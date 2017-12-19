//Aleksandra Koroza, Kevin Wang; (Team GetBackToUs)
//APCS1 pd8
//HW 53
//2017-12-13

import java.util.ArrayList;

public class SortTester {
    //=================== HELPER METHODS ===================
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate(int size, int lo, int hi) {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while(size > 0) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add(lo + (int) ((hi-lo+1) * Math.random()));
	    size--;
	}
	return retAL;
    }

    //randomly rearrange elements of an ArrayList
    public static void shuffle(ArrayList al) {
	int randomIndex;
	//setup for traversal fr right to left
	for(int i = al.size()-1; i > 0; i--) {
	    //pick an index at random
	    randomIndex = (int) ((i+1) * Math.random());
	    //swap the values at position i and randomIndex
	    al.set(i, al.set(randomIndex, al.get(i)));
	}
    }
    //======================================================
    
    public static void main(String[] args) {
	//declare ArrayLists for each case
	ArrayList<Comparable> bestCaseBub = new ArrayList<Comparable>();
	ArrayList<Comparable> worstCaseBub = new ArrayList<Comparable>();
	ArrayList<Comparable> bestCaseSel = new ArrayList<Comparable>();
	ArrayList<Comparable> worstCaseSel = new ArrayList<Comparable>();
	ArrayList<Comparable> bestCaseIns = new ArrayList<Comparable>();
	ArrayList<Comparable> worstCaseIns = new ArrayList<Comparable>();

	//======================Bubble Sort Testing=======================
	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	System.out.println("Bubble Sort testing");
	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	System.out.println("-----------------------------------------");

	/*
	  Best case for bubble sort is an array that is in ascending order.
	  b/c a swap only occurs when two adjacent elmnts are in the wrong order, there will be 0 swaps.
	  The swapping mechanism is in an if statement, thus is is not always executed.
	*/
	System.out.println("Bubble Sort best case testing [0,1,2,3,4]");
	for (int i = 0; i < 5; i++)
	    bestCaseBub.add(i);
	MySorts.bubbleSort(bestCaseBub);
	      
	/*
	  Worst case for bubble sort is an array that is in descending order.
	  b/c a swap only occurs when two adjacent elmnts are in the wrong order,
	  all adjacent elmnts being compared will be swapped
	*/
	System.out.println("-----------------------------------------");
	System.out.println("Bubble Sort worst case testing [4,3,2,1,0]");
	for (int i = 4; i >=0; i--)
	    worstCaseBub.add(i);
	MySorts.bubbleSort(worstCaseBub);
	
	//=====================Selection Sort Testing======================
	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	System.out.println("Selection sort testing");
	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	System.out.println("-----------------------------------------");

	/*
	  After, testing an array in ascending order, in descending order, and shuffled, we saw the same # of passes, same # of swaps, same # of comparisons
	  b/c there is no conditional for swapping, an elmnt will swap no matter what every pass
	*/
	System.out.println("Selection sort case [0,1,2,3,4]");
	for (int i = 0; i < 5; i++)
	    bestCaseSel.add(i);
	MySorts.selectionSort(bestCaseSel);

	System.out.println("-----------------------------------------");
	System.out.println("Selection sort case [4,3,2,1,0]");
	for (int i = 4; i >= 0; i--)
	    worstCaseSel.add(i);
	MySorts.selectionSort(worstCaseSel);

	System.out.println("-----------------------------------------");
	System.out.println("Selection sort case shuffled");
	shuffle(worstCaseSel);
	MySorts.selectionSort(worstCaseSel);
	
	//=======================InsertionSort Testing==========================
	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	System.out.println("Insertion sort testing");
	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

	/*
	  Best case for insertion sort is an array that is in ascending order.
	  b/c swapping only occurs when 2 adjacent cells are in incorrect order, no swaps will be done
	*/
	System.out.println("Insertion sort best case testing [0,1,2,3,4]");
	for (int i = 0; i < 5; i++)
	    bestCaseIns.add(i);
	MySorts.insertionSort(bestCaseIns);
	      
	/*
	  Worst case for insertion sort is an array that is in descending order.
	  b/c during every pass, elmnt to the right of partition is always < elmnt to the left, so swapping will happen every time
	*/
	System.out.println("------------------------------------------");
	System.out.println("Insertion sort worst case testing [4,3,2,1,0]");
	for (int i = 4; i >= 0; i--)
	    worstCaseIns.add(i);
	MySorts.insertionSort(worstCaseIns);
    } //end main
} //end class SortTester
