package com.smart_city.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart_city.Entity.Disease;
public interface DiseaseRepository extends JpaRepository<Disease, Long> {
	 Disease findBySymptoms(String symptoms); 

}
