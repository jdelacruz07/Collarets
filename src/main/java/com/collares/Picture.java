package com.collares;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Picture {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String nameArtist;
    private double price;
    private Date date;
    
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNameArtist() {
		return nameArtist;
	}
	public void setNameArtist(String nameArtist) {
		this.nameArtist = nameArtist;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
    
    
    

    
}
