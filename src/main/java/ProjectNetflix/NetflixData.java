package ProjectNetflix;


public class NetflixData {

    private String movieTitle;
    private String genre;
    private String director;
    private int releaseYear;
    private double rating;
    private int duration;

    // Constructor
    public NetflixData(String movieTitle, String genre, String director, int releaseYear, double rating, int duration) {
        this.movieTitle = movieTitle;
        this.genre = genre;
        this.director = director;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.duration = duration;
    }

    // Getters and Setters
    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    // Method to display movie information
    public void displayMovieInfo() {
        System.out.println("Title: " + movieTitle);
        System.out.println("Genre: " + genre);
        System.out.println("Director: " + director);
        System.out.println("Release Year: " + releaseYear);
        System.out.println("Rating: " + rating + "/10");
        System.out.println("Duration: " + duration + " minutes");
    }




}
