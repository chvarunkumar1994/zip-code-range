package org.wsi.range.zipcode.zipcode5digit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for {@link ZipCode5DigitRange}
 * 
 * @author VarunKumarChepuri
 */
public class ZipCode5DigitRangeTest {

	private static ZipCode5DigitRange zipcode5Digit;

	/**
	 * Common setup for unit tests
	 */
	@Before
	public void setup() {
		zipcode5Digit = null;
	}

	/**
	 * Test validation on lower range greater than high
	 */
	@Test
	public void testValidationForLowGreater() {
		try {
			zipcode5Digit = new ZipCode5DigitRange(ZipCode5DigitRange.MAX, ZipCode5DigitRange.MIN);
			Assert.fail("Validatation failure: Accepts values when low range is greater");
		} catch (IllegalArgumentException e) {
			Assert.assertNull(zipcode5Digit);
		}
	}

	/**
	 * Test validation on range less than {@link ZipCode5DigitRange#MIN}
	 */
	@Test
	public void testMinValidate() {
		try {
			zipcode5Digit = new ZipCode5DigitRange(ZipCode5DigitRange.MIN - 1,
			        ZipCode5DigitRange.MAX);
			Assert.fail("Validatation failure: Accepts lower range values");
		} catch (IllegalArgumentException e) {
			Assert.assertNull(zipcode5Digit);
		}
	}

	/**
	 * Test validation on range greater than {@link ZipCode5DigitRange#MAX}
	 */
	@Test
	public void testMaxValidate() {
		try {
			zipcode5Digit = new ZipCode5DigitRange(ZipCode5DigitRange.MIN,
			        ZipCode5DigitRange.MAX + 1);
			Assert.fail("Validatation failure: Accepts higher range values");
		} catch (IllegalArgumentException e) {
			Assert.assertNull(zipcode5Digit);
		}
	}

	/**
	 * Test validate for boundary values
	 */
	@Test
	public void testValidateForBoundaryConditions() {
		try {
			zipcode5Digit = new ZipCode5DigitRange(ZipCode5DigitRange.MIN, ZipCode5DigitRange.MAX);
			Assert.assertNotNull(zipcode5Digit);
		} catch (IllegalArgumentException e) {
			Assert.fail("Validatation failure: Doesn't accept boundary values");
		}
	}

	/**
	 * Test validation on low equals high
	 */
	@Test
	public void testValidationForSingleValuedRange() {
		try {
			zipcode5Digit = new ZipCode5DigitRange(ZipCode5DigitRange.MIN, ZipCode5DigitRange.MIN);
			Assert.assertNotNull(zipcode5Digit);
		} catch (IllegalArgumentException e) {
			Assert.fail("Validatation failure: Doesn't accept single valued ranges");
		}
	}

	/**
	 * Test validation when low is {@code null}
	 */
	@Test
	public void testValidationForNullValueOnLow() {
		try {
			zipcode5Digit = new ZipCode5DigitRange(null, ZipCode5DigitRange.MIN);
			Assert.fail("Validatation failure: Accepts null values");
		} catch (IllegalArgumentException e) {
			Assert.assertNull(zipcode5Digit);
		}
	}

	/**
	 * Test validation when high is {@code null}
	 */
	@Test
	public void testValidationForNullValueOnHigh() {
		try {
			zipcode5Digit = new ZipCode5DigitRange(1, null);
			Assert.fail("Validatation failure: Accepts null values");
		} catch (IllegalArgumentException e) {
			Assert.assertNull(zipcode5Digit);
		}
	}

	/**
	 * Test if {@link ZipCode5DigitRange#toString() returns as expected for Ideal
	 * case
	 */
	@Test
	public void testToStringIdealCase() {
		zipcode5Digit = new ZipCode5DigitRange(10005, 20000);
		Assert.assertNotNull(zipcode5Digit.toString());
		Assert.assertEquals("[" + zipcode5Digit.getLow() + "," + zipcode5Digit.getHigh() + "]",
		        zipcode5Digit.toString());
	}
}
