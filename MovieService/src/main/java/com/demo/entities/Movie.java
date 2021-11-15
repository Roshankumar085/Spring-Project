package com.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
     private String title;
     private String description;
     private double dailyrate;
     private double numberofstock;
     @OneToMany(cascade =CascadeType.ALL,fetch = FetchType.EAGER )
     @JoinColumn
     private List<Genre> genres;
     
	public List<Genre> getGenres() {
		
		return genres;
	}
	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getDailyrate() {
		return dailyrate;
	}
	public void setDailyrate(double dailyrate) {
		this.dailyrate = dailyrate;
	}
	
	public double getNumberofstock() {
		return numberofstock;
	}
	public void setNumberofstock(double numberofstock) {
		this.numberofstock = numberofstock;
	}
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void addGenre (Genre genre) {
		if(genres == null) {
		genres = new ArrayList<>();
//		genre.setMovie(this);
		genres.add(genre);
		}else {
	//	genre.setMovie(this);
		genres.add(genre);
		}
		}

}
