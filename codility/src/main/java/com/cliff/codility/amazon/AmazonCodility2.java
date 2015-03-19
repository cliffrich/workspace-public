package com.cliff.codility.amazon;

import java.util.Stack;

/**
A zero-indexed array A consisting of N integers is given. A pair of integers (P,Q),
such that 0 <= P <= Q <= N, is called slice of array A. A slice is called bi-valued if it 
consists of at most two different numbers. Write a function;

	class Solution{
		public int solution(int[] A);
	}

that, given an array A consisting of N integers, returns the size of the largest 
bi-valued slice in A.

For example, given array A such that;

	A[0] = 5
	A[1] = 4
	A[2] = 4
	A[3] = 5
	A[4] = 0
	A[5] = 12

the function should return 4, because (0,3) is a slice containing only 4 and 5.

There are also some other shorter bi-valued slices, such as; (1,3), (4,5) and (1,2) 
(a bi-valued slice can also contain just one valued). Slice (3,5) is not bi-valued as it 
consists of three different numbers.

Assume that;
	* N is an integer within the range [0 .. 100,000];
	* each element of array A is an integer within the range [-2,147,483,648 .. 2147483647]

Complexity:
	* expected worst-case time complexity is O(N);
	* expected worst-case space complexity is O(1), beyond input
	  storage (not counting the storage required for input arguments)
	
	Elements of input arrays can be modified.
 *
 */
public class AmazonCodility2 {
	
	/*public int solution(int[] A) {
		int count = 0, biValueCount= 0;
		int savePoint = 0;
        for(int i=0;i<A.length-2;i++){
        	for(int j=1;j<A.length-1;j++){
        		System.out.println("comparing " + A[i] + " and " + A[j]);
        			
        		if(A[j] <A[i])
        			continue;
        		if(A[i] != A[j])
        			biValueCount++;
        	}
    		if(biValueCount == 2)
    			count++;
        }
        return count++;
    }*/
	
	/*public int solution(int[] A){
		int N = A.length;
	    int distance = 0;
	    for(int i = 0; i < N-1; i++) {
	        for(int j = i; j < N; j++){            
	            if(A[i] <= A[j]  && (j - i) > distance)
	                distance = j - i;
	        }
	    }
	    return distance;
	}*/
	/*public int solution(int[] A){
		int max = 0;
	    for(int i=0; i<A.length-1; i++) {
	        for(int j=i+1; j<A.length; j++) {
	            if(A[j] >= A[i] && (j - i) >= max) {
	                max = j - i;
	            }
	        }
	    }
	    return max;
	}*/
	public static void fun(int[] a) {
	    Stack<Integer> s = new Stack<Integer>();
	    s.push(a[0]);

	    for (int i = 1; i < a.length; i++) {
	        if (s.peek() != null) {
	            while (true) {
	                if (s.peek() == null || s.peek() > a[i]) {
	                    break;
	                }
	                System.out.println(s.pop() + ":" + a[i]);
	            }
	        }
	        s.push(a[i]);
	    }
	    while (s.peek() != null) {
	        System.out.println(s.pop() + ":" + -1);
	    }
	}
	public int solution(int[] A){
		int[] top = new int[A.length];
		int max = -Integer.MAX_VALUE;
		for (int i=A.length-1; i>=0; i--) {
		    if (A[i] > max) max = A[i];
		    top[i] = max;
		}
		int best = 0;
		for (int i=0; i<A.length; i++) {
		    int c = find(top, A[i]) - i;
		    if (c > best) best = c;
		    if (best >= A.length-i) return best;
		}

		return best;
	}
	int find(int[] t, int min) {
	    int s = 0;
	    int e = t.length-1;

	    if (t[e] >= min) return e;

	    while (true) {
	        int x = (s+e) / 2;
	        if (x == t.length-1) return t.length-1;
	        if (t[x] >= min && t[x+1] < min) return x;

	        if (t[x] < min) e = x;
	        else s = x;
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AmazonCodility2 ac = new AmazonCodility2();
		System.out.println("No of Bivalues = " +ac.solution(new int[] {5,4,4,5,0,12}));
	}

}
