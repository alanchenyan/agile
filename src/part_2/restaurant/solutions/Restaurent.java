package part_2.restaurant.solutions;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

/**
 * Alan Chen 2018-1-7 下午1:32:12
 * 
 * The most server problem here is the long comment expainin
 * the Vector named "BsHour".It is explaining how a business
 * Session is represented by an arry of two times.We should
 * turn this comment into a class definition for business session.
 * 
 * PS:亮点
 * 1、BussinessSession 类的提取。将复杂、逻辑集中、功能自成模块的代码封装成一个类来表达
 * 2、方法isValid 名字简单清晰
 */
public class Restaurent extends Account {

	final static String keyPrefix = "Rest";
	String website;
	String chineseAddr;
	String englishAddr;
	String faxNoUnderComfirmation;
	boolean hasFaxNoUnderComfirmation = false;
	Vector holidayList;
	String catIdForThisRestaurant;
	Vector businessSessionList;

	void addHoliday(int year, int month, int day) {
		if (year < 1900)
			year += 1900;
		Calendar aHoliday = (new GregorianCalendar(year, month, day, 0, 0, 0));
		holidayList.add(aHoliday);
	}

	public boolean addBusinessSession(int fromHr, int fromMin, int toHr,
			int toMin) {
		BussinessSession bs = new BussinessSession(fromHr, fromMin, toHr, toMin);
		if (bs.isValid()) {
			businessSessionList.add(bs);
			return true;
		} else {
			return false;
		}
	}
}

class BussinessSession {
	int minStart;
	int minEnd;

	BussinessSession(int fromHr, int fromMin, int toHr, int toMin) {
		minStart = getMiuntesFromMidNight(fromHr, fromMin);
		minEnd = getMiuntesFromMidNight(toHr, toMin);
	}

	private int getMiuntesFromMidNight(int hours, int minutes) {
		return hours * 60 + minutes;
	}

	private boolean isMinutesWithinOneDay(int minutes) {
		return minutes > 0 && minutes < 1440;
	}

	public boolean isValid() {
		return isMinutesWithinOneDay(minStart) && isMinutesWithinOneDay(minEnd)
				&& minStart < minEnd;
	}
}

class Account {
}
