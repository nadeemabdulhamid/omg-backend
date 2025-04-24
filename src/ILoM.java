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
	 * Returns a string representation of the JSON object for the item 
	 * with the given id in this list. If the item is not found, returns "".
     */
	public String infoAsJSON(int id);

}

