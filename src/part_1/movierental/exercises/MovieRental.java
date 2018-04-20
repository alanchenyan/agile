package part_1.movierental.exercises;

import java.util.Date;

/**
 * Alan Chen
 * 2018-1-6 下午7:52:22
 * 
 * Suppose that there are two kinds of rentals :book and movie. 
 * Point out and remove the duplication in the code
 */
class BookRental{
	private String bookTitle;
	private String author;
	private Date rentDate;
	private Date dueDate;
	private double rentalFee;
	
	public boolean isOverdue(){
		Date now = new Date();
		return dueDate.before(now);
	}
	
	public double getTotalFree(){
		return isOverdue()? 1.2 *rentalFee :rentalFee;
	}
}

public class MovieRental {

	private String movieTitle;
	private int classification;
	private Date rentDate;
	private Date dueDate;
	private double rentalFee;
	
	public boolean isOverdue(){
		Date now = new Date();
		return dueDate.before(now);
	}
	
	public double getTotalFree(){
		return isOverdue()? 1.3 *rentalFee :rentalFee;
	}
}
