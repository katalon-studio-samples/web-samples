import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

import org.openqa.selenium.WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import java.awt.Color
import org.openqa.selenium.Rectangle as Rectangle

WebUI.openBrowser('')
WebDriver driver = DriverFactory.getWebDriver()
driver.get(GlobalVariable.sampleAUTShoppingCart)
WebUI.waitForPageLoad(GlobalVariable.defaultTimeout)
WebUI.maximizeWindow()
WebUI.delay(5)

String uniqueString = UUID.randomUUID().toString().substring(0, 3)
TestObject expectedElement = findTestObject("Object Repository/Page_Demo AUT/a_Katalon Shop")

'take element screenshot by webdriver and put the screenshot to /Screenshots/Webdriver'
String expectedFilename = RunConfiguration.getProjectDir() + '/Screenshots/Webdriver/driverElement' + uniqueString + '.png'
CustomKeywords.'webdriver.screenshot.TakeScreenshot.takeElementScreenshot'(expectedFilename, elementLocator, FailureHandling.STOP_ON_FAILURE)

'take element screenshot by Katalon keyword and put the screenshot to /Screenshots/Katalon'
WebUI.takeElementScreenshot("Screenshots/Katalon/ksElement" + uniqueString + ".png", expectedElement)

'Compare two images of the same element taken by webdriver and katalon keyword'
String actualFilename = RunConfiguration.getProjectDir() + '/Screenshots/Katalon/ksElement' + uniqueString + '.png'
CustomKeywords.'katalon.verifyImage.ImageComparison.areMatched'(expectedFilename,  actualFilename, FailureHandling.CONTINUE_ON_FAILURE)




