package com.cliff.codility;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * This is a demo task. You can read about this task and its solutions in this blog post.

A zero-indexed array A consisting of N integers is given. An equilibrium index of this array is any integer P such that 0 ≤ P < N and the sum of elements of lower indices is equal to the sum of elements of higher indices, i.e. 
A[0] + A[1] + ... + A[P−1] = A[P+1] + ... + A[N−2] + A[N−1].
Sum of zero elements is assumed to be equal to 0. This can happen if P = 0 or if P = N−1.

For example, consider the following array A consisting of N = 8 elements:

  A[0] = -1
  A[1] =  3
  A[2] = -4
  A[3] =  5
  A[4] =  1
  A[5] = -6
  A[6] =  2
  A[7] =  1
P = 1 is an equilibrium index of this array, because:

A[0] = −1 = A[2] + A[3] + A[4] + A[5] + A[6] + A[7]
P = 3 is an equilibrium index of this array, because:

A[0] + A[1] + A[2] = −2 = A[4] + A[5] + A[6] + A[7]
P = 7 is also an equilibrium index, because:

A[0] + A[1] + A[2] + A[3] + A[4] + A[5] + A[6] = 0
and there are no elements with indices greater than 7.

P = 8 is not an equilibrium index, because it does not fulfill the condition 0 ≤ P < N.

Write a function:

int solution(int A[], int N);

that, given a zero-indexed array A consisting of N integers, returns any of its equilibrium indices. 
The function should return −1 if no equilibrium index exists.

For example, given array A shown above, the function may return 1, 3 or 7, as explained above.

Assume that:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.

Copyright 2009–2015 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
Custom test cases	0/5	
 */
public class CodilitySample1 {
	public static final BigInteger INTEGER_MIN = BigInteger.valueOf((long) Integer.MIN_VALUE);
	public static final BigInteger INTEGER_MAX = BigInteger.valueOf((long) Integer.MAX_VALUE);
	public static void main(String[] args) {
		//int equilibriumIndex = solution(new int[] {-1,3,-4,5,1,-6,2,1});
		//int[] anArray = new int[100001];
		int equilibriumIndex = solution(new int[] {500, 1, -2, -1, 2}); // got -1, but equilibrium point exists, for example on position 0 of A = [500, 1, -2, -1, 2]
		System.out.println("equilibrium index : "+ equilibriumIndex);
	}
	
	private static int solution(int[] A) {
        // write your code in Java SE 8
        int n = A.length;
        if(n < 3)
        	return -1;
        if(n>100000)
            return -1;
        if(!isInRange(A))
        	return -1;
        int p =0; int total = 0;
        for(int i=0;i<n;i++){
        	p = i;
        	// sum the lower order
        	int sumLowerOrder = 0;
        	for(int j=0;j<p;j++){
        		sumLowerOrder += A[j];
        	}
        	// sum the higher order
        	int sumHigherOrder = 0;
        	for(int k=p+1;k<n;k++){
        		sumHigherOrder += A[k];
        	}
        	if(sumLowerOrder == sumHigherOrder){
        		total++;
        		return p;
        	}
        }
        if(total>0)
        	return total;
        return -1;
    }
	private static boolean isInRange(int[] A){
		for(int i=0;i<A.length;i++){
			if(A[i] > 2147483647 || A[i] < -2147483648)
	    		return false;
		}
		return true;
	}
	private static boolean isInIntegerRange(Number number) {
	    return isInRange(number, INTEGER_MIN, INTEGER_MAX);
	  }
	public static boolean isInRange(Number number, BigInteger min,
		      BigInteger max) {
		    try {
		      BigInteger bigInteger = null;
		      if (number instanceof Integer) {
		        bigInteger = BigInteger.valueOf(number.longValue());
		      } else {
		        // not a standard number
		        bigInteger = new BigDecimal(number.doubleValue()).toBigInteger();
		      }
		      return max.compareTo(bigInteger) >= 0 && min.compareTo(bigInteger) <= 0;
		    } catch (NumberFormatException e) {
		      return false;
		    }
		  }
}
