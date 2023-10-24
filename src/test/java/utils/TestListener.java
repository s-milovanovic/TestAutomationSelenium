package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends ScreenshotTaker implements ITestListener{
    private static final ExtentReports extent = new ExtentReports();

    @Override
    public synchronized void onTestStart(ITestResult iTestResult) {
        ExtentTest test = extent.createTest(iTestResult.getName());
        ExtentReportConfig.setExtentTest(test);
    }

    @Override
    public synchronized void onTestSuccess(ITestResult iTestResult) {
        String testName = iTestResult.getName();
        ExtentReportConfig.getExtentTest().assignCategory(iTestResult.getMethod().getGroups())
                .log(Status.PASS, testName + " passed" );
        ExtentReportConfig.removeExtentTest();
    }

    @Override
    public synchronized void onTestFailure(ITestResult iTestResult) {
        String screenshotsDir = "./failed_tests/";
        String testName = iTestResult.getName();

        takeScreenshot(testName);

        ExtentReportConfig.getExtentTest().addScreenCaptureFromPath(screenshotsDir + testName + ".png")
                .assignCategory(iTestResult.getMethod().getGroups())
                .log(Status.FAIL, iTestResult.getThrowable());
        ExtentReportConfig.removeExtentTest();
    }

    @Override
    public synchronized void onTestSkipped(ITestResult iTestResult) {
        extent.createTest(iTestResult.getName())
                .assignCategory(iTestResult.getMethod().getGroups())
                .log(Status.SKIP, iTestResult.toString());
        ExtentReportConfig.removeExtentTest();
    }

    @Override
    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public synchronized void onStart(ITestContext iTestContext) {
        ExtentReportConfig.setReporter(extent);
    }

    @Override
    public synchronized void onFinish(ITestContext iTestContext) {
        extent.flush();
        ExtentReportConfig.removeExtentTest();
    }
}
