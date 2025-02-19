package funcobjs;
/**
* Nadeem Abdul Hamid, 2025.
*/

import java.util.function.Predicate;

import media.IMedia;

/**
 * Represents a predicate on media items.
 */
public interface IMediaPredicate extends Predicate<IMedia> {
    // implicit abstract method from Predicate:
    // public boolean test(IMedia med);
}
