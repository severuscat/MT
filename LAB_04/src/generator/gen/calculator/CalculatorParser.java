package calculator;

import java.util.ArrayList;
import java.util.List;
import java.lang.StringBuilder;

public class CalculatorParser {
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

	public class Node_E extends Node {
		Node_E() {
			super("E");
		}
		public int v;
		public int v;
		public int v;
		public int v;
		public int v;
		public int v;
		public int v;
		public int v;
	}

	public class Node_G extends Node {
		Node_G() {
			super("G");
		}
		public int v;
		public int v;
		public int v;
		public int v;
		public int v;
		public int v;
		public int v;
		public int v;
	}

	public class Node_T extends Node {
		Node_T() {
			super("T");
		}
		public int v;
		public int v;
		public int v;
		public int v;
		public int v;
		public int v;
		public int v;
		public int v;
	}

	public class Node_H extends Node {
		Node_H() {
			super("H");
		}
		public int v;
		public int v;
		public int v;
		public int v;
		public int v;
		public int v;
		public int v;
		public int v;
	}

	public class Node_F extends Node {
		Node_F() {
			super("F");
		}
		public int v;
		public int v;
		public int v;
		public int v;
		public int v;
		public int v;
		public int v;
		public int v;
	}

	public class Node_PlusOp extends Node {
		Node_PlusOp() {
			super("PlusOp");
		}
		public int v;
		public int v;
		public int v;
		public int v;
		public int v;
		public int v;
		public int v;
		public int v;
	}

	public class Node_MinusOp extends Node {
		Node_MinusOp() {
			super("MinusOp");
		}
		public int v;
		public int v;
		public int v;
		public int v;
		public int v;
		public int v;
		public int v;
		public int v;
	}

	public class Node_MulOp extends Node {
		Node_MulOp() {
			super("MulOp");
		}
		public int v;
		public int v;
		public int v;
		public int v;
		public int v;
		public int v;
		public int v;
		public int v;
	}

	private CalculatorLexicalAnalyzer lexicalAnalyzer;

	public CalculatorParser(CalculatorLexicalAnalyzer lexicalAnalyzer) throws Exception {
		this.lexicalAnalyzer = lexicalAnalyzer;
		buildTree();
	}

	private void buildTree() throws Exception {
		tree = _E();
		if (lexicalAnalyzer.getCurrentToken() != CalculatorToken._END) {
			throw new Exception("Cur token is " + lexicalAnalyzer.getCurrentToken().toString() + " but expected END.");
		}
	}

	public void printTree() {
		System.out.println(tree.treeToString(new ArrayList<>()));
	}

	public int getv() {
		return ((Node_E)tree).v;
	}
	public int getv() {
		return ((Node_E)tree).v;
	}
	public int getv() {
		return ((Node_E)tree).v;
	}
	public int getv() {
		return ((Node_E)tree).v;
	}
	public int getv() {
		return ((Node_E)tree).v;
	}
	public int getv() {
		return ((Node_E)tree).v;
	}
	public int getv() {
		return ((Node_E)tree).v;
	}
	public int getv() {
		return ((Node_E)tree).v;
	}

	private void consume(CalculatorToken token) throws Exception{
		if (lexicalAnalyzer.getCurrentToken() != token) {
			throw new Exception("Expected another token.");
		}
	}

	private Node_E _E(int a, int a, int a, int b, int a, int b, int a, int b) throws Exception {
		Node_E res = new Node_E();
		switch (lexicalAnalyzer.getCurrentToken()) {
			default : 
				throw new Exception("Unexpected token.");
		}
	}

	private Node_G _G(int a, int a, int a, int b, int a, int b, int a, int b) throws Exception {
		Node_G res = new Node_G();
		switch (lexicalAnalyzer.getCurrentToken()) {
			default : 
				throw new Exception("Unexpected token.");
		}
	}

	private Node_T _T(int a, int a, int a, int b, int a, int b, int a, int b) throws Exception {
		Node_T res = new Node_T();
		switch (lexicalAnalyzer.getCurrentToken()) {
			default : 
				throw new Exception("Unexpected token.");
		}
	}

	private Node_H _H(int a, int a, int a, int b, int a, int b, int a, int b) throws Exception {
		Node_H res = new Node_H();
		switch (lexicalAnalyzer.getCurrentToken()) {
			default : 
				throw new Exception("Unexpected token.");
		}
	}

	private Node_F _F(int a, int a, int a, int b, int a, int b, int a, int b) throws Exception {
		Node_F res = new Node_F();
		switch (lexicalAnalyzer.getCurrentToken()) {
			default : 
				throw new Exception("Unexpected token.");
		}
	}

	private Node_PlusOp _PlusOp(int a, int a, int a, int b, int a, int b, int a, int b) throws Exception {
		Node_PlusOp res = new Node_PlusOp();
		switch (lexicalAnalyzer.getCurrentToken()) {
			default : 
				throw new Exception("Unexpected token.");
		}
	}

	private Node_MinusOp _MinusOp(int a, int a, int a, int b, int a, int b, int a, int b) throws Exception {
		Node_MinusOp res = new Node_MinusOp();
		switch (lexicalAnalyzer.getCurrentToken()) {
			default : 
				throw new Exception("Unexpected token.");
		}
	}

	private Node_MulOp _MulOp(int a, int a, int a, int b, int a, int b, int a, int b) throws Exception {
		Node_MulOp res = new Node_MulOp();
		switch (lexicalAnalyzer.getCurrentToken()) {
			default : 
				throw new Exception("Unexpected token.");
		}
	}

}
