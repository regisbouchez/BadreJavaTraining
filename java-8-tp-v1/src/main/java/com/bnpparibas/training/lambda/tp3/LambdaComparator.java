package com.bnpparibas.training.lambda.tp3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaComparator {

	public static void main(String[] args) {
		Person[] personsArray = { new Person("jeff", 42), new Person("jack", 22), new Person("jimm", 32) };
		List<Person> persons = Arrays.asList(personsArray);
		persons.sort(new Comparator<Person>() {
			public int compare(Person p1, Person p2) {
				return p1.getAge() - p2.getAge();
			}
		});
		persons.forEach(System.out::println);
	}
}
