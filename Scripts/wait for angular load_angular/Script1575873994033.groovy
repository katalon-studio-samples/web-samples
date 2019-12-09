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
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser(GlobalVariable.sampleAngularAUT)

WebUI.setText(findTestObject('Object Repository/Page_Angular 25 User Registration and Login_744ef3/input_First Name_firstName'), 
    'John')

WebUI.setText(findTestObject('Object Repository/Page_Angular 25 User Registration and Login_744ef3/input_Last Name_lastName'), 
    'Doe')

WebUI.setText(findTestObject('Object Repository/Page_Angular 25 User Registration and Login_744ef3/input_Username_username'), 
    'John Doe')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Angular 25 User Registration and Login_744ef3/input_Password_password'), 
    'tzH6RvlfSTg=')

WebUI.click(findTestObject('Object Repository/Page_Angular 25 User Registration and Login_744ef3/button_Register'))

WebUI.waitForAngularLoad(2)

WebUI.setText(findTestObject('Object Repository/Page_Angular Protractor Example/input_Username_username'), 'John Doe')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Angular Protractor Example/input_Password_password_1'), 'tzH6RvlfSTg=')

WebUI.click(findTestObject('Object Repository/Page_Angular Protractor Example/button_Login'))

WebUI.waitForAngularLoad(2)

WebUI.click(findTestObject('Object Repository/Page_Angular Protractor Example/a_Logout'))

