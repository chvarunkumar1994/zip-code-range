package org.wsi.app;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple {@link App}
 */
public class AppTest {
	private String input[];

	/**
	 * Test handling null values
	 */
	@Test
	public void testMainHandlingNull() {
		try {
			input = new String[1];
			App.main(input);
		} catch (NullPointerException n) {
			Assert.fail("Doesn't handle null values");
		}
	}

	/**
	 * Test for no input
	 */
	@Test
	public void testMainNoInput() {
		try {
			App.main(input);
		} catch (NullPointerException n) {
			Assert.fail("Doesn't handle when there is no input");
		}
	}

	/**
	 * Test for single valid range
	 */
	@Test
	public void testMainSingleInput() {
		try {
			input = new String[] {
			        "[13211,21241]"
			};
			App.main(input);
		} catch (NullPointerException n) {
			Assert.fail("Single input doesn't work");
		}
	}
}
