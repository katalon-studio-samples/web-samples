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

def removeImageSrcButton = findTestObject('Object Repository/Page_Demo AUT/button_Click this button to remove source of the below image after 5 seconds') 

def image = findTestObject('Object Repository/Page_Demo AUT/img_Click this button to remove source of the below image after 5 seconds_image-with-source') 

'Click the button to add the "src" attribute for the image after 5 seconds'
WebUI.click(removeImageSrcButton)

WebUI.verifyElementHasAttribute(image, "src", 1)

WebUI.waitForElementNotHasAttribute(image, "src", 10)

WebUI.verifyElementNotHasAttribute(image, "src", 1)