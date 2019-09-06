package br.org.vilicum.business;

import java.util.Calendar;
import java.util.Date;

import br.org.vilicum.util.CustomDate;

public class Datas {

	public static void main(String[] args) {
		Date currentDate = CustomDate.getCurrentDate();

		Calendar t1 = CustomDate.getLastDay(currentDate);
		System.out.println(CustomDate.formatDate(t1));
		
		Calendar t2 = CustomDate.getFirstDay(currentDate);
		System.out.println(CustomDate.formatDate(t2));
		
		Date fev = CustomDate.parseDate("10/02/2015");
		Calendar f1 = CustomDate.getLastDay(fev);
		System.out.println(CustomDate.formatDate(f1));
		
		Calendar f2 = CustomDate.getFirstDay(fev);
		System.out.println(CustomDate.formatDate(f2));
		
		Date jun = CustomDate.parseDate("10/06/2015");
		Calendar j1 = CustomDate.getLastDay(jun);
		System.out.println(CustomDate.formatDate(j1));
		
		Calendar j2 = CustomDate.getFirstDay(jun);
		System.out.println(CustomDate.formatDate(j2));
	}

}
