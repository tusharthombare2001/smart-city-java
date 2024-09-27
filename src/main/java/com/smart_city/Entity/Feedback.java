package com.smart_city.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Feedback {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	 
	 private String userName;
	    private Long destinationId;  // Foreign key to TouristDestination
	    private String comments;
	    private int rating;
		
		public Feedback() {
			super();
		
		}
		
		public Feedback(Long id, String userName, Long destinationId, String comments, int rating) {
			super();
			this.id = id;
			this.userName = userName;
			this.destinationId = destinationId;
			this.comments = comments;
			this.rating = rating;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public Long getDestinationId() {
			return destinationId;
		}
		public void setDestinationId(Long destinationId) {
			this.destinationId = destinationId;
		}
		public String getComments() {
			return comments;
		}
		public void setComments(String comments) {
			this.comments = comments;
		}
		public int getRating() {
			return rating;
		}
		public void setRating(int rating) {
			this.rating = rating;
		}
	    
	    
}
