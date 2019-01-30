package org.wsi.range.zipcode.zipcode5digit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit Tests for {@link ZipCode5DigitRangeComparator}
 * 
 * @author VarunKumarChepuri
 */
public class ZipCode5DigitRangeComparatorTest {

	private static ZipCode5DigitRangeComparator zcrc;
	private static ZipCode5DigitRange first, second;
	private static int result;

	private static final int EQUALS = 0, LESSER_THAN = -1, GREATER_THAN = 1;

	/**
	 * Common setup for unit tests
	 */
	@Before
	public void setup() {
		zcrc = new ZipCode5DigitRangeComparator();
		first = new ZipCode5DigitRange(0, 0);
		second = new ZipCode5DigitRange(0, 0);
	}

	/**
	 * Test compare when low of first object equals second object
	 */
	@Test
	public void testCompareForEquals() {
		Assert.assertEquals(EQUALS, zcrc.compare(first, second));
	}

	/**
	 * Test compare when low of first object is lesser than second object
	 */
	@Test
	public void testCompareForLesser() {
		second.setRange(1, 2);
		Assert.assertEquals(LESSER_THAN, zcrc.compare(first, second));
	}

	/**
	 * Test compare when low of first object is greater than second object
	 */
	@Test
	public void testCompareForGreater() {
		first.setRange(1, 2);
		Assert.assertEquals(GREATER_THAN, zcrc.compare(first, second));
	}
}
