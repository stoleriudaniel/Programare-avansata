package laborator.models;

import java.util.Date;
import java.util.List;

public class Movie {
    private int id;
    private String title;
    private Date release_date;
    private int duration;
    private int score;
    private List<Genre> genres;
    private List<Actor> actors;
    private List<Director> directors;
    public Movie(){}

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public int getDuration() {
        return duration;
    }

    public int getScore() {
        return score;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void addActor(Actor actor)
    {
        actors.add(actor);
    }

    public void addDirector(Director director)
    {
        directors.add(director);
    }

    public void addGenre(Genre genre)
    {
        genres.add(genre);
    }
}
