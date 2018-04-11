/*
Aleksandra Koroza
APCS2 Pd.2
HW #31: Stack: What Is It Good For?               well, this. 
2018-04-10

/*****************************************************
 * skeleton for class LatKtS
 * Driver class for Latkes.
 * change to Latkes= added peek() method
 * Uses a stack to reverse a text string, check for sets of matching parens.
 *****************************************************/


public class LatKtS
{

  /**********************************************************
   * precondition:  input string has length > 0
   * postcondition: returns reversed string s
   *                flip("desserts") -> "stressed"
   **********************************************************/
  public static String flip( String s )
  {
      Latkes stack = new Latkes(s.length());
      String ret ="";
      
      //first push to stack using for loop
      for (int i=0; i<s.length(); i++){
	  stack.push(s.substring(i,i+1));
      }

      //now that we have a stack that looks kinda like this -->
      // (eg. "latke" would be [l a t k e] on the stack)
      // we can pop one by one

      while (!(stack.isEmpty())){
	  ret+= stack.pop();
      }

      return ret;   
	  

  }//end flip()


  /**********************************************************
   * precondition:  s contains only the characters {,},(,),[,]
   * postcondition: allMatched( "({}[()])" )    -> true
   *                allMatched( "([)]" )        -> false
   *                allMatched( "" )            -> true
   **********************************************************/
  public static boolean allMatched( String s )
    {
	//algo: push to stack, one a time and check if the parenthesis of previous
	//corresponds to current. if so, pop twice
	Latkes stack = new Latkes(s.length());
	boolean ans = false;

	//used for comparison; possible parenz = () {} []
	String prev ="";
 
	//push to stack using for loop
	for (int i=0; i< s.length(); i++){
	    if (!(stack.isEmpty())){
	    prev= stack.peek();
	    stack.push(s.substring(i,i+1));}

	    else {
	    stack.push(s.substring(i,i+1));
	    }

	    if (stack.peek().equals(")") && prev.equals("(")){
		stack.pop();
		stack.pop();
		//they goot
	    }

	    if (stack.peek().equals("}") && prev.equals("{")){
		stack.pop();
		stack.pop();
		//they goot
	    }
	    if (stack.peek().equals("]") && prev.equals("[")){
		stack.pop();
		stack.pop();
		//they goot
	    }
		    
	}
	if (stack.isEmpty()){
	    ans=true;
	}

	return ans;

	
    }//end allMatched()


    //main method to test
    public static void main( String[] args )
  {
      //gr8 m8
    System.out.println(flip("stressed"));
    System.out.println(flip("elloh"));
    
    System.out.println(allMatched( "({}[()])" )); //true
    System.out.println(allMatched( "([)]" ) ); //false
    System.out.println(allMatched( "(){([])}" ) ); //true
    System.out.println(allMatched( "](){([])}" ) ); //false
    System.out.println(allMatched( "(){([])}(" ) ); //false
    System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
    //foley's tests
    System.out.println(allMatched( "()}" ) ); // false
    System.out.println(allMatched( "(){" ) ); //false
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }

}//end class LatKtS
