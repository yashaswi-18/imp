package day4.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtilsCourse {

	public static Connection buildConnection() throws Exception{
		String driverClassName = "com.mysql.cj.jdbc.Driver";
		
			Class.forName(driverClassName);
			
			
			
			//2.Establish connection 
			String connectionUrl="jdbc:mysql://localhost:3306/db?useSSL=false";
			String userId="root";
			String password="password";
			
			
			Connection dbConnection=DriverManager.getConnection(connectionUrl,userId,password);
			return dbConnection;
	}

}
