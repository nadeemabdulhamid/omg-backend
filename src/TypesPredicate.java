/**
 * Nadeem Abdul Hamid, 2025.
 */

import java.util.function.Predicate;

/**
 * A class to represent a predicate that tests 
 * whether a given media item is of a certain type.
 */
public class TypesPredicate implements Predicate<IMedia> {
    String type;

    public TypesPredicate(String type) {
        this.type = type;
    }

    public boolean test(IMedia med) {
        return med.typeMatches(this.type);
    }
}
