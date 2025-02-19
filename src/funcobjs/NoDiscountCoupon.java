package funcobjs;
/**
 * Nadeem Abdul Hamid, 2025.
 */

import java.util.List;
import media.IMedia;

public class NoDiscountCoupon implements ICoupon {
    public int calculateTotal(List<IMedia> items) {
        int total = 0;
        for (IMedia item : items) {
            total += item.salePrice();
        }
        return total;
    }
}
