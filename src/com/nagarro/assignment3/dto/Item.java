package com.nagarro.assignment3.dto;
import java.util.Comparator;
import java.util.Date;
public class Item  {
	
	private String flight_No;
	private Date valid_till;
	private String arr_Loc ;
	private String dep_Loc ;
	private Integer flight_time;
	private Double duration;
	private Double fare;
	private String avail;
	private String flight_class;
	
	public Item(String flight_No ,String dep_Loc,String arr_Loc,Date valid_till, Integer flight_time,Double duration,Double fare, String  avail,String flight_class) {
		this.flight_No = flight_No;
		this.valid_till = valid_till;
		this.arr_Loc =  arr_Loc;
		this.dep_Loc =  dep_Loc;
		this.flight_time= flight_time;
		this.duration = duration;
		this.fare = fare  ;
		this.avail = avail;
		this.flight_class = flight_class;

	}
	
	public  String getFlightNo() {
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
	
	public String getClasses() {
		return this.flight_class;
	}
	
	public Boolean isValid(String dep_location, String arr_loc2, Date flight_date, String flight_class2) {
		return this.dep_Loc.equals(dep_location)&&this.arr_Loc.equals(arr_loc2)&&(flight_date.compareTo(this.valid_till)<=0)&&this.flight_class.contains(flight_class2);
	}
	
		
}

