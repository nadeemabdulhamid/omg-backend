package funcobjs;
/**
 * Nadeem Abdul Hamid, 2025.
 */

import java.util.List;
import media.IMedia;

public class Audio30OffCoupon implements ICoupon {
	@Override
	public int calculateTotal(List<IMedia> items) {
		int sum = 0;
		for (IMedia m : items) {
			if (m.typeMatches("audio")) {
				sum += (int)(m.salePrice() * .7);
			} else {
				sum += m.salePrice();
			}
		}
		return sum;
	}
}
