package part_1.bookrental.tests;

import java.util.Vector;

/**
 * Alan Chen
 * 2017-12-31 下午3:57:22
 */
class BookRentals {
	private Vector<BookRental> rentals;

	public String getCustomerName(String rentalId) throws RentalNotFoundException{
		return getRentalById(rentalId).getCustomerName();
	}
	
	public void deleteRentalById(String rentalId) throws RentalNotFoundException{
		rentals.remove(getRentalById(rentalId));
	}
	
	public BookRental getRentalById(String rentalId) throws RentalNotFoundException{
		for(BookRental rental : rentals){
			if(rental.getId().equals(rentalId)){
				return rental;
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