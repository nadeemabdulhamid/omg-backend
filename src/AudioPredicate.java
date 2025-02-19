/**
 * Nadeem Abdul Hamid, 2025.
 */

public class AudioPredicate implements IMediaPredicate {
    public boolean test(IMedia med) {
        return med.typeMatches("audio");
    }
}
