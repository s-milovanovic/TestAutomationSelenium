package tests;

import hooks.InitHooks;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageManagement.InitPages;
import utils.Report;
import utils.TestListener;

@Listeners(TestListener.class)
public class FirstTests extends InitHooks {
    @Test(groups = {"smoke"}, description = "Our first Test")
    public void firstTest1() {
        InitPages.LoginPage.setUsernameField();
        Report.reportSuccess("user set username");
        String title = InitPages.LoginPage.GetTitle();
        Assert.assertEquals(title, "");
    }
    @Test(groups = {"integration"}, description = "Our second Test")
    public void firstTest2() {
        InitPages.LoginPage.setUsernameField();
        Report.reportSuccess("user set username");
        String title = InitPages.LoginPage.GetTitle();
        Assert.assertEquals(title, "");
    }
}
