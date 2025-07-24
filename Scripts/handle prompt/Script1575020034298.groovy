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

def button = findTestObject('Object Repository/Page_Demo AUT/button_Click me')

WebUI.openBrowser(GlobalVariable.sampleAUTPromptPage)

def name = "John"

'Click the button to show the prompt dialog which asks for user\'s name input'
WebUI.click(button)

WebUI.verifyAlertPresent(GlobalVariable.defaultTimeout)

WebUI.setAlertText(name)

WebUI.acceptAlert()

'Verify a greeting shows up as a result of inputting name to the prompt dialog and clicking OK'
WebUI.verifyTextPresent("Hello " + name, false)

WebUI.verifyAlertNotPresent(GlobalVariable.defaultTimeout)

'Click the button to show the prompt dialog again'
WebUI.click(button)

WebUI.verifyAlertPresent(GlobalVariable.defaultTimeout)

WebUI.dismissAlert()

WebUI.verifyAlertNotPresent(GlobalVariable.defaultTimeout)