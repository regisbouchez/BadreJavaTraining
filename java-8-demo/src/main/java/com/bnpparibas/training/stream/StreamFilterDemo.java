package com.bnpparibas.training.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamFilterDemo {
	public static void main(String[] args) throws IOException {
		Predicate<String> notCommentOrEmptyLine = (line) -> line.trim().length() > 0 && !line.trim().startsWith("#");

		try (Stream<String> stream = Files.lines(Paths.get("src/main/resources/example.txt"))) {
			// Chaining
			stream.filter(notCommentOrEmptyLine).forEach(System.out::println);
		}
	}
}