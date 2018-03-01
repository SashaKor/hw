/*
Aleksandra Koroza
APCS2 pd2
HW #10: [Freddie Mercury, Brian May, Roger Taylor, John Deacon] x n
2018-02-27
 */

/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 */

public class QueenBoard
{
  private int[][] _board;
    
  public QueenBoard( int size ) 
  {
    _board = new int[size][size];
  }

  
  /***
   * precondition: board is filled with 0's only.
   * postcondition: 
   * If a solution is found, board shows position of N queens, 
   * returns true.
   * If no solution, board is filled with 0's, 
   * returns false.
   */
    public boolean solve()
    {
	addQueen(1,0);
	return solveH(1);

    }

  
  /**
   *Helper method for solve. 

   */
    private boolean solveH( int col ) 
    {

	if(col<_board.length){
	    for(int r = 0; r < _board.length; r++ ){
		if(_board[r][col]==0){
		    addQueen(r,col);
		    return solveH(col+1);
		}
	    }
	   
	}
        return false;
    }

    /** Print board, a la toString...
        Except:
        all negs and 0's replaced with underscore
        all 1's replaced with 'Q'
    */
    public void printSolution()
    {
	String ans = "";
	for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
		if (_board[r][c] <= 0){ans += "_"+"\t";}
		if (_board[r][c]==1){ans += "Q"+"\t";}
	        
	    }
	    ans += "\n";
	}
	System.out.println(ans);
    }



  //================= YE OLDE SEPARATOR =================

  /***
   * Adds a queen to the board
   * precondition: board was initialized and populated with zeroes
   * postcondition: adds queen in desired row and column; decrements all spots under queen's influence to the right (ie. does not mark influence down the queen's column or in row positions before the queen placed)
   */
  private boolean addQueen(int row, int col){
      //0 means no queen and not space threatened by queen
      if(_board[row][col] != 0){
	    return false;
    }
    _board[row][col] = 1;
    int offset = 1;
    //-- is decrement operator, taking available value, -1
    while(col+offset < _board[row].length){
	    _board[row][col+offset]--;
	    if(row - offset >= 0){
        _board[row-offset][col+offset]--;
	    }
	    if(row + offset < _board.length){
        _board[row+offset][col+offset]--;
	    }
	    offset++;
    }
    return true;
  }


  /***
   * Removes a queen from the board
   * precondition: board initialized and populated with zeroes. 
   * postcondition: removes queen from desired row and column. Also increments (by one) all spaces previously under the queen's influence.
   */
  private boolean removeQueen(int row, int col){
    if ( _board[row][col] != 1 ) {
	    return false;
    }
    _board[row][col] = 0;
    int offset = 1;

    while( col+offset < _board[row].length ) {
	    _board[row][col+offset]++;
	    if( row - offset >= 0 ) {
        _board[row-offset][col+offset]++;
	    }
	    if( row + offset < _board.length ) {
        _board[row+offset][col+offset]++;
	    }
	    offset++;
    }
    return true;
  }


  /***
   * Provides a visual representation of the created board.
   * precondition: A board was initialized
   * postcondition: Prints out matrix of the board's size  with the corresponding r and c values.
   */
  public String  toString() 
  {
    String ans = "";
    for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
        ans += _board[r][c]+"\t";
	    }
	    ans += "\n";
    }
    return ans;
  }


  //main method for testing...
  public static void main( String[] args )
  {
    QueenBoard b = new QueenBoard(5);
    System.out.println(b);
    b.addQueen(2,0);
    b.addQueen(0,1);
    System.out.println(b);
    b.removeQueen(3,0);
    System.out.println(b);
    //System.out.println(b.printSolution());

     QueenBoard a = new QueenBoard(5);
     a.solve();
     System.out.println(a);
     a.printSolution();

     QueenBoard z = new QueenBoard(4);
     z.solve();
     System.out.println(z);
     z.printSolution();
  }
    
}//end class
