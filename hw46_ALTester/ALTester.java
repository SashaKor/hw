/*
Aleksandra Koroza
APCS1 pd8
HW 46- Al<B> Sorted!. 
2017-12-4
*/

import java.util.ArrayList;
import java.util.*;

public class ALTester{

    ArrayList<Comparable> aList;

    //constructor populating with 23 Integers 
    public ALTester(){
        aList = new ArrayList<Comparable>();
	
    }

    //randomly populate array list
    public void populateRand(){
	for (int i=0; i<23; i++){
	    aList.add((int)(Math.random()*23));
	}
}
    // populate array list in ascending order
    public void populateSorted(){
	for (int i=0; i<23; i++){
	    aList.add(i);
	}
    }
    // populate array list with all the same
    public void populateSame(){
	for (int i=0; i<23; i++){
	    aList.add(1);
	}
    }

    //TOSTRING method
    public String toString(){
	String result="[";
	for (Object num: aList){
	    result+= num+", ";
	}
	result+="]";
	return result;
    }

    //testing if sorted.
    //array considered sorted if in ascending order or all same
    public boolean sorted(){
	Iterator<Comparable> itr= aList.iterator();
	//Iterator object allows to traverse collections
	Comparable prev= null;
	while (itr.hasNext()){
	    Comparable current = itr.next();
	    if (prev != null && prev.compareTo(current)>0){
		return false;
	    }
	    prev=current;   
	}
	return true;


    }


    

    public static void main (String[] args){
	System.out.println("-------------------------------------");
	//populating and printing
	System.out.println("Testing default constructor and random populate method");
	ALTester test0 = new ALTester();
	test0.populateRand();
	System.out.println(test0);
	System.out.println("------------------------------------");
	System.out.println("testing sorted (previously printed)");
	System.out.println(test0.sorted());

	System.out.println("Testing default constructor and ascending populate method");
	ALTester test1 = new ALTester();
	test1.populateSorted();
	System.out.println(test1);
	System.out.println("------------------------------------");
	System.out.println("testing sorted (previously printed)");
	System.out.println(test1.sorted());

	System.out.println("Testing default constructor and all same populate method");
	ALTester test2 = new ALTester();
	test2.populateSame();
	System.out.println(test2);
	System.out.println("------------------------------------");
	System.out.println("testing sorted (previously printed)");
	System.out.println(test2.sorted());
    }

    


}
