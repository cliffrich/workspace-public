package com.cliff.practice;

public class TestThreadSayTheTruth {

	public static void main(String[] args) {
		try {
			System.out.println("I want him to say ....");
			Thread testThread = new ThreadSayTheTruth();
			testThread.start();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
