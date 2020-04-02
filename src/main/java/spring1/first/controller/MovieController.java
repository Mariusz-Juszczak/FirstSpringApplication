package spring1.first.controller;

import spring1.first.exceptions.DataNotFoundException;
import spring1.first.model.Genre;
import spring1.first.model.Movie;
import spring1.first.model.MovieCreator;
import spring1.first.repository.GenreRepository;
import spring1.first.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class MovieController {

    private MovieRepository movieRepository;
    private GenreRepository genreRepository;

    @Autowired
    public MovieController(MovieRepository movieRepository, GenreRepository genreRepository) {
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
    }

    @GetMapping("/movies")
    public List<Movie> getMovies(
            @RequestParam("title") Optional<String> title,
            @RequestParam("genre") Optional<String> genre) {

        if (title.isPresent() && !genre.isPresent()) {
            return movieRepository.findMoviesByTitle(title.get());
        } else if (!title.isPresent() && genre.isPresent()) {
            return movieRepository.findMoviesByGenre_Name(genre.get());
        } else if (title.isPresent() && genre.isPresent()) {
            return movieRepository.findMoviesByTitleAndGenre_Name(title.get(), genre.get());
        } else {
            return movieRepository.findAll();
        }
    }

    @PostMapping("/movies")
    public ResponseEntity<?> addMovies(@RequestBody MovieCreator creator) {
        String title = creator.getTitle();
        String genreName = creator.getGenre();
        LocalDate date = creator.getDate();

// stream option:
//                 Optional<Genre> genre1 = genreRepository
//                .findAll()
//                .stream()
//                .filter(gen -> gen.getName().equals(genreName))
//                .findFirst();

        Optional<Genre> genre = genreRepository.findGenreByName(genreName);

        if (genre.isPresent()) {
            Movie movie = new Movie(title, genre.get(), date);
            movieRepository.save(movie);

            return ResponseEntity
                    .ok(movie);
        } else {
            throw new DataNotFoundException();
// another possibility:
//                    return ResponseEntity
//                    .status(HttpStatus.BAD_REQUEST)
//                    .build();
        }
    }
}