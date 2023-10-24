package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class ExtentReportConfig {
    private static final ThreadLocal<ExtentTest> extentTestThreadLocal  = new ThreadLocal<>();
    public static void setReporter(ExtentReports extent) {
        ExtentSparkReporter reporter = new ExtentSparkReporter("ExtentReport.html");
        extent.attachReporter(reporter);
        setReporterConfiguration(reporter);
    }
    public static ExtentTest getExtentTest(){
        return extentTestThreadLocal.get();
    }
    public static void setExtentTest(ExtentTest test){
        extentTestThreadLocal.set(test);
    }
    public static void removeExtentTest(){
        extentTestThreadLocal.remove();
    }
    private static void setReporterConfiguration(ExtentSparkReporter reporter) {
        reporter.viewConfigurer().viewOrder().as(new ViewName[]{ViewName.DASHBOARD, ViewName.TEST}).apply();
        reporter.config().setTheme(Theme.DARK);
        reporter.config().setReportName("Test Automation Results");
        reporter.config().setDocumentTitle("Test Results");
    }
}
