package pl.pjatk.movies.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiOperation(value = "Get all movies", notes = "Retrieve all movies from the database")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Movie[].class),
            @ApiResponse(code = 400, message = "Bad request", response = Movie[].class)
    })
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAll());
    }

    @GetMapping("/getexample")
    @ApiOperation(value = "Get example movie", notes = "Add example movie with example properties")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Movie.class),
    })
    public ResponseEntity<Movie> getExampleMovie() {
        return ResponseEntity.ok(movieService.getExampleMovie());
    }

    @GetMapping("/movies/{id}")
    @ApiOperation(value = "Get movie by id", notes = "Retrieve a movie with given id from the database")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Movie.class),
            @ApiResponse(code = 400, message = "Bad request", response = Movie.class)
    })
    public ResponseEntity<Movie> getMovieById(@PathVariable Integer id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @PostMapping("/movies")
    @ApiOperation(value = "Add movie", notes = "Add a movie with given body to the database")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Movie.class),
            @ApiResponse(code = 400, message = "Bad request", response = Movie.class)
    })
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.addMovie(movie));
    }

    @PutMapping("/movies/{id}")
    @ApiOperation(value = "Update movie", notes = "Update a movie with given id by taking given body")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Movie.class),
            @ApiResponse(code = 400, message = "Bad request", response = Movie.class)
    })
    public ResponseEntity<Movie> updateMovie(@PathVariable Integer id, @RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.updateMovie(id, movie));
    }

    @DeleteMapping("/movies/{id}")
    @ApiOperation(value = "Delete movie", notes = "Delete a movie with given id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Void.class),
            @ApiResponse(code = 400, message = "Bad request", response = Void.class)
    })
    public ResponseEntity<Void> deleteMovie(@PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/makeAvailable/{id}")
    @ApiOperation(value = "Make a movie available", notes = "Make a movie with given id available")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Movie.class),
            @ApiResponse(code = 400, message = "Bad request", response = Movie.class)
    })
    public ResponseEntity<Movie> makeAvailable(@PathVariable Integer id) {
        return ResponseEntity.ok(movieService.makeAvailable(id));
    }

    @PutMapping("/makeNotAvailable/{id}")
    @ApiOperation(value = "Make a movie not available", notes = "Make a movie with given id not available")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Movie.class),
            @ApiResponse(code = 400, message = "Bad request", response = Movie.class)
    })
    public ResponseEntity<Movie> makeNotAvailable(@PathVariable Integer id) {
        return ResponseEntity.ok(movieService.makeNotAvailable(id));
    }
}

