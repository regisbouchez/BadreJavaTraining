package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Country;
import utils.HibernateUtils;

public class CountryDaoImpl implements CountryDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Country> findByCityName(String _cityName) {
		List<Country> list = null;
		try {
			em = HibernateUtils.getEmf().createEntityManager();
			String hql = "select co from Country co left join co.cities ci where ci.name like :cityName";
			TypedQuery<Country> query = em.createQuery(hql, Country.class);
			query.setParameter("cityName", _cityName);
			list = query.getResultList();
		} finally {
			em.close();
		}
		return list;
	}

	@Override
	public Country findCountryByName(String _name) {
		String hql = "select co from Country co where co.name like :name";
		TypedQuery<Country> query = em.createQuery(hql, Country.class);
		query.setParameter("name", _name);
		Country country = query.getSingleResult();
		return country;
	}

	/**
	 * Beware, this method leaves the HIbernate cache unsync with the DB, because it
	 * is a BULK delete. only 1 SQL request is sent to DB.
	 */
	@Override
	public void delete(Long _id) {
		String queryStr = "delete from " + Country.class.getName() + " as o  where o.id = :id";
		Query query = em.createQuery(queryStr);
		query.setParameter("id", _id);
		@SuppressWarnings("unused")
		int nb = query.executeUpdate();
	}

	/**
	 * More JPA like method, the cache is in sync. But 2 SQL requests are sent to DB
	 */
	public void delete2(Long _id) {
		Country c = em.find(Country.class, _id);
		em.remove(c);
	}

	@Override
	public void throwingPipoRuntime() {
		throw new RuntimeException("pipipipipi");
	}

	@Override
	public Country findOneById(Long _id) {
		return em.find(Country.class, _id);
	}

	@Override
	public Country insert(Country _country) {
		EntityTransaction tx = null;
		try {
			em = HibernateUtils.getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			em.persist(_country);
			tx.commit();
		} catch (RuntimeException ex) {
			try {
				tx.rollback();
			} catch (RuntimeException rbEx) {
			}
			throw ex;
		} finally {
			em.close();
		}
		return _country;
	}

	@Override
	public Country update(Country _country) {
		em.merge(_country);
		return _country;
	}

	@Override
	public List<Country> findAll() {
		List<Country> list = null;
		try {
			em = HibernateUtils.getEmf().createEntityManager();
			TypedQuery<Country> query = em.createQuery("select c from Country as c order by c.name", Country.class);
			list = query.getResultList();
		} finally {
			em.close();
		}
		return list;
	}

}
