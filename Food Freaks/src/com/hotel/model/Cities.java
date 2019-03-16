package com.hotel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="cities")
public class Cities {
	

	@Id
	@Column(name="cityid")
	private String cityid;
	
	@ManyToOne
	@JoinColumn(name="stateid")
	private States states;
	
	public States getStates() {
		return states;
	}
	public void setStates(States states) {
		this.states = states;
	}
	@Column(name="cityname")
	private String cityname;
	
	
	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	

}
