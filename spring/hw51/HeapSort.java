/*
Aleksandra Koroza
APCS2 pd2
HW #51: Heaping Piles of Sordidness
2018-05-20
 */
/*
Write class HeapSort, which uses heapification to sort an array of ints.
1) build maxheap from input data
2) swap root with largest index in the heap. root is now in sorted region
3) continue rebuilding maxheap and swapping until values sorted in ascending order 
 */
import java.util.ArrayList;

public class HeapSort{

    //sorting method
    private static void heapSort(ArrayList<Integer> heap){
	//limit scope after each pass
	// heapify up until the partition i and swap with root
	for (int i= heap.size()-1; i> 0; i--){
	    toHeap(heap,0,i);
	    swap(heap,0,i);
	}
    }


    //toHeap; a max-heapifying method
    // i is the index of partition
    // ie. heapify everything up to and including that point
    private static void toHeap(ArrayList<Integer> heap, int start, int stop){

	//initial positions of left and right children
	//start is current root
	int lc = 2*start + 1;
	int rc = 2*start + 2;

	if( lc > stop || rc > stop){
	    return; 
	}

	if (lc <= stop && heap.get(lc).intValue() > heap.get(start).intValue()){
	    swap(heap,lc,start);
	    //System.out.println(heap);
	    toHeap(heap,lc,stop);
	}

	if (rc <= stop && heap.get(rc).intValue() > heap.get(start).intValue()){
	    swap(heap,rc,start);
	    //System.out.println(heap);
	    toHeap(heap,rc,stop);
	}

    }
    //toString
    private String toString(ArrayList<Integer> heap){
	String retVal= "[";
	for (Integer i: heap){
	    retVal+= "i ";
	}
	retVal+= "]";
	return retVal; 
    }

    //swapping helper method
    private static void swap(ArrayList heap, int pos1, int pos2) {
        heap.set(pos1, heap.set(pos2, heap.get(pos1)));
    }

    public static void main(String args[]){
	ArrayList toSort= new ArrayList<Integer>();
	ArrayList simple =new ArrayList<Integer>();

	simple.add(1);
	simple.add(0);


	//sort in ascending order
	heapSort(simple);

	//print out
	System.out.println(simple);
	
	
	//populates in descending order
	for (int i=10; i>0; i--){
	    toSort.add(i);
	}

	
	//print out initial state
	System.out.println(toSort);

	//sort in ascending order
	heapSort(toSort);

	//print out
	System.out.println(toSort);

    }


}
