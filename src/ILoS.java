/**
 * Nadeem Abdul Hamid, 2025.
 */

/** 
 * Represents a list of strings.
 */
public interface ILoS {
    /** Produce a string representation of this list as a JSON array */
    public String asJSONList();

    /** Produce a single string with all the strings in this list quoted
     * if quote is true, and joined by the given separator. */ 
    public String join(String sep, boolean quote);

}
