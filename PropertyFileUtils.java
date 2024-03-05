package CommonUtils;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtils {
	 public String getDataFromPropertyFile(String Keyname) throws IOException {
		 FileInputStream file = new FileInputStream("src\\test\\resources\\login.properties");
			Properties p= new Properties();
			p.load(file);
			String value = p.getProperty(Keyname);
			return value;

	 
	 }

}
