package spring1.first.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring1.first.model.Genre;

import java.util.List;
import java.util.Optional;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Long> {

    List<Genre> findAll();

    List<Genre> findAllByName(String name);

    Optional<Genre> findGenreByName(String name);

    Genre save(Genre genre);
}