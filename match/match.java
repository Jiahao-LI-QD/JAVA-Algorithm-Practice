
/***********************************
* CSE2011 - Assignment 2
* File name: sum.java
* Author: Li, Jiahao
* Email: jiahaoli2017@gmail.com
* CSE number: Your cse number
************************************/


public class match {

/*
 * EXHAUSTIVE ALGORITHM
 * Returns index i if array A contains an element A[i] such that A[i] = i.
 * If there exist many of such elements, return the index of any one of them.
 * Returns -1 if there exists no element A[i] such that A[i] == i.
 * n is the number of elements A contains.
 *
 * The running time of your algorithm is O(N).
 * You may add a brief explanation here if you wish.
 */


public static int match_exh( int[] A, int n ) 
{

   // COMPLETE THIS METHOD.

   // You may define local variables inside this method.

   // You may add your own methods/subroutines to this file.
	for(int i = 0; i < n; i++) {
		if (A[i] == i) {
			return i;
		}
	}
	return -1;
} // end match_exh




/*
 * DIVIDE-AND-CONQUER ALGORITHM
 * Returns index i if array A contains an element A[i] such that A[i] = i.
 * If there exist many of such elements, return the index of any one of them.
 * Returns -1 if there exists no element A[i] such that A[i] == i.
 * n is the number of elements A contains.
 *
 * The running time of your algorithm is O(logN).
 * You may add a brief explanation here if you wish.
 */

public static int match_dac( int[] A, int n )
{

   // COMPLETE THIS METHOD.

   // You may define local variables inside this method.

   // You may add your own methods/subroutines to this file.
	return matchhelper(A, 0, n-1);
}  // end match_dac




private static int matchhelper(int[] a, int s, int e) {
	int i = (s + e) / 2;
	if (a[i] == i) {
		return i;
	}
	else {
		if (s == e) {
			return -1;
		}
		else if (a[i] > i) {
			return matchhelper(a, s, i - 1);
		}
		else {
			return matchhelper(a, i + 1, e);
		}
	}
}


} // end class
