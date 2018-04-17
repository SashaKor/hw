/*
Aleksandra Koroza
APCS2 Pd. 2
HW #34: The English Do Not Wait In Line for Soup or Anything Else; They “Queue Up”
2018-04-13
 */
/*
Write class NodeQueue, which will use singly-linked nodes to implement the local Queue specification discussed in class.
 */

public class NodeQueue<T> implements Queue<T>{

    LLNode<T> anchor;
    int size;

    LLNode<T> first;
    LLNode<T> last; 
    

    //constructor
    public NodeQueue(){
	anchor = new LLNode("anchor", null);
	size = 0;
	first = anchor;
	last= anchor;
    }
    //means of removing an element from collection:
    //Dequeues and returns the first element of the queue.
    public T dequeue(){

	if (size>1){
	    first= first.getNext();
	    size--;
	}

	else{
	    first.setValue(null);
	    size--;
	}
	return first.getValue();
    }

    //means of adding an element to collection:
    //Enqueue an element onto the back of this queue.
    public void enqueue( T x ){
	LLNode newItem =new LLNode(x, null);

	if (size==0){
	    anchor.setNext(newItem);
	    first= newItem;
	    last= newItem;
	    size++; 
	}
	else{
	    last.setNext(newItem);
	    last= newItem; 
	    size++;
	}
    }

    //Returns true if this queue is empty, otherwise returns false.
    public boolean isEmpty(){
	return size==0; 
    }

    //Returns the first element of the queue without dequeuing it.
    public T peekFront(){
	
	return first.getValue();
    }

    public static void main(String[] args){
	NodeQueue<String> cat = new NodeQueue<String>();
	System.out.println("created a new Queue called cat");
	//test isEmpty
	System.out.println("Queue cat is empty: " + cat.isEmpty());

	//first in first out functionality, FIFO
	System.out.println("Enqueue several elements to cat");
	cat.enqueue("the");
	cat.enqueue("hills");
	cat.enqueue("are");
	cat.enqueue("alive");
	cat.enqueue("with");
	cat.enqueue("the");
	cat.enqueue("sound");
	cat.enqueue("of");
	cat.enqueue("music!");

	System.out.println("Queue cat is empty: " + cat.isEmpty());

	while (! cat.isEmpty()){
	//will print double if working correctly
	System.out.println(cat.peekFront());
	System.out.println(cat.dequeue());
	}
	System.out.println("we have dequeued");
	System.out.println("Queue cat is empty: " + cat.isEmpty());

	

    }}





