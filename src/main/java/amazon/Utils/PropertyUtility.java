package amazon.Utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtility {
	
		public String getTestEnvironmentProperty(String propertyKey) {
			
			String propertyValue="";
			try {
				InputStream input =  null;
				Properties prop = new Properties();
//				input = new FileInputStream("./device.configuration.properties");
				input = new FileInputStream("src\\test\\resources\\config.properties");
				prop.load(input);					
				propertyValue=prop.getProperty(propertyKey);
			} catch (IOException e) {
//			   	propertyValue="";
			}

			return propertyValue;
			
		}
		
		
		public String getExecutionEnvironmentProperty(String propertyKey) {
			
			String propertyValue=null;
			try {
				InputStream input =  null;
				Properties prop = new Properties();
				input = new FileInputStream("./device.configuration.properties");
				prop.load(input);					
				propertyValue=prop.getProperty(propertyKey);
			} catch (IOException e) {
			   	propertyValue="";
			}

			return propertyValue;
			
		}


		
}
