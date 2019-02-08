package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "ctl00_MainContent_username")
    public WebElement usernameButton;

    @FindBy(id="ctl00_MainContent_password")
    public WebElement passwordButton;

    @FindBy(id = "ctl00_MainContent_login_button")
    public WebElement loginButton;


}
