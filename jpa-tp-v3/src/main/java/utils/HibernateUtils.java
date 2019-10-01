package utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtils {

	private static EntityManagerFactory emf;
	static {
		emf = Persistence.createEntityManagerFactory("minibaseUnit");
	}

	public static EntityManagerFactory getEmf() {
		return emf;
	}

}
