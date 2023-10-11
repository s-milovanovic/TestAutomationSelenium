package hooks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class DriverHook {
    protected static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected static String browserType;
    protected static String initialUrl;

    public static void init() {
        setProperties();
        switch (browserType){
            case "chrome":
                driver.set(ThreadGuard.protect(new ChromeDriver()));
                break;
            case "firefox":
                driver.set(ThreadGuard.protect(new FirefoxDriver()));
                break;
        }
        getDriver().manage().window().maximize();
        SetInitialPage();
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void SetInitialPage(){
        getDriver().get(initialUrl);
    }

    private synchronized static void setProperties() {
        Properties props = new Properties();
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\GlobalData.properties");
            props.load(fileInputStream);
            browserType = props.getProperty("browser");
            initialUrl = props.getProperty("initialUrl");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeDriver(){
        getDriver().close();
        getDriver().quit();
        driver.remove();
    }

    public static WebElement findAndWait(String xpath, int timeout) {
        var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    public static WebElement find(String xpath) {
        return getDriver().findElement(By.xpath(xpath));
    }
}
