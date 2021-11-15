package com.demo.repositoryTest;

import javax.transaction.Transactional;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.entities.Genre;
import com.demo.entities.Movie;
import com.demo.repositories.MovieRepository;




@SpringBootTest
public class MovieRepositoryTest {



@Autowired
MovieRepository movieRepository;

@Test
void contextLoads() {
}

@Test
public void saveMovie( ) {
Movie movie = new Movie();
movie.setTitle("ABC");
movie.setDescription("ABCDEFG");
movie.setDailyrate(20);
movie.setNumberofstock(10);

Genre genre1 = new Genre();
genre1.setName("Horror");

Genre genre2 = new Genre();
genre2.setName("Comedy");

movie.addGenre(genre1);
movie.addGenre(genre2);

movieRepository.save(movie);
}
}
