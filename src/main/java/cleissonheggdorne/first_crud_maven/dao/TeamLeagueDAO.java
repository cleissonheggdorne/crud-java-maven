package cleissonheggdorne.first_crud_maven.dao;

import java.util.List;

import cleissonheggdorne.first_crud_maven.entities.TeamLeague;

public interface TeamLeagueDAO {
	void insert(TeamLeague obj);
	void update(TeamLeague obj);
	void deleteById(Integer id);
	TeamLeague findById(Integer id);
	List<TeamLeague> findAll();
}
