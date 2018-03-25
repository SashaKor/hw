/*
Aleksandra Koroza, Angela Tom
Duo Name: Angandra 
APCS2 pd2
HW #24a: On the DLL
 */

/*****************************************************
 * class DLLNode
 * Implements a doubly-linked node,
 * for use in lists and other collection classes.
 * Stores data of type String
 *****************************************************/

public class DLLNode 
{
    private String _cargo;    //cargo may only be of type String
    private DLLNode _nextNode, _prevNode; //pointers to next, prev DLLNodes

    // constructor -- initializes instance vars

    public DLLNode( String value ) {
	_cargo = value;
	_nextNode = null;
	_prevNode = null;
    }

    public DLLNode( String value, DLLNode next, DLLNode prev ) {
	_cargo = value;
	_nextNode = next;
	_prevNode = prev;
    }


    //--------------v  ACCESSORS  v--------------
    public String getCargo() { return _cargo; }

    public DLLNode getNext() { return _nextNode; }

    public DLLNode getPrev() { return _prevNode; }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public String setCargo( String newCargo ) {
	String foo = getCargo();
	_cargo = newCargo;
	return foo;
    }

    public DLLNode setNext( DLLNode newNext ) {
	DLLNode foo = getNext();
	_nextNode = newNext;
	return foo;
    }

    public DLLNode setPrev( DLLNode newPrev ) {
	DLLNode foo = getPrev();
	_prevNode = newPrev;
	return foo;
    }

    //--------------^  MUTATORS  ^--------------

     // override inherited toString
    public static String toString(DLLNode obj)
    {
	//if (obj.value== null) {return "null";}
	return obj._prevNode.getCargo()+"|"+ obj.getCargo()+ "|"+ obj._nextNode.getCargo();

    }


    //main method for testing
    public static void main( String[] args )
    {
	DLLNode test1= new DLLNode("first");
	DLLNode test2= new DLLNode("second");
	DLLNode test3= new DLLNode("third");

	test1.setNext(test2);
	test1.setPrev(test3);
	System.out.println(toString(test1));
	
    }//end main

}//end class DLLNode
