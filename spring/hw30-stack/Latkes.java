/*
Aleksandra Koroza
APCS2 Pd.2
HW #30: Stacks on Stacks on Stacks on Stacks… …  (Do I Smell Recursion?)
2018-4-9
/*****************************************************
 * skeleton for class Latkes
 * Implements a stack of Strings using an encapsulated array
 *****************************************************/

public class Latkes
{
  private String [] _stack;
  private int _stackSize;

  //constructor
  public Latkes( int size )
  {
      _stack = new String[size];
  }

  //means of insertion
    // add at _stackSize
  public void push( String s )
  {
      if (isFull()){
	  System.out.println("stack overflow!");}

      else{
	  _stack[_stackSize]= s;
	  _stackSize++;}
  }

  //means of removal
  public String pop( )
  {
      if (isEmpty()){
	  //System.out.println("already empty!");
	  return null;}
	  
      else{
	  String ret = _stack[_stackSize-1];
	  _stack[_stackSize-1]=null;
	  _stackSize--;
	  return ret;}
  }

  //chk for emptiness
  public boolean isEmpty()
  {
      return _stackSize == 0;
  }

  //chk for fullness
  public boolean isFull()
  {
      return _stackSize == _stack.length;
  }


  //main method for testing
  public static void main( String[] args )
  {
   
      Latkes tastyStack = new Latkes(10);

      tastyStack.push("aoo");
      tastyStack.push("boo");
      tastyStack.push("coo");
      tastyStack.push("doo");
      tastyStack.push("eoo");
      tastyStack.push("foo");
      tastyStack.push("goo");
      tastyStack.push("hoo");
      tastyStack.push("ioo");
      tastyStack.push("joo");
      tastyStack.push("coocoo");
      tastyStack.push("cachoo");

      //cachoo
      System.out.println( tastyStack.pop() );
      //coocoo
      System.out.println( tastyStack.pop() );
      //joo
      System.out.println( tastyStack.pop() );
      //ioo
      System.out.println( tastyStack.pop() );
      //hoo
      System.out.println( tastyStack.pop() );
      //goo
      System.out.println( tastyStack.pop() );
      //foo
      System.out.println( tastyStack.pop() );
      //eoo
      System.out.println( tastyStack.pop() );
      //doo
      System.out.println( tastyStack.pop() );
      //coo
      System.out.println( tastyStack.pop() );
      //boo
      System.out.println( tastyStack.pop() );
      //aoo
      System.out.println( tastyStack.pop() );

      //stack empty by now; SOP(null)
      System.out.println( tastyStack.pop() );
   

  }//end main()

}//end class Latkes