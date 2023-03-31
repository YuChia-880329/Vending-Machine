package util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class OracleDBUtil {

	private static DataSource source = null;
	private static Connection connection = null;
	
	
	private static DataSource getSource() {
		
		try {
			
			Context ctx = new InitialContext();
			return (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException ex) {
			
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public static Connection getConnection() {
		
		if(connection == null) {
			
			if(source == null)
				source = getSource();
			
			try {
				
				connection = source.getConnection();
			} catch (SQLException ex) {
				
				ex.printStackTrace();
				throw new RuntimeException();
			}
		}else {
			
			try {
				
				if(connection.isClosed()) {
					
					connection = source.getConnection();
				}else if(!connection.isValid(3)) {
					
					connection.close();
					connection = source.getConnection();
				}
			} catch (SQLException ex) {
				
				ex.printStackTrace();
				throw new RuntimeException();
			}
			
		}
			
		
		return connection;
	}
}
