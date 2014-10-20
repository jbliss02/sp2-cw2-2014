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
public class FractionTest {

	
	public static void main(String[] args)
	{
		System.out.println(new Fraction(-8,7).toString());

		
		

		
	}
	
	
	public void testToString()
	{
		assertEquals("Wrong", "1/2", new Fraction(1,2).toString());
		assertEquals("Wrong", "666/253663", new Fraction(666,253663).toString());
		assertEquals("Wrong", "8/-7", new Fraction(-8,7).toString());
		assertEquals("Wrong", "2", new Fraction(2,1).toString());
		assertEquals("Wrong", "2", new Fraction(4,2).toString());
	}
	
	
	public void testNegate()
	{
		assertEquals("Wrong", new Fraction(1, -2), new Fraction(1,2).negate());
		assertEquals("Wrong", new Fraction(1, 2), new Fraction(-1,2).negate());
		assertEquals("Wrong", new Fraction(1, 2), new Fraction(1,-2).negate());
		assertEquals("Wrong", new Fraction(1, -2), new Fraction(-1,-2).negate());
		assertEquals("Wrong", new Fraction(-7, 8), new Fraction(7,8).negate());
	}
	
	@Test
	public void absValue()
	{
		//assertEquals("Wrong", new Fraction(1, 2), new Fraction(1,2).absValue());
		//assertEquals("Wrong", new Fraction(1, 2), new Fraction(-1,2).absValue());
		//assertEquals("Wrong", new Fraction(1, 2), new Fraction(1,-2).absValue());
		//assertEquals("Wrong", new Fraction(1, 2), new Fraction(-1,-2).absValue());
		assertEquals("Wrong", new Fraction(8, 9), new Fraction(-8,9).absValue());
	}
	
	
	public void testSimplify()
	{
		//assertEquals("Wrong", new Fraction(1, 2), new Fraction(2,4).simplify());
	}
	
	public void testDivide()
	{
		assertEquals("Wrong", new Fraction(8, 3), new Fraction(2,3).divide(new Fraction(1, 4)));
		assertEquals("Wrong", new Fraction(301, 13998), new Fraction(172,6999).divide(new Fraction(8, 7)));
		assertEquals("Wrong", new Fraction(99, 8), new Fraction(3,12).divide(new Fraction(-2, -99)));
		assertEquals("Wrong", new Fraction(16621, 2575329), new Fraction(4533,6553).divide(new Fraction(3537, 33)));
		assertEquals("Wrong", new Fraction(-16621, 2575329), new Fraction(4533,6553).divide(new Fraction(3537, -33)));
	}

	public void testSubtract()
	{
		assertEquals("Wrong", new Fraction(5, 8), new Fraction(6,8).subtract(new Fraction(1, 8)));
		assertEquals("Wrong", new Fraction(7, 153), new Fraction(2,9).subtract(new Fraction(3, 17)));
		assertEquals("Wrong", new Fraction(-7958, 11528), new Fraction(86,1441).subtract(new Fraction(6, 8)));		
		assertEquals("Wrong", new Fraction(-3979, 5764), new Fraction(86,1441).subtract(new Fraction(6, 8)));	
	}
	

	public void testAdd()
	{
		assertEquals("Wrong", new Fraction(61, 153), new Fraction(2,9).add(new Fraction(3, 17)));
		assertEquals("Wrong", new Fraction(27, 40), new Fraction(3,8).add(new Fraction(3, 10)));
		assertEquals("Wrong", new Fraction(-9, 20), new Fraction(3,-4).add(new Fraction(3, 10)));
		assertEquals("Wrong", new Fraction(387, 203), new Fraction(18,29).add(new Fraction(9, 7)));

	}
	

	public void testcommonDemoninator()
	{
		assertEquals("Wrong", 153, new Fraction(2,9).add(new Fraction(3, 17)));
		assertEquals("Wrong", 40, new Fraction(3,8).add(new Fraction(3, 10)));
		assertEquals("Wrong", 20, new Fraction(3,-4).add(new Fraction(3, 10)));
		assertEquals("Wrong", 203, new Fraction(18,29).add(new Fraction(9, 7)));
	}
	
	
	
	public void testMultiply() {
		
		assertEquals("Wrong", new Fraction(3, 10), new Fraction(1, 2).multiply(new Fraction(3, 5)));
		assertEquals("Wrong", new Fraction(2, 35), new Fraction(4, 7).multiply(new Fraction(1, 10)));
	}
	

	public void TestEquals()
	{
	    assertEquals ("Wrong", new Fraction(1, 2), new Fraction(1, 2));
	    assertEquals ("Wrong", new Fraction(1, 2), new Fraction(3, 6));
	    assertEquals ("Wrong", new Fraction(1, 2), new Fraction(3, 6));    
	    //assertEquals ("Wrong", new Fraction(1, 2), new Fraction(1, -2));	    
	    //assertEquals ("Wrong", new Fraction(-1, 2), new Fraction(1, -2));	
	   // assertEquals ("Wrong", new Fraction(-1, -2), new Fraction(1, -2));
	    //
	}

}
