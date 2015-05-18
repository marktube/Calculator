package scanner;
/**
 * Main program of the expression based calculator ExprEval
 * 
 * @author YanChaoLiu
 * @version 1.00 (Last update: 2015.5.12)
 **/
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import scanner.Token;

import exceptions.*;

public class Scanner {

	private String expr = "";
	private int forword = 0;
	private int lexemeBegin = 0;

	public Scanner(String e) {
		// TODO Auto-generated constructor stub
		expr = e;
	}

	public Token getNextToken() throws LexicalException{
		// TODO finish the function
		String token = "";
		String type;
		Token tmp = null;
		char lookahead = nextchar();
		int state = 0;
		forword = -1;
		while (state != -1) {
			forword++;
			lookahead = nextchar();
			switch (state) {
			case 0:// 首字符判断
				if (Character.isDigit(lookahead)) {
					token += lookahead;
					state = 1;
				} else if (lookahead == '+' || lookahead == '-'
						|| lookahead == '*' || lookahead == '/'
						|| lookahead == '^' || lookahead == '('
						|| lookahead == ')' || lookahead == ',') {
					token += lookahead;
					type = "ArithOp";
					tmp = new Token(type, token);
					// tmp.setLabel("ArithOp");
					forword++;
					state = -1;
				} else if (lookahead == '&' || lookahead == '|'
						|| lookahead == '!') {
					token += lookahead;
					type = "LogicOp";
					tmp = new Token(type, token);
					// tmp.setLabel("LogicOp");
					forword++;
					state = -1;
				} else if (lookahead == ':' || lookahead == '?') {
					token += lookahead;
					type = "TrinaryOp";
					tmp = new Token(type, token);
					// tmp.setLabel("TrinaryOp");
					forword++;
					state = -1;
				} else if (lookahead == '=') {
					token += lookahead;
					type = "RelationOp";
					tmp = new Token(type, token);
					// tmp.setLabel("RelationOp");
					forword++;
					state = -1;
				} else if (lookahead == '<') {
					token += lookahead;
					state = 4;
				} else if (lookahead == '>') {
					token += lookahead;
					state = 5;
				} else if (lookahead == 't') {
					token += lookahead;
					state = 6;
				} else if (lookahead == 'f') {
					token += lookahead;
					state = 7;
				} else if (lookahead == 's') {
					token += lookahead;
					state = 8;
				} else if (lookahead == 'c') {
					token += lookahead;
					state = 9;
				} else if (lookahead == 'm') {
					token += lookahead;
					state = 10;
				} else if (lookahead == '$') {
					state = -1;
					forword++;
					token = "$";
					type = "$";
					tmp = new Token(type, token);
				} else if (lookahead == ' ') {
					state = 0;
				} else {
					// 抛出IllegalSymbolException （非法的符号）
					state = -1;
					throw new IllegalSymbolException();
					//NullPointerException("IllegalSymbolException");
				}
				break;
			case 1:// integral
				if (Character.isDigit(lookahead)) {
					token += lookahead;
					state = 1;
				} else if (lookahead == '.') {
					token += lookahead;
					forword++;
					lookahead = nextchar();
					if (Character.isDigit(lookahead))
						forword--;
					else
						throw new IllegalDecimalException();
						//NullPointerException("IllegalDecimalException");
					state = 2;
				} else if (Character.toLowerCase(lookahead) == 'e') {
					token += lookahead;
					forword++;
					lookahead = nextchar();
					if (lookahead == '+' || lookahead == '-')
						token += lookahead;
					else if (Character.isDigit(lookahead))
						forword--;
					else
						throw new IllegalDecimalException(); 
						//NullPointerException("IllegalSymbolException");
					state = 3;
				} else {
					type = "decimal";
					tmp = new Token(token, type);
					state = -1;
				}
				break;
			case 2:// fraction
				if (Character.isDigit(lookahead)) {
					token += lookahead;
					state = 2;
				} else if (Character.toLowerCase(lookahead) == 'e') {
					token += lookahead;
					forword++;
					lookahead = nextchar();
					if (lookahead == '+' || lookahead == '-')
						token += lookahead;
					else if (Character.isDigit(lookahead))
						forword--;
					else
						throw new IllegalDecimalException();
					//NullPointerException("IllegalSymbolException");
					state = 3;
				} else {
					type = "decimal";
					tmp = new Token(token, type);
					state = -1;
				}
				break;
			case 3:// exponent
				if (Character.isDigit(lookahead)) {
					token += lookahead;
					state = 3;
				} else {
					type = "decimal";
					tmp = new Token(token, type);
					state = -1;
				}
				break;
			case 4:// < <= <>
				if (lookahead == '=' || lookahead == '>') {
					token += lookahead;
					forword++;
					type = "RelationOp";
					tmp = new Token(type, token);
					// tmp.setLabel("RelationOp");
					state = -1;
				} else {
					type = "RelationOp";
					tmp = new Token(type, token);
					state = -1;
				}
				break;
			case 5:// > >=
				if (lookahead == '=') {
					token += lookahead;
					forword++;
					type = "RelationOp";
					tmp = new Token(type, token);
					// tmp.setLabel("RelationOp");
					state = -1;
				} else {
					type = "RelationOp";
					tmp = new Token(type, token);
					state = -1;
				}
				break;
			case 6:// true
				char Cu = expr.charAt(forword + lexemeBegin + 1);
				char Ce = expr.charAt(forword + lexemeBegin + 2);
				if (lookahead == 'r' && Cu == 'u' && Ce == 'e') {
					forword += 3;
					state = -1;
					token += "rue";
					type = "bool";
					tmp = new Token(token, type);
				} else {
					// 抛出IllegalIdentifierException （非法的标识符）
					state = -1;
					throw new IllegalIdentifierException();
					//NullPointerException("IllegalIdentifierException");
				}
				break;
			case 7:// false
				char Cl = expr.charAt(forword + lexemeBegin + 1);
				char Cs = expr.charAt(forword + lexemeBegin + 2);
				char Ce2 = expr.charAt(forword + lexemeBegin + 3);

				if (lookahead == 'a' && Cl == 'l' && Cs == 's' && Ce2 == 'e') {
					forword += 4;
					state = -1;
					token += "alse";
					type = "bool";
					tmp = new Token(token, type);
				} else {
					// 抛出IllegalIdentifierException （非法的标识符）
					state = -1;
					throw new IllegalIdentifierException();
					//NullPointerException("IllegalIdentifierException");
				}
				break;
			case 8:// sin
				char Cn = expr.charAt(forword + lexemeBegin + 1);
				if (lookahead == 'i' && Cn == 'n') {
					forword += 2;
					state = -1;
					token += "in";
					type = "PredefinedOp";
					tmp = new Token(type, token);
					// tmp.setLabel("PredefinedOp");
				} else {
					// 抛出IllegalIdentifierException （非法的标识符）
					state = -1;
					throw new IllegalIdentifierException();
					//NullPointerException("IllegalIdentifierException");
				}
				break;
			case 9:// cos
				char Cs2 = expr.charAt(forword + lexemeBegin + 1);
				if (lookahead == 'o' && Cs2 == 's') {
					forword += 2;
					state = -1;
					token += "os";
					type = "PredefinedOp";
					tmp = new Token(type, token);
					// tmp.setLabel("PredefinedOp");
				} else {
					// 抛出IllegalIdentifierException （非法的标识符）
					state = -1;
					throw new IllegalIdentifierException();
					//NullPointerException("IllegalIdentifierException");
				}
				break;
			case 10:// min max
				char Clast = expr.charAt(forword + lexemeBegin + 1);
				if (lookahead == 'i' && Clast == 'n') {
					forword += 2;
					state = -1;
					token += "in";
					type = "PredefinedOp";
					tmp = new Token(type, token);
					// tmp.setLabel("PredefinedOp");
				} else if (lookahead == 'a' && Clast == 'x') {
					forword += 2;
					state = -1;
					token += "ax";
					type = "PredefinedOp";
					tmp = new Token(type, token);
					// tmp.setLabel("PredefinedOp");
				} else {
					// 抛出IllegalIdentifierException （非法的标识符）
					state = -1;
					throw new IllegalIdentifierException();
					//NullPointerException("IllegalIdentifierException");
				}
				break;
			default:
				state = -1;
				throw new NullPointerException("unknownException");
				// break;
			}
		}
		lexemeBegin += forword;
		forword = 0;
		return tmp;
	}

	protected char nextchar() {
		if (forword + lexemeBegin < expr.length())
			return expr.charAt(forword + lexemeBegin);
		else
			return '$';
	}

	protected void react() {

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner x = new Scanner(
				"19090.4556 + 1332 - ( 2e-3 - 33.4566e+9 ) * true ? sin45:2/false?3:4+max(12,13)-min(502,320)");
		Token a;
		a = x.getNextToken();
		while (a.getType() != "$") {
			System.out.println("type: " + a.getType());
			System.out.println("label: " + a.getLabel());
			System.out.println("value: " + a.getValue());
			a = x.getNextToken();
		}
		// String b = "2e-3";
		Map<String, String> mm = new HashMap<String, String>();
		mm.put("$>", "yes");
		mm.put("aaa", ">");
		if ((a.getType() + ">").compareTo("$>") == 0)
			System.out.println(mm.get((a.getType() + ">")));
		if (mm.get("aaa") == ">")
			System.out.println("yes");
		Stack<Token> st = new Stack<Token>();
		st.push(a);
		System.out.println(st.elementAt(st.size() - 1).getValue());
	}
}
