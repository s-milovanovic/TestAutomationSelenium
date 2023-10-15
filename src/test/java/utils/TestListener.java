package utils;

import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestListener;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestListener extends ScreenshotTaker implements ITestListener{
    private static final ExtentReports extent = new ExtentReports();
    private final ExtentSparkReporter reporter = new ExtentSparkReporter("ExtentReport.html");

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public synchronized void onTestFailure(ITestResult iTestResult) {
        String screenshotsDir = "./failed_tests/";
        String failedTest = iTestResult.getName();
        /*
        OPTION 2:
        Save screenshot as PNG file and add it to an Extent Report
         */
        takeScreenshot(failedTest);

        // Sets Dashboard as the primary view of the report
        reporter.viewConfigurer().viewOrder().as(new ViewName[]{ViewName.DASHBOARD, ViewName.TEST}).apply();
        reporter.config().setTheme(Theme.DARK);
        extent.attachReporter(reporter);
        extent.createTest(failedTest)
                // Add screenshot
                .addScreenCaptureFromPath(screenshotsDir + failedTest + ".png")
                // Offers another form of displaying the screenshot
//                .fail(MediaEntityBuilder.createScreenCaptureFromPath(screenshotsDir + failedTest + ".png").build())
                // Uses the test's group info to set the test category
                .assignCategory(iTestResult.getMethod().getGroups())
                // Prints the stacktrace
                .log(Status.FAIL, iTestResult.getThrowable())
                // Prints the test's description
                .info(iTestResult.getMethod().getDescription());
                // Prints the test's group
                //.info(Arrays.toString(iTestResult.getMethod().getGroups()));
        //  Write the test information to the reporter
        extent.flush();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
