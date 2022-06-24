/***********************************
* EECS2011 - Assignment 3
* File name: ListDeque.java
* Author: Li, Jiahao
* Email: jiahaoli2017@gmail.com
* EECS username: jiahao18
************************************/


public class ListDeque 
{

   protected DNode header, trailer;  // dummy nodes

   protected int size;    // number of elements

   public ListDeque()     // constructor: initialize an empty deque
   {
      header = new DNode( 0, null, null );
      trailer = new DNode( 0, null, null );
      header.setNext(trailer);  // make header point to trailer
      trailer.setPrev(header);  // make trailer point to header
      size = 0;
   }


    /**
     * Display the content of the deque
     *
     */
    public void printDeque( )
    {
	for ( DNode p = header.getNext(); p != trailer; p = p.getNext() )
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
    	
      return this.header.getNext() == this.trailer;   // replace this line with your code
    }


    /**
     * Returns the first element of the deque
     * 
     */
    public int getFirst( ) throws EmptyDequeException
    {
    	// COMPLETE THIS METHOD     
    	if (this.isEmpty()) {
    		throw new EmptyDequeException("Empty!");
    	}
    	return this.header.getNext().getElement();
        // replace this line with your code       
    }


    /**
     * Returns the last element of the deque
     * 
     */
    public int getLast( ) throws EmptyDequeException
    {
    	// COMPLETE THIS METHOD   
    	return this.trailer.getPrev().getElement();
    	// replace this line with your code         
    }


    /**
     * Inserts e at the beginning (as the first element) of the deque
     * 
     */
    public void insertFirst( int e )
    {
    	// COMPLETE THIS METHOD   
    	DNode tem = this.header.getNext();
    	this.header.setNext(new DNode(e, null, null));
    	tem.setPrev(this.header.getNext());;
    	this.header.getNext().setPrev(this.header);
    	this.header.getNext().setNext(tem);
    	size++;
    }


    /**
     * Inserts e at the end (as the last element) of the deque
     * 
     */
    public void insertLast( int e )
    {
    	// COMPLETE THIS METHOD   
    	DNode tem = this.trailer.getPrev();
    	this.trailer.setPrev(new DNode(e, null, null));
    	tem.setNext(trailer.getPrev());
    	this.trailer.getPrev().setPrev(tem);
    	this.trailer.getPrev().setNext(this.trailer);
    	size++;
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
    	int result = this.header.getNext().getElement();
    	DNode temp = this.header.getNext().getNext();
    	temp.setPrev(this.header);
    	this.header.getNext().setNext(null);
    	this.header.getNext().setPrev(null);
    	this.header.setNext(temp);
    	size--;
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
    	int result = this.trailer.getPrev().getElement();
    	DNode temp = this.trailer.getPrev().getPrev();
    	temp.setNext(this.trailer);
    	this.trailer.getPrev().setNext(null);
    	this.trailer.getPrev().setPrev(null);
    	this.trailer.setPrev(temp);
    	size--;
    	return result;
    	// replace this line with your code
    }


} // end class

