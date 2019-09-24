package Random_String;

import java.io.File;
import java.util.Random;

public class SampleToDeploy {
	
	public static final String CHARNum_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	public static String StringList = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	
	public static void main(String[] args) {		
		
		String oo = generateRandomString(4);	
		System.out.println(oo);
		
	}
	
	public static int getRandomNumber() {
		
		int randomInt = 0;
		Random randomGenerator = new Random();
		randomInt = randomGenerator.nextInt(CHARNum_LIST.length());
		if (randomInt - 1 == -1) {
			return randomInt;
		} else {
			return randomInt - 1;
		}
	}

	public static String generateRandomString(int RANDOM_STRING_LENGTH) {
		StringBuffer randStr = new StringBuffer();
		// Use the below line to append with some text
		//randStr.append("auto_");    
		for (int i = 0; i < RANDOM_STRING_LENGTH; i++) {
			int number = getRandomNumber();
			char ch = CHARNum_LIST.charAt(number);
			randStr.append(ch);
		}
		return randStr.toString();
	}
	
}
