package com.regnant.BusApp;

import java.sql.Date;

public class BusBean {
	int Bus_id;
	String Bus_no;
	String Bus_Name;
	String Bus_From; 
	String Bus_To;
	Date Departure_Date;
	String Bus_Type;
	
	public void setId(int Bus_id) {
		this.Bus_id=Bus_id;
	}
	public void setNo(String Bus_no) {
		this.Bus_no=Bus_no;
	}
	public void setName(String Bus_Name) {
		this.Bus_Name=Bus_Name;
	}
	public void setSource(String Bus_From) {
		this.Bus_From=Bus_From;
	}
	public void setDestination(String Bus_To) {
		this.Bus_To=Bus_To;
	}
	public void setDate(Date Departure_Date) {
		this.Departure_Date=Departure_Date;
	}
	public void setType(String Bus_Type) {
		this.Bus_Type=Bus_Type;
	}
	public int getId() {
		return Bus_id;
	}
	public String getNo() {
		return Bus_no;
	}
	public String getName() {
		return Bus_Name;
	}
	public String getSource() {
		return Bus_From;
	}
	public String getDestination() {
		return Bus_To;
	}
	public Date getDate() {
		return Departure_Date;
	}
	public String getType() {
		return Bus_Type;
	}
}
