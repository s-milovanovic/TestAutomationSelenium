package pageManagement;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class InitPages {
    public static LoginPage LoginPage;

    public static void pagesInit(){
        LoginPage = new LoginPage();
    }
}
