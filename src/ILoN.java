/**
 * Nadeem Abdul Hamid, 2025.
 */

 import org.json.JSONArray;

public interface ILoN {
    /**
     * Produce the number of elements in this list.
     */
    public int size();

    /** Determine if this list contains the given number */
    public boolean contains(int n);

    /** Produce a copy of this list with the given number removed */
    public ILoN remove(int n);

    /** Produce a string representation of this list as a JSON array */
    public JSONArray asJSONList();

}
