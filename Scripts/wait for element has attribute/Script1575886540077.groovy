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

WebUI.openBrowser(GlobalVariable.sampleAUTElementAttributeChangePage)

def setImageSrcButton = findTestObject('Object Repository/Page_Demo AUT/button_Click this button to set the source for the below image after 5 seconds')

def imageWithoutSrc = findTestObject('Object Repository/Page_Demo AUT/img_Click this button to set the source for the below image after 5 seconds_no-source-image')

'Click the button to add the "src" attribute for the image after 5 seconds'
WebUI.click(setImageSrcButton) 

WebUI.verifyElementNotHasAttribute(imageWithoutSrc, "src", 1)

WebUI.waitForElementHasAttribute(imageWithoutSrc, "src", 5)

WebUI.verifyElementHasAttribute(imageWithoutSrc, "src", 1)