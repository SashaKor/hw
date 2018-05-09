/*
Team Kilors -- Angela Tom + Aleksandra Koroza
APCS2 pd2
HW46 -- Arrr, There Be Priorities Here Matey
2018-05-09
 */
import java.util.ArrayList;
public class ArrayPriorityQueue implements PriorityQueue{

    ArrayList<String> a;

    public ArrayPriorityQueue(){
	a = new ArrayList<String>();
    }
    
    //Returns true if this stack is empty or false if not
    //O(1)
    public boolean isEmpty(){
	return a.size() == 0;
    }

    //Adds the item to the priority queue
    //O(1)
    public void add(String x){
	a.add(x);
    }

    //Returns the smallest item in the queue
    //O(n)
    public String peekMin(){
	String min = a.get(0);
	for(int x = 0; x < a.size(); x++){
	    if(a.get(x).compareTo(min) < 0){
		min = a.get(x);
	    }
	}
	return min;
    }
    
    //Removes and returns the smallest item in the queue
    //O(n)
    public String removeMin(){
	String min = a.get(0);
	for(int x = 0; x < a.size(); x++){
	    if(a.get(x).compareTo(min) < 0){
		min = a.get(x);
	    }
	}
       	for(int x = 0; x < a.size(); x++){
	    if(a.get(x).equals(min)){
		a.remove(x);
	        break;
	    }
	}
	return min;
    }

    public String toString(){
	String retStr = "";
	for(Object x: a){
	    retStr += x + "  ";
	}
	return retStr;
    }
    
    public static void main(String[] args){
	ArrayPriorityQueue test = new ArrayPriorityQueue();
	test.add("foo");
	System.out.println(test);
	test.add("moo");
	System.out.println(test);
	System.out.println("Removing: " + test.removeMin());
	System.out.println(test);
	test.add("goo");
	System.out.println(test);
	test.add("hoo");
	System.out.println(test);
	test.add("doo");
	System.out.println(test);
	System.out.println("Removing: " + test.removeMin());
	System.out.println(test);
    }
    
}
