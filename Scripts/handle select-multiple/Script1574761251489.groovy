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

def multiselectBox = findTestObject('Object Repository/Page_Demo AUT/select_High salaryNice managerleaderExcelle_8daca8')

WebUI.selectAllOption(multiselectBox)

WebUI.verifyEqual(WebUI.getNumberOfSelectedOption(multiselectBox), 6) // All 6 options in the select element have been selected

WebUI.verifyOptionSelectedByValue(multiselectBox, "High salary", false, 5) // first option

WebUI.deselectOptionByValue(multiselectBox, "High salary", false)

WebUI.verifyOptionNotSelectedByValue(multiselectBox, "High salary", false, 5)

WebUI.deselectOptionByIndex(multiselectBox, "1, 2")

WebUI.verifyOptionNotSelectedByIndex(multiselectBox, "1, 2", 5)

WebUI.deselectOptionByLabel(multiselectBox, "Good teamwork", false) // third option

WebUI.verifyOptionNotSelectedByLabel(multiselectBox, "Good teamwork", false, 5)

WebUI.deselectAllOption(multiselectBox)

WebUI.verifyEqual(WebUI.getNumberOfSelectedOption(multiselectBox), 0)