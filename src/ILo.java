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
    
    /** Produce a new list that is this list appended to that */
    public ILo<T> append(ILo<T> that);

    /** Produce a new list with only the first n elements of this list. */
    public ILo<T> take(int n);

    /** Produce the number of elements in this list that are equal() to the given one */
    public int count(T elt);

    /** Return the first element in this list; null if the list is empty */
    public T getFirst();

    /** Return true if this list is empty */
    default public boolean isEmpty() { return this.size() == 0; }
}
