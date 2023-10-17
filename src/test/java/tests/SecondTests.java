package tests;

import hooks.InitHooks;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageManagement.InitPages;
import utils.TestListener;

@Listeners(TestListener.class)
public class SecondTests extends InitHooks {
    @Test
    public void secondTests1() {
        InitPages.LoginPage.setUsernameField();
        Assert.assertTrue(true);
    }
    @Test
    public void secondTests2() {
        InitPages.LoginPage.setUsernameField();
        Assert.assertTrue(true);
    }
}
