import model.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class MovieStoreTest {

    private final MovieStore movieStore = new MovieStore();

    private final Movie harryPotter = new Movie("Harry Potter", "Rowling", 1999);
    private final Movie shawshankRedemption = new Movie("Shawshank Redemption", "Bob", 2000);
    private final Movie starTrek = new Movie("Star Trek", "Shwimmer", 2003);
    private final Movie starWars = new Movie("STAR Wars", "Shwimmer", 2001);
    private final Movie takeThat = new Movie("Take That", "Shwimmer", 1996);

    @Before
    public void setUp() throws Exception {
        movieStore.add(harryPotter);
        movieStore.add(starTrek);
        movieStore.add(starWars);
        movieStore.add(shawshankRedemption);
        movieStore.add(takeThat);
    }

    @Test
    public void returnsNoResultWhenNoTitlesPartiallyMatchSearch() throws Exception {
        MovieStore movieStore = new MovieStore();
        List<Movie> results = movieStore.findByPartialTitle("abc");
        assertThat(results.size(), is(0));
    }

    @Test
    public void findAMovieWhenTitleIsPartiallyMatchSearch() throws Exception {
        List<Movie> results = movieStore.findByPartialTitle("arry");
        assertThat(results.size(), is(1));
        assertThat(results, contains(harryPotter));
    }

    @Test
    public void findsMoviesWhenTitlesArePartiallyMatchSearchCaseInsensitive() throws Exception {
        List<Movie> results = movieStore.findByPartialTitle("tar");
        assertThat(results.size(), is(2));
        assertThat(results, containsInAnyOrder(starTrek, starWars));
    }

    @Test
    public void findsMoviesWhenDirectorExactlyMatches() throws Exception {
        List<Movie> results = movieStore.findByDirector("Shwimmer");
        assertThat(results.size(), is(3));
        assertThat(results, containsInAnyOrder(starTrek, starWars, takeThat));
    }

    @Test
    public void findsMoviesWhenReleaseYearBetweenTwoValues() throws Exception {
        List<Movie> results = movieStore.findByBetweenReleaseYear(1999,2002);
        assertThat(results.size(), is(3));
        assertThat(results, containsInAnyOrder(harryPotter, starWars, shawshankRedemption));
    }
}