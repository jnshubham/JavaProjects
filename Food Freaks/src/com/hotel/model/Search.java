package com.hotel.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="search")
public class Search {
	
	@Id
	@Column(name="search")
	private String search1;
	
	public String getSearch1() {
		return search1;
	}
	public void setSearch1(String search1) {
		this.search1 = search1;
	}




	@ManyToOne
	@JoinColumn(name="hotelid")
	private Hotels locationname;
	

	public Hotels getLocationname() {
		return locationname;
	}
	public void setLocationname(Hotels locationname) {
		this.locationname = locationname;
	}



	



	@ManyToOne
	@JoinColumn(name="stateid")
	private States state;
	
	
	public States getState() {
		return state;
	}
	public void setState(States state) {
		this.state = state;
	}




	@ManyToOne
	@JoinColumn(name="cityid")
	private Cities city;


	public Cities getCity() {
		return city;
	}
	public void setCity(Cities city) {
		this.city = city;
	}
	
	
}
