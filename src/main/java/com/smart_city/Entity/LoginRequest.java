package com.smart_city.Entity;

public class LoginRequest {

	  private String username;
	    private String password;
		/**
		 * 
		 */
		public LoginRequest() {
			super();
			// TODO Auto-generated constructor stub
		}
		/**
		 * @param username
		 * @param password
		 */
		public LoginRequest(String username, String password) {
			super();
			this.username = username;
			this.password = password;
		}
	    // Getters
	    public String getUsername() {
	        return username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    // Setters (if needed)
	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	}
