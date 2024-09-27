package com.smart_city.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smart_city.Entity.CityInfo;
import com.smart_city.Entity.Feedback;
import com.smart_city.Entity.TouristDestination;
import com.smart_city.Service.FeedbackService;
import com.smart_city.Service.TouristDestinationService;

@RestController
@RequestMapping("/api/tourism")
public class TourismController {
	
	 @Autowired
	    private TouristDestinationService touristDestinationService;

	    @Autowired
	    private FeedbackService feedbackService;

	    @GetMapping("/destinations")
	    public List<TouristDestination> getAllDestinations() {
	        return touristDestinationService.getAllDestinations();
	    }
	    


	    @GetMapping("/destinations/category/{category}")
	    public List<TouristDestination> getDestinationsByCategory(@PathVariable String category) {
	        return touristDestinationService.getDestinationsByCategory(category);
	    }

	    @GetMapping("/destinations/{id}")
	    public TouristDestination getDestinationById(@PathVariable Long id) {
	        return touristDestinationService.getDestinationById(id);
	    }

	    @PostMapping("/feedback")
	    public Feedback submitFeedback(@RequestBody Feedback feedback) {
	        return feedbackService.addFeedback(feedback);
	    }

	    @GetMapping("/feedback")
	    public List<Feedback> getFeedbackByDestination(@PathVariable Long destinationId) {
	        return feedbackService.getFeedbackForDestination(destinationId);
	    }
	    
	    @GetMapping("/api/tourism/destinations/category/{category}")
	    public List<TouristDestination> getDestinationsByCategoryAndCity(
	        @PathVariable String category,
	        @RequestParam(required = false, defaultValue = "Maharashtra") String city
	    ) {
	    	
	    	if (category.equalsIgnoreCase("history")) {
	            category = "history";  // Adjust the category as needed
	    	}
	        return touristDestinationService.getDestinationsByCategoryAndCity(category, city);
	    }
	    
	    
	    @PostMapping("/destinations")
	    public TouristDestination addDestination(@RequestBody TouristDestination destination) {
	        return touristDestinationService.addDestination(destination); // Assuming addDestination saves it to DB
	    }
	    
	    
	    @GetMapping("/cities/{city}")
	    public CityInfo getCityInfo(@PathVariable String city) {
	        return touristDestinationService.getCityInfo(city);
	    }
	    
	    
	    @DeleteMapping("/destinations/{id}")
	    public ResponseEntity<Void> deleteDestination(@PathVariable Long id) {
	        boolean isDeleted = touristDestinationService.deleteDestinationById(id);
	        
	        if (isDeleted) {
	            return ResponseEntity.ok().build();  // Successfully deleted
	        } else {
	            return ResponseEntity.notFound().build();  // If not found
	        }
	    }
	    
	    @PutMapping("/destinations/{id}")
	    public TouristDestination updateDestination(@PathVariable Long id, @RequestBody TouristDestination destination) {
	        return touristDestinationService.updateDestination(id, destination);
	    }





}
