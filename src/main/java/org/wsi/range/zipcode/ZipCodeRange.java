package org.wsi.range.zipcode;

import org.wsi.range.Range;

/**
 * A template to store a Range of ZipCodes
 * 
 * @author VarunKumarChepuri
 * 
 * @param <T> Any valid continuous number type
 */
public abstract class ZipCodeRange<T extends Number> extends Range<Integer> {

	/**
	 * Constructor
	 * 
	 * @param low
	 * @param high
	 */
	public ZipCodeRange(Integer low, Integer high) {
		super(low, high);
	}
}
