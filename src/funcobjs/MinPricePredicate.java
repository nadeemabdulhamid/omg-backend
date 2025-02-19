package funcobjs;
/**
 * Nadeem Abdul Hamid, 2025.
 */

import java.util.function.Predicate;
import media.IMedia;
 
public class MinPricePredicate implements Predicate<IMedia> {
    int minPrice;
        
    public MinPricePredicate(int minPrice) {
        this.minPrice = minPrice;
    }
 
    @Override
    public boolean test(IMedia med) {
        return med.salePrice() >= this.minPrice;
    }
}
