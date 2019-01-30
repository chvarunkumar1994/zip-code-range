package org.wsi.app;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.wsi.range.zipcode.zipcode5digit.ZipCode5DigitRange;
import org.wsi.range.zipcode.zipcode5digit.ZipCode5DigitRangeComparator;

/**
 * Start to the application
 *
 * @author VarunKumarChepuri
 */
public class App {
	/**
	 * Main class
	 * 
	 * @param args - A range of ZipCodes
	 */
	public static void main(String[] args) {

		if (null != args) {
			int i;
			ZipCode5DigitRangeComparator crc = new ZipCode5DigitRangeComparator();
			List<ZipCode5DigitRange> input = new LinkedList<ZipCode5DigitRange>();
			List<ZipCode5DigitRange> optimizedResult;
			Boolean atLeastOneInsert = false;

			// Reading input
			for (i = 0; i < args.length && null != args[i]; i++) {

				// Trimming away extra spaces
				String[] values = args[i].trim().replace("[", "").replace("]", "").split(",");
				input.add(new ZipCode5DigitRange(Integer.parseInt(values[0].trim()),
				        Integer.parseInt(values[1].trim())));
				atLeastOneInsert = true;
			}

			// When there is at least one interval
			if (atLeastOneInsert) {

				// Sorting the input based on lower interval
				Collections.sort(input, crc);

				// Merging overlapping sorted list
				optimizedResult = new LinkedList<ZipCode5DigitRange>();
				int prevLow = input.get(0).getLow(), prevHigh = input.get(0).getHigh();
				for (ZipCode5DigitRange each : input) {
					if (prevHigh >= each.getLow()) {
						prevHigh = Math.max(prevHigh, each.getHigh());
					} else {
						optimizedResult.add(new ZipCode5DigitRange(prevLow, prevHigh));
						prevLow = each.getLow();
						prevHigh = each.getHigh();
					}
				}
				optimizedResult.add(new ZipCode5DigitRange(prevLow, prevHigh));

				// Printing output
				for (i = 0; i < optimizedResult.size() - 1; i++) {
					System.out.print(optimizedResult.get(i).toString() + " ");
				}

				System.out.print(optimizedResult.get(i));
			}

		}
	}
}
