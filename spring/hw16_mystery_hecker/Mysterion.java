/*
Aleksandra Koroza
APCS2 pd2
HW #16: About Face
2018-03-07
 */

public class Mysterion{
    
    /* ~the mystery algorithm~
      
       (a = 0, b = 4, c = 2)
       function Mysterion(a, b, c, arr)
       v = arr[c]
       
       swap arr[c], arr[b]
       s = a
       for i in [a ... b-1]
         if arr[i] < v
           swap arr[s], arr[i]
           s += 1
       
       swap arr[b], arr[s]
       return s
    */
    //better name= doubleSwap
    //the function returns an array which swaps arr[a] with arr[b] and original value at arr[b] with arr[c]; 
    // actually no this does not hold true for all
    static int mystery(int a, int b, int c, int[] arr){
	int v = arr[c];
	int s;
	System.out.println(toString(arr));
	arr = swap(c,b,arr);
	System.out.println(toString(arr));
	s=a;

	for (int i =a; i< b; i++){
	    if (arr[i] < v){
		swap(s,i,arr);
		System.out.println(toString(arr));
		s+=1;
	    }
	}
	swap(b,s,arr);
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
    
    



    public static void main (String[] args){
	System.out.println("~~~~~~~~test1~~~~~~~~~~");
	//usual set 
	int[] test1 = {7,1,5,12,3};
	System.out.println(mystery(0,1,2,test1));
	//System.out.println(toString(test1));

	System.out.println("~~~~~~~~test2~~~~~~~~~~");
	//slightly altered
	int[] test2 = {1,7,5,12,3};
	System.out.println(mystery(0,4,2,test2));
	//System.out.println(toString(test2));

	
	System.out.println("~~~~~~~~test3~~~~~~~~~~");
	//slightly altered
	int[] test3 = {1,5,7,12,3};
	System.out.println(mystery(0,4,2,test3));
	//System.out.println(toString(test3));

	
	System.out.println("~~~~~~~~test4~~~~~~~~~~");
	//slightly altered
	int[] test4 = {1,7,5,3,12};
	System.out.println(mystery(0,4,2,test4));
	//System.out.println(toString(test4));
	System.out.println("different a,b,c values. a=1, b=2, c=3");
	System.out.println(mystery(1,2,3,test4));
	//System.out.println(toString(test4));

	
	System.out.println("~~~~~~~~test5~~~~~~~~~~");
	//sorted
	int[] test5 = {1,3,5,7,12};
	System.out.println(mystery(0,4,2,test5));
	//System.out.println(toString(test5));

	System.out.println("~~~~~~~~test6~~~~~~~~~~");
	//longer?
	int[] test6 = {1,3,5,7,12,2};
	System.out.println(mystery(0,5,2,test6));
	//System.out.println(toString(test6));
	    
    }


}
