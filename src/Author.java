/**
* Nadeem Abdul Hamid, 2025.
*/

import java.util.Objects;

/**
* Represents the author of a book in our online media store.
*/
public class Author {
    String name;
    int yob;
    
    public Author(String name, int yob) {
        this.name = name;
        this.yob = yob;
    }
    
    /**
    * Produces true if this author's name is the same as the given name.
    */
    public boolean nameMatches(String name) {
        return this.name.equals(name);
    }
    
    /** 
     * Produces true if this author was born before that given author
     */
    public boolean bornBefore(Author that) {
        return this.yob < that.yob;
    }

    /**
     * Produces a JSON object representation of this author
     */
    public String toJSONString() {
    	return "\"" + this.name + " (b. " + this.yob + ")\"";
    }


    // AUTO-GENERATED CODE BELOW. DO NOT MODIFY!
    
    @Override
    public int hashCode() {
        return Objects.hash(name, yob);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Author))
            return false;
        Author other = (Author) obj;
        return Objects.equals(name, other.name) && yob == other.yob;
    }

    @Override
    public String toString() {
        return "Author [name=" + name + ", yob=" + yob + "]";
    }

}