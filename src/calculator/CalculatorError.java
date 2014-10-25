/**
 * 
 */
package calculator;

/**
 * @jbliis02
 * Exception the calculator throws when a unsupported 
 * character is found
 */
public class CalculatorError extends Exception {
	public CalculatorError(String st){
			super("Error: " + st);
	}
}