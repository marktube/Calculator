package parser;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

import scanner.Scanner;
import scanner.Token;
import exceptions.*;

public class Parser {

	/**
	 * @param args
	 */
	private Scanner scan;
	private Stack<Token> list;
	// private String result;
	static Map<String, String> table;

	Parser(String exp) {
		// TODO Auto-generated method stub
		list = new Stack<Token>();
		table = new HashMap<String, String>();
		scan = new Scanner(exp);
		/******************************* BasicType *******************************/
		table.put("decimaldecimal", "1");
		table.put("decimalbool", "1");
		table.put("decimalsin", "1");
		table.put("decimalcos", "1");
		table.put("decimalmin", "1");
		table.put("decimalmax", "1");
		table.put("decimalneg", ">");
		table.put("decimal,", ">");
		table.put("decimal+", ">");
		table.put("decimal-", ">");
		table.put("decimal*", ">");
		table.put("decimal/", ">");
		table.put("decimal^", ">");
		table.put("decimal(", "1");
		table.put("decimal)", ">");
		table.put("decimal?", ">");
		table.put("decimal:", ">");
		table.put("decimal>", ">");
		table.put("decimal<", ">");
		table.put("decimal=", ">");
		table.put("decimal>=", ">");
		table.put("decimal<=", ">");
		table.put("decimal<>", ">");
		table.put("decimal|", ">");
		table.put("decimal&", ">");
		table.put("decimal!", ">");
		table.put("decimal$", ">");

		table.put("booldecimal", "1");
		table.put("boolbool", "1");
		table.put("boolsin", "1");
		table.put("boolcos", "1");
		table.put("boolmin", "1");
		table.put("boolmax", "1");
		table.put("boolneg", ">");
		table.put("bool,", ">");
		table.put("bool+", ">");
		table.put("bool-", ">");
		table.put("bool*", ">");
		table.put("bool/", ">");
		table.put("bool^", ">");
		table.put("bool(", "1");
		table.put("bool)", ">");
		table.put("bool?", ">");
		table.put("bool:", ">");
		table.put("bool>", ">");
		table.put("bool<", ">");
		table.put("bool=", ">");
		table.put("bool>=", ">");
		table.put("bool<=", ">");
		table.put("bool<>", ">");
		table.put("bool|", ">");
		table.put("bool&", ">");
		table.put("bool!", ">");
		table.put("bool$", ">");
		/******************************* PredefinedOp *******************************/
		table.put("sindecimal", "5");
		table.put("sinbool", "5");
		table.put("sinsin", "5");
		table.put("sincos", "5");
		table.put("sinmin", "5");
		table.put("sinmax", "5");
		table.put("sinneg", "5");
		table.put("sin,", "5");
		table.put("sin+", "5");
		table.put("sin-", "5");
		table.put("sin*", "5");
		table.put("sin/", "5");
		table.put("sin^", "5");
		table.put("sin(", "=");
		table.put("sin)", "5");
		table.put("sin?", "5");
		table.put("sin:", "5");
		table.put("sin>", "5");
		table.put("sin<", "5");
		table.put("sin=", "5");
		table.put("sin>=", "5");
		table.put("sin<=", "5");
		table.put("sin<>", "5");
		table.put("sin|", "5");
		table.put("sin&", "5");
		table.put("sin!", "5");
		table.put("sin$", ">");

		table.put("cosdecimal", "5");
		table.put("cosbool", "5");
		table.put("cossin", "5");
		table.put("coscos", "5");
		table.put("cosmin", "5");
		table.put("cosmax", "5");
		table.put("cosneg", "5");
		table.put("cos,", "5");
		table.put("cos+", "5");
		table.put("cos-", "5");
		table.put("cos*", "5");
		table.put("cos/", "5");
		table.put("cos^", "5");
		table.put("cos(", "=");
		table.put("cos)", "5");
		table.put("cos?", "5");
		table.put("cos:", "5");
		table.put("cos>", "5");
		table.put("cos<", "5");
		table.put("cos=", "5");
		table.put("cos>=", "5");
		table.put("cos<=", "5");
		table.put("cos<>", "5");
		table.put("cos|", "5");
		table.put("cos&", "5");
		table.put("cos!", "5");
		table.put("cos$", ">");

		table.put("mindecimal", "5");
		table.put("minbool", "5");
		table.put("minsin", "5");
		table.put("mincos", "5");
		table.put("minmin", "5");
		table.put("minmax", "5");
		table.put("minneg", "5");
		table.put("min,", "5");
		table.put("min+", "5");
		table.put("min-", "5");
		table.put("min*", "5");
		table.put("min/", "5");
		table.put("min^", "5");
		table.put("min(", "=");
		table.put("min)", "5");
		table.put("min?", "5");
		table.put("min:", "5");
		table.put("min>", "5");
		table.put("min<", "5");
		table.put("min=", "5");
		table.put("min>=", "5");
		table.put("min<=", "5");
		table.put("min<>", "5");
		table.put("min|", "5");
		table.put("min&", "5");
		table.put("min!", "5");
		table.put("min$", ">");

		table.put("maxdecimal", "5");
		table.put("maxbool", "5");
		table.put("maxsin", "5");
		table.put("maxcos", "5");
		table.put("maxmin", "5");
		table.put("maxmax", "5");
		table.put("maxneg", "5");
		table.put("max,", "5");
		table.put("max+", "5");
		table.put("max-", "5");
		table.put("max*", "5");
		table.put("max/", "5");
		table.put("max^", "5");
		table.put("max(", "=");
		table.put("max)", "5");
		table.put("max?", "5");
		table.put("max:", "5");
		table.put("max>", "5");
		table.put("max<", "5");
		table.put("max=", "5");
		table.put("max>=", "5");
		table.put("max<=", "5");
		table.put("max<>", "5");
		table.put("max|", "5");
		table.put("max&", "5");
		table.put("max!", "5");
		table.put("max$", ">");

		table.put(",decimal", "<");
		table.put(",bool", "<");
		table.put(",sin", "<");
		table.put(",cos", "<");
		table.put(",min", "<");
		table.put(",max", "<");
		table.put(",neg", "<");
		table.put(",,", "<");
		table.put(",+", "<");
		table.put(",-", "<");
		table.put(",*", "<");
		table.put(",/", "<");
		table.put(",^", "<");
		table.put(",(", "<");
		table.put(",)", "<");
		table.put(",?", "<");
		table.put(",:", "<");
		table.put(",>", "<");
		table.put(",<", "<");
		table.put(",=", "<");
		table.put(",>=", "<");
		table.put(",<=", "<");
		table.put(",<>", "<");
		table.put(",|", "<");
		table.put(",&", "<");
		table.put(",!", "<");
		table.put(",$", "5");
		/******************************* ArithOp *******************************/
		table.put("negdecimal", "<");
		table.put("negbool", "<");
		table.put("negsin", "<");
		table.put("negcos", "<");
		table.put("negmin", "<");
		table.put("negmax", "<");
		table.put("negneg", "<");
		table.put("neg,", ">");
		table.put("neg+", ">");
		table.put("neg-", ">");
		table.put("neg*", "<");
		table.put("neg/", "<");
		table.put("neg^", "<");
		table.put("neg(", "<");
		table.put("neg)", ">");
		table.put("neg?", ">");
		table.put("neg:", ">");
		table.put("neg>", ">");
		table.put("neg<", ">");
		table.put("neg=", ">");
		table.put("neg>=", ">");
		table.put("neg<=", ">");
		table.put("neg<>", ">");
		table.put("neg|", ">");
		table.put("neg&", ">");
		table.put("neg!", ">");
		table.put("neg$", ">");

		table.put("+decimal", "<");
		table.put("+bool", "<");
		table.put("+sin", "<");
		table.put("+cos", "<");
		table.put("+min", "<");
		table.put("+max", "<");
		table.put("+neg", "<");
		table.put("+,", ">");
		table.put("++", ">");
		table.put("+-", ">");
		table.put("+*", "<");
		table.put("+/", "<");
		table.put("+^", "<");
		table.put("+(", "<");
		table.put("+)", ">");
		table.put("+?", ">");
		table.put("+:", ">");
		table.put("+>", ">");
		table.put("+<", ">");
		table.put("+=", ">");
		table.put("+>=", ">");
		table.put("+<=", ">");
		table.put("+<>", ">");
		table.put("+|", ">");
		table.put("+&", ">");
		table.put("+!", ">");
		table.put("+$", ">");

		table.put("-decimal", "<");
		table.put("-bool", "<");
		table.put("-sin", "<");
		table.put("-cos", "<");
		table.put("-min", "<");
		table.put("-max", "<");
		table.put("-neg", "<");
		table.put("-,", ">");
		table.put("-+", ">");
		table.put("--", ">");
		table.put("-*", "<");
		table.put("-/", "<");
		table.put("-^", "<");
		table.put("-(", "<");
		table.put("-)", ">");
		table.put("-?", ">");
		table.put("-:", ">");
		table.put("->", ">");
		table.put("-<", ">");
		table.put("-=", ">");
		table.put("->=", ">");
		table.put("-<=", ">");
		table.put("-<>", ">");
		table.put("-|", ">");
		table.put("-&", ">");
		table.put("-!", ">");
		table.put("-$", ">");

		table.put("*decimal", "<");
		table.put("*bool", "<");
		table.put("*sin", "<");
		table.put("*cos", "<");
		table.put("*min", "<");
		table.put("*max", "<");
		table.put("*neg", "<");
		table.put("*,", ">");
		table.put("*+", ">");
		table.put("*-", ">");
		table.put("**", ">");
		table.put("*/", ">");
		table.put("*^", "<");
		table.put("*(", "<");
		table.put("*)", ">");
		table.put("*?", ">");
		table.put("*:", ">");
		table.put("*>", ">");
		table.put("*<", ">");
		table.put("*=", ">");
		table.put("*>=", ">");
		table.put("*<=", ">");
		table.put("*<>", ">");
		table.put("*|", ">");
		table.put("*&", ">");
		table.put("*!", ">");
		table.put("*$", ">");

		table.put("/decimal", "<");
		table.put("/bool", "<");
		table.put("/sin", "<");
		table.put("/cos", "<");
		table.put("/min", "<");
		table.put("/max", "<");
		table.put("/neg", "<");
		table.put("/,", ">");
		table.put("/+", ">");
		table.put("/-", ">");
		table.put("/*", ">");
		table.put("//", ">");
		table.put("/^", "<");
		table.put("/(", "<");
		table.put("/)", ">");
		table.put("/?", ">");
		table.put("/:", ">");
		table.put("/>", ">");
		table.put("/<", ">");
		table.put("/=", ">");
		table.put("/>=", ">");
		table.put("/<=", ">");
		table.put("/<>", ">");
		table.put("/|", ">");
		table.put("/&", ">");
		table.put("/!", ">");
		table.put("/$", ">");

		table.put("^decimal", "<");
		table.put("^bool", "<");
		table.put("^sin", "<");
		table.put("^cos", "<");
		table.put("^min", "<");
		table.put("^max", "<");
		table.put("^neg", "<");
		table.put("^,", ">");
		table.put("^+", ">");
		table.put("^-", ">");
		table.put("^*", ">");
		table.put("^/", ">");
		table.put("^^", "<");
		table.put("^(", "<");
		table.put("^)", ">");
		table.put("^?", ">");
		table.put("^:", ">");
		table.put("^>", ">");
		table.put("^<", ">");
		table.put("^=", ">");
		table.put("^>=", ">");
		table.put("^<=", ">");
		table.put("^<>", ">");
		table.put("^|", ">");
		table.put("^&", ">");
		table.put("^!", ">");
		table.put("^$", ">");

		table.put("(decimal", "<");
		table.put("(bool", "<");
		table.put("(sin", "<");
		table.put("(cos", "<");
		table.put("(min", "<");
		table.put("(max", "<");
		table.put("(neg", "<");
		table.put("(,", "<");
		table.put("(+", "<");
		table.put("(-", "<");
		table.put("(*", "<");
		table.put("(/", "<");
		table.put("(^", "<");
		table.put("((", "<");
		table.put("()", "=");
		table.put("(?", "<");
		table.put("(:", "6");
		table.put("(>", "<");
		table.put("(<", "<");
		table.put("(=", "<");
		table.put("(>=", "<");
		table.put("(<=", "<");
		table.put("(<>", "<");
		table.put("(|", "<");
		table.put("(&", "<");
		table.put("(!", "<");
		table.put("($", "4");

		table.put(")decimal", "1");
		table.put(")bool", "1");
		table.put(")sin", "<");
		table.put(")cos", "<");
		table.put(")min", "<");
		table.put(")max", "<");
		table.put(")neg", "1");
		table.put("),", ">");
		table.put(")+", ">");
		table.put(")-", ">");
		table.put(")*", ">");
		table.put(")/", ">");
		table.put(")^", ">");
		table.put(")(", "1");
		table.put("))", ">");
		table.put(")?", ">");
		table.put("):", ">");
		table.put(")>", ">");
		table.put(")<", ">");
		table.put(")=", ">");
		table.put(")>=", ">");
		table.put(")<=", ">");
		table.put(")<>", ">");
		table.put(")|", ">");
		table.put(")&", ">");
		table.put(")!", ">");
		table.put(")$", ">");
		/******************************* LogicOp *******************************/
		table.put("!decimal", "<");
		table.put("!bool", "<");
		table.put("!sin", "<");
		table.put("!cos", "<");
		table.put("!min", "<");
		table.put("!max", "<");
		table.put("!neg", "<");
		table.put("!,", ">");
		table.put("!+", "<");
		table.put("!-", "<");
		table.put("!*", "<");
		table.put("!/", "<");
		table.put("!^", "<");
		table.put("!(", "<");
		table.put("!)", ">");
		table.put("!?", ">");
		table.put("!:", ">");
		table.put("!>", "<");
		table.put("!<", "<");
		table.put("!=", "<");
		table.put("!>=", "<");
		table.put("!<=", "<");
		table.put("!<>", "<");
		table.put("!|", ">");
		table.put("!&", ">");
		table.put("!!", "<");
		table.put("!$", ">");

		table.put("&decimal", "<");
		table.put("&bool", "<");
		table.put("&sin", "<");
		table.put("&cos", "<");
		table.put("&min", "<");
		table.put("&max", "<");
		table.put("&neg", "<");
		table.put("&,", ">");
		table.put("&+", "<");
		table.put("&-", "<");
		table.put("&*", "<");
		table.put("&/", "<");
		table.put("&^", "<");
		table.put("&(", "<");
		table.put("&)", ">");
		table.put("&?", ">");
		table.put("&:", ">");
		table.put("&>", "<");
		table.put("&<", "<");
		table.put("&=", "<");
		table.put("&>=", "<");
		table.put("&<=", "<");
		table.put("&<>", "<");
		table.put("&|", ">");
		table.put("&&", ">");
		table.put("&!", "<");
		table.put("&$", ">");

		table.put("|decimal", "<");
		table.put("|bool", "<");
		table.put("|sin", "<");
		table.put("|cos", "<");
		table.put("|min", "<");
		table.put("|max", "<");
		table.put("|neg", "<");
		table.put("|,", ">");
		table.put("|+", "<");
		table.put("|-", "<");
		table.put("|*", "<");
		table.put("|/", "<");
		table.put("|^", "<");
		table.put("|(", "<");
		table.put("|)", ">");
		table.put("|?", ">");
		table.put("|:", ">");
		table.put("|>", "<");
		table.put("|<", "<");
		table.put("|=", "<");
		table.put("|>=", "<");
		table.put("|<=", "<");
		table.put("|<>", "<");
		table.put("||", ">");
		table.put("|&", ">");
		table.put("|!", "<");
		table.put("|$", ">");
		/******************************* RelationOp *******************************/
		table.put("<decimal", "<");
		table.put("<bool", "<");
		table.put("<sin", "<");
		table.put("<cos", "<");
		table.put("<min", "<");
		table.put("<max", "<");
		table.put("<neg", "<");
		table.put("<,", ">");
		table.put("<+", "<");
		table.put("<-", "<");
		table.put("<*", "<");
		table.put("</", "<");
		table.put("<^", "<");
		table.put("<(", "<");
		table.put("<)", ">");
		table.put("<?", ">");
		table.put("<:", ">");
		table.put("<>", ">");
		table.put("<<", ">");
		table.put("<=", ">");
		table.put("<>=", ">");
		table.put("<<=", ">");
		table.put("<<>", ">");
		table.put("<|", ">");
		table.put("<&", ">");
		table.put("<!", ">");
		table.put("<$", ">");

		table.put(">decimal", "<");
		table.put(">bool", "<");
		table.put(">sin", "<");
		table.put(">cos", "<");
		table.put(">min", "<");
		table.put(">max", "<");
		table.put(">neg", "<");
		table.put(">,", ">");
		table.put(">+", "<");
		table.put(">-", "<");
		table.put(">*", "<");
		table.put(">/", "<");
		table.put(">^", "<");
		table.put(">(", "<");
		table.put(">)", ">");
		table.put(">?", ">");
		table.put(">:", ">");
		table.put(">>", ">");
		table.put("><", ">");
		table.put(">=", ">");
		table.put(">>=", ">");
		table.put("><=", ">");
		table.put("><>", ">");
		table.put(">|", ">");
		table.put(">&", ">");
		table.put(">!", ">");
		table.put(">$", ">");
		table.put("=decimal", "<");
		table.put("=bool", "<");
		table.put("=sin", "<");
		table.put("=cos", "<");
		table.put("=min", "<");
		table.put("=max", "<");
		table.put("=neg", "<");
		table.put("=,", ">");
		table.put("=+", "<");
		table.put("=-", "<");
		table.put("=*", "<");
		table.put("=/", "<");
		table.put("=^", "<");
		table.put("=(", "<");
		table.put("=)", ">");
		table.put("=?", ">");
		table.put("=:", ">");
		table.put("=>", ">");
		table.put("=<", ">");
		table.put("==", ">");
		table.put("=>=", ">");
		table.put("=<=", ">");
		table.put("=<>", ">");
		table.put("=|", ">");
		table.put("=&", ">");
		table.put("=!", ">");
		table.put("=$", ">");

		table.put("<=decimal", "<");
		table.put("<=bool", "<");
		table.put("<=sin", "<");
		table.put("<=cos", "<");
		table.put("<=min", "<");
		table.put("<=max", "<");
		table.put("<=neg", "<");
		table.put("<=,", ">");
		table.put("<=+", "<");
		table.put("<=-", "<");
		table.put("<=*", "<");
		table.put("<=/", "<");
		table.put("<=^", "<");
		table.put("<=(", "<");
		table.put("<=)", ">");
		table.put("<=?", ">");
		table.put("<=:", ">");
		table.put("<=>", ">");
		table.put("<=<", ">");
		table.put("<==", ">");
		table.put("<=>=", ">");
		table.put("<=<=", ">");
		table.put("<=<>", ">");
		table.put("<=|", ">");
		table.put("<=&", ">");
		table.put("<=!", ">");
		table.put("<=$", ">");

		table.put(">=decimal", "<");
		table.put(">=bool", "<");
		table.put(">=sin", "<");
		table.put(">=cos", "<");
		table.put(">=min", "<");
		table.put(">=max", "<");
		table.put(">=neg", "<");
		table.put(">=,", ">");
		table.put(">=+", "<");
		table.put(">=-", "<");
		table.put(">=*", "<");
		table.put(">=/", "<");
		table.put(">=^", "<");
		table.put(">=(", "<");
		table.put(">=)", ">");
		table.put(">=?", ">");
		table.put(">=:", ">");
		table.put(">=>", ">");
		table.put(">=<", ">");
		table.put(">==", ">");
		table.put(">=>=", ">");
		table.put(">=<=", ">");
		table.put(">=<>", ">");
		table.put(">=|", ">");
		table.put(">=&", ">");
		table.put(">=!", ">");
		table.put(">=$", ">");

		table.put("<>decimal", "<");
		table.put("<>bool", "<");
		table.put("<>sin", "<");
		table.put("<>cos", "<");
		table.put("<>min", "<");
		table.put("<>max", "<");
		table.put("<>neg", "<");
		table.put("<>,", ">");
		table.put("<>+", "<");
		table.put("<>-", "<");
		table.put("<>*", "<");
		table.put("<>/", "<");
		table.put("<>^", "<");
		table.put("<>(", "<");
		table.put("<>)", ">");
		table.put("<>?", ">");
		table.put("<>:", ">");
		table.put("<>>", ">");
		table.put("<><", ">");
		table.put("<>=", ">");
		table.put("<>>=", ">");
		table.put("<><=", ">");
		table.put("<><>", ">");
		table.put("<>|", ">");
		table.put("<>&", ">");
		table.put("<>!", ">");
		table.put("<>$", ">");

		/******************************* TrinaryOp *******************************/
		table.put("?decimal", "<");
		table.put("?bool", "<");
		table.put("?sin", "<");
		table.put("?cos", "<");
		table.put("?min", "<");
		table.put("?max", "<");
		table.put("?neg", "<");
		table.put("?,", "6");
		table.put("?+", "<");
		table.put("?-", "<");
		table.put("?*", "<");
		table.put("?/", "<");
		table.put("?^", "<");
		table.put("?(", "<");
		table.put("?)", "6");
		table.put("??", "<");
		table.put("?:", "=");
		table.put("?>", "<");
		table.put("?<", "<");
		table.put("?=", "<");
		table.put("?>=", "<");
		table.put("?<=", "<");
		table.put("?<>", "<");
		table.put("?|", "<");
		table.put("?&", "<");
		table.put("?!", "<");
		table.put("?$", ">");

		table.put(":decimal", "<");
		table.put(":bool", "<");
		table.put(":sin", "<");
		table.put(":cos", "<");
		table.put(":min", "<");
		table.put(":max", "<");
		table.put(":neg", "<");
		table.put(":,", ">");
		table.put(":+", "<");
		table.put(":-", "<");
		table.put(":*", "<");
		table.put(":/", "<");
		table.put(":^", "<");
		table.put(":(", "<");
		table.put(":)", ">");
		table.put(":?", "<");
		table.put("::", ">");
		table.put(":>", "<");
		table.put(":<", "<");
		table.put(":=", "<");
		table.put(":>=", "<");
		table.put(":<=", "<");
		table.put(":<>", "<");
		table.put(":|", "<");
		table.put(":&", "<");
		table.put(":!", "<");
		table.put(":$", ">");
		/******************************* EndOp *******************************/
		table.put("$decimal", "<");
		table.put("$bool", "<");
		table.put("$sin", "<");
		table.put("$cos", "<");
		table.put("$min", "<");
		table.put("$max", "<");
		table.put("$neg", "<");
		table.put("$,", "<");
		table.put("$+", "<");
		table.put("$-", "<");
		table.put("$*", "<");
		table.put("$/", "<");
		table.put("$^", "<");
		table.put("$(", "<");
		table.put("$)", "3");
		table.put("$?", "<");
		table.put("$:", "<");
		table.put("$>", "<");
		table.put("$<", "<");
		table.put("$=", "<");
		table.put("$>=", "<");
		table.put("$<=", "<");
		table.put("$<>", "<");
		table.put("$|", "<");
		table.put("$&", "<");
		table.put("$!", "<");
		// table.put("$$", "<");
	}

	public void arithOpReduce() throws SyntacticException,SemanticException{
		// operand type
		double oprand1 = 0, oprand2 = 0;
		if (list.peek().getType() == "decimal")
			oprand2 = Double.valueOf(list.pop().getValue());
		else if (list.peek().getType() == "bool")
			throw new TypeMismatchedException();
			//NullPointerException("TypeMismatchedException");
		else
			throw new MissingOperandException();
			//NullPointerException("MissingOperandException");
		// oprand read
		String operator = list.pop().getType();
		if (operator == "neg") {
			Token res = new Token(String.valueOf(-oprand2), "decimal");
			// set token
			list.push(res);
			return;
		}

		if (list.peek().getType() == "decimal")
			oprand1 = Double.valueOf(list.pop().getValue());
		else if (list.peek().getType() == "bool")
			throw new TypeMismatchedException();
			//NullPointerException("TypeMismatchedException");
		else
			throw new MissingOperandException();
			//NullPointerException("MissingOperandException");

		// begin reduce
		if (operator.compareTo("+") == 0) {
			Token tmp = new Token(String.valueOf(oprand1 + oprand2), "decimal");
			tmp.setLabel("");// set label
			list.push(tmp);
		} else if (operator.compareTo("-") == 0) {
			Token tmp = new Token(String.valueOf(oprand1 - oprand2), "decimal");
			list.push(tmp);
		} else if (operator.compareTo("*") == 0) {
			Token tmp = new Token(String.valueOf(oprand1 * oprand2), "decimal");
			list.push(tmp);
		} else if (operator.compareTo("/") == 0) {
			if (oprand2 == 0)
				throw new DividedByZeroException();
				//NullPointerException("Divid by zero");// divide by 0
			Token tmp = new Token(String.valueOf(oprand1 / oprand2), "decimal");
			list.push(tmp);
		} else if (operator.compareTo("^") == 0) {
			Token tmp = new Token(String.valueOf(Math.pow(oprand1, oprand2)),
					"decimal");
			list.push(tmp);
		} else
			throw new MissingOperatorException();
			//NullPointerException("MissingOperatorException");
		// list.pop();
	}

	public void relationOpReduce() throws SyntacticException,SemanticException{
		// 类型判断
		double oprand1 = 0, oprand2 = 0;
		if (list.peek().getType() == "decimal")
			oprand2 = Double.valueOf(list.pop().getValue());
		else if (list.peek().getType() == "bool")
			throw new TypeMismatchedException();
			//NullPointerException("TypeMismatchedException");
		else
			throw new MissingOperandException();
			//NullPointerException("MissingOperandException");

		// read op
		String operator = list.pop().getType();

		if (list.peek().getType() == "decimal")
			oprand1 = Double.valueOf(list.pop().getValue());
		else if (list.peek().getType() == "bool")
			throw new TypeMismatchedException();
			//NullPointerException("TypeMismatchedException");
		else
			throw new MissingOperandException();
			//NullPointerException("MissingOperandException");

		if (operator.compareTo(">") == 0) {
			Token tmpToken = new Token(String.valueOf(oprand1 > oprand2),
					"bool");
			list.push(tmpToken);
		} else if (operator.compareTo("<") == 0) {
			Token tmpToken = new Token(String.valueOf(oprand1 < oprand2),
					"bool");
			list.push(tmpToken);
		} else if (operator.compareTo("=") == 0) {
			Token tmpToken = new Token(String.valueOf(oprand1 == oprand2),
					"bool");
			list.push(tmpToken);
		} else if (operator.compareTo("<=") == 0) {
			Token tmpToken = new Token(String.valueOf(oprand1 <= oprand2),
					"bool");
			list.push(tmpToken);
		} else if (operator.compareTo(">=") == 0) {
			Token tmpToken = new Token(String.valueOf(oprand1 >= oprand2),
					"bool");
			list.push(tmpToken);
		} else if (operator.compareTo("<>") == 0) {
			Token tmpToken = new Token(String.valueOf(oprand1 != oprand2),
					"bool");
			list.push(tmpToken);
		} else
			throw new MissingOperatorException();
			//NullPointerException("MissingOperatorException");
		// list.pop();
	}

	public void logicOpReduce() throws SyntacticException,SemanticException{
		// operand type
		boolean oprand1 = true, oprand2 = false;
		if (list.peek().getType() == "bool")
			oprand2 = Boolean.valueOf(list.pop().getValue());
		else if (list.peek().getType() == "decimal")
			throw new TypeMismatchedException();
			//NullPointerException("TypeMismatchedException");
		else
			throw new MissingOperandException();
			//NullPointerException("MissingOperandException");

		// read op
		String operator = list.pop().getType();
		if (operator.compareTo("!") == 0) {
			Token tmp = new Token(String.valueOf(!oprand2), "bool");
			list.push(tmp);
			return;
		}

		if (list.peek().getType() == "bool")
			oprand1 = Boolean.valueOf(list.pop().getValue());
		else if (list.peek().getType() == "decimal")
			throw new TypeMismatchedException();
			//NullPointerException("TypeMismatchedException");
		else
			throw new MissingOperandException();
			//NullPointerException("MissingOperandException");

		if (operator.compareTo("&") == 0) {
			Token tmpToken = new Token(String.valueOf(oprand1 & oprand2),
					"bool");
			list.push(tmpToken);
		} else if (operator.compareTo("|") == 0) {
			Token tmpToken = new Token(String.valueOf(oprand1 | oprand2),
					"bool");
			list.push(tmpToken);
		} else
			throw new MissingOperatorException();
			//NullPointerException("MissingOperatorException");
		// list.pop();
	}

	public void parenthesisReduce() throws SyntacticException,SemanticException{
		// TODO predefined op: max , min reduce
		LinkedList<Double> cont = new LinkedList<Double>();

		list.pop();// pop )

		Token x = null;
		if (list.peek().getType() == "decimal"
				|| list.peek().getType() == "bool") {
			x = new Token(list.peek().getValue(), list.pop().getType());
		} else
			throw new MissingOperandException();
			//NullPointerException("MissingOperandException");

		if (list.peek().getType().compareTo("(") == 0) {
			list.pop();
			list.push(x);

			if (getTopTerminal().getType().compareTo("sin") == 0) {
				double operand = 0;
				if (list.peek().getType() == "decimal")
					operand = Double.valueOf(list.pop().getValue());
				else if (list.peek().getType() == "bool")
					throw new TypeMismatchedException();//NullPointerException("TypeMismatchedException");
				else
					throw new FunctionCallException();//NullPointerException("FunctionCallException");
				if (list.pop().getType().compareTo("sin") == 0) {
					list.push(new Token(String.valueOf(Math.sin(operand)),
							"decimal"));
				} else
					throw new FunctionCallException();//NullPointerException("FunctionCallException");
				return;
			}

			if (getTopTerminal().getType().compareTo("cos") == 0) {
				double operand = 0;
				if (list.peek().getType() == "decimal")
					operand = Double.valueOf(list.pop().getValue());
				else if (list.peek().getType() == "bool")
					throw new TypeMismatchedException();//NullPointerException("TypeMismatchedException");
				else
					throw new FunctionCallException();//NullPointerException("FunctionCallException");
				if (list.pop().getType().compareTo("cos") == 0) {
					list.push(new Token(String.valueOf(Math.cos(operand)),
							"decimal"));
				} else if (list.peek().getType() == "bool")
					throw new TypeMismatchedException();//NullPointerException("TypeMismatchedException");
				else
					throw new FunctionCallException();//NullPointerException("FunctionCallException");
				return;
			}

			if (getTopTerminal().getType().compareTo("max") == 0
					|| getTopTerminal().getType().compareTo("min") == 0)
				throw new MissingOperandException();//NullPointerException("MissingOperandException");

		} else if (list.peek().getType().compareTo(",") == 0) {
			// TODO MAX&MIN
			if (x.getType() == "decimal")
				cont.push(Double.valueOf(x.getValue()));
			else if (list.peek().getType() == "bool")
				throw new TypeMismatchedException();//NullPointerException("TypeMismatchedException");
			else
				throw new FunctionCallException();//NullPointerException("FunctionCallException");

			while (list.peek().getType().compareTo("(") != 0) {
				if (list.pop().getType().compareTo(",") != 0)
					throw new FunctionCallException();//NullPointerException("FunctionCallException");
				// TODO add numbers to the cont
				if (list.peek().getType() == "decimal") {
					cont.push(Double.valueOf(list.pop().getValue()));
				} else if (list.peek().getType() == "bool")
					throw new TypeMismatchedException();//NullPointerException("TypeMismatchedException");
				else
					throw new FunctionCallException();//NullPointerException("FunctionCallException");
			}
			list.pop();// pop (

			// min max
			if (list.peek().getType().compareTo("min") == 0) {
				list.pop();
				list.push(new Token(String.valueOf(Collections.min(cont)),
						"decimal"));
			} else if (list.peek().getType().compareTo("max") == 0) {
				list.pop();
				list.push(new Token(String.valueOf(Collections.max(cont)),
						"decimal"));
			} else
				throw new FunctionCallException();//NullPointerException("FunctionCallException");

		} else
			throw new MissingLeftParenthesisException();//NullPointerException("MissingLeftParenthesisException");
	}

	public String parsing() throws ExpressionException{
		// TODO FINAL RESULT
		list.clear();
		Token end$ = new Token("$", "$");
		end$.setLabel("Terminal");
		list.push(end$);
		Token lookahead = scan.getNextToken();
		while (true) {

			String tk = getTopTerminal().getType(), op = lookahead.getType();

			if (tk == "$" && op == "$")
				break;
			// used to debug
			// System.out.println(tk + " " + op + " " + table.get(tk + op));
			if (table.get(tk + op) == "<" || table.get(tk + op) == "=") {
				shift(lookahead);
				lookahead = scan.getNextToken();
			} else if (table.get(tk + op) == ">") {
				reduce();
			} else {
				int er = Integer.valueOf(table.get(tk + op));
				switch (er) {
				case 1:
					throw new MissingOperatorException();//NullPointerException("MissingOperatorException");
					// break;
				case 2:
					throw new MissingOperatorException();//NullPointerException("MissingOperatorException");
				case 3:
					throw new MissingLeftParenthesisException();//NullPointerException("MissingLeftParenthesisException");
				case 4:
					throw new MissingRightParenthesisException();//NullPointerException("MissingRightParenthesisException");
				case 5:
					throw new FunctionCallException();//NullPointerException("FunctionCallException");
				case 6:
					throw new TrinaryOperationException();//NullPointerException("TrinaryOperationException");
				default:
					break;
				}
			}
		}

		if(list.empty())
			throw new EmptyExpressionException();
		return list.peek().getValue();
	}

	public void reduce()throws ExpressionException{
		// TODO NEED TO FINISH

		if (getTopTerminal().getType().compareTo(")") == 0) {
			parenthesisReduce();
			return;
		}
		if (getTopTerminal().getValue() == "ArithOp") {
			arithOpReduce();
			return;
		}
		if (getTopTerminal().getValue() == "LogicOp") {
			logicOpReduce();
			return;
		}
		if (getTopTerminal().getValue() == "RelationOp") {
			relationOpReduce();
			return;
		}
		if (getTopTerminal().getValue() == "TrinaryOp") {
			trinaryOpReduce();
			return;
		}
		if (getTopTerminal().getType() == "decimal") {
			getTopTerminal().setLabel("");// TODO set label
			return;
		}
		if (getTopTerminal().getType() == "bool")
			getTopTerminal().setLabel("");// TODO set label
		// return 0;
	}

	public Token getTopTerminal() {
		// TODO finish it !!
		int i = list.size() - 1;
		while (list.elementAt(i).getLabel() != "Terminal")
			i--;
		return list.elementAt(i);
	}

	public void shift(Token t) {
		if (t.getType().compareTo("-") == 0) {
			// list.pop();
			if (list.peek().getType() == ")"
					|| list.peek().getType() == "decimal") {
				t.setLabel("Terminal");
				list.push(t);
			} else {
				Token ng = new Token("ArithOp", "neg");
				ng.setLabel("Terminal");
				list.push(ng);
			}
		} else {
			t.setLabel("Terminal");
			list.push(t);
		}
	}

	public void trinaryOpReduce() throws ExpressionException{
		if (getTopTerminal().getType().compareTo(":") == 0) {
			double oprand1 = 0, oprand2 = 0;
			boolean boolop = true;

			if (list.peek().getType() == "decimal")
				oprand2 = Double.valueOf(list.pop().getValue());
			else if (list.peek().getType() == "bool")
				throw new TypeMismatchedException();//NullPointerException("TypeMismatchedException");
			else
				throw new TrinaryOperationException();//NullPointerException("TrinaryOperationException");

			list.pop();// pop :

			if (list.peek().getType() == "decimal")
				oprand1 = Double.valueOf(list.pop().getValue());
			else if (list.peek().getType() == "bool")
				throw new TypeMismatchedException();//NullPointerException("TypeMismatchedException");
			else
				throw new TrinaryOperationException();//NullPointerException("TrinaryOperationException");

			// pop ?
			if (list.pop().getType().compareTo("?") != 0)
				throw new TrinaryOperationException();//NullPointerException("TrinaryOperationException");

			if (list.peek().getType() == "bool")
				boolop = Boolean.valueOf(list.pop().getValue());
			else if (list.peek().getType() == "decimal")
				throw new TypeMismatchedException();//NullPointerException("TypeMismatchedException");
			else
				throw new TrinaryOperationException();//NullPointerException("TrinaryOperationException");

			if (boolop) {
				list.push(new Token(String.valueOf(oprand1), "decimal"));
			} else {
				list.push(new Token(String.valueOf(oprand2), "decimal"));
			}

		} else
			throw new TrinaryOperationException();//NullPointerException("TrinaryOperationException");
	}

	public static void main(String[] args) throws ExpressionException{
		// TODO Auto-generated method stub
		Parser p = new Parser("sin(min(12, 3 * 5, 2 + 3 ^ 2, 3.14E2))");
		String res = p.parsing();
		System.out.println(res);
	}

}
