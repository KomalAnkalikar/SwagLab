package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	public static ExtentReports getReports() {
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("ExtentsReport.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Reported By", "Komal");
		extent.setSystemInfo("Test Type", "Regression");
		return extent;
	}
	
}
