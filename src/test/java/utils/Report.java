package utils;

import com.aventstack.extentreports.Status;

public class Report {

    public static void reportSuccess(String message){
        ExtentReportConfig.getExtentTest().log(Status.PASS, message);
    }

    public static void reportInfo(String message){
        ExtentReportConfig.getExtentTest().log(Status.INFO, message);
    }

    public static void reportFailure(String message){
        ExtentReportConfig.getExtentTest().log(Status.FAIL, message);
    }
}
