package dao;

import java.util.List;

import model.Country;

public interface CountryDao {

	void delete(Long _id);

	Country insert(Country _Country);

	Country update(Country _Country);

	void throwingPipoRuntime();

	Country findCountryByName(String _name);

	Country findOneById(Long _id);

	List<Country> findAll();

	List<Country> findByCityName(String _cityName);
}
