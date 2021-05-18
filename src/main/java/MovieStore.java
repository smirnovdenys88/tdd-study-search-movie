import model.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MovieStore {
    private List<Movie> movies = new ArrayList<>();

    public void add(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> findByPartialTitle(String partialTitle) {
        return findBy(t -> t.getTitle().toUpperCase().contains(partialTitle.toUpperCase()));
    }

    public List<Movie> findByDirector(String director) {
        return findBy(m -> m.getDirector().contains(director));
    }

    public List<Movie> findByBetweenReleaseYear(int startYear, int endYear) {
        return findBy(m -> m.getYear() >= startYear && m.getYear() <= endYear);
    }

    private List<Movie> findBy(Predicate<Movie> predicate) {
        return movies.stream().filter(predicate).collect(Collectors.toList());
    }
}
