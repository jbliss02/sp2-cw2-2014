/**
 * jbliss02 
 * October 2014
 * Fraction Calculator - takes a fraction and a string calculation, makes the calculations
 * as outlined in the string and returns final fraction, throwing exceptions for anything unexpected
 * 
 * meets the requirements outlined here http://moodle.bbk.ac.uk/pluginfile.php/349944/mod_resource/content/1/cw2.pdf
 */
package calculator;
import java.util.List;
import java.util.ArrayList;

public class FractionCalculator implements IFractionCalculator{

	private IFraction currentFrac;
	private Operators operators;
	
	@Override
	public void main(String[] args)
	{
		
	}
	
	public FractionCalculator()
	{
		setDefault();
		operators = new Operators();
	}
		
	private void setDefault(){currentFrac = new Fraction(0,1);} //set the saved fraction to zero
	
	@Override
	public IFraction evaluate(IFraction frac, String inputString) throws CalculatorError
	{
		currentFrac = frac; //save the provided fraction
		
		Operator rememberedOp = null; //incase an operation needs to be remembered
		
		inputString = inputString.trim(); //ignore trailing blanks
		
		if(inputString == ""){ return currentFrac;} //no instruction provided
				
		String[] stCalc = inputString.split(" "); //split the input instruction string into an array
		
		//loop through items and calculate
		for(int i = 0; i < stCalc.length; i ++)
		{	
			if(stCalc[i].equals(" ")){continue;} //skip over any blanks
			
			//if next element is a fraction then checked for a saved operator, if saved do calculation
			//if not saved store that number as the current fraction, and continue to next iteration in both cases	
			if(isFraction(stCalc[i]) && rememberedOp == null){
				currentFrac = toFraction(stCalc[i]); 
				continue;
			}
			else if(isFraction(stCalc[i]) && rememberedOp != null)
			{
				doCalculation(rememberedOp, toFraction(stCalc[i]));
				rememberedOp = null;
				continue;
			}
						
			//throw error if the element is not an operator (as it is also not a fraction)
			if(!operators.isOperator(stCalc[i])){
				setDefault();
				throw new CalculatorError("Unsupprted character");
			}
			
			//extract the current operator
			Operator op = operators.returnOperator(stCalc[i]);
			if(op.isQuit()){setDefault(); throw new CalculatorError("Quit string found");} //quit check
			
			//if operator and saved operator then error
			if(rememberedOp != null && !op.worksAlone){
				setDefault(); throw new CalculatorError("Some sequence error, two consecutive non-work alone operators found");
			}
			
			//define type of operation and call the calculation method
			if(op.worksAlone)
			{
				doCalculation(op);
			}
			else //operator requires another item
			{
				if(stCalc.length <= i + 1) {return currentFrac;} //string ends with an operator so ignore and return the current fraction
		
				if(!isFraction(stCalc[i + 1]) && !operators.isOperator(stCalc[i + 1])) //not a fraction nor an operator
				{
					setDefault();
					throw new CalculatorError("Some sequence error, expected a fraction or operator");
				} 
				else if(!isFraction(stCalc[i + 1]) && !op.worksAlone) //not a fraction but is a work alone operator
				{
					rememberedOp = op; //save the operator for later use as it cannot be used immediately
				}
				else
				{
					doCalculation(op, toFraction(stCalc[i + 1])); //do the calculation with the next item, which is a fraction
					i++; //increase i as we have taken the next element as the fraction for the calculation
				}

			}//type of operator found

		}//i -loop over instruction
		
		return currentFrac; //finished doing computation, return the result
		
	}//evaluate() ends
	
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
		
		switch(op.name.toLowerCase())
		{
			case("abs"):
			case("a"):
				currentFrac = currentFrac.absValue();
				break;
			case("neg"):
			case("n"):
				currentFrac = currentFrac.negate();
				break;
			case("clear"):
			case("c"):
				currentFrac = new Fraction(0,1);
				break;
		}//switch ends

	}//doCalculation

	private boolean isFraction(String input)
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

		//if here then is a fraction
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
	
}//FractionCalculator Class ends


//Operators class holds the supported operators and associated logic
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
		
		o = new Operator("quit", true); list.add(o);
		o = new Operator("q", true); list.add(o);
		o = new Operator("Q", true); list.add(o);
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
	{//returns the Operator that matches the input string name
		
		for(int i = 0; i < list.size(); i++)
		{
			if(operatorName.trim().equals(list.get(i).name)) {return list.get(i);} //a match
		}
		
		return null; //if doesn't exist 
		
	}//returnOperator() ends
	
}

//operator class holds information about a single operator
class Operator
{
	String name;
	boolean worksAlone; //some operators do not need a subsequent fraction, some do
	
	public Operator(String name, boolean worksAlone)
	{
		this.name = name;
		this.worksAlone = worksAlone;
	}
	
	public boolean isQuit()
	{
		if (this.name.equals("quit") || this.name.toUpperCase().equals("Q"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}//isQuit()
	
}//Operator class ends


