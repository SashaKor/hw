/*
Aleksandra Koroza
APCS2 Pd2
HW #32: Leon Leonwood Stack    
2018-04-11
 */

/*****************************************************
 * class Stckr
 * driver/tester for Stack implementations (Linked-list-based, ArrayList-based)
 *****************************************************/

public class Stckr 
{
    public static void main( String[] args )
    {
	Stack<String> cakes = new ALStack<String>();
	//Stack<String> cakes = new LLStack<String>();
	System.out.println("~~~cakes is empty~~~");
	System.out.println("value printed should be true: " + cakes.isEmpty());

	System.out.println("pushing time");
	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
	cakes.push("The");
	cakes.push("hills");
	cakes.push("are");
	cakes.push("alive");
	cakes.push("with");
	cakes.push("the");
	cakes.push("sound");
	cakes.push("of");
	cakes.push("music!");

	System.out.println("cakes should no longer be empty: "+ cakes.isEmpty());
	System.out.println("testing peek and pop");

	while (! cakes.isEmpty()){
	    //expected outcome is printing double of each statement
	    System.out.println(cakes.peek());
	    System.out.println(cakes.pop());
	}

	System.out.println("empty?? "+ cakes.isEmpty());

        
	
    }//end main

}//end class

