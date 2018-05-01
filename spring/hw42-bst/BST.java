/*
Aleksandra Koroza
APCS2 PD2
HW #42: Algorithm as Data Structure  ...or if it is answers you seek, start at the bottom of the page
2018-04-30
/*****************************************************
 * class BST - v1:partial
 * SKELETON
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT)
 *
 * A BST maintains the invariant that, for any node N with value V,
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value,
 *  and any value in its right subtree must be greater.)
 * This BST only holds ints (its nodes have int cargo)
 *****************************************************/

public class BST
{

    //instance variables / attributes of a BST:
    TreeNode _root;
    int size;

    /*****************************************************
   * default constructor
   *****************************************************/
  BST( )
  {
      this._root= new TreeNode(0,null,null);
      size=0;
  }


  /*****************************************************
   * void insert( int )
   * Adds a new data element to tree.
   *****************************************************/
  public void insert( int newVal )
  {
    TreeNode newNode = new TreeNode( newVal );
    if (size==0){
	_root.setValue(newVal);
	size++;
    }
    else{
	insert(_root, newNode);
	size++;}
    
  }

  //recursive helper for insert(int)
  public void insert( TreeNode stRoot, TreeNode newNode )
    {
	if (stRoot.getValue() > newNode.getValue()){
	    //place in the left subtree
	    //recurse to bottom
	    if (stRoot.getLeft() != null){
		insert(stRoot.getLeft(), newNode);}
	    stRoot.setLeft(newNode);

	}

      if (stRoot.getValue()< newNode.getValue()){
	  //place in the right subtree
	  //recurse to bottom
	  if (stRoot.getRight() != null){
	      insert(stRoot.getRight(), newNode);}
	  stRoot.setRight(newNode);

	  //exit case= its null;
      }
  }//end insert()




  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

  // each traversal should simply print to standard out
  // the nodes visited, in order


    //process root, recurse left, recurse right
    public void preOrderTrav()
    {
	preOrderTrav( _root );
    }
    public void preOrderTrav( TreeNode currNode )
    {
	if (currNode != null){
	    System.out.println(currNode.getValue());
	    preOrderTrav(currNode.getLeft());
	    preOrderTrav(currNode.getRight());}
    }


    //recurse left, process root, recurse right
    public void inOrderTrav()
    {
	inOrderTrav(_root);
    }
    public void inOrderTrav( TreeNode currNode )
    {
	if (currNode != null){
	    inOrderTrav(currNode.getLeft());
	    System.out.println(currNode.getValue());
	    inOrderTrav(currNode.getRight());}
    }


    //recurse left, recurse right, process root
    public void postOrderTrav()
    {
      postOrderTrav(_root);
    }
    public void postOrderTrav( TreeNode currNode )
    {
	if (currNode != null){
	    postOrderTrav(currNode.getLeft());
	    postOrderTrav(currNode.getRight());
	    System.out.println(currNode.getValue());}
    }

    //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  //main method for testing
  public static void main( String[] args )
  {
   

      BST arbol = new BST();

      //PROTIP: sketch state of tree after each insertion
      //        ...BEFORE executing these.
      arbol.insert( 4 );
      arbol.insert( 2 );
      arbol.insert( 5 );
      arbol.insert( 6 );
      arbol.insert( 1 );
      arbol.insert( 3 );

      System.out.println( "\n-----------------------------");
      System.out.println( "pre-order traversal:" );
      arbol.preOrderTrav();

      System.out.println( "\n-----------------------------");
      System.out.println( "in-order traversal:" );
      arbol.inOrderTrav();

      System.out.println( "\n-----------------------------");
      System.out.println( "post-order traversal:" );
      arbol.postOrderTrav();

      System.out.println( "\n-----------------------------");
  }

}//end class
