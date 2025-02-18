/**
 * Nadeem Abdul Hamid, 2025.
 */

/** 
 * Represents a list of media in our store.
 */
public interface ILoM {

    /** 
     * Produces a comma-separated string of all the
     * ids of the media in this list.
     */
    public String collectIds();

    /**
	 * Returns the media item with the given id in this list.
     * Produces null if not found.
     */
	public IMedia findItem(int id);

    /**
     * Return a list of all tags of all items in this list
     */
    public ILo<String> collectTags();

    /**
     * Return the range of years associated with all items in this list
     */
    public Range yearRange();

    /**
     * Return the range of prices of all items in this list
     */
    public Range priceRange();

}

