package funcobjs;
/**
 * Nadeem Abdul Hamid, 2025.
 */

import java.util.List;
import media.IMedia;

public class HalfOffCoupon extends NoDiscountCoupon {
    public int calculateTotal(List<IMedia> items) {
        return super.calculateTotal(items) / 2;
    }
}
