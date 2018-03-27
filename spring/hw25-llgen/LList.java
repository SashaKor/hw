/*
Aleksandra Koroza, Angela Tom
Duo Name: Angandra 
APCS2 pd2
HW #25: Generically Speaking...
2018-03-26
 */


/*****************************************************
 * class LList
 * Implements a linked list of DLLNodes, each containing String data
 * new in v2: add-at-index, remove
 * new in v3: takes advantage of doubly-linked list
v4= generic typing!
 *****************************************************/

public class LList<T> implements List<T> //your List interface must be in same dir
{ 

    //instance vars
    private DLLNode _head;
    private DLLNode _tail;
    private int _size;

    // constructor -- initializes instance vars
    public LList( )
    {
	_head = null;//at birth, a list has no elements
	_tail = null;
	_size = 0;
    }


    //--------------v  List interface methods  v--------------
    
    public boolean add( T newVal )
    {
	DLLNode newNode = new DLLNode(newVal);

	newNode.setNext(_head);
	newNode.setPrev(null);
	if (_head!=null){
	    _head.setPrev(newNode);}
	if(_size==0){
	  _tail=newNode;}
	_head=newNode;
	_size++;
	
	return true;
    }

    
  public T get( int index )
  {
    if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

    T retVal;


    //walk to desired node
    if (index < _size/2){
	DLLNode tmp = _head; //create alias to head
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();
    
	//check target node's cargo hold
	retVal = (T) tmp.getCargo();}

    else {
	DLLNode tmp = _tail; //create alias to tail

	for( int i=_size-1; i > index-1; i-- )
	    tmp = tmp.getPrev();
    
	//check target node's cargo hold
	retVal = (T) tmp.getCargo();
    }
    return retVal;
  }


  public T set( int index, T newVal )
  {

    if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();
    T oldVal;
    if (index < _size/2){
    DLLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
	tmp = tmp.getNext();

    //store target node's cargo
    oldVal = (T)tmp.getCargo();

    //modify target node's cargo
    tmp.setCargo( newVal );}

    else {
	DLLNode tmp = _tail; //create alias to tail

	//walk to desired node
	for( int i=_size-1; i > index-1; i-- )
	    tmp = tmp.getPrev();

	//store target node's cargo
        oldVal =(T) tmp.getCargo();

	//modify target node's cargo
	tmp.setCargo( newVal );
    }

    

    return oldVal;
  }


  //return number of nodes in list
  public int size() { return _size; }
    

  //insert a node containing newVal at position index
  // Optimization= if index < size/2 start at head
    //             else start at tail
  public void add( int index, T newVal ) {

    if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

    //create a new node, prev and next both pointing to null
    DLLNode newNode = new DLLNode(newVal);

    //if index==0, insert node before head node
    if ( index == 0 ) 
	add( newVal );

    else {
	//if index is in first half of linked list
	if(index < _size/2){

	    DLLNode tmp = _head; //create alias to head

	    //walk to node before desired node
	    for( int i=0; i < index-1; i++ )
		tmp = tmp.getNext();

	    //insert new node
	    newNode.setNext( tmp.getNext() );
	    newNode.setPrev( tmp.getPrev() );
	    //tmp.getPrev().setNext(newNode);
	    tmp.getNext().setPrev(newNode);

	    tmp.setNext( newNode );

	    //increment size attribute
	    _size++;}
	else{
	    DLLNode tmp = _tail; //create alias to tail

	    //walk to node before desired node
	    for( int i=_size-1; i > index-1; i-- )
		tmp = tmp.getPrev();

	    //insert new node
	    newNode.setNext( tmp.getNext() );
	    newNode.setPrev( tmp.getPrev() );
	    tmp.getNext().setPrev(newNode);

	    tmp.setNext( newNode );

	    //increment size attribute
	    _size++;}
    }
  }


    
  //remove node at pos index, return its cargo
  public T remove( int index ) {

    if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

    T retVal;
    DLLNode tmp = _head; //create alias to head

    //if index==0, remove head node
    if ( index == 0 ) {
	    //check target node's cargo hold
	retVal =(T) _head.getCargo();

	    //remove target node
	   
	    _head = _head.getNext();
	    
    }
    //last index, remove tail node
    else if( index == _size-1){
      
	retVal =(T) _tail.getCargo();
	_tail = _tail.getPrev();
	_tail.setNext(null);
    }
    else {
	    //walk to node before desired node
	    for( int i=0; i < index-1; i++ )
		tmp = tmp.getNext();

	    //check target node's cargo hold
	    retVal = (T)tmp.getNext().getCargo();

	    //remove target node
	    tmp.setNext( tmp.getNext().getNext() );

	    (tmp.getNext().getNext()).setPrev(tmp);
    }

    //decrement size attribute
    _size--;

    return retVal;
  }

  //--------------^  List interface methods  ^--------------

  
  // override inherited toString
  public String toString()
  {
    String retStr = "HEAD=";
    DLLNode tmp = _head; //init tr
    while( tmp != null ) {
	    retStr += tmp.getCargo() + "=";
	    tmp = tmp.getNext();
    }
    retStr += "TAIL";
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

    System.out.println( "...and now 2nd item is: " + james.set(1,"got") );
    System.out.println( james );

    james.add(0,"whut");
    System.out.println( "...after add(0,whut): " );
    System.out.println( james );

    james.add(4,"phat");
    System.out.println( "...after add(4,phat): " );
    System.out.println( james );

    System.out.println( "...after remove last: " 
                        + james.remove( james._size-1) );
    System.out.println( james );

    System.out.println( "...after remove(0): " + james.remove(0) );
    System.out.println( james );

    System.out.println( "...after remove(0): " + james.remove(0) );
    System.out.println( james );

    System.out.println( "...after remove(0): " + james.remove(0) );
    System.out.println( james );
    
  }

}//end class LList


