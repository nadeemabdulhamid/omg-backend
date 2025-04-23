/*
 * Nadeem Abdul Hamid, 2025.
 */

 import java.util.Objects;
 
 import org.json.JSONObject;

 /** 
  * Represents an audio item in our online media store.
  */
 public class Audio extends AbsItem {
	private String artist;
	private int duration;		// seconds

    public Audio(int id, String title, String description, int year, String artist, int duration, IPrice price, ILoS tags, Rating rating) {
        super(id, title, description, year, price, tags, rating);
        this.artist = artist;
        this.duration = duration;
    }

    public Audio(int id, String title, String description, int year, String artist, int duration, int salePrice, int listPrice, String discount, String tags,
                    double ratingAverage, int ratingCount) {
        this(id, title, description, year, artist, duration, buildPrice(salePrice, listPrice, discount), 
                    StringHelpers.split(tags, ','), new Rating(ratingAverage, ratingCount));
    }

    /** Produce true if this media item contains the given text in 
        any of its textual fields */
    @Override
    public boolean contains(String text) {
        String lowerText = text.toLowerCase();
        return super.contains(text) || this.artist.toLowerCase().contains(lowerText);
    }

    /* 
     * Generate the info line for this audio item
     */
    private String infoLine() {
        return (this.duration/60) + " minutes " + (this.duration%60) + " seconds - " + this.year;
    }

    @Override
    protected JSONObject toJSONObject() {
        return super.toJSONObject()
                    .put("type", "audio")
                    .put("artist", this.artist)
                    .put("info-line", this.infoLine());
    }


    // AUTO-GENERATED: DO NOT EDIT BELOW

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(artist, duration);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (!(obj instanceof Audio))
            return false;
        Audio other = (Audio) obj;
        return Objects.equals(artist, other.artist) && duration == other.duration;
    }

    @Override
    public String toString() {
        return "Audio [artist=" + artist + ", duration=" + duration + ", toString()=" + super.toString() + "]";
    }

}
