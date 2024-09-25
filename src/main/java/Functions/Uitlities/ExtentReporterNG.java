package Functions.Uitlities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

    public static ExtentReports getReportObject() {
        String userEnv = System.getProperty("user.env");
        String defaultPath = "."; // You can set this to a suitable default path
        String path = (userEnv != null ? userEnv : defaultPath) + File.separator + "reports" + File.separator + "Report.html";

        // Ensure the directory exists
        File reportFile = new File(path);
        reportFile.getParentFile().mkdirs();

        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("OneMap Testing Results");
        reporter.config().setDocumentTitle("Test Results");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Sourav Paul");
        return extent;
    }
	
	
	
	
}
