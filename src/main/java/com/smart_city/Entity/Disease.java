package com.smart_city.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity

public class Disease {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String diseaseName;
	    private String symptoms;
	    private String treatment;
		/**
		 * @param id
		 * @param diseaseName
		 * @param symptoms
		 * @param treatment
		 */
		public Disease(Long id, String diseaseName, String symptoms, String treatment) {
			super();
			this.id = id;
			this.diseaseName = diseaseName;
			this.symptoms = symptoms;
			this.treatment = treatment;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getDiseaseName() {
			return diseaseName;
		}
		public void setDiseaseName(String diseaseName) {
			this.diseaseName = diseaseName;
		}
		public String getSymptoms() {
			return symptoms;
		}
		public void setSymptoms(String symptoms) {
			this.symptoms = symptoms;
		}
		public String getTreatment() {
			return treatment;
		}
		public void setTreatment(String treatment) {
			this.treatment = treatment;
		}

}
