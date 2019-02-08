package tests;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.TestBase;

import java.io.IOException;

public class LoginTest extends TestBase {


    @Test(groups = "Smoke")
    public void test1() throws IOException {
        logger = extent.createTest("login");
        logger.info("logging in");

        pages.login().usernameButton.sendKeys(ConfigurationReader.getProperty("username"));
        pages.login().passwordButton.sendKeys(ConfigurationReader.getProperty("password")+ Keys.ENTER);
        Assert.assertEquals(driver.getTitle(), "Web Orders");
    }

    @Test
    public void test2(){
        logger = extent.createTest("select check box");
        logger.info("login");
        pages.login().usernameButton.sendKeys(ConfigurationReader.getProperty("username"));
        pages.login().passwordButton.sendKeys(ConfigurationReader.getProperty("password")+ Keys.ENTER);

        logger.info("check box");
        pages.login().checkboxRow1.click();

        Assert.assertTrue(pages.login().checkboxRow1.isSelected());
    }


}
