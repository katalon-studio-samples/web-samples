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

WebUI.openBrowser(GlobalVariable.sampleAUTClickPage)

def clickButton = findTestObject('Object Repository/Page_Demo AUT/button_Click me_click page') 

WebUI.verifyTextNotPresent("You have clicked the button!", false)

WebUI.click(clickButton)

WebUI.verifyTextPresent("You have clicked the button!", false)

WebUI.verifyTextNotPresent("You have double-clicked the button!", false)

WebUI.doubleClick(clickButton)

WebUI.verifyTextPresent("You have double-clicked the button!", false)

WebUI.verifyTextNotPresent("You have right clicked the button!", false)

WebUI.rightClick(clickButton)

WebUI.verifyTextPresent("You have right clicked the button!", false)

WebUI.enhancedClick(clickButton)

WebUI.verifyTextPresent("You have clicked the button!", false)

