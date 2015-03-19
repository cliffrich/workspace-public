package com.cliff.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cliffr
 * 
 * Prints all fibonacci numbers upto the given number
 * Has two methods doing the same job, one in a more traditional manner and the other in a recursive manner
 * 
 * For eg., if the input is 140, this program will print the 
 * Fibonacci sequences upto 140
 *
 */
public class Fibonacci {
	
	public static void getFibonacciRecursive(List<Integer> result, int currentIndex, int upto){
		int newSum = (currentIndex<2) ? currentIndex : (result.get(currentIndex-1) + result.get(currentIndex-2));
		if (newSum > upto) 
			return;
		result.add(currentIndex, newSum);	
		getFibonacciRecursive(result, currentIndex+1, upto);
	}
	public static List<Integer> getFibonacci(int upto){
		List<Integer> result = new ArrayList<Integer>();
		int newSum = 0, currentIndex = 0;
		while(newSum<upto){
			newSum = (currentIndex<2) ? currentIndex : (result.get(currentIndex-1) + result.get(currentIndex-2));
			if(newSum>upto)
				break;
			result.add(currentIndex, newSum);
			currentIndex++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		List<Integer> result = new ArrayList<Integer>();
		getFibonacciRecursive(result, 0, 140);
		//List<Integer> result = getFibonacci(140);
		for(Integer item:result){
			System.out.println(item);		
		}
	}

}
