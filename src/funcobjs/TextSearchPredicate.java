package funcobjs;
/**
 * Nadeem Abdul Hamid, 2025.
 */

import java.util.function.Predicate;
import media.IMedia;

public class TextSearchPredicate implements Predicate<IMedia> {
	String searchString;
		
	public TextSearchPredicate(String searchString) {
		this.searchString = searchString;
	}

	@Override
	public boolean test(IMedia med) {
		return med.contains(searchString);
	}
}
