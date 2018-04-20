package part_1.logparser.exercises;

/**
 * Alan Chen
 * 2018-1-4 下午9:37:00
 * 
 * Point out and remove the duplation in the code
 */
public class ReportCatalogueIndexCommandParser {

	final String NO_GROUPING = "orgNOGrouping";
	static final int ORG_CATALOG = 0;
	static final int PART_CATALOG = 1;
	
	int getGroupingType(String grouping){
		if(grouping.equals(NO_GROUPING)){
			return ORG_CATALOG;
		}else if(grouping.equals("orgGroupByCounty")){
			return ORG_CATALOG;
		}else if(grouping.equals("orgGroupByTypeOfOrgName")){
			return ORG_CATALOG;
		}else if(grouping.equals("part")){
			return PART_CATALOG;
		}else{
			//PS:拋出精确的异常信息，值得学习
			throw new IllegalArgumentException("Invalid grouping!");
		}
	}
}
