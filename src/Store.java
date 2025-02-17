/**
 * Nadeem Abdul Hamid, 2025.
 */

/**
 * Represents our online media store, which keeps track of a few books
 * available for sale.
 */
public class Store {
	ILoM items;
	
	public Store(ILoM items) {
		this.items = items;
	}

	/**
	 * Returns a string representation of a JSON array of the ids of all items
	 * in this store.
	 */
	public String catalog() {
		return "[" + this.items.collectIds() + "]";
	}
	
	/**
	 * Returns a string representation of the JSON object for the item 
	 * with the given id.
	 */
	public String itemInfoAsJSON(int id) {
		return this.items.infoAsJSON(id);
	}
	
	// stub!
	public String tagCounts() {
		return "[ [\"fiction\", 1], [\"nonfiction\", 1], [\"textbook\", 1] ]";
	}
	
}
