package funcobjs;
/**
 * Nadeem Abdul Hamid, 2025.
 */

import java.util.List;
import media.IMedia;

/**
 * Represents a function object that calculates the 
 * total cost of items in a shopping cart while
 * applying a coupon offer.
 */
public interface ICoupon {
    public int calculateTotal(List<IMedia> items);
}
