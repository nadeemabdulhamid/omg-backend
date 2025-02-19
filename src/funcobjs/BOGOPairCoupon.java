package funcobjs;
/**
 * Nadeem Abdul Hamid, 2025.
 */

import java.util.List;
import media.IMedia;

/** 
 * If there are only two items of the same type in the cart,
 * then the lesser priced item is free.
 * Otherwise, the coupon doesn't apply.
 */
public class BOGOPairCoupon extends NoDiscountCoupon {
    public int calculateTotal(List<IMedia> items) {
        if (items.size() == 2 && items.get(1).typeMatches(items.get(0).getType())) {
            return Math.max(items.get(0).salePrice(), items.get(1).salePrice());
        } else {
            return super.calculateTotal(items);
        }
    }
}
