import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.HashMap;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.Tree;

public class Compilateur
{
	public static HashMap<String, TableSymboles> liste_tds = new HashMap<String, TableSymboles>();
	public static String code_asm = "";
	private static boolean flagi = false;//Affiche les infos sur stdout si à TRUE
	private final static String usage = "Usage : java -jar compilateur.jar path/source.c [-i] ";
	
	public static void main(String[] args) throws Exception
	{
		//Test nombre de parametre
		if (args.length < 1)
		{
			System.err.println("Un parametre obligatoire!");
			System.out.println(usage);
			System.exit(1);
		}
		//Lecture des options
		String input_file = null;
		if(args.length==1){
			input_file= args[0];
		}
		else{
			if(args[0].matches("-i")){
				input_file= args[1];
				flagi = true;
			}
			else if(args[1].matches("-i")){
				input_file= args[0];
				flagi = true;
			}
			else{
				System.err.println("Option inconnue! ");
				System.out.println(usage);
				System.exit(1);
			}
		}
		
		//verrification fichier ".c"
		if (!input_file.matches(".*\\.c$"))
		{
			System.err.println("Fichier source invalide!");
			System.exit(0);
		}

		// lexer and parser
		ANTLRFileStream input = null;
		try
		{
			input = new ANTLRFileStream(input_file, "UTF8");
		}
		catch (FileNotFoundException e)
		{
			System.err.println("Fichier " + input_file + " introuvable!");
			System.exit(0);
		}
		microC_ASTLexer lexer = new microC_ASTLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		microC_ASTParser parser = new microC_ASTParser(tokens);
		microC_ASTParser.programme_return prog = parser.programme();

		//nombre d'erreurs syntaxiques
		int nerror = parser.getNumberOfSyntaxErrors();

		//S'il n'y a pas d'erreur syntaxique
		if (nerror == 0)
		{
			//AST
			Tree ast = prog.getTree();
			if(flagi) System.out.println("AST : " + ast.toStringTree());

			//Génération des TDS
			TableSymboles.creerTablesSymboles(ast);

			//On affiche la TDS
			if(flagi) TableSymboles.afficherTablesSymboles();
			
			//Controle sémantique
			ControleSemantique.lancer(ast);
			
			//Génération de codes
			GenerateurDeCode.lancer(ast);
			//Ecriture du fichier assembleur
			String output_file = input_file.replaceAll("\\.c", ".src");
			FileWriter fw = new FileWriter(output_file);
			fw.write(GenerateurDeCode.code_asm);
			fw.close();

			//Commande de compilation microPIUP4
			String cmd = "java -jar microPIUP4.jar -ass " + output_file;
			Process process = Runtime.getRuntime().exec(cmd);
			//process.waitFor();
			String line = "", l;
			boolean exec_err = false;
			BufferedReader in = new BufferedReader(new InputStreamReader(
					process.getInputStream()));
			while ((l = in.readLine()) != null)
			{
				line += l + "\n";
			}
			BufferedReader err = new BufferedReader(new InputStreamReader(
					process.getErrorStream()));
			while ((l = err.readLine()) != null)
			{
				line += l + "\n";
				exec_err = true;
			}
			if (!exec_err)
			{
				if(flagi) System.out.println(line+ "\n");
				System.out.println("Le fichier assembleur '"+input_file.replaceAll("\\.c", ".iup")+"' a bien ete genere.");
			}
			else
			{
				if(flagi) System.err.println(line+ "\n");
				System.err.println("Le fichier assembleur '"+input_file.replaceAll("\\.c", ".iup")+"' n'a pas ete genere.");
			}
			in.close();
		}
		else
		{
			System.err.println("Il y a " + nerror + " erreur"
					+ ((nerror > 1) ? "s" : ""));
		}
	}

}