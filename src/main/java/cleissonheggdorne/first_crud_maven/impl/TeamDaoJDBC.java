package cleissonheggdorne.first_crud_maven.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import org.sqlite.SQLiteException;

import cleissonheggdorne.first_crud_maven.dao.TeamDAO;
import cleissonheggdorne.first_crud_maven.entities.Team;

public class TeamDaoJDBC implements TeamDAO{
	
	private Connection conn;
	
	public TeamDaoJDBC (Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Team obj) {
		PreparedStatement stmt = null;
		String sql = "INSERT INTO team (name)"
						+"VALUES(?)";
		try {
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, obj.getName());
			/*
			 * Implementar  Insert de Imagem
			 * 			 
			 */
			//stmt.setInt(2, obj.getImage());
			
			int rowsAffected = stmt.executeUpdate();
			if(rowsAffected > 0) {
				ResultSet rs = stmt.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				rs.close();

			}else {
				System.out.println("Sem linhas afetadas");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				System.out.println(e);
			}
		}
		
	}

	@Override
	public void update(Team obj) {
		PreparedStatement stmt = null;
		/*
		 * Implementar imagem
		 */
		String sql = "UPDATE team SET name = ?"
						+"WHERE id = ?";
		try {
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, obj.getName());
			stmt.setInt(2, obj.getId());
			/*
			 * Implementar  Insert de Imagem
			 * 			 
			 */
			//stmt.setInt(2, obj.getImage());
			
			int rowsAffected = stmt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				System.out.println(e);
			}
		}
		
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement stmt = null;
		String sql = "DELETE FROM team WHERE id = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			/*
			 * Implementar  Insert de Imagem
			 * 			 
			 */
			//stmt.setInt(2, obj.getImage());
			
			stmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				System.out.println(e);
			}
		}
		
	}

	@Override
	public Team findById(Integer id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM team WHERE id = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if(rs.next()) {
				Team team = instantiateTeam(rs);
				return team;
			}
			return null;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				System.out.println(e);
			}
		}
		return null;
	}

	private Team instantiateTeam(ResultSet rs) throws SQLException {
		Team team = new Team();
		team.setId(rs.getInt("id"));
		team.setName(rs.getString("name"));
		return team;
	}

	@Override
	public List<Team> findAll() {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM team ORDER by name";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			List<Team> list = new ArrayList<>();
			
			while(rs.next()) {
				Team team = instantiateTeam(rs);
				list.add(team);
			}
			return list;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				System.out.println(e);
			}
		}
		return null;
	}

}
