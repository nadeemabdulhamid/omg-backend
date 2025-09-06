/**
* Nadeem Abdul Hamid, 2025.
*/

import java.util.Objects;

/**
* Represents the author of a book in our online media store.
*/
public class Author {
    
    public Author(String name, int yob) {
    }
    
    public boolean nameMatches(String name) {
        return false;
    }
    
    public boolean bornBefore(Author that) {
        return false;
    }

    /**
     * Produces a JSON object representation of this author
     */
    public String toJSONString() {
    	return "\"Some author (b. year)\"";
    }


    // AUTO-GENERATED CODE BELOW. DO NOT MODIFY!
    
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Author))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Author";
    }

}