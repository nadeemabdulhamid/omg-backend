package media;
/**
* Nadeem Abdul Hamid, 2025.
*/

import java.math.BigDecimal;

/**
 * Represents a price of items in our media store.
 */
public interface IPrice {
    /** Does this price represent a discount on the list price */
    public boolean isOnSale();

    /** Return the sale price of the item */
    public int getSalePrice();

    /** Produces a JSON data representation of this price */
    public Object toJSON();

    /** Produce an updated version of this price with the 
     *  list price multiplied by the given percentage.
     */
    public IPrice adjustPrice(int percent);

    /**
     * Helper method to format a price in cents as a dollar amount
     */
	default public String formatAsDollars(int centsValue) {
		return "$" + new BigDecimal(centsValue).movePointLeft(2).toString();
	}
}
