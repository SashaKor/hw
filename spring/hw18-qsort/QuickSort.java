//Aleksandra Koroza
//APCS2 pd2
//HW18 -- QuickSort
//2018-03-13
  
/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:a recursive divide and conquer algorithm. 
 * QSort(arr): (based on my implemetation, can be optimized with median or random choosing)
1) Choose the rightmost element in the array and partition. (step results in subarrays with all values smaller than pivot to the left and all values bigger to the right)
2) Recursively call step 1 on each resulting subarray until no more comparisons are possible. 

Notes from Mr.Brown:

algo qsort(arr,left,right)
	If left < right
		pvtpos = partition(arr,left,right)
		qsort(arr,left,pvtpos-1)
		qsort(arr,pvtpos + 1,right)

 *
 * 2a. Worst pivot choice and associated runtime: 
 * The runtime associated with the worst case is O(n^2) since it would require comparisons for each element in the array. Thus, the worst pivot choice would be the largest or smallest value in the array (since the partition is unbalanced).

 * 2b. Best pivot choice and associated runtime:
The runtime associated with the best case is O(nlogn), when the partition is as evenly balanced as possible. Thus, the ideal pivot choice would be the median value of the array (although this is not guaranteed to actually happen). Choosing from the middle region of the array could minimize the possibility of inportune partitions.
 *
 * 3. Approach to handling duplicate values in array:
My code works as intended when given duplicate values (repeated in order). My implementation of quick sort looks at the last value when completing comparisons. I do not yet know under which cases duplicates would be an issue.
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
