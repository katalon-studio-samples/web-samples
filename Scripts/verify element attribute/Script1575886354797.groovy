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

WebUI.openBrowser(GlobalVariable.sampleAUTWebFormPage)

def input = findTestObject('Object Repository/Page_Demo AUT/input_First name_firstName')

WebUI.verifyElementHasAttribute(input, "id", GlobalVariable.defaultTimeout)

WebUI.verifyEqual(WebUI.getAttribute(input, "id"), "first-name")

def verifyIdAttributeResult = WebUI.verifyElementAttributeValue(input, "id", "first-name", GlobalVariable.defaultTimeout)

WebUI.verifyEqual(verifyIdAttributeResult, true)

def verifyIncorrectIdAttributeResult = WebUI.verifyElementAttributeValue(input, "id", "incorrect-id", GlobalVariable.defaultTimeout, FailureHandling.OPTIONAL)

WebUI.verifyEqual(verifyIncorrectIdAttributeResult, false)

WebUI.verifyElementNotHasAttribute(input, "href", GlobalVariable.defaultTimeout)

WebUI.verifyEqual(WebUI.getAttribute(input, "href"), null)

boolean verifyHrefAttributeResult = WebUI.verifyElementAttributeValue(input, "href", "whatever", GlobalVariable.defaultTimeout, FailureHandling.OPTIONAL)

'Verifying the value of an unavailable attribute will always return false'
WebUI.verifyEqual(verifyHrefAttributeResult, false)


