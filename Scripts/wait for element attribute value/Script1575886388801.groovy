import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.junit.After

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

WebUI.openBrowser(GlobalVariable.sampleAUTElementAttributeChangePage)

def changeColorButton = findTestObject('Object Repository/Page_Demo AUT/button_Click this button to change its color after 5 seconds')

'Click the changeColorButton to change its "class" attribute value after 5 seconds'
WebUI.click(changeColorButton)

'Verify the value of "class" attribute before 5 seconds elapse'
WebUI.verifyEqual(WebUI.getAttribute(changeColorButton, "class"), "btn btn-primary")

WebUI.waitForElementAttributeValue(changeColorButton, "class", "btn btn-success", 5)

'Verify the value of "class" attribute has been changed after waiting for 5 seconds'
WebUI.verifyEqual(WebUI.getAttribute(changeColorButton, "class"), "btn btn-success")




