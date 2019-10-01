
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Country;

public class Main {

	private static EntityManagerFactory emf;
	static {
		emf = Persistence.createEntityManagerFactory("minibaseUnit");
	}

	public static EntityManagerFactory getEmf() {
		return emf;
	}

	public static void main(String[] args) throws Exception {
		createCountry();
	}

	public static void createCountry() throws Exception {
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			Country fr = new Country("France3");
			em.persist(fr);
			Country fr2 = new Country("France2");
			em.persist(fr2);
			//
			// TypedQuery<Country> query =
			// em.createQuery("select c from Country as c where c.name = :countryName",
			// Country.class);
			// Country france = query.setParameter("countryName",
			// "France2").getSingleResult();
			// france.setName("fr");
			tx.commit();
		} catch (RuntimeException ex) {
			try {
				tx.rollback();
			} catch (RuntimeException rbEx) {
			}
			throw ex;
		} finally {
			em.close();
			emf.close();
		}
	}
}
