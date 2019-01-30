package org.wsi.range.zipcode.zipcode5digit;

import org.wsi.range.zipcode.ZipCodeRange;

/**
 * A class to store ZipCodes of up to 5 digits
 * 
 * @author VarunKumarChepuri
 */
public class ZipCode5DigitRange extends ZipCodeRange<Integer> {
	/**
	 * Constants that defines the boundaries of the class
	 */
	public static Integer MIN = 0;
	public static Integer MAX = 99999;

	/**
	 * Constructor
	 * 
	 * @param low
	 * @param high
	 */
	public ZipCode5DigitRange(Integer low, Integer high) {
		super(low, high);
	}

	/*
	 * (non-Javadoc)
	 * @see org.wsi.zip_code_range.model.BothInclusiveRange#validate(java.lang.
	 * Comparable, java.lang.Comparable)
	 */
	@Override
	protected void rangeValidate(Integer low, Integer high) {
		if (low < MIN || low > MAX) {
			throw new IllegalArgumentException(
			        "Expecting a 5 digit positive number for low:" + low);
		} else if (high < MIN || high > MAX) {
			throw new IllegalArgumentException(
			        "Expecting a 5 digit positive number for high:" + high);
		} else if (low > high) {
			throw new IllegalArgumentException("Illegal Range:[" + low + "," + high + "]");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (this.getLow() != null) {
			return "[" + this.getLow() + "," + this.getHigh() + "]";
		}
		return null;
	}
}
