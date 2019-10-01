package com.bnpparibas.training.lambda.tp1;

public class MathOperationJava8 {

	public static void main(String[] args) {
		MathOperation mathOperation = (a, b) -> a + b;
		int d = mathOperation.sommer(1, 3);
		System.out.println(d);
	}

}
