package com.cliff;

/**
 * @author sheryl
 * Write a java program that processes a string and switches words in adjacent pairs. 
 * Ex: “java is so cool” return “is java cool so”
 */
public class SwichWords {
	
	private static void switchWords(String words){
		final String SPACE = " ";
		String[] inputWords = words.split(SPACE);
		int noOfWords = inputWords.length;
		StringBuffer switchedWords = new StringBuffer();
		for(int i=0;i<noOfWords; i+=2){ // always take 2 consequetive words
			if(noOfWords-i == 1){ // no even pair
				switchedWords.append(SPACE + inputWords[i]);
				break;
			}				
			switchedWords.append(SPACE + inputWords[i+1] + SPACE + inputWords[i]);
		}
		System.out.println("'"+words+"' switched to '" + switchedWords.toString()+"'");
	}
	public static void main(String[] args) {
		switchWords("java is a cool language");
	}

}
