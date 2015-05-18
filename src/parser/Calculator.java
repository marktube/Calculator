package parser;

/**
 * Main program of the expression based calculator ExprEval
 * 
 * @author YanChaoLiu
 * @version 1.00 (Last update: 2015.5.9)
 **/

import exceptions.*; 

public class Calculator {
	/**
	 * The main program of the parser. You should substitute the body of this
	 * method with your experiment result.
	 * 
	 * @param expression
	 *            user input to the calculator from GUI.
	 * @return if the expression is well-formed, return the evaluation result of
	 *         it.
	 * @throws ExpressionException
	 *             if the expression has error, a corresponding exception will
	 *             be raised.
	 **/
	public double calculate(String expression)throws ExpressionException
	{
		// You should substitute this method body ...
		Parser p = new Parser(expression);
		double result = Double.valueOf(p.parsing());
		return result;
	}
}
