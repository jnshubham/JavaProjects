package com.hotel.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="hotels")
public class Hotels {
	
	
	@Id
	@Column(name="hotelid")
	private String hotelid;
	
	@Column(name="hotelname")
	private String hotelname;
	
	@Column(name="address")
	private String address;
	
	/*@Column(name="locationname")
	private String locationname;*/
	
	@Column(name="pin")
	private String pin;
	
	@Column(name="latitude")
	private String latitude;
	
	@Column(name="emailid")
	private String emailid;
	
	@Column(name="contactno")
	private String contactno;
	
	@Column(name="ownername")
	private String ownername;
	
	@Column(name="status")
	private String status;
	
	@Transient
	private String state;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	@ManyToOne
	@JoinColumn(name="cityid")
	private Cities cities;
		
	public Cities getCities() {
		return cities;
	}
	public void setCities(Cities cities) {
		this.cities = cities;
	}
	
	@ManyToOne
	@JoinColumn(name="locationid")
	private Locations locations;
	public Locations getLocations() {
		return locations;
	}
	public void setLocations(Locations locations) {
		this.locations = locations;
	}

	@Transient
	private List<Map<String,String>> fillstate=new ArrayList<Map<String,String>>();
	@Transient
	private List<Map<String,String>> fillcity=new ArrayList<Map<String,String>>();
	
	
	
	
	
	public String getHotelid() {
		return hotelid;
	}
	public void setHotelid(String hotelid) {
		this.hotelid = hotelid;
	}
	public String getHotelname() {
		return hotelname;
	}
	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getOwnername() {
		return ownername;
	}
	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
	public List<Map<String, String>> getFillstate() {
		return fillstate;
	}
	public void setFillstate(List<Map<String, String>> fillstate) {
		this.fillstate = fillstate;
	}
	public List<Map<String, String>> getFillcity() {
		return fillcity;
	}
	public void setFillcity(List<Map<String, String>> fillcity) {
		this.fillcity = fillcity;
	}
	
	
	
	
	
	

}

