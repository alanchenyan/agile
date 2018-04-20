package part_1.movierental.solutions;

import java.util.Date;

/**
 * Alan Chen
 * 2018-1-6 下午8:09:53
 */
public abstract class Rental {

	protected Date rentDate;
	protected Date dueDate;
	protected double rentalFee;
	
	protected abstract double getOverduePenaltyRate();
	
	protected boolean isOverdue(){
		Date now = new Date();
		return dueDate.before(now);
	}
	
	protected double getTotalFree(){
		return isOverdue()? getOverduePenaltyRate() *rentalFee :rentalFee;
	}
}
