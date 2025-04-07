/**
 * Nadeem Abdul Hamid, 2025.
 */

/**
 * Represents a media item in our online store.
 */
public interface IMedia {

    /** Produce this media item's unique id */
    public int getId();

    /** Produce the sale price of this media item */
	public int salePrice();

    /** Produce the string representation of a JSON object for this item */
	public String toJSONString();

    /** Produce true if this media item contains the given text in 
        any of its textual fields */
	public boolean contains(String text);

}
