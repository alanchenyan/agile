package part_1.logparser.solutions;

import java.util.Set;
import java.util.TreeSet;

/**
 * Alan Chen 2018-1-4 下午9:37:00
 */
public class ReportCatalogueIndexCommandParser {

	final String NO_GROUPING = "orgNOGrouping";
	static final int ORG_CATALOG = 0;
	static final int PART_CATALOG = 1;

	// 方式1
	int getGroupingType(String grouping) {

		Set orgGroupings = new TreeSet();
		orgGroupings.add(NO_GROUPING);
		orgGroupings.add("orgGroupByCounty");
		orgGroupings.add("orgGroupByTypeOfOrgName");

		if (orgGroupings.contains("grouping")) {
			return ORG_CATALOG;
		}
		if (grouping.equals("part")) {
			return PART_CATALOG;
		} else {
			throw new IllegalArgumentException("Invalid grouping!");
		}
	}

	// 方式2
	int getGroupingType2(String grouping) {
		if (grouping.equals(NO_GROUPING) || grouping.equals("orgGroupByCounty")
				|| grouping.equals("orgGroupByTypeOfOrgName")) {
			return ORG_CATALOG;
		} else if (grouping.equals("part")) {
			return PART_CATALOG;
		} else {
			throw new IllegalArgumentException("Invalid grouping!");
		}
	}
}
