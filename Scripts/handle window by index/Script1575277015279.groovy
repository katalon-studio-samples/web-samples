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

import com.kms.katalon.core.webui.driver.DriverFactory

import org.openqa.selenium.Keys as Keys

WebUI.openBrowser(GlobalVariable.sampleAUTOpenNewWindowPage)

WebUI.setText(findTestObject('Object Repository/Page_Demo AUT/input_Open New Window_window-title'), 'www.google.com')

'Click to open new window'
WebUI.click(findTestObject('Object Repository/Page_Demo AUT/button_Open New Window'))

WebUI.verifyEqual(WebUI.getWindowIndex(), 0)

WebUI.switchToWindowIndex(1)

WebUI.verifyEqual(WebUI.getWindowIndex(), 1)

'Verify that there are 2 opened windows'
WebUI.verifyEqual(DriverFactory.getWebDriver().getWindowHandles().size(), 2)

WebUI.closeWindowIndex(0)

WebUI.verifyEqual(DriverFactory.getWebDriver().getWindowHandles().size(), 1)
