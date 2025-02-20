package funcobjs;
/**
 * Nadeem Abdul Hamid, 2025.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import media.IMedia;
 
/**
 * If there are four or more items in the cart,
 * then apply a 20% discount to the 3 oldest items 
 * (earliest years), and a 10% discount to the next
 * 3 oldest items.
 * If there are less than 4 items in the cart,
 * then there is no discount applied from this coupon.
 */
public class OldiesGoldiesCoupon extends NoDiscountCoupon {
    public int calculateTotal(List<IMedia> items) {
        if (items.size() < 4) {
            return super.calculateTotal(items);
        }

        List<IMedia> sortedItems = new ArrayList<>(items);  // make a copy
        Collections.sort(sortedItems, (a, b) -> Integer.compare(a.getYear(), b.getYear()));
        int total = 0;
        int count = 0;
        for (IMedia item : sortedItems) {
            if (count < 3) {
                total += item.salePrice() * 0.8;
            } else if (count < 6) {
                total += item.salePrice() * 0.9;
            } else {
                total += item.salePrice();
            }
            count++;
        }
        return total;
    }
}
