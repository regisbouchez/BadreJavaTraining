package com.bnpparibas.training.methodreferences.tp3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.function.Supplier;

public class ConstructorMethodReference {

	public static Collection<Integer> arrayToCollection(Supplier<Collection<Integer>> supplier, Integer[] numbers) {
		Collection<Integer> collection = supplier.get();
		for (int i : numbers) {
			collection.add(i);
		}
		return collection;
	}

	public static void main(String[] args) {
		Integer[] array = { 1, 8, 5 };
		Collection<Integer> col1 = arrayToCollection(ArrayList<Integer>::new, array);
		System.out.println("Natural order");
		col1.forEach(System.out::println);
		System.out.println("=======================");
		System.out.println("Ascending order");
		Collection<Integer> col2 = arrayToCollection(HashSet<Integer>::new, array);
		col2.forEach(System.out::println);
	}
}