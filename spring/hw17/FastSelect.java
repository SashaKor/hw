/*
Aleksandra Koroza
APCS2 pd2
HW #17: So So Fast
2018-03-11
 */

/*
 *Write Java class FastSelect, which will use your renamed mysterion method to find, as fast as possible, the yth smallest value in an array.
 */
public class FastSelect{

    //renamed mysterion
    static int partition(int left, int right, int pvtPos, int[] arr){
	int v = arr[pvtPos];
	int s;
	System.out.println(toString(arr));
	arr = swap(pvtPos,right,arr);
	System.out.println(toString(arr));
	s=left;

	for (int i =left; i< right; i++){
	    if (arr[i] < v){
		swap(s,i,arr);
		System.out.println(toString(arr));
		s+=1;
	    }
	}
	swap(right,s,arr);
	System.out.println(toString(arr));
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
	System.out.println(toString(test1));
    }


}
