package com.cliff.codility.amazon;

/**
 * 
Write a function:

	char * solution(char *S, char *T);

that, given two strings S and T consisting of N and M characters, respectively,
determines whether string T can be obtained from string S by at most one insertion or 
deletion of a character, or by swapping two adjacent characters once. The function 
should return a string;

	* "INSERT c" if string T can be obtained from string S by inserting a single character "c";
	* "DELETE c" if string T can be obtained from string S by deleting a single character "c";
	* "SWAP c" if string T can be obtained from string S by swapping two adjacent characters "c" and "d" 
		(these characters should be distinct and they should be in this order in string S);
	* "NOTHING" if no operation is needed (strings T and S are equal);
	* "IMPOSSIBLE" if none of the above works.
	
For example, given S = "nice" and T = "niece", the function should return "INSERT e".
Given S = "form" and T = "from", the function should return "SWAP o r".
Given S = "o" and T = "odd", the function should return "IMPOSSIBLE".

Assume that;
	* N and M are integers within the range [1..100];
	* string S consists only of lower-case letters (a-z);
	* string T consists only of lower-case letters (a-z).
	
In your solution, focus on correctness. The performance of your solution will not be 
the focus of the assessment.

 *
 */
public class AmazonCodelity1 {

	public String solution(String S, String T){
		String result = null;
		String[] alphabets = {"a","b", "c","d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w","x", "y", "z"};
		
		if(S.equalsIgnoreCase(T))
			return "NOTHING";
		String temperoryWord = null;

		// Insert
		for(int i = 0;i<S.length(); i++){
			for(int j=0;j<alphabets.length;j++){
				if(i==0)
					temperoryWord = alphabets[j]+ S;
				else
					temperoryWord = S.substring(0, i) + alphabets[j] + S.substring(i, S.length());
				if(temperoryWord.equals(T)){
					result = "INSERT "+alphabets[j];
					break;
				}					
			}
		}
		// For Delete
		String removed = null;
		for(int i = 0;i<S.length(); i++){
			if(i==0){
				temperoryWord = S.substring(1, S.length());
				removed = S.substring(0, 1);
			} else{
				temperoryWord = S.substring(0, i) + S.substring(i+1, S.length());
				removed = S.substring(i, i+1);
			}
				
			if(temperoryWord.equals(T)){
				result = "DELETE "+removed;
				break;
			}					
		}
		// Switch
		String switched = null;
		for(int i = 0;i<S.length(); i++){
			if(i==0){
				temperoryWord = S.substring(1, S.length()) + S.substring(0, 1);
				switched = S.substring(0, 1);
			} else {
				temperoryWord = S.substring(0, i-1)+ S.substring(i, i+1) +S.substring(i-1, i)+S.substring(i+1, S.length());
				switched = S.substring(i, i+1) + " " + S.substring(i-1, i);
			}				
			if(temperoryWord.equals(T)){
				result = "SWAP "+switched;
				break;
			}	
		}

		if(result == null)
			result = "IMPOSSIBLE";
		return result;
	}
	public static void main(String[] args) {
		AmazonCodelity1 ac = new AmazonCodelity1();
		String result = ac.solution("amazno", "amazon");
		System.out.println(result);
	}

}
