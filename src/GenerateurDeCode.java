import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.text.rtf.RTFEditorKit;

import org.antlr.runtime.tree.Tree;

import enumeration.Mode;
import enumeration.Nature;
import enumeration.Type;


public class GenerateurDeCode {
	public static String code_asm = "";
	static final int tailleEntier = 2;
	static final int tailleChar = 2;
	static final int taillePointeur = 2;
	static Map<String, Method> fonctions; // Pour appeler des fonctions dynamiquement lors du parsing selon le noeud parsé, par exemple fonctions.get("+") contiendra la fonction à appeler pour générer un noeud "+"
	static int nombreRegistres = 10; // Nombre de registres dispos
	static Registres registres = new Registres(nombreRegistres, 1); // Pour gérer les registres dispos lors de l'evaluation d'une expression
	static Etiquettes etiquettes = new Etiquettes(); // Pour gérer les étiquettes (dans le if)

	public static void lancer(Tree ast) {
		code_asm += ajouterHeader();
		code_asm += rootToken(ast);
		code_asm += systemIO();
	}

	public static String ajouterHeader()
	{
		String res = "";
		res = "EXIT_EXC   EQU   64             // n° d'exception de EXIT           (testé)\n"
				+ "READ_EXC   EQU   65             // n° d'exception de READ  (1 ligne)(testé)\n"
				+ "WRITE_EXC  EQU   66             // n° d'exception de WRITE (1 ligne)(testé)\n"
				+ "STACK_ADRS EQU   0x1000         // base de pile en 1000h            (par exemple)\n"
				+ "LOAD_ADRS  EQU   0xF000         // adresse de chargement            (par exemple; >= STACK_ADRS)\n"
				+ "NIL        EQU   0              // fin de liste de chaînage des frames\n"
				+ "\n"
				+ "// ces alias permettront de changer les réels registres utilisés\n"
				+ "SP         EQU   R15            // alias pour R15, pointeur de pile\n"
				+ "WR         EQU   R14            // Work Register\n"
				+ "BP         EQU   R13            // frame Base Pointer (pointeur d'environnement)\n"
				+ "\n"
				+ "ORG   LOAD_ADRS      // adresse de chargement\n"
				+ "START main_          // adresse de démarrage\n\n";
		return res;
	}

	public static String rootToken(Tree t)
	{
		initMapFonctions();
		String s = "";
		if(t.getText()!=null&&t.getText().equals("MAIN")){
			s += fonctToken(t);
		}
		else{
			for (int i = 0; i < t.getChildCount(); i++)
			{
				if (t.getChild(i).toString().equals("FONCT"))
				{
					s += fonctToken(t.getChild(i));
				}
				else if (t.getChild(i).toString().equals("PROC"))
				{
					s += procToken(t.getChild(i));
				}
				else if (t.getChild(i).toString().equals("MAIN"))
				{
					s += fonctToken(t.getChild(i));
				}
			}
		}
		return s;
	}

	// Pour initialiser le "tableau" de fonctions
	private static void initMapFonctions()
	{
		fonctions = new HashMap<String, Method>();
		try
		{
			Class[] params = new Class[2];
			params[0] = Tree.class;
			params[1] = Object.class;
			fonctions.put("AFFECT", GenerateurDeCode.class.getMethod("affectToken",params));
			fonctions.put("DECL", GenerateurDeCode.class.getMethod("declToken",params));
			fonctions.put("+", GenerateurDeCode.class.getMethod("genererExpression",params));
			fonctions.put("-", GenerateurDeCode.class.getMethod("genererExpression",params));
			fonctions.put("*", GenerateurDeCode.class.getMethod("genererExpression",params));
			fonctions.put("/", GenerateurDeCode.class.getMethod("genererExpression",params));
			fonctions.put("return", GenerateurDeCode.class.getMethod("retournerResultat", params));
			fonctions.put("CALL", GenerateurDeCode.class.getMethod("genererAppelFonctionProcedure", params));
			fonctions.put("IF", GenerateurDeCode.class.getMethod("genererIf", params));
			fonctions.put("==", GenerateurDeCode.class.getMethod("genererCondition", params));
			fonctions.put("!=", GenerateurDeCode.class.getMethod("genererCondition", params));
			fonctions.put("<", GenerateurDeCode.class.getMethod("genererCondition", params));
			fonctions.put("<=", GenerateurDeCode.class.getMethod("genererCondition", params));
			fonctions.put(">", GenerateurDeCode.class.getMethod("genererCondition", params));
			fonctions.put(">=", GenerateurDeCode.class.getMethod("genererCondition", params));
			fonctions.put("&&", GenerateurDeCode.class.getMethod("genererConditionAnd", params));
			fonctions.put("||", GenerateurDeCode.class.getMethod("genererConditionOr", params));
			fonctions.put("!", GenerateurDeCode.class.getMethod("genererConditionNot", params));
			fonctions.put("WHILE", GenerateurDeCode.class.getMethod("genererWhile", params));
			fonctions.put("FOR", GenerateurDeCode.class.getMethod("genererFor", params));
		}
		catch (NoSuchMethodException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SecurityException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	private static String mainToken(Tree child)
	{
		// TODO Auto-generated method stub
		return "main";
	}

	private static String procToken(Tree child)
	{
		String code = "";
		String name = child.getChild(0).getText();
		code += name + "_ "; // label of procedure
		code += "// PROCEDURE\n";

		int tailleVarsLocales = 0;
		Tree bloc = child.getChild(2);

		tailleVarsLocales = Compilateur.liste_tds.get(name).getTailleVariablesLocales();
		
		code += "\tLDQ " + tailleVarsLocales + ", R1 // R1 = taille données locales\n"
				+ "\tADQ -2, SP     // décrémente le pointeur de pile SP\n"
				+ "\tSTW BP, (SP)   // sauvegarde le contenu du registre BP sur la pile\n"
				+ "\tLDW BP, SP     // charge contenu SP ds BP qui pointe sur sa sauvegarde\n"
				+ "\tSUB SP, R1, SP // réserve R1 octets sur la pile\n\n";

		// On génère le code assembleur de chaque instruction en appelant la fonction correspondante au noeud parsé
		for (int i = 0; i < bloc.getChildCount(); i++)
		{
			if (fonctions.containsKey(bloc.getChild(i).getText()))
			{
				ArrayList<Object> liste = new ArrayList<Object>();
				liste.add(name);
				if(bloc.getChild(i).getText().equals("return")) liste.add(new Integer(0)); else liste.add(new Integer(1));
				code+=appelerFonctionDansMap(bloc.getChild(i).getText(), bloc.getChild(i), liste);
			}
		}

		// On dépile
		code += "\tLDW SP, BP    // charge SP avec contenu de BP: abandon infos locales\n" 
				+ "\tLDW BP, (SP)  // charge BP avec ancien BP\n"
				+ "\tADQ 2, SP     // ancien BP supprimé de la pile\n\n";
		
		// On fait le RTS
		code += "\tLDW WR, (SP)  // charge WR avec l'adresse de retour\n"
				+ "\tADQ 2, SP     // incrémente le pointeur de pile SP\n"
				+ "\tJEA (WR)      // saute à l'instruction d'adresse absolue dans WR\n\n";


		return code;
	}

	private static String fonctToken(Tree child)
	{
		String code = "";
		String name = child.getChild(0).getText().equals("void") || child.getChild(0).getText().equals("int") ? "main" : child.getChild(0).getText();
		code += name + "_ "; // label of fonction
		code += name.equals("main") ? "// MAIN\n" : "// FONCTION\n";

		int tailleVarsLocales = 0;
		Tree bloc = name.equals("main") ? child.getChild(1) : child.getChild(3);
		
		if (name.equals("main"))
			code += "\tLDW SP, #STACK_ADRS             // charge SP avec STACK_ADRS\n"
					+ "\tLDQ NIL, BP                     // BP = NIL\n\n"
					+ "\tADQ -" + Compilateur.liste_tds.get("#global#").getTailleVariablesLocales() + ", SP	// place pour variables globales\n\n";
		
		tailleVarsLocales = Compilateur.liste_tds.get(name).getTailleVariablesLocales();
		
		// Réservation pour variables locales
		code += "\tLDQ " + tailleVarsLocales + ", R1 // R1 = taille données locales\n"
				+ "\tADQ -2, SP     // décrémente le pointeur de pile SP\n"
				+ "\tSTW BP, (SP)   // sauvegarde le contenu du registre BP sur la pile\n"
				+ "\tLDW BP, SP     // charge contenu SP ds BP qui pointe sur sa sauvegarde\n"
				+ "\tSUB SP, R1, SP // réserve R1 octets sur la pile\n\n";
		
		// On s'occupe ici des variables globales initialisés
		Tree root = child.getParent();
		if(root != null)
		{
			for (int i = 0; i < root.getChildCount(); i++)
			{
				if (root.getChild(i).toString().equals("DECL"))
				{
					ArrayList<Object> liste = new ArrayList<Object>();
					liste.add("#global#");
					liste.add(new Integer(1));
					code += declToken(root.getChild(i), liste);
				}
			}
		}

		// On génère le code assembleur de chaque instruction en appelant la fonction correspondante au noeud parsé
		for (int i = 0; i < bloc.getChildCount(); i++)
		{
			if (fonctions.containsKey(bloc.getChild(i).getText()))
			{
				ArrayList<Object> liste = new ArrayList<Object>();
				liste.add(name);
				if(bloc.getChild(i).getText().equals("return")) liste.add(new Integer(0)); else liste.add(new Integer(1));
				code+=appelerFonctionDansMap(bloc.getChild(i).getText(), bloc.getChild(i), liste);
			}
		}

		// On dépile
		code += "\tLDW SP, BP    // charge SP avec contenu de BP: abandon infos locales\n" 
				+ "\tLDW BP, (SP)  // charge BP avec ancien BP\n"
				+ "\tADQ 2, SP     // ancien BP supprimé de la pile\n\n";

		if (!name.equals("main"))
		{
			// On fait le RTS
			code += "\tLDW WR, (SP)  // charge WR avec l'adresse de retour\n"
					+ "\tADQ 2, SP     // incrémente le pointeur de pile SP\n"
					+ "\tJEA (WR)      // saute à l'instruction d'adresse absolue dans WR\n\n";
		}
		else
		{
			// Pour arrêtre l'exec du main
			code += "\tLDW WR, #EXIT_EXC // WR = EXIT_EXC = n° exception de EXIT\n"
					+ "\tTRP WR            // exécute la trappe logicielle \"EXIT\"\n\n";

			// Pour se brancher au début du main
			code += "\tLDW WR, #main_    // WR = main_ = adresse du début de main\n"
					+ "\tJEA (WR)          // saute à l'instruction dont l'adresse est dans WR\n\n";

		}

		return code;
	}

	// Permet d'appler la fonction correspondante à un noeud particulier
	private static String appelerFonctionDansMap(String fonction, Tree child, Object params)
	{
		String res = null;
		try
		{
			Object[]args = new Object[2];
			args[0] = child;
			args[1] = params;
			res = (String) fonctions.get(fonction).invoke(null, args);
		}
		catch (IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IllegalArgumentException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (InvocationTargetException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	// Génération de code pour une délaration suivie d'une affectation (int a = 4;)
	public static String declToken(Tree child, Object params)
	{
		String res = "";
		if(fonctions.containsKey(child.getChild(1).getText()))
		{
			res += appelerFonctionDansMap(child.getChild(1).getText(), child.getChild(1), params);
		}
		
		return res;
	}

	// Génération de code pour une affectation
	public static String affectToken(Tree child, Object params)
	{
		String res = "";
		String bloc = (String) ((ArrayList<Object>) params).get(0);
		Tree arbre = child.getChild(0);
		int registreVoulu = (Integer) ((ArrayList<Object>) params).get(1);
		registres.prendreRegistre(1);
		
		// Si déclaration et affectation d'un tableau avec des valeurs
		if(arbre.getChild(0).getText().equals("TABLEAU") && arbre.getChild(1).getText().equals("PARAM"))
		{
			int nbVals = arbre.getChild(1).getChildCount();
			for(int i=0; i<nbVals; i++)
			{
				String nomTableau = arbre.getChild(0).getChild(0).getText();
				//res += "\tLDW R1, #" + arbre.getChild(1).getChild(i).getText() + "	// R1 = " + arbre.getChild(1).getChild(i).getText() + "\n";
				String texte=arbre.getChild(1).getChild(i).getText();
				if(isInteger(texte))
				{
					res += "\tLDW R1, #" + Integer.valueOf(texte) + "	// R1 = " + texte + "\n\n";
				}
				else // variable, pointeur ou appel de fonction
				{
					// caractere
					if(texte.equals("CARACTERE"))
					{
						char c = arbre.getChild(1).getChild(i).getChild(0).getText().charAt(0);
						int code = String.valueOf(c).codePointAt(0)+256;
						if(arbre.getChild(1).getChild(i).getChild(0).getText().equals("\\n")) code = 266;
						else if(arbre.getChild(1).getChild(i).getChild(0).getText().equals("\\t")) code = 265;
						else if(arbre.getChild(1).getChild(i).getChild(0).getText().equals("\\0")) code = 0;
						res += "\tLDW R1, #" + code + "	// R1 = '" + c + "'\n\n";
					}
				}
				boolean locale = varInTDS(nomTableau, bloc) && !bloc.equals("#global#");
				boolean globale = varInTDS(nomTableau, "#global#");
				int deplacement = 0;
	
				if(locale)
				{
					deplacement = Compilateur.liste_tds.get(bloc).getTds().get(nomTableau).getAdresse();
					if(deplacement < 0)
						deplacement = deplacement - 2 * i;
					else
						deplacement = deplacement + 2 * i;
					res += "\tLDW WR, BP	// WR = BP\n";
				}
				else if(globale)
				{
					deplacement = Compilateur.liste_tds.get("#global#").getTds().get(nomTableau).getAdresse();
					deplacement = deplacement - 2 * i;
					res += "\tLDW WR, #STACK_ADRS	// WR = #STACK_ADRS\n";;
				}
				res += "\tADQ " + deplacement + ", WR	// WR pointe sur " + nomTableau + "[" + i + "]\n"
						+"\tSTW R1, (WR)	// " + nomTableau + "[" + i + "] = R1\n\n";
			}
		}
		else
		{
			if(fonctions.containsKey(arbre.getChild(1).getText()))
			{
				// Calcul des opérandes et du résultat
				res += appelerFonctionDansMap(arbre.getChild(1).getText(), arbre.getChild(1), params);
			}
			else
			{
				res += coderExpression(arbre.getChild(1), registreVoulu, bloc);
			}
	
			// Stockage du résultat dans la pile
			Tree expression = child.getChild(0).getChild(0);
			String variable = arbre.getChild(0).getText();
			
			// Tableau
			if(variable.equals("TABLEAU"))
			{
				String nomTableau = expression.getChild(0).getText();
				
				boolean locale = varInTDS(nomTableau, bloc) && !bloc.equals("#global#");
				boolean globale = varInTDS(nomTableau, "#global#");
				int deplacement = 0;
				
				// On réserve un registre supplémentaire
				int registre = registres.getRegistreLibre();
				registres.prendreRegistre(registre);

				// On choppe l'indice qu'on met dans registre
				res += coderExpression(expression.getChild(1).getChild(0), registre, bloc);
				
				if(locale)
				{
					deplacement = Compilateur.liste_tds.get(bloc).getTds().get(nomTableau).getAdresse();
					res += "\tLDW WR, BP	// WR = BP\n";
				}
				else if(globale)
				{
					deplacement = Compilateur.liste_tds.get("#global#").getTds().get(nomTableau).getAdresse();
					res += "\tLDW WR, #STACK_ADRS	// WR = #STACK_ADRS\n";
				}
				
				// On réserve un registre supplémentaire
				int registreTmp = registres.getRegistreLibre();
				registres.prendreRegistre(registreTmp);
				if(deplacement < 0)
				{
					res += "\tLDW R" + registreTmp + ", #-2\n";
				}
				else
				{
					res += "\tLDW R" + registreTmp + ", #2\n";
				}
				res += "\tMUL R" + registre + ", R" + registreTmp + ", R" + registre + "\n";
				res += "\tADQ " + deplacement + ", WR\n";
				res += "\tADD R" + registre + ", WR, WR\n";
				res += "\tSTW R" + registreVoulu + ", (WR)\n";
				registres.libererRegiste(registre);
				registres.libererRegiste(registreTmp);
				
			}
			// pointeur
			else if(variable.equals("PTR"))
			{
				variable = expression.getChild(0).getText();
				if(!variable.equals("PTR"))
				{
					boolean locale = varInTDS(variable, bloc) && !bloc.equals("#global#");
					boolean globale = varInTDS(variable, "#global#");
					int deplacement = 0;
	
					if(locale)
					{
						deplacement = Compilateur.liste_tds.get(bloc).getTds().get(variable).getAdresse();
						res += "\tLDW WR, BP	// WR = BP\n"
								+ "\tADQ " + deplacement + ", WR	// WR pointe sur " + variable + "\n";
					}
					else if(globale)
					{
						deplacement = Compilateur.liste_tds.get("#global#").getTds().get(variable).getAdresse();
						res += "\tLDW WR, #STACK_ADRS	// WR = #STACK_ADRS\n"
								+ "\tADQ " + deplacement + ", WR	// WR pointe sur " + variable + "\n";
					}
					res += "\tLDW WR, (WR)	// WR = (WR) (Adresse)\n"
							+"\tSTW R1, (WR)	// *" + variable + " = R1\n\n";
				}
				else
				{
					variable = expression.getChild(0).getChild(0).getText();
					boolean locale = varInTDS(variable, bloc) && !bloc.equals("#global#");
					boolean globale = varInTDS(variable, "#global#");
					int deplacement = 0;
	
					if(locale)
					{
						deplacement = Compilateur.liste_tds.get(bloc).getTds().get(variable).getAdresse();
						res += "\tLDW WR, BP	// WR = BP\n";
					}
					else if(globale)
					{
						deplacement = Compilateur.liste_tds.get("#global#").getTds().get(variable).getAdresse();
						res += "\tLDW WR, #STACK_ADRS	// WR = #STACK_ADRS\n";
					}
					res += "\tADQ " + deplacement + ", WR	// WR pointe sur " + variable + "\n"
							+"\tLDW WR, (WR)	// WR = (WR) (Adresse)\n"
							+"\tLDW WR, (WR)	// WR = (WR) (Adresse)\n"
							+"\tSTW R1, (WR)	// **" + variable + " = R1\n\n";
				}
				
			}
			// variable
			else
			{
				boolean locale = varInTDS(variable, bloc) && !bloc.equals("#global#");
				boolean globale = varInTDS(variable, "#global#");
				int deplacement = 0;
	
				if(locale)
				{
					deplacement = Compilateur.liste_tds.get(bloc).getTds().get(variable).getAdresse();
					res += "\tLDW	WR, BP	// WR = BP\n";
				}
				else if(globale)
				{
					deplacement = Compilateur.liste_tds.get("#global#").getTds().get(variable).getAdresse();
					res += "\tLDW WR, #STACK_ADRS	// WR = #STACK_ADRS\n";
				}
				res += "\tADQ " + deplacement + ", WR	// WR pointe sur " + variable + "\n"
						+ "\tSTW R1, (WR)\n\n";
			}
		}
			
		return res;
	}

	public static String declToken(Tree t, String bloc)
	{
		String s = "";
		for (int i = 0; i < t.getChildCount(); i++)
		{
			if (t.getChild(i).toString().equals("int"))
			{

			}
			else if (t.getChild(i).toString().equals("char"))
			{

			}
			else if (t.getChild(i).toString().equals("PTR"))
			{// cas de la déclaration de pointeur

			}
		}
		return s;
	}

	// Pour savoir si une string est un entier
	public static boolean isInteger(String s)
	{
		try
		{
			Integer.parseInt(s);
			return true;
		}
		catch (NumberFormatException e)
		{
			return false;
		}
	}

	public static boolean varInTDS(String var, String TDS)
	{
		return Compilateur.liste_tds.get(TDS).getTds().containsKey(var);
	}

	// Génération de code pour l'évaluation d'une expression
	public static String genererExpression(Tree t, Object params)
	{
		// Voir algo ici page 45 : http://www-verimag.imag.fr/~jhenry/teaching/c7_6pages.pdf
		// Note : On fait une eval gauche droite seulement ! Deja pas mal...
		boolean sauvegardeRegistre = false;
		String res = "";

		Tree e1 = t.getChild(0);
		Tree e2 = t.getChild(1);

		String bloc = (String) ((ArrayList<Object>) params).get(0);
		int registreVoulu = (Integer) ((ArrayList<Object>) params).get(1);

		// Eval gauche dans registreVoulu
		if (fonctions.containsKey(e1.getText()))
		{
			res += genererExpression(e1, params);
		}
		else
		{
			res += coderExpression(e1, registreVoulu, bloc);
		}

		// Eval droite dans prochain registre dispo sinon mettre dans pile (à faire plus tard)
		int prochainRegistreDispo = registres.resteUnRegistre() ? registres.getRegistreLibre() : -1;
		if(prochainRegistreDispo != -1)
			registres.prendreRegistre(prochainRegistreDispo);
		else
		{
			boolean fin = false;
			int i=1;
			sauvegardeRegistre = true;
			while(!fin)
			{
				if(i!=registreVoulu)
				{
					prochainRegistreDispo = i;
					// Sauvegarde registre dans la pile
					res += "\tADQ -2, SP	// décrémente le pointeur de pile SP\n"
							+ "\tSTW R" + prochainRegistreDispo + ", (SP)	// sauvegarde du regsitre R" + prochainRegistreDispo + " car plus assez de registres dispos\n";
					fin = true;
				}
				else
				{
					i++;
				}
			}
		}
		if(fonctions.containsKey(e2.getText()))
		{
			ArrayList<Object> liste = new ArrayList<Object>();
			liste.add(bloc);
			liste.add(prochainRegistreDispo);

			res += genererExpression(e2, liste);
		}
		else
		{
			res += coderExpression(e2, prochainRegistreDispo, bloc);
		}

		// Calcul du résultat
		String op = null;
		if (t.getText().equals("+"))
			op = "ADD";
		else if (t.getText().equals("-"))
			op = "SUB";
		else if (t.getText().equals("*"))
			op = "MUL";
		else if (t.getText().equals("/"))
			op = "DIV";
		if(op!=null){
			res += "\t" + op + " R" + registreVoulu + ", R" + prochainRegistreDispo + ", R" + registreVoulu + "\n\n";

			// Libération du registre pour l'opérande de droite
			if(!sauvegardeRegistre)
				registres.libererRegiste(prochainRegistreDispo);
			// Dépilage du regsitre sauvegardé
			else
			{
				res += "\tLDW R" + prochainRegistreDispo + ", (SP)	// on restaure regsitre R" + prochainRegistreDispo + " précédemment sauvegardé\n"
						+ "\tADQ 2, SP	// incrémente le pointeur de pile SP\n";
			}
		}
		
		return res;
	}

	public static String genererAppelFonctionProcedure(Tree t, Object params)
	{
		String res = "";
		String nomFonction = t.getChild(0).getText();
		Nature nature = Nature.FONCTION;
		if(!nomFonction.equals("print")&&!nomFonction.equals("exit")&&!nomFonction.equals("printi")&&!nomFonction.equals("printc")&&!nomFonction.equals("itoa")){
			nature = Compilateur.liste_tds.get("#global#").getTds().get(nomFonction).getNature();
		}
		String bloc = (String) ((ArrayList<Object>) params).get(0);
		int registre = (Integer) ((ArrayList<Object>) params).get(1);
		int nombreParametres = t.getChild(1).getChildCount();

		if (nombreParametres > 0)
		{
			for (int i=nombreParametres -1 ; i>=0; i--)
			{
				String parametre = t.getChild(1).getChild(i).getText();
				if (fonctions.containsKey(parametre))
				{
					res += genererExpression(t, params);
				}
				else
				{
					res += coderExpression(t.getChild(1).getChild(i), registre, bloc);
				}

				// On empile
				res += "\tADQ -2, SP     // décrémente le pointeur de pile SP\n"
						+ "\tSTW R" + registre + ", (SP)   // sauvegarde le contenu du registre R1 sur la pile\n\n";
			}
		}

		Symbole symb = null;
		if(nomFonction.equals("print")){
			String param = t.getChild(1).getChild(0).getText();
			for (Entry<String, TableSymboles> entry : Compilateur.liste_tds.entrySet()){
				String key = entry.getKey();
				for (Entry<String, Symbole> entry1 : Compilateur.liste_tds.get(key).getTds().entrySet()){
					String key1 = entry1.getKey();
					Symbole value1 = entry1.getValue();
					if(param.equals(key1)){
						symb=value1;
					}
				}
			}
			int reg = registres.getRegistreLibre();
			int reg1 = registres.getRegistreLibre();
			res += "\tLDW R"+reg1+", BP\n"
				+ "\tADQ "+symb.getAdresse()+", R"+reg1+"\n"
				+ "\tADQ -"+symb.getTaille()+", R"+reg1+"\n";
				for(int k=0;k<symb.getTaille();k+=2){
					res +="\tADQ 2, R"+reg1+"\n"
						+ "\tLDW R"+reg+", (R"+reg1+")\n"
						+ "\tSTW R"+reg+", -(SP)\n";
				}
				res += "\tLDW R"+reg+", SP\n"
						+"\tSTW R"+reg+", -(SP)\n";
			registres.libererRegiste(reg);
			registres.libererRegiste(reg1);
		}
		
		// Appel de la fonction
		res += "\tLDW R" + registre + ", #" + nomFonction +"_\n\n";
		res += "\tMPC WR        // charge le contenu du PC dans WR\n"
				+ "\tADQ 8, WR     // ajoute 8 à WR: WR contient l'adresse de retour\n"
				+ "\tADQ -2, SP    // décrémente le pointeur de pile SP\n"
				+ "\tSTW WR, (SP)  // sauvegarde l'adresse de retour sur le sommet de pile\n"
				+ "\tJEA (R1)      // saute à l'instruction d'adresse absolue dans R1\n\n";

		if(nomFonction.equals("print")){
			res += "\tADQ " + (symb.getTaille()+2) + ", SP   // SP + " + nombreParametres + " * 2 -> SP\n\n";
		}
		// Nettoyage de la pile par l'appelant
		res += "\tADQ " + nombreParametres + "*2, SP   // SP + " + nombreParametres + " * 2 -> SP\n\n";

		return res;
	}

	public static String coderExpression(Tree expression, int registre, String bloc)
	{
		String res = "";
		String texte = expression.getText();

		if(isInteger(texte))
		{
			res += "\tLDW R" + registre + ", #" + Integer.valueOf(texte) + "	// R" + registre + " = " + texte + "\n\n";
		}
		else // variable, pointeur ou appel de fonction
		{
			// caractere
			if(texte.equals("CARACTERE"))
			{
				char c = expression.getChild(0).getText().charAt(0);
				int code = String.valueOf(c).codePointAt(0)+256;
				if(expression.getChild(0).getText().equals("\\n")) code = 266;
				else if(expression.getChild(0).getText().equals("\\t")) code = 265;
				else if(expression.getChild(0).getText().equals("\\0")) code = 0;
				res += "\tLDW R" + registre + ", #" + code + "	// R" + registre + " = '" + c + "'\n\n";
			}
			else if (texte.equals("PARAM"))
			{
				if(expression.getChild(0).getText().equals("-")){
					res += "\tLDW R" + registre + ", #-" + Integer.valueOf(expression.getChild(0).getChild(0).getText()) + "	// R" + registre + " = -" + Integer.valueOf(expression.getChild(0).getChild(0).getText()) + "\n\n";
				}
			}
			// tableau
			else if(texte.equals("TABLEAU"))
			{
				String nomTableau = expression.getChild(0).getText();
					
				boolean locale = varInTDS(nomTableau, bloc) && !bloc.equals("#global#");
				boolean globale = varInTDS(nomTableau, "#global#");
				int deplacement = 0;

				// On choppe l'indice qu'on met dans registre
				res += coderExpression(expression.getChild(1).getChild(0), registre, bloc);
				
				if(locale)
				{
					deplacement = Compilateur.liste_tds.get(bloc).getTds().get(nomTableau).getAdresse();
					res += "\tLDW WR, BP	// WR = BP\n";
				}
				else if(globale)
				{
					deplacement = Compilateur.liste_tds.get("#global#").getTds().get(nomTableau).getAdresse();
					res += "\tLDW WR, #STACK_ADRS	// WR = #STACK_ADRS\n";
				}
				
				// On réserve un registre supplémentaire
				int registreTmp = registres.getRegistreLibre();
				registres.prendreRegistre(registreTmp);
				if(deplacement < 0)
				{
					res += "\tLDW R" + registreTmp + ", #-2\n";
				}
				else
				{
					res += "\tLDW R" + registreTmp + ", #2\n";
				}
				res += "\tMUL R" + registre + ", R" + registreTmp + ", R" + registre + "\n";
				res += "\tADQ " + deplacement + ", WR\n";
				res += "\tADD R" + registre + ", WR, WR\n";
				res += "\tLDW R" + registre + ", (WR)\n";
				registres.libererRegiste(registreTmp);
			}
			// adresse
			else if(texte.equals("ADDRESS"))
			{
				texte = expression.getChild(0).getText();
				boolean locale = varInTDS(texte, bloc) && !bloc.equals("#global#");
				boolean globale = varInTDS(texte, "#global#");
				int deplacement = 0;

				if(locale)
				{
					deplacement = Compilateur.liste_tds.get(bloc).getTds().get(texte).getAdresse();
					res += "\tLDW WR, BP	// WR = BP\n";
				}
				else if(globale)
				{
					deplacement = Compilateur.liste_tds.get("#global#").getTds().get(texte).getAdresse();
					res += "\tLDW WR, #STACK_ADRS	// WR = #STACK_ADRS\n";
				}
				res += "\tADQ " + deplacement + ", WR	// WR pointe sur " + texte + "\n"
						+"\tLDW R" + registre + ", WR	// R" + registre + " = &" + texte + "\n\n";
			}
			// pointeur
			else if(texte.equals("PTR"))
			{
				texte = expression.getChild(0).getText();
				if(!texte.equals("PTR"))
				{
					boolean locale = varInTDS(texte, bloc) && !bloc.equals("#global#");
					boolean globale = varInTDS(texte, "#global#");
					int deplacement = 0;
	
					if(locale)
					{
						deplacement = Compilateur.liste_tds.get(bloc).getTds().get(texte).getAdresse();
						res += "\tLDW WR, BP	// WR = BP\n";
					}
					else if(globale)
					{
						deplacement = Compilateur.liste_tds.get("#global#").getTds().get(texte).getAdresse();
						res += "\tLDW WR, #STACK_ADRS	// WR = #STACK_ADRS\n";
					}
					res += "\tADQ " + deplacement + ", WR	// WR pointe sur " + texte + "\n"
							+"\tLDW R" + registre + ", (WR)	// R" + registre + " = " + texte + " (Adresse)\n"
							+"\tLDW R" + registre + ", (R" + registre + ")	// R" + registre + " = *" + texte + "\n\n";
				}
				else
				{
					texte = expression.getChild(0).getChild(0).getText();
					boolean locale = varInTDS(texte, bloc) && !bloc.equals("#global#");
					boolean globale = varInTDS(texte, "#global#");
					int deplacement = 0;
	
					if(locale)
					{
						deplacement = Compilateur.liste_tds.get(bloc).getTds().get(texte).getAdresse();
						res += "\tLDW WR, BP	// WR = BP\n";
					}
					else if(globale)
					{
						deplacement = Compilateur.liste_tds.get("#global#").getTds().get(texte).getAdresse();
						res += "\tLDW WR, #STACK_ADRS	// WR = #STACK_ADRS\n";
					}
					res += "\tADQ " + deplacement + ", WR	// WR pointe sur " + texte + "\n"
							+"\tLDW R" + registre + ", (WR)	// R" + registre + " = " + texte + " (Adresse)\n"
							+"\tLDW R" + registre + ", (R" + registre + ")	// R" + registre + " = *" + texte + "\n"
							+"\tLDW R" + registre + ", (R" + registre + ")	// R" + registre + " = **" + texte + "\n\n";
				}
				
			}
			// variable
			else
			{
				boolean locale = varInTDS(texte, bloc);
				boolean globale = varInTDS(texte, "#global#");
				int deplacement = 0;

				if(locale)
				{
					deplacement = Compilateur.liste_tds.get(bloc).getTds().get(texte).getAdresse();
					res += "\tLDW WR, BP	// WR = BP\n";
				}
				else if(globale)
				{
					deplacement = Compilateur.liste_tds.get("#global#").getTds().get(texte).getAdresse();
					res += "\tLDW WR, #STACK_ADRS	// WR = #STACK_ADRS\n";
				}
				res += "\tADQ " + deplacement + ", WR	// WR pointe sur " + texte + "\n"
						+"\tLDW R" + registre + ", (WR)	// R" + registre + " = " + texte + "\n\n";
			}
		}

		return res;
	}

	public static String retournerResultat(Tree t, Object params)
	{
		String res = "";

		Tree valeur = t.getChild(0);
		String bloc = (String) ((ArrayList<Object>) params).get(0);
		String texte_valeur = valeur.getText();
		int registreVoulu = (Integer) ((ArrayList<Object>) params).get(1);
		if (fonctions.containsKey(texte_valeur))
		{
			res += genererExpression(valeur, params);
		}
		else
		{
			res += coderExpression(valeur, registreVoulu, bloc);
		}

		return res;
	}
	
	public static String genererConditionAnd(Tree condition, Object params)
	{
		String res = "";
		Tree op1 = condition.getChild(0);
		Tree op2 = condition.getChild(1);
		String bloc = (String) ((ArrayList<Object>) params).get(0);
		int registreVoulu = (Integer) ((ArrayList<Object>) params).get(1);
		boolean etat_condition = (Boolean) ((ArrayList<Object>) params).get(2);
		String etiquette = (String) ((ArrayList<Object>) params).get(3);
		
		if(etat_condition)
		{
			String e_fin = etiquettes.getEtiquetteSuivante();
			ArrayList<Object> liste = new ArrayList<Object>();
			liste.add(bloc);
			liste.add(registreVoulu);
			liste.add(false);
			liste.add(e_fin);
			res += genererCondition(op1, liste);
			res += genererCondition(op2, params);
			// Écriture de l'étiquette
			res += e_fin + "_	// Etiquette pour analyse paresseuse de AND\n";
		}
		else
		{
			res += genererCondition(op1, params);
			res += genererCondition(op2, params);
		}
			
		return res;
	}
	
	public static String genererConditionOr(Tree condition, Object params)
	{
		String res = "";
		Tree op1 = condition.getChild(0);
		Tree op2 = condition.getChild(1);
		String bloc = (String) ((ArrayList<Object>) params).get(0);
		int registreVoulu = (Integer) ((ArrayList<Object>) params).get(1);
		boolean etat_condition = (Boolean) ((ArrayList<Object>) params).get(2);
		String etiquette = (String) ((ArrayList<Object>) params).get(3);
		
		if(!etat_condition)
		{
			String e_fin = etiquettes.getEtiquetteSuivante();
			ArrayList<Object> liste = new ArrayList<Object>();
			liste.add(bloc);
			liste.add(registreVoulu);
			liste.add(true);
			liste.add(e_fin);
			res += genererCondition(op1, liste);
			res += genererCondition(op2, params);
			// Écriture de l'étiquette
			res += e_fin + "_	// Etiquette pour analyse paresseuse de OR\n";
		}
		else
		{
			res += genererCondition(op1, params);
			res += genererCondition(op2, params);
		}
			
		return res;
	}
	
	public static String genererConditionNot(Tree condition, Object params)
	{
		return appelerFonctionDansMap(condition.getChild(0).getText(), condition.getChild(0), params);
	}
	
	public static String genererCondition(Tree condition, Object params)
	{
		String res = "";
		Tree op1 = condition.getChild(0);
		Tree op2 = condition.getChild(1);
		String bloc = (String) ((ArrayList<Object>) params).get(0);
		registres.libererRegiste((Integer) ((ArrayList<Object>) params).get(1));
		int registreVoulu = registres.getRegistreLibre();
		boolean etat_condition = (Boolean) ((ArrayList<Object>) params).get(2);
		String etiquette = (String) ((ArrayList<Object>) params).get(3);

		// Générer l'opérande gauche de la condition
		if(fonctions.containsKey(op1.getText()))
		{
			res += appelerFonctionDansMap(op1.getText(), op1, params);
		}
		else
		{
			res += coderExpression(op1, registreVoulu, bloc);
		}
		
		// Générer l'opérande droite de la condition
		int prochainRegistre = registres.getRegistreLibre();
		if(prochainRegistre == -1)
			new Exception("Plus de registres ! :(");
		if(fonctions.containsKey(op2.getText()))
		{
			ArrayList<Object> liste = new ArrayList<Object>();
			liste.add(bloc);
			liste.add(prochainRegistre);
			liste.add(etat_condition);
			liste.add(etiquette);
			res += appelerFonctionDansMap(op2.getText(), op2, liste);
		}
		else
		{
			res += coderExpression(op2, prochainRegistre, bloc);
		}
		
		String op = condition.getText();
		if(etat_condition == false)
		{
			if(op.equals("=="))
			{
				res += "\tCMP R" + registreVoulu + ", R" + prochainRegistre + " // Test différence\n";
				res += "\tJNE #"+ etiquette + "_-$-2 // Si différence saut à " + etiquette + " sinon exécution de la suite\n";	
			}
			else if(op.equals("!="))
			{
				res += "\tCMP R" + registreVoulu + ", R" + prochainRegistre + " // Test égalité\n";
				res += "\tJEQ #"+ etiquette + "_-$-2 // Si égalité saut à " + etiquette + " sinon exécution de la suite\n";	
			}
			else if(op.equals("<"))
			{
				res += "\tCMP R" + registreVoulu + ", R" + prochainRegistre + " // Test supérieur ou égal\n";
				res += "\tJGE #"+ etiquette + "_-$-2 // Si supérieur ou égal saut à " + etiquette + " sinon exécution de la suite\n";	
			}
			else if(op.equals("<="))
			{
				res += "\tCMP R" + registreVoulu + ", R" + prochainRegistre + " // Test supérieur strict\n";
				res += "\tJGT #"+ etiquette + "_-$-2 // Si supérieur strict saut à " + etiquette + " sinon exécution de la suite\n";
			}
			else if(op.equals(">"))
			{
				res += "\tCMP R" + registreVoulu + ", R" + prochainRegistre + " // Test inférieur ou égal\n";
				res += "\tJLE #"+ etiquette + "_-$-2 // Si inférieur ou égal saut à " + etiquette + " sinon exécution de la suite\n";
			}
			else if(op.equals(">="))
			{
				res += "\tCMP R" + registreVoulu + ", R" + prochainRegistre + " // Test inférieur strict\n";
				res += "\tJLW #"+ etiquette + "_-$-2 // Si inférieur strictl saut à " + etiquette + " sinon exécution de la suite\n";
			}
			res += "\n";
		}
		else
		{
			if(op.equals("=="))
			{
				res += "\tCMP R" + registreVoulu + ", R" + prochainRegistre + " // Test égalité\n";
				res += "\tJEQ #"+ etiquette + "_-$-2 // Si égalité saut à " + etiquette + " sinon exécution de la suite\n";	
			}
			else if(op.equals("!="))
			{
				res += "\tCMP R" + registreVoulu + ", R" + prochainRegistre + " // Test différence\n";
				res += "\tJNE #"+ etiquette + "_-$-2 // Si différence saut à " + etiquette + " sinon exécution de la suite\n";	
			}
			else if(op.equals("<"))
			{
				res += "\tCMP R" + registreVoulu + ", R" + prochainRegistre + " // Test inférieur strict\n";
				res += "\tJLW #"+ etiquette + "_-$-2 // Si inférieur strictl saut à " + etiquette + " sinon exécution de la suite\n";
			}
			else if(op.equals("<="))
			{
				res += "\tCMP R" + registreVoulu + ", R" + prochainRegistre + " // Test inférieur ou égal\n";
				res += "\tJLE #"+ etiquette + "_-$-2 // Si inférieur ou égal saut à " + etiquette + " sinon exécution de la suite\n";
			}
			else if(op.equals(">"))
			{
				res += "\tCMP R" + registreVoulu + ", R" + prochainRegistre + " // Test supérieur strict\n";
				res += "\tJGT #"+ etiquette + "_-$-2 // Si supérieur strict saut à " + etiquette + " sinon exécution de la suite\n";
			}
			else if(op.equals(">="))
			{
				res += "\tCMP R" + registreVoulu + ", R" + prochainRegistre + " // Test supérieur ou égal\n";
				res += "\tJGE #"+ etiquette + "_-$-2 // Si supérieur ou égal saut à " + etiquette + " sinon exécution de la suite\n";	
			}
			res += "\n";
		}
		registres.libererRegiste(registreVoulu);
		registres.libererRegiste(prochainRegistre);
		return res;
	}
	
	// Pour savoir si dans une condition, il faut "true" ou "false" pour se brancher à une étiquette spécifique
	public static boolean calculerEtatSaut(Tree condition)
	{
		boolean etatSaut = false;
		
		if(condition.getText().equals("!"))
			etatSaut = true;
		
		return etatSaut; 
	}
	
	public static String genererIf(Tree if_, Object params)
	{
		String res = "";
		if(if_.getChildCount() == 2)
			res += genererIfThen(if_, params);
		else
			res += genererIfThenElse(if_, params);
		return res;
	}
	
	public static String genererIfThen(Tree ifThen, Object params)
	{
		String res = "";
		boolean etat_saut = calculerEtatSaut(ifThen.getChild(0).getChild(0));
		
		// Création étiquette pour la fin du If
		String e_res = etiquettes.getEtiquetteSuivante();
		
		// Génération de la condition
		String op = ifThen.getChild(0).getChild(0).getText();
		((ArrayList<Object>) params).add(etat_saut);
		((ArrayList<Object>) params).add(e_res);
		res += appelerFonctionDansMap(op, ifThen.getChild(0).getChild(0), params);
		String nomBloc = (String) ((ArrayList<Object>) params).get(0);
		
		// Génération des instructions dans le If
		Tree bloc = ifThen.getChild(1);
		for(int i=0; i<bloc.getChildCount(); i++)
		{
			if (fonctions.containsKey(bloc.getChild(i).getText()))
			{
				ArrayList<Object> liste = new ArrayList<Object>();
				liste.add(nomBloc);
				if(bloc.getChild(i).getText().equals("return")) liste.add(new Integer(0)); else liste.add(new Integer(1));
				res += appelerFonctionDansMap(bloc.getChild(i).getText(), bloc.getChild(i), liste);
			}
		}
		
		// Écriture de l'étiquette
		res += e_res + "_	// Etiquette pour la fin du if\n\n";
		
		return res;
	}
	
	public static String genererIfThenElse(Tree ifThenElse, Object params)
	{
		String res = "";
		boolean etat_saut = calculerEtatSaut(ifThenElse.getChild(0).getChild(0));
		
		// Création étiquette pour la fin du If
		String e_res = etiquettes.getEtiquetteSuivante();
		String e_else = etiquettes.getEtiquetteSuivante();
		String op = ifThenElse.getChild(0).getChild(0).getText();
		((ArrayList<Object>) params).add(etat_saut);
		((ArrayList<Object>) params).add(e_else);
		
		// Génération de la condition
		res += appelerFonctionDansMap(op, ifThenElse.getChild(0).getChild(0), params);
		String nomBloc = (String) ((ArrayList<Object>) params).get(0);
		
		// Génération des instructions dans le If
		Tree bloc = ifThenElse.getChild(1);
		for(int i=0; i<bloc.getChildCount(); i++)
		{
			if (fonctions.containsKey(bloc.getChild(i).getText()))
			{
				ArrayList<Object> liste = new ArrayList<Object>();
				liste.add(nomBloc);
				if(bloc.getChild(i).getText().equals("return")) liste.add(new Integer(0)); else liste.add(new Integer(1));
				res += appelerFonctionDansMap(bloc.getChild(i).getText(), bloc.getChild(i), liste);
			}
		}
		
		// Écriture de l'étiquette du else
		res += "\tJMP #"+ e_res + "_-$-2 // Saut à la fin du if pour pas aller dans le else\n\n";
		
		// Saut à la fin du if
		res += e_else + "_	// Etiquette pour le else\n";
		
		// Génération des instructions dans le else
		bloc = ifThenElse.getChild(3);
		for(int i=0; i<bloc.getChildCount(); i++)
		{
			if (fonctions.containsKey(bloc.getChild(i).getText()))
			{
				ArrayList<Object> liste = new ArrayList<Object>();
				liste.add(nomBloc);
				if(bloc.getChild(i).getText().equals("return")) liste.add(new Integer(0)); else liste.add(new Integer(1));
				res += appelerFonctionDansMap(bloc.getChild(i).getText(), bloc.getChild(i), liste);
			}
		}
		
		// Écriture de l'étiquette de fin
		res += e_res + "_	// Etiquette pour la fin du if\n\n";
		
		return res;
	}
	
	public static String genererWhile(Tree while_, Object params)
	{
		String res = "";
		boolean etat_saut = calculerEtatSaut(while_.getChild(0).getChild(0));
		
		// Création étiquette pour le début de la boucle
		String e_loop = etiquettes.getEtiquetteSuivante();
		res += e_loop + "_	// Etiquette pour le debut de la boucle\n\n";
		// Création étiquette pour la fin de la boucle
		String e_res = etiquettes.getEtiquetteSuivante();
		String op = while_.getChild(0).getChild(0).getText();
		((ArrayList<Object>) params).add(etat_saut);
		((ArrayList<Object>) params).add(e_res);

		// Génération de la condition
		res += appelerFonctionDansMap(op, while_.getChild(0).getChild(0), params);
		String nomBloc = (String) ((ArrayList<Object>) params).get(0);

		// Génération des instructions dans la boucle
		Tree bloc = while_.getChild(1);
		for(int i=0; i<bloc.getChildCount(); i++)
		{
			if (fonctions.containsKey(bloc.getChild(i).getText()))
			{
				ArrayList<Object> liste = new ArrayList<Object>();
				liste.add(nomBloc);
				if(bloc.getChild(i).getText().equals("return")) liste.add(new Integer(0)); else liste.add(new Integer(1));
				res += appelerFonctionDansMap(bloc.getChild(i).getText(), bloc.getChild(i), liste);
			}
		}
		
		//on reboucle à la condition de la boucle (JMP)
		res += "\tJMP #"+ e_loop + "_-$-2 // saut au début de la boucle\n";
		// Écriture de l'étiquette
		res += e_res + "_	// Etiquette pour la fin de la boucle\n\n";

		return res;
	}
	

	public static String genererFor(Tree for_, Object params)
	{
		String res = "";
		boolean etat_saut = calculerEtatSaut(for_.getChild(0).getChild(0));
		
		// Création étiquette pour le début de la boucle
		String e_loop = etiquettes.getEtiquetteSuivante();
		
		// Création étiquette pour la fin de la boucle
		String e_res = etiquettes.getEtiquetteSuivante();
		String op = for_.getChild(0).getChild(1).getText();
		((ArrayList<Object>) params).add(false);
		((ArrayList<Object>) params).add(e_res);
		String nomBloc = (String) ((ArrayList<Object>) params).get(0);

		//Initialisation de la variable de boucle
		ArrayList<Object> l1 = new ArrayList<Object>();
		l1.add(nomBloc);
		if(for_.getChild(0).getChild(0).getText().equals("return")) l1.add(new Integer(0)); else l1.add(new Integer(1));
		res += appelerFonctionDansMap(for_.getChild(0).getChild(0).getText(), for_.getChild(0).getChild(0), l1);

		// Etiquette de la boucle for
		res += e_loop + "_	// Etiquette pour le debut de la boucle\n\n";
		
		// Génération de la condition
		res += appelerFonctionDansMap(op, for_.getChild(0).getChild(1), params);
		

		// Génération des instructions dans la boucle
		Tree bloc = for_.getChild(1);
		for(int i=0; i<bloc.getChildCount(); i++)
		{
			if (fonctions.containsKey(bloc.getChild(i).getText()))
			{
				ArrayList<Object> liste = new ArrayList<Object>();
				liste.add(nomBloc);
				if(bloc.getChild(i).getText().equals("return"))
				{
					liste.add(new Integer(0));
					res += appelerFonctionDansMap(bloc.getChild(i).getText(), bloc.getChild(i), liste);
				}
				else
				{
					registres.prendreRegistre(1);
					liste.add(new Integer(1));
					res += appelerFonctionDansMap(bloc.getChild(i).getText(), bloc.getChild(i), liste);
					registres.libererRegiste(1);
				}
			}
		}
		
		// "Incrémentation" (affectation) de la variable de boucle
		ArrayList<Object> l2 = new ArrayList<Object>();
		l2.add(nomBloc);
		if(for_.getChild(0).getChild(2).getText().equals("return")) l2.add(new Integer(0)); else l2.add(new Integer(1));
		res += appelerFonctionDansMap(for_.getChild(0).getChild(2).getText(), for_.getChild(0).getChild(2), l2);
		
		// On reboucle sur la condition de la boucle (JMP e_loop)
		res += "\tJMP #"+ e_loop + "_-$-2 // saut au début de la boucle\n";
		// Écriture de l'étiquette
		res += e_res + "_	// Etiquette pour la fin de la boucle\n\n";

		return res;
	}
	
	//Ajouter les fonctions systeme
	public static String systemIO(){
		String res = "";	
		//Procedure exit
		if(code_asm.contains("exit_")){
			res 	+= "exit_				// PROCEDURE pour quitter le programme\n"
					+ "\tLDW SP, BP    // abandon infos locales\n"
					+ "\tLDW BP, (SP)  // charge BP avec ancien BP\n"
					+ "\tADQ 2, SP      // incrémente SP\n"

					+ "\t// arrêt simulateur\n"
					+ "\tLDW WR, #EXIT_EXC // WR = EXIT_EXC\n"
					+ "\tTRP WR                    // EXIT: arrête le programme\n"

					+ "\t// saute à main si on redemance exécution (sinon part dans les choux ...)\n"
					+ "\tLDW WR, #main_\n"
					+ "\tJEA (WR)\n"
					+ "\n\n";
		}

		//Procedure printc
		if(code_asm.contains("printc_")){
			res 	+= "printc_				// PROCEDURE afficher un caractere\n"
					+ "\tLDQ 0, R1		// R1 = taille données locales (ici 0) de fonction appelée\n"
					+ "\tSTW BP, -(SP)	// empile le contenu du registre BP\n"
					+ "\tLDW BP, SP    	// charge contenu SP ds BP qui pointe sur sa sauvegarde\n"
					+ "\tSUB SP, R1, SP	// réserve R1 octets sur la pile pour la variable locale\n"

					+ "\tLDW R0, #NIL		// On met a NIL la fin de la chaine pour arreter l'affichage\n"
					+ "\tSTW R0, -(SP)\n"

					+ "\tLDW R0, BP		// On recopie le caracetre a afficher au sommet de la pile\n"
					+ "\tADQ 4, R0\n"
					+ "\tLDW R0, (R0)\n"
					+ "\tSTW R0, -(SP)\n"

					+ "\tLDW R0, SP\n"
					+ "\tTRP #WRITE_EXC	// Lancement de la TRP\n"

					+ "\tSTW R0, (SP)+	// On dépile les caracteres empilés\n"
					+ "\tSTW R0, (SP)+\n"

					+ "\tLDW SP, BP		// charge SP avec contenu de BP: abandon infos locales\n"
					+ "\tLDW BP, (SP)		// charge BP avec ancien BP\n"
					+ "\tADQ 2, SP		// ancien BP supprimé de la pile\n"

					+ "\tRTS\n"
					+ "\n\n";
		}

		//Procedure printi
		if(code_asm.contains("printi_")){
			res 	+= "printi_				// PROCEDURE afficher un nombre\n"
					+ "\tLDQ 0, R1		// R1 = taille données locales (ici 0) de fonction appelée\n"
					+ "\tSTW BP, -(SP)	// empile le contenu du registre BP\n"
					+ "\tLDW BP, SP    	// charge contenu SP ds BP qui pointe sur sa sauvegarde\n"
					+ "\tSUB SP, R1, SP	// réserve R1 octets sur la pile pour la variable locale z\n"

					//+ "\tLDW R0, #NIL		// On met a NIL la fin de la chaine pour arreter l'affichage\n"
					//+ "\tSTW R0, -(SP)\n"

					//+ "\tLDW R0, BP		// On recopie le caracetre a afficher au sommet de la pile\n"
					//+ "\tADQ 4, R0\n"
					//+ "\tLDW R0, (R0)\n"
					//+ "\tSTW R0, -(SP)\n"

					+ "\t// char toto[7];\n"
					+ "\t// réserve 7+1 = 8 caractères en pile\n"
					+ "\t// (entier pair supérieur à 7 demandé pour pas désaligner pile)\n"
					+ "\tadi SP, SP, #-8   // réserve place pour text sur pile (8 octets); \n"
					+ "\t// déplacement du début du tableau est -8\n"
					+ "\n"
					+ "\t// int value;\n"
					+ "\tadi SP, SP, #-2   // réserve place pour variable value;\n"
					+ "\t// déplacement de value est -10\n"
					+ "\n"
					+ "\t// value = -23; \n"
					//+ "\tldw R0, #-23      // charge R0 avec -23 = C2(23) = FFE9\n"
					//
					+ "\tLDW R0, SP		// On recopie le caracetre a afficher au sommet de la pile\n"
					+ "\tADQ 14, R0\n"
					+ "\tLDW R0, (R0)\n"
					//
					+ "\tstw R0, (BP)-10   // sauve R0 à l'adresse BP-10       \n"
					+ "\n"
					+ "\t// itoa(value, text, 10); // appelle itoa avec i = value, p = text, b = 10\n"
					+ "\n"
					+ "\tldw R0, #10       // charge 10 (pour base décimale) dans R0\n"
					+ "\tstw R0, -(SP)     // empile contenu de R0 (paramètre b)\n"
					+ "\n"
					+ "\tadi BP, R0, #-8   // R0 = BP - 8 = adresse du tableau text\n"
					+ "\tstw R0, -(SP)     // empile contenu de R0 (paramètre p)\n"
					+ "\n"
					+ "\tldw R0, (BP)-10   // charge R0 avec value\n"
					+ "\tstw R0, -(SP)     // empile contenu de R0 (paramètre i)\n"
					+ "\n"
					+ "\tjsr @itoa_        // appelle fonction itoa d'adresse itoa_\n"
					+ "\n"
					+ "\tadi SP, SP, #6    // nettoie la pile des paramètres \n"
					+ "\t// de taille totale 6 octets\n"
					+ "\n"
					+ "\t// print(text);\n"
					+ "\n"
					+ "\tadi BP, R0, #-8   // R0 = BP - 8 = adresse du tableau text\n"
					+ "\tstw R0, -(SP)     // empile contenu de R0 (paramètre p)\n"
					+ "\n"
					+ "\tjsr @print_       // appelle fonction print d'adresse print_\n"
					+ "\n"
					//+ "\tadi SP, SP, #2    // nettoie la pile des paramètres\n"
					//+ "\t// de taille totale 2 octets\n"

					//+ "\tSTW R0, (SP)+	// On dépile les caracteres empilés\n"
					//+ "\tSTW R0, (SP)+\n"

					+ "\tLDW SP, BP		// charge SP avec contenu de BP: abandon infos locales\n"
					+ "\tLDW BP, (SP)		// charge BP avec ancien BP\n"
					+ "\tADQ 2, SP		// ancien BP supprimé de la pile\n"

					+ "\tRTS\n"
					+ "\n\n";
		}

		if(code_asm.contains("printi_")||code_asm.contains("itoa_")){
			//Fonction ITOA pour convertir un entier en chaine de caractere
			res 	+= "ITOA_I      equ 4      // offset du paramètre i\n"
					+ "ITOA_P      equ 6      // offset du paramètre p\n"
					+ "ITOA_B      equ 8      // offset du paramètre b\n"
					+ "ASCII_MINUS equ 45     // code ASCII de -\n"
					+ "ASCII_PLUS  equ 43     // code ASCII de +\n"
					+ "ASCII_SP    equ 32     // code ASCII d'espace SP\n"
					+ "ASCII_0     equ 48     // code ASCII de zéro (les autres chiffres jusqu'à 9 suivent dans l'ordre)\n"
					+ "ASCII_A     equ 65     // code ASCII de A (les autres lettres jusqu'à Z suivent dans l'ordre alphabétique)\n\n"
					+ "itoa_   stw BP, -(SP)\n"
					+ "\tldw BP, SP\n"
					+ "\n"
					+ "\t// récupération des paramètres depuis pile vers registres\n"
					+ "\tldw R0, (BP)ITOA_I    // R0 = i    \n"
					+ "\tldw R1, (BP)ITOA_B    // R1 = b\n"
					+ "\n"
					+ "\t// gère le signe: normalement itoa gère des int c'est à dire des entiers signés, \n"
					+ "\t// mais en fait seulement pour b=10;\n"
					+ "\t// dans ce cas calcule le signe dans r3 et charge R0 avec la valeur absolue de i\n"
					+ "\tldq ASCII_SP, r3      // code ASCII de eSPace (SPace) -> r3\n"
					+ "\tldq 10, WR            // 10 -> WR\n"
					+ "\tCMP R1, WR            // charge les indicateurs de b - 10\n"
					+ "\tbne NOSIGN-$-2        // si non égal (donc si b != 10) saute en NOSIGN, sinon calcule signe\n"
					+ "\tldq ASCII_PLUS, r3    // charge le code ASCII du signe plus + dans r3\n"
					+ "\ttst R0                // charge les indicateurs de R0 et donc de i\n"
					+ "\tbge POSIT-$-2         // saute en POSIT si i >= 0\n"
					+ "\tneg R0, R0            // change le signe de R0\n"
					+ "\tldq ASCII_MINUS, r3   // charge le code ASCII du signe moins - dans r3\n"
					+ "\tPOSIT   NOP                   // r3 = code ASCII de signe: SP pour aucun, - ou +\n"
					+ "\n"
					+ "\n"
					+ "\t// convertit l'entier i en chiffres et les empile de droite à gauche\n"
					+ "\tNOSIGN  ldw R2, R0            // R2 <- R0\n"
					+ "\tCNVLOOP ldw R0, R2            // R0 <- R2\n"
					+ "\n"
					+ "\t// effectue 'créativement' la division par b supposé pair (car l'instruction div est hélas signée ...)\n"
					+ "\t// d=2*d' , D = d * q + r  , D = 2*D'+r\" , D\' = d\' * q + r' => r = 2*r'+r\"\n"
					+ "\t// un bug apparaît avec SRL R0, R0 avec R0 = 2 : met CF à 1 !!\n"
					+ "\tsrl R1, R1            // R1 = b/2\n"
					+ "\tani R0, R4, #1        // ANd Immédiate entre R0 et 00...01 vers R4:\n"
					+ "\t// bit n°0 de R0 -> R4; R4 = reste de R0/2\n"
					+ "\tsrl R0, R0            // R0 / 2 -> R0\n"
					+ "\tdiv R0, R1, R2        // quotient = R0 / R1 -> R2, reste' = R0 % R1 -> R0\n"
					+ "\tshl R0, R0            // R0 = 2 * reste'\n"
					+ "\tadd R0, R4, R0        // R0 = reste = 2 * reste' + reste\" => R0 = chiffre\n"
					+ "\tshl R1, R1            // R1 = b\n"
					+ "\n"
					+ "\tadq -10, R0           // chiffre - 10 -> R0 \n"
					+ "\tbge LETTER-$-2        // saute en LETTER si chiffre >= 10\n"
					+ "\tadq 10+ASCII_0, R0    // ajoute 10 => R0 = chiffre, ajoute code ASCII de 0 \n"
					+ "\t// => R0 = code ASCII de chiffre\n"
					+ "\tbmp STKCHR-$-2        // saute en STKCHR \n"
					+ "\n"
					+ "\tLETTER  adq ASCII_A, R0       // R0 = ASCII(A) pour chiffre = 10, ASCII(B) pour 11 ...\n"
					+ "\t// ajoute code ASCII de A => r = code ASCII de chiffre\n"
					+ "\tSTKCHR  stw R0, -(SP)         // empile code ASCII du chiffre \n"
					+ "\t// (sur un mot complet pour pas désaligner pile)\n"
					+ "\ttst R2                // charge les indicateurs en fonction du quotient ds R2)\n"
					+ "\tbne CNVLOOP-$-2       // boucle si quotient non nul; sinon sort\n"
					+ "\n"
					+ "\t// les caractères sont maintenant empilés : gauche en haut et droit en bas\n"
					+ "\n"
					+ "\t// recopie les caractères dans le tampon dans le bon ordre: de gauche à droite\n"
					+ "\tldw R1, (BP)ITOA_P    // R1 pointe sur le début du tampon déjà alloué \n"
					+ "\tstb r3, (R1)+         // copie le signe dans le tampon\n"
					+ "\tCPYLOOP ldw R0, (SP)+         // dépile code du chiffre gauche (sur un mot) dans R0\n"
					+ "\tstb R0, (R1)+         // copie code du chiffre dans un Byte du tampon de gauche à droite\n"
					+ "\tCMP SP, BP            // compare SP et sa valeur avant empilement des caractères qui était BP\n"
					+ "\tbne CPYLOOP-$-2       // boucle s'il reste au moins un chiffre sur la pile\n"
					+ "\tldq NIL, R0           // charge le code du caractère NIL dans R0\n"
					+ "\tstb R0, (R1)+         // sauve code NIL pour terminer la chaîne de caractères\n"
					+ "\n"
					+ "\t// termine\n"
					+ "\tldw R0, (BP)ITOA_P    // retourne le pointeur sur la chaîne de caractères\n"
					+ "\n"
					+ "\t// UNLINK: fermeture de l'environnement de la fonction itoa\n"
					+ "\tldw SP, BP            // SP <- BP : abandonne infos locales; SP pointe sur ancinne valeur de BP\n"
					+ "\tldw BP, (SP)+         // dépile ancienne valeur de BP dans BP; SP pointe sur adresse de retour\n"
					+ "\n"
					+ "\trts                   // retourne au programme appelant\n"
					+ "\n\n";
		}

		if(code_asm.contains("printi_")||code_asm.contains("print_")){
			//Fonction print (pour les tableaux de caracteres)
			res 	+= "\t// void print(char* p)     // imprime le texte pointé par paramètre p\n"
					+ "\n"
					+ "\t// prépare l'environnement de la fonction appelée (prologue) :\n"
					+ "\n"
					+ "print_     LDQ 0, R1      // R1 = taille données locales (ici 0) de fonction appelée\n"
					+ "\n"
					+ "\t// LINK R1        // crée et lie l'environnement de fonction appelée\n"
					+ "\tSTW BP, -(SP)  // empile le contenu du registre BP\n"
					+ "\tLDW BP, SP     // charge contenu SP ds BP qui pointe sur sa sauvegarde\n"
					+ "\tSUB SP, R1, SP // réserve R1 octets sur la pile pour la variable locale z\n"
					+ "\n"
					+ "\t// charge R0 avec le paramètre p de déplacement 4\n"
					+ "\tLDW R0, (BP)4  // R0 = M[BP + 4]\n"
					+ "\n"
					+ "\t// affiche texte pointé par R0\n"
					+ "\tTRP #WRITE_EXC // lance trappe n° WRITE_EXC: affiche texte d'adresse R0\n"
					+ "\n"
					+ "\t// fin de la fonction (épilogue) :\n"
					+ "\n"
					+ "\t// UNLINK \n"
					+ "\tLDW SP, BP    // charge SP avec contenu de BP: abandon infos locales\n"
					+ "\tLDW BP, (SP)+ // dépile ancien BP dans BP\n"
					+ "\n"
					+ "\tRTS  // retour au programme appelant\n\n";
		}

		return res;
	}
}
