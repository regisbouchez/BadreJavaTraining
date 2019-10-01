package com.bnpparibas.training.functionalinterface;

import java.util.function.Function;

public class PredicateDemo {

	public static void main(String[] args) {
//		Predicate<String> numbersOnly = (input) -> {
//			for (int i = 0; i < input.length(); i++) {
//				char c = input.charAt(i);
//				if ("0123456789".indexOf(c) == -1) {
//					return false;
//				}
//			}
//			return true;
//		};
//		System.out.println(numbersOnly.test("17"));
//		System.out.println(numbersOnly.test("&0456"));

		Function<String, Integer> getSize = (x -> x.length());
		Integer lenght = getSize.apply("test");
		System.out.println(lenght);
	}



}
