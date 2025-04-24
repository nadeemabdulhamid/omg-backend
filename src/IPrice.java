/**
* Nadeem Abdul Hamid, 2025.
*/


/**
 * Represents a price of items in our media store.
 */
public interface IPrice {
    /** Does this price represent a discount on the list price */
    public boolean isOnSale();

    /** Return the sale price of the item */
    public int getSalePrice();

    /** Produces a JSON object representation of this price */
    public String toJSONString();

    /** Produce an updated version of this price with the 
     *  list price multiplied by the given percentage.
     */
    public IPrice adjustPrice(int percent);

}

