package com.smart_city.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart_city.Dao.DiseaseRepository;
import com.smart_city.Entity.Disease;
@Service
public class DiseaseService {
	  @Autowired
	    private DiseaseRepository repository;

	    public Disease getDiseaseBySymptoms(String symptoms) {
	    	 if ("cough".equalsIgnoreCase(symptoms)) {
	             return new Disease(null, "Common Cold", "cough, runny nose", "Rest and hydration");
	         }
	         return null; // If no disease found for given symptoms
	     }

}
