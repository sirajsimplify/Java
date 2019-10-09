package Calander_Operations;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Calander_Days_Details {
	
	public static void main(String[] args) {
		
		// TO add days using calander
		LocalDate localDate = LocalDate.now();
		System.out.println("Current date is " + localDate);
		System.out.println(localDate.plusDays(Integer.parseInt("2")).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		System.out.println("The date with 2 days added are " + localDate.plusDays(Integer.parseInt("2")));
		System.out.println("Get the number of days got over in the month " + localDate.getDayOfMonth());
		System.out.println("Number of days got over in the current year " + localDate.getDayOfYear());
		System.out.println("Shows the month " + localDate.getMonthValue());
		System.out.println("To check whether the current year is a leap year " + localDate.isLeapYear());
		System.out.println("To check the number of days in the current month " + localDate.lengthOfMonth() +", To Find the number of days in a month " + localDate.lengthOfYear());
		System.out.println("To minus days using calander " + localDate.minusDays(3));
		System.out.println("To minus month from the current month " + localDate.minusMonths(2).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		System.out.println("To minus year from the current year " + localDate.minusYears(2).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		System.out.println("To add months " + localDate.plusMonths(4) + ", To add weeks " + localDate.plusWeeks(3));
		
	}

}
