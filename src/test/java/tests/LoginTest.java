package tests;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.TestBase;

import java.io.IOException;

public class LoginTest extends TestBase {


    @Test
    public void test1() throws IOException {
        logger = extent.createTest("login");
        logger.info("logging in");

        pages.login().usernameButton.sendKeys(ConfigurationReader.getProperty("username"));
        pages.login().passwordButton.sendKeys(ConfigurationReader.getProperty("password")+ Keys.ENTER);
        pages.login().loginButton.click();



    }
}
