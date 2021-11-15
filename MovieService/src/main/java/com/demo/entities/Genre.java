package com.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Genre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    
	       private int id;
	       private String name;
//	       @ManyToOne
//	       private Movie movie;
//		public Movie getMovie() {
//			return movie;
//		}
//		public void setMovie(Movie movie) {
//			this.movie = movie;
//		}
		public Genre() {
			super();
			// TODO Auto-generated constructor stub
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	       
	      
	
	
          

}
