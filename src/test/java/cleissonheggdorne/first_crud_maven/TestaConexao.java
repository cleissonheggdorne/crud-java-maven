package cleissonheggdorne.first_crud_maven;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import cleissonheggdorne.first_crud_maven.controller.ControllerLeague;
import cleissonheggdorne.first_crud_maven.controller.ControllerTeam;
import cleissonheggdorne.first_crud_maven.dao.DAOFactory;
import cleissonheggdorne.first_crud_maven.dao.LeagueDAO;
import cleissonheggdorne.first_crud_maven.dao.PunctuationTypeDAO;
import cleissonheggdorne.first_crud_maven.dao.TeamDAO;
import cleissonheggdorne.first_crud_maven.entities.League;
import cleissonheggdorne.first_crud_maven.entities.PunctuationType;
import cleissonheggdorne.first_crud_maven.entities.Team;


public class TestaConexao {
	public static void main(String[] args) throws SQLException{
		
		
		System.out.println("\n++++++Teste insert equipe ++++++");
		Team team1 = new Team(null, "Camperinos");
		TeamDAO teamDao1 = DAOFactory.createTeamDao();
		teamDao1.insert(team1);
		System.out.println("Inser��o efetuada com sucesso: " + team1);
		
		System.out.println("\n++++++Teste UPDATE equipe ++++++");
		team1.setName("Camperinos 2");
		TeamDAO teamDao2 = DAOFactory.createTeamDao();
		teamDao2.update(team1);
		System.out.println("Atualização efetuada com sucesso: " + team1);
		
		
		System.out.println("++++++Teste findby id equipe ++++++");
		TeamDAO teamDao = DAOFactory.createTeamDao();
		Team team = teamDao.findById(1);
		System.out.println(team);
		
		System.out.println("\n++++++Teste findAll equipe ++++++");
		TeamDAO teamDaoo = DAOFactory.createTeamDao();

		List<Team> list = teamDaoo.findAll();
		for(Team t : list) {
			System.out.println(t);
		}
		
		System.out.println("\n+++++ Teste DELETE TEAM +++++++");
		TeamDAO teamDaodelete = DAOFactory.createTeamDao();
		int id = 3;
		teamDaodelete.deleteById(id);
			
		System.out.println("\n++++++Teste findby id league ++++++");
		LeagueDAO leagueDao = DAOFactory.createLeagueDao();
		League league = leagueDao.findById(1);
		System.out.println(league);
		
		System.out.println("\n++++++Teste findAll league ++++++");
		LeagueDAO leagueDao2 = DAOFactory.createLeagueDao();
		List<League> list1 = leagueDao2.findAll();
		for(League l : list1) {
			System.out.println(l);
		}
		
		System.out.println("\n+++++ Teste DELETE League +++++++");
		LeagueDAO leagueDaoDelete = DAOFactory.createLeagueDao();
		int idDelete = 3;
		leagueDaoDelete.deleteById(idDelete);
		
		System.out.println("\n++++++Teste findby id punctuationType ++++++");
		PunctuationTypeDAO punctuationTypeDao = DAOFactory.createPunctuationTypeDao();
		PunctuationType punctuationType = punctuationTypeDao.findById(1);
		
		System.out.println("\n++++++Teste insert league ++++++");
		League league1 = new League(null, "Liga teste", punctuationType);
		LeagueDAO leagueDao3 = DAOFactory.createLeagueDao();
		leagueDao3.insert(league1);
		System.out.println("Inser��o efetuada com sucesso: " + league1);
		
		System.out.println("\n++++++Teste UPDATE league ++++++");
		league1.setName("Camperinos 2");
		LeagueDAO leagueDaoUpdate = DAOFactory.createLeagueDao();
		leagueDaoUpdate.update(league1);
		System.out.println("Atualização efetuada com sucesso: " + league1);
		
		System.out.println(punctuationType);
		
		System.out.println("\n++++++Teste findAll punctuationType ++++++");
		PunctuationTypeDAO punctuationTypeDao1 = DAOFactory.createPunctuationTypeDao();
		List<PunctuationType> list2 = punctuationTypeDao1.findAll();
		for(PunctuationType l : list2) {
			System.out.println(l);
		}
		
	}

}

