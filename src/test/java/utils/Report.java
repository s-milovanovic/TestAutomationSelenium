package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class Report {
    public static void setReporter(ExtentReports extent) {
        ExtentSparkReporter reporter = new ExtentSparkReporter("ExtentReport.html");
        extent.attachReporter(reporter);
        setReporterConfiguration(reporter);
    }

    private static void setReporterConfiguration(ExtentSparkReporter reporter) {
        reporter.viewConfigurer().viewOrder().as(new ViewName[]{ViewName.DASHBOARD, ViewName.TEST}).apply();
        reporter.config().setTheme(Theme.DARK);
        reporter.config().setReportName("Test Automation Results");
        reporter.config().setDocumentTitle("Test Results");
    }
}
