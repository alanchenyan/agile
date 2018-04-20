package part_1.movierental.solutions;

/**
 * Alan Chen
 * 2018-1-6 下午8:09:49
 */
public class BookRental extends Rental{

	private String bookTitle;
	private String author;
	
	@Override
	protected double getOverduePenaltyRate() {
		return 1.2;
	}
}
