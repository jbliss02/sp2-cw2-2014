package calculator;

/**
 * Created by keith for the second coursework assignment.
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
    	
    	//return  getDenominator() == 1 ? "" + getNumerator() : "" + getNumerator() + '/' + getDenominator();	
    }

    /* (non-Javadoc)
	 * @see calculator.IFraction#getNumerator()
	 */
    @Override
	public int getNumerator() {
        return numerator;
    }

    /* (non-Javadoc)
	 * @see calculator.IFraction#setNumerator(int)
	 */
    @Override
	public void setNumerator(int num) {
        numerator = num;
    }

    /* (non-Javadoc)
	 * @see calculator.IFraction#getDenominator()
	 */
    @Override
	public int getDenominator() {
        return denominator;
    }

    /* (non-Javadoc)
	 * @see calculator.IFraction#setDenominator(int)
	 */
    @Override
	public void setDenominator(int num) {
        denominator = num;
    }

    /* (non-Javadoc)
	 * @see calculator.IFraction#equals(java.lang.Object)
	 */

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IFraction fraction = (IFraction) o;

        if (getDenominator() != fraction.getDenominator()) return false;
        if (getNumerator() != fraction.getNumerator()) return false;

        return true;
    }

    /* (non-Javadoc)
	 * @see calculator.IFraction#hashCode()
	 */

	@Override
    public int hashCode() {
        int result = numerator;
        result = 31 * result + denominator;
        return result;
    }

    /* (non-Javadoc)
	 * @see calculator.IFraction#multiply(calculator.IFraction)
	 */
    @Override
	public IFraction multiply(IFraction frac) {

        int num = this.getNumerator() * frac.getNumerator();
        int denom = this.getDenominator() * frac.getDenominator();
        return new Fraction(num, denom);
    }

    /* (non-Javadoc)
	 * @see calculator.IFraction#add(calculator.Fraction)
	 */
    @Override
	public IFraction add(Fraction frac){
    	
    	IFraction simpleInput = frac.simplify(); 
    	
        int commonDenom = returnCommon(simpleInput.getDenominator(), 1, this.getDenominator(), 1);
        int newNom = (simpleInput.getNumerator() * (commonDenom /simpleInput.getDenominator()) + (this.getNumerator() * (commonDenom / this.getDenominator())));
        
        return new Fraction(newNom, commonDenom);
    }
    
    /* (non-Javadoc)
	 * @see calculator.IFraction#subtract(calculator.Fraction)
	 */
    @Override
	public IFraction subtract(Fraction frac)
    {//subtracts the input fraction with the objects fraction
    	IFraction simpleInput = frac.simplify(); 
 
        int commonDenom = returnCommon(simpleInput.getDenominator(), 1, this.getDenominator(), 1);       
        int newNom = ((this.getNumerator() * (commonDenom / this.getDenominator())) - simpleInput.getNumerator() * (commonDenom /simpleInput.getDenominator()));
        
        return new Fraction(newNom, commonDenom);
    }
    
    /* (non-Javadoc)
	 * @see calculator.IFraction#divide(calculator.IFraction)
	 */
    @Override
	public IFraction divide(IFraction frac)
    {//divides the input fraction with the objects fraction
        return new Fraction((this.getNumerator() * frac.getDenominator()), this.getDenominator() * frac.getNumerator()).simplify();
    }
    
    /* (non-Javadoc)
	 * @see calculator.IFraction#negate()
	 */
    @Override
	public IFraction negate()
    {//negates the objects fraction, if either the numerator or denominator are negative then change the sign so
     //both are always positive

    	return new Fraction(this.getNumerator(), this.getDenominator() * -1);
    	
    }
    
    /* (non-Javadoc)
	 * @see calculator.IFraction#absValue()
	 */
    @Override
	public IFraction absValue()
    {//absolute value is the +ve value of the fraction
    	int newNom = this.getNumerator() < 0 ? this.getNumerator() * -1 : this.getNumerator();
    	int newDenom = this.getDenominator() < 0 ? this.getDenominator() * -1 : this.getDenominator();
    	return new Fraction(newNom, newDenom).simplify();
    }
    

    private int returnCommon(int denom1, int mult1, int denom2, int mult2)
    {//a recursive method to return the lowest common denominator 
    
		if((denom1 * mult1) == (denom2 * mult2))
		{
			return denom1 * mult1;
		}
		else
		{
			//check which denominator to raise by 1 (the smallest product of the demoninator * its multiplier + 1)
			if((denom1 * (mult1 + 1)) > (denom2 * (mult2 + 1)))
			{
				return returnCommon(denom1, mult1, denom2, mult2 + 1);
			}
			else
			{
				return returnCommon(denom1, mult1 + 1, denom2, mult2);	
			}
			
		}

    }//returnCommon ends
    
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