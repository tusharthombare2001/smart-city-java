package com.smart_city.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart_city.Dao.FeedbackRepository;
import com.smart_city.Entity.Feedback;

@Service
public class FeedbackService {
	
	 @Autowired
	    private FeedbackRepository feedbackRepository;

	    public List<Feedback> getFeedbackForDestination(Long destinationId) {
	        return feedbackRepository.findByDestinationId(destinationId);
	    }

	    public Feedback addFeedback(Feedback feedback) {
	        return feedbackRepository.save(feedback);
	    }

}
