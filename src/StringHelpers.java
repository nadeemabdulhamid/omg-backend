/**
 * Nadeem Abdul Hamid, 2025.
 */

import java.math.BigDecimal;

/**
 * A collection of helper methods for working with strings.
 */
public class StringHelpers {
    /**
     * Helper method to format a price in cents as a dollar amount
     */
	public static String formatAsDollars(int centsValue) {
		return "$" + new BigDecimal(centsValue).movePointLeft(2).toString();
	}

    /**
     * Adds quotes around a string.
     */
    public static String quote(String str) {
        return "\"" + str + "\"";
    }

    /**
     * Returns a key-value pair as a JSON string, with the key quoted and
     * the value string quoted if addQuote is true.
     */
    public static String keyValuePair(String key, String value, boolean addQuote) {
        if (addQuote) {
            return quote(key) + ": " + quote(value);
        } else {
            return quote(key) + ": " + value;
        }
    }

    /**
     * Returns a key-value pair as a JSON string, with the key and value quoted
     */
    public static String keyValuePair(String key, String value) {
        return keyValuePair(key, value, true);
    }

    /**
     * Returns a key-value pair as a JSON string, for an integer value.
     */
    public static String keyValuePair(String key, int value) {
        return keyValuePair(key, value, false);
    }

    /**
     * Returns a key-value pair as a JSON string, for an integer value
     * which is formatted as a dollar amount if formatAsDollars is true.
     */
    public static String keyValuePair(String key, int value, boolean formatAsDollars) {
        if (formatAsDollars) {
            return keyValuePair(key, formatAsDollars(value), true);
        } else {
            return keyValuePair(key, Integer.toString(value), false);
        }
    }

    /**
     * Split the given string into a list of substrings, separated by the
     * given character.
     */
    public static ILo<String> split(String text, char sep) {
        if (text.equals("")) {
            return new MTLo<>();
        } else {
            int pos = text.indexOf(sep);
            if (pos < 0) {
                return new ConsLo<>(text, new MTLo<>());
            } else {
                return new ConsLo<>(text.substring(0, pos), 
                                   split(text.substring(pos + 1), sep));
            }
        }
    }
}
