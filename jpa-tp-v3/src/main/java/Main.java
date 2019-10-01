
import java.util.List;

import dao.CityDao;
import dao.CityDaoImpl;
import dao.CountryDao;
import dao.CountryDaoImpl;
import model.City;
import model.Country;
import utils.HibernateUtils;

public class Main {

	public static void main(String[] args) throws Exception {
		try {
			CountryDao dao = new CountryDaoImpl();
			Country _country = new Country("France555");
			// dao.insert(_country);
			List<Country> list = dao.findAll();
			System.out.println(list.size());
			City c = new City("test1");
			c.setCountry(_country);
			City c2 = new City("test1");
			CityDao citydao = new CityDaoImpl();
			c = citydao.insert(c);
			c2.setCountry(c.getCountry());
			// citydao.insert(c2);
			System.out.println("fini");
			List<City> cities = citydao.getCitiesByCountryName("France");
			System.out.println(cities.size());
		} finally {
			HibernateUtils.getEmf().close();
		}

	}
}
