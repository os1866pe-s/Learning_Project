package Inl2;

public class CD {

    private String artist;   // artist
    private String title;    // titel

    /**Creates a cd with and artist(artist) and a title(title).*/
    public CD(String artist, String title) {
        this.artist = artist;
        this.title = title;
    }

    /**Returns the name of the artist*/
    public String getArtist() {
        return artist;
    }

    /**Returns the title*/
    public String getTitle() {
        return title;
    }

    /**Returns a String which contains both the cd's artist and title.*/
    public String toString() {
        return artist + "   " + title;

    }
}
