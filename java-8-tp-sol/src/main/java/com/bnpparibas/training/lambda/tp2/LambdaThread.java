
package com.bnpparibas.training.lambda.tp2;

public class LambdaThread {

	public static void main(String[] args) {
		Thread newThread = new Thread(() -> System.out.println("New Thread way"));
		newThread.start();
	}
}
