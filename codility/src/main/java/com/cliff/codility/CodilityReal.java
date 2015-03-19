package com.cliff.codility;

/**
 * @author sheryl
 * 
 * A zero-indexed array A consisting of N integers is given. 
We are looking for pairs of elements of the array that are 
equal but that occupy different positions in the array. 
More formally, a pair of indices (P,Q) is called identical 
if O <= P < Q < N and A[P] = A[Q]. The goal is to calculate 
the number of identical pairs of indices.

For example, consider array A such that:

A[0] = 3
A[1] = 5
A[2] = 6
A[3] = 3
A[4] = 3
A[5] = 5

There are four pairs of identical indices:(0,3), (0,4), (1,5) and (3,4).
Note that pairs (2,2) and (5,1) are not counted since their first indices 
are not smaller than their second.

Write a function:
	class Solution{
		public int solution(int[] A);
	}
that, given a zero-indexed array A of N integers, returns the number of 
identical pairs of indices.

If the number of identical pairs of indices is greater than 1000000000, the 
function should return 1000000000.

For example, given:

A[0] = 3
A[1] = 5
A[2] = 6
A[3] = 3
A[4] = 3
A[5] = 5

the function should return 4 as explained above.
 *
 */
public class CodilityReal {

	public static void main(String[] args) {
		int count = solution(new int[] {3,5,6,3,3,5});
		System.out.println("count "+ count);
	}
	public static int solution(int[] A) {
		if(A == null)
			return 0;
		int n = A.length;
		if(n<2)
			return 0;
		int totalPairs = 0;
		for(int i=0;i<n-1;i++){
			for(int j=i+1;j<n;j++){
				System.out.println("comparing " +A[i] +" and " + A[j] );
				if(A[i] == A[j]){
					totalPairs++;
				}
			}
		}
		if(totalPairs > 1000000000)
			return 1000000000;
		return totalPairs;
    }
}
