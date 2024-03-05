package CommonUtils;

import java.util.Random;

public class JavaUtils {
	
	public int getRandomNumber() {
		Random r=new Random();
	int num = r.nextInt(100);
	return num;// the data/return type of num is int thats why we make it as void to int
		
	}

}
