package com.smart_city.Controller;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import com.smart_city.Entity.Disease;
//import com.smart_city.Service.DiseaseService;
//
//@RestController
//@RequestMapping("/api/disease")
//@CrossOrigin(origins = "http://localhost:3000") // Allow requests from React frontend
//
//public class DiseaseController {
//	   @Autowired
//	    private DiseaseService service;
//
//	    @GetMapping("/{symptoms}")
//	    public ResponseEntity<Object> getDisease(@PathVariable String symptoms) {
//	    	 Disease disease = new Disease(null, symptoms, symptoms, symptoms);
//	         if ("cough".equalsIgnoreCase(symptoms)) {
//	             disease.setDiseaseName("Common Cold");
//	             disease.setSymptoms("cough, runny nose");
//	             disease.setTreatment("Rest and hydration");
//	         } else {
//	             // If symptoms don't match, return a not found response
//	             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//	         }
//
//	         return ResponseEntity.ok(disease);
//	    }
//
//}


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.smart_city.Entity.Disease;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/disease")
public class DiseaseController {

    private final Map<String, Disease> diseaseMap = new HashMap<>();

    // Initialize the Map with some predefined diseases
    public DiseaseController() {
        diseaseMap.put("cough", new Disease(null, "Common Cold", "cough, runny nose", "Rest and hydration"));
        diseaseMap.put("fever", new Disease(null, "Flu", "fever, cough, body aches", "Rest, hydration, and antiviral medication"));
        diseaseMap.put("headache", new Disease(null, "Migraine", "headache, sensitivity to light, nausea", "Pain relievers, avoid triggers"));
        diseaseMap.put("fever,cough", new Disease(null, "COVID-19", "fever, cough, difficulty breathing", "Isolation and consult a doctor"));
        diseaseMap.put("sore throat", new Disease(null, "Tonsillitis", "sore throat, fever, swollen lymph nodes", "Antibiotics or rest"));
        diseaseMap.put("fatigue,fever", new Disease(null, "Malaria", "fatigue, fever, chills, sweating", "Anti-malarial medications"));
        diseaseMap.put("rash,fever", new Disease(null, "Measles", "rash, fever, cough, runny nose", "Supportive care, hydration, and vaccination"));
        diseaseMap.put("nausea,vomiting", new Disease(null, "Gastroenteritis", "nausea, vomiting, diarrhea", "Hydration, electrolyte balance, and rest"));
        diseaseMap.put("chest pain,shortness of breath", new Disease(null, "Heart Attack", "chest pain, shortness of breath, nausea", "Immediate medical attention"));
        diseaseMap.put("stomach pain", new Disease(null, "Gastritis", "stomach pain, bloating, nausea", "Antacids, dietary changes, and stress management"));
        diseaseMap.put("joint pain", new Disease(null, "Arthritis", "joint pain, swelling, stiffness", "Anti-inflammatory medications, physical therapy"));
        diseaseMap.put("swollen legs", new Disease(null, "Edema", "swollen legs, shortness of breath, fatigue", "Diuretics, compression socks, elevation of legs"));
        diseaseMap.put("nausea,dizziness", new Disease(null, "Vertigo", "nausea, dizziness, loss of balance", "Vestibular rehabilitation therapy, medications"));
        diseaseMap.put("skin rash", new Disease(null, "Eczema", "itchy skin, rash, red and dry patches", "Corticosteroid creams, moisturizing lotions"));
        diseaseMap.put("severe headache", new Disease(null, "Cluster Headache", "severe headache, pain behind the eye, eye redness", "Pain relievers, oxygen therapy"));
        diseaseMap.put("abdominal bloating", new Disease(null, "Irritable Bowel Syndrome (IBS)", "abdominal bloating, cramping, diarrhea or constipation", "Dietary changes, stress management, antispasmodic medications"));
        diseaseMap.put("shortness of breath", new Disease(null, "Asthma", "shortness of breath, wheezing, chest tightness", "Bronchodilators, inhaled corticosteroids"));
        diseaseMap.put("back pain", new Disease(null, "Herniated Disc", "lower back pain, leg pain, numbness or tingling", "Physical therapy, pain medications, surgery in severe cases"));
        diseaseMap.put("frequent urination", new Disease(null, "Urinary Tract Infection (UTI)", "frequent urination, burning sensation, cloudy urine", "Antibiotics, plenty of fluids"));
        diseaseMap.put("diarrhea", new Disease(null, "Food Poisoning", "diarrhea, nausea, vomiting, stomach cramps", "Hydration, rest, and antibiotics if bacterial"));
        diseaseMap.put("sore muscles", new Disease(null, "Muscle Strain", "sore muscles, stiffness, swelling", "Rest, ice packs, anti-inflammatory drugs"));
        diseaseMap.put("sweating,chills", new Disease(null, "Malaria", "sweating, chills, fever, fatigue", "Anti-malarial medications"));
        diseaseMap.put("night sweats", new Disease(null, "Tuberculosis (TB)", "night sweats, cough, weight loss, fatigue", "Antibiotics, long-term treatment"));
        diseaseMap.put("nausea,loss of appetite", new Disease(null, "Hepatitis", "nausea, jaundice, loss of appetite", "Antiviral drugs, rest"));
        diseaseMap.put("red eyes", new Disease(null, "Conjunctivitis (Pink Eye)", "red eyes, irritation, watery eyes", "Antibiotics or antiviral medication, depending on cause"));
        diseaseMap.put("dizziness,vomiting", new Disease(null, "Vertigo", "dizziness, nausea, vomiting", "Vestibular rehabilitation therapy, anti-nausea medication"));
        diseaseMap.put("swollen glands", new Disease(null, "Mononucleosis (Mono)", "swollen glands, sore throat, fever", "Rest, fluids, and pain relievers"));
        diseaseMap.put("itchy skin", new Disease(null, "Psoriasis", "itchy skin, red patches, scales", "Topical treatments, phototherapy, oral medication"));
        diseaseMap.put("blurry vision", new Disease(null, "Glaucoma", "blurry vision, eye pain, nausea", "Medications to reduce intraocular pressure, surgery if necessary"));
        diseaseMap.put("frequent headaches", new Disease(null, "Tension Headache", "frequent headaches, pressure around the head", "Stress management, pain relievers"));
        diseaseMap.put("nausea,headaches", new Disease(null, "Migraine", "nausea, headache, light sensitivity", "Pain relievers, avoiding triggers"));
        diseaseMap.put("sensitivity to light", new Disease(null, "Meningitis", "sensitivity to light, fever, stiff neck", "Antibiotics, hospitalization"));
        diseaseMap.put("irregular heartbeat", new Disease(null, "Arrhythmia", "irregular heartbeat, dizziness, chest pain", "Medications, pacemaker implantation"));
        diseaseMap.put("nausea,abdominal pain", new Disease(null, "Peptic Ulcer", "nausea, burning abdominal pain", "Proton pump inhibitors, avoiding irritants"));
        diseaseMap.put("pale skin", new Disease(null, "Anemia", "pale skin, fatigue, shortness of breath", "Iron supplements, dietary changes"));
        diseaseMap.put("cough,wheezing", new Disease(null, "Chronic Obstructive Pulmonary Disease (COPD)", "chronic cough, wheezing, shortness of breath", "Bronchodilators, steroids, lifestyle changes"));
        diseaseMap.put("leg cramps", new Disease(null, "Electrolyte Imbalance", "leg cramps, muscle weakness", "Rehydration, electrolyte replacement"));
        diseaseMap.put("weight loss", new Disease(null, "Hyperthyroidism", "unexplained weight loss, rapid heart rate", "Anti-thyroid medications, surgery if severe"));
        diseaseMap.put("fever,body aches", new Disease(null, "Dengue Fever", "fever, body aches, rash", "Hydration, rest, fever reducers"));
    
    }

    @GetMapping("/{symptoms}")
    public ResponseEntity<Object> getDisease(@PathVariable String symptoms) {
        Disease disease = diseaseMap.get(symptoms.toLowerCase());

        if (disease == null) {
            // If no matching disease is found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No matching disease found for the given symptoms.");
        }

        return ResponseEntity.ok(disease);
    }

    // Add new disease dynamically via an API call
    @PostMapping("/add")
    public ResponseEntity<String> addDisease(@RequestBody Disease newDisease) {
        if (newDisease.getSymptoms() == null || newDisease.getDiseaseName() == null || newDisease.getTreatment() == null) {
            return ResponseEntity.badRequest().body("Disease information is incomplete.");
        }
        diseaseMap.put(newDisease.getSymptoms().toLowerCase(), newDisease);
        return ResponseEntity.ok("Disease added successfully.");
    }
}
