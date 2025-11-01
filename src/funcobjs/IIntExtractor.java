package funcobjs;
/**
 * Nadeem Abdul Hamid, 2025.
 */

import media.IMedia;

/** 
 * Represents a function object that extracts some integer-valued 
 * characteristic (property) from a media item.
 */
public interface IIntExtractor {
	int extract(IMedia med);
}
