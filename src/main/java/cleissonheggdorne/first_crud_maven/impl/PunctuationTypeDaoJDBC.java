package cleissonheggdorne.first_crud_maven.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cleissonheggdorne.first_crud_maven.dao.PunctuationTypeDAO;
import cleissonheggdorne.first_crud_maven.entities.PunctuationType;

public class PunctuationTypeDaoJDBC implements PunctuationTypeDAO {

	private Connection conn;
	
	public PunctuationTypeDaoJDBC (Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(PunctuationType obj) {
		PreparedStatement stmt = null;
		String sql = "INSERT INTO punctuation_type (name)"
						+"VALUES(?)";
		try {
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, obj.getName());
			
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
	public void update(PunctuationType obj) {
		PreparedStatement stmt = null;
		String sql = "UPDATE punctuation_type SET name = ?"
						+"WHERE id = ?";
		try {
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, obj.getName());
			stmt.setInt(2, obj.getId());
			
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
		String sql = "DELETE FROM punctuation_type WHERE id = ?";
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
	public PunctuationType findById(Integer id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM punctuation_type WHERE id = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if(rs.next()) {
				PunctuationType punctuationType = instantiatePunctuationType(rs);
				return punctuationType;
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

	private PunctuationType instantiatePunctuationType(ResultSet rs) throws SQLException {
		PunctuationType punctuationType = new PunctuationType();
		punctuationType.setId(rs.getInt("id"));
		punctuationType.setName(rs.getString("name"));
		return punctuationType;
	}
	
	@Override
	public List<PunctuationType> findAll() {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM punctuation_type ORDER by name";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			List<PunctuationType> list = new ArrayList<>();
			
			while(rs.next()) {
				PunctuationType punctuationType = instantiatePunctuationType(rs);
				list.add(punctuationType);
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
