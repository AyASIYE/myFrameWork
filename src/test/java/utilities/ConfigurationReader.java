package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    public static Properties properties;

    static{
        try{
            FileInputStream fileInputStream = new FileInputStream("configuration.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        }catch(IOException e){
            // prints stacktace for this Throwable Object
            e.printStackTrace();
        }
    }

    public static String getProperty(String property){
        return properties.getProperty(property);
    }
}
