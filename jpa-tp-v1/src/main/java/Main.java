
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Country;

public class Main {

	private SessionFactory factory;

	public static void main(String[] args) throws Exception {
		final Main test = new Main();
		Configuration cfg = new Configuration().configure("hibernate-pagila.cfg.xml");
		cfg.setProperty("show_sql", "true");
		test.factory = cfg.buildSessionFactory();
		test.createCountry();
		test.factory.close();
	}

	public void createCountry() throws Exception {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Country fr = new Country(1, "France");
			session.save(fr);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
			factory.close();
		}
	}
}
