package pl.chrzescijanskja.randka.ulils;

import java.util.Date;

public class Utils {
	
	public static final int IMPLICIT_WAIT_TIME = 50;
	public static final int  PAGE_LOAD_TIME = 30;

	public static  String generateEmailWithTimeStamp() {
		Date date = new Date();
		String timestamp = date.toString().replace(" ","_").replace(":","_");
		return "bees" + timestamp+ "@gmail.com";
		
	}
	

}
