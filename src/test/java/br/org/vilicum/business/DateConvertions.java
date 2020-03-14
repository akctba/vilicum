package br.org.vilicum.business;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import br.org.vilicum.util.CustomDate;

public class DateConvertions {
	
	private Date currentDate;
	private String febLeapYear = "/02/2020"; //leap year

	@Before
	public void setUp() throws Exception {
		currentDate = CustomDate.getCurrentDate();
	}

	@Test
	public void lastDay() {
		Calendar t1 = CustomDate.getLastDay(currentDate);
		assertEquals("31/03/2020", CustomDate.formatDate(t1));
	}
	
	@Test
	public void firstDay() {
		Calendar t2 = CustomDate.getFirstDay(currentDate);
		assertEquals("01/03/2020", CustomDate.formatDate(t2));
	}

	@Test
	public void february29LeapYear() {
		Date fev = CustomDate.parseDate("10" + febLeapYear);
		Calendar f1 = CustomDate.getLastDay(fev);
		assertEquals("29" + febLeapYear, CustomDate.formatDate(f1));
	}

}
