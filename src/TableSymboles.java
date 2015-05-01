import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.antlr.runtime.tree.Tree;

import enumeration.Mode;
import enumeration.Nature;
import enumeration.Type;

/**
 * 
 * Regroupe l'ensemble des symboles d'une table.
 * 
 */

public class TableSymboles
{
	private HashMap<String, Symbole> tds = new HashMap<String, Symbole>();
	private int tailleVariablesLocales = 0;

	public TableSymboles()
	{

	}

	public void put(String key, Symbole symbole)
	{
		tds.put(key, symbole);
	}

	public void remove(String key)
	{
		tds.remove(key);
	}

	public String toString()
	{
		String res = "";
		res += "-------------------------------------------------------------------------------------------------\n";
		res += "| nom\t\t| type\t\t| mode\t\t  | nature\t| adresse\t| taille\t|\n";
		res += "-------------------------------------------------------------------------------------------------\n";

		for (Map.Entry<String, Symbole> entry : tds.entrySet())
		{
			String key = entry.getKey();
			if (key.length() <= 5)
				key += "\t";
			Symbole value = entry.getValue();
			res += "| " + key + "\t| " + value.toString() + "\n";
		}
		res += "-------------------------------------------------------------------------------------------------\n";

		return res;
	}

	/*
	 * Permet d'afficher les tables de symboles
	 */
	public static void afficherTablesSymboles()
	{
		System.out.println("\n************************");
		System.out.println("* TABLES DES SYMBOLES  *");
		System.out.println("************************\n");
		for (Entry<String, TableSymboles> entry : Compilateur.liste_tds
				.entrySet())
		{
			String key = entry.getKey();
			TableSymboles value = entry.getValue();
			System.out.println("Nom table : " + key);
			System.out.println(value);
		}
	}

	/*
	 * Indique si un symbole est présent dans la table
	 */
	public static boolean symboleIsInTable(String name, TableSymboles table)
	{
		if (table != null)
			return table.getTds().get(name) != null;
		return false;
	}
	
	/*
	 * Récupérer la taille d'une déclaration (utile pour les tableaux...)
	 */
	public static int recupererTailleDeclaration(Tree arbre)
	{
		int taille = 2;
		if(arbre.getChild(1).getText().equals("TABLEAU"))
		{
			taille = Integer.valueOf(arbre.getChild(1).getChild(1).getChild(0).getText()) * 2;
		}
		else if(arbre.getChild(1).getChild(0)!=null&&arbre.getChild(1).getChild(0).getChild(0).getText().equals("TABLEAU"))
		{
			taille = Integer.valueOf(arbre.getChild(1).getChild(0).getChild(0).getChild(1).getChild(0).getText()) * 2;
		}
		return taille;
	}

	/*
	 * Ajouter des déclarations dans une table des symboles
	 */
	public static void ajouterDeclaration(Tree arbre, TableSymboles table, int adresse)
	{
		String name = arbre.getChild(1).getText();
		Type type = null;
		Mode mode = null;
		int taille = 0;
		if (arbre.getChild(0).getText().equals("PTR"))
		{//cas des pointeurs
			if (arbre.getChild(0).getChild(0).getText().equals("PTR"))
			{//cas pointeur de pointeur
				type = Type.get(arbre.getChild(0).getChild(0).getChild(0)
						.getText());
				mode = Mode.get("double_direct");
			}
			else
			{//cas pointeur
				type = Type.get(arbre.getChild(0).getChild(0).getText());
				mode = Mode.get("indirect");
			}
		}
		else if(arbre.getChild(0).getText().equals("int") || arbre.getChild(0).getText().equals("char"))
		{
			//cas des variables
			type = Type.get(arbre.getChild(0).getText());
			mode = Mode.get("direct");
		}
		Nature nature = Nature.VARIABLE;
		String valeur = new String();

		// cas d'une déclaration sans affectation
		if (name.equals("TABLEAU"))
		{
			nature = Nature.TABLEAU;
			name = arbre.getChild(1).getChild(0).getText();
			type = Type.get(arbre.getChild(0).getText());
		}

		// cas d'une déclaration avec initialisation
		else if (name.equals("AFFECT"))
		{
			// membre gauche du égal
			Tree filsAffect = arbre.getChild(1).getChild(0).getChild(0);
			String texteFilsAffect = filsAffect.getText();

			// cas d'un tableau
			if (texteFilsAffect.equals("TABLEAU"))
			{
				nature = Nature.TABLEAU;
				name = arbre.getChild(1).getChild(0).getChild(0).getChild(0)
						.getText();
				type = Type.get(arbre.getChild(0).getText());
			}
			// cas d'un int ou char
			else
			{
				name = valeur = arbre.getChild(1).getChild(0).getChild(0)
						.getText();
				valeur = arbre.getChild(1).getChild(0).getChild(1).getText();
				type = Type.INT;
				if (valeur.equals("CARACTERE"))
				{
					valeur = arbre.getChild(1).getChild(0).getChild(1)
							.getChild(0).getText();
					type = Type.CHAR;
				}
			}

		}
		// cas des variables procédurales
		if (arbre.getParent() != null && arbre.getParent().getText() != null)
		{
			if (arbre.getParent().getText().equals("PARAM"))
				nature = Nature.PARAM;
		}
		taille = recupererTailleDeclaration(arbre);
		Symbole s = new Symbole(type, mode, nature, adresse, taille);
		table.put(name, s);
		if(nature != Nature.PARAM)
			table.tailleVariablesLocales += taille;
	}

	/*
	 * Permet de créer la table de symbole d'une fonction ou d'une procédure
	 */
	public static void creerTableSymboles(Tree t)
	{
		TableSymboles table = new TableSymboles();
		boolean fonction = false;
		int adresseVariableLocale = -2; // déplacement négatif à partir de BP pour la première déclaration locale
		int adresseParametreFormel = 4; // déplacement positif à partir de BP pour la première déclaration (paramètre formel)
		
		if (!t.getText().equals("PROC"))
			fonction = true;

		String name = t.getText() == "MAIN" ? "main" : t.getChild(0).getText();
		Compilateur.liste_tds.put(name, table);

		if (!name.equals("main"))
		{
			int indiceParams = fonction ? 2 : 1;
			Tree params = t.getChild(indiceParams);
			for (int i = 0; i < params.getChildCount(); i++)
			{
				ajouterDeclaration(params.getChild(i), table, adresseParametreFormel);
				int taille;
				taille = recupererTailleDeclaration(params.getChild(i));
				adresseParametreFormel += taille;
			}
		}

		for (int i = 0; i < t.getChildCount(); i++)
		{
			if (t.getChild(i).toString().equals("BLOC"))
			{
				Tree bloc = t.getChild(i);
				for (int j = 0; j < bloc.getChildCount(); j++)
				{
					if (bloc.getChild(j).getText().equals("AFFECT"))
					{
						String nameSymbole = bloc.getChild(j).getChild(0)
								.getChild(0).getText();
						if(nameSymbole.equals("TABLEAU")){
							nameSymbole=bloc.getChild(j).getChild(0).getChild(0).getChild(0).getText();
						}
						if (!(symboleIsInTable(nameSymbole, table) || symboleIsInTable(
								nameSymbole,
								Compilateur.liste_tds.get("#global#")))){
							System.err
									.println("Erreur: ligne " + bloc.getChild(j).getChild(0)
											.getChild(0).getLine() + ": variable '"
											+ nameSymbole
											+ "' utilsée mais non declaree dans la fonction "
											+ name + ".");
							ControleSemantique.inc_nb_erreur();
						}
					}
					if (bloc.getChild(j).getText().equals("DECL"))
					{
						ajouterDeclaration(bloc.getChild(j), table, adresseVariableLocale);
						int taille;
						taille = recupererTailleDeclaration(bloc.getChild(j));
						adresseVariableLocale-=taille;
					}
				}
			}
		}
	}

	/*
	 * Permet de créer l'ensemble des tables (vars globales, main et fonctions
	 */
	public static void creerTablesSymboles(Tree t)
	{
		TableSymboles table = new TableSymboles();
		Compilateur.liste_tds.put("#global#", table);
		int adresse = -2; // déplacement positif à partir de BP pour la première déclaration globale
		
		if (t.getText()!=null&&t.getText().equals("MAIN"))
		{
			String name = "main";
			Type type = Type.get(t.getChild(0).getText());
			Mode mode = Mode.get("direct");
			Symbole s = new Symbole(type, mode, Nature.FONCTION, 0, 0);
			table.put(name, s);
			creerTableSymboles(t);
		}
		else
		{
			for (int i = 0; i < t.getChildCount(); i++)
			{
				Tree fils = t.getChild(i);
				if (fils.getText().equals("FONCT"))
				{
					String name = fils.getChild(0).getText();
					Type type = Type.get(fils.getChild(1).getText());
					Mode mode = Mode.get("direct");
					Symbole s = new Symbole(type, mode, Nature.FONCTION, 0, fils.getChild(2).getChildCount());
					table.put(name, s);
					creerTableSymboles(fils);
					if (!returnInFonct(fils)){
						System.err
								.println("Erreur: ligne " + fils.getLine() + ": pas de 'return' dans la fonction '"
										+ name + "'.");
						ControleSemantique.inc_nb_erreur();
					}
				}
				else if (fils.getText().equals("PROC"))
				{
					String name = fils.getChild(0).getText();
					Type type = Type.get("void");
					Mode mode = Mode.get("direct");
					Symbole s = new Symbole(type, mode, Nature.PROCEDURE, 0, fils.getChild(1).getChildCount());
					table.put(name, s);
					creerTableSymboles(fils);
				}
				else if (fils.getText().equals("MAIN"))
				{
					String name = "main";
					Type type = Type.get(fils.getChild(0).getText());
					Mode mode = Mode.get("direct");
					Symbole s = new Symbole(type, mode, Nature.FONCTION, 0, 0);
					table.put(name, s);
					creerTableSymboles(fils);
					/* if (!returnInFonct(fils))
						System.err
								.println("Erreur : pas de 'return' dans la fonction "
										+ name + ".");
					*/
					/*
					 * ======> Utile dans le main ?
					 */
				}
				else if (fils.getText().equals("DECL"))
				{
					ajouterDeclaration(fils, table, adresse);
					int taille;
					taille = recupererTailleDeclaration(fils);
					adresse-=taille;
				}
			}
		}
	}

	public static boolean returnInFonct(Tree t)
	{
		boolean trouve = false;
		for (int i = 0; i < t.getChildCount(); i++)
		{
			Tree fils = t.getChild(i);
			if (fils.getText().equals("return"))
			{
				return true;
			}
			else if (fils.getText().equals("BLOC")
					|| fils.getText().equals("IF")
					|| fils.getText().equals("WHILE"))
			{
				trouve |= returnInFonct(fils);
			}
		}
		return trouve;
	}

	public HashMap<String, Symbole> getTds()
	{
		return tds;
	}
	
	public int getTailleVariablesLocales()
	{
		return tailleVariablesLocales;
	}
}
