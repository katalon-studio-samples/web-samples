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
import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.common.WebUiCommonHelper

WebUI.openBrowser(GlobalVariable.sampleAUTWebFormPage)

def firstNameInput = findTestObject('Object Repository/Page_Demo AUT/input_First name_firstName')

WebUI.verifyElementPresent(firstNameInput, GlobalVariable.defaultTimeout)

WebUI.verifyElementVisible(firstNameInput)

'Get the corresponding Selenium WebElement of firstNameInput'
WebElement inputElement = WebUiCommonHelper.findWebElement(firstNameInput, GlobalVariable.defaultTimeout)

'Hide the inpute element by setting css property display to "none"'
WebUI.executeJavaScript("arguments[0].style.display = 'none'", Arrays.asList(inputElement))

WebUI.verifyElementPresent(firstNameInput, GlobalVariable.defaultTimeout)

WebUI.verifyElementNotVisible(firstNameInput)

'Reset the value of display property'
WebUI.executeJavaScript("arguments[0].style.display = 'block'", Arrays.asList(inputElement))

WebUI.verifyElementVisible(firstNameInput)

'Hide the input element again by setting css property visibility to "hidden"'
WebUI.executeJavaScript("arguments[0].style.visibility = 'hidden'", Arrays.asList(inputElement))

WebUI.verifyElementPresent(firstNameInput, GlobalVariable.defaultTimeout)

WebUI.verifyElementNotVisible(firstNameInput)