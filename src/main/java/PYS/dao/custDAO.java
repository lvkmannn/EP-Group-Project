package PYS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import PYS.bean.customer;
import PYS.connection.dBConnection;

public class custDAO {
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	
	private int custid,custpostcode;
	private String custname,custphone,cust_email,custaddress,custcity,custstate,custcountry,cust_username,cust_password;
	
	public void addCust(customer bean) {
		
		custname = bean.getCustname();
		custphone = bean.getCustphone();
		cust_email = bean.getCust_email();
		custaddress = bean.getCustaddress();
		custcity = bean.getCustcity();
		custpostcode = bean.getCustpostcode();
		custstate = bean.getCuststate();
		custcountry = bean.getCustcountry();
		cust_username = bean.getCust_username();
		cust_password = bean.getCust_password();
		
		try {
			//call getConnection() method
			con=dBConnection.getConnection();
			
			//create statement
				ps = con.prepareStatement("INSERT INTO CUSTOMER (custname, custphone, cust_email, custaddress, custcity, custpostcode,custstate,custcountry,cust_username,cust_password) VALUES(?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1,custname);
				ps.setString(2, custphone);
				ps.setString(3, cust_email);
				ps.setString(4, custaddress);
				ps.setString(5, custcity);
				ps.setInt(6,  custpostcode);
				ps.setString(7, custstate);
				ps.setString(8, custcountry);
				ps.setString(9, cust_username);
				ps.setString(10, cust_password);
			//execute query
			ps.executeUpdate();
			System.out.println("Successfully Add Customer");
			
			//close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Method to list all customer
		public static List<customer>getAllCust(){
			List<customer> customers=new ArrayList<customer>();
			
			try {
				//call getConnection method
				con = dBConnection.getConnection();
				
				//create statement
				stmt = con.createStatement();
				String sql = "SELECT * FROM customer ORDER BY custid";
				
				//execute query
				rs=stmt.executeQuery(sql);
				
				while(rs.next()) {
					customer c = new customer();
					
					c.setCustid(rs.getInt("custid"));
					c.setCustname(rs.getString("custname"));
					c.setCustphone(rs.getString("custphone"));
					c.setCust_email(rs.getString("cust_email"));
					c.setCustaddress(rs.getString("custaddress"));
					c.setCustcity(rs.getString("custcity"));
					c.setCustpostcode(rs.getInt("custpostcode"));
					c.setCuststate(rs.getString("custstate"));
					c.setCustcountry(rs.getString("custcountry"));
					c.setCust_username(rs.getString("cust_username"));
					c.setCust_password(rs.getString("cust_password"));
					
					System.out.println(c.getCustid());
			
					customers.add(c);
				}
				//close connection
				con.close();
			}catch(Exception e) {
				System.out.print("Error in public static List<customer>getAllCust()");
				e.printStackTrace();
			}
			return customers;
		}
		
		//Method to delete
		public void deleteCust(int custid) {
			try {
				//call getConnection method
				con = dBConnection.getConnection();
				
				//create statement
				ps = con.prepareStatement("DELETE FROM customer WHERE custid=?");
				ps.setInt(1, custid);
				
				//execute update
				ps.executeUpdate();
				System.out.print("Successfully Delete Customer" + custid);
				//close connection
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("Error in custDAO.deleteCust()");
			}
		}
		
		//Method for updating customer
		public void updateCust(customer bean) {
			
			custid = bean.getCustid();
			custname = bean.getCustname();
			custphone = bean.getCustphone();
			cust_email = bean.getCust_email();
			custaddress = bean.getCustaddress();
			custcity = bean.getCustcity();
			custpostcode = bean.getCustpostcode();
			custstate = bean.getCuststate();
			custcountry = bean.getCustcountry();
			cust_username = bean.getCust_username();
			cust_password = bean.getCust_password();
			
			try {
				//call getConnection() method
				con = dBConnection.getConnection();
				
				//prepare statement
				ps = con.prepareStatement("UPDATE customer SET custname=?,custphone=?,cust_email=?, custaddress=?, custcity=?, custpostcode=?, custstate=?, custcountry=? WHERE custid=?");
				ps.setString(1,custname);
				ps.setString(2,custphone);
				ps.setString(3,cust_email);
				ps.setString(4,custaddress);
				ps.setString(5,custcity);
				ps.setInt(6,custpostcode);
				ps.setString(7,custstate);
				ps.setString(8,custcountry);
				ps.setInt(9, custid);
					
				//execute update
				ps.executeUpdate();
				
				//close connection
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("Error in custDAO.updateCust");
			}
		}
		
		//get customer by custid
		public static customer getCustByCustId(int custid) {
			customer c = new customer();
			
			try {
				//call getConnection() method
				con = dBConnection.getConnection();
				
				//prepare statement
				ps=con.prepareStatement("SELECT * FROM customer WHERE custid=?");
				ps.setInt(1, custid);
				
				//execute query
				rs = ps.executeQuery();
				
				if(rs.next()) {
					c.setCustid(rs.getInt("custid"));
					c.setCustname(rs.getString("custname"));
					c.setCustphone(rs.getString("custphone"));
					c.setCust_email(rs.getString("cust_email"));
					c.setCustaddress(rs.getString("custaddress"));
					c.setCustcity(rs.getString("custcity"));
					c.setCustpostcode(rs.getInt("custpostcode"));
					c.setCuststate(rs.getString("custstate"));
					c.setCustcountry(rs.getString("custcountry"));
					c.setCust_username(rs.getString("cust_username"));
					c.setCust_password(rs.getString("cust_password"));
				}
				
				//close connection
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("Error in custDAO.getCustByCustId");
			}
			return c;
		}
}
