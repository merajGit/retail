package com.store.retail.bo;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		Date d1 = new Date("05/10/2016");
		//Date d2 = new Date("10/10/2012");
		
		Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		cal.add(Calendar.YEAR, -2); // to get previous year add -1
		Date d2 = cal.getTime();
		
		System.out.println(d2);
		
		int  discount = (int)(3000/100)*5;
		
		System.out.println(discount);
		
		
		
		System.out.println(d1.compareTo(d2)<0);
		
		
	
		
		

	}

}
