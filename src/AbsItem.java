/**
 * Nadeem Abdul Hamid, 2025.
 */

import org.json.JSONObject;

public abstract class AbsItem implements IMedia {
    int id;
    String title;
    String description;
    int year;
    IPrice price;
    ILoS tags;
    Rating rating;

    public AbsItem(int id, String title, String description, int year, IPrice price, ILoS tags, Rating rating) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.year = year;
        this.price = price;
        this.tags = tags;
        this.rating = rating;
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
    public ILoS getTags() { 
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
                    .put("id", this.id)
                    .put("title", this.title)
                    .put("description-full", this.description)
                    .put("description-short", this.getShortDescription())
                    .put("price", this.price.toJSON())
                    .put("tags", this.tags.asJSONList()));
    }


}
