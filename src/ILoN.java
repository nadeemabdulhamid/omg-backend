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
    public String asJSONList();

    /** Produce a single string with all the strings in this list quoted
     * if quote is true, and joined by the given separator. */ 
    public String join(String sep);

}
