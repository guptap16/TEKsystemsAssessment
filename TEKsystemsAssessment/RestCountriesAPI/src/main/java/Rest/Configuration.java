package Rest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {	
	
	public static String  getValue(String key)
	{
		String value = null;
		try 			
		{

		    InputStream input = new FileInputStream("C:\\Projects\\eclipse workspace\\TekSystem\\RestCountriesAPI\\src\\main\\resources\\config.properties");
			Properties prop = new Properties();

            // load a properties file
            prop.load(input);
           return prop.getProperty(key);


        } catch (IOException ex) {
            ex.printStackTrace();
        }
		return value;
		
	}
	

}
