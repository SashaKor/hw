/*
Aleksandra Koroza
APCS2 pd 2
HW #23: Give and Take
2018-03-22
 */

/*****************************************************
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 *****************************************************/

public class LList implements List //your List interface must be in same dir
{ 

    //instance vars
    private LLNode _head;
    private int _size;

    // constructor -- initializes instance vars
    public LList( )
    {
	_head = null; //at birth, a list has no elements
	_size = 0;
    }


    //--------------v  List interface methods  v--------------
    
    public boolean add( String newVal )
    {
	LLNode tmp = new LLNode( newVal, _head );
	_head = tmp;
	_size++;
	return true;
    }


    public void add( int index, String newVal )
    //question: what index considered out of bounds?
    //decision-> do not allow to add to front
	
    {
	if ( index <= 0 || index > size() )
	    throw new IndexOutOfBoundsException();

	LLNode tmp = _head; //create alias to head
	//walk to desired node (which is 1 less than desired point of addition

	for( int i=0; i < index-1; i++ ){
	    tmp = tmp.getNext();
	    System.out.println(i);
	}
	

	tmp.setNext(new LLNode(newVal,tmp.getNext()));
	//this line is important. Why?
	tmp=_head;
	_size++;
    }

    //removes the node at position i and returns its cargo
    public String remove( int index ){
	
	    String retVal= "";
	    if ( index < 0 || index > size() )
		throw new IndexOutOfBoundsException();

	    LLNode tmp = _head; //create alias to head
	    //special case when at head position
	    if (index==0){
		retVal= tmp.getCargo();

		tmp= tmp.getNext();
		tmp=_head;
		_size--;
		return retVal;
		
	    }

	    //walk to desired node (which is 1 less than desired point of addition
	    else{
	    for( int i=0; i < index-1; i++ ){
		tmp = tmp.getNext();
		//System.out.println(i);
	    }

	    retVal= tmp.getNext().getCargo();

	    //where the magic happens <3
	    tmp.setNext(tmp.getNext().getNext());
	    tmp=_head;
	    _size--;
	    

	    return retVal;}}


    
	public String get( int index )
	{
	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	String retVal;
	LLNode tmp = _head; //create alias to head

	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

	//check target node's cargo hold
	retVal = tmp.getCargo();
	return retVal;
    }


    public String set( int index, String newVal )
    {

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	LLNode tmp = _head; //create alias to head

	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

	//store target node's cargo
	String oldVal = tmp.getCargo();

	//modify target node's cargo
	tmp.setCargo( newVal );

	return oldVal;
    }


    //return number of nodes in list
    public int size() { return _size; }
    
    //--------------^  List interface methods  ^--------------


    // override inherited toString
    public String toString()
    {
	String retStr = "HEAD->";
	LLNode tmp = _head; //init tr
	while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
	}
	retStr += "NULL";
	return retStr;
    }


    //main method for testing
    public static void main( String[] args )
    {
	LList james = new LList();

	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("beat");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("a");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("need");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("I");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	System.out.println( "2nd item is: " + james.get(1) );

	james.set( 1, "got" );
	System.out.println( "...and now 2nd item is: " + james.set(1,"got") );

	System.out.println( james );

	//testing add method
	System.out.println("add w/ parameters method");
	LList jesse  = new LList();
	System.out.println( jesse );
	jesse.add("cat");
	jesse.add("parrot");
	jesse.add("dog");

	System.out.println(jesse);
	jesse.add(3,"inserted");
	System.out.println(jesse);

	//testing remove method
	System.out.println("remove method");
	LList meowth  = new LList();
	System.out.println( meowth );
        meowth.add("cat");
	meowth.add("parrot");
	meowth.add("dog");

	System.out.println(meowth);
        meowth.remove(0);
	System.out.println(meowth);
	
    }

}//end class LList


