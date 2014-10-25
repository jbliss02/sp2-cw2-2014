package calculator;

//Interface for the fraction class

public interface IFraction {

	public abstract String toString();

	public abstract int getNumerator();

	public abstract void setNumerator(int num);

	public abstract int getDenominator();

	public abstract void setDenominator(int num);

	public abstract boolean equals(Object o);

	public abstract int hashCode();

	public abstract IFraction multiply(IFraction frac);

	public abstract IFraction add(Fraction frac);

	public abstract IFraction subtract(Fraction frac);

	public abstract IFraction divide(IFraction frac);

	public abstract IFraction negate();

	public abstract IFraction absValue();

}