package ca.evelyne.repository;

import ca.evelyne.domain.film.Movie;
import ca.evelyne.service.MovieService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

//@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MovieRepository.class)
public class MovieServiceTest {

    @Autowired
    MovieRepository movieRepository;

    @Test
    public void findMovieById() throws Exception    {
        int id = 2;
        MovieRepository movieRepository;
        MovieService movieService = new MovieService() ;
        ResponseEntity<Movie> byId = movieService.findById(id);
        String title = byId.getBody().getTitle();
        assertEquals("The Great Gatsby", title );
    }




}
