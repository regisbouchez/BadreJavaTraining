package com.bnpparibas.training.functionalinterface;

@FunctionalInterface
public interface Calculator {

	double calculate(int a, int b);

	// Adding this will make the annotation invalid
	// double calculate2(int a, int b);

	default int subtract(int a, int b) {
		return a - b;
	}

	default int add(int a, int b) {
		return a + b;
	}

	static int multiply(int a, int b) {
		return a * b;
	}

	// Overriding object methods is still allowed
	@Override
	String toString();

}
