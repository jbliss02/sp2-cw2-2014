package calculator;

/**
 * Created by keith for the second coursework assignment.
 */
public class Fraction {
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
        return "" + getNumerator() + '/' + getDenominator();
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int num) {
        numerator = num;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int num) {
        denominator = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fraction fraction = (Fraction) o;

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

    public Fraction multiply(Fraction frac) {

        int num = this.getNumerator() * frac.getNumerator();
        int denom = this.getDenominator() * frac.getDenominator();
        return new Fraction(num, denom);
    }

    public Fraction add(Fraction frac){
    	
    	Fraction simpleInput = frac.simplify(); 
    	
        int commonDenom = returnCommon(simpleInput.getDenominator(), 1, this.getDenominator(), 1);
        int newNom = (simpleInput.getNumerator() * (commonDenom /simpleInput.getDenominator()) + (this.getNumerator() * (commonDenom / this.getDenominator())));
        
        return new Fraction(newNom, commonDenom);
    }
    
    public Fraction subtract(Fraction frac)
    {
    	Fraction simpleInput = frac.simplify(); 
 
        int commonDenom = returnCommon(simpleInput.getDenominator(), 1, this.getDenominator(), 1);       
        int newNom = ((this.getNumerator() * (commonDenom / this.getDenominator())) - simpleInput.getNumerator() * (commonDenom /simpleInput.getDenominator()));
        
        return new Fraction(newNom, commonDenom);
    }
    
    public Fraction divide(Fraction frac)
    {
    	//flip the numerator and denominator of the input so we can use that to multiply
    	//Fraction newInput = new Fraction(frac.getDenominator(), frac.getNumerator()).simplify();
    	
        return new Fraction((this.getNumerator() * frac.getDenominator()), this.getDenominator() * frac.getNumerator()).simplify();

    	
    }
    

    private int returnCommon(int denom1, int mult1, int denom2, int mult2)
    {//a recursive method to return the lowest common denominator 
    
		if((denom1 * mult1) == (denom2 * mult2))
		{
			return denom1 * mult1;
		}
		else
		{
			//check which denominator to raise by 1
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
    private Fraction simplify()
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