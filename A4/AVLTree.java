/***********************************
* EECS2011 - Assignment 4
* File name: AVLTree.java
* Author: Li, Jiahao
* Email: jiahao18@my.yorku.ca
* CSE number: jiahao18
************************************/


/**  Implementation of an AVL tree. */
public class AVLTree extends BinarySearchTree implements Dictionary {

  public AVLTree(Comparator c)  { super(c); }

  public AVLTree() { super(); }

  /** Nested class for the nodes of an AVL tree. */ 
  protected static class AVLNode extends BTNode {

    protected int height;  // we add a height field to a BTNode

    /** Preferred constructor */
    AVLNode(Object element, BTPosition parent,
	    BTPosition left, BTPosition right) {
      super(element, parent, left, right);
      height = 0;
      if (left != null) 
        height = Math.max(height, 1 + ((AVLNode) left).getHeight());
      if (right != null) 
        height = Math.max(height, 1 + ((AVLNode) right).getHeight());
    } // we assume that the parent will revise its height if needed

    public void setHeight(int h) { height = h; }

    public int getHeight() { return height; }
  }


  /**
    * Print the content of the tree root.
    */
  public void printRoot() {
     System.out.println("printRoot: " + value(left(root())).toString() + " "
        +  value(root()).toString() + " " + value(right(root())).toString());
  }


  /**
    * Print the the tree using preorder traversal.
    */
  public void preorderPrint(Position v) {
      if (isInternal(v))
         System.out.print( value(v).toString() + " " );
      if (hasLeft(v)) preorderPrint(left(v));
      if (hasRight(v)) preorderPrint(right(v));
  }


  /** Creates a new binary search tree node (overrides super's version). */
  protected BTPosition createNode(Object element, BTPosition parent,
              BTPosition left, BTPosition right) {
    return new AVLNode(element,parent,left,right);  // now use AVL nodes
  }


  /** Returns the height of a node (call back to an AVLNode). */
  protected int height(Position p)  {
    return ((AVLNode) p).getHeight();
  }


  /** Sets the height of an internal node (call back to an AVLNode). */
  protected void setHeight(Position p)  { // called only if p is internal
    ((AVLNode) p).setHeight(1+Math.max(height(left(p)), height(right(p))));
  }


  /** Returns whether a node has balance factor between -1 and 1. */
  protected boolean isBalanced(Position p)  {
    int bf = height(left(p)) - height(right(p));
    return ((-1 <= bf) &&  (bf <= 1));
  }


  /** Returns a child of p with height no smaller than that of the other child 
    */
  protected Position tallerChild(Position p)  {
    if (height(left(p)) > height(right(p))) return left(p);
    else if (height(left(p)) < height(right(p))) return right(p);
    // equal height children - break tie using parent's type
    if (isRoot(p)) return left(p);
    if (p == left(parent(p))) return left(p);
    else return right(p);
  }


  /**
    * Insert a new element into the AVL tree.
    */
  public Entry insert(Object k, Object v) throws InvalidKeyException  {
    Entry toReturn = super.insert(k, v); // calls our new createNode method
    rebalance(actionPos); // rebalance up from the insertion position
    return toReturn;
  }


  /**
    * Remove an element from the AVL tree.
    */
  public Entry remove(Entry ent) throws InvalidEntryException {
    Entry toReturn = super.remove(ent);
    if (toReturn != null)   // we actually removed something
      rebalance(actionPos);  // rebalance up the tree
    return toReturn;
  }


  /**  
    * Rebalance method called by insert and remove.  Traverses the path from 
    * zPos to the root. For each node encountered, we recompute its height 
    * and perform a trinode restructuring if it's unbalanced.
    */
  protected void rebalance(Position zPos) {
    if(isInternal(zPos))
       setHeight(zPos);
    while (!isRoot(zPos)) {  // traverse up the tree towards the root
      zPos = parent(zPos);
      setHeight(zPos);
      if (!isBalanced(zPos)) { 
	// Perform a trinode restructuring starting from zPos's tallest grandchild
        Position xPos =  tallerChild(tallerChild(zPos));
        zPos = restructure(xPos); // tri-node restructure 
        setHeight(left(zPos));  // recompute heights
        setHeight(right(zPos));
        setHeight(zPos);
      }
    }
  } 





   // ***************************************
   // DO NOT MODIFY THE CODE ABOVE THIS LINE.
   // ADD YOUR CODE BELOW THIS LINE.
   //
   // ***************************************


  /** 
   * Perform a trinode restructuring starting from x, z's tallest grandchild.
   * Input: xPos, position of (pointer to) x
   * Output: position of (pointer to) the new root of the subtree that was restructured.
   */
  protected Position restructure( Position xPos ) {

	// COMPLETE THIS METHOD
	  Position result;
	// You may add your own method(s) to this file.
	  Position y = parent(xPos);
	  Position z = parent(y);
	  boolean flag = true;
	  boolean lr = true;
	  Position subroot = null;
	  if (super.isRoot(z)) {
		  flag = false;
	  }
	  else {
		  subroot = parent(z);
		  lr = left(subroot) == z ? true : false;
	  }
	  
	  if (left(z) == y) {
		  if(left(y) == xPos) {
			  result = single1(xPos, y, z);
		  }
		  else {
			  result = double1(y, xPos, z);
		  }
	  }
	  else {
		  if(right(y) == xPos) {
			  result = single2(z, y, xPos);
		  }
		  else {
			  result = double2(z, xPos, y);
		  }
	  }
	  
	  if (flag) {
		  if (lr) {
			  ((BTPosition)subroot).setLeft((BTPosition)result);
			  ((BTPosition)result).setParent((BTPosition)subroot);
		  }
		  else{
			  ((BTPosition)subroot).setRight((BTPosition)result);
			  ((BTPosition)result).setParent((BTPosition)subroot);
		  }
	  }
	  else {
		  super.root = result;
		  ((BTPosition)result).setParent(null);
	  }
	  
	return result;	// replace this line with your code

  } // restructure

  //right left
  private Position double2(Position z, Position x, Position y) {
	  Position a = z;
	  Position b = x;
	  Position c = y;
	  Position T1 = left(z);
	  Position T2 = left(x);
	  Position T3 = right(x);
	  Position T4 = right(y);
	  link(a, b, c, T1, T2, T3, T4);
	  return b;
}
private void link(Position a, Position b, Position c, Position t1, Position t2, Position t3, Position t4) {
	((BTPosition)a).setLeft((BTPosition)t1);
	((BTPosition)a).setRight((BTPosition)t2);
	((BTPosition)c).setLeft((BTPosition)t3);
	((BTPosition)c).setRight((BTPosition)t4);
	((BTPosition)b).setLeft((BTPosition)a);
	((BTPosition)b).setRight((BTPosition)c);
	
	((BTPosition)t1).setParent((BTPosition)a);
	((BTPosition)t2).setParent((BTPosition)a);
	((BTPosition)t3).setParent((BTPosition)c);
	((BTPosition)t4).setParent((BTPosition)c);
	((BTPosition)a).setParent((BTPosition)b);
	((BTPosition)c).setParent((BTPosition)b);
}

// right right
private Position single2(Position z, Position y, Position x) {
	 Position a = z;
	  Position b = y;
	  Position c = x;
	  Position T1 = left(z);
	  Position T2 = left(y);
	  Position T3 = left(x);
	  Position T4 = right(x);

	  link(a, b, c, T1, T2, T3, T4);
	  return b;
}

// left right
private Position double1(Position y, Position x, Position z) {
	  Position a = y;
	  Position b = x;
	  Position c = z;
	  Position T1 = left(y);
	  Position T2 = left(x);
	  Position T3 = right(x);
	  Position T4 = right(z);

	  link(a, b, c, T1, T2, T3, T4);
	  return b;
  }
//left left
  private Position single1(Position x, Position y, Position z) {
	  Position a = x;
	  Position b = y;
	  Position c = z;
	  Position T1 = left(x);
	  Position T2 = right(x);
	  Position T3 = right(y);
	  Position T4 = right(z);

	  link(a, b, c, T1, T2, T3, T4);
	  return b;
  }
  
} // end AVLTree class
