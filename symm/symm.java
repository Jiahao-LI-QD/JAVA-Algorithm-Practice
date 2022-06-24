/***********************************
* CSE2011 - Assignment 2 
* File name: symm.java
* Author: Li, Jiahao
* Email: jiahaoli2017@gmail.com
* CSE number: Your cse number
************************************/

public class symm {


/* 
 * Returns true if array A is symmetric.
 * Returns false otherwise.
 * n is the number of elements A contains.
 *
 * The running time of your algorithm is O(n).
 * You may add a brief explanation here if you wish.
 * 
 * Explanation:
 * This method will call a helper method which divide the question in
 * n - 2 size.
 * T(n) = c + T(n -2)
 * 		= 2c + T(n - 4)
 * 		= 3c + T(n - 6)
 * 		...
 * 		= k*c/2 + T(n-k)  when n-k = 1, k = n -1
 * so T(n) = (n/2)*c + T(1) => O(n)
 */

	public static boolean symmetric (int[] A, int n ) {
		// COMPLETE THIS METHOD.
		
		// You may define local variables inside this method.

		// You may add your own methods/subroutines to this file.
		return symmhelper(A, 0, n - 1);
		
	}  // end symmetric

	
	private static boolean symmhelper(int[] a, int s, int n) {
		if (s >= n) {
			return true;
		}
		else {
			if(a[s] != a[n]) {
				return false;
			}
			else {
				return symmhelper(a, s + 1, n - 1);
			}
		}
	}


}  // end class
