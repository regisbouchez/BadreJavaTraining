package com.bnpparibas.training.datetime.tp1;

public class CalculDuration {

	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();
		Thread.sleep(10000);
		long end = System.currentTimeMillis();
		System.out.println("Took : " + ((end - start) / 1000) + " sec");
	}

}
