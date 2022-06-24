/***********************************
* EECS2011 - Assignment 3
* File name: AnotherListMain.java
* Author: U. T. Nguyen 
************************************/

public class AnotherListMain {

    public static void main(String[] args) {
	AnotherListDeque q = new AnotherListDeque();
	q.insertFirst(120);

	System.out.println(q.size());
	q.printDeque();
	q.insertFirst(15);

	System.out.println(q.size());
	q.printDeque();
	System.out.println("first=" + q.getFirst());
	System.out.println("last=" + q.getLast());
	q.insertLast(401);
	System.out.println(q.size());
	q.printDeque();
	q.insertLast(65);
	q.insertLast(37);

	System.out.println(q.size());
	q.printDeque();
	System.out.println(q.size());
	System.out.println("first=" + q.getFirst());
	System.out.println("last=" + q.getLast());
	System.out.println("remove first=" + q.removeFirst());
	q.printDeque();
	System.out.println(q.size());
	System.out.println("remove last=" + q.removeLast());
	System.out.println("remove last=" + q.removeLast());
	q.printDeque();
	System.out.println(q.size());
	System.out.println("remove last=" + q.removeFirst());

	q.printDeque();
	System.out.println(q.head.element);
	System.out.println(q.tail.element);
	System.out.println(q.size());
	System.out.println("remove last=" + q.removeLast());
	q.printDeque();System.out.println(q.size());

    }
}
