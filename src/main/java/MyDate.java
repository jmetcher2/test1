import java.text.ParseException;

public class MyDate {

	/*
	 * Static factory stuff
	 * 
	 * 
	 */
	private static int epochBaseYear = 1970;
	private static int[] monthDays = new int[] {31,28,31,30,31,30,31,31,30,31,30,31};
	
	public static MyDate of(String dateString) throws NumberFormatException {
		String[] dateParts = dateString.split("/");
		
		int day = Integer.parseInt(dateParts[0]);
		int month = Integer.parseInt(dateParts[1]);
		int year = Integer.parseInt(dateParts[2]);
		
		return new MyDate(day,month,year);
	}
	
	private static int getMonthDays(int month, int year) {
		if (month == 2 && isLeap(year)) {
			return 29;
		}
		return monthDays[month - 1];
	}

	private static boolean isLeap(int year) {
		return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
	}
	

	
	/*
	 * Instance stuff
	 * 
	 * 
	 * 
	 */

	// This is not the normal java epoch, 
	// but we're using a similar concept
	private Integer epochDays;
	private int day = 1;
	private int month = 1;
	private int year = epochBaseYear;

	private MyDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
		
		int daysInMonth = getMonthDays(month, year);
		
		if (month < 1 || month > 12) {
			throw new IllegalArgumentException ("Month should be between 1 and 12.  Supplied value: " + month);
		}
		if (day < 1 || day > daysInMonth) {
			throw new IllegalArgumentException ("Day should be between 1 and " + daysInMonth + ".  Supplied value: " + day);
		}

		// might as well precalc and stash this
		this.epochDays = epochDiff();
	}
	
	private MyDate(Integer epochDays) {
		this.epochDays = epochDays;
	}
	
	public MyDate minus(MyDate toDate) {
		return new MyDate(this.getEpochDays() - toDate.getEpochDays());
	}
	
	public Integer getEpochDays() {
		return epochDays;
	}
	
	private Integer epochDiff() {
		Integer diff = (year - epochBaseYear) * 365;
		for (int i = 1; i < month; i++) {
			diff += getMonthDays(i, year);
		}
		diff += day -1;
		return diff;
	}


}
