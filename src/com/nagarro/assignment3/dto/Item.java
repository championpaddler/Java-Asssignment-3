package com.nagarro.assignment3.dto;

import java.util.Date;

public class Item {
	private String flight_No;
	private Date valid_till;
	private String arr_Loc;
	private String dep_Loc;
	private Integer flight_time;
	private Double duration;
	private Double fare;
	private String avail;
	private String flight_class;

	public Item(String flight_No, String dep_Loc, String arr_Loc, Date valid_till, Integer flight_time, Double duration,
			Double fare, String avail, String flight_class) {
		this.flight_No = flight_No;
		this.valid_till = valid_till;
		this.arr_Loc = arr_Loc;
		this.dep_Loc = dep_Loc;
		this.flight_time = flight_time;
		this.duration = duration;
		this.fare = fare;
		this.avail = avail;
		this.flight_class = flight_class;

	}

	public String getFlightNo() {
		return this.flight_No;
	}

	public Integer getFlightTime() {
		return this.flight_time;
	}

	public Double getDuration() {
		return this.duration;
	}

	public Double getfare() {
		return this.fare;
	}

	public Date getValid() {
		return this.valid_till;
	}

	public String getavail() {
		return this.avail;
	}

	public String getClasses() {
		return this.flight_class;
	}

	public void setfare(Double fare) {
		this.fare = fare;
	}

	public void setClasses(String cl) {
		this.flight_class = cl;
	}

	public void setavail(String avail) {
		this.avail = avail;
	}

	public void setValid(Date d1) {
		this.valid_till = d1;
	}

	public void setDuration(Double d1) {
		this.duration = d1;
	}

	public Boolean isValid(String dep_location, String arr_loc2, Date flight_date, String flight_class2) {
		return this.avail.equals("Y") && this.dep_Loc.toLowerCase().equals(dep_location.toLowerCase())
				&& this.arr_Loc.toLowerCase().equals(arr_loc2.toLowerCase())
				&& (flight_date.compareTo(this.valid_till) <= 0) && this.flight_class.contains(flight_class2);
	}

}
