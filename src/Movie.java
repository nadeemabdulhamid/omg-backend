/**
* Nadeem Abdul Hamid, 2025.
*/

import java.util.Objects;

/**
* Represents a video item in our media store.
*/
public class Movie implements IMedia {
    int id;
    String title;
    String description;
    String starring;
    String directedBy;
    Price price;
    String genre;
    Rating rating;

    public Movie(int id, String title, String description, String starring, String directedBy, Price price,
            String genre, Rating rating) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.starring = starring;
        this.directedBy = directedBy;
        this.price = price;
        this.genre = genre;
        this.rating = rating;
    }

    public Movie(int id, String title, String description, String starring, String directedBy, int salePrice, int listPrice, String discount,
            String genre, double ratingAverage, int ratingCount) {
        this(id, title, description, starring, directedBy, new Price(salePrice, listPrice, discount), genre, new Rating(ratingAverage, ratingCount));
    }

    /**
     * Return the ID of this movie.
     */
    @Override
    public int getId() {
        return this.id;
    }

    /**
     * Return the sale price of this movie.
     */
    @Override
    public int salePrice() {
        return this.price.getSalePrice();
    }

    /**
     * Return a truncated version of the description of this book.
     */
    public String getShortDescription() {
        return this.description.substring(0, Math.min(15, this.description.length())) + "...";
    }

    /**
     * Return the string representation of a JSON object for this movie.
     */
    @Override
    public String toJSONString() {
        return "{ "
                + StringHelpers.keyValuePair("type", "video") + ", "
                + StringHelpers.keyValuePair("id", getId()) + ", "
                + StringHelpers.keyValuePair("title", this.title) + ", "
                + StringHelpers.keyValuePair("description-full", this.description) + ", "
                + StringHelpers.keyValuePair("description-short", this.getShortDescription()) + ", "
                + StringHelpers.keyValuePair("starring", this.starring) + ", "
                + StringHelpers.keyValuePair("directed-by", this.directedBy) + ", "
                + StringHelpers.keyValuePair("price", this.price.toJSONString(), false) + ", "
                + StringHelpers.keyValuePair("tags", this.genre) + ", "
                + this.rating.toJSONStringFragment()
                + " }";
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
        return Objects.hash(id, title, description, starring, directedBy, price, genre, rating);
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
                && Objects.equals(price, other.price) && Objects.equals(genre, other.genre)
                && Objects.equals(rating, other.rating);
    }

    @Override
    public String toString() {
        return "Movie [id=" + id + ", title=" + title + ", description=" + description + ", starring=" + starring
                + ", directedBy=" + directedBy + ", price=" + price + ", genre=" + genre + ", rating=" + rating + "]";
    }

}
