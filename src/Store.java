/**
 * Nadeem Abdul Hamid, 2025.
 */

/**
 * Represents our online media store, which keeps track of a few books
 * available for sale.
 */
public class Store {
	IMedia m1;
	IMedia m2;
	IMedia m3;
	
	public Store(IMedia m1, IMedia m2, IMedia m3) {
		this.m1 = m1;
		this.m2 = m2;
		this.m3 = m3;
	}
	
	/**
	 * Returns a string representation of a JSON array of the ids of all items
	 * in this store.
	 */
	public String catalog() {
		return "[" + m1.getId() + ", " + m2.getId() + ", " + m3.getId() + "]";
	}
	
	/**
	 * Returns a string representation of the JSON object for the item 
	 * with the given id.
	 */
	public String itemInfoAsJSON(int id) {
		if (m1.getId() == id) {
			return m1.toJSONString();
		} else if (m2.getId() == id) {
			return m2.toJSONString();
		} else if (m3.getId() == id) {
			return m3.toJSONString();
		} else {
			return "{}";
		}
	}
	
	// stub!
	public String tagCounts() {
		return "[ [\"fiction\", 1], [\"nonfiction\", 1], [\"textbook\", 1] ]";
	}
	
}
