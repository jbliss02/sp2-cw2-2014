package calculator;

public interface IFractionCalculator {

	public abstract void main(String[] args);

	public abstract IFraction evaluate(IFraction frac, String inputString)
			throws CalculatorError;//evaluate() ends

}