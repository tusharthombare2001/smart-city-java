package com.smart_city.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Spot {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment for primary key
	    private Long id; // Primary key field
	private String name;
    private String imageUrl;
    private String description;
	/**
	 * 
	 */
	public Spot() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param name
	 * @param imageUrl
	 * @param description
	 */
	public Spot(String name, String imageUrl, String description) {
		super();
		this.name = name;
		this.imageUrl = imageUrl;
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
    
    

}
