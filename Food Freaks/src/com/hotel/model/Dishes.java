package com.hotel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="dishes")
public class Dishes {

	@Id
	@Column(name="dishid")
	private String dishid;
	
	@Column(name="dishname")
	private String dishname;
	
	@Column(name="description")
	private String description;
	
	@Column(name="icon")
	private String icon;
	
	@Column(name="price")
	private String price;
	
	@Column(name="specialoffer")
	private String specialoffer;
	
	@ManyToOne
	@JoinColumn(name="menuid")
	private Menus menus;
	
	
	
	public Menus getMenus() {
		return menus;
	}
	public void setMenus(Menus menus) {
		this.menus = menus;
	}
	
	public String getDishid() {
		return dishid;
	}
	public void setDishid(String dishid) {
		this.dishid = dishid;
	}
	public String getDishname() {
		return dishname;
	}
	public void setDishname(String dishname) {
		this.dishname = dishname;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSpecialoffer() {
		return specialoffer;
	}
	public void setSpecialoffer(String specialoffer) {
		this.specialoffer = specialoffer;
	}
	
}
