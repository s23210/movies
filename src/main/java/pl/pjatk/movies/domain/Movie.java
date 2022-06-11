package pl.pjatk.movies.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "movie")
@ApiModel(value = "movie", description = "Movie from database")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Unique id of the movie", required = true)
    private Integer id;
    @ApiModelProperty(value = "Title of the movie", required = true)
    private String title;
    @ApiModelProperty(value = "Description of the movie", required = true)
    private String description;
    @Enumerated(EnumType.STRING)
    @ApiModelProperty(value = "Genre of the movie", required = true)
    private Genres genre;
    @ApiModelProperty(value = "Availability of the movie")
    private Boolean isAvailable = false;

    public Movie(Integer id, String title, String description, Genres genre, Boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.isAvailable = isAvailable;
    }

    public Movie() {
    }

    public Movie(Integer id, String title, String description, Genres genre) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.genre = genre;
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

    public Genres getGenre() {
        return genre;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGenre(Genres genre) {
        this.genre = genre;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }
}
