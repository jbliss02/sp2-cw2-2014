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
		Fraction f = new Fraction(1,9);
		System.out.println(f.add(new Fraction(1,17)));


		
	}
	
	@Test
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
