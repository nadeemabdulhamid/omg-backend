/**
 * Nadeem Abdul Hamid, 2025.
 */

 import java.util.Objects;

 /** 
  * Represents an audio item in our online media store.
  */
 public class Audio implements IMedia {
    int id;
	String title;
    String description;
	String artist;
	int duration;		// seconds
	IPrice price;
	String kind;
    Rating rating;

    public Audio(int id, String title, String description, String artist, int duration, IPrice price, String kind, Rating rating) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.artist = artist;
        this.duration = duration;
        this.price = price;
        this.kind = kind;
        this.rating = rating;
    }

    public Audio(int id, String title, String description, String artist, int duration, int salePrice, int listPrice, String discount, String kind,
                    double ratingAverage, int ratingCount) {
        this(id, title, description, artist, duration, buildPrice(salePrice, listPrice, discount), kind, new Rating(ratingAverage, ratingCount));
    }

    /*
     * Builds a DiscountPrice object if the sale price is different from the list
     */
    private static IPrice buildPrice(int salePrice, int listPrice, String discount) {
        if (salePrice == listPrice) {
            return new SimplePrice(salePrice);
        } else {
            return new DiscountPrice(salePrice, listPrice, discount);
        }
    }

    /**
     * Return the ID of this audio item.
     */ 
    @Override
    public int getId() {
        return this.id;
    }

    /**
     * Return the description of this audio item.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Return a truncated version of the description of this audio item.
     */
    public String getShortDescription() {
        return this.description.substring(0, Math.min(15, this.description.length())) + "...";
    }

    /**
     * Return the sale price of this audio item.
     */
    @Override
    public int salePrice() {
        return this.price.getSalePrice();
    }

    /** Produce true if this media item contains the given text in 
        any of its textual fields */
    @Override
    public boolean contains(String text) {
        String lowerText = text.toLowerCase();
        return this.title.toLowerCase().contains(lowerText) || this.description.toLowerCase().contains(lowerText) || this.artist.toLowerCase().contains(lowerText);
    }

    /**
     * Return a JSON string representation of this book.
     */
    @Override
    public String toJSONString() {
        return "{ "
                + StringHelpers.keyValuePair("type", "audio") + ", "
                + StringHelpers.keyValuePair("id", getId()) + ", "
                + StringHelpers.keyValuePair("title", this.title) + ", "
                + StringHelpers.keyValuePair("description-full", this.description) + ", "
                + StringHelpers.keyValuePair("description-short", this.getShortDescription()) + ", "
                + StringHelpers.keyValuePair("artist", this.artist) + ", "
                + StringHelpers.keyValuePair("info-line", (this.duration/60) + " minutes " + (this.duration%60) + " seconds") + ", "
                + StringHelpers.keyValuePair("price", this.price.toJSONString(), false) + ", "
                + StringHelpers.keyValuePair("tags", this.kind) + ", "
                + this.rating.toJSONStringFragment()
                + " }";
    }

    // AUTO-GENERATED: DO NOT EDIT BELOW

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, artist, duration, price, kind, rating);
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
                && Objects.equals(kind, other.kind) && Objects.equals(rating, other.rating);
    }

    @Override
    public String toString() {
        return "Audio [id=" + id + ", title=" + title + ", description=" + description + ", artist=" + artist
                + ", duration=" + duration + ", price=" + price + ", kind=" + kind + ", rating=" + rating + "]";
    }

}
