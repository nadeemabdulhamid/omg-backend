/**
* Nadeem Abdul Hamid, 2025.
*/

import java.util.Objects;
import org.json.JSONObject;

/**
 * Represents a price, in cents, of items in our media store with a 
 * discount off the normal list price.
 */
public class DiscountPrice implements IPrice {
	int sale;
	int list;
	String discount;
	
	public DiscountPrice(int sale, int list, String discount) {
		this.sale = sale;
		this.list = list;
		this.discount = discount;
	}
	
    /**
     * An item is on sale if the sale price is less than the list price.
     */
    @Override
	public boolean isOnSale() {
		return this.sale < this.list;
	}

	/**
	 * Return the sale price of the item.
	 */
    @Override
	public int getSalePrice() {
		return this.sale;
	}
	
    /**
     * Produce an updated version of this price with the 
     * list price multiplied by the given percentage.
     */
    @Override
    public DiscountPrice adjustPrice(int percent) {
        return new DiscountPrice(this.sale * percent / 100, this.list * percent / 100, this.discount);
    }

    /** Produces a JSON data representation of this price */
    @Override
    public Object toJSON() {
    	if (this.isOnSale()) {
			return new JSONObject().put("sale", StringHelpers.formatAsDollars(this.sale)).put("list",StringHelpers.formatAsDollars(this.list)).put("discount", this.discount);
		} else {
			return StringHelpers.formatAsDollars(this.sale);
		}
	}
	
    // AUTO-GENERATED: DO NOT EDIT BELOW

	@Override
	public int hashCode() {
		return Objects.hash(sale, list, discount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof DiscountPrice))
			return false;
		DiscountPrice other = (DiscountPrice) obj;
		return sale == other.sale && list == other.list && Objects.equals(discount, other.discount);
	}

	@Override
	public String toString() {
		return "Price [sale=" + sale + ", list=" + list + ", discount=" + discount + "]";
	}
	
	
}
