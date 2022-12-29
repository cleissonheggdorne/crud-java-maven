package cleissonheggdorne.first_crud_maven.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Access {
	private static String databasefile = "src\\main\\java\\cleissonheggdorne\\first_crud_maven\\db\\base.db";

	public static Connection getConnection(){
		try {
			Class.forName("org.sqlite.JDBC");
			return DriverManager.getConnection("jdbc:sqlite:"+databasefile);
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Problema ao carregar o driver de conex�o!");
		}
		catch(ClassNotFoundException cnfe) {
			System.out.println("Problemas com a classe de conexão");

		}
		return null;
	}
}
