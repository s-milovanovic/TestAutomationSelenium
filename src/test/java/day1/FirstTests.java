package day1;

import hooks.InitHooks;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import pageManagement.InitPages;
import org.testng.annotations.Test;
import utils.TestListener;

@Listeners(TestListener.class)
public class FirstTests extends InitHooks {
    @Test(groups = {"smoke"}, description = "Our first Test")
    public void testRun() {
        InitPages.LoginPage.setUsernameField();
        String title = InitPages.LoginPage.GetTitle();
        Assert.assertEquals(title, "");
    }
    @Test(groups = {"integration"}, description = "Our second Test")
    public void testRun1() {
        InitPages.LoginPage.setUsernameField();
        String title = InitPages.LoginPage.GetTitle();
        Assert.assertEquals(title, "");
    }
}
