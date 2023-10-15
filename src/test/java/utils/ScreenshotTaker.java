package utils;

import hooks.DriverHook;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class ScreenshotTaker {
    /**
     * Takes screenshot of whole page and allows you to name the screenshot
     *
     * @param screenshotName The screenshot file name
     */
    public void takeScreenshot(String screenshotName) {
        TakesScreenshot screenshot = (TakesScreenshot) DriverHook.getDriver();
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("./failed_tests/" + screenshotName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Takes screenshot of single WebElement
     */
    public void takeElementScreenshot(By locator) {
        WebElement element = DriverHook.getDriver().findElement(locator);
        File file = element.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("./screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
