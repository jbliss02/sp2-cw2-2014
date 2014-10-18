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

    public int add(Fraction frac){
    	
    	
    	int denom1 = this.getDenominator();
    	int denom2 = frac.getDenominator();
    	
    	return commonDemoninator(denom1,denom2);

    }
    
    private int commonDemoninator(int denom1, int denom2)
    {
    	int commonDenom = -1;
    	for(int i = 1; i < 50; i++)
    	{
    		for(int k = 1; k < 50; k++)
    		{
    			if((denom1 * i) == (denom2 * k))
    			{
    				commonDenom =  denom1 * i;
    				break;
    			}
    		}
    		if(commonDenom != -1){break;}
    	}
    	
    	return commonDenom;
    }
    
    private int recCommon(int demon1, int mult1, int demon2, int mult2)
    {
    	
    }
    
    
    
    //change to private
    public int myGcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}