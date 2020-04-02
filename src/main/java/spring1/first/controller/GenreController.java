package spring1.first.controller;

import spring1.first.model.Genre;
import spring1.first.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class GenreController {

    private GenreRepository genreRepository;

    @Autowired
    public GenreController(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @GetMapping("/genres")
    public List<Genre> getGenres(
            @RequestParam("name") Optional<String> name) {
        if (name.isPresent()) {
            return genreRepository.findAllByName(name.get());
        } else {
            return genreRepository.findAll();
        }
    }
}