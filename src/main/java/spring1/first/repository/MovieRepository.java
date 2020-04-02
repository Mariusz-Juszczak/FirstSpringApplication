package spring1.first.repository;

import spring1.first.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {

    List<Movie> findAll();

    List<Movie> findMoviesByTitle(String title);

    List<Movie> findMoviesByGenre_Name(String genreName);

    List<Movie> findMoviesByTitleAndGenre_Name(String title, String genreName);

    Movie save(Movie movie);
}
