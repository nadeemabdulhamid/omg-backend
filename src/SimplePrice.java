/**
* Nadeem Abdul Hamid, 2025.
*/

import java.util.Objects;

/**
 * Represents a price, in cents, of items in our media store
 */
public class SimplePrice implements IPrice {
    int value;

    public SimplePrice(int value) {
        this.value = value;
    }

    /** Does this price represent a discount on the list price */
    @Override
    public boolean isOnSale() {
        return false;
    }

    /** Return the sale price of the item */
    @Override
    public int getSalePrice() {
        return this.value;
    }

    /** Produces a JSON object representation of this price */
    @Override
    public String toJSONString() {
        return StringHelpers.quote(StringHelpers.formatAsDollars(value));
    }

    /** Produce an updated version of this price with the 
     *  list price multiplied by the given percentage.
     */
    @Override
    public SimplePrice adjustPrice(int percent) {
        return new SimplePrice(this.value * percent / 100);
    }


    // AUTO-GENERATED: DO NOT EDIT BELOW

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof SimplePrice))
            return false;
        SimplePrice other = (SimplePrice) obj;
        return value == other.value;
    }

    @Override
    public String toString() {
        return "SimplePrice [value=" + value + "]";
    }

}
