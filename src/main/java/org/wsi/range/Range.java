package org.wsi.range;

/**
 * @author VarunKumarChepuri
 *
 * @param <T> Any continuous data type
 */
public abstract class Range<T> {

	private T low, high = null;

	/**
	 * A method to validate the {@link Range}
	 * 
	 * @param low
	 * @param high
	 */
	protected abstract void rangeValidate(T low, T high);

	/**
	 * Constructor
	 * 
	 * @param low
	 * @param high
	 */
	public Range(T low, T high) {
		setRange(low, high);
	}

	/**
	 * A method to validate the boundaries
	 * 
	 * @param low
	 * @param high
	 */
	private void validate(T low, T high) {
		if (low == null || high == null) {
			throw new IllegalArgumentException("Range cannot have null values");
		}
		rangeValidate(low, high);
	}

	/**
	 * @return
	 */
	public T getLow() {
		return low;
	}

	/**
	 * @return
	 */
	public T getHigh() {
		return high;
	}

	/**
	 * @param low
	 */
	public void setLow(T low) {
		if (high != null) {
			setRange(low, high);
		} else
			throw new IllegalArgumentException("There is no existing Range");
	}

	/**
	 * @param high
	 */
	public void setHigh(T high) {
		if (high != null) {
			setRange(low, high);
		} else
			throw new IllegalArgumentException("There is no existing Range");
	}

	/**
	 * A method to set the boundaries
	 * 
	 * @param low
	 * @param high
	 */
	public void setRange(T low, T high) {
		validate(low, high);

		this.low = low;
		this.high = high;
	}
}
