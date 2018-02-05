/*
Aleksandra Koroza
APCS1 pd 8
HW 47 ascending
2017-12-5
 */


import java.util.ArrayList;

//Implement class OrderedArrayList,
//a wrapper class for ArrayList maintaining the invariant that its elements are sorted.
public class OrderedArrayList{

    //ArrayList's single parameter add method does not ensure elements remain sorted
    public void add(ArrayList<Comparable> obj){
	if (ArrayList.size()==0)
	    {ArrayList.set(0,obj);}

	for (int i =0; i<size()-1 ; i++){
	    if ((ArrayList.get(i).compareTo(ArrayList.get(i+1)) < 0) && (ArrayList.get(i).compareTo(ArrayList.get(i-1))) >= 0)
		{ArrayList.add(i,obj);}
	}
        
    }

    public void populate (ArrayList<Comparable> arr){
	for (int i=0; i<23; i++){
	    arr.ArrayList.add(i);
	}
    }

    public static void main(String[] args){
	OrderedArrayList<Comparable> array = new OrderedArrayList<Comparable>(); 
	array.populate();
	System.out.println();

    }
}
