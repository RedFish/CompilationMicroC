import java.util.Map;
import java.util.Map.Entry;

import org.antlr.runtime.tree.Tree;

import enumeration.Mode;
import enumeration.Nature;
import enumeration.Type;


public class ControleSemantique {
	private static int nb_erreur = 0;
	private static int nb_attention = 0;
	private static final int overflow_number = 32767;

	public static void inc_nb_erreur(){
		nb_erreur++;
	}

	public static void inc_nb_attention(){
		nb_attention++;
	}

	public static void lancer(Tree ast) {
		System.out.flush();//On vide le buffer stdoud avant d'afficher des erreurs

		//Lancement de la moulinette qui permet de detecter les erreurs
		moulinette(ast,"#global#");

		//Affichage des messages
		if (nb_erreur>0){
			System.err.println("\nLe code ne peut pas etre genere! ("+nb_erreur+" error"+(nb_erreur>1?"s":"")+", "+nb_attention+" warning"+(nb_attention>1?"s":"")+")");
			System.exit(1);
		}
		else if(nb_attention>0){
			System.err.println("\nLe code peut etre genere! ("+nb_erreur+" error"+(nb_erreur>1?"s":"")+", "+nb_attention+" warning"+(nb_attention>1?"s":"")+")");

		}
		System.err.flush();//On vide le buffer stderr pour afficher les erreurs d'un seul coup
	}

	private static void moulinette(Tree t, String table) {
		if (t.getText()!=null&&t.getText().equals("MAIN"))
		{
			moulinette(t.getChild(1), "main");
		}
		else{
			String nom_table = table;
			for (int i = 0; i < t.getChildCount(); i++){
				Tree fils = t.getChild(i);
				
				if (fils.getText().equals("FONCT")||fils.getText().equals("PROC")){
					nom_table = fils.getChild(0).getText();
				}
				else if (fils.getText().equals("MAIN")){
					nom_table = "main";
				}
				else if (fils.toString().equals("CALL")){
					if(fils.getChildCount()==2){
						String nom_call = fils.getChild(0).toString();
						int nombre_param = fils.getChild(1).getChildCount();
						for (Map.Entry<String, Symbole> entry : Compilateur.liste_tds.get("#global#").getTds().entrySet()){
							String key = entry.getKey();
							Symbole value = entry.getValue();
							if(key.equals(nom_call)) { //cas de fonction/proc utilisateurs
								//Test le nombre de parametre passé lors de l'appel d'un fonction/procedure
								if(value.getTaille()!=nombre_param){
									System.err.println(
											"Erreur: ligne " + fils.getLine() + ": La fonction '"
													+ key
													+ "' utilise "
													+ value.getTaille()
													+ " parametre"+(value.getTaille()>1?"s":"")
													+ " (" + nombre_param
													+ " parametre"+(nombre_param>1?"s":"")
													+ " lors de l'appel)."
											);
									inc_nb_erreur();
								}
								// si y a le bon nombre de parametre on compare les types
								else{
									for(int j=1;j<=nombre_param;j++){
										for (Map.Entry<String, Symbole> entry1 : Compilateur.liste_tds.get(key).getTds().entrySet()){
											//String key1 = entry1.getKey();
											Symbole value1 = entry1.getValue();
											boolean adresse=false;
											boolean pointeur=false;

											Type type = Type.VOID;
											Mode mode = Mode.DIRECT;
											String name = "";
											if(fils.getChild(1).getChild(j-1).getText().equals("CARACTERE")){//cas du char
												type=Type.CHAR;
											}
											else if (GenerateurDeCode.isInteger(fils.getChild(1).getChild(j-1).getText())||fils.getChild(1).getChild(j-1).getText().equals("-")){
												type=Type.INT;
											}
											else if(fils.getChild(1).getChild(j-1).getText().equals("PTR")){
												if(fils.getChild(1).getChild(j-1).getChild(0).getText().equals("PTR")){
													mode = Mode.INDIRECT;
													name = fils.getChild(1).getChild(j-1).getChild(0).getChild(0).getText();
												}
												name = fils.getChild(1).getChild(j-1).getChild(0).getText();
												pointeur=true;
											}
											else if(fils.getChild(1).getChild(j-1).getText().equals("ADDRESS")){
												mode = Mode.INDIRECT;
												adresse=true;
												name = fils.getChild(1).getChild(j-1).getChild(0).getText();
											}
											else{
												name=fils.getChild(1).getChild(j-1).getText();
											}

											Type type_juste;
											if(name.equals("")){
												type_juste = value1.getType();
												int num = 0;
												if(type_juste==Type.INT){
													num = getNumeroParametre(value1.getAdresse(), GenerateurDeCode.tailleEntier);
												}
												else if(type_juste==Type.CHAR){
													num = getNumeroParametre(value1.getAdresse(), GenerateurDeCode.tailleChar);
												}
												//test si pas le meme type
												if(num==j&&type_juste!=type){
													System.err.println(
															"Warning: ligne " + fils.getLine() + ": Le parametre " + j
															+ " de la fonction '"
															+ key
															+ "' est de type '"
															+ type_juste
															+ "' (type "+type+" utilise)."
															);
													inc_nb_attention();
												}
											}
											else{//cas des variables
												Symbole symb = null;
												if(Compilateur.liste_tds.get(table).getTds().get(name) != null){
													symb=Compilateur.liste_tds.get(table).getTds().get(name);
												}
												else if (!table.equals("#global#")){
													if(Compilateur.liste_tds.get("#global#").getTds().get(name) != null){
														symb=Compilateur.liste_tds.get("#global#").getTds().get(name);
													}
												}


												type_juste = value1.getType();
												Mode mode_juste = value1.getMode();
												int num = 0;
												if(pointeur||adresse){
													num = getNumeroParametre(value1.getAdresse(),GenerateurDeCode.taillePointeur);
												}
												else if(type_juste==Type.INT){
													num =  getNumeroParametre(value1.getAdresse(),GenerateurDeCode.tailleEntier);
												}
												else if(type_juste==Type.CHAR){
													num =  getNumeroParametre(value1.getAdresse(),GenerateurDeCode.tailleChar);
												}


												String genre = "";
												if(mode==Mode.DIRECT){
													genre="La varible";
												}
												else{
													genre="Le pointeur";
												}
												
												if(num==j){
													if(symb==null){//La variable n'existe pas
														if(!name.equals("TABLEAU"))
														{	
															System.err.println(
																	"Erreur: ligne " 
																			+ fils.getLine() 
																			+ ": "+genre+" '"
																			+ name
																			+ "' utilsiee mais non declaree dans la fonction "
																			+ table + ".");
															inc_nb_erreur();
														}
													}
													else{
														type = symb.getType();

														if(!adresse&&!pointeur) mode = symb.getMode();
														else if(adresse&&!pointeur&&symb.getMode()==Mode.INDIRECT) mode = Mode.DOUBLE_INDIRECT;
														//else if(!adresse&&pointeur&&mode==Mode.DIRECT) mode = Mode.DOUBLE_INDIRECT;
														else if(!adresse&&pointeur&&symb.getMode()==Mode.INDIRECT) {mode = Mode.DIRECT;pointeur=false;}

														if(pointeur&&symb.getMode()==Mode.DIRECT){
															System.err.println(
																	"Erreur: ligne " + fils.getLine() + ": Utilisation interdite de la variable '"
																			+ name+"' (parametre " + j +")"
																			+ " dans l'appel de la fonction '"
																			+ key + "'"
																	);
															inc_nb_attention();
														}
														else if(type_juste!=type||mode_juste!=mode){
															System.err.println(
																	"Warning: ligne " + fils.getLine() + ": Le parametre " + j
																	+ " de la fonction '"
																	+ key
																	+ "' est de type '"
																	+ type_juste + pointeurFormat(mode_juste)
																	+ "' (type "+type + pointeurFormat(mode) +" utilise)."
																	);
															inc_nb_attention();
														}
													}
												}
											}
										}
									}
								}
							}
						}
						//Test si la fonction/procedure est déclaré
						//Cas des fonctions/proc systemes
						if(nom_call.equals("printi")){
							if(nombre_param!=1){
								System.err.println(
										"Erreur: ligne " + fils.getLine() + ": La fonction '"
												+ "printi"
												+ "' utilise "
												+ 1
												+ " parametre"
												+ " (" + nombre_param
												+ " parametre"+(nombre_param>1?"s":"")
												+ " lors de l'appel)."
										);
								inc_nb_erreur();
							}
							else{
								Type type;
								if(fils.getChild(1).getChild(0).getText().equals("CARACTERE")){//cas du char
									type=Type.CHAR;
								}
								else{
									type=Type.INT;
								}
								Type type_juste = Type.INT;
								if(type_juste!=type){
									System.err.println(
											"Warning: ligne " + fils.getLine() + ": Le parametre 1"
													+ " de la fonction '"
													+ "printi"
													+ "' est de type '"
													+ type_juste
													+ "' (type "+type+" utilise)."
											);
									inc_nb_attention();
								}
							}
						}
						else if(nom_call.equals("printc")){
							if(nombre_param!=1){
								System.err.println(
										"Erreur: ligne " + fils.getLine() + ": La fonction '"
												+ "printc"
												+ "' utilise "
												+ 1
												+ " parametre"
												+ " (" + nombre_param
												+ " parametre"+(nombre_param>1?"s":"")
												+ " lors de l'appel)."
										);
								inc_nb_erreur();
							}
							else{
								Type type=Type.CHAR;
								if(fils.getChild(1).getChild(0).getText().equals("-")||GenerateurDeCode.isInteger(fils.getChild(1).getChild(0).getText())){//cas du char
									type=Type.INT;
								}
								Type type_juste = Type.CHAR;
								if(type_juste!=type){
									System.err.println(
											"Warning: ligne " + fils.getLine() + ": Le parametre 1"
													+ " de la fonction '"
													+ "printc"
													+ "' est de type '"
													+ type_juste
													+ "' (type "+type+" utilise)."
											);
									inc_nb_attention();
								}
							}
						}
						else if(nom_call.equals("print")){

						}
						else if(nom_call.equals("itoa")){

						}
						else if(nom_call.equals("exit")){
							if(nombre_param!=0){
								System.err.println(
										"Erreur: ligne " + fils.getLine() + ": La fonction '"
												+ "exit"
												+ "' n'utilise pas de parametre"
												+ " (" + nombre_param
												+ " parametre"+(nombre_param>1?"s":"")
												+ " lors de l'appel)."
										);
								inc_nb_erreur();
							}
						}	
						else if(Compilateur.liste_tds.get("#global#").getTds().get(nom_call)==null){
							System.err.println(
									"Erreur: ligne " + fils.getLine() + ": fonction '"
											+ nom_call
											+ "' appelee mais non declaree.");
							inc_nb_erreur();
						}
					}
				}
				else if (fils.toString().equals("AFFECT"))
				{
					//Test des bornes du tableau lors de la declaration
					if(fils.getChild(0).getChild(0).getText().equals("TABLEAU")&&fils.getChild(0).getChild(1).getText().equals("PARAM")){
						String nom_tab = fils.getChild(0).getChild(0).getChild(0).getText();
						Symbole symb = null;
						if(Compilateur.liste_tds.get(table).getTds().get(nom_tab) != null){
							symb=Compilateur.liste_tds.get(table).getTds().get(nom_tab);
						}
						else if (!table.equals("#global#")){
							if(Compilateur.liste_tds.get("#global#").getTds().get(nom_tab) != null){
								symb=Compilateur.liste_tds.get("#global#").getTds().get(nom_tab);
							}
						}
						else
							return;
						if(symb == null)
							return;
						int taille_juste = symb.getTaille();

						int nb_param = fils.getChild(0).getChild(1).getChildCount();
						if(taille_juste!=nb_param*2){
							System.err.println(
									"Erreur: ligne " + fils.getLine() + ": Le tableau '"
											+ nom_tab
											+ "' est de taille "
											+ (taille_juste/GenerateurDeCode.tailleEntier)
											+ " (" + nb_param
											+ " valeur"+(nb_param>1?"s":"")
											+ " pour l'initialisation)."
									);
							inc_nb_erreur();
						}
					}
					//Test des bornes du tableau
					else if (fils.getChild(0).getChild(0).toString().equals("TABLEAU")){
						String nom_tab = fils.getChild(0).getChild(0).getChild(0).getText();
						int indice = 0;
						if(GenerateurDeCode.isInteger(fils.getChild(0).getChild(0).getChild(1).getChild(0).getText())){
							indice = Integer.valueOf(fils.getChild(0).getChild(0).getChild(1).getChild(0).getText());
						}
						else if (fils.getChild(0).getChild(0).getChild(1).getChild(0).getText().equals("-")){
							indice = -1;
						}
						Symbole symb = null;
						if(Compilateur.liste_tds.get(table).getTds().get(nom_tab) != null){
							symb=Compilateur.liste_tds.get(table).getTds().get(nom_tab);
						}
						else if (!table.equals("#global#")){
							if(Compilateur.liste_tds.get("#global#").getTds().get(nom_tab) != null){
								symb=Compilateur.liste_tds.get("#global#").getTds().get(nom_tab);
							}
						}
						else{
							return;
						}
						
						if(symb==null)return;
						int taille_juste = symb.getTaille();

						if(indice<0||indice>=taille_juste/2){
							System.err.println(
									"Erreur: ligne " + fils.getLine() + ": depassement des bornes du tableau '"
											+nom_tab
											+"' [0.."
											+ (taille_juste/2-1)
											+ "].");
							inc_nb_erreur();
						}
					}
				}
				else{
					if(GenerateurDeCode.isInteger(fils.getText())){
						int nombre = Integer.parseInt(fils.getText());
						if(nombre>overflow_number){
							System.err.println(
									"Warning: ligne " + fils.getLine() + ": " 
											+ "overflow ("+overflow_number+" max)."
									);
							inc_nb_attention();
						}
					}
				}
				//Appel récurssif
				moulinette(fils,nom_table);
			}
		}
	}

	private static int getNumeroParametre(int adresse, int taillepointeur) {
		int res = (adresse-2)/(taillepointeur);
		return res;
	}

	private static String pointeurFormat(Mode mode){
		if(mode==Mode.DIRECT)
			return "";
		else if(mode==Mode.INDIRECT)
			return " *";
		else
			return " **";
	}

}
