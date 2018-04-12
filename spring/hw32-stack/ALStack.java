/*
Aleksandra Koroza
APCS2 Pd2
HW #32: Leon Leonwood Stack    
2018-04-11
 */
/*
Write class ALStack, which will implement a stack using an ArrayList as its underlying container.
 */

import java.util.ArrayList;

public class ALStack<T> implements Stack<T>{

    private ArrayList<T> al;

    //constructor
    public ALStack(){
	al= new ArrayList<T>();
    }

        //0(1) since only checking size
    public boolean isEmpty(){
	return al.isEmpty();
    }

    //0(1) 
    public T peek(){
	return al.get(al.size()-1); 
    }

    public T pop(){
	return al.remove(al.size()-1);
    }

    public void push(T x){
	al.add(x);
    }



}
