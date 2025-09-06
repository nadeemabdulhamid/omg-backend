/**
* Nadeem Abdul Hamid, 2025.
*/


/**
 * Represents a price, in cents, of items in our media store.
 */
public class Price {
	
	public Price(int sale, int list, String discount) {
	}

	public Price(int sale) {
	}
	
	public boolean isOnSale() {
		return false;
	}

	public int getSalePrice() {
		return 0;
	}
	
    /**
     * Produce an updated version of this price with the 
     * list price multiplied by the given percentage.
     */
    public Price adjustPrice(int percent) {
        return this;
    }

    /**
     * Produces a JSON object representation of this price
     */
    public String toJSONString() {
		return "{ \"sale\" : \"$0.00\" }";
    }

    // AUTO-GENERATED: DO NOT EDIT BELOW

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Price";
	}
	
}
