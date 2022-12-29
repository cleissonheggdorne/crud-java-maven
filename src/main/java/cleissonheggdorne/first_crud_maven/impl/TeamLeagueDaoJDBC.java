package cleissonheggdorne.first_crud_maven.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import cleissonheggdorne.first_crud_maven.dao.TeamLeagueDAO;
import cleissonheggdorne.first_crud_maven.entities.TeamLeague;

public class TeamLeagueDaoJDBC implements TeamLeagueDAO {
	
	private Connection conn;
	
	public TeamLeagueDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	@Override
	public void insert(TeamLeague obj) {
		PreparedStatement stmt = null;
		String sql = "INSERT INTO team_league (id_team, id_league)"
						+"VALUES(?, ?)";
		try {
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, obj.getTeam().getId());
			stmt.setInt(2, obj.getLeague().getId());
			
			int rowsAffected = stmt.executeUpdate();
			if(rowsAffected > 0) {
				ResultSet rs = stmt.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					
				}
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void update(TeamLeague obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TeamLeague findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TeamLeague> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
