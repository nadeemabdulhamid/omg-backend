/**
 * Nadeem Abdul Hamid, 2025.
 */

/**
 * Represents our online media store, which keeps track of a few books
 * available for sale.
 */
public class Store {
	Book b1;
	Book b2;
	Book b3;
	
	public Store(Book b1, Book b2, Book b3) {
		this.b1 = b1;
		this.b2 = b2;
		this.b3 = b3;
	}
	
	public String catalog() {
		return "[" + b1.getId() + ", " + b2.getId() + ", " + b3.getId() + "]";
	}
	
	public String itemInfoAsJSON(int id) {
		if (b1.getId() == id) {
			return b1.toJSONString();
		} else if (b2.getId() == id) {
			return b2.toJSONString();
		} else if (b3.getId() == id) {
			return b3.toJSONString();
		} else {
			return "{}";
		}
	}
	
	// stub!
	public String tagCounts() {
		return "[ [\"fiction\", 1], [\"nonfiction\", 1], [\"textbook\", 1] ]";
	}
	
}
