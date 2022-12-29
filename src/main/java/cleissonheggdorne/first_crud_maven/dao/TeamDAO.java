package cleissonheggdorne.first_crud_maven.dao;

import java.util.List;

import cleissonheggdorne.first_crud_maven.entities.Team;

public interface TeamDAO {
	void insert(Team obj);
	void update(Team obj);
	void deleteById(Integer id);
	Team findById(Integer id);
	List<Team> findAll();
	
}
