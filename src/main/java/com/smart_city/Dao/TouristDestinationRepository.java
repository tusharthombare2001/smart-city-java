package com.smart_city.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart_city.Entity.TouristDestination;

public interface TouristDestinationRepository extends JpaRepository<TouristDestination, Long> {
    List<TouristDestination> findByCategory(String category);
    // Query method to find destinations by category and location
    List<TouristDestination> findByCategoryAndCity(String category, String city);

} 


