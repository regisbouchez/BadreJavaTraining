package com.bnpparibas.training.stream.tp1;

import java.util.stream.Stream;

public class StreamCollectDemo1 {
	public static void main(String[] args) {
		String[] strings = { "a", "b", "c", "d", "e" };
		Stream<String> stream1 = Stream.of(strings);

		StringBuilder sb1 = stream1.collect(() -> new StringBuilder(), (a1, b1) -> a1.append(b1),
				(a1, b1) -> a1.append(b1));

		System.out.println(sb1.toString());

		Stream<String> stream2 = Stream.of(strings);
		StringBuilder sb2 = stream2.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);

		System.out.println(sb2.toString());
	}
}