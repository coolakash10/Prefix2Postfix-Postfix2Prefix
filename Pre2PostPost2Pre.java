/*********************************************************************************************************************
     **
     **  Conversion of Postfix and prefix expression to Prefix and Postfix expression resp. 
     **  Input Postfix and Prefix expression must be in a desired format. 
     **  Operands and operator, both must be single character.
     **  Only '+'  ,  '-'  , '*', '/'  operators are expected. 
     
     **  Written By:    Akash Vishwas Londhe
     **
*********************************************************************************************************************/


import java.util.*;

class Pre2PostPost2Pre
{

	public static void main(String[] args)
	{

		String exp="*-A/BC-/AKL";
		System.out.println("POSTFIX EVALUATION : "+ pre2Post(exp));

		exp="ab*c+";
		System.out.println("PREFIX EVALUATION : "+ post2Pre(exp));


	}

	private static String post2Pre(String exp)
	{

		Stack<String> stack=new Stack();

		for(int i=0;i<exp.length();i++)
		{
			if(!isOperator(exp.charAt(i)))
				stack.push(exp.charAt(i)+"");
			else 
			{
				String s1=stack.pop();
				String s2=stack.pop();
				stack.push(exp.charAt(i)+s2+s1);
			}
		}
		return stack.pop();

	}

	private static String pre2Post(String exp)
	{

		Stack<String> stack=new Stack();

		for(int i=exp.length()-1;i>=0;i--)
		{
			if(!isOperator(exp.charAt(i)))
				stack.push(exp.charAt(i)+"");
			else 
			{
				String s1=stack.pop();
				String s2=stack.pop();
				stack.push(s1+s2+exp.charAt(i));
			}
		}
		return stack.pop();

	}

	private static boolean isOperator(char c)
	{

		switch(c)
		{
			case '+':
			case '-':
			case '*':
			case '/':
			return true;
		}
		return false;

	}
	
}