package webdriver.screenshot

import javax.imageio.ImageIO
import java.awt.image.BufferedImage;

import org.apache.commons.io.FileUtils
import org.openqa.selenium.*;

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory

import katalon.common.BaseKeyword
import ru.yandex.qatools.ashot.AShot
import ru.yandex.qatools.ashot.Screenshot
import ru.yandex.qatools.ashot.shooting.ShootingStrategies

public class TakeScreenshot extends BaseKeyword {

	/**
	 * Take screenshot of current view
	 * @param expectedFilename the location of expected image
	 * @param flowControl control behavior of the execution
	 * @return
	 */
	@Keyword
	public boolean takeScreenshot(String expectedFilename, FailureHandling flowControl = FailureHandling.STOP_ON_FAILURE){
		WebDriver driver = DriverFactory.getWebDriver()
		try{
			//Convert web driver object to TakeScreenshot
			TakesScreenshot scrShot = (TakesScreenshot)driver

			//Call getScreenshotAs method to create image file
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE)

			//Move image file to new destination
			File DestFile = new File(expectedFilename)

			//Copy file at destination
			FileUtils.copyFile(SrcFile, DestFile)
		}catch(ex){
			handleError(ex, flowControl)
		}
	}

	/**
	 * Take screenshot of the element
	 * @param expectedFilename the location of expected image
	 * @param elementLocator the locator of desired element to take screenshot
	 * @param flowControl control behavior of the execution
	 * @return
	 */
	@Keyword
	public void takeElementScreenshot(String expectedFilename, String elementLocator, FailureHandling flowControl = FailureHandling.STOP_ON_FAILURE){
		WebDriver driver = DriverFactory.getWebDriver()
		try{
			//Locate the web element
			WebElement logo = driver.findElement(By.xpath(elementLocator));

			//Define new destination for image file
			File DestFile = new File(expectedFilename)

			//Call getScreenshotAs method to create image file
			File SrcFile = logo.getScreenshotAs(OutputType.FILE)

			//Copy file at destination
			FileUtils.copyFile(SrcFile, DestFile)
		}catch(ex){
			handleError(ex, flowControl)
		}
	}
}
