package pl.pjatk.movies.domain;

import javax.persistence.*;

@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private Genres genre;

    public Movie(Integer id, String title, String description, Genres genre) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.genre = genre;
    }

    public Movie() {
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Enum getGenre() {
        return genre;
    }
}
