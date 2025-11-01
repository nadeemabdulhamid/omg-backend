package media;
/**
 * Nadeem Abdul Hamid, 2025.
 */

import org.json.*;
import java.util.List;

public abstract class AbsItem implements IMedia {
    String type;
    int id;
    String title;
    String description;
    int year;
    IPrice price;
    List<String> tags;
    Rating rating;

    public AbsItem(String type, int id, String title, String description, int year, IPrice price, List<String> tags, Rating rating) {
        this.type = type;
        this.id = id;
        this.title = title;
        this.description = description;
        this.year = year;
        this.price = price;
        this.tags = tags;
        this.rating = rating;
    }

    @SuppressWarnings("unchecked")
    public AbsItem(JSONObject obj) {
        this.type = obj.getString("type");
        this.id = obj.getInt("id");
        this.title = obj.getString("title");
        this.description = obj.getString("description");
        this.year = obj.getInt("year");
        this.price = buildPrice(obj.getInt("sale-price"), obj.getInt("list-price"), obj.getString("discount"));
        this.tags = (List<String>)(List<?>)obj.getJSONArray("tags").toList();   // weird casting needed to get around limitations of generics
        this.rating = new Rating(obj.getDouble("rating-average"), obj.getInt("rating-count"));
    }

    /**
     * Return the ID of this media item.
     */
    @Override
    public int getId() {
        return this.id;
    }

    /**
     * Return the year of this media item.
     */
    @Override
    public int getYear() {
        return this.year;
    }

    /**
     * Return the sale price of this media item.
     */
    @Override
    public int salePrice() {
        return this.price.getSalePrice();
    }

    /**
     * Produce the tags for this media item
     */
    public List<String> getTags() { 
        return this.tags;
    }

    /**
     * Return the description of this audio item.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Return a truncated version of the description of this media item.
     */
    public String getShortDescription() {
        return this.description.substring(0, Math.min(15, this.description.length())) + "...";
    }

    /**
     * Produce true if the type of this media is one
     * of the given comma-separated list of types
     */
    public boolean typeMatches(String tys) {
        return tys.contains(this.type);
    }

    /*
     * Builds a DiscountPrice object if the sale price is different from the list
     */
    protected static IPrice buildPrice(int salePrice, int listPrice, String discount) {
        if (salePrice == listPrice) {
            return new SimplePrice(salePrice);
        } else {
            return new DiscountPrice(salePrice, listPrice, discount);
        }
    }

    /*
     * Builds a JSONObject with key/values for the common 
     * fields of this media item
     */
    protected JSONObject toJSONObject() {
        return rating.addToJSONObject(
                    new JSONObject()
                    .put("type", this.type)
                    .put("id", this.id)
                    .put("title", this.title)
                    .put("description-full", this.description)
                    .put("description-short", this.getShortDescription())
                    .put("info-line", Integer.toString(this.year))
                    .put("price", this.price.toJSON())
                    .put("tags", new JSONArray(this.tags)));
    }


}
