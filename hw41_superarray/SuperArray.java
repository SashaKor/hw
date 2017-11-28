/***************************
 Aleksandra Koroza
APCS1 pd 8
HW -- hw 41 Array of Steel
2017-11-27

* class SuperArray
* Wrapper class for array. Facilitates resizing,
* getting and setting element values.
***************************/

public class SuperArray
{

  private int[] _data;  //underlying container
  private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray()
  {
      _data = new int[10];
      _size=10;
  }


  //output SuperArray in [a,b,c] format
  public String toString()
  {
      String result= "[";
      int cnt=0;
      for (int i: _data){
	  result+= i + ",";
      }
      result+="]";

      return result;
  }


  //double capacity of SuperArray
    private void expand()
    {
	int newSize=_size*2;
	_size=newSize;

	//first loop stores all the values of existing array; second populates
	//a newly expanded _data with length double that of previous _size attribute.

	//public static void grow(byte[] a, int n){
	int[] b = new int[newSize];
	for (int i=0; i < _data.length; i++){
	   b[i]=_data[i];
	}

	_data=new int[newSize];
	for (int i=0; i <b.length; i++){
	    _data[i]=b[i];
	}
    }


  //accessor -- return value at specified index
  public int get( int index )
  {
      return _data[index];
  }


  //mutator -- set value at index to newVal,
  //           return old value at index
  public int set( int index, int newVal )
  {
      int oldVal= _data[index];
      _data[index]=newVal;
      return oldVal;
  }


  //main method for testing
  public static void main( String[] args )
  {
   
      SuperArray curtis = new SuperArray();
      System.out.println( "Printing empty SuperArray curtis..." );
      System.out.println( curtis );
       
      for( int i = 0; i < curtis._data.length; i++ ) {
      curtis.set( i, i * 2 );
      }

      System.out.println("Printing populated SuperArray curtis...");
      System.out.println(curtis);

      for( int i = 0; i < 3; i++ ) {
      curtis.expand();
      System.out.println("Printing expanded SuperArray curtis...");
      System.out.println(curtis);
      }
      
  }//end main()


}//end class
