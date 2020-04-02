package spring1.first.controller;

import spring1.first.model.Genre;
import spring1.first.model.Movie;
import spring1.first.repository.GenreRepository;
import spring1.first.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements ApplicationRunner {

    private MovieRepository movieRepository;
    private GenreRepository genreRepository;

    @Autowired
    public DataLoader(MovieRepository movieRepository, GenreRepository genreRepository) {
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Genre fantasy = new Genre("Fantasy", "Imagined movie which took place long time ago");
        Genre drama = new Genre("Drama", "Sad story which makes you sad");
        genreRepository.save(fantasy);
        genreRepository.save(drama);

        movieRepository.save(new Movie("LOTR", fantasy, LocalDate.now()));
        movieRepository.save(new Movie("God Father", drama, LocalDate.parse("2010-04-02")));
        movieRepository.save(new Movie("American Beauty", drama, LocalDate.of(2012, 1, 4)));
    }
}