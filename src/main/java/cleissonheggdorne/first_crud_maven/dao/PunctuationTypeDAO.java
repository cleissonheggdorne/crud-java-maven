package cleissonheggdorne.first_crud_maven.dao;

import java.util.List;

import cleissonheggdorne.first_crud_maven.entities.PunctuationType;

public interface PunctuationTypeDAO {
	void insert(PunctuationType obj);
	void update(PunctuationType obj);
	void deleteById(Integer id);
	PunctuationType findById(Integer id);
	List<PunctuationType> findAll();
}
