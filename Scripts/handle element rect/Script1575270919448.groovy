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

WebUI.openBrowser(GlobalVariable.sampleAUTElementRectPage)

'Find the only div in the page which has width: 200px, height: 100px, left: 100px, top: 200px'
def element = findTestObject('Object Repository/Page_Demo AUT/div_This is a div with width 200px height 100px left 100px top 200px') 

def elementWidth = WebUI.getElementWidth(element)

WebUI.verifyEqual(elementWidth, 200)

def elementHeight = WebUI.getElementHeight(element)

WebUI.verifyEqual(elementHeight, 100)

def elementLeftPosition = WebUI.getElementLeftPosition(element)

WebUI.verifyEqual(elementLeftPosition, 100)