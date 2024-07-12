package PYS.bean;

import java.util.Date;

public class packages {
	private String packageid;
	private String packagename;
	private String p_destination;
	private Date p_startdate;
	private Date p_enddate;
	public Date getP_enddate() {
		return p_enddate;
	}
	public void setP_enddate(Date p_enddate) {
		this.p_enddate = p_enddate;
	}
	private double packageprice;
	private String packagedesc;
	public String getPackageid() {
		return packageid;
	}
	public void setPackageid(String packageid) {
		this.packageid = packageid;
	}
	public String getPackagename() {
		return packagename;
	}
	public void setPackagename(String packagename) {
		this.packagename = packagename;
	}
	public String getP_destination() {
		return p_destination;
	}
	public void setP_destination(String p_destination) {
		this.p_destination = p_destination;
	}
	public Date getP_startdate() {
		return p_startdate;
	}
	public void setP_startdate(Date p_startdate) {
		this.p_startdate = p_startdate;
	}
	public double getPackageprice() {
		return packageprice;
	}
	public void setPackageprice(double packageprice) {
		this.packageprice = packageprice;
	}
	public String getPackagedesc() {
		return packagedesc;
	}
	public void setPackagedesc(String packagedesc) {
		this.packagedesc = packagedesc;
	}
	
}
