package com.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Movie;
import com.demo.repositories.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movRepo;
	
	  public Movie savemov(Movie mov) {
		  
		  return movRepo.save(mov);
	  }
	    public List<Movie> getAllMov(){
	    	return movRepo.findAll();
	    	
	    }
	    
	      public Movie removeMovie(int id) {
	    	  Optional<Movie> optmov =movRepo.findById(id);
	    	  if(optmov.isPresent()) {
	    		  Movie e=optmov.get();
	    		  return e;
	    		  
	    	  }
			     return null;
	    	  
	   }
	      public Movie removeEmp(int id) {

	  		Optional<Movie> optEmp = movRepo.findById(id);

	  		if (optEmp.isPresent()) {
	  			Movie e = optEmp.get();
	  			movRepo.delete(e);
	  			return e;
	  		}

	  		return null;
	  	}

	  	public Movie updateEmp(int id, Movie mov) {

	  		Optional<Movie> optEmp = movRepo.findById(id);

	  		if (optEmp.isPresent()) {
	  			Movie e = optEmp.get();
	  			e.setId(mov.getId());
	  			e.setTitle(mov.getTitle());
	  			e.setDescription(mov.getDescription());
	  			e.setDailyrate(mov.getDailyrate());
	  			e.setNumberofstock(mov.getNumberofstock());
	  			movRepo.save(e);
	  			return e;
	  		}

	  		return null;
	  	}

}
