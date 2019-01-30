package org.wsi.range.zipcode.zipcode5digit;

import java.util.Comparator;

public class ZipCode5DigitRangeComparator implements Comparator<ZipCode5DigitRange> {

	/**
	 * Method that compares two ranges and returns i) {@code -1} if current range is
	 * less than objToCompare ii) {@code 1} if current range is greater than
	 * objToCompare iii) {@code 0} if current range overlaps or continues with
	 * objToCompare
	 * 
	 * @param objToCompare
	 * @return
	 */
	@Override
	public int compare(ZipCode5DigitRange o1, ZipCode5DigitRange o2) {
		if (o1.getLow() < o2.getLow())
			return -1;
		else if (o1.getLow() > o2.getLow())
			return 1;
		return 0;
	}
}
