package Day1;

import hooks.InitHooks;
import pageManagement.InitPages;
import org.testng.annotations.Test;

public class FirstTests extends InitHooks {
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
