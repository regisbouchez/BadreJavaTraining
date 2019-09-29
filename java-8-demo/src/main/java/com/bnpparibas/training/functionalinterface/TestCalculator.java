package com.bnpparibas.training.functionalinterface;

public class TestCalculator {
	public static void main(String[] args) {
		Calculator addCalculatorWithParamTypes = (a, b) -> a + b;
		System.out.println(addCalculatorWithParamTypes.calculate(2, 3));

		Calculator addCalculatorWithoutParamTypes = (a, b) -> {
			System.out.println("a+b");
			return a + b;
		};
		System.out.println(addCalculatorWithoutParamTypes.calculate(2, 3));
	}
}
