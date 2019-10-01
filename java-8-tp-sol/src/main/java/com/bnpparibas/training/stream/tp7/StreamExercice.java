package com.bnpparibas.training.stream.tp7;

import java.util.Arrays;
import java.util.List;

public class StreamExercice {
	public static void main(String[] args) {
		List<String> words = Arrays.asList("hi", "hello", "hola", "bye", "goodbye", "adios");
		System.out.printf("Original words: %s.%n", words);
		// Stream<String> wordStream = words.stream(); Then, reuse wordStream.
		// NO!! Why not?

		String upperCaseWords = words.stream().reduce("", (s1, s2) -> s1.toUpperCase() + s2.toUpperCase());
		System.out.printf("Single uppercase String: %s.%n", upperCaseWords);

		// Alternative solution to problem 1: change into uppercase
		// at the end instead of as you go along.
		String upperCaseWordsAlt = words.stream().reduce("", String::concat).toUpperCase();
		System.out.printf("Single uppercase String: %s.%n", upperCaseWordsAlt);

		String upperCaseWords2 = words.stream().map(String::toUpperCase).reduce("", String::concat);
		System.out.printf("Single uppercase String: %s.%n", upperCaseWords2);

		String wordsWithCommas = words.stream().reduce((s1, s2) -> s1 + "," + s2).orElse("need at least two strings");
		System.out.printf("Comma-separated String: %s.%n", wordsWithCommas);

		int numberOfChars = words.stream().mapToInt(String::length).sum();
		System.out.printf("Total number of characters: %s.%n", numberOfChars);

		long numberOfWordsWithH = words.stream().filter(s -> s.contains("h")).count();
		System.out.printf("Number of words containing 'h': %s.%n", numberOfWordsWithH);
	}
}
