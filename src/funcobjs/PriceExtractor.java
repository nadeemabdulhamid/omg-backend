package funcobjs;
/**
 * Nadeem Abdul Hamid, 2025.
 */

import media.IMedia;

/** 
 * Extracts the sale price of a media item.
 */
public class PriceExtractor implements IIntExtractor {
    public int extract(IMedia med) {
        return med.salePrice();
    }
}
