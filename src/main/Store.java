package main;
/**
 * Nadeem Abdul Hamid, 2025.
 */

import java.util.*;
import java.util.*;
import java.util.function.Predicate;

import org.json.JSONArray;

import funcobjs.*;
import media.*;

/**
 * Represents our online media store, which keeps track of a few books
 * available for sale.
 */
public class Store {
	List<IMedia> items;		// catalog of items available in this store
	List<Integer> cart;		// list of item ids that are currently in the cart
	String coupon;	// coupon code for a discount applied to the cart, "" if none is applied, always in uppercase
	
	public Store(List<IMedia> items, List<Integer> cart, String coupon) {
		this.items = items;
		this.cart = cart;
		this.coupon = coupon;
	}

	public Store(List<IMedia> items) {
		this(items, new ArrayList<Integer>(), "");
	}

	/**
	 * Returns a string representation of a JSON array of the ids of all items
	 * in this store that satisfy the given predicate.
	 */
	public String catalog(Predicate<IMedia> pred) {
		JSONArray ids = new JSONArray();
		for (IMedia item : this.items) {
			if (pred.test(item)) {
				ids.put(item.getId());
			}
		}
		return ids.toString();
	}
	
	/*
	 * find the item with the given id
	 */
	public IMedia findItem(int id) {
		for (IMedia item : this.items) {
			if (item.getId() == id) {
				return item;
			}
		}
		return null;
	}

	/**
	 * Returns a string representation of the JSON object for the item 
	 * with the given id.
	 */
	public String itemInfoAsJSON(int id) {
		IMedia item = findItem(id);
		IMedia item = findItem(id);
		if (item == null) {
			return "";
		} else {
			return item.toJSONString();
		}
	}
	
	/*
	 * Collects all tags of all items in the store that satisfy the given predicate
	 */
	private List<String> collectTags(Predicate<IMedia> pred) {
		List<String> tags = new ArrayList<String>();
		for (IMedia item : this.items) {
			if (pred.test(item)) {
				tags.addAll(item.getTags());
			}
		}
		return tags;
	}

	/**
	 * Produces a JSON array of pairs (JSON array of a string and a number)
	 * representing the count of each tag in the store for all tags of all
	 * items.
	 */
	public String tagCounts() {
		JSONArray tallies = new JSONArray();
		List<String> alltags = collectTags(new MinPricePredicate(0));   // temporary
		Set<String> unique = new HashSet<String>(alltags);

		for (String tag : unique) {
			tallies.put(new JSONArray().put(tag).put(Collections.frequency(alltags, tag)));
		JSONArray tallies = new JSONArray();
		List<String> alltags = collectTags(new MinPricePredicate(0));   // temporary
		Set<String> unique = new HashSet<String>(alltags);

		for (String tag : unique) {
			tallies.put(new JSONArray().put(tag).put(Collections.frequency(alltags, tag)));
		}

		return tallies.toString();

		return tallies.toString();
	}
	
	/**
	 * Returns (JSON string) the number of items in the cart.
	 */
	public String cartSize() {
		return Integer.toString(cart.size());
	}

	/**
	 * Returns a JSON array of the ids of all items in the cart.
	 */
	public String cartList() {
		return new JSONArray(this.cart).toString();
	}

	/**
	 * Adds the given id to the cart.
	 * Produces "true" if successful, "false" if the item was
	 * already in the cart.
	 */
	public String addToCart(int id) {
		if (this.cart.contains(id)) {
			return "false";
		} else {
			this.cart.add(id);  
			return "true";
		}
	}

	/**
	 * Removes the given id from the cart.
	 * Returns "true" if the id was found otherwise
	 * "false" if the id is not in the cart.
	 */
	public String removeFromCart(int id) {
		if (!this.cart.contains(id)) {
			return "false";
		} else {
			this.cart.remove(Integer.valueOf(id));
			return "true";
		}
	}

	/**
	 * Returns the currently applied coupon as a JSON quoted string, "\"\""" if none.
	 */
	public String getCoupon() {
		return "\"" + this.coupon + "\"";
	}

	/**
	 * Applies the given coupon to the cart, as long as there isn't already
	 * a coupon applied. Coupon codes should be turned into all uppercase letters
	 * when they are applied.
	 * Returns "true" if successful, "false" if there was already a coupon applied.
	 */
	public String applyCoupon(String code) {
		if (this.coupon.equals("")) {
			this.coupon = code.toUpperCase();
			return "true";
		} else {
			return "false";
		}
	}
	
	/**
	 * Removes the currently applied coupon from the cart.
	 * Returns "false" if there was no coupon applied, "true" otherwise.
	 */
	public String removeCoupon(String code) {
		if (this.coupon.equals(code.toUpperCase())) {
			this.coupon = "";
			return "true";
		} else {
			return "false";
		}
	}

	/**
	 * Returns a JSON string representation of the range of 
	 * years of all items in the store that satisfy the
	 * given predicate.
	 */
	public String yearRangeAsJSON(Predicate<IMedia> pred) {
		return rangeAsJSON(pred, new YearExtractor());
	}

	/**
	 * Returns a JSON string representation of the range of 
	 * years of all items in the store that satisfy the
	 * given predicate.
	 */
	public String priceRangeAsJSON(Predicate<IMedia> pred) {
		return rangeAsJSON(pred, new PriceExtractor());
	}

	/**
	 * Returns a JSON string representation of the range of 
	 * items in this store that satisfy the given
	 * predicate, based on the extraction function.
	 */
	public String rangeAsJSON(Predicate<IMedia> pred, IIntExtractor obj) {
		List<Integer> vals = new ArrayList<>();
		for (IMedia item : this.items) {
			if (pred.test(item)) {
				vals.add(obj.extract(item));
			}
		}
		return new Range(Collections.min(vals), Collections.max(vals)).toJSONString();
		List<Integer> vals = new ArrayList<>();
		for (IMedia item : this.items) {
			if (pred.test(item)) {
				vals.add(obj.extract(item));
			}
		}
		return new Range(Collections.min(vals), Collections.max(vals)).toJSONString();
	}


	// AUTOGENERATED CODE BELOW

	@Override
	public int hashCode() {
		return Objects.hash(items, cart, coupon);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Store))
			return false;
		Store other = (Store) obj;
		return Objects.equals(items, other.items) && Objects.equals(cart, other.cart)
				&& Objects.equals(coupon, other.coupon);
	}

	@Override
	public String toString() {
		return "Store [items=" + items + ", cart=" + cart + ", coupon=" + coupon + "]";
	}
	
}
