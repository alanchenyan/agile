package part_1.logparser.tests;

import java.util.HashMap;
import java.util.Map;

/**
 * Alan Chen 2018-1-4 下午9:37:15
 */
public class ReportCatalogueIndexCommandParser {

	static final int ORG_CATALOG = 0;
	static final int PART_CATALOG = 1;

	private static Map<String, Integer> logTypeMap = new HashMap<String, Integer>();
	static {
		logTypeMap.put("orgNOGrouping", ORG_CATALOG);
		logTypeMap.put("orgGroupByCounty", ORG_CATALOG);
		logTypeMap.put("orgGroupByTypeOfOrgName", ORG_CATALOG);
		logTypeMap.put("part", PART_CATALOG);
	}

	int getGroupingType(String grouping) {
		Integer logType = logTypeMap.get(grouping);
		if (logType == null) {
			throw new IllegalArgumentException("Invalid grouping!");
		}
		return logType;
	}
}
