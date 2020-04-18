package tests.utils;

import com.aventstack.extentreports.ExtentReports;

public class ExtentInstance {
    private static ExtentInstance singleton = null;
    private ExtentReports extentReports;

    private ExtentInstance() {
        extentReports = new ExtentReports();

    }

    public static ExtentInstance getInstance() {
        if (singleton == null) {
            singleton = new ExtentInstance();
        }
        return singleton;
    }

    public ExtentReports getExtentReport() {
        return extentReports;
    }
}
