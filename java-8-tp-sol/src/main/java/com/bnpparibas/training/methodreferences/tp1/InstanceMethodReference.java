package com.bnpparibas.training.methodreferences.tp1;

import java.util.Arrays;
import java.util.List;

public class InstanceMethodReference {
	public static void main(String[] args) {
		List<String> fruits = Arrays.asList("Orange", "Apple", "Banana");
		// with lambda expression
		fruits.forEach((name) -> System.out.println(name));
		// with method reference
		fruits.forEach(System.out::println);
		/**
		 * Comparator function: int compare(String str1, String str2)
		 * 
		 * Instance method compareToIgnoreCase: int compareToIgnoreCase(String
		 * str)
		 */
		fruits.sort(String::compareToIgnoreCase);
		fruits.forEach(System.out::println);
	}
}