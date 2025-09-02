package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {
    private static ExtentReports extent;

    public static ExtentReports getReporter() {
        if (extent == null) {
            String timestamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date());
            String reportPath = "test-output/Report_" + timestamp + ".html";
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            sparkReporter.config().setReportName("Regression Automation Test Report");
            sparkReporter.config().setDocumentTitle("Extent Report");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Tester", "Saugat Dahal");
            extent.setSystemInfo("Environment", "QA");
        }
        return extent;
    }
}
