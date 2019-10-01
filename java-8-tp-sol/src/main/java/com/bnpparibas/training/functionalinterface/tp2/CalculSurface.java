package com.bnpparibas.training.functionalinterface.tp2;

import java.util.function.BiFunction;

public class CalculSurface {

	public static void main(String[] args) {
		BiFunction<Float, Float, Float> area = (width, length) -> width * length;
		float width = 1.5f;
		float length = 3;
		float result = area.apply(width, length);
		System.out.println(result);
	}

}
