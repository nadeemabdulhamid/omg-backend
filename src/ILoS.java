/**
 * Nadeem Abdul Hamid, 2025.
 */

import org.json.JSONArray;

/** 
 * Represents a list of strings.
 */
public interface ILoS {
    /** Produce a representation of this list as a JSON array */
    public JSONArray asJSONList();

    /**
     * Produce a new list that is this list append to all the
     * items in that.
     */
    public ILoS append(ILoS that);

    /**
     * Produce a new list with only the first n items of this list.
     */
    public ILoS take(int n);

}
