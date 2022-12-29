package cleissonheggdorne.first_crud_maven.dao;

import cleissonheggdorne.first_crud_maven.db.Access;
import cleissonheggdorne.first_crud_maven.impl.LeagueDaoJDBC;
import cleissonheggdorne.first_crud_maven.impl.PunctuationTypeDaoJDBC;
import cleissonheggdorne.first_crud_maven.impl.TeamDaoJDBC;

public class DAOFactory{
	public static TeamDAO createTeamDao() {
		return new TeamDaoJDBC(Access.getConnection());
	}
	
	public static LeagueDAO createLeagueDao() {
		return new LeagueDaoJDBC(Access.getConnection());
	}
	
	public static PunctuationTypeDAO createPunctuationTypeDao() {
		return new PunctuationTypeDaoJDBC(Access.getConnection());
	}

}
