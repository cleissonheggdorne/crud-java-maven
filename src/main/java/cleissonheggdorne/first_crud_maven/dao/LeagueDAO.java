package cleissonheggdorne.first_crud_maven.dao;

import java.util.List;

import cleissonheggdorne.first_crud_maven.entities.League;

public interface LeagueDAO {
	void insert(League obj);
	void update(League obj);
	void deleteById(Integer id);
	League findById(Integer id);
	List<League> findAll();
}
