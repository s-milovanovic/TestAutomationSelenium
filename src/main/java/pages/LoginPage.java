package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private final WebElement username = find("(//input[@name = 'username'])[1]", 10);
    public void setUsernameField(){
        username.sendKeys("test");
    }
}
