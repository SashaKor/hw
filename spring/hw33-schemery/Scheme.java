/*
Aleksandra Koroza
APCS2 pd2
HW #33: What a Racket   or: How I Learned to Stop Worrying and Love the Stack
2018-04-12
/*****************************************************
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 * 
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *   1. Starting from the end of the expression array, push value onto 1st stack (input). If the value 
 *   is an operand, push it to second stack (opr).   
 *   2. Once closing parenthesis reached ("("), pop it. Unload input Stack.
 *   3. Update return value, pop once from opr Stack, and pop from input until first parenthesis reached
 *   4. Repeat for every element of split array
 *
 * STACK OF CHOICE: LinkedList
 * I chose to use LinkedList (LLStack.java) as my capsule. I don't need indexed 
 * access to my collection since I am popping elements from the stack and 
 * performing the needed operations. I felt that LinkedList lent itself
 * to the stack data type, although there aren't major differences between the 
 * two in terms of efficiency in this homework. Thus, I am still unsure as to 
 * whether one type is truly the smarter choice. 
 ******************************************************/

public class Scheme
{
  /****************************************************** 
   * precond:  Assumes expr is a valid Scheme (prefix) expression,
   *           with whitespace separating all operators, parens, and 
   *           integer operands.
   * postcond: Returns the simplified value of the expression, as a String
   * eg,
   *           evaluate( "( + 4 3 )" ) -> 7
   *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
   ******************************************************/
  public static String evaluate( String expr ) 
  {
      String result="1";
      // one stack for storing numbers and parenthesis, another for seeing current operand
      LLStack<String> input = new LLStack<String>();
      LLStack<String> opr = new LLStack<String>();
      //splitting input string into usable stuffs
      String[] exprArr = expr.split("\\s+");
      int op =0;

      input.push(exprArr[exprArr.length-1]);
      for (int i= exprArr.length-2; i>=0 ; i--){
	  String curr= exprArr[i];

	  if (curr.equals("+")){
	      opr.push(curr);
	      op= 1;
	  }

	  if (curr.equals("-")){
	      opr.push(curr);
	      op= 2;
	  }

	  if (curr.equals("*")){
	      opr.push(curr);
	      op= 3;
	  }
	      

	  else{
	      input.push(curr);
	  }

	  if (curr.equals("(")){
	      input.pop();
	      result= Integer.toString(Integer.parseInt(result) + Integer.parseInt(unload(op,input)));
	      opr.pop();

	      while (! input.peek().equals(")")){
		  input.pop();
	      }

	      input.pop();
	  }

	  
	      
	      
      
      }
      return result; 
  }//end evaluate()


  /****************************************************** 
   * precond:  Assumes top of input stack is a number.
   * postcond: Performs op on nums until closing paren is seen thru peek().
   *           Returns the result of operating on sequence of operands.
   *           Ops: + is 1, - is 2, * is 3
   ******************************************************/
  public static String unload( int op, LLStack<String> numbers ) 
  {
      String ans="0";
      //used for subtraction and multiplication
      boolean firstPop = true; 
      //closing parens might change
      while (isNumber(numbers.peek())){
	  String curr = numbers.pop();
	  //addition
	  if (op ==1){
	      //sorta messy way of getting to ints and going back to String
	      ans= Integer.toString(Integer.parseInt(curr)+ Integer.parseInt(ans));
	  }

	  //subtraction
	  if (op==2){
	      if (firstPop){
		  ans= curr;
		  firstPop=false;
	      }
	      else{
		  ans= Integer.toString(Integer.parseInt(ans)- Integer.parseInt(curr));
	      }
	  }

	  //multiplication
	  if (op==2){
	      if (firstPop){
		  ans= curr;
		  firstPop=false;
	      }
	      else{
		  ans= Integer.toString(Integer.parseInt(ans)* Integer.parseInt(curr));
	      }
	  }
      }
      return ans; 
  }//end unload()


  
  //optional check-to-see-if-its-a-number helper fxn:
  public static boolean isNumber( String s ) {
  try {
  Integer.parseInt(s);
  return true;
	}
  catch( NumberFormatException e ) {
  return false;
	}
  }
  


  //main method for testing
  public static void main( String[] args )
  {

    
      String zoo1 = "( + 4 3 )";
      System.out.println(zoo1);
      System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
      //...7

      String zoo2 = "( + 4 ( * 2 5 ) 3 )";
      System.out.println(zoo2);
      System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
      //...17

      String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
      System.out.println(zoo3);
      System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
      //...29

      String zoo4 = "( - 1 2 3 )";
      System.out.println(zoo4);
      System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
      //...-4
      
  }//main

}//end class Scheme
