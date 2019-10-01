package com.bnpparibas.training.stream.tp2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamCollectDemo2 {
	public static void main(String[] args) {
		String[] strings = { "a", "b", "c", "d" };
		Stream<String> stream1 = Stream.of(strings);
		List<String> list1 = stream1.collect(() -> new ArrayList<>(), (a1, b1) -> a1.add(b1),
				(a2, b2) -> a2.addAll(b2));

		list1.forEach(System.out::print);

		System.out.println();

		Stream<String> stream2 = Stream.of(strings);
		List<String> list2 = stream2.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

		list2.forEach(System.out::print);
	}
}