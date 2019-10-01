package com.bnpparibas.training.global1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) throws IOException {
		List<Etudiant> promo = PromotionFactory.getEtudiants();

		// question1(promo);
		// question2(promo);
		// question3(promo);
		// question4(promo);
		// question5(promo);
		question6(promo);
		// question7();
		// question8(Paths.get("src", "main", "java", "fr", "ib", "training",
		// "global1", "Main.java"), "java");
		// question9(promo);
		// question10(Paths.get("."), "main(");
		// étudiants dont le nom commence par s:
		// q1= promo.stream().filter(predicate)
	}

	public static void affiche(int numQuestion, Collection<?> p) {
		java.text.NumberFormat format = NumberFormat.getNumberInstance();
		format.setParseIntegerOnly(true);
		format.setMaximumIntegerDigits(2);
		System.out.println("******" + format.format(numQuestion) + "******");
		p.stream().forEach(System.out::println);
		System.out.println("******" + "**" + "******");
		// autre solution pour formater le nombre: utiliser String.format...
	}

	/**
	 * liste des étudiants dont le nom commence par N :
	 *
	 * @param promo
	 */
	public static void question1(List<Etudiant> promo) {
		//
		List<Etudiant> l = promo.stream().filter((e) -> e.getNom().startsWith("S")).collect(Collectors.toList());
		affiche(1, l);
	}

	public static void question2(List<Etudiant> promo) {

		// Version 1: utilisation de lambda expression.
		// On attend deux étudiants en paramètre.
		// Noter que les accolades autour du if sont nécessaires.
		// (parce que if est une instruction et pas une expression).
		List<Etudiant> l = promo.stream().sorted((e1, e2) -> {
			if (e1.getMoyenne() > e2.getMoyenne()) {
				return 1;
			} else if (e1.getMoyenne() < e2.getMoyenne()) {
				return -1;
			} else {
				return 0;
			}
		}).collect(Collectors.toList());
		affiche(2, l);

		// Version 2 : comme le code ci-dessus est un peu répétitif,
		// Comparator fournit une méthode statique qui permet de construire
		// facilement un comparateur qui utilise la valeur d'un champ donné
		// d'un objet.
		l = promo.stream().sorted(Comparator.comparing((e) -> e.getMoyenne())).collect(Collectors.toList());
		affiche(2, l);

		// Version 2 bis:
		// même chose, mais en utilisant :: au lieu de -> :
		l = promo.stream().sorted(Comparator.comparing(Etudiant::getMoyenne)).collect(Collectors.toList());
		affiche(2, l);

		l = promo.stream().sorted(Comparator.comparing((Etudiant e) -> e.getMoyenne()).thenComparing(e -> e.getNom()))
				.collect(Collectors.toList());
		affiche(2, l);

		// Petit aparté : si on veux trier
		// d'abord sur la moyenne
		// puis, à moyenne égale, par nom
		// on peut utiliser la méthode thenComparing() qui
		// permet d'ajouter un niveau de comparaison supplémentaire
		// au comparateur.
		l = promo.stream().sorted(Comparator.comparing((Etudiant e) -> e.getMoyenne()).thenComparing(e -> e.getNom()))
				.collect(Collectors.toList());
		affiche(2, l);

		// remarque un peu technique:
		// dans l'exemple précédent, on a déclaré le type de e dans
		// (Etudiant e) -> e.getMoyenne())
		// la raison est que si on ne déclare pas le type comme "Etudiant" au
		// niveau de comparing(...), quand on arrive à
		// .thenComparing(...), le compilateur a "oublié" que la comparaison
		// portait sur des etudiants, et ne voit plus que le type "object".
	}

	/**
	 * Les étudiants qui ont la moyenne.
	 *
	 * @param promo
	 */
	private static void question3(List<Etudiant> promo) {
		List<Etudiant> l = promo.stream().filter(e -> e.getMoyenne() >= 10.0).collect(Collectors.toList());
		affiche(3, l);
	}

	/**
	 * Le nom des étudiants qui ont la moyenne (comme ensemble).
	 *
	 * @param promo
	 */
	private static void question4(List<Etudiant> promo) {
		Set<String> l = promo.stream().filter(e -> e.getMoyenne() >= 10.0) // on
																			// filtre
				.map(e -> e.getNom()) // puis on ne garde que les noms.
				.collect(Collectors.toSet()); // on combine sous forme
												// d'ensemble.
		affiche(4, l);
	}

	// retourne le nom de tous les étudiants qui ont la moyenne,
	// sous forme d’une String où les noms sont séparés par des
	// virgules (regardez la classe Collectors) ;
	private static void question5(List<Etudiant> promo) {
		String s = promo.stream().filter(e -> e.getMoyenne() >= 10.0) // on
																		// filtre
				.map(e -> e.getNom()) // puis on ne garde que les noms.
				.collect(Collectors.joining(", ")); // on combine sous forme
													// d'ensemble.
		System.out.println("*******");
		System.out.println("Question 5");
		System.out.println(s);
	}

	/**
	 * Moyenne générale
	 *
	 * @param promo
	 */
	private static void question6(List<Etudiant> promo) {
		System.out.println("*********** Question 6 *************");
		// à la main:
		double total = promo.stream().mapToDouble(Etudiant::getMoyenne) // on
																		// récupère
																		// uniquement
																		// les
																		// notes
				.sum();
		double nb = promo.size();
		System.out.println("Moyenne " + (total / nb));
		// Version directe
		double m = promo.stream().mapToDouble(Etudiant::getMoyenne) // on
																	// récupère
																	// uniquement
																	// les notes
				.summaryStatistics() // on calcule les stats correspondantes
				.getAverage(); // On est intéressé par la moyenne
		System.out.println("Moyenne " + m);

		System.out.println("************************************");

	}

	// Note interessante à propos de cette question:
	// Si votre compte contient beaucoup de fichiers, comme le mien,
	// vous pourrez remarquer l'intérêt des stream : la chaîne entière de
	// traitement est effectuée au fur et à mesure (alors qu'on les a
	// spécifié
	// séparément).
	// On ne calcule PAS d'abord TOUS les path, avant de les filtrer,
	// puis de les imprimer. Les traitement se font au fur et à mesure
	// du parcours.
	private static void question7() throws IOException {
		String home = System.getProperty("user.home");
		Path homePath = Paths.get(home);
		// find visite récursivement les fichiers sous homePath
		// en filtrant ceux pour qui la lambda renvoie true.
		Files.find(homePath, Integer.MAX_VALUE, (path, attr) -> path.toString().endsWith(".java")) // On
																									// a
																									// un
																									// stream
																									// de
																									// path,
																									// on
																									// les
																									// imprime
				.forEach(p -> System.out.println(p));
	}

	/**
	 * en utilisant la méthode lines() de Files, listez toutes les lignes
	 * d’un fichier qui contiennent un mot donné.
	 */
	private static void question8(Path path, String mot) throws IOException {
		System.out.println("************************* 08 *************************");
		Files.lines(path).filter(l -> l.contains(mot)).forEach(System.out::println);
		System.out.println("******************************************************");

	}

	private static void question9(List<Etudiant> promo) {
		Map<String, List<Etudiant>> m = promo.stream().collect(Collectors.groupingBy(Etudiant::getPromo));
		System.out.println("************************* 09 *************************");
		System.out.println(m);
		System.out.println("******************************************************");

	}

	// listez toutes les lignes des fichiers java dans une arborescence
	// qui contiennent un mot donné.
	// Regardez les méthodes filter, flatmap et Files.walk
	private static void question10(Path racine, String chaine) throws IOException {
		// On parcours les fichiers avec walk ;
		// on filtre les fichiers avec filter
		// ensuite: plus complexe :
		// le contenu d'UN fichier est un stream de lignes.
		// On a donc en théorie un stream de stream de lignes
		// mais ce qu'on voudrait, c'est UN stream avec
		// toutes les lignes de tous les fichiers.
		//
		// flatmap fait exactement cela: il crée et concatène
		// les streams pour
		// en former un seul.
		//
		// on filtre ensuite...
		// et c'est fini.
		//
		// dernier détail technique:
		// dans la fonction passée à flatmap, Files.lines
		// peut éventuellement lever une IOException.
		// mais flatmap n'admet pas les exceptions:
		// du coup, soit on doit écrire une lambda très laide avec un
		// try...catch dedans, soit on écrit une fonction "normale",
		// avec son try...catch plus lisible, et on l'appelle.
		// simpleLines n'a pas d'exception déclarées, ce qui est bien.
		List<String> l = Files.walk(racine, Integer.MAX_VALUE).filter(p -> p.getFileName().toString().endsWith(".java"))
				.flatMap(Main::simpleLines).filter(s -> s.contains(chaine)).collect(Collectors.toList());
		affiche(10, l);
	}

	private static Stream<String> simpleLines(Path p) {
		try {
			return Files.lines(p);
		} catch (IOException ex) {
			// Notez le système pour transformer une exception
			// déclarée en exception non déclarée.
			throw new RuntimeException(ex);
		}
	}

}
