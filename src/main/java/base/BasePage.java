package base;

import hooks.DriverHook;
import org.openqa.selenium.WebElement;
public class BasePage {
    public WebElement find(String xpath, int timeout){
        return DriverHook.findAndWait(xpath, timeout);
    }
    public WebElement find(String xpath){
        return DriverHook.find(xpath);
    }
}
