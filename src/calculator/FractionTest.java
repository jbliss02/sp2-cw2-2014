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

	@Test
	public void testMultiply() {
		
		assertEquals("Wrong", new Fraction(3, 10), new Fraction(1, 2).multiply(new Fraction(3, 5)));
		assertEquals("Wrong", new Fraction(2, 35), new Fraction(4, 7).multiply(new Fraction(1, 10)));
	}
	
	@Test
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
