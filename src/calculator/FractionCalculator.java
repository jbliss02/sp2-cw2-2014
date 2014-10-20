/**
 * 
 */
package calculator;
import java.util.*;
/**
 * @author J
 *
 */
public class FractionCalculator{

	/**
	 * @param args
	 */
	private Fraction currentFrac;
	private Operators operators;
	
	public static void main(String[] args)
	{
		
		//System.out.println(isFraction("2/3")));
	}
	
	public FractionCalculator()
	{
		setDefault();
		operators = new Operators();
	}
		
	private void setDefault(){currentFrac = new Fraction(0,1);}
	
	public Fraction evaluate(Fraction frac, String inputString)
	{

		//test for just a fraction with no instruction
		if(inputString == ""){ currentFrac = new Fraction(frac.getNumerator(), frac.getDenominator()); return currentFrac;}
		
		//split the input instruction string into an array
		String[] stCalc = inputString.split(" ");
		
		//next instruction must be an operator if the fraction is not zero- check and error if not
		if(!frac.toString().equals("0") && !operators.isOperator(stCalc[0]))
		{
			writeError("fraction must be followed by an operator");
			return currentFrac;
		}
		
		//set the starting fraction and the point in the instruction array the first operator should appear
		int startingPoint = 0;
		
		if(frac.toString().equals("0") && isFraction(stCalc[0]))
		{
			currentFrac = toFraction(stCalc[0]);
			startingPoint = 1;
		}
		else if(operators.isOperator(stCalc[0]))
		{
			startingPoint = 0;
			currentFrac = frac;
		}
		else
		{
			writeError("some sequence error");
			return currentFrac;
		}
		
		//ready to calculate - a fraction is stored in currentFrac and the position of the first operator is stored in startingPoint
		for(int i = startingPoint; i < stCalc.length; i ++)
		{
			//check the last element is a fraction
			
			//extract the current calculation
					
			//exit if the current element is not an operator
			if(!operators.isOperator(stCalc[i])){writeError("Some sequence error, expected an operator"); return currentFrac;}
			
			//extract the current operator
			Operator op = operators.returnOperator(stCalc[i]);
			
			//define type of operation and call the calculation method,
			if(op.worksAlone)
			{
				doCalculation(op);
			}
			else
			{
				if(stCalc.length <= i + 1 || !isFraction(stCalc[i + 1])){writeError("Some sequence error, expected a fraction"); return currentFrac;}
				
				doCalculation(op, toFraction(stCalc[i + 1]));
				i = i + 1; //increase i as we have taken the next fraction for the calculation
			}

		}
		

		return currentFrac;
		
	}//evaluate ends
	
	private void doCalculation(Operator op, Fraction f)
	{//updates the current fraction by doing the operation with the provided fraction
		
		switch(op.name)
		{
			case("+"):
				currentFrac = currentFrac.add(f);
				break;
			case("-"):
				currentFrac = currentFrac.subtract(f);
				break;
			case("*"):
				currentFrac = currentFrac.multiply(f);
				break;
			case("/"):
				currentFrac = currentFrac.divide(f);
				break;
				
		}//switch ends
			
	}
	
	private void doCalculation(Operator op)
	{//updates the current fraction 
		if (op.name == "abs")
		{
			currentFrac = currentFrac.absValue();
		}
	}
	
	
	
	
	
	public boolean isFraction(String input)
	{//checks whether the string input is a fraction by splitting on the '/' character,
	 //then checking whether each element is a number
		
		String[] split = input.split("/");
		if(split.length != 2) {return false;}
		
		return isNumeric(split[0]) && isNumeric(split[1]) ? true : false;

	}
	
	private boolean isNumeric(String input)
	{//checks whether the string input is a number by attempting to parse and checking for an error
		try
		{
			Integer.parseInt(input);
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}
		
	}//isNumeric ends
	

	private void writeError(String input)
	{//writes an error message and re-sets the stored fraction
		System.out.println("Error - " + input);
		setDefault();
	}
	
	private int[] returnFractionElements(String input)
	{//returns the numerator and denominator of a string fraction in an integer array
		
		int[] ret = new int[2];
		
		if(!isFraction(input)) {ret[0] = 0; ret[1] = 1; return ret;} //not a fraction, return zero
		
		String[] split = input.split("/");
		
		if(isNumeric(split[0]) && isNumeric(split[1]))
		{
			ret[0] = Integer.parseInt(split[0]); //int already validated
			ret[1] = Integer.parseInt(split[1]);
			return ret;
		}
		else //something invalid, return zero
		{
			ret[0] = 0; 
			ret[1] = 1; 
			return ret;
		}
		
	}//returnFractionElements ends
	

	private Fraction toFraction(String input)
	{//takes a string and returns a fraction
		
		if(!isFraction(input))
		{
			return new Fraction(0,1);
		}
		else
		{
			int[] f = returnFractionElements(input);
			return new Fraction(f[0], f[1]);
		}
		
	}//toFraction ends
	
}

class Operators
{
	List<Operator> list = new ArrayList<Operator>();
	
	public Operators(){populate();}
	
	private void populate()
	{//populates the supported operators in the list
		
		Operator o = new Operator("+", false); list.add(o);
		o = new Operator("-", false); list.add(o);
		o = new Operator("*", false); list.add(o);
		o = new Operator("/", false); list.add(o);
		
		o = new Operator("abs", true); list.add(o);
	}
	
	public boolean isOperator(String input)
	{//whether the inputed string exists in the list
		
		for(int i = 0; i < list.size(); i++)
		{
			if(input.trim().equals(list.get(i).name)) {return true;} //a match
		}
		
		return false;
		
	}//isOperator
	
	public Operator returnOperator(String operatorName)
	{//returns the Operator that matches the input name
		
		for(int i = 0; i < list.size(); i++)
		{
			if(operatorName.trim().equals(list.get(i).name)) {return list.get(i);} //a match
		}
		
		return null; //if doesn't exist 
		
	}//returnOperator() ends
	
}

class Operator
{
	String name;
	boolean worksAlone; //some operators do not need a subsequent fraction, some do
	
	public Operator(String name, boolean worksAlone)
	{
		this.name = name;
		this.worksAlone = worksAlone;
	}
	
}


