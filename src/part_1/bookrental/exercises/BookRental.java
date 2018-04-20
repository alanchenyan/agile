package part_1.bookrental.exercises;

import java.util.Vector;

/**
 * Alan Chen
 * 2017-12-31 下午5:23:09
 * 
 * suppose you need to add a new method to delete a rental given its id.
 * How do you do ?
 */
class BookRentals {
	private Vector rentals;

	public String getCustomerName(String rentalId) throws RentalNotFoundException{
		for(int i =0;i<rentals.size();i++){
			BookRental rental = (BookRental)rentals.elementAt(i);
			if(rental.getId().equals(rentalId)){
				return rental.getCustomerName();
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