package part_2.restaurant.exercises;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

/**
 * Alan Chen
 * 2018-1-7 上午11:19:38
 * 
 * Turn the comments into code
 */
public class Restaurent extends Account{

	// the string "Rest" is cocated with the restaurant ID to form the key.
	final static String RestaurentIDText = "Rest";
	String website;
	String addr_cn;//address in Chiese
	String addr_en; // address in English
	//the restaurant would like to update its fax # with this.After it is
	//comfirmed,it will be stored in Account . Before that,it is stored here
	String numb_newfax;
	boolean has_NewFax = false;
	Vector Holiday;// a holiday
	String catId;// id of the category this restaurant belongs to.
	// a list of business session. Each business session is an arry
	// of two times. The first time is the start time.The second time
	// is the end time.The restaurant is open for businesss in each session.
	Vector BsHour; //Business hour
	
	//y:year
	//m:month
	//d:date
	void addHoliday(int y,int m,int d){
		if(y<1900) y+=1900;
		Calendar aHoliday = (new GregorianCalendar(y,m,d,0,0,0));
		Holiday.add(aHoliday);
	}
	
	public boolean addBsHour(int fromHr,int fromMin,int toHr,int toMin){
		int fMin = fromHr *60 +fromMin; // start time in minutes.
		int tMin = toHr *60 +toMin; // end time in minutes.
		// make sure both times are valid and the start time is earlier
		// than the end time.
		if(fMin >0 && fMin<1440 && tMin >0 && tMin <=1400 && fMin <tMin){
			GregorianCalendar bs [] = {
			   new GregorianCalendar(1900,1,1,fromHr,fromMin,0),
			   new GregorianCalendar(1900,1,1,toHr,toMin,0)
			};
			BsHour.add(bs);
			return true;
		}else{
			return false;
		}
	}
}


class Account{}
