package PYS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import PYS.bean.customer;
import PYS.bean.staff;
import PYS.connection.dBConnection;

public class staffDAO {
	private static String sql;
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	private int staffid,staffpostcode,managerid;
	private String staffname,staffphone,staff_email,staffaddress,staffcity,staffstate,staffcountry,staff_username,staff_password;
	private double staffsalary;
	private String cust_username,cust_password;
	
	//login
	public int checkManagerID(int staffid) {
	    int managerid = 0;
	    Connection con = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;

	    try {
	        con = dBConnection.getConnection();
	        String query = "SELECT managerid FROM staff WHERE staffid=?";
	        statement = con.prepareStatement(query);
	        statement.setInt(1, staffid);
	        resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            managerid = resultSet.getInt("managerid");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.print("Error in PYSDAO, checkManagerID");
	    } finally {
	        // Close the resources
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            if (statement != null) {
	                statement.close();
	            }
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return managerid; // Return the retrieved managerid
	}

	public int authenticateStaff(staff bean) {
		staff_username=bean.getStaff_username();
		staff_password=bean.getStaff_password();
		Connection con;
		Statement statement=null;
		ResultSet resultSet = null;
		String userNameDB="";
		String passwordDB="";
		int staffidDB=0;
		try {
			con = dBConnection.getConnection();//Fetch database connection object
			statement = con.createStatement();//Statement is used to write queries.
			resultSet = statement.executeQuery("select staffid,staff_username,staff_password from staff");//the table name is login and userName,password are columns. Fetching all the records and storing in a resultSet
			
			while(resultSet.next()){//Until next row is present otherwise it return false
				userNameDB = resultSet.getString("staff_username"); //fetch the values present in database
				passwordDB = resultSet.getString("staff_password");
				staffidDB = resultSet.getInt("staffid");
				if(staff_username.equals(userNameDB) && staff_password.equals(passwordDB)) {					
					return staffidDB;//if the user entered correct values in database
				}
			}
		} catch (SQLException e) {
			  // TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
	
	public int authenticateUser(customer bean) {
		cust_username=bean.getCust_username();
		cust_password=bean.getCust_password();
		Connection con;
		Statement statement=null;
		ResultSet resultSet = null;
		String userNameDB="";
		String passwordDB="";
		int custidDB=0;
		try {
			con = dBConnection.getConnection();//Fetch database connection object
			statement = con.createStatement();//Statement is used to write queries.
			resultSet = statement.executeQuery("SELECT custid, cust_username, cust_password FROM customer");
			//resultSet = statement.executeQuery("select cust_username,cust_password from customer");//the table name is login and userName,password are columns. Fetching all the records and storing in a resultSet
//			System.out.println("name before: "+cust_username);
			
			while(resultSet.next()){//Until next row is present otherwise it return false
				userNameDB = resultSet.getString("cust_username"); //fetch the values present in database
				passwordDB = resultSet.getString("cust_password");
				custidDB = resultSet.getInt("custid");
//				System.out.println("name: "+userNameDB);
				
				if(cust_username.equals(userNameDB) && cust_password.equals(passwordDB)) {
					return custidDB;
					//return "SUCCESS";//if the user entered correct values in database
				}
			}
		} catch (SQLException e) {
			  // TODO: handle exception
			e.printStackTrace();
		}
		return 0;
		//return "Invalid user credentials";
	}


	//Method to add staff
	public void addStaff(staff bean) {
		//staffid=bean.getStaffid();
		staffname=bean.getStaffname();
		staffphone=bean.getStaffphone();
		staff_email=bean.getStaff_email();
		staffaddress=bean.getStaffaddress();
		staffcity=bean.getStaffcity();
		staffpostcode=bean.getStaffpostcode();
		staffstate=bean.getStaffstate();
		staffcountry=bean.getStaffcountry();
		staffsalary=bean.getStaffsalary();
		staff_username=bean.getStaff_username();
		staff_password=bean.getStaff_password();
		managerid=bean.getManagerid();
		
		
		
		try {
			//call getConnection() method
			con=dBConnection.getConnection();
			
			//create statement
			if(managerid==0) {
				ps = con.prepareStatement("INSERT INTO STAFF(staffname,staffphone,staff_email,staffaddress,staffcity,staffpostcode,staffstate,staffcountry,staffsalary,staff_username,staff_password,managerid) VALUES(?,?,?,?,?,?,?,?,?,?,?,null)");
				ps.setString(1,staffname);
				ps.setString(2,staffphone);
				ps.setString(3,staff_email);
				ps.setString(4,staffaddress);
				ps.setString(5,staffcity);
				ps.setInt(6,staffpostcode);
				ps.setString(7,staffstate);
				ps.setString(8,staffcountry);
				ps.setDouble(9,staffsalary);
				ps.setString(10,staff_username);
				ps.setString(11,staff_password);
			}else {
				ps = con.prepareStatement("INSERT INTO STAFF(staffname,staffphone,staff_email,staffaddress,staffcity,staffpostcode,staffstate,staffcountry,staffsalary,staff_username,staff_password,managerid) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1,staffname);
				ps.setString(2,staffphone);
				ps.setString(3,staff_email);
				ps.setString(4,staffaddress);
				ps.setString(5,staffcity);
				ps.setInt(6,staffpostcode);
				ps.setString(7,staffstate);
				ps.setString(8,staffcountry);
				ps.setDouble(9,staffsalary);
				ps.setString(10,staff_username);
				ps.setString(11,staff_password);
				ps.setInt(12,managerid);
				
				System.out.println("PYSDAO set passed");
			}
			
			
			//execute query
			ps.executeUpdate();
			System.out.println("Successfully Add Staff");
			
			//close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	//Method to list all staff
	public static List<staff>getAllStaff(){
		List<staff> staffs=new ArrayList<staff>();
		
		try {
			//call getConnection method
			con = dBConnection.getConnection();
			
			//create statement
			stmt = con.createStatement();
			String sql = "SELECT * FROM staff ORDER BY staffid";
			
			//execute query
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				staff s = new staff();
				
				s.setStaffid(rs.getInt("staffid"));
				s.setStaffname(rs.getString("staffname"));
				s.setStaffphone(rs.getString("staffphone"));
				s.setStaff_email(rs.getString("staff_email"));
				s.setStaffaddress(rs.getString("staffaddress"));
				s.setStaffcity(rs.getString("staffcity"));
				s.setStaffpostcode(rs.getInt("staffpostcode"));
				s.setStaffstate(rs.getString("staffstate"));
				s.setStaffcountry(rs.getString("staffcountry"));
				s.setStaffsalary(rs.getDouble("staffsalary"));
				s.setManagerid(rs.getInt("managerid"));
				System.out.println(s.getManagerid());
				staffs.add(s);
			}
			//close connection
			con.close();
		}catch(Exception e) {
			System.out.print("Error in public static List<Staff>getAllStaff()");
			e.printStackTrace();
		}
		return staffs;
	}
	
	public void deleteStaff(int staffid) {
		try {
			//call getConnection method
			con = dBConnection.getConnection();
			
			//create statement
			ps = con.prepareStatement("DELETE FROM staff WHERE staffid=?");
			ps.setInt(1, staffid);
			
			//execute update
			ps.executeUpdate();
			System.out.print("Successfully Delete Staff" + staffid);
			//close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in PYSDAO.deleteStaff()");
		}
	}
	
	//Method for updating staff
	public void updateStaff(staff bean) {
		staffid=bean.getStaffid();
		staffname=bean.getStaffname();
		staffphone=bean.getStaffphone();
		staff_email=bean.getStaff_email();
		staffaddress=bean.getStaffaddress();
		staffcity=bean.getStaffcity();
		staffpostcode=bean.getStaffpostcode();
		staffstate=bean.getStaffstate();
		staffcountry=bean.getStaffcountry();
		staffsalary=bean.getStaffsalary();
		staff_username=bean.getStaff_username();
		staff_password=bean.getStaff_password();
		managerid=bean.getManagerid();
		
		try {
			//call getConnection() method
			con = dBConnection.getConnection();
			
			//prepare statement
			
			if(managerid==0) {
				ps = con.prepareStatement("UPDATE staff SET staffname=?,staffphone=?,staff_email=?,staffaddress=?,staffcity=?,staffpostcode=?,staffstate=?,staffcountry=?,staffsalary=?,managerid=null WHERE staffid=?");
				ps.setString(1,staffname);
				ps.setString(2,staffphone);
				ps.setString(3,staff_email);
				ps.setString(4,staffaddress);
				ps.setString(5,staffcity);
				ps.setInt(6,staffpostcode);
				ps.setString(7,staffstate);
				ps.setString(8,staffcountry);
				ps.setDouble(9,staffsalary);
				//ps.setInt(10,managerid);
				ps.setInt(10, staffid);
			}else {
				ps = con.prepareStatement("UPDATE staff SET staffname=?,staffphone=?,staff_email=?,staffaddress=?,staffcity=?,staffpostcode=?,staffstate=?,staffcountry=?,staffsalary=?,managerid=? WHERE staffid=?");
				ps.setString(1,staffname);
				ps.setString(2,staffphone);
				ps.setString(3,staff_email);
				ps.setString(4,staffaddress);
				ps.setString(5,staffcity);
				ps.setInt(6,staffpostcode);
				ps.setString(7,staffstate);
				ps.setString(8,staffcountry);
				ps.setDouble(9,staffsalary);
				ps.setInt(10,managerid);
				ps.setInt(11, staffid);	
			}
			
			//execute update
			ps.executeUpdate();
			
			//close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in PYSDAO.updateStaff");
		}
	}
	
	public static staff getStaffByStaffId(int staffid) {
		staff s = new staff();
		
		try {
			//call getConnection() method
			con = dBConnection.getConnection();
			
			//prepare statement
			ps=con.prepareStatement("SELECT * FROM staff WHERE staffid=?");
			ps.setInt(1, staffid);
			
			//execute query
			rs = ps.executeQuery();
			
			if(rs.next()) {
				s.setStaffid(rs.getInt("staffid"));
				s.setStaffname(rs.getString("staffname"));
				s.setStaffphone(rs.getString("staffphone"));
				s.setStaff_email(rs.getString("staff_email"));
				s.setStaffaddress(rs.getString("staffaddress"));
				s.setStaffcity(rs.getString("staffcity"));
				s.setStaffpostcode(rs.getInt("staffpostcode"));
				s.setStaffstate(rs.getString("staffstate"));
				s.setStaffcountry(rs.getString("staffcountry"));
				s.setStaffsalary(rs.getDouble("staffsalary"));
				s.setStaffcountry(rs.getString("staffcountry"));
				s.setStaffsalary(rs.getDouble("staffsalary"));
				s.setStaff_username(rs.getString("staffcountry"));
				s.setStaff_password(rs.getString("staffsalary"));
				s.setManagerid(rs.getInt("managerid"));
			}
			
			//close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in PYSDAO.getStaffByStaffId");
		}
		return s;
	}
	public static List<staff> getStaffSearch(String staffname) { 
	      List<staff> staffs = new ArrayList<staff>(); 
	      try { 
	          // Call getConnection() method
	          con = dBConnection.getConnection();

	          // Prepare the SQL query with a placeholder for the searchQuery
	          sql = "SELECT * FROM staff WHERE staffname LIKE ?";

	          // Create a prepared statement with the SQL query
	          PreparedStatement pstmt = con.prepareStatement(sql);

	          // Set the searchQuery as a parameter in the prepared statement
	          pstmt.setString(1, "%" + staffname + "%"); // Use the LIKE operator to search for partial matches

	          // Execute the query
	          rs = pstmt.executeQuery();

	          while (rs.next()) {  
	              staff s = new staff();
	              s.setStaffid(rs.getInt("staffid"));
					s.setStaffname(rs.getString("staffname"));
					s.setStaffphone(rs.getString("staffphone"));
					s.setStaff_email(rs.getString("staff_email"));
					s.setStaffaddress(rs.getString("staffaddress"));
					s.setStaffcity(rs.getString("staffcity"));
					s.setStaffpostcode(rs.getInt("staffpostcode"));
					s.setStaffstate(rs.getString("staffstate"));
					s.setStaffcountry(rs.getString("staffcountry"));
					s.setStaffsalary(rs.getDouble("staffsalary"));
					s.setStaffcountry(rs.getString("staffcountry"));
					s.setStaffsalary(rs.getDouble("staffsalary"));
					s.setStaff_username(rs.getString("staffcountry"));
					s.setStaff_password(rs.getString("staffsalary"));
					s.setManagerid(rs.getInt("managerid"));

	              staffs.add(s);
	          }

	          // Close the connection and prepared statement
	          pstmt.close();
	          con.close();
	      } catch (Exception e) { 
	          e.printStackTrace(); 
	      }
	      return staffs; 
	  }
}
