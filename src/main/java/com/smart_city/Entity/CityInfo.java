package com.smart_city.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "city_info")
public class CityInfo {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 private String history;
	 @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    @JoinColumn(name = "city_info_id")  // Foreign key column in the Spot table
	 private List<Spot> touristSpots;
	 
	 @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    @JoinColumn(name = "city_info_id")  // Foreign key column in the Spot tabl
	 private List<Spot> highlightedSpots;
	    
	    /**
	 * 
	 */
	public CityInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

		/**
		 * @param history
		 * @param touristSpots
		 * @param highlightedSpots
		 */
		public CityInfo(String history, List<Spot> touristSpots, List<Spot> highlightedSpots) {
			super();
			this.history = history;
			this.touristSpots = touristSpots;
			this.highlightedSpots = highlightedSpots;
		}

		public String getHistory() {
			return history;
		}

		public void setHistory(String history) {
			this.history = history;
		}

		public List<Spot> getTouristSpots() {
			return touristSpots;
		}

		public void setTouristSpots(List<Spot> touristSpots) {
			this.touristSpots = touristSpots;
		}

		public List<Spot> getHighlightedSpots() {
			return highlightedSpots;
		}

		public void setHighlightedSpots(List<Spot> highlightedSpots) {
			this.highlightedSpots = highlightedSpots;
		}
    

}
