
/***********************************
* CSE2011 - Assignment 2
* File name: sum.java
* Author: Li, Jiahao
* Email: jiahaoli2017@gmail.com
* CSE number: Your cse number
************************************/

import java.util.Arrays;
public class kthsmallest {

public static final int MaxSize = 500;

/*
 * Return the value of the kth smallest element of array A.
 * n is the number of elements A contains, and k <= n.
 * The running time of your algorithm must be O(n).
 *
 */

public static int find_kth_smallest( int[] A, int n, int k )
{

   // COMPLETE THIS METHOD.

   // You may define local variables inside this method.

   // You may add your own methods/subroutines to this file.


   /* Note 1:
    * During the partitioning process, array elements may be swapped and moved around.
    * DO NOT modify the content of array A.  Copy it to a temporary array B and work on B instead.
    */

   /* Note 2:
    * DO NOT SORT THE WHOLE ARRAY and then return B[k-1].  That would take O(nlogn) time.
    * If you do that, your program will get zero point.
    */
	int[] B = A.clone();
	return helper(B, 0, n - 1, k);

}  // end find_kth_smallest

private static int helper(int[] b, int l, int r, int k) {
	boolean wait = false;
	int pivot = b[k - 1];
	swap(b, k - 1, r);
	int i = l;
	int j = r - 1;
	
	while (i < j) { 
		if (b[i++] > pivot) {
			wait = true;
			while (j >= i) {
				if (b[j--] < pivot) {
					swap(b, i - 1, j + 1);
					wait = false;
					break;
				}
			}
		}
		
	}
	if (b[i] < pivot) {
		swap(b, ++ i, r);
	}
	else if (wait){
		swap(b, --i, r);
	}
	else {
		swap(b, i, r);
	}
	
	
	if (i == k - 1) {
		return b[i];
	}
	else if (i > k - 1) {
		return helper(b, l, i - 1, k);
	}
	else {
		return helper(b, i + 1, r, k);
	}
}

private static void swap(int[] b, int a, int c) {
	int t = b[a];
	b[a] = b[c];
	b[c] = t;
	
}



} // end class

