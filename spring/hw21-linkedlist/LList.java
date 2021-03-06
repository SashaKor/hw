/*Aleksandra Koroza
APCS2 pd2
HW #21c: Rockin’ Through the Night
2018-03-19

Write class LList, which uses class LLNode to implement the List interface given in class.
*/
public class LList implements List {
    private LLNode first = null;
    private LLNode last = null;

    
    //add node to list, containing input String as its data
    public boolean add( String x ){
	if(this.first==null){
	    this.first = new LLNode(x);
	    this.first.setNext(null);
	    this.last = this.first;
	}else{
	    LLNode next = new LLNode(x);
	    this.last.setNext(next);
	    this.last = next;
	}
	return true;
    }

    //return data in element at position i
    public String get( int i ){
	if(i==0){
	    return this.first.getCargo();
	}else if(i>0 && this.first!=null){
	    LLNode node = this.first;
	    for(int cnt=1; cnt<=i && node!=null ; i++){
		node = node.getNext();
	    }
	    if(node!=null){
		return node.getCargo();
	    }
	}
        return null;
    }; 

    //overwrite data in element at position i
    public String set( int i, String x ){
	//todo: implement
	return null;
    }; 

    //return length of list
    public int size(){
	int size=0;
	LLNode node = this.first;
	while(node!=null){
	    node = node.getNext();
	    size++;
	    //System.out.println(size);
	}
	return size;
    }; 

    //main method for testing
    public static void main( String[] args )
    {
	LList list = new LList();
	list.add("1");
	list.add("2");
	
	System.out.println("size: "+list.size());
	
    }//end main

}
