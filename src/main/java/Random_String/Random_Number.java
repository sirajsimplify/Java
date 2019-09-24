package Random_String;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class Random_Number {
	
	private static final int RANDOM_STRING_LENGTH = 10;
	private static final String DIGIT_LIST = "1234567890";
	public static HashMap<String, String> Dynamicvariable = new HashMap<String, String>();
	public static String GparamName;
	private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	private static final int RANDOM_STRING_LENGTH2 = 48;
	
	public static void main(String[] args) {
		
		Random_Number rn = new Random_Number();
		int o = rn.getRandomNumber1();
		String p = rn.generateRandomNumber();
		boolean q = rn.generateRandomNumber("6");
		boolean r = rn.generateUniqueString();
		int s = rn.getRandomNumber();
		String t = rn.generateRandomString();
		String u = rn.generateRandomString2();
		
		System.out.println("Value of 'p' is ".concat(p) + ", "
				+ "the value of 'o' is " + o + ", "
						+ "the value of 'q' is "+ q + ", "
								+ "value of 'r' is " + r + ", value of 's' is " + s
								+ ", the value of 't' is " +t + ", the value of 'u' is " + u);
		System.out.println("Finished");
		
	}	
	// Direct call
	public String generateRandomNumber() {

		StringBuffer randStr = new StringBuffer();
		int RANDOM_STRING_LENGTH1 = 10;
		for (int i = 0; i < RANDOM_STRING_LENGTH1; i++) {
			int number = getRandomNumber1();
			char ch = DIGIT_LIST.charAt(number);
			randStr.append(ch);
		}
		return randStr.toString();
	}
	
	// 
	public boolean generateRandomNumber(String digit) {

		StringBuffer randStr = new StringBuffer();
		for (int i = 0; i < Integer.parseInt(digit); i++) {
			int number = getRandomNumber1();
			char ch = DIGIT_LIST.charAt(number);
			randStr.append(ch);
		}
//		Dynamicvariable.put(GparamName, randStr.toString());
		String randomStringIs =  randStr.toString();
		System.out.println(randomStringIs);
		return true;
	}
	
	public boolean generateUniqueString() {
		boolean bStatus = false;
		try {
			Date date = new Date();
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String DateandTime = sdf.format(date).replace("-", "").replace(":", "").replace(" ", "");
			String UniqueText = "Test_" + DateandTime;
			Dynamicvariable.put(GparamName, UniqueText);
			String gVar = "Unique Email ID is " + ":" + UniqueText;
			System.out.println(gVar);
			bStatus = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bStatus;
	}
	
	// This method is being called by another method
		private int getRandomNumber1() {
			
			int randomInt = 0;
			Random randomGenerator = new Random();
			String DIGIT_LIST1 = "1234567890";
			randomInt = randomGenerator.nextInt(DIGIT_LIST1.length());
			if (randomInt - 1 == -1) {
				return randomInt;
			} else {
				return randomInt - 1;
			}
		}
	
	// This method is being called by another method
	private int getRandomNumber() {
		
		int randomInt = 0;
		Random randomGenerator = new Random();
		randomInt = randomGenerator.nextInt(CHAR_LIST.length());
		if (randomInt - 1 == -1) {
			return randomInt;
		} else {
			return randomInt - 1;
		}
	}
	
	public String generateRandomString() {
		StringBuffer randStr = new StringBuffer();
		randStr.append("auto_");
		for (int i = 0; i < RANDOM_STRING_LENGTH; i++) {
			int number = getRandomNumber();
			char ch = CHAR_LIST.charAt(number);
			randStr.append(ch);
		}
		return randStr.toString();
	}
	
	public String generateRandomString2() {

		StringBuffer randStr = new StringBuffer();
		randStr.append("auto");
		for (int i = 0; i < RANDOM_STRING_LENGTH2; i++) {
			int number = getRandomNumber();
			char ch = CHAR_LIST.charAt(number);
			randStr.append(ch);
		}
		return randStr.toString();
	}
	
	

}
