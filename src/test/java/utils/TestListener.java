package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends ScreenshotTaker implements ITestListener{
    private static final ExtentReports extent = new ExtentReports();

    @Override
    public synchronized void onTestStart(ITestResult iTestResult) {
    }

    @Override
    public synchronized void onTestSuccess(ITestResult iTestResult) {
        extent.createTest(iTestResult.getName())
                .assignCategory(iTestResult.getMethod().getGroups())
                .log(Status.PASS, iTestResult.toString());
    }

    @Override
    public synchronized void onTestFailure(ITestResult iTestResult) {
        String screenshotsDir = "./failed_tests/";
        String failedTest = iTestResult.getName();

        takeScreenshot(failedTest);

        extent.createTest(failedTest)
                .addScreenCaptureFromPath(screenshotsDir + failedTest + ".png")
                .assignCategory(iTestResult.getMethod().getGroups())
                .log(Status.FAIL, iTestResult.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        extent.createTest(iTestResult.getName())
                .assignCategory(iTestResult.getMethod().getGroups())
                .log(Status.SKIP, iTestResult.toString());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public synchronized void onStart(ITestContext iTestContext) {
        Report.setReporter(extent);
    }

    @Override
    public synchronized void onFinish(ITestContext iTestContext) {
        extent.flush();
    }
}
