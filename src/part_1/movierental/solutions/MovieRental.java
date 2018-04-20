package part_1.movierental.solutions;


/**
 * Alan Chen
 * 2018-1-6 下午8:09:58
 */
public class MovieRental extends Rental{

	private String movieTitle;
	private int classification;
	
	
	@Override
	protected double getOverduePenaltyRate() {
		return 1.3;
	}
	
}
