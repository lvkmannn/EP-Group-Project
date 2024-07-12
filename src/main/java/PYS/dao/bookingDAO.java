package PYS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import PYS.bean.TotalCustomerPerMonthChart;
import PYS.bean.TotalCustomerPerPackageChart;
import PYS.bean.TotalSalesPerMonthChart;
import PYS.bean.booking;
import PYS.connection.dBConnection;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class bookingDAO {
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	
	private int booking_id;
	private Date booking_date;
	private String booking_status;
	private int staffid;
	private int custid;
	private String packageid;
	private int qtypeople;
	
	//TODO addBooking
	public void addBooking(booking bean, HttpServletRequest request, HttpServletResponse response) {
	    booking_id = bean.getBooking_id();
	    booking_date = bean.getBooking_date();
	    booking_status = bean.getBooking_status();
	    staffid = bean.getStaffid();
	    custid = bean.getCustid();
	    packageid = bean.getPackageid();
	    qtypeople = bean.getQtypeople();

	    try {
	        // call getConnection() method
	        con = dBConnection.getConnection();

	        // prepare statement
	        // values staffid=8 (will be default value, then the staff will assign)
	        ps = con.prepareStatement("INSERT INTO booking(booking_date, booking_status, packageid, qtypeople, staffid, custid) VALUES(?, 'BOOKED', ?, ?, 8, ?)", Statement.RETURN_GENERATED_KEYS);
	        ps.setObject(1, booking_date);
	        ps.setString(2, packageid);
	        ps.setInt(3, qtypeople);
	        ps.setInt(4, custid);

	        // execute query
	        int affectedRows = ps.executeUpdate();

	        if (affectedRows == 1) {
	            // Retrieve the generated booking ID
	            ResultSet generatedKeys = ps.getGeneratedKeys();
	            if (generatedKeys.next()) {
	                booking_id = generatedKeys.getInt(1);
	             // Set the booking ID as a session attribute
	                HttpSession session = request.getSession();
	                session.setAttribute("bookingId", booking_id);
	                System.out.println("Successfully Add Booking with ID: " + booking_id);
	            }
	        }

	        // close connection
	        con.close();

	    } catch (Exception e) {
	        System.out.println("Error in bookingDAO.addBooking");
	        e.printStackTrace();
	    }
	}

	
	//Method deleteBooking
	public void deleteBooking(int booking_id) {
		try {
			//call getConnection() method
			con=dBConnection.getConnection();
					
			//prepare statement
			ps=con.prepareStatement("DELETE FROM booking WHERE booking_id");
			ps.setInt(1, booking_id);
					
			//execute update
			ps.executeUpdate();
			System.out.println("Successfully Delete Booking");
					
			//close connection
			con.close();
		}catch(Exception e) {
			System.out.print("Error in bookingDAO.deleteBooking");
			e.printStackTrace();
		}
	}
	
	//get booking by booking_id
	public static booking getBookingByBooking_id(int booking_id) {
		booking r = new booking();
		
		try {
			//call getConnection() method
			con=dBConnection.getConnection();
			
			//prepare statement
			ps=con.prepareStatement("SELECT * FROM booking WHERE booking_id=?");
			ps.setInt(1, booking_id);
			
			//execute query
			rs=ps.executeQuery();
			
			if(rs.next()) {
				r.setBooking_id(rs.getInt("booking_id"));
				r.setBooking_date(rs.getDate("booking_date"));
				r.setBooking_status(rs.getString("booking_status"));
				r.setPackageid(rs.getString("packageid"));
				r.setQtypeople(rs.getInt("qtypeople"));
				r.setStaffid(rs.getInt("staffid"));
				r.setCustid(rs.getInt("custid"));
			}
			
			//close connection
			con.close();
		}catch(Exception e) {
			System.out.println("Error in getBookingByBooking_id");
			e.printStackTrace();
		}
		return r;
	}
	
	public static booking getBookingByBookingid(int booking_id, HttpServletRequest request, HttpServletResponse response) {
	    booking d = new booking();

	    try {
	        // call getConnection() method
	        con = dBConnection.getConnection();

	        // prepare statement
	        ps = con.prepareStatement("SELECT * FROM booking WHERE booking_id=?");
	        ps.setInt(1, booking_id);

	        // execute query
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            d.setBooking_id(rs.getInt("booking_id"));
	            d.setBooking_date(rs.getDate("booking_date"));
	            d.setBooking_status(rs.getString("booking_status"));
	            d.setPackageid(rs.getString("packageid"));
	            d.setQtypeople(rs.getInt("qtypeople"));
	            d.setStaffid(rs.getInt("staffid"));
	            d.setCustid(rs.getInt("custid"));

	            HttpSession session = request.getSession();
	            session.setAttribute("packageid", d.getPackageid()); // Store the packageid from the booking object in the session
                System.out.print("IN BOOKING DAO, id: "+d.getPackageid());
	        }

	        // close connection
	        con.close();
	    } catch (Exception e) {
	        System.out.println("Error in getBookingByBooking_id");
	        e.printStackTrace();
	    }
	    return d;
	}

	
	//listAllBooking
	public static List<booking>getAllBooking(){
		List<booking> bookings=new ArrayList<booking>();
		
		try {
			//call getConnection() method
			con=dBConnection.getConnection();
			
			//create statement
			stmt=con.createStatement();
			String sql="SELECT * FROM booking ORDER BY booking_id";
			
			//execute query
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				booking b = new booking();
				
				b.setBooking_id(rs.getInt("booking_id"));
				b.setBooking_date(rs.getDate("booking_date"));
				b.setBooking_status(rs.getString("booking_status"));
				b.setPackageid(rs.getString("packageid"));
				b.setQtypeople(rs.getInt("qtypeople"));
				b.setStaffid(rs.getInt("staffid"));
				b.setCustid(rs.getInt("custid"));
				
				bookings.add(b);
			}
			
			//close connection 
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return bookings;
	}
	//update booking
	  public void updateBooking(booking bean) {
	    booking_id=bean.getBooking_id();
	    booking_date=bean.getBooking_date();
	    booking_status=bean.getBooking_status();
	    staffid=bean.getStaffid();
	    custid=bean.getCustid();
	    packageid=bean.getPackageid();
	    qtypeople=bean.getQtypeople();
	    try {
	      //call getConnection() method
	      con=dBConnection.getConnection();
	      
	      //prepare statement
	      ps=con.prepareStatement("UPDATE booking SET booking_status=?,staffid=? WHERE custid=?");
	      ps.setString(1, booking_status);
	      ps.setInt(2, staffid);
	      ps.setInt(3, custid);
	      
	      //execute query
	      ps.executeUpdate();
	      System.out.println("Successfully Update Booking");
	      
	      //close connection
	      con.close();
	      
	    }catch(Exception e) {
	      System.out.println("Error in bookingDAO.updateBooking");
	      e.printStackTrace();
	    }
	  }
	//Below here is the report
	  public static List<TotalSalesPerMonthChart>getReportSPM(){
		  List<TotalSalesPerMonthChart>spmChart=new ArrayList<TotalSalesPerMonthChart>();
		  
		  try {
			  //call getConnection() method
			  con=dBConnection.getConnection();
			  
			  //prepare sql
			  String sql = "SELECT DATE_FORMAT(booking_date, '%Y-%m') AS month, SUM(qtypeople * packageprice) AS total_sales FROM package JOIN booking ON package.packageid = booking.packageid GROUP BY DATE_FORMAT(booking_date, '%Y-%m') ORDER BY DATE_FORMAT(booking_date, '%Y-%m');";
			  
			  //prepare statement
			  PreparedStatement stmt = con.prepareStatement(sql);
			  
			  ResultSet rs = stmt.executeQuery();
			  
			  while(rs.next()) {
				  TotalSalesPerMonthChart tspm = new TotalSalesPerMonthChart();
				  tspm.setSpmLabel(rs.getString("month"));
				  tspm.setSales(rs.getInt("total_sales"));
				  System.out.println("Month : " +rs.getString("month"));
				  System.out.println("Total Sales : " +rs.getInt("total_sales"));
				  spmChart.add(tspm);
			  }
			  
			  //close
			  rs.close(); 
	          stmt.close(); 
	          con.close(); 
		  }catch(Exception e) {
			  e.printStackTrace(); 
		  }
		  return spmChart;
	  }
	  
	  public static List<TotalCustomerPerMonthChart>getReportCustPM(){
		  List<TotalCustomerPerMonthChart>cpmChart=new ArrayList<TotalCustomerPerMonthChart>();
		  try {
			//call getConnection() method
			  con=dBConnection.getConnection();
			  
			  //prepare sql
			  String sql = "SELECT DATE_FORMAT(booking_date, '%Y-%m') AS month, COUNT(DISTINCT custid) AS total_customers FROM booking GROUP BY DATE_FORMAT(booking_date, '%Y-%m') ORDER BY DATE_FORMAT(booking_date, '%Y-%m');";
			  
			  //prepare statement
			  PreparedStatement stmt = con.prepareStatement(sql);
			  
			  ResultSet rs = stmt.executeQuery();
			  
			  while(rs.next()) {
				  TotalCustomerPerMonthChart tcpm = new TotalCustomerPerMonthChart();
				  tcpm.setCpmLabel(rs.getString("month"));
				  tcpm.setTotalCust(rs.getInt("total_customers"));
				  cpmChart.add(tcpm);
			  }
			  
			  //close connection
			  rs.close(); 
	          stmt.close(); 
	          con.close(); 
			  
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
		  return cpmChart;
	  }
	  
	  public static List<TotalCustomerPerPackageChart>getReportCustPerPackage()	{
		  List<TotalCustomerPerPackageChart>custPerPackageChart=new ArrayList<TotalCustomerPerPackageChart>();
		  
		  try {
			  //call getConnection()
			  con=dBConnection.getConnection();
			  
			  //prepare sql
			  String sql = "SELECT p.packagename, COUNT(DISTINCT b.custid) AS total_customers FROM package p JOIN booking b ON p.packageid = b.packageid GROUP BY p.packagename ORDER BY p.packagename;";
			  
			  //prepare statement
			  PreparedStatement stmt = con.prepareStatement(sql);
			  
			  ResultSet rs = stmt.executeQuery();
			  
			  while(rs.next()) {
				  TotalCustomerPerPackageChart tcpp=new TotalCustomerPerPackageChart();
				  tcpp.setPackagename(rs.getString("p.packagename"));
				  tcpp.setTotalCustPerPackage(rs.getInt("total_customers"));
				  custPerPackageChart.add(tcpp);
			  }
			  
			//close connection
			  rs.close(); 
	          stmt.close(); 
	          con.close(); 
			  
			  
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
		  return custPerPackageChart;
	  }
}

