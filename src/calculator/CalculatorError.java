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
	public String errorCode;

	public CalculatorError(String st, String errCode){
			super("Error: " + st);
			this.errorCode = errCode;
	}
}