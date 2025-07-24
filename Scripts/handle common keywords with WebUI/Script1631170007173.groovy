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
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Test Cases/delete all cookies'), null)

WebUI.delay(5)

WebUI.openBrowser(GlobalVariable.curaAUT)

def cookies = DriverFactory.getWebDriver().manage().getCookies().size()

WebUI.verifyNotEqual(cookies, 0)

WebUI.verifyLessThan(cookies, 0, FailureHandling.OPTIONAL)

WebUI.verifyGreaterThan(cookies, 0)

WebUI.comment("The cookies observed is: " + cookies)

'This checkpoint marked the data and Source data are NOT matched'
boolean isFalse = WebUI.verifyCheckpoint(findCheckpoint('Checkpoints/Checkpoint - James'), true, FailureHandling.OPTIONAL)

'This checkpoint marked the data and Source data are matched'
boolean isTrue = WebUI.verifyCheckpoint(findCheckpoint('Checkpoints/Checkpoint - Yaya info'), false)
