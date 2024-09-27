package com.smart_city.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TouristDestination {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	   
	   private String name;
	    private String category;  // e.g., Historical, Nature, Adventure
	    private String historical;
	    private String timings;
	    private double entryFee;
	    private String bestTimeToVisit;
	    private String imageUrl;
	    private String videoUrl;
	    private String city; 
	    private LocalDate tripDate; // Change to appropriate data type if needed

		
		public TouristDestination() {
			super();
			
		}
		
		

	
		

		/**
		 * @param id
		 * @param name
		 * @param category
		 * @param historical
		 * @param timings
		 * @param entryFee
		 * @param bestTimeToVisit
		 * @param imageUrl
		 * @param videoUrl
		 * @param city
		 * @param tripDate
		 */
		public TouristDestination(Long id, String name, String category, String historical, String timings,
				double entryFee, String bestTimeToVisit, String imageUrl, String videoUrl, String city,
				LocalDate tripDate) {
			super();
			this.id = id;
			this.name = name;
			this.category = category;
			this.historical = historical;
			this.timings = timings;
			this.entryFee = entryFee;
			this.bestTimeToVisit = bestTimeToVisit;
			this.imageUrl = imageUrl;
			this.videoUrl = videoUrl;
			this.city = city;
			this.tripDate = tripDate;
		}






		public Long getId() {
			return id;
		}






		public void setId(Long id) {
			this.id = id;
		}






		public String getName() {
			return name;
		}






		public void setName(String name) {
			this.name = name;
		}






		public String getCategory() {
			return category;
		}






		public void setCategory(String category) {
			this.category = category;
		}






		public String getHistorical() {
			return historical;
		}






		public void setHistorical(String historical) {
			this.historical = historical;
		}






		public String getTimings() {
			return timings;
		}






		public void setTimings(String timings) {
			this.timings = timings;
		}






		public double getEntryFee() {
			return entryFee;
		}






		public void setEntryFee(double entryFee) {
			this.entryFee = entryFee;
		}






		public String getBestTimeToVisit() {
			return bestTimeToVisit;
		}






		public void setBestTimeToVisit(String bestTimeToVisit) {
			this.bestTimeToVisit = bestTimeToVisit;
		}






		public String getImageUrl() {
			return imageUrl;
		}






		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}






		public String getVideoUrl() {
			return videoUrl;
		}






		public void setVideoUrl(String videoUrl) {
			this.videoUrl = videoUrl;
		}






		public String getCity() {
			return city;
		}






		public void setCity(String city) {
			this.city = city;
		}






		public LocalDate getTripDate() {
			return tripDate;
		}






		public void setTripDate(LocalDate tripDate) {
			this.tripDate = tripDate;
		}





 

}
