package PYS.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class dBConnection {

	public static Connection getConnection() {
		Connection con=null;
		
		String url="jdbc:mysql://localhost:3306/project";
		String username="root";
		String password="";
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			con=DriverManager.getConnection(url,username,password);
			System.out.println("Printing connection object" +con);
		} catch (Exception e) {
			  // TODO: handle exception
			e.printStackTrace();
		}
		return con;
	}
}
