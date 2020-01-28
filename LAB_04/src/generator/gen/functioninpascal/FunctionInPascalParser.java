package functioninpascal;

import java.util.ArrayList;
import java.util.List;

public class FunctionInPascalParser {
	public Node tree;
	public static class Node {
		private String name;
		private List<Node> children = new ArrayList<>();

		Node(String s) {
			name = s;
		}

		public void addChild(Node node) {
			children.add(node);
		}

		public String getName() {
			return name;
		}

		StringBuilder treeToString(ArrayList<Boolean> mask) {
			StringBuilder sb = new StringBuilder();
			if (!mask.isEmpty()) {
				sb.append("|__");
			}
			sb.append("'").append(name).append("'").append("\n");
			for (int curChild = 0; curChild < children.size(); ++curChild) {
				for (boolean b : mask) {
					if (b) {
						sb.append("|  ");
					} else {
						sb.append("   ");
					}
				}
				mask.add(curChild != children.size() - 1);
				sb.append(children.get(curChild).treeToString(mask));
				mask.remove(mask.size() - 1);
			}
			return sb;
		}
	}

	public class Node_function_rule extends Node {
		Node_function_rule() {
			super("function_rule");
		}
	}

	public class Node_arguments_list extends Node {
		Node_arguments_list() {
			super("arguments_list");
		}
	}

	public class Node_arguments_list_add extends Node {
		Node_arguments_list_add() {
			super("arguments_list_add");
		}
	}

	public class Node_arguments extends Node {
		Node_arguments() {
			super("arguments");
		}
	}

	public class Node_arguments_add extends Node {
		Node_arguments_add() {
			super("arguments_add");
		}
	}

	private FunctionInPascalLexicalAnalyzer lexicalAnalyzer;

	public FunctionInPascalParser(FunctionInPascalLexicalAnalyzer lexicalAnalyzer) throws Exception {
		this.lexicalAnalyzer = lexicalAnalyzer;
		buildTree();
	}

	private void buildTree() throws Exception {
		tree = _function_rule();
		if (lexicalAnalyzer.getCurrentToken() != FunctionInPascalToken._END) {
			throw new Exception("Cur token is " + lexicalAnalyzer.getCurrentToken().toString() + " but expected END.");
		}
	}

	public void printTree() {
		System.out.println(tree.treeToString(new ArrayList<>()));
	}


	private void consume(FunctionInPascalToken token) throws Exception{
		if (lexicalAnalyzer.getCurrentToken() != token) {
			throw new Exception("Expected another token.");
		}
	}

	private Node_function_rule _function_rule() throws Exception {
		Node_function_rule res = new Node_function_rule();
		switch (lexicalAnalyzer.getCurrentToken()) {
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			default : 
				throw new Exception("Unexpected token.");
		}
	}

	private Node_arguments_list _arguments_list() throws Exception {
		Node_arguments_list res = new Node_arguments_list();
		switch (lexicalAnalyzer.getCurrentToken()) {
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			default : 
				throw new Exception("Unexpected token.");
		}
	}

	private Node_arguments_list_add _arguments_list_add() throws Exception {
		Node_arguments_list_add res = new Node_arguments_list_add();
		switch (lexicalAnalyzer.getCurrentToken()) {
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			default : 
				throw new Exception("Unexpected token.");
		}
	}

	private Node_arguments _arguments() throws Exception {
		Node_arguments res = new Node_arguments();
		switch (lexicalAnalyzer.getCurrentToken()) {
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			default : 
				throw new Exception("Unexpected token.");
		}
	}

	private Node_arguments_add _arguments_add() throws Exception {
		Node_arguments_add res = new Node_arguments_add();
		switch (lexicalAnalyzer.getCurrentToken()) {
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			case FUNCTION :
			{
				consume(FunctionInPascalToken.FUNCTION);
				res.addChild(new Node("FUNCTION"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n0 = _arguments_list();
				res.addChild(n0);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.PROCEDURE);
				res.addChild(new Node("PROCEDURE"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.LP);
				res.addChild(new Node("LP"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list n1 = _arguments_list();
				res.addChild(n1);
				
				consume(FunctionInPascalToken.RP);
				res.addChild(new Node("RP"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n2 = _arguments();
				res.addChild(n2);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n3 = _arguments_list_add();
				res.addChild(n3);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.SEMICOLON);
				res.addChild(new Node("SEMICOLON"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments n4 = _arguments();
				res.addChild(n4);
				
				consume(FunctionInPascalToken.COLON);
				res.addChild(new Node("COLON"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.TYPE);
				res.addChild(new Node("TYPE"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_list_add n5 = _arguments_list_add();
				res.addChild(n5);
				
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n6 = _arguments_add();
				res.addChild(n6);
				
				consume(FunctionInPascalToken.EPS);
				res.addChild(new Node("EPS"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.COMMA);
				res.addChild(new Node("COMMA"));
				
				lexicalAnalyzer.getNextToken();
				consume(FunctionInPascalToken.NAME);
				res.addChild(new Node("NAME"));
				
				lexicalAnalyzer.getNextToken();
				Node_arguments_add n7 = _arguments_add();
				res.addChild(n7);
				
				return res;
			}
			default : 
				throw new Exception("Unexpected token.");
		}
	}

}
