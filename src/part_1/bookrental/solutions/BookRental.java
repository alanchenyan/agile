package part_1.bookrental.solutions;

import java.util.Vector;
/**
 * Alan Chen
 * 2017-12-31 下午5:23:23
 * 方式：将重复的代码抽取为方法
 */
class BookRentals {
	private Vector rentals;

	public String getCustomerName(String rentalId) throws RentalNotFoundException{
		BookRental rental =  (BookRental) rentals.elementAt(getRentalIndexById(rentalId));
		return rental.getCustomerName();
	}
	
	//PS：妙在用下标，删除时可以提高效率。
	public void deleteRentalById(String rentalId) throws RentalNotFoundException{
		rentals.remove(getRentalIndexById(rentalId));
	}
	
	
	public int getRentalIndexById(String rentalId) throws RentalNotFoundException{
		for(int i =0;i<rentals.size();i++){
			BookRental rental = (BookRental)rentals.elementAt(i);
			if(rental.getId().equals(rentalId)){
				return i;
			}
		}
		throw new RentalNotFoundException();
	}
}


public class BookRental {
	private String id;
	private String customerName;

	public String getId() {
		return id;
	}

	public String getCustomerName() {
		return customerName;
	}
}

class RentalNotFoundException extends Exception{
	
}