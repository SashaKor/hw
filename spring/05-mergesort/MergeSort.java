/*======================================
  Aleksandra Koroza
  APCS2 Pd. 2
  HW #05: Step 1: Split, Step 2: ?, Step 3: Sorted!.
  2018-02-06
======================================*/
/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm:
1. Split collection in half until size == 1 (is sorted by definition)
2. Compare each with nearby collection; merge adjacent collections
3. When final two collections merged, whole collection is sorted

  ======================================*/

public class MergeSort
{
  /******************************************************
   * int[] merge(int[],int[])
   * Merges two input arrays
   * Precond:  Input arrays are sorted in ascending order
   * Postcond: Input arrays unchanged, and
   * output array sorted in ascending order.
   ******************************************************/
  private static int[] merge( int[] a, int[] b )
  {
      //result int[] will be of size sum of two merging arrays
      int[] result= new int[a.length + b.length];
      int resInd =0;

      //index trackers
      int indA= 0;
      int indB= 0;

      while(indA < a.length && indB < b.length){
	  if(a[indA] <= b[indB]){
	      result[resInd] = a[indA];
	      indA++;
	      resInd++;
	  }
	  else{
	      result[resInd] = b[indB];
	      indB++;
	      resInd++;
	  }
      }

      while (indA < a.length){
	  result[resInd] = a[indA];
	  resInd++;
	  indA++;
      }

      while (indB < b.length){
	  result[resInd] = b[indB];
	  resInd++;
	  indB++;
      }
      return result;
  }


    /******************************************************
     * int[] sort(int[])
     * Sorts input array using mergesort algorithm
   * Returns sorted version of input array (ascending)
   ******************************************************/
    public static int[] sort( int[] arr )
    {
	if (arr.length<=1){
	    return arr;
	}
	
	int[] tempL = new int[ (arr.length / 2)];
	for (int i =0; i< tempL.length; i++){
	    tempL[i]= arr[i];
		}
	
	int[] tempR = new int[ (arr.length- tempL.length)];
	for (int i = 0; i< tempR.length; i++){
	    tempR[i]= arr[i+ (arr.length/2)];
		} 


	return merge(sort(tempL), sort(tempR));

   
        
	
        
	

    }//end sort()



  //-------------------HELPERS-------------------------
  //tester function for exploring how arrays are passed
  //usage: print array, mess(array), print array. Whaddayasee?
  public static void mess( int[] a ) {
    for( int i = 0 ; i<a.length; i++ )
      a[i] = 0;
  }

  //helper method for displaying an array
  public static void printArray( int[] a ) {
    System.out.print("[");
    for( int i : a )
      System.out.print( i + ",");
    System.out.println("]");
  }
  //---------------------------------------------------


  //main method for testing
  public static void main( String [] args ) {

   
      int[] arr0 = {0};
      int[] arr1 = {1};
      int[] arr2 = {1,2};
      int[] arr3 = {3,4};
      int[] arr4 = {1,2,3,4};
      int[] arr5 = {4,3,2,1};
      int[] arr6 = {0,9,17,23,42,63,512};
      int[] arr7 = {9,42,17,63,0,9,512,23,9};

      System.out.println("\nTesting mess-with-array method...");
      printArray( arr3 );
      mess(arr3);
      printArray( arr3 );

      System.out.println("\nMerging arr1 and arr0: ");
      printArray( merge(arr1,arr0) );

      System.out.println("\nMerging arr4 and arr6: ");
      printArray( merge(arr4,arr6) );
 
      System.out.println("\nSorting arr4-7...");
      printArray( sort( arr4 ) );
      printArray( sort( arr5 ) );
      printArray( sort( arr6 ) );
      printArray( sort( arr7 ) );
    
  }//end main()

}//end class MergeSort
