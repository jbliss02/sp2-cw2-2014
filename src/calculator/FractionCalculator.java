/**
 * 
 */
package calculator;
import java.util.*;

public class FractionCalculator{

	private IFraction currentFrac;
	private Operators operators;
	
	public static void main(String[] args)
	{
		
	}
	
	public FractionCalculator()
	{
		setDefault();
		operators = new Operators();
	}
		
	private void setDefault(){currentFrac = new Fraction(0,1);}
	
	public IFraction evaluate(IFraction frac, String inputString)
	{
		
		currentFrac = frac; //save the provided fraction
		
		inputString = inputString.trim(); //ignore trailling blanks
		
		if(inputString == ""){ return currentFrac;} //test for just a fraction with no instruction
				
		String[] stCalc = inputString.split(" "); //split the input instruction string into an array
		
		//loop through items and calculate
		for(int i = 0; i < stCalc.length; i ++)
		{	
			if(stCalc[i].equals(" ")){continue;} //ignore any blanks
			
			//if next element is a fraction then store that number as it overwrites what has been stored, and continue to next iteration	
			if(isFraction(stCalc[i])){currentFrac = toFraction(stCalc[i]); continue;}
			
			//exit if the element is not an operator (as it is also not a fraction)
			if(!operators.isOperator(stCalc[i])){writeError("Unexpected character"); return currentFrac;}
			
			//extract the current operator
			Operator op = operators.returnOperator(stCalc[i]);
			
			//define type of operation and call the calculation method,
			if(op.worksAlone)
			{
				doCalculation(op);
			}
			else //operator requires another item
			{
				if(stCalc.length <= i + 1) {return currentFrac;} //message ends with an operator so ignore and return the current fraction
			
				if(!isFraction(stCalc[i + 1])){writeError("Some sequence error, expected a fraction"); return currentFrac;} //not a fraction so exit
				
				doCalculation(op, toFraction(stCalc[i + 1]));

				i++; //increase i as we have taken the next element as the fraction for the calculation
			}

		}//i -loop over instruction
		
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
			
	}//doCalculation

	
	private void doCalculation(Operator op)
	{//updates the current fraction 
		
		switch(op.name)
		{
			case("abs"):
				currentFrac = currentFrac.absValue();
				break;
			case("a"):
				currentFrac = currentFrac.absValue();
				break;
			case("A"):
				currentFrac = currentFrac.absValue();
				break;
			case("neg"):
			case("n"):
			case("N"):
				currentFrac = currentFrac.negate();
				break;
			case("clear"):
			case("c"):
			case("C"):
				currentFrac = new Fraction(0,1);
				break;
		}

	}//doCalculation

	public boolean isFraction(String input)
	{//checks whether the string input is a fraction by splitting on the '/' character,
	 //then checking whether each element is a number
		
		String[] split = input.split("/");
		
		if(split.length != 2) //not a fraction
		{
			return isNumeric(input) ? true : false;
		}
		
		return isNumeric(split[0]) && isNumeric(split[1]) ? true : false; //if both elements are numeric its a fraction

	}//isFraction
	
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
		
		if(!isFraction(input)) //not a fraction or a whole number
		{
				ret[0] = 0; ret[1] = 1; 
				return ret;
		}
		else if(isNumeric(input)) //is a whole number
		{
			ret[0] = Integer.parseInt(input); ret[1] = 1; 
			return ret;
		}

		//if here then is a bona fide fraction
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
						
			return f.length == 2 ? new Fraction(f[0], f[1]) : new Fraction(0,1); //create fraction or send 0 if not a fraction
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
		o = new Operator("a", true); list.add(o);
		o = new Operator("A", true); list.add(o);
		
		o = new Operator("neg", true); list.add(o);
		o = new Operator("n", true); list.add(o);
		o = new Operator("N", true); list.add(o);
		
		o = new Operator("clear", true); list.add(o);
		o = new Operator("c", true); list.add(o);
		o = new Operator("C", true); list.add(o);
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


