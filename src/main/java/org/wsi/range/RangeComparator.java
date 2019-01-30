package org.wsi.range;

import java.util.Comparator;

/**
 * A comparator for {@link Range}
 * 
 * @author VarunKumarChepuri
 *
 * @param <T> Type to compare to
 */
public interface RangeComparator<T extends Range<?>> extends Comparator<T> {

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
	public int compare(T o1, T o2);
}
