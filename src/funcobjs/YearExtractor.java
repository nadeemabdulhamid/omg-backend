package funcobjs;
/**
 * Nadeem Abdul Hamid, 2025.
 */

import media.IMedia;

/**
 * Extracts the year associated with the publication or
 * production of a media item.
 */
public class YearExtractor implements IIntExtractor {
    public int extract(IMedia med) {
        return med.getYear();
    }
}
