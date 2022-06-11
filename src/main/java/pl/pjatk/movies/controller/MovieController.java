package pl.pjatk.movies.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.movies.domain.Movie;
import pl.pjatk.movies.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAll());
    }

    @GetMapping("/getexample")
    public ResponseEntity<Movie> getExampleMovie() {
        return ResponseEntity.ok(movieService.getExampleMovie());
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Integer id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.addMovie(movie));
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Integer id, @RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.updateMovie(id, movie));
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/makeAvailable/{id}")
    public ResponseEntity<Movie> makeAvailable(@PathVariable Integer id) {
        return ResponseEntity.ok(movieService.makeAvailable(id));
    }

    @PutMapping("/makeNotAvailable/{id}")
    public ResponseEntity<Movie> makeNotAvailable(@PathVariable Integer id) {
        return ResponseEntity.ok(movieService.makeNotAvailable(id));
    }
}

