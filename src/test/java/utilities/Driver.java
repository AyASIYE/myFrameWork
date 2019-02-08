package utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    private static WebDriver driver;

    public static void setDriver(){
        if(driver == null){
            Driver.driver=driver;
        }
    }

    public static WebDriver getDriver(){
        if(driver==null){
            switch(ConfigurationReader.getProperty("browser")){
                case"chrome":
                    WebDriverManager.chromedriver().setup();
                    driver= new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.chromedriver().setup();
                    driver = new FirefoxDriver();
            }
        }
        return driver;
    }

    public static void close(){
        if(driver != null){
            driver.quit();
            driver= null;
        }
    }
}
