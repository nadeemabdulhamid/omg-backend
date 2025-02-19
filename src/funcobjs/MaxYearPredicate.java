package funcobjs;
/**
 * Nadeem Abdul Hamid, 2025.
 */

import java.util.function.Predicate;
import media.IMedia;
 
public class MaxYearPredicate implements Predicate<IMedia> {
    int maxYear;
        
    public MaxYearPredicate(int maxYear) {
        this.maxYear = maxYear;
    }
 
    @Override
    public boolean test(IMedia med) {
        return med.getYear() <= this.maxYear;
    }
}
