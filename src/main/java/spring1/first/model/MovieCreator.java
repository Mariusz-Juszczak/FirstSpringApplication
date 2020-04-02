package spring1.first.model;

import java.time.LocalDate;

public class MovieCreator {

    private String title;
    private LocalDate date;
    private String genre;

    public MovieCreator(String title, LocalDate date, String genre) {
        this.title = title;
        this.date = date;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}