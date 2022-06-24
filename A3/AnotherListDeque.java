/***********************************
* EECS2011 - Assignment 3
* File name: AnotherListDeque.java
* Author: Li, Jiahao
* Email: jiahaoli2017@gmail.com
* EECS username: jiahao18
************************************/


public class AnotherListDeque 
{

   protected DNode head, tail;  // head and tail contain actual data (int)

   protected int size;    // number of elements

   public AnotherListDeque()     // constructor: initialize an empty deque
   {
       head = tail = null;
       size = 0;
   }


    /**
     * Display the content of the deque
     *
     */
    public void printDeque( )
    {

	for ( DNode p = head; p != null; p = p.getNext() )
	    System.out.print( p.getElement() + " " );
	System.out.println();

    }


   // ***************************************
   // DO NOT MODIFY THE CODE ABOVE THIS LINE.
   // ADD YOUR CODE BELOW THIS LINE.
   //
   // ***************************************

   /**
     * Returns the number of items in this collection.
     * @return the number of items in this collection.
     */
    public int size( )
    {
        // COMPLETE THIS METHOD

      return this.size;   // replace this line with your code
    }


    /**
     * Returns true if this collection is empty.
     * @return true if this collection is empty.
     */ 
    public boolean isEmpty( )
    {
    	// COMPLETE THIS METHOD
    	
      return this.head == null;   // replace this line with your code
    }


    /**
     * Returns the first element of the deque
     * 
     */
    public int getFirst( ) throws EmptyDequeException
    {
    	// COMPLETE THIS METHOD   
    	if (this.isEmpty()) {
    		throw new EmptyDequeException("Empty");
    	}
    	return this.head.getElement();
    	// replace this line with your code       
    }


    /**
     * Returns the last element of the deque
     * 
     */
    public int getLast( ) throws EmptyDequeException
    {
    	// COMPLETE THIS METHOD   
    	if (this.isEmpty()) {
    		throw new EmptyDequeException("Empty");
    	}
    	return this.tail.getElement();
    	// replace this line with your code         
    }


    /**
     * Inserts e at the beginning (as the first element) of the deque
     * 
     */
    public void insertFirst( int e )
    {
    	
    	// COMPLETE THIS METHOD 
    	if (this.isEmpty()) {
    		this.head = this.tail = new DNode(e, null, null);
    	}
    	else if(this.size() == 1) {
    		this.head = new DNode(e,null, this.tail);
    		this.tail.setPrev(this.head);
    	}
    	else {
    		DNode n = new DNode(e, null, this.head);
    		this.head.setPrev(n);
    		this.head = n;
    	}
		this.size++;
    }


    /**
     * Inserts e at the end (as the last element) of the deque
     * 
     */
    public void insertLast( int e )
    {
    	// COMPLETE THIS METHOD   
    	if (this.isEmpty()) {
    		this.head = this.tail = new DNode(e, null, null);
    	}
    	else if(this.size() == 1) {
    		this.tail = new DNode(e, this.head, null);
    		this.head.setNext(this.tail);
    	}
    	else {
    		DNode n = new DNode(e, this.tail, null);
        	this.tail.setNext(n);
        	this.tail = n;
    	}
		this.size++;
    }


    /**
     * Removes and returns the first element of the deque
     * 
     */
    public int removeFirst( ) throws EmptyDequeException
    {
    	// COMPLETE THIS METHOD
    	if (this.isEmpty()) {
    		throw new EmptyDequeException("Empty");
    	}
    	else if (this.size-- == 1) {
    		int result = this.head.getElement();
    		this.head = this.tail = null;
    		return result;
    	}
    	int result = this.head.getElement();
    	DNode temp = this.head.getNext();
    	temp.setPrev(null);
    	this.head.setNext(null);
    	this.head = temp;
    	return result;
    	// replace this line with your code	
    }


    /**
     * Removes and returns the last element of the deque
     * 
     */
    public int removeLast( ) throws EmptyDequeException
    {
    	// COMPLETE THIS METHOD		
    	if (this.isEmpty()) {
    		throw new EmptyDequeException("Empty");
    	}
    	else if (this.size-- == 1) {
    		int result = this.head.getElement();
    		this.head = this.tail = null;
    		return result;
    	}
    	int result = this.tail.getElement();
    	DNode temp = this.tail.getPrev();
    	temp.setNext(null);
    	this.tail.setPrev(null);
    	this.tail = temp;
    	return result;
    	// replace this line with your code
    }


} // end class

