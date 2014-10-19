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
		Fraction f = new Fraction(2,4);
		//System.out.println(f.simplify().toString());

		
		

		
	}
	
	
	public void testSimplify()
	{
		//assertEquals("Wrong", new Fraction(1, 2), new Fraction(2,4).simplify());
	}
	
	
	@Test
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
