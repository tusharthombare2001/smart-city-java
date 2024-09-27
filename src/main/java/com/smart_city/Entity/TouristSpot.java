package com.smart_city.Entity;

public class TouristSpot {private String name;
private String description;
private String imageUrl;
/**
 * 
 */
public TouristSpot() {
	super();
	// TODO Auto-generated constructor stub
}
/**
 * @param name
 * @param description
 * @param imageUrl
 */
public TouristSpot(String name, String description, String imageUrl) {
	super();
	this.name = name;
	this.description = description;
	this.imageUrl = imageUrl;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getImageUrl() {
	return imageUrl;
}
public void setImageUrl(String imageUrl) {
	this.imageUrl = imageUrl;
}


}
