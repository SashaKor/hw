
/*Aleksandra Koroza
APCS2 pd2
HW #21b: We Got a Little Ol’ Convoy...
2018-03-19
*/
/*****************************************************
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 *****************************************************/

public class LLNode
{
    //instance vars
    public String value=null;
    public LLNode next=null; 

    // constructor 
    public LLNode(String str){
	this.value= str;
    }

    //--------------v  ACCESSORS  v--------------
    public String getCargo()
    {
	return this.value;
    }

    public LLNode getNext()
    {
	return this.next;
    }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public String setCargo(String str)
    {
	this.value= str;
	return toString(this);
    }

    public LLNode setNext(LLNode obj)
    {
	this.next=obj;
        return next;
    }
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
    public static String toString(LLNode obj)
    {
	//if (obj.value== null) {return "null";}
	return obj.getCargo()+ "|"+ obj.next.getCargo();
    }


    //main method for testing
    public static void main( String[] args )
    {
	LLNode test1= new LLNode("first");
	LLNode test2= new LLNode("second");

	test1.setNext(test2);
	System.out.println(toString(test1));
	
    }//end main

}//end class LLNode
