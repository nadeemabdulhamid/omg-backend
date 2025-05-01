package media;
/**
 * Nadeem Abdul Hamid, 2025.
 */

import java.util.Objects;

import java.util.List;

/** 
 * Represents an audio item in our online media store.
 */
public class Audio extends AbsItem {
    String artist;
    int duration;		// seconds
    
    public Audio(int id, String title, String description, int year, String artist, int duration, IPrice price, List<String> tags, Rating rating) {
        super("audio", id, title, description, year, price, tags, rating);
        this.artist = artist;
        this.duration = duration;
    }
    
    public Audio(int id, String title, String description, int year, String artist, int duration, int salePrice, int listPrice, String discount, List<String> tags,
                    double ratingAverage, int ratingCount) {
        this(id, title, description, year, artist, duration, buildPrice(salePrice, listPrice, discount), 
                        tags, new Rating(ratingAverage, ratingCount));
    }
       
    /** Produce true if this media item contains the given text in 
    any of its textual fields */
    @Override
    public boolean contains(String text) {
        String lowerText = text.toLowerCase();
        return this.title.toLowerCase().contains(lowerText) || this.description.toLowerCase().contains(lowerText) || this.artist.toLowerCase().contains(lowerText);
    }

    /*
     * generate the info line for this audio item
     */
    private String infoLine() {
        return (this.duration/60) + " minutes " + (this.duration%60) + " seconds • " + this.year;
    }
    
    /**
    * Return a JSON string representation of this book.
    */
    @Override
    public String toJSONString() {
        return super.toJSONObject()
                .put("artist", this.artist)
                .put("info-line", infoLine())
                .toString();
    }
    
    // AUTO-GENERATED: DO NOT EDIT BELOW
    
    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, artist, duration, price, tags, rating);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
        return true;
        if (!(obj instanceof Audio))
        return false;
        Audio other = (Audio) obj;
        return id == other.id && Objects.equals(title, other.title)
        && Objects.equals(description, other.description) && Objects.equals(artist, other.artist)
        && duration == other.duration && Objects.equals(price, other.price)
        && Objects.equals(tags, other.tags) && Objects.equals(rating, other.rating);
    }
    
    @Override
    public String toString() {
        return "Audio [id=" + id + ", title=" + title + ", description=" + description + ", artist=" + artist
        + ", duration=" + duration + ", price=" + price + ", tags=" + tags + ", rating=" + rating + "]";
    }
    
}
