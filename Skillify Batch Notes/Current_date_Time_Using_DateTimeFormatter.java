package Date_And_Time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Current_date_Time_Using_DateTimeFormatter {
	
	public static void main(String[] args) {
		
		java_time_format_DateTimeFormatter();
		java_text_SimpleDateFormat();
		java_util_Date();
		java_sql_Date();
		java_util_Calendar();
		System.out.println("From java.time.LocalDate ==> " + java.time.LocalDate.now()); // Get date using java.time.LocalDate
		System.out.println("From java.time.LocalTime  ==> " + java.time.LocalTime.now());  //  Get Current Time: java.time.LocalTime based on 24 hours
		System.out.println("From java.time.LocalDateTime ==> " + java.time.LocalDateTime.now()); // Get Current Date & Time: java.time.LocalDateTime
		System.out.println("From java.time.Clock ==> " + java.time.Clock.systemUTC().instant());  // The Clock.systemUTC().instant() method returns current date and time both.
		 
	}
	
	
	// This class uses java.time.format.DateTimeFormatter class to get the date and time
	public static void java_time_format_DateTimeFormatter(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); 
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss a");
		DateTimeFormatter gg = DateTimeFormatter.ofPattern("MM/dd/yyyy");		
		   LocalDateTime now = LocalDateTime.now();  		  
		   System.out.println("From java.time.format.DateTimeFormatter ==> " + dtf.format(now));
		   System.out.println("From java.time.format.DateTimeFormatter << 12 hours format >>  " + dtf1.format(now));
		   System.out.println(gg.format(now));
		   // Output ==>   2019/08/15 20:49:09
	}
	
	// This class uses java.text.SimpleDateFormat to get the date and time
	public static void java_text_SimpleDateFormat(){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();  
	    System.out.println("From java.text.SimpleDateFormat ==> " + formatter.format(date));
	    // Output ==>   15/08/2019 20:49:09
	}
	
	// Get Current Date & Time: java.util.Date
	public static void java_util_Date(){
		java.util.Date date=new java.util.Date();  
		System.out.println("From java.util.Date = First way ==> " + date);
		// Output ==>   First way ==>Thu Aug 15 20:49:09 IST 2019
		
		long millis=System.currentTimeMillis();  
		java.util.Date date1=new java.util.Date(millis);  
		System.out.println("From java.util.Date = Second way ==> " + date1);
		// Output ==>   Second way ==>Thu Aug 15 20:49:09 IST 2019
	}
	
	public static void  java_sql_Date(){
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);  
		System.out.println("From java.sql.Date  ==> " + date);  
		// Output ==>   2015-03-26
	}
	
	public static void java_util_Calendar(){
		Date date=java.util.Calendar.getInstance().getTime();  
		System.out.println("From java.util.Calendar ==> " + date); 
		// Output ==>  Thu Mar 26 08:22:02 IST 2015
	}
}
