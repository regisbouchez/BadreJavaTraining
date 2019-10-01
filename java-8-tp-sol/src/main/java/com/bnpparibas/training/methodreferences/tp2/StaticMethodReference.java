package com.bnpparibas.training.methodreferences.tp2;

import java.util.Arrays;
import java.util.List;

public class StaticMethodReference {

	public static void formatAndPrint(StringListFormatter formatter, String delimiter, List<String> list) {
		String formatted = formatter.format(delimiter, list);
		System.out.println(formatted);
	}

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Don", "King", "Kong");
		formatAndPrint(String::join, ", ", names);
	}
}