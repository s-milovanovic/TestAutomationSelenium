package day1;

import hooks.InitHooks;
import org.testng.annotations.Test;
import pageManagement.InitPages;

public class SecondTests extends InitHooks {
    @Test
    public void testRun() throws InterruptedException {
        InitPages.LoginPage.setUsernameField();
        Thread.sleep(5000);
    }
    @Test
    public void testRun1() throws InterruptedException {
        InitPages.LoginPage.setUsernameField();
        Thread.sleep(5000);
    }
}
