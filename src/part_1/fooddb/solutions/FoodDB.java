package part_1.fooddb.solutions;

import java.util.Iterator;
import java.util.TreeMap;

/**
 * Alan Chen 2018-1-4 下午10:37:22
 * 
 * The checking of whether the name contains a keyword is duplicated
 */
public class FoodDB {

	public Iterator srchFood(String cName, String eName) {
		TreeMap foodTree = new TreeMap();
		Iterator foodList;
		Food food;
		foodList = getAllRecords();
		while (foodList.hasNext()) {
			food = (Food) foodList.next();
			if (nameMatchKeyworkd(food.getcName(), cName)
					&& nameMatchKeyworkd(food.geteName(), eName)) {
				foodTree.put(food.getFoodKey(), food);
			}
		}
		return foodTree.values().iterator();
	}

	private boolean nameMatchKeyworkd(String name, String keyword) {
		return keyword == null || keyword.equals("")
				|| name.indexOf(keyword) != -1;
	}

	// temp code
	private Iterator getAllRecords() {
		return null;
	}
}

class Food {
	private String foodKey;
	private String cName;
	private String eName;

	public String getFoodKey() {
		return foodKey;
	}

	public String getcName() {
		return cName;
	}

	public String geteName() {
		return eName;
	}
}
