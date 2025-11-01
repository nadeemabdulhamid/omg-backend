package funcobjs;
/**
 * Nadeem Abdul Hamid, 2025.
 */

import java.util.function.Predicate;
import media.IMedia;
 
public class MinYearPredicate implements Predicate<IMedia> {
    int minYear;
        
    public MinYearPredicate(int minYear) {
        this.minYear = minYear;
    }
 
    @Override
    public boolean test(IMedia med) {
        return med.getYear() >= this.minYear;
    }
}
