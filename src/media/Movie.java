package media;
/**
* Nadeem Abdul Hamid, 2025.
*/

import java.util.List;
import java.util.Objects;

/**
* Represents a video item in our media store.
*/
public class Movie extends AbsItem {
    String starring;
    String directedBy;
    int minutes;
    String format;

    public Movie(int id, String title, String description, String imageURL, int year, String starring, String directedBy, int minutes, String format, IPrice price,
                     List<String> tags, Rating rating) {
        super("video", id, title, description, imageURL, year, price, tags, rating);
        this.starring = starring;
        this.directedBy = directedBy;
        this.minutes = minutes;
        this.format = format;
    }

    public Movie(int id, String title, String description, String imageURL, int year, String starring, String directedBy, int minutes, String format, 
                        int salePrice, int listPrice, String discount,
                        List<String> tags, double ratingAverage, int ratingCount) {
        this(id, title, description, imageURL, year, starring, directedBy, minutes, format, new DiscountPrice(salePrice, listPrice, discount), tags, new Rating(ratingAverage, ratingCount));
    }

    /*
     * generate the info line for this audio item
     */
    private String infoLine() {
        if (this.minutes%60 == 0) {
            return (this.minutes/60) + " hours • " + this.year;
        } else {
            return (this.minutes/60) + " hours " + (this.minutes%60) + " seconds • " + this.year;
        }
    }

    /**
     * Return the string representation of a JSON object for this movie.
     */
    @Override
    public String toJSONString() {
        return super.toJSONObject()
                .put("starring", this.starring)
                .put("directed-by", this.directedBy)
                .put("info-line", infoLine())
                .toString();
    }

    @Override
    public boolean contains(String text) {
        String lowerText = text.toLowerCase();
        return this.title.toLowerCase().contains(lowerText) || this.description.toLowerCase().contains(lowerText) 
                    || this.starring.toLowerCase().contains(lowerText) || this.directedBy.toLowerCase().contains(lowerText);
    }

    // AUTO-GENERATED: DO NOT EDIT BELOW

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, starring, directedBy, price, tags, rating);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Movie))
            return false;
        Movie other = (Movie) obj;
        return id == other.id && Objects.equals(title, other.title) && Objects.equals(description, other.description)
                && Objects.equals(starring, other.starring) && Objects.equals(directedBy, other.directedBy)
                && Objects.equals(price, other.price) && Objects.equals(tags, other.tags)
                && Objects.equals(rating, other.rating);
    }

    @Override
    public String toString() {
        return "Movie [id=" + id + ", title=" + title + ", description=" + description + ", starring=" + starring
                + ", directedBy=" + directedBy + ", price=" + price + ", tags=" + tags + ", rating=" + rating + "]";
    }

}
