package part_2.stockitemindb.solutions;

public class StockItemInDB {

	//bad this method name is too long
	StockItem [] findStockItemsFromOverseasWithInventoryLeassThan10(){
		return null;
	}
	
	//Fun 1
	StockItem [] findStockItemsWhithFeatures(boolean isFromOverseas,InventoryRange inventoryRange){
		return null;
	}
	
	//Fun 2
	StockItem [] findStockItemsToReplenish(){
		StockItem stockItems[] =null;
		stockItems = findStockItemsFromOverSeas();
		stockItems = findStockItemsInventoryLeassThan10(stockItems);
		return stockItems;
	}
	
	StockItem [] findStockItemsFromOverSeas(){
		return null;
	}
	
	StockItem [] findStockItemsInventoryLeassThan10(StockItem stockItems[]){
		return null;
	}
}

class InventoryRange{
	int minimumInventory;
	int maxmumInventory;
}

//补充代码用于辅助编译
class StockItem{}