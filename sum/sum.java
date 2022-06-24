
/***********************************
* CSE2011 - Assignment 2
* File name: sum.java
* Author: Li, Jiahao
* Email: jiahaoli2017@gmail.com
* CSE number: Your cse number
************************************/


public class sum {


/*
 * EXHAUSTIVE ALGORITHM
 * Returns true if array A contains two elements whose sum is k.
 * Returns false otherwise.
 * n is the number of elements A contains.
 *
 * The running time of your algorithm is O( n ^ 2).
 * You may add a brief explanation here if you wish.
 */

public static boolean sum_exh( int[] A, int n, int k )
{
   // COMPLETE THIS METHOD.

   // You may define local variables inside this method.

   // You may add your own methods/subroutines to this file.

	for (int a : A) {
		for (int b : A) {
			if (a == b) {
				continue;
			}
			else {
				if (a + b == k) {
					return true;
				}
			}
		}
	}
	return false;
}  // end sum_exh





/*
 * RECURSIVE ALGORITHM
 * Returns true if array A contains two elements whose sum is k.
 * Returns false otherwise.
 * n is the number of elements A contains.
 *
 * The running time of your algorithm is O( n ).
 * You may add a brief explanation here if you wish.
 */

public static boolean sum_rec( int[] A, int n, int k )
{
   // COMPLETE THIS METHOD.

   // You may define local variables inside this method.
	return sum_rechelper(A, 0, n-1, k);
   // You may add your own methods/subroutines to this file.
	
}  // end sum_rec

private static boolean sum_rechelper(int[] A, int a, int b, int k) {
	if (a == b) {
		return false;
	}
	else {
		if (A[a] + A[b] > k) {
			return sum_rechelper(A, a, --b, k);
		}
		else if (A[a] + A[b] < k){
			return sum_rechelper(A, ++a, b, k);
		}
		else {
			return true;
		}
	}
}

} // end class
