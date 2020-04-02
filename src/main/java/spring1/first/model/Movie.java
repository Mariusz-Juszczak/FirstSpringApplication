package spring1.first.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Movie {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    Genre genre;

    public Movie() {
    }

    public Movie(String title, Genre genre, LocalDate date) {
        this.title = title;
        this.genre = genre;
        this.date = date;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
