/**
* Nadeem Abdul Hamid, 2025.
*/

import java.util.Objects;

/**
* Represents a video item in our media store.
*/
public class Movie extends AbsItem {
    String starring;
    String directedBy;

    public Movie(int id, String title, String description, String starring, String directedBy, IPrice price,
            ILoS tags, Rating rating) {
        super(id, title, description, price, tags, rating);
        this.starring = starring;
        this.directedBy = directedBy;
    }

    public Movie(int id, String title, String description, String starring, String directedBy, int salePrice, int listPrice, String discount,
                String tags, double ratingAverage, int ratingCount) {
        this(id, title, description, starring, directedBy, new DiscountPrice(salePrice, listPrice, discount), StringHelpers.split(tags, ','), new Rating(ratingAverage, ratingCount));
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
                + StringHelpers.keyValuePair("tags", this.tags.asJSONList(), false) + ", "
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
