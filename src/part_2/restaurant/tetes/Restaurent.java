package part_2.restaurant.tetes;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

/**
 * Alan Chen 2018-1-7 上午11:44:06
 */
public class Restaurent extends Account {

	final static String RestaurentIDText = "Rest";
	String website;
	String chisAddress;
	String enAddress;
	String numbOfNewfax;
	boolean hasNewFax = false;
	Vector holidays;
	String categoryId;
	Vector businessHour;

	void addHoliday(int year, int month, int day) {
		if (year < 1900)
			year += 1900;
		Calendar aHoliday = (new GregorianCalendar(year, month, day, 0, 0, 0));
		holidays.add(aHoliday);
	}

	public boolean addBsHour(int fromHr, int fromMin, int toHr, int toMin) {
		int startMins = toMins(fromHr,fromMin);
		int endMins = toMins(toHr,toMin);
		boolean startTimeIsEarlierThanEndTime = startMins < endMins; // 变量名太长

		if (timeInMinsIsValid(startMins) && timeInMinsIsValid(endMins)
				&& startTimeIsEarlierThanEndTime) {
			GregorianCalendar bs[] = {
					new GregorianCalendar(1900, 1, 1, fromHr, fromMin, 0),
					new GregorianCalendar(1900, 1, 1, toHr, toMin, 0) };
			businessHour.add(bs);
			return true;
		} else {
			return false;
		}
	}

	private boolean timeInMinsIsValid(int mins) {
		return mins > 0 && mins < 1440;
	}
	
	private int toMins(int hours,int mins){
		return hours *60 + mins;
	}
}

class Account {
}
