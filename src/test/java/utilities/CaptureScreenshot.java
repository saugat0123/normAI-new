package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import commons.BaseClass;
import org.openqa.selenium.WebDriver;

public class CaptureScreenshot extends BaseClass{

	public static String takeScreenshot(WebDriver driver) {
		String timestamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date());
		String folderPath = System.getProperty("user.dir") + "/test-output/screenshots/";
//		new File(folderPath).mkdirs(); // Create folder if not exist

		String screenshotName = folderPath  + "_" + timestamp + ".png";

		try {
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File destFile = new File(screenshotName);
			FileUtils.copyFile(srcFile, destFile);
			return destFile.getAbsolutePath();
		} catch (IOException e) {
			System.err.println("Screenshot capture failed: " + e.getMessage());
			return null;
		}
	}

//	public static void getScreenshot() throws IOException {
//		Date currentDateTime = new Date();
//		String screenshotName = currentDateTime.toString().replace(" ", "-").replace(":", "-");
//		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile	(screenshotFile, new File(".//screenshots//"+ screenshotName +".png"));
//	}

}