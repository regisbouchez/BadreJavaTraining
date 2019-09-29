
package com.bnpparibas.training.lambda.tp2;

public class LambdaThread {

	public static void main(String[] args) {
		Thread oldThread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Old Thread way");
			}

		});
		oldThread.start();
	}
}
