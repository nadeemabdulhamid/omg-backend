import org.json.JSONArray;

/**
 * Nadeem Abdul Hamid, 2025.
 */

public interface ILo<T> {
    /** Produce the number of elements in this list. */
    public int size();

    /** Produce a string representation of this list as a JSON array */
    public JSONArray asJSONList();

    /** Determine if this list contains the given number */
    public boolean contains(T elt);

    /** Produce a copy of this list with the given number removed */
    public ILo<T> removeAll(T elt);
    
}

