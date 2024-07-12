package PYS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import PYS.bean.packages;
import PYS.connection.dBConnection;

public class packageDAO {
	static Connection con = null;
	static ResultSet rs =null;
	static PreparedStatement ps = null;
	private String packageid;
	private String packagename;
	private String p_destination;
	private Date p_startdate;
	private Date p_enddate;
	private double packageprice;
	private String packagedesc;
	
	//List all packages
	public static List<packages> getAllPackages(){
		List<packages> pack =new ArrayList<>();
	
		
		try {
			con = dBConnection.getConnection();
			ps = con.prepareStatement("SELECT * FROM PACKAGE");
			rs = ps.executeQuery();
			
			 while (rs.next()) {
	                packages p = new packages();
	                p.setPackageid(rs.getString("packageid"));
	                p.setPackagename(rs.getString("packagename"));
	                p.setP_destination(rs.getString("p_destination"));
	                p.setP_startdate(rs.getDate("p_startdate"));
	                p.setP_enddate(rs.getDate("p_enddate"));
	                p.setPackageprice(rs.getDouble("packageprice"));
	                p.setPackagedesc(rs.getString("packagedesc"));
	                
	                pack.add(p);
			 }
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in packageDAO, getAllPackages()");
		}
		
		return pack;	
	}
	
	
	//Get package by id
	public static packages getPackageByPackageid(String packageid) {

		packages p  = new packages();
		
		try {
			//call getConnection() method
			con=dBConnection.getConnection();
			
			//prepare statement
			ps=con.prepareStatement("SELECT * FROM package WHERE packageid=?");
			ps.setString(1, packageid);
			
			//execute query
			rs=ps.executeQuery();
			
			if(rs.next()) {
				p.setPackageid(rs.getString("packageid"));
                p.setPackagename(rs.getString("packagename"));
                p.setP_destination(rs.getString("p_destination"));
                p.setP_startdate(rs.getDate("p_startdate"));
                p.setP_enddate(rs.getDate("p_enddate"));
                p.setPackageprice(rs.getDouble("packageprice"));
                p.setPackagedesc(rs.getString("packagedesc"));
			}
			System.out.println("in packageDAO successfully package with ID: " + packageid);
			//close connection
			con.close();
		}catch(Exception e) {
			System.out.println("Error in getBookingByBooking_id");
			e.printStackTrace();
		}
		return p;
	}
	
	//Update Package
	public void updatePackage(packages bean) {
		packageid=bean.getPackageid();
		packagename=bean.getPackagename();
		p_destination=bean.getP_destination();
		p_startdate=bean.getP_startdate();
		p_enddate=bean.getP_enddate();
		packageprice=bean.getPackageprice();
		packagedesc=bean.getPackagedesc();
		
		try {
			//call getConnection() method
			con=dBConnection.getConnection();
			
			//prepare statement
			ps=con.prepareStatement("UPDATE package SET packageid=?,packagename=?,p_destination=?,p_startdate=?,p_enddate=?,packageprice=?,packagedesc=? WHERE packageid=?");
			ps.setString(1, packageid);
			ps.setString(2, packagename);
			ps.setString(3, p_destination);
			ps.setObject(4, p_startdate);
			ps.setObject(5, p_enddate);
			ps.setDouble(6, packageprice);
			ps.setString(7, packagedesc);
			ps.setString(8, packageid);
			
			//execute update
			ps.executeUpdate();
			
			//close connection
			con.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addPackage(packages bean) {
		packageid=bean.getPackageid();
		packagename=bean.getPackagename();
		p_destination=bean.getP_destination();
		p_startdate=bean.getP_startdate();
		p_enddate=bean.getP_enddate();
		packageprice=bean.getPackageprice();
		packagedesc=bean.getPackagedesc();
		
		try {
			//call getConnection() method
			con=dBConnection.getConnection();
			
			//prepare statement
			ps=con.prepareStatement("INSERT INTO package(packageid,packagename,p_destination,p_startdate,p_enddate,packageprice,packagedesc) VALUES(?,?,?,?,?,?,?)");
			ps.setString(1, packageid);
			ps.setString(2, packagename);
			ps.setString(3, p_destination);
			ps.setObject(4, p_startdate);
			ps.setObject(5, p_enddate);
			ps.setDouble(6, packageprice);
			ps.setString(7, packagedesc);
			
			//execute update
			ps.executeUpdate();
			System.out.println("Successfully Add Package");
			
			//close connection
			con.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deletePackage(String packageid) {
		try {
			//call getConnection method
			con = dBConnection.getConnection();
			
			//create statement
			ps = con.prepareStatement("DELETE FROM package WHERE packageid=?");
			ps.setString(1, packageid);
			
			//execute update
			ps.executeUpdate();
			System.out.print("Successfully Delete Package " + packageid);
			//close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
