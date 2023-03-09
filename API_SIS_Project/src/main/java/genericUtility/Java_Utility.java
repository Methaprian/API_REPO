package genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Java_Utility {

	
	public int randomNumber() {
		Random random = new Random();
		int ran = random.nextInt(500);
		return ran;
	}
	
	public String getSystemDateAndtime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("DD-MM-YYYY hh:mm:ss");
		Date systemdate = new Date();
		String dateAndTime = dateFormat.format(systemdate);
		System.out.println(dateAndTime);
		return dateAndTime.replaceAll(":", "-");
	}
}
