package cleissonheggdorne.first_crud_maven.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cleissonheggdorne.first_crud_maven.dao.LeagueDAO;
import cleissonheggdorne.first_crud_maven.entities.League;
import cleissonheggdorne.first_crud_maven.entities.PunctuationType;

public class LeagueDaoJDBC implements LeagueDAO {

	private Connection conn;
	
	public LeagueDaoJDBC (Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(League obj) {
		PreparedStatement stmt = null;
		String sql = "INSERT INTO league (name, id_punctuation_type)"
						+"VALUES(?, ?)";
		try {
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, obj.getName());
			stmt.setInt(2, obj.getPunctuationType().getId());
			
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
			//stmt.executeQuery();
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
	public void update(League obj) {
		PreparedStatement stmt = null;
		
		String sql = "UPDATE league SET name = ?, id_punctuation_type = ?"
						+"WHERE id = ?";
		try {
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, obj.getName());
			stmt.setInt(2, obj.getPunctuationType().getId());
			stmt.setInt(3, obj.getId());
			
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
		String sql = "DELETE FROM league WHERE id = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			
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
	public League findById(Integer id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT l.*, pt.name as name_punctuation_type FROM league l\r\n"
					+ "INNER JOIN punctuation_type pt on\r\n"
					+ "pt.id = l.id_punctuation_type\r\n"
					+ " WHERE l.id = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if(rs.next()) {
				PunctuationType punctuationType = instantiatePunctuationType(rs);
				League league = instantiateLeague(rs, punctuationType);
				return league;
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
	
	@Override
	public List<League> findAll() {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT l.*, pt.name as name_punctuation_type FROM league l\r\n"
				+ "INNER JOIN punctuation_type pt on\r\n"
				+ "pt.id = l.id_punctuation_type\r\n";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			List<League> list = new ArrayList<>();
			Map<Integer, PunctuationType> map = new HashMap<>();
			
			while(rs.next()) {
				PunctuationType pt = map.get(rs.getInt("id_punctuation_type"));
				
				if(pt == null) {
					pt = instantiatePunctuationType(rs);
					map.put(rs.getInt("id_punctuation_type"), pt);
				}
				
				League league = instantiateLeague(rs, pt);
				list.add(league);
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
	
	private League instantiateLeague(ResultSet rs, PunctuationType pt) throws SQLException {
		League league = new League();
		league.setId(rs.getInt("id"));
		league.setName(rs.getString("name"));
		league.setPunctuationType(pt);
		return league;
	}
	
	private PunctuationType instantiatePunctuationType(ResultSet rs) throws SQLException {
		PunctuationType punctuationType = new PunctuationType();
		punctuationType.setId(rs.getInt("id_punctuation_type"));
		punctuationType.setName(rs.getString("name"));
		return punctuationType;
	}

	
}
