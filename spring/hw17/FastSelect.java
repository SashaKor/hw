
/*
Aleksandra Koroza
Fred (team)
APCS2 pd2
HW #17: So So Fast
2018-03-11
 */

/*
 *Write Java class FastSelect, which will use your renamed mysterion method to find, as fast as possible, the yth smallest value in an array.

~ partition: given a range, places everything bigger than pvtPos value to the right of pvtPos, and everything less than to the right.
~preliminary ideas: creating a merge sort esque algorithm that rearranges each part.


Algorithm: 
Using y-1 as the pivot point each time, if the partition return y-1 number of values smaller than itself --> return arr[y-1]
repeat this process until the condition is satisfied (at most n number of times)

Best case: O(1). Satisfies condition on the first partition
Worst case O(n) Have to cycle through entire array and partition each time (ie. array scrambled and in descending order). Im still confused as to the costliness of the partition operation. 
     
 */
public class FastSelect{
    //for 
    static int counter= 0;
    static int fastSelect(int[] arr, int y){
	counter=0;
	for (int i=0; i< arr.length; i++){
	    System.out.println(toString(arr));
	    if( partition(0, arr.length-1, y-1, arr) == y-1)
		{return arr[y-1];}}
	return 0;				 

    }


    //renamed mysterion
    static int partition(int left, int right, int pvtPos, int[] arr){
	int v = arr[pvtPos];
	int s;
	//System.out.println(toString(arr));
	arr = swap(pvtPos,right,arr);
	//System.out.println(toString(arr));
	s=left;

	for (int i =left; i< right; i++){
	    counter++;
	    if (arr[i] < v){
		swap(s,i,arr);
		//System.out.println(toString(arr));
		s+=1;
	    }
	}
	swap(right,s,arr);
	//System.out.println(toString(arr));
	return s;

    }

    //swap helper method
    static int[] swap(int x, int y, int[] arr){
	int temp=arr[x];

	arr[x]=arr[y];
	arr[y]=temp;

	return arr;
    }

    //string out
    public static String toString(int[] arr){
	String result="{";
	for (int i: arr){
	    result+= i+",";
	}
	result+= "}";
	return result;
	
    }
    



    public static void main(String[] args){
	//test run of renamed mysterion
	System.out.println("~~~~~~~~test1~~~~~~~~~~");
	//usual set 
	int[] test1 = {7,1,5,12,3};
	System.out.println(partition(0,4,2,test1));
	System.out.println(partition(0,4,1,test1));
	System.out.println(partition(0,4,0,test1));
	//System.out.println(partition(0,4,1,test1));
	//System.out.println(toString(test1));
    

	//test run of renamed mysterion
	System.out.println("~~~~~~~~test2~~~~~~~~~~");
	//usual set 
	int[] test2 = {7,1,5,12,3};
	System.out.println(partition(0,4,3,test2));
	//System.out.println(toString(test1));
	System.out.println(partition(0,2,1,test2));
	System.out.println(partition(0,4,3,test2));
    

	System.out.println("~~~~~~~~worst~~~~~~~~~~");
	//usual set 
	int[] test3 = {18,17,16,15,5,3,2,1,0,-2,-3,-4,-5};
	//System.out.println(toString(test3));
	System.out.println(fastSelect(test3,13));
	System.out.println(counter);

	System.out.println("~~~~~~~~best~~~~~~~~~~");
	//usual set 
	int[] test4 = {0,1,2,3};
	//System.out.println(toString(test3));
	System.out.println(fastSelect(test4,2));
	System.out.println(counter);

    }}

   


   



