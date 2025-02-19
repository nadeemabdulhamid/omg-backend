package funcobjs;
/**
 * Nadeem Abdul Hamid, 2025.
 */

import java.util.function.Predicate;
import media.IMedia;
 
public class MaxPricePredicate implements Predicate<IMedia> {
    int maxPrice;
        
    public MaxPricePredicate(int maxPrice) {
        this.maxPrice = maxPrice;
    }
 
    @Override
    public boolean test(IMedia med) {
        return med.salePrice() <= this.maxPrice;
    }
}
