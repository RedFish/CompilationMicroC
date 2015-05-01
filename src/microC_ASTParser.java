// $ANTLR 3.5 /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g 2013-05-22 17:28:54

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class microC_ASTParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ADDRESS", "AFFECT", "BLOC", "CALL", 
		"CARACTERE", "CHIFFRE", "CHIFFRES", "COMMENTAIRE", "COMMENTAIRES", "COND", 
		"DECL", "ELSE", "FIN_INSTRUCTION", "FONCT", "FOR", "IDENTIFIANT", "IF", 
		"INDICE", "LETTRE", "LETTRE_QUOTE", "MAIN", "PARAM", "PROC", "PTR", "SIZE", 
		"TABLEAU", "WHILE", "WS", "'!'", "'!='", "'&&'", "'&'", "'('", "')'", 
		"'*'", "'*='", "'+'", "'+='", "','", "'-'", "'-='", "'/'", "'/='", "'<'", 
		"'<='", "'='", "'=='", "'>'", "'>='", "'['", "']'", "'char'", "'else'", 
		"'for'", "'if'", "'int'", "'main'", "'return'", "'void'", "'while'", "'{'", 
		"'||'", "'}'"
	};
	public static final int EOF=-1;
	public static final int T__32=32;
	public static final int T__33=33;
	public static final int T__34=34;
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int T__37=37;
	public static final int T__38=38;
	public static final int T__39=39;
	public static final int T__40=40;
	public static final int T__41=41;
	public static final int T__42=42;
	public static final int T__43=43;
	public static final int T__44=44;
	public static final int T__45=45;
	public static final int T__46=46;
	public static final int T__47=47;
	public static final int T__48=48;
	public static final int T__49=49;
	public static final int T__50=50;
	public static final int T__51=51;
	public static final int T__52=52;
	public static final int T__53=53;
	public static final int T__54=54;
	public static final int T__55=55;
	public static final int T__56=56;
	public static final int T__57=57;
	public static final int T__58=58;
	public static final int T__59=59;
	public static final int T__60=60;
	public static final int T__61=61;
	public static final int T__62=62;
	public static final int T__63=63;
	public static final int T__64=64;
	public static final int T__65=65;
	public static final int T__66=66;
	public static final int ADDRESS=4;
	public static final int AFFECT=5;
	public static final int BLOC=6;
	public static final int CALL=7;
	public static final int CARACTERE=8;
	public static final int CHIFFRE=9;
	public static final int CHIFFRES=10;
	public static final int COMMENTAIRE=11;
	public static final int COMMENTAIRES=12;
	public static final int COND=13;
	public static final int DECL=14;
	public static final int ELSE=15;
	public static final int FIN_INSTRUCTION=16;
	public static final int FONCT=17;
	public static final int FOR=18;
	public static final int IDENTIFIANT=19;
	public static final int IF=20;
	public static final int INDICE=21;
	public static final int LETTRE=22;
	public static final int LETTRE_QUOTE=23;
	public static final int MAIN=24;
	public static final int PARAM=25;
	public static final int PROC=26;
	public static final int PTR=27;
	public static final int SIZE=28;
	public static final int TABLEAU=29;
	public static final int WHILE=30;
	public static final int WS=31;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public microC_ASTParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public microC_ASTParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return microC_ASTParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g"; }


	public static class programme_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "programme"
	// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:30:1: programme : ( declaration FIN_INSTRUCTION !| affectation FIN_INSTRUCTION !| fonction | procedure )* main ;
	public final microC_ASTParser.programme_return programme() throws RecognitionException {
		microC_ASTParser.programme_return retval = new microC_ASTParser.programme_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token FIN_INSTRUCTION2=null;
		Token FIN_INSTRUCTION4=null;
		ParserRuleReturnScope declaration1 =null;
		ParserRuleReturnScope affectation3 =null;
		ParserRuleReturnScope fonction5 =null;
		ParserRuleReturnScope procedure6 =null;
		ParserRuleReturnScope main7 =null;

		CommonTree FIN_INSTRUCTION2_tree=null;
		CommonTree FIN_INSTRUCTION4_tree=null;

		try {
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:30:11: ( ( declaration FIN_INSTRUCTION !| affectation FIN_INSTRUCTION !| fonction | procedure )* main )
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:30:13: ( declaration FIN_INSTRUCTION !| affectation FIN_INSTRUCTION !| fonction | procedure )* main
			{
			root_0 = (CommonTree)adaptor.nil();


			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:30:13: ( declaration FIN_INSTRUCTION !| affectation FIN_INSTRUCTION !| fonction | procedure )*
			loop1:
			while (true) {
				int alt1=5;
				switch ( input.LA(1) ) {
				case 59:
					{
					int LA1_1 = input.LA(2);
					if ( (LA1_1==38) ) {
						int LA1_5 = input.LA(3);
						if ( (LA1_5==38) ) {
							int LA1_10 = input.LA(4);
							if ( (LA1_10==IDENTIFIANT) ) {
								int LA1_7 = input.LA(5);
								if ( (LA1_7==FIN_INSTRUCTION||LA1_7==42||LA1_7==49||LA1_7==53) ) {
									alt1=1;
								}
								else if ( (LA1_7==36) ) {
									alt1=3;
								}

							}

						}
						else if ( (LA1_5==IDENTIFIANT) ) {
							int LA1_7 = input.LA(4);
							if ( (LA1_7==FIN_INSTRUCTION||LA1_7==42||LA1_7==49||LA1_7==53) ) {
								alt1=1;
							}
							else if ( (LA1_7==36) ) {
								alt1=3;
							}

						}

					}
					else if ( (LA1_1==IDENTIFIANT) ) {
						int LA1_7 = input.LA(3);
						if ( (LA1_7==FIN_INSTRUCTION||LA1_7==42||LA1_7==49||LA1_7==53) ) {
							alt1=1;
						}
						else if ( (LA1_7==36) ) {
							alt1=3;
						}

					}

					}
					break;
				case 62:
					{
					int LA1_2 = input.LA(2);
					if ( (LA1_2==IDENTIFIANT) ) {
						alt1=4;
					}

					}
					break;
				case 55:
					{
					int LA1_3 = input.LA(2);
					if ( (LA1_3==38) ) {
						int LA1_9 = input.LA(3);
						if ( (LA1_9==38) ) {
							int LA1_13 = input.LA(4);
							if ( (LA1_13==IDENTIFIANT) ) {
								int LA1_7 = input.LA(5);
								if ( (LA1_7==FIN_INSTRUCTION||LA1_7==42||LA1_7==49||LA1_7==53) ) {
									alt1=1;
								}
								else if ( (LA1_7==36) ) {
									alt1=3;
								}

							}

						}
						else if ( (LA1_9==IDENTIFIANT) ) {
							int LA1_7 = input.LA(4);
							if ( (LA1_7==FIN_INSTRUCTION||LA1_7==42||LA1_7==49||LA1_7==53) ) {
								alt1=1;
							}
							else if ( (LA1_7==36) ) {
								alt1=3;
							}

						}

					}
					else if ( (LA1_3==IDENTIFIANT) ) {
						int LA1_7 = input.LA(3);
						if ( (LA1_7==FIN_INSTRUCTION||LA1_7==42||LA1_7==49||LA1_7==53) ) {
							alt1=1;
						}
						else if ( (LA1_7==36) ) {
							alt1=3;
						}

					}

					}
					break;
				case IDENTIFIANT:
				case 38:
					{
					alt1=2;
					}
					break;
				}
				switch (alt1) {
				case 1 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:30:14: declaration FIN_INSTRUCTION !
					{
					pushFollow(FOLLOW_declaration_in_programme115);
					declaration1=declaration();
					state._fsp--;

					adaptor.addChild(root_0, declaration1.getTree());

					FIN_INSTRUCTION2=(Token)match(input,FIN_INSTRUCTION,FOLLOW_FIN_INSTRUCTION_in_programme117); 
					}
					break;
				case 2 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:30:43: affectation FIN_INSTRUCTION !
					{
					pushFollow(FOLLOW_affectation_in_programme120);
					affectation3=affectation();
					state._fsp--;

					adaptor.addChild(root_0, affectation3.getTree());

					FIN_INSTRUCTION4=(Token)match(input,FIN_INSTRUCTION,FOLLOW_FIN_INSTRUCTION_in_programme122); 
					}
					break;
				case 3 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:30:72: fonction
					{
					pushFollow(FOLLOW_fonction_in_programme125);
					fonction5=fonction();
					state._fsp--;

					adaptor.addChild(root_0, fonction5.getTree());

					}
					break;
				case 4 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:30:81: procedure
					{
					pushFollow(FOLLOW_procedure_in_programme127);
					procedure6=procedure();
					state._fsp--;

					adaptor.addChild(root_0, procedure6.getTree());

					}
					break;

				default :
					break loop1;
				}
			}

			pushFollow(FOLLOW_main_in_programme131);
			main7=main();
			state._fsp--;

			adaptor.addChild(root_0, main7.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "programme"


	public static class main_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "main"
	// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:33:1: main : type_all 'main' '(' ')' bloc_complexe -> ^( MAIN type_all bloc_complexe ) ;
	public final microC_ASTParser.main_return main() throws RecognitionException {
		microC_ASTParser.main_return retval = new microC_ASTParser.main_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal9=null;
		Token char_literal10=null;
		Token char_literal11=null;
		ParserRuleReturnScope type_all8 =null;
		ParserRuleReturnScope bloc_complexe12 =null;

		CommonTree string_literal9_tree=null;
		CommonTree char_literal10_tree=null;
		CommonTree char_literal11_tree=null;
		RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
		RewriteRuleSubtreeStream stream_bloc_complexe=new RewriteRuleSubtreeStream(adaptor,"rule bloc_complexe");
		RewriteRuleSubtreeStream stream_type_all=new RewriteRuleSubtreeStream(adaptor,"rule type_all");

		try {
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:33:6: ( type_all 'main' '(' ')' bloc_complexe -> ^( MAIN type_all bloc_complexe ) )
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:33:8: type_all 'main' '(' ')' bloc_complexe
			{
			pushFollow(FOLLOW_type_all_in_main141);
			type_all8=type_all();
			state._fsp--;

			stream_type_all.add(type_all8.getTree());
			string_literal9=(Token)match(input,60,FOLLOW_60_in_main143);  
			stream_60.add(string_literal9);

			char_literal10=(Token)match(input,36,FOLLOW_36_in_main145);  
			stream_36.add(char_literal10);

			char_literal11=(Token)match(input,37,FOLLOW_37_in_main147);  
			stream_37.add(char_literal11);

			pushFollow(FOLLOW_bloc_complexe_in_main149);
			bloc_complexe12=bloc_complexe();
			state._fsp--;

			stream_bloc_complexe.add(bloc_complexe12.getTree());
			// AST REWRITE
			// elements: bloc_complexe, type_all
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 33:46: -> ^( MAIN type_all bloc_complexe )
			{
				// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:33:49: ^( MAIN type_all bloc_complexe )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(MAIN, "MAIN"), root_1);
				adaptor.addChild(root_1, stream_type_all.nextTree());
				adaptor.addChild(root_1, stream_bloc_complexe.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "main"


	public static class bloc_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "bloc"
	// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:37:1: bloc : ( bloc_simple | bloc_complexe );
	public final microC_ASTParser.bloc_return bloc() throws RecognitionException {
		microC_ASTParser.bloc_return retval = new microC_ASTParser.bloc_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope bloc_simple13 =null;
		ParserRuleReturnScope bloc_complexe14 =null;


		try {
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:37:6: ( bloc_simple | bloc_complexe )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==IDENTIFIANT||LA2_0==38||LA2_0==55||(LA2_0 >= 57 && LA2_0 <= 59)||LA2_0==61||LA2_0==63) ) {
				alt2=1;
			}
			else if ( (LA2_0==64) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:37:8: bloc_simple
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_bloc_simple_in_bloc170);
					bloc_simple13=bloc_simple();
					state._fsp--;

					adaptor.addChild(root_0, bloc_simple13.getTree());

					}
					break;
				case 2 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:38:4: bloc_complexe
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_bloc_complexe_in_bloc175);
					bloc_complexe14=bloc_complexe();
					state._fsp--;

					adaptor.addChild(root_0, bloc_complexe14.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "bloc"


	public static class bloc_simple_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "bloc_simple"
	// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:41:1: bloc_simple : instruction -> ^( BLOC instruction ) ;
	public final microC_ASTParser.bloc_simple_return bloc_simple() throws RecognitionException {
		microC_ASTParser.bloc_simple_return retval = new microC_ASTParser.bloc_simple_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope instruction15 =null;

		RewriteRuleSubtreeStream stream_instruction=new RewriteRuleSubtreeStream(adaptor,"rule instruction");

		try {
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:42:2: ( instruction -> ^( BLOC instruction ) )
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:42:4: instruction
			{
			pushFollow(FOLLOW_instruction_in_bloc_simple186);
			instruction15=instruction();
			state._fsp--;

			stream_instruction.add(instruction15.getTree());
			// AST REWRITE
			// elements: instruction
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 42:17: -> ^( BLOC instruction )
			{
				// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:42:20: ^( BLOC instruction )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BLOC, "BLOC"), root_1);
				adaptor.addChild(root_1, stream_instruction.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "bloc_simple"


	public static class bloc_complexe_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "bloc_complexe"
	// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:45:1: bloc_complexe : '{' ( instruction )* '}' -> ^( BLOC ( instruction )* ) ;
	public final microC_ASTParser.bloc_complexe_return bloc_complexe() throws RecognitionException {
		microC_ASTParser.bloc_complexe_return retval = new microC_ASTParser.bloc_complexe_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal16=null;
		Token char_literal18=null;
		ParserRuleReturnScope instruction17 =null;

		CommonTree char_literal16_tree=null;
		CommonTree char_literal18_tree=null;
		RewriteRuleTokenStream stream_66=new RewriteRuleTokenStream(adaptor,"token 66");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleSubtreeStream stream_instruction=new RewriteRuleSubtreeStream(adaptor,"rule instruction");

		try {
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:46:2: ( '{' ( instruction )* '}' -> ^( BLOC ( instruction )* ) )
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:46:4: '{' ( instruction )* '}'
			{
			char_literal16=(Token)match(input,64,FOLLOW_64_in_bloc_complexe206);  
			stream_64.add(char_literal16);

			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:46:8: ( instruction )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==IDENTIFIANT||LA3_0==38||LA3_0==55||(LA3_0 >= 57 && LA3_0 <= 59)||LA3_0==61||LA3_0==63) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:46:8: instruction
					{
					pushFollow(FOLLOW_instruction_in_bloc_complexe208);
					instruction17=instruction();
					state._fsp--;

					stream_instruction.add(instruction17.getTree());
					}
					break;

				default :
					break loop3;
				}
			}

			char_literal18=(Token)match(input,66,FOLLOW_66_in_bloc_complexe211);  
			stream_66.add(char_literal18);

			// AST REWRITE
			// elements: instruction
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 46:26: -> ^( BLOC ( instruction )* )
			{
				// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:46:29: ^( BLOC ( instruction )* )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BLOC, "BLOC"), root_1);
				// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:46:36: ( instruction )*
				while ( stream_instruction.hasNext() ) {
					adaptor.addChild(root_1, stream_instruction.nextTree());
				}
				stream_instruction.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "bloc_complexe"


	public static class instruction_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "instruction"
	// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:50:1: instruction : ( condition | boucle | affectation FIN_INSTRUCTION !| declaration FIN_INSTRUCTION !| appel_fonction_procedure FIN_INSTRUCTION !| retour FIN_INSTRUCTION !);
	public final microC_ASTParser.instruction_return instruction() throws RecognitionException {
		microC_ASTParser.instruction_return retval = new microC_ASTParser.instruction_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token FIN_INSTRUCTION22=null;
		Token FIN_INSTRUCTION24=null;
		Token FIN_INSTRUCTION26=null;
		Token FIN_INSTRUCTION28=null;
		ParserRuleReturnScope condition19 =null;
		ParserRuleReturnScope boucle20 =null;
		ParserRuleReturnScope affectation21 =null;
		ParserRuleReturnScope declaration23 =null;
		ParserRuleReturnScope appel_fonction_procedure25 =null;
		ParserRuleReturnScope retour27 =null;

		CommonTree FIN_INSTRUCTION22_tree=null;
		CommonTree FIN_INSTRUCTION24_tree=null;
		CommonTree FIN_INSTRUCTION26_tree=null;
		CommonTree FIN_INSTRUCTION28_tree=null;

		try {
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:51:2: ( condition | boucle | affectation FIN_INSTRUCTION !| declaration FIN_INSTRUCTION !| appel_fonction_procedure FIN_INSTRUCTION !| retour FIN_INSTRUCTION !)
			int alt4=6;
			switch ( input.LA(1) ) {
			case 58:
				{
				alt4=1;
				}
				break;
			case 57:
			case 63:
				{
				alt4=2;
				}
				break;
			case IDENTIFIANT:
				{
				int LA4_3 = input.LA(2);
				if ( (LA4_3==39||LA4_3==41||LA4_3==44||LA4_3==46||LA4_3==49||LA4_3==53) ) {
					alt4=3;
				}
				else if ( (LA4_3==36) ) {
					alt4=5;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 4, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 38:
				{
				alt4=3;
				}
				break;
			case 55:
			case 59:
				{
				alt4=4;
				}
				break;
			case 61:
				{
				alt4=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}
			switch (alt4) {
				case 1 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:51:4: condition
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_condition_in_instruction233);
					condition19=condition();
					state._fsp--;

					adaptor.addChild(root_0, condition19.getTree());

					}
					break;
				case 2 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:52:4: boucle
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_boucle_in_instruction238);
					boucle20=boucle();
					state._fsp--;

					adaptor.addChild(root_0, boucle20.getTree());

					}
					break;
				case 3 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:53:4: affectation FIN_INSTRUCTION !
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_affectation_in_instruction243);
					affectation21=affectation();
					state._fsp--;

					adaptor.addChild(root_0, affectation21.getTree());

					FIN_INSTRUCTION22=(Token)match(input,FIN_INSTRUCTION,FOLLOW_FIN_INSTRUCTION_in_instruction245); 
					}
					break;
				case 4 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:54:4: declaration FIN_INSTRUCTION !
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_declaration_in_instruction251);
					declaration23=declaration();
					state._fsp--;

					adaptor.addChild(root_0, declaration23.getTree());

					FIN_INSTRUCTION24=(Token)match(input,FIN_INSTRUCTION,FOLLOW_FIN_INSTRUCTION_in_instruction253); 
					}
					break;
				case 5 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:55:4: appel_fonction_procedure FIN_INSTRUCTION !
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_appel_fonction_procedure_in_instruction259);
					appel_fonction_procedure25=appel_fonction_procedure();
					state._fsp--;

					adaptor.addChild(root_0, appel_fonction_procedure25.getTree());

					FIN_INSTRUCTION26=(Token)match(input,FIN_INSTRUCTION,FOLLOW_FIN_INSTRUCTION_in_instruction261); 
					}
					break;
				case 6 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:56:4: retour FIN_INSTRUCTION !
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_retour_in_instruction267);
					retour27=retour();
					state._fsp--;

					adaptor.addChild(root_0, retour27.getTree());

					FIN_INSTRUCTION28=(Token)match(input,FIN_INSTRUCTION,FOLLOW_FIN_INSTRUCTION_in_instruction269); 
					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "instruction"


	public static class declaration_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "declaration"
	// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:61:1: declaration : ( type_affect var ( ',' var )* -> ( ^( DECL type_affect var ) )+ | type_affect affectation_bis -> ^( DECL type_affect affectation_bis ) );
	public final microC_ASTParser.declaration_return declaration() throws RecognitionException {
		microC_ASTParser.declaration_return retval = new microC_ASTParser.declaration_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal31=null;
		ParserRuleReturnScope type_affect29 =null;
		ParserRuleReturnScope var30 =null;
		ParserRuleReturnScope var32 =null;
		ParserRuleReturnScope type_affect33 =null;
		ParserRuleReturnScope affectation_bis34 =null;

		CommonTree char_literal31_tree=null;
		RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");
		RewriteRuleSubtreeStream stream_affectation_bis=new RewriteRuleSubtreeStream(adaptor,"rule affectation_bis");
		RewriteRuleSubtreeStream stream_var=new RewriteRuleSubtreeStream(adaptor,"rule var");
		RewriteRuleSubtreeStream stream_type_affect=new RewriteRuleSubtreeStream(adaptor,"rule type_affect");

		try {
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:62:2: ( type_affect var ( ',' var )* -> ( ^( DECL type_affect var ) )+ | type_affect affectation_bis -> ^( DECL type_affect affectation_bis ) )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==59) ) {
				int LA6_1 = input.LA(2);
				if ( (LA6_1==38) ) {
					int LA6_3 = input.LA(3);
					if ( (LA6_3==38) ) {
						int LA6_6 = input.LA(4);
						if ( (LA6_6==IDENTIFIANT) ) {
							switch ( input.LA(5) ) {
							case 49:
								{
								alt6=2;
								}
								break;
							case 53:
								{
								int LA6_8 = input.LA(6);
								if ( (LA6_8==CHIFFRES) ) {
									int LA6_11 = input.LA(7);
									if ( (LA6_11==54) ) {
										int LA6_12 = input.LA(8);
										if ( (LA6_12==FIN_INSTRUCTION||LA6_12==42) ) {
											alt6=1;
										}
										else if ( (LA6_12==49) ) {
											alt6=2;
										}

										else {
											int nvaeMark = input.mark();
											try {
												for (int nvaeConsume = 0; nvaeConsume < 8 - 1; nvaeConsume++) {
													input.consume();
												}
												NoViableAltException nvae =
													new NoViableAltException("", 6, 12, input);
												throw nvae;
											} finally {
												input.rewind(nvaeMark);
											}
										}

									}

									else {
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 6, 11, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

								}

								else {
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 6, 8, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

								}
								break;
							case FIN_INSTRUCTION:
							case 42:
								{
								alt6=1;
								}
								break;
							default:
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 6, 4, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 6, 6, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}
					else if ( (LA6_3==IDENTIFIANT) ) {
						switch ( input.LA(4) ) {
						case 49:
							{
							alt6=2;
							}
							break;
						case 53:
							{
							int LA6_8 = input.LA(5);
							if ( (LA6_8==CHIFFRES) ) {
								int LA6_11 = input.LA(6);
								if ( (LA6_11==54) ) {
									int LA6_12 = input.LA(7);
									if ( (LA6_12==FIN_INSTRUCTION||LA6_12==42) ) {
										alt6=1;
									}
									else if ( (LA6_12==49) ) {
										alt6=2;
									}

									else {
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 6, 12, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

								}

								else {
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 6, 11, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}

							else {
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 6, 8, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

							}
							break;
						case FIN_INSTRUCTION:
						case 42:
							{
							alt6=1;
							}
							break;
						default:
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 6, 4, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 6, 3, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA6_1==IDENTIFIANT) ) {
					switch ( input.LA(3) ) {
					case 49:
						{
						alt6=2;
						}
						break;
					case 53:
						{
						int LA6_8 = input.LA(4);
						if ( (LA6_8==CHIFFRES) ) {
							int LA6_11 = input.LA(5);
							if ( (LA6_11==54) ) {
								int LA6_12 = input.LA(6);
								if ( (LA6_12==FIN_INSTRUCTION||LA6_12==42) ) {
									alt6=1;
								}
								else if ( (LA6_12==49) ) {
									alt6=2;
								}

								else {
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 6, 12, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}

							else {
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 6, 11, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 6, 8, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case FIN_INSTRUCTION:
					case 42:
						{
						alt6=1;
						}
						break;
					default:
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 6, 4, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 6, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA6_0==55) ) {
				int LA6_2 = input.LA(2);
				if ( (LA6_2==38) ) {
					int LA6_5 = input.LA(3);
					if ( (LA6_5==38) ) {
						int LA6_10 = input.LA(4);
						if ( (LA6_10==IDENTIFIANT) ) {
							switch ( input.LA(5) ) {
							case 49:
								{
								alt6=2;
								}
								break;
							case 53:
								{
								int LA6_8 = input.LA(6);
								if ( (LA6_8==CHIFFRES) ) {
									int LA6_11 = input.LA(7);
									if ( (LA6_11==54) ) {
										int LA6_12 = input.LA(8);
										if ( (LA6_12==FIN_INSTRUCTION||LA6_12==42) ) {
											alt6=1;
										}
										else if ( (LA6_12==49) ) {
											alt6=2;
										}

										else {
											int nvaeMark = input.mark();
											try {
												for (int nvaeConsume = 0; nvaeConsume < 8 - 1; nvaeConsume++) {
													input.consume();
												}
												NoViableAltException nvae =
													new NoViableAltException("", 6, 12, input);
												throw nvae;
											} finally {
												input.rewind(nvaeMark);
											}
										}

									}

									else {
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 6, 11, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

								}

								else {
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 6, 8, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

								}
								break;
							case FIN_INSTRUCTION:
							case 42:
								{
								alt6=1;
								}
								break;
							default:
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 6, 4, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 6, 10, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}
					else if ( (LA6_5==IDENTIFIANT) ) {
						switch ( input.LA(4) ) {
						case 49:
							{
							alt6=2;
							}
							break;
						case 53:
							{
							int LA6_8 = input.LA(5);
							if ( (LA6_8==CHIFFRES) ) {
								int LA6_11 = input.LA(6);
								if ( (LA6_11==54) ) {
									int LA6_12 = input.LA(7);
									if ( (LA6_12==FIN_INSTRUCTION||LA6_12==42) ) {
										alt6=1;
									}
									else if ( (LA6_12==49) ) {
										alt6=2;
									}

									else {
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 6, 12, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

								}

								else {
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 6, 11, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}

							else {
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 6, 8, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

							}
							break;
						case FIN_INSTRUCTION:
						case 42:
							{
							alt6=1;
							}
							break;
						default:
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 6, 4, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 6, 5, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA6_2==IDENTIFIANT) ) {
					switch ( input.LA(3) ) {
					case 49:
						{
						alt6=2;
						}
						break;
					case 53:
						{
						int LA6_8 = input.LA(4);
						if ( (LA6_8==CHIFFRES) ) {
							int LA6_11 = input.LA(5);
							if ( (LA6_11==54) ) {
								int LA6_12 = input.LA(6);
								if ( (LA6_12==FIN_INSTRUCTION||LA6_12==42) ) {
									alt6=1;
								}
								else if ( (LA6_12==49) ) {
									alt6=2;
								}

								else {
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 6, 12, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}

							else {
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 6, 11, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 6, 8, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case FIN_INSTRUCTION:
					case 42:
						{
						alt6=1;
						}
						break;
					default:
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 6, 4, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 6, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:62:4: type_affect var ( ',' var )*
					{
					pushFollow(FOLLOW_type_affect_in_declaration284);
					type_affect29=type_affect();
					state._fsp--;

					stream_type_affect.add(type_affect29.getTree());
					pushFollow(FOLLOW_var_in_declaration286);
					var30=var();
					state._fsp--;

					stream_var.add(var30.getTree());
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:62:20: ( ',' var )*
					loop5:
					while (true) {
						int alt5=2;
						int LA5_0 = input.LA(1);
						if ( (LA5_0==42) ) {
							alt5=1;
						}

						switch (alt5) {
						case 1 :
							// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:62:22: ',' var
							{
							char_literal31=(Token)match(input,42,FOLLOW_42_in_declaration290);  
							stream_42.add(char_literal31);

							pushFollow(FOLLOW_var_in_declaration292);
							var32=var();
							state._fsp--;

							stream_var.add(var32.getTree());
							}
							break;

						default :
							break loop5;
						}
					}

					// AST REWRITE
					// elements: var, type_affect
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 62:32: -> ( ^( DECL type_affect var ) )+
					{
						if ( !(stream_var.hasNext()||stream_type_affect.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_var.hasNext()||stream_type_affect.hasNext() ) {
							// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:62:35: ^( DECL type_affect var )
							{
							CommonTree root_1 = (CommonTree)adaptor.nil();
							root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DECL, "DECL"), root_1);
							adaptor.addChild(root_1, stream_type_affect.nextTree());
							adaptor.addChild(root_1, stream_var.nextTree());
							adaptor.addChild(root_0, root_1);
							}

						}
						stream_var.reset();
						stream_type_affect.reset();

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:63:4: type_affect affectation_bis
					{
					pushFollow(FOLLOW_type_affect_in_declaration310);
					type_affect33=type_affect();
					state._fsp--;

					stream_type_affect.add(type_affect33.getTree());
					pushFollow(FOLLOW_affectation_bis_in_declaration312);
					affectation_bis34=affectation_bis();
					state._fsp--;

					stream_affectation_bis.add(affectation_bis34.getTree());
					// AST REWRITE
					// elements: affectation_bis, type_affect
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 63:32: -> ^( DECL type_affect affectation_bis )
					{
						// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:63:35: ^( DECL type_affect affectation_bis )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DECL, "DECL"), root_1);
						adaptor.addChild(root_1, stream_type_affect.nextTree());
						adaptor.addChild(root_1, stream_affectation_bis.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "declaration"


	public static class var_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "var"
	// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:66:1: var : ( IDENTIFIANT tableau -> ^( TABLEAU IDENTIFIANT tableau ) | IDENTIFIANT ^);
	public final microC_ASTParser.var_return var() throws RecognitionException {
		microC_ASTParser.var_return retval = new microC_ASTParser.var_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENTIFIANT35=null;
		Token IDENTIFIANT37=null;
		ParserRuleReturnScope tableau36 =null;

		CommonTree IDENTIFIANT35_tree=null;
		CommonTree IDENTIFIANT37_tree=null;
		RewriteRuleTokenStream stream_IDENTIFIANT=new RewriteRuleTokenStream(adaptor,"token IDENTIFIANT");
		RewriteRuleSubtreeStream stream_tableau=new RewriteRuleSubtreeStream(adaptor,"rule tableau");

		try {
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:66:5: ( IDENTIFIANT tableau -> ^( TABLEAU IDENTIFIANT tableau ) | IDENTIFIANT ^)
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==IDENTIFIANT) ) {
				int LA7_1 = input.LA(2);
				if ( (LA7_1==53) ) {
					alt7=1;
				}
				else if ( (LA7_1==FIN_INSTRUCTION||LA7_1==42) ) {
					alt7=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 7, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:66:7: IDENTIFIANT tableau
					{
					IDENTIFIANT35=(Token)match(input,IDENTIFIANT,FOLLOW_IDENTIFIANT_in_var333);  
					stream_IDENTIFIANT.add(IDENTIFIANT35);

					pushFollow(FOLLOW_tableau_in_var335);
					tableau36=tableau();
					state._fsp--;

					stream_tableau.add(tableau36.getTree());
					// AST REWRITE
					// elements: tableau, IDENTIFIANT
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 66:28: -> ^( TABLEAU IDENTIFIANT tableau )
					{
						// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:66:31: ^( TABLEAU IDENTIFIANT tableau )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TABLEAU, "TABLEAU"), root_1);
						adaptor.addChild(root_1, stream_IDENTIFIANT.nextNode());
						adaptor.addChild(root_1, stream_tableau.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:67:4: IDENTIFIANT ^
					{
					root_0 = (CommonTree)adaptor.nil();


					IDENTIFIANT37=(Token)match(input,IDENTIFIANT,FOLLOW_IDENTIFIANT_in_var351); 
					IDENTIFIANT37_tree = (CommonTree)adaptor.create(IDENTIFIANT37);
					root_0 = (CommonTree)adaptor.becomeRoot(IDENTIFIANT37_tree, root_0);

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "var"


	public static class affectation_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "affectation"
	// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:71:1: affectation : ( IDENTIFIANT operateur_affectation expression -> ^( AFFECT ^( operateur_affectation IDENTIFIANT expression ) ) | pointeur operateur_affectation expression -> ^( AFFECT ^( operateur_affectation ^( PTR pointeur ) expression ) ) | acces_tableau operateur_affectation expression -> ^( AFFECT ^( operateur_affectation acces_tableau expression ) ) );
	public final microC_ASTParser.affectation_return affectation() throws RecognitionException {
		microC_ASTParser.affectation_return retval = new microC_ASTParser.affectation_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENTIFIANT38=null;
		ParserRuleReturnScope operateur_affectation39 =null;
		ParserRuleReturnScope expression40 =null;
		ParserRuleReturnScope pointeur41 =null;
		ParserRuleReturnScope operateur_affectation42 =null;
		ParserRuleReturnScope expression43 =null;
		ParserRuleReturnScope acces_tableau44 =null;
		ParserRuleReturnScope operateur_affectation45 =null;
		ParserRuleReturnScope expression46 =null;

		CommonTree IDENTIFIANT38_tree=null;
		RewriteRuleTokenStream stream_IDENTIFIANT=new RewriteRuleTokenStream(adaptor,"token IDENTIFIANT");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_pointeur=new RewriteRuleSubtreeStream(adaptor,"rule pointeur");
		RewriteRuleSubtreeStream stream_acces_tableau=new RewriteRuleSubtreeStream(adaptor,"rule acces_tableau");
		RewriteRuleSubtreeStream stream_operateur_affectation=new RewriteRuleSubtreeStream(adaptor,"rule operateur_affectation");

		try {
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:72:2: ( IDENTIFIANT operateur_affectation expression -> ^( AFFECT ^( operateur_affectation IDENTIFIANT expression ) ) | pointeur operateur_affectation expression -> ^( AFFECT ^( operateur_affectation ^( PTR pointeur ) expression ) ) | acces_tableau operateur_affectation expression -> ^( AFFECT ^( operateur_affectation acces_tableau expression ) ) )
			int alt8=3;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==IDENTIFIANT) ) {
				int LA8_1 = input.LA(2);
				if ( (LA8_1==53) ) {
					alt8=3;
				}
				else if ( (LA8_1==39||LA8_1==41||LA8_1==44||LA8_1==46||LA8_1==49) ) {
					alt8=1;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 8, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA8_0==38) ) {
				alt8=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:72:4: IDENTIFIANT operateur_affectation expression
					{
					IDENTIFIANT38=(Token)match(input,IDENTIFIANT,FOLLOW_IDENTIFIANT_in_affectation365);  
					stream_IDENTIFIANT.add(IDENTIFIANT38);

					pushFollow(FOLLOW_operateur_affectation_in_affectation367);
					operateur_affectation39=operateur_affectation();
					state._fsp--;

					stream_operateur_affectation.add(operateur_affectation39.getTree());
					pushFollow(FOLLOW_expression_in_affectation369);
					expression40=expression();
					state._fsp--;

					stream_expression.add(expression40.getTree());
					// AST REWRITE
					// elements: IDENTIFIANT, operateur_affectation, expression
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 72:49: -> ^( AFFECT ^( operateur_affectation IDENTIFIANT expression ) )
					{
						// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:72:52: ^( AFFECT ^( operateur_affectation IDENTIFIANT expression ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AFFECT, "AFFECT"), root_1);
						// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:72:61: ^( operateur_affectation IDENTIFIANT expression )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot(stream_operateur_affectation.nextNode(), root_2);
						adaptor.addChild(root_2, stream_IDENTIFIANT.nextNode());
						adaptor.addChild(root_2, stream_expression.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:73:4: pointeur operateur_affectation expression
					{
					pushFollow(FOLLOW_pointeur_in_affectation388);
					pointeur41=pointeur();
					state._fsp--;

					stream_pointeur.add(pointeur41.getTree());
					pushFollow(FOLLOW_operateur_affectation_in_affectation390);
					operateur_affectation42=operateur_affectation();
					state._fsp--;

					stream_operateur_affectation.add(operateur_affectation42.getTree());
					pushFollow(FOLLOW_expression_in_affectation392);
					expression43=expression();
					state._fsp--;

					stream_expression.add(expression43.getTree());
					// AST REWRITE
					// elements: pointeur, expression, operateur_affectation
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 73:46: -> ^( AFFECT ^( operateur_affectation ^( PTR pointeur ) expression ) )
					{
						// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:73:49: ^( AFFECT ^( operateur_affectation ^( PTR pointeur ) expression ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AFFECT, "AFFECT"), root_1);
						// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:73:58: ^( operateur_affectation ^( PTR pointeur ) expression )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot(stream_operateur_affectation.nextNode(), root_2);
						// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:73:82: ^( PTR pointeur )
						{
						CommonTree root_3 = (CommonTree)adaptor.nil();
						root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PTR, "PTR"), root_3);
						adaptor.addChild(root_3, stream_pointeur.nextTree());
						adaptor.addChild(root_2, root_3);
						}

						adaptor.addChild(root_2, stream_expression.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 3 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:74:4: acces_tableau operateur_affectation expression
					{
					pushFollow(FOLLOW_acces_tableau_in_affectation415);
					acces_tableau44=acces_tableau();
					state._fsp--;

					stream_acces_tableau.add(acces_tableau44.getTree());
					pushFollow(FOLLOW_operateur_affectation_in_affectation417);
					operateur_affectation45=operateur_affectation();
					state._fsp--;

					stream_operateur_affectation.add(operateur_affectation45.getTree());
					pushFollow(FOLLOW_expression_in_affectation419);
					expression46=expression();
					state._fsp--;

					stream_expression.add(expression46.getTree());
					// AST REWRITE
					// elements: operateur_affectation, expression, acces_tableau
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 74:51: -> ^( AFFECT ^( operateur_affectation acces_tableau expression ) )
					{
						// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:74:54: ^( AFFECT ^( operateur_affectation acces_tableau expression ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AFFECT, "AFFECT"), root_1);
						// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:74:63: ^( operateur_affectation acces_tableau expression )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot(stream_operateur_affectation.nextNode(), root_2);
						adaptor.addChild(root_2, stream_acces_tableau.nextTree());
						adaptor.addChild(root_2, stream_expression.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "affectation"


	public static class affectation_bis_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "affectation_bis"
	// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:77:1: affectation_bis : ( IDENTIFIANT '=' expression -> ^( AFFECT ^( '=' IDENTIFIANT expression ) ) | IDENTIFIANT tableau '=' '{' parametres_appel '}' -> ^( AFFECT ^( '=' ^( TABLEAU IDENTIFIANT tableau ) parametres_appel ) ) );
	public final microC_ASTParser.affectation_bis_return affectation_bis() throws RecognitionException {
		microC_ASTParser.affectation_bis_return retval = new microC_ASTParser.affectation_bis_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENTIFIANT47=null;
		Token char_literal48=null;
		Token IDENTIFIANT50=null;
		Token char_literal52=null;
		Token char_literal53=null;
		Token char_literal55=null;
		ParserRuleReturnScope expression49 =null;
		ParserRuleReturnScope tableau51 =null;
		ParserRuleReturnScope parametres_appel54 =null;

		CommonTree IDENTIFIANT47_tree=null;
		CommonTree char_literal48_tree=null;
		CommonTree IDENTIFIANT50_tree=null;
		CommonTree char_literal52_tree=null;
		CommonTree char_literal53_tree=null;
		CommonTree char_literal55_tree=null;
		RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
		RewriteRuleTokenStream stream_66=new RewriteRuleTokenStream(adaptor,"token 66");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_IDENTIFIANT=new RewriteRuleTokenStream(adaptor,"token IDENTIFIANT");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_tableau=new RewriteRuleSubtreeStream(adaptor,"rule tableau");
		RewriteRuleSubtreeStream stream_parametres_appel=new RewriteRuleSubtreeStream(adaptor,"rule parametres_appel");

		try {
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:78:2: ( IDENTIFIANT '=' expression -> ^( AFFECT ^( '=' IDENTIFIANT expression ) ) | IDENTIFIANT tableau '=' '{' parametres_appel '}' -> ^( AFFECT ^( '=' ^( TABLEAU IDENTIFIANT tableau ) parametres_appel ) ) )
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==IDENTIFIANT) ) {
				int LA9_1 = input.LA(2);
				if ( (LA9_1==49) ) {
					alt9=1;
				}
				else if ( (LA9_1==53) ) {
					alt9=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 9, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:78:4: IDENTIFIANT '=' expression
					{
					IDENTIFIANT47=(Token)match(input,IDENTIFIANT,FOLLOW_IDENTIFIANT_in_affectation_bis444);  
					stream_IDENTIFIANT.add(IDENTIFIANT47);

					char_literal48=(Token)match(input,49,FOLLOW_49_in_affectation_bis446);  
					stream_49.add(char_literal48);

					pushFollow(FOLLOW_expression_in_affectation_bis448);
					expression49=expression();
					state._fsp--;

					stream_expression.add(expression49.getTree());
					// AST REWRITE
					// elements: expression, IDENTIFIANT, 49
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 78:31: -> ^( AFFECT ^( '=' IDENTIFIANT expression ) )
					{
						// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:78:34: ^( AFFECT ^( '=' IDENTIFIANT expression ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AFFECT, "AFFECT"), root_1);
						// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:78:43: ^( '=' IDENTIFIANT expression )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot(stream_49.nextNode(), root_2);
						adaptor.addChild(root_2, stream_IDENTIFIANT.nextNode());
						adaptor.addChild(root_2, stream_expression.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:79:4: IDENTIFIANT tableau '=' '{' parametres_appel '}'
					{
					IDENTIFIANT50=(Token)match(input,IDENTIFIANT,FOLLOW_IDENTIFIANT_in_affectation_bis467);  
					stream_IDENTIFIANT.add(IDENTIFIANT50);

					pushFollow(FOLLOW_tableau_in_affectation_bis469);
					tableau51=tableau();
					state._fsp--;

					stream_tableau.add(tableau51.getTree());
					char_literal52=(Token)match(input,49,FOLLOW_49_in_affectation_bis471);  
					stream_49.add(char_literal52);

					char_literal53=(Token)match(input,64,FOLLOW_64_in_affectation_bis473);  
					stream_64.add(char_literal53);

					pushFollow(FOLLOW_parametres_appel_in_affectation_bis474);
					parametres_appel54=parametres_appel();
					state._fsp--;

					stream_parametres_appel.add(parametres_appel54.getTree());
					char_literal55=(Token)match(input,66,FOLLOW_66_in_affectation_bis475);  
					stream_66.add(char_literal55);

					// AST REWRITE
					// elements: tableau, parametres_appel, IDENTIFIANT, 49
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 79:51: -> ^( AFFECT ^( '=' ^( TABLEAU IDENTIFIANT tableau ) parametres_appel ) )
					{
						// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:79:54: ^( AFFECT ^( '=' ^( TABLEAU IDENTIFIANT tableau ) parametres_appel ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AFFECT, "AFFECT"), root_1);
						// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:79:63: ^( '=' ^( TABLEAU IDENTIFIANT tableau ) parametres_appel )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot(stream_49.nextNode(), root_2);
						// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:79:69: ^( TABLEAU IDENTIFIANT tableau )
						{
						CommonTree root_3 = (CommonTree)adaptor.nil();
						root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TABLEAU, "TABLEAU"), root_3);
						adaptor.addChild(root_3, stream_IDENTIFIANT.nextNode());
						adaptor.addChild(root_3, stream_tableau.nextTree());
						adaptor.addChild(root_2, root_3);
						}

						adaptor.addChild(root_2, stream_parametres_appel.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "affectation_bis"


	public static class tableau_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "tableau"
	// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:83:1: tableau : '[' CHIFFRES ']' -> ^( SIZE CHIFFRES ) ;
	public final microC_ASTParser.tableau_return tableau() throws RecognitionException {
		microC_ASTParser.tableau_return retval = new microC_ASTParser.tableau_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal56=null;
		Token CHIFFRES57=null;
		Token char_literal58=null;

		CommonTree char_literal56_tree=null;
		CommonTree CHIFFRES57_tree=null;
		CommonTree char_literal58_tree=null;
		RewriteRuleTokenStream stream_CHIFFRES=new RewriteRuleTokenStream(adaptor,"token CHIFFRES");
		RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
		RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");

		try {
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:83:9: ( '[' CHIFFRES ']' -> ^( SIZE CHIFFRES ) )
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:83:11: '[' CHIFFRES ']'
			{
			char_literal56=(Token)match(input,53,FOLLOW_53_in_tableau507);  
			stream_53.add(char_literal56);

			CHIFFRES57=(Token)match(input,CHIFFRES,FOLLOW_CHIFFRES_in_tableau509);  
			stream_CHIFFRES.add(CHIFFRES57);

			char_literal58=(Token)match(input,54,FOLLOW_54_in_tableau511);  
			stream_54.add(char_literal58);

			// AST REWRITE
			// elements: CHIFFRES
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 83:28: -> ^( SIZE CHIFFRES )
			{
				// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:83:31: ^( SIZE CHIFFRES )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SIZE, "SIZE"), root_1);
				adaptor.addChild(root_1, stream_CHIFFRES.nextNode());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "tableau"


	public static class operateur_affectation_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "operateur_affectation"
	// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:87:1: operateur_affectation : ( '=' | '*=' | '/=' | '+=' | '-=' );
	public final microC_ASTParser.operateur_affectation_return operateur_affectation() throws RecognitionException {
		microC_ASTParser.operateur_affectation_return retval = new microC_ASTParser.operateur_affectation_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set59=null;

		CommonTree set59_tree=null;

		try {
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:88:2: ( '=' | '*=' | '/=' | '+=' | '-=' )
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set59=input.LT(1);
			if ( input.LA(1)==39||input.LA(1)==41||input.LA(1)==44||input.LA(1)==46||input.LA(1)==49 ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set59));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "operateur_affectation"


	public static class appel_fonction_procedure_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "appel_fonction_procedure"
	// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:96:1: appel_fonction_procedure : IDENTIFIANT '(' parametres_appel ')' -> ^( CALL IDENTIFIANT parametres_appel ) ;
	public final microC_ASTParser.appel_fonction_procedure_return appel_fonction_procedure() throws RecognitionException {
		microC_ASTParser.appel_fonction_procedure_return retval = new microC_ASTParser.appel_fonction_procedure_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENTIFIANT60=null;
		Token char_literal61=null;
		Token char_literal63=null;
		ParserRuleReturnScope parametres_appel62 =null;

		CommonTree IDENTIFIANT60_tree=null;
		CommonTree char_literal61_tree=null;
		CommonTree char_literal63_tree=null;
		RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
		RewriteRuleTokenStream stream_IDENTIFIANT=new RewriteRuleTokenStream(adaptor,"token IDENTIFIANT");
		RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
		RewriteRuleSubtreeStream stream_parametres_appel=new RewriteRuleSubtreeStream(adaptor,"rule parametres_appel");

		try {
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:97:2: ( IDENTIFIANT '(' parametres_appel ')' -> ^( CALL IDENTIFIANT parametres_appel ) )
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:97:5: IDENTIFIANT '(' parametres_appel ')'
			{
			IDENTIFIANT60=(Token)match(input,IDENTIFIANT,FOLLOW_IDENTIFIANT_in_appel_fonction_procedure571);  
			stream_IDENTIFIANT.add(IDENTIFIANT60);

			char_literal61=(Token)match(input,36,FOLLOW_36_in_appel_fonction_procedure573);  
			stream_36.add(char_literal61);

			pushFollow(FOLLOW_parametres_appel_in_appel_fonction_procedure575);
			parametres_appel62=parametres_appel();
			state._fsp--;

			stream_parametres_appel.add(parametres_appel62.getTree());
			char_literal63=(Token)match(input,37,FOLLOW_37_in_appel_fonction_procedure577);  
			stream_37.add(char_literal63);

			// AST REWRITE
			// elements: parametres_appel, IDENTIFIANT
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 97:42: -> ^( CALL IDENTIFIANT parametres_appel )
			{
				// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:97:45: ^( CALL IDENTIFIANT parametres_appel )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CALL, "CALL"), root_1);
				adaptor.addChild(root_1, stream_IDENTIFIANT.nextNode());
				adaptor.addChild(root_1, stream_parametres_appel.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "appel_fonction_procedure"


	public static class parametres_appel_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "parametres_appel"
	// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:102:1: parametres_appel : ( expression )? ( ',' ( expression ) )* -> ^( PARAM ( expression )* ) ;
	public final microC_ASTParser.parametres_appel_return parametres_appel() throws RecognitionException {
		microC_ASTParser.parametres_appel_return retval = new microC_ASTParser.parametres_appel_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal65=null;
		ParserRuleReturnScope expression64 =null;
		ParserRuleReturnScope expression66 =null;

		CommonTree char_literal65_tree=null;
		RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");

		try {
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:103:2: ( ( expression )? ( ',' ( expression ) )* -> ^( PARAM ( expression )* ) )
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:103:4: ( expression )? ( ',' ( expression ) )*
			{
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:103:4: ( expression )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==CHIFFRES||LA10_0==IDENTIFIANT||LA10_0==LETTRE_QUOTE||LA10_0==32||(LA10_0 >= 35 && LA10_0 <= 36)||LA10_0==38||LA10_0==43) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:103:5: expression
					{
					pushFollow(FOLLOW_expression_in_parametres_appel602);
					expression64=expression();
					state._fsp--;

					stream_expression.add(expression64.getTree());
					}
					break;

			}

			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:103:18: ( ',' ( expression ) )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==42) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:103:19: ',' ( expression )
					{
					char_literal65=(Token)match(input,42,FOLLOW_42_in_parametres_appel607);  
					stream_42.add(char_literal65);

					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:103:23: ( expression )
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:103:24: expression
					{
					pushFollow(FOLLOW_expression_in_parametres_appel610);
					expression66=expression();
					state._fsp--;

					stream_expression.add(expression66.getTree());
					}

					}
					break;

				default :
					break loop11;
				}
			}

			// AST REWRITE
			// elements: expression
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 103:38: -> ^( PARAM ( expression )* )
			{
				// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:103:41: ^( PARAM ( expression )* )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PARAM, "PARAM"), root_1);
				// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:103:49: ( expression )*
				while ( stream_expression.hasNext() ) {
					adaptor.addChild(root_1, stream_expression.nextTree());
				}
				stream_expression.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "parametres_appel"


	public static class condition_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "condition"
	// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:107:1: condition : 'if' '(' expression ')' bloc ( options {greedy=true; } : 'else' bloc )? -> ^( IF ^( COND expression ) bloc ( ELSE bloc )? ) ;
	public final microC_ASTParser.condition_return condition() throws RecognitionException {
		microC_ASTParser.condition_return retval = new microC_ASTParser.condition_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal67=null;
		Token char_literal68=null;
		Token char_literal70=null;
		Token string_literal72=null;
		ParserRuleReturnScope expression69 =null;
		ParserRuleReturnScope bloc71 =null;
		ParserRuleReturnScope bloc73 =null;

		CommonTree string_literal67_tree=null;
		CommonTree char_literal68_tree=null;
		CommonTree char_literal70_tree=null;
		CommonTree string_literal72_tree=null;
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
		RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_bloc=new RewriteRuleSubtreeStream(adaptor,"rule bloc");

		try {
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:108:2: ( 'if' '(' expression ')' bloc ( options {greedy=true; } : 'else' bloc )? -> ^( IF ^( COND expression ) bloc ( ELSE bloc )? ) )
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:108:5: 'if' '(' expression ')' bloc ( options {greedy=true; } : 'else' bloc )?
			{
			string_literal67=(Token)match(input,58,FOLLOW_58_in_condition635);  
			stream_58.add(string_literal67);

			char_literal68=(Token)match(input,36,FOLLOW_36_in_condition637);  
			stream_36.add(char_literal68);

			pushFollow(FOLLOW_expression_in_condition639);
			expression69=expression();
			state._fsp--;

			stream_expression.add(expression69.getTree());
			char_literal70=(Token)match(input,37,FOLLOW_37_in_condition641);  
			stream_37.add(char_literal70);

			pushFollow(FOLLOW_bloc_in_condition643);
			bloc71=bloc();
			state._fsp--;

			stream_bloc.add(bloc71.getTree());
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:108:35: ( options {greedy=true; } : 'else' bloc )?
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==56) ) {
				alt12=1;
			}
			switch (alt12) {
				case 1 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:108:60: 'else' bloc
					{
					string_literal72=(Token)match(input,56,FOLLOW_56_in_condition655);  
					stream_56.add(string_literal72);

					pushFollow(FOLLOW_bloc_in_condition657);
					bloc73=bloc();
					state._fsp--;

					stream_bloc.add(bloc73.getTree());
					}
					break;

			}

			// AST REWRITE
			// elements: bloc, expression, bloc
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 108:74: -> ^( IF ^( COND expression ) bloc ( ELSE bloc )? )
			{
				// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:108:76: ^( IF ^( COND expression ) bloc ( ELSE bloc )? )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IF, "IF"), root_1);
				// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:108:81: ^( COND expression )
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(COND, "COND"), root_2);
				adaptor.addChild(root_2, stream_expression.nextTree());
				adaptor.addChild(root_1, root_2);
				}

				adaptor.addChild(root_1, stream_bloc.nextTree());
				// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:108:105: ( ELSE bloc )?
				if ( stream_bloc.hasNext() ) {
					adaptor.addChild(root_1, (CommonTree)adaptor.create(ELSE, "ELSE"));
					adaptor.addChild(root_1, stream_bloc.nextTree());
				}
				stream_bloc.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "condition"


	public static class boucle_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "boucle"
	// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:112:1: boucle : ( 'while' '(' expression ')' bloc -> ^( WHILE ^( COND expression ) bloc ) | 'for' '(' affectation ';' expression ';' affectation ')' bloc -> ^( FOR ^( COND affectation expression affectation ) bloc ) );
	public final microC_ASTParser.boucle_return boucle() throws RecognitionException {
		microC_ASTParser.boucle_return retval = new microC_ASTParser.boucle_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal74=null;
		Token char_literal75=null;
		Token char_literal77=null;
		Token string_literal79=null;
		Token char_literal80=null;
		Token char_literal82=null;
		Token char_literal84=null;
		Token char_literal86=null;
		ParserRuleReturnScope expression76 =null;
		ParserRuleReturnScope bloc78 =null;
		ParserRuleReturnScope affectation81 =null;
		ParserRuleReturnScope expression83 =null;
		ParserRuleReturnScope affectation85 =null;
		ParserRuleReturnScope bloc87 =null;

		CommonTree string_literal74_tree=null;
		CommonTree char_literal75_tree=null;
		CommonTree char_literal77_tree=null;
		CommonTree string_literal79_tree=null;
		CommonTree char_literal80_tree=null;
		CommonTree char_literal82_tree=null;
		CommonTree char_literal84_tree=null;
		CommonTree char_literal86_tree=null;
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_FIN_INSTRUCTION=new RewriteRuleTokenStream(adaptor,"token FIN_INSTRUCTION");
		RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_bloc=new RewriteRuleSubtreeStream(adaptor,"rule bloc");
		RewriteRuleSubtreeStream stream_affectation=new RewriteRuleSubtreeStream(adaptor,"rule affectation");

		try {
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:113:2: ( 'while' '(' expression ')' bloc -> ^( WHILE ^( COND expression ) bloc ) | 'for' '(' affectation ';' expression ';' affectation ')' bloc -> ^( FOR ^( COND affectation expression affectation ) bloc ) )
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==63) ) {
				alt13=1;
			}
			else if ( (LA13_0==57) ) {
				alt13=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}

			switch (alt13) {
				case 1 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:113:5: 'while' '(' expression ')' bloc
					{
					string_literal74=(Token)match(input,63,FOLLOW_63_in_boucle692);  
					stream_63.add(string_literal74);

					char_literal75=(Token)match(input,36,FOLLOW_36_in_boucle694);  
					stream_36.add(char_literal75);

					pushFollow(FOLLOW_expression_in_boucle696);
					expression76=expression();
					state._fsp--;

					stream_expression.add(expression76.getTree());
					char_literal77=(Token)match(input,37,FOLLOW_37_in_boucle698);  
					stream_37.add(char_literal77);

					pushFollow(FOLLOW_bloc_in_boucle700);
					bloc78=bloc();
					state._fsp--;

					stream_bloc.add(bloc78.getTree());
					// AST REWRITE
					// elements: bloc, expression
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 113:37: -> ^( WHILE ^( COND expression ) bloc )
					{
						// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:113:40: ^( WHILE ^( COND expression ) bloc )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(WHILE, "WHILE"), root_1);
						// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:113:48: ^( COND expression )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(COND, "COND"), root_2);
						adaptor.addChild(root_2, stream_expression.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_1, stream_bloc.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:114:5: 'for' '(' affectation ';' expression ';' affectation ')' bloc
					{
					string_literal79=(Token)match(input,57,FOLLOW_57_in_boucle720);  
					stream_57.add(string_literal79);

					char_literal80=(Token)match(input,36,FOLLOW_36_in_boucle722);  
					stream_36.add(char_literal80);

					pushFollow(FOLLOW_affectation_in_boucle724);
					affectation81=affectation();
					state._fsp--;

					stream_affectation.add(affectation81.getTree());
					char_literal82=(Token)match(input,FIN_INSTRUCTION,FOLLOW_FIN_INSTRUCTION_in_boucle726);  
					stream_FIN_INSTRUCTION.add(char_literal82);

					pushFollow(FOLLOW_expression_in_boucle728);
					expression83=expression();
					state._fsp--;

					stream_expression.add(expression83.getTree());
					char_literal84=(Token)match(input,FIN_INSTRUCTION,FOLLOW_FIN_INSTRUCTION_in_boucle730);  
					stream_FIN_INSTRUCTION.add(char_literal84);

					pushFollow(FOLLOW_affectation_in_boucle732);
					affectation85=affectation();
					state._fsp--;

					stream_affectation.add(affectation85.getTree());
					char_literal86=(Token)match(input,37,FOLLOW_37_in_boucle734);  
					stream_37.add(char_literal86);

					pushFollow(FOLLOW_bloc_in_boucle736);
					bloc87=bloc();
					state._fsp--;

					stream_bloc.add(bloc87.getTree());
					// AST REWRITE
					// elements: affectation, bloc, affectation, expression
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 114:67: -> ^( FOR ^( COND affectation expression affectation ) bloc )
					{
						// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:114:70: ^( FOR ^( COND affectation expression affectation ) bloc )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FOR, "FOR"), root_1);
						// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:114:77: ^( COND affectation expression affectation )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(COND, "COND"), root_2);
						adaptor.addChild(root_2, stream_affectation.nextTree());
						adaptor.addChild(root_2, stream_expression.nextTree());
						adaptor.addChild(root_2, stream_affectation.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_1, stream_bloc.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "boucle"


	public static class fonction_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "fonction"
	// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:119:1: fonction : type_affect IDENTIFIANT '(' parametres_effectifs ')' bloc_complexe -> ^( FONCT IDENTIFIANT type_affect parametres_effectifs bloc_complexe ) ;
	public final microC_ASTParser.fonction_return fonction() throws RecognitionException {
		microC_ASTParser.fonction_return retval = new microC_ASTParser.fonction_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENTIFIANT89=null;
		Token char_literal90=null;
		Token char_literal92=null;
		ParserRuleReturnScope type_affect88 =null;
		ParserRuleReturnScope parametres_effectifs91 =null;
		ParserRuleReturnScope bloc_complexe93 =null;

		CommonTree IDENTIFIANT89_tree=null;
		CommonTree char_literal90_tree=null;
		CommonTree char_literal92_tree=null;
		RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
		RewriteRuleTokenStream stream_IDENTIFIANT=new RewriteRuleTokenStream(adaptor,"token IDENTIFIANT");
		RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
		RewriteRuleSubtreeStream stream_bloc_complexe=new RewriteRuleSubtreeStream(adaptor,"rule bloc_complexe");
		RewriteRuleSubtreeStream stream_type_affect=new RewriteRuleSubtreeStream(adaptor,"rule type_affect");
		RewriteRuleSubtreeStream stream_parametres_effectifs=new RewriteRuleSubtreeStream(adaptor,"rule parametres_effectifs");

		try {
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:119:10: ( type_affect IDENTIFIANT '(' parametres_effectifs ')' bloc_complexe -> ^( FONCT IDENTIFIANT type_affect parametres_effectifs bloc_complexe ) )
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:119:12: type_affect IDENTIFIANT '(' parametres_effectifs ')' bloc_complexe
			{
			pushFollow(FOLLOW_type_affect_in_fonction767);
			type_affect88=type_affect();
			state._fsp--;

			stream_type_affect.add(type_affect88.getTree());
			IDENTIFIANT89=(Token)match(input,IDENTIFIANT,FOLLOW_IDENTIFIANT_in_fonction769);  
			stream_IDENTIFIANT.add(IDENTIFIANT89);

			char_literal90=(Token)match(input,36,FOLLOW_36_in_fonction772);  
			stream_36.add(char_literal90);

			pushFollow(FOLLOW_parametres_effectifs_in_fonction774);
			parametres_effectifs91=parametres_effectifs();
			state._fsp--;

			stream_parametres_effectifs.add(parametres_effectifs91.getTree());
			char_literal92=(Token)match(input,37,FOLLOW_37_in_fonction776);  
			stream_37.add(char_literal92);

			pushFollow(FOLLOW_bloc_complexe_in_fonction778);
			bloc_complexe93=bloc_complexe();
			state._fsp--;

			stream_bloc_complexe.add(bloc_complexe93.getTree());
			// AST REWRITE
			// elements: bloc_complexe, type_affect, IDENTIFIANT, parametres_effectifs
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 119:80: -> ^( FONCT IDENTIFIANT type_affect parametres_effectifs bloc_complexe )
			{
				// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:119:83: ^( FONCT IDENTIFIANT type_affect parametres_effectifs bloc_complexe )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FONCT, "FONCT"), root_1);
				adaptor.addChild(root_1, stream_IDENTIFIANT.nextNode());
				adaptor.addChild(root_1, stream_type_affect.nextTree());
				adaptor.addChild(root_1, stream_parametres_effectifs.nextTree());
				adaptor.addChild(root_1, stream_bloc_complexe.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "fonction"


	public static class procedure_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "procedure"
	// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:122:1: procedure : 'void' IDENTIFIANT '(' parametres_effectifs ')' bloc_complexe -> ^( PROC IDENTIFIANT parametres_effectifs bloc_complexe ) ;
	public final microC_ASTParser.procedure_return procedure() throws RecognitionException {
		microC_ASTParser.procedure_return retval = new microC_ASTParser.procedure_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal94=null;
		Token IDENTIFIANT95=null;
		Token char_literal96=null;
		Token char_literal98=null;
		ParserRuleReturnScope parametres_effectifs97 =null;
		ParserRuleReturnScope bloc_complexe99 =null;

		CommonTree string_literal94_tree=null;
		CommonTree IDENTIFIANT95_tree=null;
		CommonTree char_literal96_tree=null;
		CommonTree char_literal98_tree=null;
		RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_IDENTIFIANT=new RewriteRuleTokenStream(adaptor,"token IDENTIFIANT");
		RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
		RewriteRuleSubtreeStream stream_bloc_complexe=new RewriteRuleSubtreeStream(adaptor,"rule bloc_complexe");
		RewriteRuleSubtreeStream stream_parametres_effectifs=new RewriteRuleSubtreeStream(adaptor,"rule parametres_effectifs");

		try {
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:122:11: ( 'void' IDENTIFIANT '(' parametres_effectifs ')' bloc_complexe -> ^( PROC IDENTIFIANT parametres_effectifs bloc_complexe ) )
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:122:13: 'void' IDENTIFIANT '(' parametres_effectifs ')' bloc_complexe
			{
			string_literal94=(Token)match(input,62,FOLLOW_62_in_procedure804);  
			stream_62.add(string_literal94);

			IDENTIFIANT95=(Token)match(input,IDENTIFIANT,FOLLOW_IDENTIFIANT_in_procedure806);  
			stream_IDENTIFIANT.add(IDENTIFIANT95);

			char_literal96=(Token)match(input,36,FOLLOW_36_in_procedure808);  
			stream_36.add(char_literal96);

			pushFollow(FOLLOW_parametres_effectifs_in_procedure810);
			parametres_effectifs97=parametres_effectifs();
			state._fsp--;

			stream_parametres_effectifs.add(parametres_effectifs97.getTree());
			char_literal98=(Token)match(input,37,FOLLOW_37_in_procedure812);  
			stream_37.add(char_literal98);

			pushFollow(FOLLOW_bloc_complexe_in_procedure814);
			bloc_complexe99=bloc_complexe();
			state._fsp--;

			stream_bloc_complexe.add(bloc_complexe99.getTree());
			// AST REWRITE
			// elements: bloc_complexe, IDENTIFIANT, parametres_effectifs
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 122:75: -> ^( PROC IDENTIFIANT parametres_effectifs bloc_complexe )
			{
				// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:122:78: ^( PROC IDENTIFIANT parametres_effectifs bloc_complexe )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PROC, "PROC"), root_1);
				adaptor.addChild(root_1, stream_IDENTIFIANT.nextNode());
				adaptor.addChild(root_1, stream_parametres_effectifs.nextTree());
				adaptor.addChild(root_1, stream_bloc_complexe.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "procedure"


	public static class parametres_effectifs_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "parametres_effectifs"
	// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:125:1: parametres_effectifs : ( parametre )? ( ',' parametre )* -> ^( PARAM ( parametre )* ) ;
	public final microC_ASTParser.parametres_effectifs_return parametres_effectifs() throws RecognitionException {
		microC_ASTParser.parametres_effectifs_return retval = new microC_ASTParser.parametres_effectifs_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal101=null;
		ParserRuleReturnScope parametre100 =null;
		ParserRuleReturnScope parametre102 =null;

		CommonTree char_literal101_tree=null;
		RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");
		RewriteRuleSubtreeStream stream_parametre=new RewriteRuleSubtreeStream(adaptor,"rule parametre");

		try {
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:126:2: ( ( parametre )? ( ',' parametre )* -> ^( PARAM ( parametre )* ) )
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:126:4: ( parametre )? ( ',' parametre )*
			{
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:126:4: ( parametre )?
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0==55||LA14_0==59) ) {
				alt14=1;
			}
			switch (alt14) {
				case 1 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:126:4: parametre
					{
					pushFollow(FOLLOW_parametre_in_parametres_effectifs838);
					parametre100=parametre();
					state._fsp--;

					stream_parametre.add(parametre100.getTree());
					}
					break;

			}

			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:126:15: ( ',' parametre )*
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==42) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:126:16: ',' parametre
					{
					char_literal101=(Token)match(input,42,FOLLOW_42_in_parametres_effectifs842);  
					stream_42.add(char_literal101);

					pushFollow(FOLLOW_parametre_in_parametres_effectifs844);
					parametre102=parametre();
					state._fsp--;

					stream_parametre.add(parametre102.getTree());
					}
					break;

				default :
					break loop15;
				}
			}

			// AST REWRITE
			// elements: parametre
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 126:32: -> ^( PARAM ( parametre )* )
			{
				// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:126:35: ^( PARAM ( parametre )* )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PARAM, "PARAM"), root_1);
				// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:126:43: ( parametre )*
				while ( stream_parametre.hasNext() ) {
					adaptor.addChild(root_1, stream_parametre.nextTree());
				}
				stream_parametre.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "parametres_effectifs"


	public static class parametre_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "parametre"
	// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:129:1: parametre : type_affect IDENTIFIANT -> ^( DECL type_affect IDENTIFIANT ) ;
	public final microC_ASTParser.parametre_return parametre() throws RecognitionException {
		microC_ASTParser.parametre_return retval = new microC_ASTParser.parametre_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENTIFIANT104=null;
		ParserRuleReturnScope type_affect103 =null;

		CommonTree IDENTIFIANT104_tree=null;
		RewriteRuleTokenStream stream_IDENTIFIANT=new RewriteRuleTokenStream(adaptor,"token IDENTIFIANT");
		RewriteRuleSubtreeStream stream_type_affect=new RewriteRuleSubtreeStream(adaptor,"rule type_affect");

		try {
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:129:11: ( type_affect IDENTIFIANT -> ^( DECL type_affect IDENTIFIANT ) )
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:129:13: type_affect IDENTIFIANT
			{
			pushFollow(FOLLOW_type_affect_in_parametre868);
			type_affect103=type_affect();
			state._fsp--;

			stream_type_affect.add(type_affect103.getTree());
			IDENTIFIANT104=(Token)match(input,IDENTIFIANT,FOLLOW_IDENTIFIANT_in_parametre870);  
			stream_IDENTIFIANT.add(IDENTIFIANT104);

			// AST REWRITE
			// elements: IDENTIFIANT, type_affect
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 129:37: -> ^( DECL type_affect IDENTIFIANT )
			{
				// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:129:40: ^( DECL type_affect IDENTIFIANT )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DECL, "DECL"), root_1);
				adaptor.addChild(root_1, stream_type_affect.nextTree());
				adaptor.addChild(root_1, stream_IDENTIFIANT.nextNode());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "parametre"


	public static class retour_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "retour"
	// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:133:1: retour : ( 'return' ^| 'return' ^ expression );
	public final microC_ASTParser.retour_return retour() throws RecognitionException {
		microC_ASTParser.retour_return retval = new microC_ASTParser.retour_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal105=null;
		Token string_literal106=null;
		ParserRuleReturnScope expression107 =null;

		CommonTree string_literal105_tree=null;
		CommonTree string_literal106_tree=null;

		try {
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:133:8: ( 'return' ^| 'return' ^ expression )
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==61) ) {
				int LA16_1 = input.LA(2);
				if ( (LA16_1==FIN_INSTRUCTION) ) {
					alt16=1;
				}
				else if ( (LA16_1==CHIFFRES||LA16_1==IDENTIFIANT||LA16_1==LETTRE_QUOTE||LA16_1==32||(LA16_1 >= 35 && LA16_1 <= 36)||LA16_1==38||LA16_1==43) ) {
					alt16=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 16, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}

			switch (alt16) {
				case 1 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:133:10: 'return' ^
					{
					root_0 = (CommonTree)adaptor.nil();


					string_literal105=(Token)match(input,61,FOLLOW_61_in_retour892); 
					string_literal105_tree = (CommonTree)adaptor.create(string_literal105);
					root_0 = (CommonTree)adaptor.becomeRoot(string_literal105_tree, root_0);

					}
					break;
				case 2 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:134:4: 'return' ^ expression
					{
					root_0 = (CommonTree)adaptor.nil();


					string_literal106=(Token)match(input,61,FOLLOW_61_in_retour898); 
					string_literal106_tree = (CommonTree)adaptor.create(string_literal106);
					root_0 = (CommonTree)adaptor.becomeRoot(string_literal106_tree, root_0);

					pushFollow(FOLLOW_expression_in_retour901);
					expression107=expression();
					state._fsp--;

					adaptor.addChild(root_0, expression107.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "retour"


	public static class type_int_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "type_int"
	// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:138:1: type_int : ( 'int' | 'char' );
	public final microC_ASTParser.type_int_return type_int() throws RecognitionException {
		microC_ASTParser.type_int_return retval = new microC_ASTParser.type_int_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set108=null;

		CommonTree set108_tree=null;

		try {
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:138:10: ( 'int' | 'char' )
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set108=input.LT(1);
			if ( input.LA(1)==55||input.LA(1)==59 ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set108));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "type_int"


	public static class type_ptr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "type_ptr"
	// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:142:1: type_ptr : ( 'int' '*' -> ^( PTR 'int' ) | 'char' '*' -> ^( PTR 'char' ) | 'int' '*' '*' -> ^( PTR ^( PTR 'int' ) ) | 'char' '*' '*' -> ^( PTR ^( PTR 'char' ) ) );
	public final microC_ASTParser.type_ptr_return type_ptr() throws RecognitionException {
		microC_ASTParser.type_ptr_return retval = new microC_ASTParser.type_ptr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal109=null;
		Token char_literal110=null;
		Token string_literal111=null;
		Token char_literal112=null;
		Token string_literal113=null;
		Token char_literal114=null;
		Token char_literal115=null;
		Token string_literal116=null;
		Token char_literal117=null;
		Token char_literal118=null;

		CommonTree string_literal109_tree=null;
		CommonTree char_literal110_tree=null;
		CommonTree string_literal111_tree=null;
		CommonTree char_literal112_tree=null;
		CommonTree string_literal113_tree=null;
		CommonTree char_literal114_tree=null;
		CommonTree char_literal115_tree=null;
		CommonTree string_literal116_tree=null;
		CommonTree char_literal117_tree=null;
		CommonTree char_literal118_tree=null;
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
		RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");

		try {
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:142:10: ( 'int' '*' -> ^( PTR 'int' ) | 'char' '*' -> ^( PTR 'char' ) | 'int' '*' '*' -> ^( PTR ^( PTR 'int' ) ) | 'char' '*' '*' -> ^( PTR ^( PTR 'char' ) ) )
			int alt17=4;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==59) ) {
				int LA17_1 = input.LA(2);
				if ( (LA17_1==38) ) {
					int LA17_3 = input.LA(3);
					if ( (LA17_3==38) ) {
						alt17=3;
					}
					else if ( (LA17_3==IDENTIFIANT) ) {
						alt17=1;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 17, 3, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 17, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA17_0==55) ) {
				int LA17_2 = input.LA(2);
				if ( (LA17_2==38) ) {
					int LA17_4 = input.LA(3);
					if ( (LA17_4==38) ) {
						alt17=4;
					}
					else if ( (LA17_4==IDENTIFIANT) ) {
						alt17=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 17, 4, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 17, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}

			switch (alt17) {
				case 1 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:142:12: 'int' '*'
					{
					string_literal109=(Token)match(input,59,FOLLOW_59_in_type_ptr928);  
					stream_59.add(string_literal109);

					char_literal110=(Token)match(input,38,FOLLOW_38_in_type_ptr930);  
					stream_38.add(char_literal110);

					// AST REWRITE
					// elements: 59
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 142:23: -> ^( PTR 'int' )
					{
						// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:142:26: ^( PTR 'int' )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PTR, "PTR"), root_1);
						adaptor.addChild(root_1, stream_59.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:143:4: 'char' '*'
					{
					string_literal111=(Token)match(input,55,FOLLOW_55_in_type_ptr944);  
					stream_55.add(string_literal111);

					char_literal112=(Token)match(input,38,FOLLOW_38_in_type_ptr946);  
					stream_38.add(char_literal112);

					// AST REWRITE
					// elements: 55
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 143:16: -> ^( PTR 'char' )
					{
						// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:143:19: ^( PTR 'char' )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PTR, "PTR"), root_1);
						adaptor.addChild(root_1, stream_55.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 3 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:144:4: 'int' '*' '*'
					{
					string_literal113=(Token)match(input,59,FOLLOW_59_in_type_ptr960);  
					stream_59.add(string_literal113);

					char_literal114=(Token)match(input,38,FOLLOW_38_in_type_ptr962);  
					stream_38.add(char_literal114);

					char_literal115=(Token)match(input,38,FOLLOW_38_in_type_ptr964);  
					stream_38.add(char_literal115);

					// AST REWRITE
					// elements: 59
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 144:19: -> ^( PTR ^( PTR 'int' ) )
					{
						// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:144:22: ^( PTR ^( PTR 'int' ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PTR, "PTR"), root_1);
						// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:144:28: ^( PTR 'int' )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PTR, "PTR"), root_2);
						adaptor.addChild(root_2, stream_59.nextNode());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 4 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:145:4: 'char' '*' '*'
					{
					string_literal116=(Token)match(input,55,FOLLOW_55_in_type_ptr982);  
					stream_55.add(string_literal116);

					char_literal117=(Token)match(input,38,FOLLOW_38_in_type_ptr984);  
					stream_38.add(char_literal117);

					char_literal118=(Token)match(input,38,FOLLOW_38_in_type_ptr986);  
					stream_38.add(char_literal118);

					// AST REWRITE
					// elements: 55
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 145:20: -> ^( PTR ^( PTR 'char' ) )
					{
						// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:145:23: ^( PTR ^( PTR 'char' ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PTR, "PTR"), root_1);
						// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:145:29: ^( PTR 'char' )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PTR, "PTR"), root_2);
						adaptor.addChild(root_2, stream_55.nextNode());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "type_ptr"


	public static class type_affect_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "type_affect"
	// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:148:1: type_affect : ( type_int | type_ptr );
	public final microC_ASTParser.type_affect_return type_affect() throws RecognitionException {
		microC_ASTParser.type_affect_return retval = new microC_ASTParser.type_affect_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope type_int119 =null;
		ParserRuleReturnScope type_ptr120 =null;


		try {
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:148:13: ( type_int | type_ptr )
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==59) ) {
				int LA18_1 = input.LA(2);
				if ( (LA18_1==38) ) {
					alt18=2;
				}
				else if ( (LA18_1==IDENTIFIANT) ) {
					alt18=1;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 18, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA18_0==55) ) {
				int LA18_2 = input.LA(2);
				if ( (LA18_2==38) ) {
					alt18=2;
				}
				else if ( (LA18_2==IDENTIFIANT) ) {
					alt18=1;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 18, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 18, 0, input);
				throw nvae;
			}

			switch (alt18) {
				case 1 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:148:15: type_int
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_type_int_in_type_affect1010);
					type_int119=type_int();
					state._fsp--;

					adaptor.addChild(root_0, type_int119.getTree());

					}
					break;
				case 2 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:148:24: type_ptr
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_type_ptr_in_type_affect1012);
					type_ptr120=type_ptr();
					state._fsp--;

					adaptor.addChild(root_0, type_ptr120.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "type_affect"


	public static class type_all_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "type_all"
	// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:151:1: type_all : ( type_int | 'void' );
	public final microC_ASTParser.type_all_return type_all() throws RecognitionException {
		microC_ASTParser.type_all_return retval = new microC_ASTParser.type_all_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal122=null;
		ParserRuleReturnScope type_int121 =null;

		CommonTree string_literal122_tree=null;

		try {
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:151:10: ( type_int | 'void' )
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==55||LA19_0==59) ) {
				alt19=1;
			}
			else if ( (LA19_0==62) ) {
				alt19=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 19, 0, input);
				throw nvae;
			}

			switch (alt19) {
				case 1 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:151:12: type_int
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_type_int_in_type_all1023);
					type_int121=type_int();
					state._fsp--;

					adaptor.addChild(root_0, type_int121.getTree());

					}
					break;
				case 2 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:151:21: 'void'
					{
					root_0 = (CommonTree)adaptor.nil();


					string_literal122=(Token)match(input,62,FOLLOW_62_in_type_all1025); 
					string_literal122_tree = (CommonTree)adaptor.create(string_literal122);
					adaptor.addChild(root_0, string_literal122_tree);

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "type_all"


	public static class expression_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "expression"
	// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:154:1: expression : ou_logique ;
	public final microC_ASTParser.expression_return expression() throws RecognitionException {
		microC_ASTParser.expression_return retval = new microC_ASTParser.expression_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope ou_logique123 =null;


		try {
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:155:2: ( ou_logique )
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:155:4: ou_logique
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_ou_logique_in_expression1037);
			ou_logique123=ou_logique();
			state._fsp--;

			adaptor.addChild(root_0, ou_logique123.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expression"


	public static class ou_logique_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "ou_logique"
	// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:158:1: ou_logique : et_logique ( '||' ^ et_logique )* ;
	public final microC_ASTParser.ou_logique_return ou_logique() throws RecognitionException {
		microC_ASTParser.ou_logique_return retval = new microC_ASTParser.ou_logique_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal125=null;
		ParserRuleReturnScope et_logique124 =null;
		ParserRuleReturnScope et_logique126 =null;

		CommonTree string_literal125_tree=null;

		try {
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:159:2: ( et_logique ( '||' ^ et_logique )* )
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:159:5: et_logique ( '||' ^ et_logique )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_et_logique_in_ou_logique1050);
			et_logique124=et_logique();
			state._fsp--;

			adaptor.addChild(root_0, et_logique124.getTree());

			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:159:16: ( '||' ^ et_logique )*
			loop20:
			while (true) {
				int alt20=2;
				int LA20_0 = input.LA(1);
				if ( (LA20_0==65) ) {
					alt20=1;
				}

				switch (alt20) {
				case 1 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:159:17: '||' ^ et_logique
					{
					string_literal125=(Token)match(input,65,FOLLOW_65_in_ou_logique1053); 
					string_literal125_tree = (CommonTree)adaptor.create(string_literal125);
					root_0 = (CommonTree)adaptor.becomeRoot(string_literal125_tree, root_0);

					pushFollow(FOLLOW_et_logique_in_ou_logique1056);
					et_logique126=et_logique();
					state._fsp--;

					adaptor.addChild(root_0, et_logique126.getTree());

					}
					break;

				default :
					break loop20;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "ou_logique"


	public static class et_logique_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "et_logique"
	// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:162:1: et_logique : egalite ( '&&' ^ egalite )* ;
	public final microC_ASTParser.et_logique_return et_logique() throws RecognitionException {
		microC_ASTParser.et_logique_return retval = new microC_ASTParser.et_logique_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal128=null;
		ParserRuleReturnScope egalite127 =null;
		ParserRuleReturnScope egalite129 =null;

		CommonTree string_literal128_tree=null;

		try {
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:163:2: ( egalite ( '&&' ^ egalite )* )
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:163:5: egalite ( '&&' ^ egalite )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_egalite_in_et_logique1070);
			egalite127=egalite();
			state._fsp--;

			adaptor.addChild(root_0, egalite127.getTree());

			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:163:13: ( '&&' ^ egalite )*
			loop21:
			while (true) {
				int alt21=2;
				int LA21_0 = input.LA(1);
				if ( (LA21_0==34) ) {
					alt21=1;
				}

				switch (alt21) {
				case 1 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:163:14: '&&' ^ egalite
					{
					string_literal128=(Token)match(input,34,FOLLOW_34_in_et_logique1073); 
					string_literal128_tree = (CommonTree)adaptor.create(string_literal128);
					root_0 = (CommonTree)adaptor.becomeRoot(string_literal128_tree, root_0);

					pushFollow(FOLLOW_egalite_in_et_logique1076);
					egalite129=egalite();
					state._fsp--;

					adaptor.addChild(root_0, egalite129.getTree());

					}
					break;

				default :
					break loop21;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "et_logique"


	public static class egalite_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "egalite"
	// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:166:1: egalite : difference ( ( '==' | '!=' ) ^ difference )* ;
	public final microC_ASTParser.egalite_return egalite() throws RecognitionException {
		microC_ASTParser.egalite_return retval = new microC_ASTParser.egalite_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set131=null;
		ParserRuleReturnScope difference130 =null;
		ParserRuleReturnScope difference132 =null;

		CommonTree set131_tree=null;

		try {
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:167:2: ( difference ( ( '==' | '!=' ) ^ difference )* )
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:167:4: difference ( ( '==' | '!=' ) ^ difference )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_difference_in_egalite1090);
			difference130=difference();
			state._fsp--;

			adaptor.addChild(root_0, difference130.getTree());

			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:167:15: ( ( '==' | '!=' ) ^ difference )*
			loop22:
			while (true) {
				int alt22=2;
				int LA22_0 = input.LA(1);
				if ( (LA22_0==33||LA22_0==50) ) {
					alt22=1;
				}

				switch (alt22) {
				case 1 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:167:16: ( '==' | '!=' ) ^ difference
					{
					set131=input.LT(1);
					set131=input.LT(1);
					if ( input.LA(1)==33||input.LA(1)==50 ) {
						input.consume();
						root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set131), root_0);
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_difference_in_egalite1100);
					difference132=difference();
					state._fsp--;

					adaptor.addChild(root_0, difference132.getTree());

					}
					break;

				default :
					break loop22;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "egalite"


	public static class difference_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "difference"
	// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:170:1: difference : operation ( ( '<' | '>' | '<=' | '>=' ) ^ operation )* ;
	public final microC_ASTParser.difference_return difference() throws RecognitionException {
		microC_ASTParser.difference_return retval = new microC_ASTParser.difference_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set134=null;
		ParserRuleReturnScope operation133 =null;
		ParserRuleReturnScope operation135 =null;

		CommonTree set134_tree=null;

		try {
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:171:2: ( operation ( ( '<' | '>' | '<=' | '>=' ) ^ operation )* )
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:171:4: operation ( ( '<' | '>' | '<=' | '>=' ) ^ operation )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_operation_in_difference1113);
			operation133=operation();
			state._fsp--;

			adaptor.addChild(root_0, operation133.getTree());

			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:171:14: ( ( '<' | '>' | '<=' | '>=' ) ^ operation )*
			loop23:
			while (true) {
				int alt23=2;
				int LA23_0 = input.LA(1);
				if ( ((LA23_0 >= 47 && LA23_0 <= 48)||(LA23_0 >= 51 && LA23_0 <= 52)) ) {
					alt23=1;
				}

				switch (alt23) {
				case 1 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:171:15: ( '<' | '>' | '<=' | '>=' ) ^ operation
					{
					set134=input.LT(1);
					set134=input.LT(1);
					if ( (input.LA(1) >= 47 && input.LA(1) <= 48)||(input.LA(1) >= 51 && input.LA(1) <= 52) ) {
						input.consume();
						root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set134), root_0);
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_operation_in_difference1127);
					operation135=operation();
					state._fsp--;

					adaptor.addChild(root_0, operation135.getTree());

					}
					break;

				default :
					break loop23;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "difference"


	public static class operation_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "operation"
	// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:175:1: operation : terme ( ( '+' | '-' ) ^ terme )* ;
	public final microC_ASTParser.operation_return operation() throws RecognitionException {
		microC_ASTParser.operation_return retval = new microC_ASTParser.operation_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set137=null;
		ParserRuleReturnScope terme136 =null;
		ParserRuleReturnScope terme138 =null;

		CommonTree set137_tree=null;

		try {
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:176:2: ( terme ( ( '+' | '-' ) ^ terme )* )
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:176:4: terme ( ( '+' | '-' ) ^ terme )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_terme_in_operation1141);
			terme136=terme();
			state._fsp--;

			adaptor.addChild(root_0, terme136.getTree());

			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:176:10: ( ( '+' | '-' ) ^ terme )*
			loop24:
			while (true) {
				int alt24=2;
				int LA24_0 = input.LA(1);
				if ( (LA24_0==40||LA24_0==43) ) {
					alt24=1;
				}

				switch (alt24) {
				case 1 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:176:11: ( '+' | '-' ) ^ terme
					{
					set137=input.LT(1);
					set137=input.LT(1);
					if ( input.LA(1)==40||input.LA(1)==43 ) {
						input.consume();
						root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set137), root_0);
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_terme_in_operation1151);
					terme138=terme();
					state._fsp--;

					adaptor.addChild(root_0, terme138.getTree());

					}
					break;

				default :
					break loop24;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "operation"


	public static class terme_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "terme"
	// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:180:1: terme : non_logique ( ( '*' | '/' ) ^ non_logique )* ;
	public final microC_ASTParser.terme_return terme() throws RecognitionException {
		microC_ASTParser.terme_return retval = new microC_ASTParser.terme_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set140=null;
		ParserRuleReturnScope non_logique139 =null;
		ParserRuleReturnScope non_logique141 =null;

		CommonTree set140_tree=null;

		try {
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:181:2: ( non_logique ( ( '*' | '/' ) ^ non_logique )* )
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:181:4: non_logique ( ( '*' | '/' ) ^ non_logique )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_non_logique_in_terme1166);
			non_logique139=non_logique();
			state._fsp--;

			adaptor.addChild(root_0, non_logique139.getTree());

			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:181:16: ( ( '*' | '/' ) ^ non_logique )*
			loop25:
			while (true) {
				int alt25=2;
				int LA25_0 = input.LA(1);
				if ( (LA25_0==38||LA25_0==45) ) {
					alt25=1;
				}

				switch (alt25) {
				case 1 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:181:17: ( '*' | '/' ) ^ non_logique
					{
					set140=input.LT(1);
					set140=input.LT(1);
					if ( input.LA(1)==38||input.LA(1)==45 ) {
						input.consume();
						root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set140), root_0);
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_non_logique_in_terme1176);
					non_logique141=non_logique();
					state._fsp--;

					adaptor.addChild(root_0, non_logique141.getTree());

					}
					break;

				default :
					break loop25;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "terme"


	public static class non_logique_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "non_logique"
	// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:184:1: non_logique : ( '!' ^)? moins_uniaire ;
	public final microC_ASTParser.non_logique_return non_logique() throws RecognitionException {
		microC_ASTParser.non_logique_return retval = new microC_ASTParser.non_logique_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal142=null;
		ParserRuleReturnScope moins_uniaire143 =null;

		CommonTree char_literal142_tree=null;

		try {
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:185:2: ( ( '!' ^)? moins_uniaire )
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:185:4: ( '!' ^)? moins_uniaire
			{
			root_0 = (CommonTree)adaptor.nil();


			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:185:4: ( '!' ^)?
			int alt26=2;
			int LA26_0 = input.LA(1);
			if ( (LA26_0==32) ) {
				alt26=1;
			}
			switch (alt26) {
				case 1 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:185:5: '!' ^
					{
					char_literal142=(Token)match(input,32,FOLLOW_32_in_non_logique1190); 
					char_literal142_tree = (CommonTree)adaptor.create(char_literal142);
					root_0 = (CommonTree)adaptor.becomeRoot(char_literal142_tree, root_0);

					}
					break;

			}

			pushFollow(FOLLOW_moins_uniaire_in_non_logique1195);
			moins_uniaire143=moins_uniaire();
			state._fsp--;

			adaptor.addChild(root_0, moins_uniaire143.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "non_logique"


	public static class moins_uniaire_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "moins_uniaire"
	// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:188:1: moins_uniaire : ( '-' ^)? atom ;
	public final microC_ASTParser.moins_uniaire_return moins_uniaire() throws RecognitionException {
		microC_ASTParser.moins_uniaire_return retval = new microC_ASTParser.moins_uniaire_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal144=null;
		ParserRuleReturnScope atom145 =null;

		CommonTree char_literal144_tree=null;

		try {
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:189:2: ( ( '-' ^)? atom )
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:189:4: ( '-' ^)? atom
			{
			root_0 = (CommonTree)adaptor.nil();


			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:189:4: ( '-' ^)?
			int alt27=2;
			int LA27_0 = input.LA(1);
			if ( (LA27_0==43) ) {
				alt27=1;
			}
			switch (alt27) {
				case 1 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:189:5: '-' ^
					{
					char_literal144=(Token)match(input,43,FOLLOW_43_in_moins_uniaire1208); 
					char_literal144_tree = (CommonTree)adaptor.create(char_literal144);
					root_0 = (CommonTree)adaptor.becomeRoot(char_literal144_tree, root_0);

					}
					break;

			}

			pushFollow(FOLLOW_atom_in_moins_uniaire1213);
			atom145=atom();
			state._fsp--;

			adaptor.addChild(root_0, atom145.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "moins_uniaire"


	public static class atom_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "atom"
	// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:192:1: atom : ( IDENTIFIANT | acces_tableau | CHIFFRES | LETTRE_QUOTE -> ^( CARACTERE LETTRE_QUOTE ) | pointeur -> ^( PTR pointeur ) | adresse -> ^( ADDRESS adresse ) | '(' ! expression ')' !| appel_fonction_procedure );
	public final microC_ASTParser.atom_return atom() throws RecognitionException {
		microC_ASTParser.atom_return retval = new microC_ASTParser.atom_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENTIFIANT146=null;
		Token CHIFFRES148=null;
		Token LETTRE_QUOTE149=null;
		Token char_literal152=null;
		Token char_literal154=null;
		ParserRuleReturnScope acces_tableau147 =null;
		ParserRuleReturnScope pointeur150 =null;
		ParserRuleReturnScope adresse151 =null;
		ParserRuleReturnScope expression153 =null;
		ParserRuleReturnScope appel_fonction_procedure155 =null;

		CommonTree IDENTIFIANT146_tree=null;
		CommonTree CHIFFRES148_tree=null;
		CommonTree LETTRE_QUOTE149_tree=null;
		CommonTree char_literal152_tree=null;
		CommonTree char_literal154_tree=null;
		RewriteRuleTokenStream stream_LETTRE_QUOTE=new RewriteRuleTokenStream(adaptor,"token LETTRE_QUOTE");
		RewriteRuleSubtreeStream stream_adresse=new RewriteRuleSubtreeStream(adaptor,"rule adresse");
		RewriteRuleSubtreeStream stream_pointeur=new RewriteRuleSubtreeStream(adaptor,"rule pointeur");

		try {
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:192:6: ( IDENTIFIANT | acces_tableau | CHIFFRES | LETTRE_QUOTE -> ^( CARACTERE LETTRE_QUOTE ) | pointeur -> ^( PTR pointeur ) | adresse -> ^( ADDRESS adresse ) | '(' ! expression ')' !| appel_fonction_procedure )
			int alt28=8;
			switch ( input.LA(1) ) {
			case IDENTIFIANT:
				{
				switch ( input.LA(2) ) {
				case 53:
					{
					alt28=2;
					}
					break;
				case 36:
					{
					alt28=8;
					}
					break;
				case FIN_INSTRUCTION:
				case 33:
				case 34:
				case 37:
				case 38:
				case 40:
				case 42:
				case 43:
				case 45:
				case 47:
				case 48:
				case 50:
				case 51:
				case 52:
				case 54:
				case 65:
				case 66:
					{
					alt28=1;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 28, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
				}
				break;
			case CHIFFRES:
				{
				alt28=3;
				}
				break;
			case LETTRE_QUOTE:
				{
				alt28=4;
				}
				break;
			case 38:
				{
				alt28=5;
				}
				break;
			case 35:
				{
				alt28=6;
				}
				break;
			case 36:
				{
				alt28=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 28, 0, input);
				throw nvae;
			}
			switch (alt28) {
				case 1 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:192:8: IDENTIFIANT
					{
					root_0 = (CommonTree)adaptor.nil();


					IDENTIFIANT146=(Token)match(input,IDENTIFIANT,FOLLOW_IDENTIFIANT_in_atom1223); 
					IDENTIFIANT146_tree = (CommonTree)adaptor.create(IDENTIFIANT146);
					adaptor.addChild(root_0, IDENTIFIANT146_tree);

					}
					break;
				case 2 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:193:4: acces_tableau
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_acces_tableau_in_atom1228);
					acces_tableau147=acces_tableau();
					state._fsp--;

					adaptor.addChild(root_0, acces_tableau147.getTree());

					}
					break;
				case 3 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:194:4: CHIFFRES
					{
					root_0 = (CommonTree)adaptor.nil();


					CHIFFRES148=(Token)match(input,CHIFFRES,FOLLOW_CHIFFRES_in_atom1233); 
					CHIFFRES148_tree = (CommonTree)adaptor.create(CHIFFRES148);
					adaptor.addChild(root_0, CHIFFRES148_tree);

					}
					break;
				case 4 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:195:4: LETTRE_QUOTE
					{
					LETTRE_QUOTE149=(Token)match(input,LETTRE_QUOTE,FOLLOW_LETTRE_QUOTE_in_atom1238);  
					stream_LETTRE_QUOTE.add(LETTRE_QUOTE149);

					// AST REWRITE
					// elements: LETTRE_QUOTE
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 195:17: -> ^( CARACTERE LETTRE_QUOTE )
					{
						// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:195:20: ^( CARACTERE LETTRE_QUOTE )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CARACTERE, "CARACTERE"), root_1);
						adaptor.addChild(root_1, stream_LETTRE_QUOTE.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 5 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:196:4: pointeur
					{
					pushFollow(FOLLOW_pointeur_in_atom1251);
					pointeur150=pointeur();
					state._fsp--;

					stream_pointeur.add(pointeur150.getTree());
					// AST REWRITE
					// elements: pointeur
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 196:13: -> ^( PTR pointeur )
					{
						// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:196:16: ^( PTR pointeur )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PTR, "PTR"), root_1);
						adaptor.addChild(root_1, stream_pointeur.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 6 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:197:4: adresse
					{
					pushFollow(FOLLOW_adresse_in_atom1264);
					adresse151=adresse();
					state._fsp--;

					stream_adresse.add(adresse151.getTree());
					// AST REWRITE
					// elements: adresse
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 197:12: -> ^( ADDRESS adresse )
					{
						// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:197:15: ^( ADDRESS adresse )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ADDRESS, "ADDRESS"), root_1);
						adaptor.addChild(root_1, stream_adresse.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 7 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:198:4: '(' ! expression ')' !
					{
					root_0 = (CommonTree)adaptor.nil();


					char_literal152=(Token)match(input,36,FOLLOW_36_in_atom1277); 
					pushFollow(FOLLOW_expression_in_atom1279);
					expression153=expression();
					state._fsp--;

					adaptor.addChild(root_0, expression153.getTree());

					char_literal154=(Token)match(input,37,FOLLOW_37_in_atom1280); 
					}
					break;
				case 8 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:199:4: appel_fonction_procedure
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_appel_fonction_procedure_in_atom1286);
					appel_fonction_procedure155=appel_fonction_procedure();
					state._fsp--;

					adaptor.addChild(root_0, appel_fonction_procedure155.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "atom"


	public static class acces_tableau_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "acces_tableau"
	// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:202:1: acces_tableau : IDENTIFIANT '[' expression ']' -> ^( TABLEAU IDENTIFIANT ^( INDICE expression ) ) ;
	public final microC_ASTParser.acces_tableau_return acces_tableau() throws RecognitionException {
		microC_ASTParser.acces_tableau_return retval = new microC_ASTParser.acces_tableau_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENTIFIANT156=null;
		Token char_literal157=null;
		Token char_literal159=null;
		ParserRuleReturnScope expression158 =null;

		CommonTree IDENTIFIANT156_tree=null;
		CommonTree char_literal157_tree=null;
		CommonTree char_literal159_tree=null;
		RewriteRuleTokenStream stream_IDENTIFIANT=new RewriteRuleTokenStream(adaptor,"token IDENTIFIANT");
		RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
		RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");

		try {
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:203:2: ( IDENTIFIANT '[' expression ']' -> ^( TABLEAU IDENTIFIANT ^( INDICE expression ) ) )
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:203:4: IDENTIFIANT '[' expression ']'
			{
			IDENTIFIANT156=(Token)match(input,IDENTIFIANT,FOLLOW_IDENTIFIANT_in_acces_tableau1298);  
			stream_IDENTIFIANT.add(IDENTIFIANT156);

			char_literal157=(Token)match(input,53,FOLLOW_53_in_acces_tableau1300);  
			stream_53.add(char_literal157);

			pushFollow(FOLLOW_expression_in_acces_tableau1302);
			expression158=expression();
			state._fsp--;

			stream_expression.add(expression158.getTree());
			char_literal159=(Token)match(input,54,FOLLOW_54_in_acces_tableau1305);  
			stream_54.add(char_literal159);

			// AST REWRITE
			// elements: expression, IDENTIFIANT
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 203:36: -> ^( TABLEAU IDENTIFIANT ^( INDICE expression ) )
			{
				// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:203:39: ^( TABLEAU IDENTIFIANT ^( INDICE expression ) )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TABLEAU, "TABLEAU"), root_1);
				adaptor.addChild(root_1, stream_IDENTIFIANT.nextNode());
				// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:203:61: ^( INDICE expression )
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INDICE, "INDICE"), root_2);
				adaptor.addChild(root_2, stream_expression.nextTree());
				adaptor.addChild(root_1, root_2);
				}

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "acces_tableau"


	public static class pointeur_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "pointeur"
	// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:206:1: pointeur : ( '*' IDENTIFIANT -> IDENTIFIANT | '*' '*' IDENTIFIANT -> ^( PTR IDENTIFIANT ) );
	public final microC_ASTParser.pointeur_return pointeur() throws RecognitionException {
		microC_ASTParser.pointeur_return retval = new microC_ASTParser.pointeur_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal160=null;
		Token IDENTIFIANT161=null;
		Token char_literal162=null;
		Token char_literal163=null;
		Token IDENTIFIANT164=null;

		CommonTree char_literal160_tree=null;
		CommonTree IDENTIFIANT161_tree=null;
		CommonTree char_literal162_tree=null;
		CommonTree char_literal163_tree=null;
		CommonTree IDENTIFIANT164_tree=null;
		RewriteRuleTokenStream stream_IDENTIFIANT=new RewriteRuleTokenStream(adaptor,"token IDENTIFIANT");
		RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");

		try {
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:206:10: ( '*' IDENTIFIANT -> IDENTIFIANT | '*' '*' IDENTIFIANT -> ^( PTR IDENTIFIANT ) )
			int alt29=2;
			int LA29_0 = input.LA(1);
			if ( (LA29_0==38) ) {
				int LA29_1 = input.LA(2);
				if ( (LA29_1==IDENTIFIANT) ) {
					alt29=1;
				}
				else if ( (LA29_1==38) ) {
					alt29=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 29, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 29, 0, input);
				throw nvae;
			}

			switch (alt29) {
				case 1 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:206:12: '*' IDENTIFIANT
					{
					char_literal160=(Token)match(input,38,FOLLOW_38_in_pointeur1330);  
					stream_38.add(char_literal160);

					IDENTIFIANT161=(Token)match(input,IDENTIFIANT,FOLLOW_IDENTIFIANT_in_pointeur1332);  
					stream_IDENTIFIANT.add(IDENTIFIANT161);

					// AST REWRITE
					// elements: IDENTIFIANT
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 206:28: -> IDENTIFIANT
					{
						adaptor.addChild(root_0, stream_IDENTIFIANT.nextNode());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:207:4: '*' '*' IDENTIFIANT
					{
					char_literal162=(Token)match(input,38,FOLLOW_38_in_pointeur1341);  
					stream_38.add(char_literal162);

					char_literal163=(Token)match(input,38,FOLLOW_38_in_pointeur1343);  
					stream_38.add(char_literal163);

					IDENTIFIANT164=(Token)match(input,IDENTIFIANT,FOLLOW_IDENTIFIANT_in_pointeur1345);  
					stream_IDENTIFIANT.add(IDENTIFIANT164);

					// AST REWRITE
					// elements: IDENTIFIANT
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 207:24: -> ^( PTR IDENTIFIANT )
					{
						// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:207:27: ^( PTR IDENTIFIANT )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PTR, "PTR"), root_1);
						adaptor.addChild(root_1, stream_IDENTIFIANT.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "pointeur"


	public static class adresse_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "adresse"
	// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:210:1: adresse : '&' ! ( ( IDENTIFIANT | pointeur ) | '(' ! ( IDENTIFIANT | pointeur ) ')' !) ;
	public final microC_ASTParser.adresse_return adresse() throws RecognitionException {
		microC_ASTParser.adresse_return retval = new microC_ASTParser.adresse_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal165=null;
		Token IDENTIFIANT166=null;
		Token char_literal168=null;
		Token IDENTIFIANT169=null;
		Token char_literal171=null;
		ParserRuleReturnScope pointeur167 =null;
		ParserRuleReturnScope pointeur170 =null;

		CommonTree char_literal165_tree=null;
		CommonTree IDENTIFIANT166_tree=null;
		CommonTree char_literal168_tree=null;
		CommonTree IDENTIFIANT169_tree=null;
		CommonTree char_literal171_tree=null;

		try {
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:210:9: ( '&' ! ( ( IDENTIFIANT | pointeur ) | '(' ! ( IDENTIFIANT | pointeur ) ')' !) )
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:210:11: '&' ! ( ( IDENTIFIANT | pointeur ) | '(' ! ( IDENTIFIANT | pointeur ) ')' !)
			{
			root_0 = (CommonTree)adaptor.nil();


			char_literal165=(Token)match(input,35,FOLLOW_35_in_adresse1363); 
			// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:210:16: ( ( IDENTIFIANT | pointeur ) | '(' ! ( IDENTIFIANT | pointeur ) ')' !)
			int alt32=2;
			int LA32_0 = input.LA(1);
			if ( (LA32_0==IDENTIFIANT||LA32_0==38) ) {
				alt32=1;
			}
			else if ( (LA32_0==36) ) {
				alt32=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 32, 0, input);
				throw nvae;
			}

			switch (alt32) {
				case 1 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:210:17: ( IDENTIFIANT | pointeur )
					{
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:210:17: ( IDENTIFIANT | pointeur )
					int alt30=2;
					int LA30_0 = input.LA(1);
					if ( (LA30_0==IDENTIFIANT) ) {
						alt30=1;
					}
					else if ( (LA30_0==38) ) {
						alt30=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 30, 0, input);
						throw nvae;
					}

					switch (alt30) {
						case 1 :
							// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:210:18: IDENTIFIANT
							{
							IDENTIFIANT166=(Token)match(input,IDENTIFIANT,FOLLOW_IDENTIFIANT_in_adresse1368); 
							IDENTIFIANT166_tree = (CommonTree)adaptor.create(IDENTIFIANT166);
							adaptor.addChild(root_0, IDENTIFIANT166_tree);

							}
							break;
						case 2 :
							// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:210:30: pointeur
							{
							pushFollow(FOLLOW_pointeur_in_adresse1370);
							pointeur167=pointeur();
							state._fsp--;

							adaptor.addChild(root_0, pointeur167.getTree());

							}
							break;

					}

					}
					break;
				case 2 :
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:210:40: '(' ! ( IDENTIFIANT | pointeur ) ')' !
					{
					char_literal168=(Token)match(input,36,FOLLOW_36_in_adresse1373); 
					// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:210:44: ( IDENTIFIANT | pointeur )
					int alt31=2;
					int LA31_0 = input.LA(1);
					if ( (LA31_0==IDENTIFIANT) ) {
						alt31=1;
					}
					else if ( (LA31_0==38) ) {
						alt31=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 31, 0, input);
						throw nvae;
					}

					switch (alt31) {
						case 1 :
							// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:210:45: IDENTIFIANT
							{
							IDENTIFIANT169=(Token)match(input,IDENTIFIANT,FOLLOW_IDENTIFIANT_in_adresse1376); 
							IDENTIFIANT169_tree = (CommonTree)adaptor.create(IDENTIFIANT169);
							adaptor.addChild(root_0, IDENTIFIANT169_tree);

							}
							break;
						case 2 :
							// /Users/bogy/Google Drive/Compilation/Redmine/grammaire/microC_AST.g:210:57: pointeur
							{
							pushFollow(FOLLOW_pointeur_in_adresse1378);
							pointeur170=pointeur();
							state._fsp--;

							adaptor.addChild(root_0, pointeur170.getTree());

							}
							break;

					}

					char_literal171=(Token)match(input,37,FOLLOW_37_in_adresse1380); 
					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "adresse"

	// Delegated rules



	public static final BitSet FOLLOW_declaration_in_programme115 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_FIN_INSTRUCTION_in_programme117 = new BitSet(new long[]{0x4880004000080000L});
	public static final BitSet FOLLOW_affectation_in_programme120 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_FIN_INSTRUCTION_in_programme122 = new BitSet(new long[]{0x4880004000080000L});
	public static final BitSet FOLLOW_fonction_in_programme125 = new BitSet(new long[]{0x4880004000080000L});
	public static final BitSet FOLLOW_procedure_in_programme127 = new BitSet(new long[]{0x4880004000080000L});
	public static final BitSet FOLLOW_main_in_programme131 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_all_in_main141 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_main143 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_main145 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_main147 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_bloc_complexe_in_main149 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_bloc_simple_in_bloc170 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_bloc_complexe_in_bloc175 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_instruction_in_bloc_simple186 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_bloc_complexe206 = new BitSet(new long[]{0xAE80004000080000L,0x0000000000000004L});
	public static final BitSet FOLLOW_instruction_in_bloc_complexe208 = new BitSet(new long[]{0xAE80004000080000L,0x0000000000000004L});
	public static final BitSet FOLLOW_66_in_bloc_complexe211 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_condition_in_instruction233 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_boucle_in_instruction238 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_affectation_in_instruction243 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_FIN_INSTRUCTION_in_instruction245 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declaration_in_instruction251 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_FIN_INSTRUCTION_in_instruction253 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_appel_fonction_procedure_in_instruction259 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_FIN_INSTRUCTION_in_instruction261 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_retour_in_instruction267 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_FIN_INSTRUCTION_in_instruction269 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_affect_in_declaration284 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_var_in_declaration286 = new BitSet(new long[]{0x0000040000000002L});
	public static final BitSet FOLLOW_42_in_declaration290 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_var_in_declaration292 = new BitSet(new long[]{0x0000040000000002L});
	public static final BitSet FOLLOW_type_affect_in_declaration310 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_affectation_bis_in_declaration312 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIANT_in_var333 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_tableau_in_var335 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIANT_in_var351 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIANT_in_affectation365 = new BitSet(new long[]{0x0002528000000000L});
	public static final BitSet FOLLOW_operateur_affectation_in_affectation367 = new BitSet(new long[]{0x0000085900880400L});
	public static final BitSet FOLLOW_expression_in_affectation369 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pointeur_in_affectation388 = new BitSet(new long[]{0x0002528000000000L});
	public static final BitSet FOLLOW_operateur_affectation_in_affectation390 = new BitSet(new long[]{0x0000085900880400L});
	public static final BitSet FOLLOW_expression_in_affectation392 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_acces_tableau_in_affectation415 = new BitSet(new long[]{0x0002528000000000L});
	public static final BitSet FOLLOW_operateur_affectation_in_affectation417 = new BitSet(new long[]{0x0000085900880400L});
	public static final BitSet FOLLOW_expression_in_affectation419 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIANT_in_affectation_bis444 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_49_in_affectation_bis446 = new BitSet(new long[]{0x0000085900880400L});
	public static final BitSet FOLLOW_expression_in_affectation_bis448 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIANT_in_affectation_bis467 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_tableau_in_affectation_bis469 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_49_in_affectation_bis471 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_affectation_bis473 = new BitSet(new long[]{0x00000C5900880400L,0x0000000000000004L});
	public static final BitSet FOLLOW_parametres_appel_in_affectation_bis474 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_66_in_affectation_bis475 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_53_in_tableau507 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CHIFFRES_in_tableau509 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_54_in_tableau511 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIANT_in_appel_fonction_procedure571 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_appel_fonction_procedure573 = new BitSet(new long[]{0x00000C7900880400L});
	public static final BitSet FOLLOW_parametres_appel_in_appel_fonction_procedure575 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_appel_fonction_procedure577 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_parametres_appel602 = new BitSet(new long[]{0x0000040000000002L});
	public static final BitSet FOLLOW_42_in_parametres_appel607 = new BitSet(new long[]{0x0000085900880400L});
	public static final BitSet FOLLOW_expression_in_parametres_appel610 = new BitSet(new long[]{0x0000040000000002L});
	public static final BitSet FOLLOW_58_in_condition635 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_condition637 = new BitSet(new long[]{0x0000085900880400L});
	public static final BitSet FOLLOW_expression_in_condition639 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_condition641 = new BitSet(new long[]{0xAE80004000080000L,0x0000000000000001L});
	public static final BitSet FOLLOW_bloc_in_condition643 = new BitSet(new long[]{0x0100000000000002L});
	public static final BitSet FOLLOW_56_in_condition655 = new BitSet(new long[]{0xAE80004000080000L,0x0000000000000001L});
	public static final BitSet FOLLOW_bloc_in_condition657 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_63_in_boucle692 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_boucle694 = new BitSet(new long[]{0x0000085900880400L});
	public static final BitSet FOLLOW_expression_in_boucle696 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_boucle698 = new BitSet(new long[]{0xAE80004000080000L,0x0000000000000001L});
	public static final BitSet FOLLOW_bloc_in_boucle700 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_boucle720 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_boucle722 = new BitSet(new long[]{0x0000004000080000L});
	public static final BitSet FOLLOW_affectation_in_boucle724 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_FIN_INSTRUCTION_in_boucle726 = new BitSet(new long[]{0x0000085900880400L});
	public static final BitSet FOLLOW_expression_in_boucle728 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_FIN_INSTRUCTION_in_boucle730 = new BitSet(new long[]{0x0000004000080000L});
	public static final BitSet FOLLOW_affectation_in_boucle732 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_boucle734 = new BitSet(new long[]{0xAE80004000080000L,0x0000000000000001L});
	public static final BitSet FOLLOW_bloc_in_boucle736 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_affect_in_fonction767 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_IDENTIFIANT_in_fonction769 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_fonction772 = new BitSet(new long[]{0x0880042000000000L});
	public static final BitSet FOLLOW_parametres_effectifs_in_fonction774 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_fonction776 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_bloc_complexe_in_fonction778 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_procedure804 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_IDENTIFIANT_in_procedure806 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_procedure808 = new BitSet(new long[]{0x0880042000000000L});
	public static final BitSet FOLLOW_parametres_effectifs_in_procedure810 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_procedure812 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_bloc_complexe_in_procedure814 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_parametre_in_parametres_effectifs838 = new BitSet(new long[]{0x0000040000000002L});
	public static final BitSet FOLLOW_42_in_parametres_effectifs842 = new BitSet(new long[]{0x0880000000000000L});
	public static final BitSet FOLLOW_parametre_in_parametres_effectifs844 = new BitSet(new long[]{0x0000040000000002L});
	public static final BitSet FOLLOW_type_affect_in_parametre868 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_IDENTIFIANT_in_parametre870 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_61_in_retour892 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_61_in_retour898 = new BitSet(new long[]{0x0000085900880400L});
	public static final BitSet FOLLOW_expression_in_retour901 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_type_ptr928 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_type_ptr930 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_55_in_type_ptr944 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_type_ptr946 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_type_ptr960 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_type_ptr962 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_type_ptr964 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_55_in_type_ptr982 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_type_ptr984 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_type_ptr986 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_int_in_type_affect1010 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_ptr_in_type_affect1012 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_int_in_type_all1023 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_type_all1025 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ou_logique_in_expression1037 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_et_logique_in_ou_logique1050 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_ou_logique1053 = new BitSet(new long[]{0x0000085900880400L});
	public static final BitSet FOLLOW_et_logique_in_ou_logique1056 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
	public static final BitSet FOLLOW_egalite_in_et_logique1070 = new BitSet(new long[]{0x0000000400000002L});
	public static final BitSet FOLLOW_34_in_et_logique1073 = new BitSet(new long[]{0x0000085900880400L});
	public static final BitSet FOLLOW_egalite_in_et_logique1076 = new BitSet(new long[]{0x0000000400000002L});
	public static final BitSet FOLLOW_difference_in_egalite1090 = new BitSet(new long[]{0x0004000200000002L});
	public static final BitSet FOLLOW_set_in_egalite1093 = new BitSet(new long[]{0x0000085900880400L});
	public static final BitSet FOLLOW_difference_in_egalite1100 = new BitSet(new long[]{0x0004000200000002L});
	public static final BitSet FOLLOW_operation_in_difference1113 = new BitSet(new long[]{0x0019800000000002L});
	public static final BitSet FOLLOW_set_in_difference1116 = new BitSet(new long[]{0x0000085900880400L});
	public static final BitSet FOLLOW_operation_in_difference1127 = new BitSet(new long[]{0x0019800000000002L});
	public static final BitSet FOLLOW_terme_in_operation1141 = new BitSet(new long[]{0x0000090000000002L});
	public static final BitSet FOLLOW_set_in_operation1144 = new BitSet(new long[]{0x0000085900880400L});
	public static final BitSet FOLLOW_terme_in_operation1151 = new BitSet(new long[]{0x0000090000000002L});
	public static final BitSet FOLLOW_non_logique_in_terme1166 = new BitSet(new long[]{0x0000204000000002L});
	public static final BitSet FOLLOW_set_in_terme1169 = new BitSet(new long[]{0x0000085900880400L});
	public static final BitSet FOLLOW_non_logique_in_terme1176 = new BitSet(new long[]{0x0000204000000002L});
	public static final BitSet FOLLOW_32_in_non_logique1190 = new BitSet(new long[]{0x0000085800880400L});
	public static final BitSet FOLLOW_moins_uniaire_in_non_logique1195 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_43_in_moins_uniaire1208 = new BitSet(new long[]{0x0000005800880400L});
	public static final BitSet FOLLOW_atom_in_moins_uniaire1213 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIANT_in_atom1223 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_acces_tableau_in_atom1228 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHIFFRES_in_atom1233 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LETTRE_QUOTE_in_atom1238 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pointeur_in_atom1251 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_adresse_in_atom1264 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_36_in_atom1277 = new BitSet(new long[]{0x0000085900880400L});
	public static final BitSet FOLLOW_expression_in_atom1279 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_atom1280 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_appel_fonction_procedure_in_atom1286 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIANT_in_acces_tableau1298 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_53_in_acces_tableau1300 = new BitSet(new long[]{0x0000085900880400L});
	public static final BitSet FOLLOW_expression_in_acces_tableau1302 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_54_in_acces_tableau1305 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_38_in_pointeur1330 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_IDENTIFIANT_in_pointeur1332 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_38_in_pointeur1341 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_pointeur1343 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_IDENTIFIANT_in_pointeur1345 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_35_in_adresse1363 = new BitSet(new long[]{0x0000005000080000L});
	public static final BitSet FOLLOW_IDENTIFIANT_in_adresse1368 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pointeur_in_adresse1370 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_36_in_adresse1373 = new BitSet(new long[]{0x0000004000080000L});
	public static final BitSet FOLLOW_IDENTIFIANT_in_adresse1376 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_pointeur_in_adresse1378 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_adresse1380 = new BitSet(new long[]{0x0000000000000002L});
}
