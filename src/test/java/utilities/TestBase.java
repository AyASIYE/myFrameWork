package utilities;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {
protected WebDriver driver;
protected Pages pages;
protected static ExtentHtmlReporter reporter ;
protected static ExtentReports extent;
protected static ExtentTest logger;



    @BeforeMethod
    public void setup(){
    driver=Driver.getDriver();
    pages = new Pages();

    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.get(ConfigurationReader.getProperty("url"));
}

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotLocation = ScreenShot.getScreenshot(result.getName());
            logger.fail(result.getName());
            logger.addScreenCaptureFromPath(screenshotLocation);
            logger.fail(result.getThrowable());

        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.skip("Test Case Skipped: " + result.getName());
        }
            Driver.close();

    }

    @AfterTest
    public void endrepo(){
        extent.flush();
}


    @BeforeTest
    public void repo(){
        extent = new ExtentReports();

     reporter = new ExtentHtmlReporter("./test-output/Reports.html");

    extent.attachReporter(reporter);

    extent.setSystemInfo("Test Name","Web Order");
        extent.setSystemInfo("Environment", "Staging");
        extent.setSystemInfo("Browser", ConfigurationReader.getProperty("browser"));
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        reporter.config().setDocumentTitle("Prestashop Reports");
        reporter.config().setReportName("Prestashop Automated Test Reports");
    }
}
