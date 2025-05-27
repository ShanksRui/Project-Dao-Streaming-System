package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Db {

	private static Connection con;
	
	public static Connection getConnection() {
		try {
			if(con == null) {
				Properties properties = loadProperties();
				String url = properties.getProperty("dburl");
			    return con = DriverManager.getConnection(url,properties);	
			}
		return con;	
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	public static Properties loadProperties() {
	try(FileInputStream file = new FileInputStream("config.properties")){
		Properties prop = new Properties();
		prop.load(file);
		return prop;
		
	}catch (IOException e) {
		throw new DbException(e.getMessage());
	}
}
	public static void closeConnection() {
		try {
		if (con != null) {
			con.close();
			con = null;
		}
	}catch (SQLException e) {
		throw new DbException(e.getMessage());
	}
}	
	public static void closePrepareStatement(PreparedStatement ps) {
		try {
		if (ps != null) {
			ps.close();
		}
	}catch (SQLException e) {
		throw new DbException(e.getMessage());
	}
}	
	public static void closeResultSet(ResultSet rs) {
		try {
		if (rs!= null) {
			rs.close();
		}
	}catch (SQLException e) {
		throw new DbException(e.getMessage());
	}
}	
 }
