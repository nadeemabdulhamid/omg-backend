/**
 * Nadeem Abdul Hamid, 2025.
 */

 import org.json.JSONArray;

 /** 
  * Represents a list of strings.
  */
 public interface ILoS {
     /** Produce a string representation of this list as a JSON array */
     public JSONArray asJSONList();
 
     /** Produce a single string with all the strings in this list quoted
      * if quote is true, and joined by the given separator. */ 
     public String join(String sep, boolean quote);
 
     /**
      * Produce a new list that is this list append to all the
      * items in that.
      */
     public ILoS append(ILoS that);
 
     /**
      * Produce a new list with only the first n items of this list.
      */
     public ILoS take(int n);
 
 }
 