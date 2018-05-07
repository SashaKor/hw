/*
Aleksandra Koroza
APCS2 pd2
HW #43: BSTs is the Perfect Place for Shade that’s just how I feel
2018-05-01
/*****************************************************
 * class BST - v1:partial
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

  /*****************************************************
   * default constructor
   *****************************************************/
  BST( )
  {
    _root = null;
  }


  /*****************************************************
   * void insert( int )
   * Adds a new data element to tree.
   *****************************************************/
  public void insert( int newVal )
  {
    TreeNode newNode = new TreeNode( newVal );

    if ( _root == null ) {
      _root = newNode;
      return;
    }
    insert( _root, newNode );
  }
  //recursive helper for insert(int)
  public void insert( TreeNode stRoot, TreeNode newNode )
  {
    if ( newNode.getValue() < stRoot.getValue() ) {
      //if no left child, make newNode the left child
      if ( stRoot.getLeft() == null )
        stRoot.setLeft( newNode );
      else //recurse down left subtree
        insert( stRoot.getLeft(), newNode );
      return;
    }
    else { // new val >= curr, so look down right subtree
      //if no right child, make newNode the right child
      if ( stRoot.getRight() == null )
        stRoot.setRight( newNode );
      else //recurse down right subtree
        insert( stRoot.getRight(), newNode );
      return;
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
    if ( currNode == null ) //stepped beyond leaf
      return;
    System.out.print( currNode.getValue() + " " );
    preOrderTrav( currNode.getLeft() );
    preOrderTrav( currNode.getRight() );
  }

  //recurse left, process root, recurse right
  public void inOrderTrav()
  {
    inOrderTrav( _root );
  }
  public void inOrderTrav( TreeNode currNode )
  {
    if ( currNode == null ) //stepped beyond leaf
      return;
    inOrderTrav( currNode.getLeft() );
    System.out.print( currNode.getValue() + " " );
    inOrderTrav( currNode.getRight() );
  }

  //recurse left, recurse right, process root
  public void postOrderTrav()
  {
    postOrderTrav( _root );
  }
  public void postOrderTrav( TreeNode currNode )
  {
    if ( currNode == null ) //stepped beyond leaf
      return;
    postOrderTrav( currNode.getLeft() );
    postOrderTrav( currNode.getRight() );
    System.out.print( currNode.getValue() + " "  );
  }

  //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*****************************************************
     * TreeNode search(int)
     * returns pointer to node containing target,
     * or null if target not found
     *****************************************************/
    TreeNode search( int target )
    {
        return search(target, _root);
    }

    // search helper method
    TreeNode search( int target, TreeNode currNode)
    {
	//check if found
	if (target == currNode.getValue()){
	    return currNode; 
	}
	
        else if ( target < currNode.getValue() ) {
	    //if no left child, you know you've reached end
	    if ( currNode.getLeft() == null )
	        return null;
	    else //recurse down left subtree
		return search( target, currNode.getLeft());
	}
	else { // new val >= curr, so look down right subtree
	    if ( currNode.getRight() == null )
	        return null;
	    else //recurse down right subtree
		return search( target, currNode.getRight());
    }
    }


    /*****************************************************
     * int height()
     * returns height of this tree (length of longest leaf-to-root path)
     * eg: a 1-node tree has height 0
     *****************************************************/
    public int height()
    {
	return height (_root);
    }
    //helper method
    public int height(TreeNode root){
	if (root ==null){
	    return 0;
	}

	if (root.getLeft() == null && root.getRight() == null){
	    return 0; 
	}

	int lenRight= height(root.getLeft());
	int lenLeft= height(root.getRight());

	if (lenRight< lenLeft){
	    return lenLeft+1;
	}

	return lenRight+1;
    }

    /*****************************************************
     * int numLeaves()
     * returns number of leaves in tree
     *****************************************************/
    public int numLeaves()
    {
	return numLeaves(_root);
    }

    public int numLeaves(TreeNode root){
	if (root ==null){
	    return 0;
	}

	if (root.getLeft() == null && root.getRight() == null){
	    return 1; 
	}

	else {
	    return numLeaves(root.getLeft())+numLeaves(root.getRight());
	}
	
    }
    
    // toString for ease
    public static String toString (TreeNode node){
	String retVal ="";
	if (node == null){
	    return "null";
	}
	else{
	    return retVal+ node.getValue();
		}
    }

       /*****************************************************
     * void remove(int)
     * removes specified node from tree
     *****************************************************/
     public void remove(int node){
    	remove(_root, node);
     }

     public void remove(TreeNode root, int node){
	 //will be one ahead of the given root node
	 TreeNode next= new TreeNode(0);
	 boolean right = true;

	 //if what you are searching for is less than current node, its in the left subtree
	 if (node < root.getValue()){
	     next= root.getLeft();
	     right= false;
	 }

	 if (node >= root.getValue()){
	     next= root.getRight();
	 }

	 if(node == root.getValue()){
	     next=root;
	 }

	 //now see if this next value is what you want to remove
	 if (next.getValue() == node){

	     //if this value is a leaf
	     if (next.getLeft()==null && next.getRight()==null && right){
		 root.setRight(null);
	     }
	     else if (next.getLeft()==null && next.getRight()==null && !right){
		 root.setLeft(null);
	     }

	     //if this value is on a single branch
	     else if (next.getLeft()==null && right){
		 root.setRight(next.getRight());
	     }
	     else if (next.getRight()== null && right){
		 root.setLeft(next.getRight());
	     }
	     else if (next.getLeft()==null && !right){
		 root.setRight(next.getRight());
	     }
	     else if (next.getRight()== null && !right){
		 root.setLeft(next.getRight());
	     }

	     //if this value is on a double branch, use minval helper function
	     // call remove again
	     else{
		 //set value of this junction to minimum of right branch
		 int min = minValue(next);
		 remove(next, min);
		 next.setValue(min);}}

	 
	 else {
	     if (node < root.getValue()){
		 remove(root.getLeft(),node);
	     }

	     if (node > root.getValue()){
		 remove(root.getRight(),node);
	     }
	 }
     }
			  
			  
    //find minimum value in right subtree
    public static int minValue(TreeNode root)
    {
	//direct into right subtree and save that value
        int min = root.getRight().getValue();
	root= root.getRight();

	//get to the bottom of the leftmost subtree of the right
	while (root.getLeft() != null)
        {
            min = root.getLeft().getValue();
            root = root.getLeft();
        }
        return min; //<--- min value in right subtree, bigger than everything on the left so it can replace root and still maintain BST properties
    }

    //main method for testing
    public static void main( String[] args )
    {
	BST arbol = new BST();
	BST leaf = new BST();

	//PROTIP: sketch state of tree after each insertion
	//        ...BEFORE executing these.
    arbol.insert( 4 );
    arbol.insert( 2 );
    arbol.insert( 6 );
    arbol.insert( 5 );
    arbol.insert( 1 );
    arbol.insert( 3 );
    arbol.insert( 7 );

    leaf.insert(0);
    leaf.insert(-1);
    leaf.insert(1);
    leaf.insert(4);
    leaf.insert(-3);
    leaf.insert(3);
    leaf.insert(5);
    leaf.insert(-2);
    leaf.insert(-5);

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
    System.out.println( "search method testing");
    System.out.println( "should return null 6 4");
    
    System.out.println(toString(arbol.search(39)));
    System.out.println(toString(arbol.search(6)));
    System.out.println(toString(arbol.search(4)));

    System.out.println( "\n-----------------------------");
    System.out.println( "height method testing");
    System.out.println( "should return 2");
    
    System.out.println(arbol.height());

    System.out.println( "\n-----------------------------");
    System.out.println( "leaf  method testing");
    System.out.println( "should return 3");
    
    System.out.println(arbol.numLeaves());

    System.out.println( "\n-----------------------------");
    System.out.println( "remove  method testing");
    System.out.println( "print out subsequent inorder");

    leaf.inOrderTrav();
    leaf.remove(0);
    System.out.println("~~~~~~~");
    leaf.inOrderTrav();

    System.out.println( "\n-----------------------------");
    System.out.println( "testing min val function");
    System.out.println( minValue(leaf.search(1)));

    }}//end class
