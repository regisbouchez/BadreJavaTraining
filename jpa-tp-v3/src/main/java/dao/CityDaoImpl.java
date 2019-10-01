package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.City;
import utils.HibernateUtils;

public class CityDaoImpl implements CityDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<City> getCitiesByCountryName(String _countryName) {
		EntityTransaction tx = null;
		List<City> list = null;
		try {
			em = HibernateUtils.getEmf().createEntityManager();
			String hql = "select ci from City as ci left join ci.country country "
					+ "where country.name  = :countryName";
			TypedQuery<City> query = em.createQuery(hql, City.class);
			query.setParameter("countryName", _countryName);
			list = query.getResultList();
		} finally {
			em.close();
		}
		return list;
	}

	@Override
	public City findOneByName(String _name) {
		String hql = "select city from City city where city.name like :name";
		TypedQuery<City> query = em.createQuery(hql, City.class);
		query.setParameter("name", _name);
		City City = query.getSingleResult();
		return City;
	}

	/**
	 * Beware, this method leaves the HIbernate cache unsync with the DB, because it
	 * is a BULK delete. only 1 SQL request is sent to DB
	 */
	@Override
	public void delete(Long _id) {
		String queryStr = "delete from " + City.class.getName() + " as o  where o.id = :id";
		Query query = em.createQuery(queryStr);
		query.setParameter("id", _id);
		@SuppressWarnings("unused")
		int nb = query.executeUpdate();
	}

	/**
	 * More JPA like method, the cache is in sync. But 2 SQL requests are sent to DB
	 */
	public void delete2(Long _id) {
		City c = em.find(City.class, _id);
		em.remove(c);
	}

	@Override
	public City findOneById(Long _id) {
		return em.find(City.class, _id);
	}

	@Override
	public City insert(City _City) {
		EntityTransaction tx = null;
		try {
			em = HibernateUtils.getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			em.persist(_City);
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
		return _City;
	}

	@Override
	public City update(City _City) {
		em.merge(_City);
		return _City;
	}

	@Override
	public List<City> findAll() {
		TypedQuery<City> query = em.createQuery("select c from City as c order by c.City", City.class);
		List<City> l = query.getResultList();
		java.sql.Connection connection = em.unwrap(java.sql.Connection.class);
		System.out.println(connection);
		return l;
	}

}
