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
		
	}

	@Test
	public void basicEval() throws CalculatorError
	{ 
		//test starting with fraction
		assertEquals("Basic test 1", new Fraction(1,2), new FractionCalculator().evaluate(new Fraction(1,2), ""));
		
		//zero supplied, then a fraction in the instruction
		assertEquals("Basic test 3", new Fraction(1,3), new FractionCalculator().evaluate(new Fraction(0,1), "1/3"));
		
		//fraction supplied, followed by a plus, return the fraction
		assertEquals("Basic test 4", new Fraction(3,4), new FractionCalculator().evaluate(new Fraction(3,4), "+"));
		
		//a simple add
		assertEquals("Basic test 5", new Fraction(3,4), new FractionCalculator().evaluate(new Fraction(2,4), "+ 1/4"));
		
		//a simple abs
		assertEquals("Basic test 6", new Fraction(8,9), new FractionCalculator().evaluate(new Fraction(8,9), "abs"));
		
		//another abs
		assertEquals("Basic test 7", new Fraction(8, 9), new FractionCalculator().evaluate(new Fraction(-8,9), "abs"));
		
		//a simple subtract
		assertEquals("Basic test 9", new Fraction(5,8), new FractionCalculator().evaluate(new Fraction(6,8), "- 1/8"));

		//a simple divide
		assertEquals("Basic test 10", new Fraction(8,3), new FractionCalculator().evaluate(new Fraction(2,3), "/ 1/4"));

		//a simple multiplication
		assertEquals("Basic test 11", new Fraction(3,10), new FractionCalculator().evaluate(new Fraction(1,2), "* 3/5"));
		
		//2 fractions in a row
		assertEquals("Basic test 12", new Fraction(3,5), new FractionCalculator().evaluate(new Fraction(1,2), "3/5"));
		
		//simple double addition
		assertEquals("Basic test 13", new Fraction(3,4), new FractionCalculator().evaluate(new Fraction(1,4), "+ 1/4 + 1/4"));
		
		//simple triple addition
		assertEquals("Basic test 14", new Fraction(4,4), new FractionCalculator().evaluate(new Fraction(1,4), "+ 1/4 + 1/4 + 1/4"));
		
		//simple quadruple addition
		assertEquals("Basic test 15", new Fraction(5,4), new FractionCalculator().evaluate(new Fraction(1,4), "+ 1/4 + 1/4 + 1/4 + 1/4"));
		
		//simple triple addition & a subtract
		assertEquals("Basic test 15", new Fraction(3,4), new FractionCalculator().evaluate(new Fraction(1,4), "+ 1/4 + 1/4 - 1/4 + 1/4"));
	}
	
	@Test 
	public void mixedEval() throws CalculatorError
	{
		assertEquals("Mixed test 1", new Fraction(7,10), new FractionCalculator().evaluate(new Fraction(1,2), "+ 1/5 A"));
		assertEquals("Mixed test 2", new Fraction(7,10), new FractionCalculator().evaluate(new Fraction(1,2), "+ 1/5 a"));
		assertEquals("Mixed test 3", new Fraction(7,10), new FractionCalculator().evaluate(new Fraction(1,2), "+ 1/5 abs"));
		
		assertEquals("Mixed test 4", new Fraction(7,-10), new FractionCalculator().evaluate(new Fraction(1,2), "+ 1/5 N"));
		assertEquals("Mixed test 5", new Fraction(7,-10), new FractionCalculator().evaluate(new Fraction(1,2), "+ 1/5 n"));
		assertEquals("Mixed test 6", new Fraction(7,-10), new FractionCalculator().evaluate(new Fraction(1,2), "+ 1/5 neg"));
		
		assertEquals("Mixed test 7", new Fraction(7,-10), new FractionCalculator().evaluate(new Fraction(1,2), "+ 1/5 abs neg"));
		assertEquals("Mixed test 8", new Fraction(0,1), new FractionCalculator().evaluate(new Fraction(1,2), "+ 1/5 abs neg c"));
		assertEquals("Mixed test 9", new Fraction(7,10), new FractionCalculator().evaluate(new Fraction(1,2), "+ 1/5 A - 1/5 + 1/5"));	
	
		assertEquals("Mixed test 10", new Fraction(1,-5), new FractionCalculator().evaluate(new Fraction(0,1), "+ 1/5 abs neg"));
		assertEquals("Mixed test 11", new Fraction(0,1), new FractionCalculator().evaluate(new Fraction(0,1), "+ 1/5 abs neg c"));
		assertEquals("Mixed test 12", new Fraction(1,5), new FractionCalculator().evaluate(new Fraction(0,1), "+ 1/5 A - 1/5 + 1/5"));	
		
		assertEquals("Mixed test 13", new Fraction(7,-10), new FractionCalculator().evaluate(new Fraction(0,1), "1/2 + 1/5 abs neg"));
		assertEquals("Mixed test 14", new Fraction(0,1), new FractionCalculator().evaluate(new Fraction(0,1), "1/2 + 1/5 abs neg c"));
		assertEquals("Mixed test 15", new Fraction(7,10), new FractionCalculator().evaluate(new Fraction(0,1), "1/2 + 1/5 A - 1/5 + 1/5"));	
	} 

	@Test
	public void wholeNumberEval() throws CalculatorError
	{
		assertEquals("wholeNumber test 1", new Fraction(8,7), new FractionCalculator().evaluate(new Fraction(1,7), "+ 1"));
		assertEquals("wholeNumber test 2", new Fraction(1,7), new FractionCalculator().evaluate(new Fraction(8,7), "- 1"));
		assertEquals("wholeNumber test 3", new Fraction(1,7), new FractionCalculator().evaluate(new Fraction(1,7), "* 1"));
		assertEquals("wholeNumber test 4", new Fraction(8,1), new FractionCalculator().evaluate(new Fraction(4,1), "* 2"));
		
	}
	
	@Test
	public void testBlanks() throws CalculatorError
	{
		//blank at beginning
		assertEquals("blanks test 1", new Fraction(3,4), new FractionCalculator().evaluate(new Fraction(1,4), " + 1/4 + 1/4"));
		//blank at end
		assertEquals("blanks test 2", new Fraction(3,4), new FractionCalculator().evaluate(new Fraction(1,4), "+ 1/4 + 1/4 "));
		//blank at beginning and end
		assertEquals("blanks test 3", new Fraction(3,4), new FractionCalculator().evaluate(new Fraction(1,4), " + 1/4 + 1/4 "));

		
	}
	
	@Test
	public void testClear() throws CalculatorError
	{
		assertEquals("clear test 1", new Fraction(3,4), new FractionCalculator().evaluate(new Fraction(66,7), "+ 1/2 c 3/4"));
		assertEquals("clear test 2", new Fraction(3,4), new FractionCalculator().evaluate(new Fraction(0,1), "+ 1/2 c 3/4"));
		assertEquals("clear test 3", new Fraction(0,1), new FractionCalculator().evaluate(new Fraction(0,1), "+ 1/2 c"));
		assertEquals("clear test 4", new Fraction(0,1), new FractionCalculator().evaluate(new Fraction(0,1), "+ 1/2 c abs"));
		assertEquals("clear test 5", new Fraction(0,-1), new FractionCalculator().evaluate(new Fraction(0,1), "+ 1/2 c neg"));
	}
	
	@Test
	public void testError() //throws UnexpectedCharacter
	{
		//operator not supplied after fraction
		try
		{
			assertEquals("Error test 2", new Fraction(0,1), new FractionCalculator().evaluate(new Fraction(1,2), "not"));
		}
		catch(CalculatorError ex)
		{
			System.out.println(ex.getMessage());
			assertTrue(true);
		}
	}
	
	@Test
	public void TestSequenceError()
	{
		//two operators in a row
		try
		{
			//add followed by a non fraction
			assertEquals("Seq error 1", new Fraction(0,1), new FractionCalculator().evaluate(new Fraction(2,4), "+ -"));
		}
		catch(CalculatorError ex)
		{
			System.out.println(ex.getMessage());
			assertTrue(true);
		}
	}
	
	@Test
	public void testQuit() 
	{
		try
		{
			assertEquals("Ex error 1", new Fraction(-1,4) , new FractionCalculator().evaluate(new Fraction(1,2), "- 3/4 q"));
		}
		catch(CalculatorError ex)
		{
			System.out.println(ex.getMessage());
			assertTrue(true);
		}
		
		try
		{
			assertEquals("Ex error 2", new Fraction(-1,4) , new FractionCalculator().evaluate(new Fraction(1,2), "- 3/4 quit"));
		}
		catch(CalculatorError ex)
		{
			System.out.println(ex.getMessage());
			assertTrue(true);
		}
		
		try
		{
			assertEquals("Ex error 3", new Fraction(-1,4) , new FractionCalculator().evaluate(new Fraction(1,2), "- 3/4 Q"));
		}
		catch(CalculatorError ex)
		{
			System.out.println(ex.getMessage());
			assertTrue(true);
		}
		
		try
		{
			assertEquals("Ex error 4", new Fraction(-1,4) , new FractionCalculator().evaluate(new Fraction(1,2), "- 3/4 Q + 6/10 - 7"));
		}
		catch(CalculatorError ex)
		{
			System.out.println(ex.getMessage());
			assertTrue(true);
		}
		
		try
		{
			assertEquals("Ex error 5", new Fraction(-1,4) , new FractionCalculator().evaluate(new Fraction(1,2), "q - 3/4 Q + 6/10 - 7"));
		}
		catch(CalculatorError ex)
		{
			System.out.println(ex.getMessage());
			assertTrue(true);
		}

	}
	
	@Test
	public void exampleTest() throws CalculatorError
	{//works through the example in the coursework specification
		
		String ex = "1/2 - 3/4 * abs 8 7/8 neg"; //the example in the coursework spec
		String ex2 = "3/4 + 1/-3 * 7 / 5"; //the second example in the coursework spec

		assertEquals("Ex error 1", new Fraction(-1,4) , new FractionCalculator().evaluate(new Fraction(1,2), "- 3/4"));
		assertEquals("Ex error 2", new Fraction(1,4), new FractionCalculator().evaluate(new Fraction(1,2), "- 3/4 abs"));
		assertEquals("Ex error 3", new Fraction(8,1), new FractionCalculator().evaluate(new Fraction(1,2), "- 3/4 abs 8"));
		assertEquals("Ex error 4", new Fraction(7,8), new FractionCalculator().evaluate(new Fraction(1,2), "- 8 7/8"));
		assertEquals("Ex error 5", new Fraction(7,8), new FractionCalculator().evaluate(new Fraction(1,2), "8 7/8"));
		assertEquals("Ex error 6", new Fraction(7,8), new FractionCalculator().evaluate(new Fraction(1,2), "- 3/4 abs 8 7/8"));
		assertEquals("Ex error 7", new Fraction(7,8), new FractionCalculator().evaluate(new Fraction(1,2), "- 3/4 abs 8 7/8"));
		assertEquals("Ex error 8", new Fraction(7,8), new FractionCalculator().evaluate(new Fraction(1,2), "- 3/4 abs 8 7/8"));
		assertEquals("Ex error 9", new Fraction(7, 12), new FractionCalculator().evaluate(new Fraction(3,4), "+ 1/-3 * 7 / 5"));
		
		assertEquals("Ex error 10", new Fraction(-7,8), new FractionCalculator().evaluate(new Fraction(1,2), "- 3/4 abs 8 7/8 neg"));
		
		assertEquals("Ex error 11", new Fraction(-7,8), new FractionCalculator().evaluate(new Fraction(1,2), "1/2 - 3/4 abs 8 7/8 neg"));
		
		assertEquals("Ex error 11", new Fraction(-7,8), new FractionCalculator().evaluate(new Fraction(0,1), "1/2 - 3/4 abs 8 7/8 neg"));
		
		assertEquals("Ex error 12", new Fraction(-7,8), new FractionCalculator().evaluate(new Fraction(0,1), ex));
		assertEquals("Ex error 12", new Fraction(7,12), new FractionCalculator().evaluate(new Fraction(0,1), ex2));
	
	}
	
	@Test
	public void rememberOps() throws CalculatorError
	{
		assertEquals("Rem ops 1", new Fraction(-3,4), new FractionCalculator().evaluate(new Fraction(0,1), "- 3/4"));
		
		assertEquals("Rem ops 2", new Fraction(1,4), new FractionCalculator().evaluate(new Fraction(4,4), "- abs 3/4"));
		
		assertEquals("Rem ops 3", new Fraction(3,8), new FractionCalculator().evaluate(new Fraction(2,8), "abs + neg neg 1/8"));
	}
	
	
	

	
}
