package pl.pjatk.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pjatk.movies.domain.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
