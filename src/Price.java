/**
* Nadeem Abdul Hamid, 2025.
*/

import java.math.BigDecimal;

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
     * Produces a JSON object representation of this price
     */
    public String toJSONString() {
    	if (isOnSale()) {
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
	
}
