/**
* Nadeem Abdul Hamid, 2025.
*/

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Represents a price, in cents, of items in our media store.
 */
public class Price {
	int sale;
	int list;
	String discount;
	
	public Price(int sale, int list, String discount) {
		this.sale = sale;
		this.list = list;
		this.discount = discount;
	}
	
    /**
     * An item is on sale if the sale price is less than the list price.
     */
	public boolean isOnSale() {
		return this.sale < this.list;
	}

	/**
	 * Return the sale price of the item.
	 */
	public int getSalePrice() {
		return this.sale;
	}
	
    /**
     * Produce an updated version of this price with the 
     * list price multiplied by the given percentage.
     */
    public Price adjustPrice(int percent) {
        return new Price(this.sale * percent / 100, this.list * percent / 100, this.discount);
    }

    /**
     * Produces a JSON object representation of this price
     */
    public String toJSONString() {
    	if (this.isOnSale()) {
    		return "{ \"sale\" : " + this.formatAsDollars(sale) + ", " +
    				  "\"list\" : " + this.formatAsDollars(list) + ", " +
    				  "\"discount\" : \"" + this.discount + "\" }";
    	} else {
    		return this.formatAsDollars(sale);
    	}
    }
	
    /**
     * Helper method to format a price in cents as a dollar amount, quoted
     * as a JSON string.
     */
	public String formatAsDollars(int centsValue) {
		return "\"$" + new BigDecimal(centsValue).movePointLeft(2).toString() + "\"";
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
		if (!(obj instanceof Price))
			return false;
		Price other = (Price) obj;
		return sale == other.sale && list == other.list && Objects.equals(discount, other.discount);
	}

	@Override
	public String toString() {
		return "Price [sale=" + sale + ", list=" + list + ", discount=" + discount + "]";
	}
	
	
}
