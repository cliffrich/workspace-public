package com.cliff.practice;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
	
	public static void getFibonacciRecursive(List<Integer> result, int start, int currentSum, int upto){
		while(currentSum<upto){
			if(start<2)
				result.add(start, start);
			else
				result.add(start, result.get(start-1) + result.get(start-2));
			getFibonacciRecursive(result, start+1, result.get(start), upto);
		}
	}
	public static List<Integer> getFibonacci(int upto){
		List<Integer> result = new ArrayList<Integer>();
		int sum = 0, count = 0;
		while(sum<upto){
			if(count<2)
				sum = count;
			else
				sum = result.get(count-1) + result.get(count-2);
			if(sum>upto)
				break;
			result.add(count, sum);
			count++;
		}
		return result;
	}
	/*public static void printFibonacci(int upto){
		int[] fibArr = new int[upto];
		int sum = 0, count = 0;
		for(;count<=upto;count++){
			if(count<2)
				sum = count;
			else
				sum = fibArr[count-1] + fibArr[count-2];
			if(sum>upto)
				break;
			fibArr[count] = sum;
		}
		for(int i=0;i<count;i++){
			System.out.println(fibArr[i]);
		}
	}*/
	public static void main(String[] args) {
		List<Integer> result = new ArrayList<Integer>();
		getFibonacciRecursive(result, 0, 0, 140);
		//List<Integer> result = getFibonacci(140);
		for(Integer item:result){
			System.out.println(item);		
		}
	}

}
