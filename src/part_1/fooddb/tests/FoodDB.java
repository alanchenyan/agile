package part_1.fooddb.tests;

import java.util.Iterator;
import java.util.TreeMap;

/**
 * Alan Chen
 * 2018-1-4 下午10:37:22
 */
public class FoodDB {
	
	public Iterator srchFood(String cName,String eName){
		TreeMap foodTree = new TreeMap();
		Iterator foodList;
		Food food;
		foodList = getAllRecords();
		while(foodList.hasNext()){
			food = (Food)foodList.next();
			if(srchByName(cName,food.getcName()) &&
					srchByName(eName,food.geteName())){
				foodTree.put(food.getFoodKey(), food);
			}
		}
		return foodTree.values().iterator();
	}
	
	
	private boolean srchByName(String source,String target){
		if(source ==null || source.equals("") || target.indexOf(source) !=-1){
			return true;
		}
		return false;
	}
	
	
	//temp code
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
