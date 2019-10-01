package com.bnpparibas.training.functionalinterface.tp1;

import java.util.function.Function;

public class MilesToKmConverter {

	public static void main(String[] args) {
		Function<Integer, Double> milesToKm = (input) -> 1.6 * input;
		int miles = 3;
		double kms = milesToKm.apply(miles);
		System.out.printf("%d miles = %3.2f kilometers", miles, kms);
	}

}
