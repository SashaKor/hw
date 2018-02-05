//Aleksandra Koroza, Kevin Wang; (Team GetBackToUs)
//APCS1 pd8
//HW 55 Never Fear, Big Oh Is Here!
//2017-14-13


import java.util.ArrayList;

public class MySorts {
    /*
      Ordered Array List Methods:

      Default constructor initializing array O(1) since never changes in functionality.This method initializes a new instance of an ArrayList<Comparable>.
      
      toString(): O(n) since grows linearly in proportion to size of data
      
      remove (int index): O(n) b/c there will be at most n - 1 shifts (if the first elmnt is removed)
      
      size(): O(1) since this method just returns size (an attribute tied to the add() methods).
      
      get(int index): O(1) since this method just checks a specific index and returns the value at that index; unaffected by the size of the array.

      add(): best case scenario= O(1); since element would placed on the first try. worst case scenario= O(n); since code would require traversing entire list and finally leaving the for loop. The element maybe be in the last position or not found at all.
      

      addBin(): best case scenario= O(1); since element would placed on the first try (initial halving). worst case scenario= O(log2n); since code would keep halving the data set until it reaches a point where halving is unable to continue (and value is isolated).

     */

    /*

      Insertion best is O(n) b/c after each pass, the left partition will increase by one with no swaps
      Insertion worst is O(n^2) b/c for every increase in partition size (k), there must be k - 1 comparisons (& k - 1 swaps)

     */
    // VOID version of InsertionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void insertionSort(ArrayList<Comparable> data) {
	for(int partition = 1; partition < data.size(); partition++) {
	    //partition marks first item in unsorted region

	    //diag:
	    System.out.println("\npartition: " + partition + "\tdataset:");
	    System.out.println(data); 

	    //traverse sorted region from right to left
	    for(int i = partition; i > 0; i--) {

		// "walk" the current item to where it belongs
		// by swapping adjacent items
		if (data.get(i).compareTo(data.get(i-1)) < 0) {
		    //diag:
		    System.out.println("swap indices "+(i-1)+" & "+i+"...");
		    data.set(i, data.set(i-1, data.get(i))); 
		}
		else 
		    break; 
	    }
	}
    }//end insertionSort
    /*
      Selection sort is n^2 regardless the state of the input array. Code cycles through two for loops (establishing pass and finding maxPos) no matter the input array.
     */
    // VOID version of SelectionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void selectionSort(ArrayList<Comparable> data) {
	//note: this version places greatest value at rightmost end,

	//maxPos will point to position of SELECTION (greatest value)
	int maxPos;

	for(int pass = data.size()-1; pass > 0; pass--) {
	    System.out.println("\nbegin pass " + (data.size()-pass));//diag
	    maxPos = 0;
	    for(int i = 1; i <= pass; i++) {
		System.out.println("maxPos: " + maxPos);//diag
		System.out.println(data);//diag
		if (data.get(i).compareTo(data.get(maxPos)) > 0)
		    maxPos = i;
	    }
	    data.set(maxPos, (data.set(pass, data.get(maxPos))));
	    System.out.println("after swap: " +  data);//diag
	}
    }//end selectionSort


    /*
      best for bubbleSort: O(n); Best case does not require further swapping and just leaves data as-is.
      worst for bubbleSort:O(n^2); Requires the traversal and swapping of every single element.
     */
    // VOID version of bubbleSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void bubbleSort(ArrayList<Comparable> data) {
	//make n-1 passes across collection
	for(int passCtr = 1; passCtr < data.size(); passCtr++) {
	    System.out.println("commencing pass #" + passCtr + "...");

	    //iterate from first to next-to-last element
	    for(int i = 0; i < data.size()-1; i++) {
		//if element at i > element at i+1, swap
		if (data.get(i).compareTo(data.get(i+1)) > 0) { 
		    data.set(i, data.set(i+1,data.get(i)));	
		    System.out.println(data); //diag: show current state of list
		}
	    }
	}
    } //end bubbleSort
} //end class MySorts
