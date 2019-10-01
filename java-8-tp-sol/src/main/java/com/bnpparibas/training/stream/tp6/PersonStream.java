package com.bnpparibas.training.stream.tp6;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonStream {

	public static void main(String[] args) {
		List<String> colors = Arrays.asList("Red", "Black", "Orange", "Green", "Blue", "Pink");
		Stream<String> colorsStream = colors.stream();
		Predicate<String> startsWithB = x -> x.length() >= 4;
		Stream<String> filteredStream = colorsStream.filter(startsWithB);
		List<String> listOfB = filteredStream.collect(Collectors.toList());
		// System.out.println(listOfB);

		// listOfB = colors.stream().filter(x ->
		// x.startsWith("B")).collect(Collectors.toList());

		List<Person> persons = Arrays.asList(new Person("Brian", 22), new Person("Jeff", 20), new Person("Jimmy", 40));
		Stream<Person> personStream = persons.stream();
		Function<Person, String> mapPersonToName = p -> p.getName();
		Stream<String> personNames = personStream.map(mapPersonToName);
		personNames.forEach(System.out::println);
		
		
		List<Person> collect = persons.stream().filter(p -> p.getName().equals("Jeff")).collect(Collectors.toList());
		// collect.forEach(System.out::println);

//		OptionalInt max = persons.stream().mapToInt(p -> p.getAge()).reduce(Integer::max);
//		System.out.println(max);

		Map<Integer, String> map = persons.stream().collect(Collectors.toMap(Person::getAge, Person::getName));
		map.forEach((x, y) -> System.out.println("Key: " + x + ", value: " + y));
	}

}