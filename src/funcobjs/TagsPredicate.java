package funcobjs;
/**
 * Nadeem Abdul Hamid, 2025.
 */

import java.util.List;
import java.util.function.Predicate;
import media.IMedia;
 
public class TagsPredicate implements Predicate<IMedia> {
    List<String> tags;
        
    public TagsPredicate(String tagstr) {
        this.tags = List.of(tagstr.split(","));
    }

    @Override
    public boolean test(IMedia med) {
        return med.hasAnyTag(tags);
    }
    
}
