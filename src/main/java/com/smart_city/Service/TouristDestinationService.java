package com.smart_city.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.AotInitializerNotFoundException;
import org.springframework.stereotype.Service;

import com.smart_city.Dao.TouristDestinationRepository;
import com.smart_city.Entity.CityInfo;
import com.smart_city.Entity.Spot;
import com.smart_city.Entity.TouristDestination;

@Service
public class TouristDestinationService {
	  @Autowired
	    private TouristDestinationRepository touristDestinationRepository;

	    public List<TouristDestination> getAllDestinations() {
	        return touristDestinationRepository.findAll();
	    }

	    public List<TouristDestination> getDestinationsByCategory(String category) {
	        return touristDestinationRepository.findByCategory(category);
	    }

	    public TouristDestination getDestinationById(Long id) {
	        return touristDestinationRepository.findById(id)
	                .orElseThrow(() -> new AotInitializerNotFoundException(null, "Destination not found"));
	    }

	    public TouristDestination addDestination(TouristDestination destination) {
	        return touristDestinationRepository.save(destination);
	    }
	    
	    // Fetch destinations by category and location
	    public List<TouristDestination> getDestinationsByCategoryAndCity(String category, String city) {
	        return touristDestinationRepository.findByCategoryAndCity(category, city);
	    }
	    
	    

	    public CityInfo getCityInfo(String city) {
	        String history = "";
	        List<Spot> touristSpots = new ArrayList<>();
	        List<Spot> highlightedSpots = new ArrayList<>();

	        switch (city.toLowerCase()) {
	            case "pune":
	                history = "Pune is known as the cultural capital of Maharashtra.";
	                highlightedSpots.add(new Spot("Aga Khan Palace", "https://th.bing.com/th/id/OIP.s0RXVX_YQEwEhtLtZ2dRvwHaEL?rs=1&pid=ImgDetMain.jpg", "Historical palace with beautiful gardens."));
	                touristSpots.add(new Spot("Shaniwar Wada", "https://t4.ftcdn.net/jpg/03/30/09/97/240_F_330099712_3M66llI8QLFUPJG88eCRosR1SICeQFVJ.jpg", "A famous fort in Pune."));
	                touristSpots.add(new Spot("Sinhagad Fort", "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1b/40/01/58/caption.jpg", "A historic fort with scenic views."));
	                break;
	            case "mumbai":
	                history = "Mumbai is the financial capital of India and home to Bollywood.";
	                highlightedSpots.add(new Spot("Gateway of India", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTrFD0MZ04ZTQ9o_HwaGSSOpSo1MstSul3vxg&s.jpg", "Iconic monument overlooking the Arabian Sea."));
	                touristSpots.add(new Spot("Marine Drive", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR1UiaKU6wXCPeAlsIsHRz7AVNb3RnAk4qcVA&s.jpg", "Scenic seaside promenade."));
	                touristSpots.add(new Spot("Elephanta Caves", "data.jpg", "Ancient cave temples on Elephanta Island."));
	                break;
	            case "nagpur":
	                history = "Nagpur is known for its oranges and as a major trade center.";
	                highlightedSpots.add(new Spot("Futala Lake", "https://plus.unsplash.com/premium_photo-1674409427334-0ae5280381ee?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OXx8bGFrZXxlbnwwfHwwfHx8MA%3D%3D.jpg", "Beautiful lake with a walking path."));
	                touristSpots.add(new Spot("Deekshabhoomi", "https://media.gettyimages.com/id/520826278/photo/statues-of-lord-buddha-in-deekshabhoomi-stupa-nagpur-maharashtra-india.jpg?s=612x612&w=0&k=20&c=R_dVdf8uZRJ7ojwuZQE8aGyh88mqo4epm_eDknBmt4c=.jpg", "A sacred monument of Buddhism."));
	                touristSpots.add(new Spot("Nagzira Wildlife Sanctuary", "https://example.com/images/nagzira_wildlife_sanctuary.jpg", "A wildlife sanctuary known for its rich biodiversity."));
	                break;
	            case "aurangabad":
	                history = "Aurangabad is known for its rich history and UNESCO World Heritage Sites.";
	                highlightedSpots.add(new Spot("Ajanta Caves", "https://example.com/images/ajanta_caves.jpg", "Ancient Buddhist rock-cut caves."));
	                touristSpots.add(new Spot("Ellora Caves", "https://example.com/images/ellora_caves.jpg", "A collection of monumental caves."));
	                touristSpots.add(new Spot("Bibi Ka Maqbara", "https://example.com/images/bibi_ka_maqbara.jpg", "A mausoleum resembling the Taj Mahal."));
	                break;
	            case "nashik":
	                history = "Nashik is known for its vineyards and the Kumbh Mela.";
	                highlightedSpots.add(new Spot("Sula Vineyards", "https://example.com/images/sula_vineyards.jpg", "Famous vineyard offering wine tours and tastings."));
	                touristSpots.add(new Spot("Kumbh Mela", "https://example.com/images/kumbh_mela.jpg", "Massive religious festival held every 12 years."));
	                touristSpots.add(new Spot("Anjneri Hill", "https://example.com/images/anjneri_hill.jpg", "A popular trekking destination."));
	                break;
	            default:
	                history = "No information available for the selected city.";
	                break;
	        }

	        return new CityInfo(history, touristSpots, highlightedSpots);
	    }
	    
	    
	    
	    public boolean deleteDestinationById(Long id) {
	        if (touristDestinationRepository.existsById(id)) {
	            touristDestinationRepository.deleteById(id);
	            return true;
	        } else {
	            return false;  // Destination not found
	        }
	    }
	    
	    public TouristDestination updateDestination(Long id, TouristDestination newDetails) {
	        return touristDestinationRepository.findById(id)
	            .map(destination -> {
	                destination.setName(newDetails.getName());
	                destination.setCategory(newDetails.getCategory());
	                destination.setCity(newDetails.getCity());
	                // Set other fields as needed
	                return touristDestinationRepository.save(destination);
	            })
	            .orElseThrow(() -> new AotInitializerNotFoundException(null, "Destination not found with id: " + id));
	    }





		
	}


