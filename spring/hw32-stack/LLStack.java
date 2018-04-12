/*
Aleksandra Koroza
APCS2 Pd2
HW #32: Leon Leonwood Stack    
2018-04-11
 */
/*
Write class LLStack, which will implement your locally defined Stack interface (see skeleton) using Java’s built-in linked list as its underlying container.
*/

import java.util.LinkedList;
    
public class LLStack<T> implements Stack<T>{

    private LinkedList<T> ll;
    

    //constructor
    public LLStack(){
        ll= new LinkedList<T>();
    }
    
    
    //0(1) since only checking size
    public boolean isEmpty(){
	if (ll.size()==0)
	    return true;
	return false;
    }

    //0(1) since only looking at head
    public T peek(){
	return ll.peek(); 
    }

    //0(1) removes last thing on stack, a constant time operation
    public T pop(){
	return ll.pop();
    }

    //0(1) a constant time operation, only appends to front
    public void push(T x){
	ll.push(x);
    }


}
