package PYS.bean;

import java.util.Date;

public class booking {
	private int booking_id;
	private Date booking_date;
	private String booking_status;
	private int staffid;
	private int custid;
	private String packageid;
	private int qtypeople;
	
	public int getQtypeople() {
		return qtypeople;
	}

	public void setQtypeople(int qtypeople) {
		this.qtypeople = qtypeople;
	}

	public String getPackageid() {
		return packageid;
	}

	public void setPackageid(String packageid) {
		this.packageid = packageid;
	}

	public booking(int booking_id, Date booking_date, String booking_status, int staffid, int custid) {
		super();
		this.booking_id = booking_id;
		this.booking_date = booking_date;
		this.booking_status = booking_status;
		this.staffid = staffid;
		this.custid = custid;
	}

	public booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public Date getBooking_date() {
		return booking_date;
	}

	public void setBooking_date(Date booking_date) {
		this.booking_date = booking_date;
	}

	public String getBooking_status() {
		return booking_status;
	}

	public void setBooking_status(String booking_status) {
		this.booking_status = booking_status;
	}

	public int getStaffid() {
		return staffid;
	}

	public void setStaffid(int staffid) {
		this.staffid = staffid;
	}

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}
	
	
}
