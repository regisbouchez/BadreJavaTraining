package dao;

import java.util.List;

import model.City;

public interface CityDao {

	void delete(Long _id);

	City insert(City _City);

	City update(City _City);

	City findOneByName(String _name);

	City findOneById(Long _id);

	List<City> findAll();

	List<City> getCitiesByCountryName(String _countryName);
}
