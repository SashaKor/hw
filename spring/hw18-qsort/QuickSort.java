//Aleksandra Koroza
//APCS2 pd2
//HW18 -- QuickSort
//2018-03-13
  
/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr): 


Notes from Mr.Brown:

algo qsort(arr,left,right)
	If left < right
		pvtpos = partition(arr,left,right)
		qsort(arr,left,pvtpos-1)
		qsort(arr,pvtpos + 1,right)

 *
 * 2a. Worst pivot choice and associated runtime: 
 *
 * 2b. Best pivot choice and associated runtime:
 *
 * 3. Approach to handling duplicate values in array:
 *
 *****************************************************/

public class QuickSort
{
  //--------------v  HELPER METHODS  v--------------
  //swap values at indices x, y in array o
  public static void swap( int x, int y, int[] o ) {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
  }

  //print input array 
  public static void printArr( int[] a ) {
    for ( int o : a )
	    System.out.print( o + " " );
    System.out.println();
  }

  //shuffle elements of input array
  public static void shuffle( int[] d ) {
    int tmp;
    int swapPos;
    for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
    }
  }

  //return int array of size s, with each element fr range [0,maxVal)
  public static int[] buildArray( int s, int maxVal ) {
    int[] retArr = new int[s];
    for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }

    // from Lili Yan's rumpus room submission:

    /***
     * int partition(int[] arr, int left, int right, int pvtPos):
     ** considers values of array arr between indices left and right, 
     ** organizes that part of arr such that all values less than the value at 
     index pvtPos are to the left of the pivot value, and all values greater 
     are to the right of the pivot value
     ** returns final position of former value at index pvtPos; ie position in a sorted array
     ** runtime: O(n)

     * @param arr initial array of integers
     * @param left starting index of set of values in arr to be organized
     * @param right ending index of set of values in arr to be organized
     * @param pvtPos index whose corresponding value is used to determine what
     values are put to the left of the pivot value, and what values are put to
     the right of the pivot value      
    ***/
    // partition method
    static int partition(int left, int right, int pvtPos, int[] arr){
	int v = arr[pvtPos];
	int s;
        swap(pvtPos,right,arr);
	s=left;

	for (int i =left; i< right; i++){
	    if (arr[i] < v){
		swap(s,i,arr);
		s+=1;
	    }
	}
	swap(right,s,arr);

	return s;

    }



    
  //--------------^  HELPER METHODS  ^--------------



  /*****************************************************
   * void qsort(int[])
   * @param d -- array of ints to be sorted in place
   *****************************************************/
    public static void qsort( int[] d )
    { 
	qsortH(d, 0, d.length-1);    }

    /*****************************************************
     * void qsortH(int[], int, int)
     * @param d -- array of ints to be sorted in place
     * @param left -- leftmost point of range
     * @param right -- rightmost point of range
     *****************************************************/
    //qsort helper method
    public static void qsortH(int[] arr, int left, int right){
	int pvtPos;
	if (left < right){
	    //setting pivot position.
	    //line returns the final postion of the current right term0
	    pvtPos= partition(left, right, right ,arr);
	    
	    //printArr(arr);

	    //looking at left side and sorting.
	    qsortH(arr,left,pvtPos-1);
	    //printArr(arr);
	    //looking at right side and sorting
	    qsortH(arr,pvtPos+1,right);
	    //printArr(arr);
	}
    }


    //main method for testing
    public static void main( String[] args )
    {
	

	//get-it-up-and-running, static test case:
	int [] arr1 = {7,1,5,12,3};
	System.out.println("\narr1 init'd to: " );
	printArr(arr1);

	qsort( arr1 );	
	System.out.println("arr1 after qsort: " );
	printArr(arr1);

// randomly-generated arrays of n distinct vals
	int[] arrN = new int[10];
    for( int i = 0; i < arrN.length; i++ )
    arrN[i] = i;
       
    System.out.println("\narrN init'd to: " );
    printArr(arrN);

    shuffle(arrN);
    System.out.println("arrN post-shuffle: " );
    printArr(arrN);

    qsort( arrN );
    System.out.println("arrN after sort: " );
    printArr(arrN);


    //get-it-up-and-running, static test case w/ dupes:
    int [] arr2 = {7,1,5,12,3,7};
    System.out.println("\narr2 init'd to: " );
    printArr(arr2);

    qsort( arr2 );	
    System.out.println("arr2 after qsort: " );
    printArr(arr2);


    // arrays of randomly generated ints
    int[] arrMatey = new int[20];
    for( int i = 0; i < arrMatey.length; i++ )
    arrMatey[i] = (int)( 48 * Math.random() );
       
    System.out.println("\narrMatey init'd to: " );
    printArr(arrMatey);

    shuffle(arrMatey);
    System.out.println("arrMatey post-shuffle: " );
    printArr(arrMatey);

    qsort( arrMatey );
    System.out.println("arrMatey after sort: " );
    printArr(arrMatey);
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main

}//end class QuickSort
