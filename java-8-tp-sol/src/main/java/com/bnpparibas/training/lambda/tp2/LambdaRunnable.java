
package com.bnpparibas.training.lambda.tp2;

public class LambdaRunnable {

	public static void main(String[] args) {
		Runnable newRunnable = () -> System.out.println("New Runnable way");
		newRunnable.run();
	}
}
