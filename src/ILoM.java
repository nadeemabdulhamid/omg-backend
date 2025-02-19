/**
 * Nadeem Abdul Hamid, 2025.
 */

import java.util.function.Predicate;

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

    /**
     * Return the range of values baed on the given extractor 
     * applied to all items in this list
     */
    public Range range(IIntExtractor obj);

    /**
     * Produce a list of only the "print" media from this list
     */
    public ILoM onlyPrint();

    /**
     * Produce a list of only media published/produced after 
     * 2000 from this list
     */
	public ILoM after2000();

    /**
     * Produce a list of only media from this list that satisfy the given predicate
     */
    //public ILoM filter(IMediaPredicate pred);
    public ILoM filter(Predicate<IMedia> pred);
}

