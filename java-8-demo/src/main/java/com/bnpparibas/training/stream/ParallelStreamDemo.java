package com.bnpparibas.training.stream;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class ParallelStreamDemo {

	public static long fibonacci(long i) {
		if (i == 1 || i == 2) {
			return 1;
		}
		return fibonacci(i - 1) + fibonacci(i - 2);
	}

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(10, 20, 30);
		// List<Integer> numbers =
		// Arrays.asList(1, 2, 3, 4, 5, 6);

		Instant start = Instant.now();
		for (Integer i : numbers) {
			long j = fibonacci(i);
			System.out.println(j);
		}
		Instant end = Instant.now();
		System.out.printf("Processing time with old style : %dms\n", Duration.between(start, end).toMillis());

		start = Instant.now();
		numbers.parallelStream().map((input) -> fibonacci(input)).forEach(System.out::println);
		end = Instant.now();
		System.out.printf("Processing time with parallel stream : %dms\n", Duration.between(start, end).toMillis());

		start = Instant.now();
		numbers.stream().map((input) -> fibonacci(input)).forEach(System.out::println);
		end = Instant.now();
		System.out.printf("Processing time with sequential stream : %dms\n", Duration.between(start, end).toMillis());
	}
}