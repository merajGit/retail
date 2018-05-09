package com.store.retail.util;

import java.util.Calendar;
import java.util.Date;

public class Utility {

	public static boolean compareDateForTwoYears(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -2); // to get previous year add -1
		Date dateBeforeTwoYears = cal.getTime();
		return date.compareTo(dateBeforeTwoYears) < 0;
	}

}
