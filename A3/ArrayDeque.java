/***********************************
* EECS2011 - Assignment 3
* File name: ArrayDeque.java
* Author: Li, Jiahao
* Email: jiahaoli2017@gmail.com
* EECS username: jiahao18
************************************/


public class ArrayDeque
{
   public static final int INIT_CAPACITY = 8;	// initial array capacity
   protected int capacity;  // current capacity of the array
   protected int front;     // index of the front element
   protected int rear;      // index of the rear element
   protected int[] A;	    // array deque

   public ArrayDeque( )      // constructor method
   {
      A = new int[ INIT_CAPACITY ];
      capacity = INIT_CAPACITY;
      front = rear = 0;
   }


    /**
     * Display the content of the deque
     * 
     */
    public void printDeque( )
    {
      for ( int i = front; i != rear; i = (i+1) % capacity )
	System.out.print( A[i] + " " );
      System.out.println();
    }


    /**
     * Display the content of the whole array
     *
     */
    public void printArray( )
    {
	for ( int i = 0; i < capacity; i++ )
	   System.out.print( A[i] + " " );
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

        // Hint: size can be computed from capacity, front and rear.
    	
    	return (this.rear + this.capacity - this.front) % this.capacity;   // replace this line with your code
    }


    /**
     * Returns true if this collection is empty.
     * @return true if this collection is empty.
     */ 
    public boolean isEmpty( )
    {
    	// COMPLETE THIS METHOD

      return this.rear == this.front;   // replace this line with your code
    }


    /**
     * Returns the first element of the deque
     * 
     */
    public int getFirst() throws EmptyDequeException
    {
    	// COMPLETE THIS METHOD 
      return this.A[front];   // replace this line with your code       
    }


    /**
     * Returns the last element of the deque
     * 
     */
    public int getLast( ) throws EmptyDequeException
    {
    	// COMPLETE THIS METHOD   

      return this.A[(this.rear - 1 + this.capacity) % this.capacity];   // replace this line with your code         
    }


    /**
     * Inserts e at the beginning (as the first element) of the deque
     * 
     */
    public void insertFirst( int e )
    {
    	if (this.size() == this.capacity - 1) {
    		this.doublesize();
    	}
    	this.front = (this.front - 1 + this.capacity) % this.capacity;
    	A[this.front] = e;// COMPLETE THIS METHOD   
    }



	/**
     * Inserts e at the end (as the last element) of the deque
     * 
     */
    public void insertLast( int e )
    {
    	// COMPLETE THIS METHOD   
    	if (this.size() == this.capacity - 1) {
    		this.doublesize();
    	}
    	this.rear = (this.rear + 1) % this.capacity;
    	A[(this.rear - 1 + this.capacity) % this.capacity] = e;
    }


    /**
     * Removes and returns the first element of the deque
     * 
     */
    public int removeFirst( ) throws EmptyDequeException
    {
    	// COMPLETE THIS METHOD	
    	if (this.front == this.rear) {
    		throw new EmptyDequeException("This collection is empty");
    	}
    	else if (this.size() < this.capacity / 4) {
    		this.halfsize();
    	}
    	int result = this.A[this.front % this.capacity];
    	this.A[this.front++ % this.capacity] = 0;
    	this.front %= this.capacity;
      return result;   // replace this line with your code	
    }


    /**
     * Removes and returns the last element of the deque
     * 
     */
    public int removeLast( ) throws EmptyDequeException
    {
    	// COMPLETE THIS METHOD		
    	if (this.front == this.rear) {
    		throw new EmptyDequeException("This collection is empty");
    	}
    	else if (this.size() < this.capacity / 4) {
    		this.halfsize();
    	}
    	int result = this.A[(this.rear - 1 + this.capacity) % this.capacity];
    	this.A[(--this.rear + this.capacity) % this.capacity] = 0;
    	this.rear %= this.capacity;
      return result;   // replace this line with your code
    }
    
    public void doublesize() {
    	
    	int[] B = new int[this.capacity * 2];
    	int size = this.size();
    	int j=0;
    	for ( int i = front ; i != rear; i = (i+1) % capacity) {
			B[j++] = A[i];
		}
    	this.front = 0;
    	this.rear = size;
    	this.capacity = capacity * 2;
    	this.A = B;
    }
    
    private void halfsize() {
		if (this.capacity == ArrayDeque.INIT_CAPACITY) {
			return;
		}
		int[] B = new int[this.capacity / 2];
		int size = this.size();
		int j = 0;
		for ( int i = front ; i != rear; i = (i+1) % capacity) {
			B[j++] = A[i];
		}
		this.front = 0;
		this.rear = size;
		this.capacity /= 2;
		this.A = B;
	}
}  // end class

