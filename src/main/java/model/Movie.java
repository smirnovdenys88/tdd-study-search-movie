package model;

public class Movie {
    private String title;
    private String director;
    private int year;

    public Movie(String title, String director, int year) {
        this.title = title;
        this.director = director;
        this.year = year;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDirector() {
        return director;
    }

    public int getYear() {
        return this.year;
    }
}
