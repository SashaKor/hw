/***
 Aleksandra Koroza
APCS1 Pd8
HW #57: How Deep Does the Rabbit Hole Go? …
12-20-17

* class Matrix -- models a square matrix
 *
 * BACKGROUND:
 * A matrix is a rectangular array.
 * Its dimensions are numRows x numColumns.
 * Each element is indexed as (row,column): 
 *  eg,
 *   for 2 x 3 matrix M:
 *        -       -
 *   M =  | a b c |
 *        | d e f |
 *        -       -
 *   ... d is at position (2,1) or M[2,1] 
 *
 * TASK:
 * Implement methods below, categorize runtime of each. 
 * Test in main method.
 ***/


public class Matrix 
{
  //constant for default matrix size
  private final static int DEFAULT_SIZE = 2;

  private Object[][] matrix;

  //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
    // O(1)
  public Matrix( ) 
	{
	    matrix= new Object[DEFAULT_SIZE][DEFAULT_SIZE];
  }


  //constructor intializes an a*a matrix
    //O(1)
  public Matrix( int a ) 
  {
      matrix= new Object[a][a];
  }


  //return size of this matrix, where size is 1 dimension
    // O(1)
  private int size() 
  {
      return matrix[0].length;
  }


  //return the item at the specified row & column
    //O(1)
  private Object get( int r, int c ) 
  {
      return matrix[r][c];
  }


  //return true if this matrix is empty, false otherwise
    //O(n)
  private boolean isEmpty() 
  {
      boolean empty= true;

      for (Object obj: matrix){
	  if (obj != null){
	      empty=false;
	  }
      }
      return empty;
  }


  //overwrite item at specified row and column with newVal
  //return old value
    // O(1)
  private Object set( int r, int c, Object newVal ) 
  {
      Object old= matrix[r][c];
      matrix[r][c]= newVal;
      return old;
  }


  //return String representation of this matrix
  // (make it look like a matrix)
    //O(n)
    public String toString() 
    {
        String result= "";
	String row="";
	for(Object[] r: this.matrix){
	    row="";
	    for (Object obj: r){
		row+= obj+" ";
	    }
	    result+=row;
	    result+="\n";
	}
	return result;
	
    }


  //override inherited equals method
  //criteria for equality: matrices have identical dimensions,
  //and identical values in each slot
    //O(n^2)?
    public boolean equals( Object rightSide ) {
	if (rightSide==null)
	    {return false;}
	else if (rightSide instanceof Matrix)
	    {
		Matrix other = (Matrix) rightSide;

		if (other.size() != this.size())
		    {return false;}

		boolean valSame= true;

		for (int r=0; r< matrix.length;r++) {
		    for (int c=0; c< matrix[r].length; c++){
			if (!(other.matrix[r][c].equals(this.matrix[r][c]))){
			    valSame=false;
			    break;
			}
		    }
		}
		return valSame;
	    }

	else {return false;}

    }

  //swap two columns of this matrix 
  //(1,1) is top left corner of matrix
  //row values increase going down
  //column value increase L-to-R
    // O(n)
  public void swapColumns( int c1, int c2  ) 
  {
      //c1 switches with c2
      //(1,1) are 1 greater than actual index, thus:
      int col1= c1-1;
      int col2= c2-1;

      for (int i=0; i< matrix.length; i++){
	  Object toInput= this.matrix[i][col1];

	  this.matrix[i][col1]= this.matrix[i][col2];
	  this.matrix[i][col2]= toInput;
      }

  }


  //swap two rows of this matrix 
  //(1,1) is top left corner of matrix
  //row values increase going down
  //column value increase L-to-R
    //O(n)
  public void swapRows( int r1, int r2  ) 
  {
      //r1 switches with r2
      //(1,1) is 1 greater than actual indices, thus:
      int row1= r1-1;
      int row2= r2-1;

      for (int i=0; i< matrix.length; i++){
	  Object toInput= this.matrix[row1][i];

	  this.matrix[row1][i]= this.matrix[row2][i];
	  this.matrix[row2][i]= toInput;
      }
      
  }


  //main method for testing
  public static void main( String[] args ) 
  {
      System.out.println("test default constructor with no params + set method");
      Matrix test1= new Matrix();
      
      //set values for each place in new Matrix object
      test1.set(0,0,1);
      test1.set(0,1,2);
      test1.set(1,0,3);
      test1.set(1,1,4);
      System.out.println(test1);
      System.out.println("--------------------------------");


      System.out.println("test constructor with specified dimension (3)");
      Matrix test2= new Matrix(3);
      
      //populate ~lazy way
      test2.set(0,0,1);
      test2.set(1,0,2);
      test2.set(2,0,3);
      test2.set(0,1,4);
      test2.set(1,1,5);
      test2.set(2,1,6);
      test2.set(0,2,7);
      test2.set(1,2,8);
      test2.set(2,2,9);
      System.out.println(test2);
     
      System.out.println("--------------------------------");
      System.out.println("testing equals method");
      Matrix test3= new Matrix(3);
      Matrix test4= new Matrix(4);
      Matrix test5= new Matrix(4);

      System.out.println("compare test1 and test2:"+test1.equals(test2));
      //System.out.println("compare test4 and test5:"+test4.equals(test5));
      System.out.println("compare test1 and test4:"+test1.equals(test4));

      System.out.println("--------------------------------");
      System.out.println("testing swapColumns and swapRows");

      System.out.println("test2 before swapping");
      System.out.println(test2);
      System.out.println("test2 after swapColumns(1,2)");
      test2.swapColumns(1,2);
      System.out.println(test2);
      System.out.println("test2 after swapRows(1,2)");
      test2.swapRows(1,2);
      System.out.println(test2);
  }

}//end class Matrix
