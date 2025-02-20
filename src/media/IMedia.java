package media;
/**
 * Nadeem Abdul Hamid, 2025.
 */

import java.util.List;

/**
 * Represents a media item in our online store.
 */
public interface IMedia extends Comparable<IMedia> {

    /** Produce this media item's unique id */
    public int getId();

    /** Produce the type of this media item */
    public String getType();

    /** Produce the sale price of this media item */
	public int salePrice();

    /** Is the price of this media item discounted */
    public boolean isOnSale();

    /** Produce the string representation of a JSON object for this item */
	public String toJSONString();

    /** Produce true if this media item contains the given text in 
        any of its textual fields */
	public boolean contains(String text);

    /**
     * Produce the tags for this media item
     */
    public List<String> getTags();

    /**
     * Produce the year of this media item
     */
    public int getYear();

    /**
     * Produce true if the type of this media is one
     * of the given comma-separated list of types
     */
    public boolean typeMatches(String tys);

    /**
     * Produce true if this media item has 
     * any of the given tags
     */
    public boolean hasAnyTag(List<String> tags);

}
