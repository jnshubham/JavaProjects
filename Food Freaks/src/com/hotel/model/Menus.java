package com.hotel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="menus")
public class Menus {
	
	
	@Id
	@Column(name="menuid")
	private String menuid;
	
	@Column(name="menuname")
	private String menuname;
	
	@Column(name="description")
	private String description;
	
	@Column(name="icon")
	private String icon;
	
	@ManyToOne
	@JoinColumn(name="hotelid")
	private Hotels hotels;
	
	
	
	public Hotels getHotels() {
		return hotels;
	}
	public void setHotels(Hotels hotels) {
		this.hotels = hotels;
	}
	

	public String getMenuid() {
		return menuid;
	}
	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	

}
