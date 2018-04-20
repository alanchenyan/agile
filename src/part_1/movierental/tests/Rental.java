package part_1.movierental.tests;

import java.util.Date;

/**
 * Alan Chen
 * 2018-1-6 下午8:09:53
 */
public abstract class Rental {

	protected Date rentDate;
	protected Date dueDate;
	protected double rentalFee;
	
	protected abstract double getOverdueFreeTimes();
	
	protected boolean isOverdue(){
		Date now = new Date();
		return dueDate.before(now);
	}
	
	protected double getTotalFree(){
		return isOverdue()? getOverdueFreeTimes() *rentalFee :rentalFee;
	}
}
