package com.smart_city.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart_city.Entity.Feedback;

public interface FeedbackRepository  extends JpaRepository<Feedback, Long> {
    List<Feedback> findByDestinationId(Long destinationId); 

}
