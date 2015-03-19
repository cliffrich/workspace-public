package com.cliff.codility.amazon;

/**
An integer P is a 'whole square' if it is a square of some integer Q; i.e. if P = Q2(square).

Write a function;

	class Solution{
		public int solution(int A, int B);
	}

that, given two integers A and B, returns the number of whole squares within the 
interval [A..B] (both ends included).

For example, given A = 4 and B = 17, the function should return 3, because there are 
three squares of integers in the interval [4..17], namely 4=2Sq., 9=3Sq. and 16=4Sq.

Assume that;
	* A and B are integers within the range [-2,147,483,648 .. 2147483647];
	* A <= B

Complexity:
	* expected worst-case time complexity is O(sqrt(abs(B)));
	* expected worst-case space complexity is O(1)
 *
 */
public class AmazonCodility3 {
	
	public int solution(int A, int B) {
		int count = 0, sqrt = 0;
		for(int i= A;i<=B;i++){
			sqrt = (int) Math.sqrt(i);
			if(sqrt*sqrt == i) 
				count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		AmazonCodility3 ac = new AmazonCodility3();
		System.out.println("No of squrares = " + ac.solution(4, 25));

	}

}
