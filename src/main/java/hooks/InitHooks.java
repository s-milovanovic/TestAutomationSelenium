package hooks;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageManagement.InitPages;

public class InitHooks extends DriverHook {

    @BeforeMethod
    public void setup(){
        init();
        InitPages.pagesInit();
    }
    @AfterMethod
    public void tearDown(){
        closeDriver();
    }
}
