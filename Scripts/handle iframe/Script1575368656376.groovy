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

import com.kms.katalon.core.webui.common.WebUiCommonHelper

import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebElement 

WebUI.openBrowser(GlobalVariable.sampleAUTIframePage)

def iframe = findTestObject('Object Repository/Page_Demo AUT/iframe_nested') 

def inputInsideIframe = findTestObject('Object Repository/Page_Demo AUT/input_First name_firstName_iframe')

def inputLocator = WebUiCommonHelper.buildLocator(inputInsideIframe)

WebUI.switchToFrame(iframe, GlobalVariable.defaultTimeout)

List<WebElement> foundElements = DriverFactory.getWebDriver().findElements(inputLocator)

'Verify that the input inside iframe can be found because we have switched to the iframe context'
WebUI.verifyEqual(foundElements.size(), 1)

WebUI.switchToDefaultContent()

foundElements = DriverFactory.getWebDriver().findElements(inputLocator)

'Verify that the input element inside iframe cannot be found because we have switched to default content'
WebUI.verifyEqual(foundElements.size(), 0)

