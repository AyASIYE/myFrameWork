package utilities;
import pages.*;

public class Pages {
   private LoginPage loginPage;

    public LoginPage login() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }
}
