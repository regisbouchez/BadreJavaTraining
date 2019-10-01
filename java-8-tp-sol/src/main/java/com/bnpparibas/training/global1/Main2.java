package com.bnpparibas.training.global1;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main2 {

	public static void main(String[] args) throws IOException {
		List<Etudiant> promo = PromotionFactory.getEtudiants();
		// question1(promo);
		// question2(promo);
		// question3(promo);
		// question4(promo);
		// question5(promo);
		// question6(promo);
		// question7(promo);
		// question8(promo);
		// question9(promo);
		question10(promo);
	}

	private static void question1(List<Etudiant> promo) {
		Stream<Etudiant> stream = promo.stream();
		List<Etudiant> etudiants = stream.filter(e -> e.getNom().startsWith("S")).collect(Collectors.toList());
		etudiants.forEach(System.out::println);

	}

	private static void question2(List<Etudiant> promo) {
		promo.sort((p1, p2) -> Double.compare(p1.getMoyenne(), p2.getMoyenne()));
		promo.forEach(System.out::println);
	}

	private static void question3(List<Etudiant> promo) {
		Stream<Etudiant> stream = promo.stream();
		List<Etudiant> etudiants = stream.filter(e -> e.getMoyenne() > 10).collect(Collectors.toList());
		etudiants.forEach(System.out::println);
	}

	private static void question4(List<Etudiant> promo) {
		Stream<Etudiant> stream = promo.stream();
		List<String> etudiants = stream.filter(e -> e.getMoyenne() > 10).map(e -> e.getNom())
				.collect(Collectors.toList());
		etudiants.forEach(System.out::println);
	}

	private static void question5(List<Etudiant> promo) {
		Stream<Etudiant> stream = promo.stream();
		String s = stream.filter(e -> e.getMoyenne() > 10).map(e -> e.getNom()).collect(Collectors.joining(","));
		System.out.println(s);
	}

	private static void question6(List<Etudiant> promo) {
		double total = promo.stream().mapToDouble(Etudiant::getMoyenne).summaryStatistics().getAverage();
		System.out.println(total);
		total = promo.stream().mapToDouble(Etudiant::getMoyenne).sum();
		System.out.println(total / promo.size());
		total = promo.stream().map(Etudiant::getMoyenne).reduce(0d, Double::sum);
		System.out.println(total / promo.size());
	}

	private static void question7(List<Etudiant> promo) throws IOException {
		Path homePath = Paths.get("..");
		Files.find(homePath, Integer.MAX_VALUE, (path, attr) -> path.toString().endsWith(".java"))
				.forEach(p -> System.out.println(p));
	}

	private static void question8(List<Etudiant> promo) throws IOException {
		Path path = Paths.get("D:\\Interne\\mytraining\\Java8\\workspace\\java-8-demo\\.classpath");
		Files.lines(path).filter(l -> l.contains("JRE")).forEach(System.out::println);
	}

	private static void question9(List<Etudiant> promo) {
		Map<String, List<Etudiant>> m = promo.stream().collect(Collectors.groupingBy(Etudiant::getPromo));
		System.out.println(m);
	}

	private static void question10(List<Etudiant> promo) throws IOException {
		Path path = Paths.get("D:\\Interne\\mytraining\\Java8\\workspace");
		List<String> l = Files.walk(path, Integer.MAX_VALUE).filter(p -> p.getFileName().toString().endsWith(".java"))
				.flatMap(Main2::simpleLines).filter(s -> s.contains("demo")).collect(Collectors.toList());
	}

	private static Stream<String> simpleLines(Path p) {
		try {
			return Files.lines(p, Charset.defaultCharset());
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}
}
