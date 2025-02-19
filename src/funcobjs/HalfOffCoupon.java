package funcobjs;
/**
 * Nadeem Abdul Hamid, 2025.
 */

import java.util.List;
import media.IMedia;

public class HalfOffCoupon implements ICoupon {
    public int calculateTotal(List<IMedia> items) {
        int total = 0;
        for (IMedia item : items) {
            if (item.isOnSale()) {
                total += item.salePrice();
            } else {
                total += item.salePrice() / 2;
            }
        }
        return total;
    }
}
