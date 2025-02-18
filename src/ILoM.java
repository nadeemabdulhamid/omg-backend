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
    public ILoS collectTags();

    /**
     * Return the range of years associated with all items in this list
     */
    public Range yearRange();
}

