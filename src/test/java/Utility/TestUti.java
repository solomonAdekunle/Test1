package Utility;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class TestUti {

	
	
	
	
	public static void updateproperty(String key, String Value) throws ConfigurationException {
		System.out.println("Config cHECKING");
		String path = System.getProperty("user.dir") +"\\src\\test\\java\\Config\\Config.Properties";
		PropertiesConfiguration config = new PropertiesConfiguration(path);
		config.setProperty(key, Value);
		config.save();
		System.out.println("Config Property Successfully Updated..");
	}
}
