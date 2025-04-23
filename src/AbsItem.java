/*
 * Nadeem Abdul Hamid, 2025.
 */

import java.util.Objects;

import org.json.JSONObject;

/** 
* Represents abstract commonalities between media items. 
*/
public abstract class AbsItem implements IMedia {
    protected int id;
    protected String title;
    protected String description;
    protected int year;
    protected IPrice price;
    protected ILoS tags;
    protected Rating rating;
    
    public AbsItem(int id, String title, String description, int year, IPrice price, ILoS tags, Rating rating) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.year = year;
        this.price = price;
        this.tags = tags;
        this.rating = rating;
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
    
    /**
     * Return the ID of this media item.
     */
    @Override
    public int getId() {
        return this.id;
    }
    
    /**
     * Return the description of this media item.
     */
    public String getDescription() {
        return this.description;
    }
    
    /**
     * Produce the tags for this audio item
     */
    @Override
    public ILoS getTags() { 
        return this.tags;
    }
    
    /**
     * Return a truncated version of the description of this media item.
     */
    public String getShortDescription() {
        return this.description.substring(0, Math.min(15, this.description.length())) + "...";
    }
    
    /** Produce true if this media item contains the given text in 
        any of its textual fields (ignoring capitalization) 
    */
    @Override
    public boolean contains(String text) {
        String lowerText = text.toLowerCase();
        return this.title.toLowerCase().contains(lowerText) || this.description.toLowerCase().contains(lowerText);
    }
    
    /**
    * Builds a JSONObject with key/values for the common fields of this media item
    */
    protected JSONObject toJSONObject() {
        return this.rating.addToJSONObject(
        new JSONObject()
        .put("id", this.id)
        .put("title", this.title)
        .put("description-full", this.description)
        .put("description-short", this.getShortDescription())
        .put("info-line", Integer.toString(this.year))
        .put("price", this.price.toJSONString())
        .put("tags", this.tags.asJSONList()));
    }
    
    /**
    * Return a JSON string representation of this media item.
    */
    @Override
    public String toJSONString() {
        return this.toJSONObject().toString();
    }
    
    
    // AUTO-GENERATED: DO NOT EDIT BELOW
    
    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, year, price, tags, rating);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
        return true;
        if (!(obj instanceof AbsItem))
        return false;
        AbsItem other = (AbsItem) obj;
        return id == other.id && Objects.equals(title, other.title) && Objects.equals(description, other.description)
        && year == other.year && Objects.equals(price, other.price) && Objects.equals(tags, other.tags)
        && Objects.equals(rating, other.rating);
    }
    
    @Override
    public String toString() {
        return "AbsItem [id=" + id + ", title=" + title + ", description=" + description + ", year=" + year + ", price="
        + price + ", tags=" + tags + ", rating=" + rating + "]";
    }
    
    
}
