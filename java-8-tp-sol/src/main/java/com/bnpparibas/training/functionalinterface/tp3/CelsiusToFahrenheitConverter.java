package com.bnpparibas.training.functionalinterface.tp3;

import java.util.function.IntToDoubleFunction;

public class CelsiusToFahrenheitConverter {

	public static void main(String[] args) {
		IntToDoubleFunction celsiusToFahrenheit = (input) -> 1.8 * input + 32;
		double result = celsiusToFahrenheit.applyAsDouble(20);
		System.out.println(result);
	}

}
