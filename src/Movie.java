/**
* Nadeem Abdul Hamid, 2025.
*/

import java.util.Objects;

import org.json.JSONObject;

/**
* Represents a video item in our media store.
*/
public class Movie extends AbsItem {
    String starring;
    String directedBy;

    public Movie(int id, String title, String description, int year, String starring, String directedBy, IPrice price,
                     ILo<String> tags, Rating rating) {
        super(id, title, description, year, price, tags, rating);
        this.starring = starring;
        this.directedBy = directedBy;
    }

    public Movie(int id, String title, String description, int year, String starring, String directedBy, int salePrice, int listPrice, String discount,
            String tags, double ratingAverage, int ratingCount) {
        this(id, title, description, year, starring, directedBy, buildPrice(salePrice, listPrice, discount), StringHelpers.split(tags, ','), new Rating(ratingAverage, ratingCount));
    }

    @Override
    protected JSONObject toJSONObject() {
        return super.toJSONObject()
                    .put("type", "video")
                    .put("starring", this.starring)
                    .put("directed-by", this.directedBy);
    }

    @Override
    public boolean contains(String text) {
        String lowerText = text.toLowerCase();
        return super.contains(text) 
                    || this.starring.toLowerCase().contains(lowerText) || this.directedBy.toLowerCase().contains(lowerText);
    }

    // AUTO-GENERATED: DO NOT EDIT BELOW

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(starring, directedBy);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (!(obj instanceof Movie))
            return false;
        Movie other = (Movie) obj;
        return Objects.equals(starring, other.starring) && Objects.equals(directedBy, other.directedBy);
    }

    @Override
    public String toString() {
        return "Movie [starring=" + starring + ", directedBy=" + directedBy + ", toString()=" + super.toString() + "]";
    }

}
