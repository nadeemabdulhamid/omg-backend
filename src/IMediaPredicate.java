/**
* Nadeem Abdul Hamid, 2025.
*/

import java.util.function.Predicate;

/**
 * Represents a predicate on media items.
 */
public interface IMediaPredicate extends Predicate<IMedia> {
    // implicit abstract method from Predicate:
    // public boolean test(IMedia med);
}
