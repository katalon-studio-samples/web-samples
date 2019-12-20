package webdriver.screenshot

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable

import katalon.common.BaseKeyword

import org.openqa.selenium.WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.apache.commons.io.FileUtils
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot


public class TakeScreenshot extends BaseKeyword {

	/**
	 * Verify two images are matched or not
	 * @param expectedImgPath the location of expected image
	 * @param actualImgPath the location of actual image
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
}
