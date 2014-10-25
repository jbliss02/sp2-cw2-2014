/**
 * 
 */
package calculator;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Jbliss02 
 * October 2014
 * JUnit tests for the Fraction class
 *
 */
public class FractionTest {


	
	@Test
	public void testToString()
	{
		assertEquals("tostring 1", "1/2", new Fraction(1,2).toString());
		assertEquals("tostring 2", "666/253663", new Fraction(666,253663).toString());
		assertEquals("tostring 3", "8/-7", new Fraction(-8,7).toString());
		assertEquals("tostring 4", "2", new Fraction(2,1).toString());
		assertEquals("tostring 5", "2", new Fraction(4,2).toString());
	}
	
	@Test
	public void testNegate()
	{
		assertEquals("negate 1", new Fraction(1, -2), new Fraction(1,2).negate());
		assertEquals("negate 2", new Fraction(1, 2), new Fraction(-1,2).negate());
		assertEquals("negate 3", new Fraction(1, 2), new Fraction(1,-2).negate());
		assertEquals("negate 4", new Fraction(1, -2), new Fraction(-1,-2).negate());
		assertEquals("negate 5", new Fraction(-7, 8), new Fraction(7,8).negate());
	}
	
	@Test
	public void absValue()
	{
		assertEquals("abs 1", new Fraction(1, 2), new Fraction(1,2).absValue());
		assertEquals("abs 2", new Fraction(1, 2), new Fraction(-1,2).absValue());
		assertEquals("abs 3", new Fraction(1, 2), new Fraction(1,-2).absValue());
		assertEquals("abs 4", new Fraction(1, 2), new Fraction(-1,-2).absValue());
		assertEquals("abs 5", new Fraction(8, 9), new Fraction(-8,9).absValue());
	}
	
	
	@Test
	public void testDivide()
	{
		assertEquals("divide 1", new Fraction(8, 3), new Fraction(2,3).divide(new Fraction(1, 4)));
		assertEquals("divide 2", new Fraction(301, 13998), new Fraction(172,6999).divide(new Fraction(8, 7)));
		assertEquals("divide 3", new Fraction(99, 8), new Fraction(3,12).divide(new Fraction(-2, -99)));
		assertEquals("divide 4", new Fraction(16621, 2575329), new Fraction(4533,6553).divide(new Fraction(3537, 33)));
		assertEquals("divide 5", new Fraction(-16621, 2575329), new Fraction(4533,6553).divide(new Fraction(3537, -33)));
	}

	@Test
	public void testSubtract()
	{
		assertEquals("subtract 1", new Fraction(5, 8), new Fraction(6,8).subtract(new Fraction(1, 8)));
		assertEquals("subtract 2", new Fraction(7, 153), new Fraction(2,9).subtract(new Fraction(3, 17)));
		assertEquals("subtract 3", new Fraction(-7958, 11528), new Fraction(86,1441).subtract(new Fraction(6, 8)));		
		assertEquals("subtract 4", new Fraction(-3979, 5764), new Fraction(86,1441).subtract(new Fraction(6, 8)));	
	}
	
	@Test
	public void testAdd()
	{
		assertEquals("add 1", new Fraction(61, 153), new Fraction(2,9).add(new Fraction(3, 17)));
		assertEquals("add 2", new Fraction(27, 40), new Fraction(3,8).add(new Fraction(3, 10)));
		assertEquals("add 3", new Fraction(-9, 20), new Fraction(3,-4).add(new Fraction(3, 10)));
		assertEquals("add 4", new Fraction(387, 203), new Fraction(18,29).add(new Fraction(9, 7)));

	}
	

	@Test	
	public void testMultiply() {
		
		assertEquals("Mult 1", new Fraction(3, 10), new Fraction(1, 2).multiply(new Fraction(3, 5)));
		assertEquals("Mult 2", new Fraction(2, 35), new Fraction(4, 7).multiply(new Fraction(1, 10)));
	}
	
	@Test
	public void TestEquals()
	{
	    assertEquals ("equals 1", new Fraction(1, 2), new Fraction(1, 2));
	    assertEquals ("equals 2", new Fraction(1, 2), new Fraction(3, 6));
	    assertEquals ("equals 3", new Fraction(1, 2), new Fraction(3, 6));    
	}
	
	@Test
	public void TestAddNegatives()
	{
		assertEquals("neg add 1", new Fraction(1, 10), new Fraction(1,-2).add(new Fraction(6, 10)));
		assertEquals("neg add 2", new Fraction(-4, 21), new Fraction(-4,7).add(new Fraction(8, 21)));
		assertEquals("neg add 3", new Fraction(4, 35), new Fraction(2,5).add(new Fraction(-2, 7)));
		assertEquals("neg add 4", new Fraction(-5, 77), new Fraction(4,11).add(new Fraction(3, -7)));
	}
	
	@Test
	public void TestSubtractNegatives()
	{
		assertEquals("neg subtract 1", new Fraction(-11, 10), new Fraction(1,-2).subtract(new Fraction(6, 10)));
		assertEquals("neg subtract 2", new Fraction(-20, 21), new Fraction(-4,7).subtract(new Fraction(8, 21)));
		assertEquals("neg subtract 3", new Fraction(24, 35), new Fraction(2,5).subtract(new Fraction(-2, 7)));
		assertEquals("neg subtract 4", new Fraction(61, 77), new Fraction(4,11).subtract(new Fraction(3, -7)));
	}
	
	@Test
	public void TestDivideNegatives()
	{
		assertEquals("neg divide 1", new Fraction(-5, 6), new Fraction(1,-2).divide(new Fraction(6, 10)));
		assertEquals("neg divide 2", new Fraction(-3, 2), new Fraction(-4,7).divide(new Fraction(8, 21)));
		assertEquals("neg divide 3", new Fraction(-7, 5), new Fraction(2,5).divide(new Fraction(-2, 7)));
		assertEquals("neg divide 4", new Fraction(-28, 33), new Fraction(4,11).divide(new Fraction(3, -7)));
	}
	
	@Test
	public void TestMultiplyNegatives()
	{
		assertEquals("neg mult 1", new Fraction(-3, 10), new Fraction(1,-2).multiply(new Fraction(6, 10)));
		assertEquals("neg mult 2", new Fraction(-32, 147), new Fraction(-4,7).multiply(new Fraction(8, 21)));
		assertEquals("neg mult 3", new Fraction(-4, 35), new Fraction(2,5).multiply(new Fraction(-2, 7)));
		assertEquals("neg mult 4", new Fraction(-12, 77), new Fraction(4,11).multiply(new Fraction(3, -7)));
	}

}
