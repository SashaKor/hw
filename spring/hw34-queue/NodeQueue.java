/*
Aleksandra Koroza
APCS2 Pd. 2
HW #34: The English Do Not Wait In Line for Soup or Anything Else; They “Queue Up”
2018-04-13
 */
/*
Write class NodeQueue, which will use singly-linked nodes to implement the local Queue specification discussed in class.
 */

public class NodeQueue<Quasar> implements Queue{

    private Quasar item; 
    //constructor
    public NodeQueue<Quasar>(){
	item = new LLNode(Quasar val, );
    }
    //means of removing an element from collection:
    //Dequeues and returns the first element of the queue.
    public Quasar dequeue();

    //means of adding an element to collection:
    //Enqueue an element onto the back of this queue.
    public void enqueue( Quasar x );

    //Returns true if this queue is empty, otherwise returns false.
    public boolean isEmpty();

    //Returns the first element of the queue without dequeuing it.
    public Quasar peekFront();




}
