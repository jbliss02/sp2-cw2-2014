/**
 * 
 */
package calculator;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author J
 *
 */
public class FractionCalculatorTest {


	public void test() {

		FractionCalculator calc = new FractionCalculator();
		
		//input fraction only
		assertEquals("Error",new Fraction(2,3), calc.evaluate(new Fraction(2,3), ""));


		
		
	}
	
	@Test
	public void testEval()
	{
		//test starting with fraction
		assertEquals("Err test 1", new Fraction(1,2), new FractionCalculator().evaluate(new Fraction(1,2), ""));
		
		//operator not supplied after fraction (should console error too)
		assertEquals("Err test 2", new Fraction(0,1), new FractionCalculator().evaluate(new Fraction(1,2), "not"));

		//zero supplied, then a fraction in the instruction
		assertEquals("Err test 3", new Fraction(1,3), new FractionCalculator().evaluate(new Fraction(0,1), "1/3"));
		
		//fraction supplied, followed by a plus, incorrect
		assertEquals("Err test 4", new Fraction(0,1), new FractionCalculator().evaluate(new Fraction(3,4), "+"));
		
		//a simple add
		assertEquals("Err test 5", new Fraction(3,4), new FractionCalculator().evaluate(new Fraction(2,4), "+ 1/4"));
		
		//a simple abs
		assertEquals("Err test 6", new Fraction(8,9), new FractionCalculator().evaluate(new Fraction(8,9), "abs"));
		
		//another abs
		assertEquals("Err test 7", new Fraction(8, 9), new FractionCalculator().evaluate(new Fraction(-8,9), "abs"));
		
		//add followed by a non fraction
		assertEquals("Err test 8", new Fraction(0,1), new FractionCalculator().evaluate(new Fraction(2,4), "+ -"));
		
		//a simple subtract
		assertEquals("Err test 9", new Fraction(5,8), new FractionCalculator().evaluate(new Fraction(6,8), "- 1/8"));

		//a simple divide
		assertEquals("Err test 10", new Fraction(8,3), new FractionCalculator().evaluate(new Fraction(2,3), "/ 1/4"));

		//a simple multiplication
		assertEquals("Err test 11", new Fraction(3,10), new FractionCalculator().evaluate(new Fraction(1,2), "* 3/5"));
		
	}
	
	
	public void testFraction()
	{
		assertEquals("Error", true, new FractionCalculator().isFraction("1/2"));
		assertEquals("Error", true, new FractionCalculator().isFraction("2/1"));
		assertEquals("Error", true, new FractionCalculator().isFraction("-1/200"));
		assertEquals("Error", true, new FractionCalculator().isFraction("1/0"));
		assertEquals("Error", true, new FractionCalculator().isFraction("0/0"));
		assertEquals("Error", false, new FractionCalculator().isFraction("0"));
		assertEquals("Error", false, new FractionCalculator().isFraction("/0"));
		assertEquals("Error", false, new FractionCalculator().isFraction("/"));
		assertEquals("Error", false, new FractionCalculator().isFraction("0/"));
		assertEquals("Error", false, new FractionCalculator().isFraction("+"));
		assertEquals("Error", false, new FractionCalculator().isFraction("1 / 2"));
		assertEquals("Error", false, new FractionCalculator().isFraction("2 /1"));
	}
	
	
	public void testIsOperator()
	{
//		assertEquals("error", true, new FractionCalculator().isOperator("+"));
//		assertEquals("error", false, new FractionCalculator().isOperator("a"));
	}
	
	public void testIsNumeric()
	{
//		assertEquals("Error",true, new FractionCalculator().isNumeric("2"));
//		assertEquals("Error",true, new FractionCalculator().isNumeric(" 2"));
//		assertEquals("Error",false, new FractionCalculator().isNumeric("x"));
//		assertEquals("Error",false, new FractionCalculator().isNumeric("x2"));
//		assertEquals("Error",false, new FractionCalculator().isNumeric("xx"));
//		assertEquals("Error",true, new FractionCalculator().isNumeric("10087"));
//		assertEquals("Error",true, new FractionCalculator().isNumeric("0"));
//		assertEquals("Error",true, new FractionCalculator().isNumeric("-1"));
	}
	
	public void testIsFraction()
	{
		FractionCalculator calc = new FractionCalculator();
		
		//input fraction only
		assertEquals("Error", "2", calc.isFraction("2/3"));
	}

}
