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

WebUI.openBrowser(GlobalVariable.sampleAUTWebFormPage)

WebUI.navigateToUrl('https://katalon-test.s3.amazonaws.com/aut/html/form.html')

WebUI.setText(findTestObject('Page_Demo AUT/input_First name_firstName'), 'John')

WebUI.setText(findTestObject('Page_Demo AUT/input_Last name_lastName'), 'Doe')

WebUI.click(findTestObject('Page_Demo AUT/input_Male_gender'))

WebUI.setText(findTestObject('Object Repository/Page_Demo AUT/input_Date of birth_dob'), '05/08/1993')

WebUI.setText(findTestObject('Object Repository/Page_Demo AUT/input_Address_address'), 'US')

WebUI.setText(findTestObject('Object Repository/Page_Demo AUT/input_Email_email'), 'John@xyz.com')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Demo AUT/input_Password_password'), 'tzH6RvlfSTg=')

WebUI.setText(findTestObject('Object Repository/Page_Demo AUT/input_Company_company'), 'KMS')

WebUI.selectOptionByValue(findTestObject('Page_Demo AUT/select_High salaryNice managerleaderExcelle_8daca8'), 'High salary', 
    true)

WebUI.click(findTestObject('Object Repository/Page_Demo AUT/input'))

WebUI.submit(findTestObject('Page_Demo AUT/button_Submit'))

'Verify a text shows up as a result of submitting the form'
WebUI.verifyTextPresent("Successfully submitted!", false)

