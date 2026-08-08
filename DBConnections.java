package ComplaintRegistration;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnections {
	
	
		static String url = "jdbc:mysql://localhost:3306/municipal_complaint";
		
		static String username = "root";
		
		static String password = "Gokul@3003";
		
		public static Connection getConnection() {
			Connection con = null;
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url,username,password);
				System.out.println("Database Connected Successfullly!!");		

			}catch(ClassNotFoundException e) {
				System.out.println("JDBC Driver Not Found");
			}catch(Exception e) {
				System.out.println("Connection Error : " + e.getMessage());
			}
			return con;
			
		}

	}



