package com.cliff.practice;

public class ThreadSayTheTruth extends Thread{
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println("To Be or Not to Be...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
