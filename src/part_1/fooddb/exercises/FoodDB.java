package part_1.fooddb.exercises;

import java.util.Iterator;
import java.util.TreeMap;

/**
 * Alan Chen
 * 2018-1-4 下午10:37:22
 * 
 * Point out and remove the duplation in the code
 */
public class FoodDB {

	//find all foods whose names contain both the keywords.
	//returns an iterator on these foods
	public Iterator srchFood(String cName,String eName){
		//it contains all the foods to be returned.
		TreeMap foodTree = new TreeMap();
		Iterator foodList;
		Food food;
		foodList = getAllRecords();
		while(foodList.hasNext()){
			food = (Food)foodList.next();
			//null or "" means no key is specified
			if((cName ==null || cName.equals("") || food.getcName().indexOf(cName) !=-1) &&
			   (eName ==null || eName.equals("") || food.geteName().indexOf(eName) !=-1)){
				foodTree.put(food.getFoodKey(), food);
			}
		}
		return foodTree.values().iterator();
	}
	
	
	//补充代码用于辅助编译
	private Iterator getAllRecords(){
		return null;
	}
}


class Food{
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
