package funcobjs;
/**
 * Nadeem Abdul Hamid, 2025.
 */

import media.IMedia;

public class After2000Predicate implements IMediaPredicate {
    public boolean test(IMedia med) {
        return med.getYear() > 2000;
    }
}
