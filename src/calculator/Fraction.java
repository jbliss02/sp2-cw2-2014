package calculator;

/**
 * Created by keith for the second coursework assignment.
 * extended by jbliss02, october 2014
 */

public class Fraction implements IFraction {
    private int numerator;
    private int denominator;

    public Fraction(int num, int denom) {
        if (denom == 0) {
            System.out.println("Invalid fraction with denominator 0"); // this should use exceptions
            return;
        }
        int gcd = myGcd(num, denom);
        setNumerator(num / gcd);
        setDenominator(denom / gcd);
    }


	@Override
    public String toString() {
    	
    	if(getDenominator() == 1)
    	{
    		return ("" + getNumerator()).trim();
    	}
    	else
    	{
    		return ("" + getNumerator() + '/' + getDenominator()).trim();
    	}
    		
    }


    @Override
	public int getNumerator() {
        return numerator;
    }

    @Override
	public void setNumerator(int num) {
        numerator = num;
    }

    @Override
	public int getDenominator() {
        return denominator;
    }

    @Override
	public void setDenominator(int num) {
        denominator = num;
    }

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IFraction fraction = (IFraction) o;

        if (getDenominator() != fraction.getDenominator()) return false;
        if (getNumerator() != fraction.getNumerator()) return false;

        return true;
    }

	@Override
    public int hashCode() {
        int result = numerator;
        result = 31 * result + denominator;
        return result;
    }

    @Override
	public IFraction multiply(IFraction frac) {

        int num = this.getNumerator() * frac.getNumerator();
        int denom = this.getDenominator() * frac.getDenominator();
        return new Fraction(num, denom);
    }
    
    @Override
    public IFraction add(Fraction frac)
    {
    	IFraction simpleInput = frac.simplify(); 
    	
    	int ad = this.getNumerator() * simpleInput.getDenominator();
    	int bc = this.getDenominator() * simpleInput.getNumerator();
    	int bd = this.getDenominator() * simpleInput.getDenominator();
    	
    	return new Fraction((ad + bc), bd).simplify();	
    } 
    	
	@Override
	public IFraction subtract(Fraction frac)
	{
		int ad = this.getNumerator() * frac.getDenominator();
		int bc = this.getDenominator() * frac.getNumerator();
		int bd = this.getDenominator() * frac.getDenominator();
		
		return new Fraction((ad - bc), bd);
	}
    

    @Override
	public IFraction divide(IFraction frac)
    {//divides the input fraction with the objects fraction
        return new Fraction((this.getNumerator() * frac.getDenominator()), this.getDenominator() * frac.getNumerator()).simplify();
    }

    @Override
	public IFraction negate()
    {//negates the objects fraction, if either the numerator or denominator are negative then change the sign so
     //both are always positive

    	return new Fraction(this.getNumerator(), this.getDenominator() * -1);    	
    }

    @Override
	public IFraction absValue()
    {//absolute value is the +ve value of the fraction
    	int newNom = this.getNumerator() < 0 ? this.getNumerator() * -1 : this.getNumerator();
    	int newDenom = this.getDenominator() < 0 ? this.getDenominator() * -1 : this.getDenominator();
    	return new Fraction(newNom, newDenom).simplify();
    }
    

//    private int returnCommon(int denom1, int mult1, int denom2, int mult2)
//    {//a recursive method to return the lowest common denominator 
//    
//		if((denom1 * mult1) == (denom2 * mult2))
//		{
//			return denom1 * mult1;
//		}
//		else
//		{
//			//check which denominator to raise by 1 (the smallest product of the demoninator * its multiplier + 1)
//			if((denom1 * (mult1 + 1)) > (denom2 * (mult2 + 1)))
//			{
//				return returnCommon(denom1, mult1, denom2, mult2 + 1);
//			}
//			else
//			{
//				return returnCommon(denom1, mult1 + 1, denom2, mult2);	
//			}
//			
//		}
//
//    }//returnCommon ends
    
    //simplify a fraction
    private IFraction simplify()
    {

        int num = this.getNumerator();
        int denom = this.getDenominator();
        int gcd = myGcd(num, denom);
        
        //set the integers of the new fraction
        int num1 = (num / gcd);
        int denom1 = (denom / gcd);
        
        return new Fraction(num1, denom1);
    }
    
    //change to private
    private int myGcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}