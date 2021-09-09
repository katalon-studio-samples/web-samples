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

WebUI.verifyEqual(WebUI.getNumberOfTotalOption(multiselectBox), 6)

WebUI.verifyOptionsPresent(multiselectBox, [
    "High salary",
    "Nice manager/leader",
    "Excellent colleagues",
    "Good teamwork",
    "Chance to go onsite",
    "Challenging"
])

'Verify option not present by label, without using regex'
WebUI.verifyOptionNotPresentByLabel(multiselectBox, "Unavailable option label", false, GlobalVariable.defaultTimeout)

'Verify option not present by label, using regex'
WebUI.verifyOptionNotPresentByLabel(multiselectBox, 'Un.*$', true, GlobalVariable.defaultTimeout)

'Verify option not present by value, without using regex'
WebUI.verifyOptionNotPresentByValue(multiselectBox, "Unavailable option value", false, GlobalVariable.defaultTimeout)

'Verify option not present by value, using regex'
WebUI.verifyOptionNotPresentByValue(multiselectBox, 'Un.*$', true, GlobalVariable.defaultTimeout)

'Verify that no option in the select element has been selected'
WebUI.verifyEqual(WebUI.getNumberOfSelectedOption(multiselectBox), 0)

WebUI.selectAllOption(multiselectBox)

'Verify that all 6 options in the select element have been selected'
WebUI.verifyEqual(WebUI.getNumberOfSelectedOption(multiselectBox), 6)

'Verify the option with value "High salary" is present, without using regex'
WebUI.verifyOptionPresentByValue(multiselectBox, "High salary", false, GlobalVariable.defaultTimeout)

'Verify the option with value "High salary" is present, using regex'
WebUI.verifyOptionPresentByValue(multiselectBox, 'High.*$', true, GlobalVariable.defaultTimeout)

'Verify the option with value "High salary" is selected, without using regex'
WebUI.verifyOptionSelectedByValue(multiselectBox, "High salary", false, GlobalVariable.defaultTimeout)

'Verify the option with value "High salary" is selected, using regex'
WebUI.verifyOptionSelectedByValue(multiselectBox, 'High.*$', true, GlobalVariable.defaultTimeout)

'Deslection the option with value "High salary", without using regex'
WebUI.deselectOptionByValue(multiselectBox, "High salary", false)

'Verify the option with value "High salary" is not selected, without using regex'
WebUI.verifyOptionNotSelectedByValue(multiselectBox, "High salary", false, GlobalVariable.defaultTimeout)

'Verify the option with value "High salary" is not selected, using regex'
WebUI.verifyOptionNotSelectedByValue(multiselectBox, 'High.*$', true, GlobalVariable.defaultTimeout)

'Deselect the second option with value "Nice manager/leader" using regex'
WebUI.deselectOptionByValue(multiselectBox, 'Nice.*$', true)

'Verify the second option with value "Nice manager/leader" is not selected using regex'
WebUI.verifyOptionNotSelectedByValue(multiselectBox, 'Nice.*$', true, GlobalVariable.defaultTimeout)

'Verify the second option with value "Nice manager/leader" is not selected, without using regex'
WebUI.verifyOptionNotSelectedByValue(multiselectBox, "Nice manager/leader", false, GlobalVariable.defaultTimeout)

WebUI.deselectOptionByIndex(multiselectBox, "2, 3")

WebUI.verifyOptionNotSelectedByIndex(multiselectBox, "2, 3", GlobalVariable.defaultTimeout)

'Verify the option with label "High salary" is present, without using regex'
WebUI.verifyOptionPresentByValue(multiselectBox, "High salary", false, GlobalVariable.defaultTimeout)

'Verify the option with label "High salary" is present, using regex'
WebUI.verifyOptionPresentByValue(multiselectBox, 'High.*$', true, GlobalVariable.defaultTimeout)

'Verify the option with label "Chance to go onsite" is present, without using regex'
WebUI.verifyOptionPresentByLabel(multiselectBox, "Chance to go onsite", false, GlobalVariable.defaultTimeout)

'Verify the option with label "Chance to go onsite" is present, using regex'
WebUI.verifyOptionPresentByValue(multiselectBox, 'Chance.*$', true, GlobalVariable.defaultTimeout)

'Deselect the fifth option which has label "Chance to go onsite", without using regex'
WebUI.deselectOptionByLabel(multiselectBox, "Chance to go onsite", false)

'Verify the fifth option which has label "Chance to go onsite" is not selected, without using regex'
WebUI.verifyOptionNotSelectedByLabel(multiselectBox, "Chance to go onsite", false, GlobalVariable.defaultTimeout)

'Verify the fifth option which has label "Chance to go onsite" is not selected using regex'
WebUI.verifyOptionNotSelectedByLabel(multiselectBox, 'Chance.*$', true, GlobalVariable.defaultTimeout)

'Deselect the last option which has label "Challenging", using regex'
WebUI.deselectOptionByLabel(multiselectBox, 'Chall.*$', true)

WebUI.verifyOptionNotSelectedByLabel(multiselectBox, "Challenging", false, GlobalVariable.defaultTimeout)

'Reselect the first option which has value "High salary", without using regex'
WebUI.selectOptionByValue(multiselectBox, "High salary", false)

WebUI.verifyOptionSelectedByValue(multiselectBox, "High salary", false, GlobalVariable.defaultTimeout)

'Reselect the second option which has value "Nice manager/leader", using regex'
WebUI.selectOptionByValue(multiselectBox, 'Nice.*$', true)

WebUI.verifyOptionSelectedByValue(multiselectBox, "Nice manager/leader", false, GlobalVariable.defaultTimeout)

'Reselect the third option which has label "Excellent colleagues", without using regex'
WebUI.selectOptionByLabel(multiselectBox, "Excellent colleagues", false)

WebUI.verifyOptionSelectedByLabel(multiselectBox, "Excellent colleagues", false, GlobalVariable.defaultTimeout)

'Reselect the fourth option which has label "Good teamwork", using regex'
WebUI.selectOptionByLabel(multiselectBox, 'Good.*$', true)

WebUI.verifyOptionSelectedByLabel(multiselectBox, "Good teamwork", false, GlobalVariable.defaultTimeout)

WebUI.deselectAllOption(multiselectBox)

'Reselect the second and fourth options which have index in range 1, 2 (range starts from 0)'
WebUI.selectOptionByIndex(multiselectBox, "1, 3", FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyOptionSelectedByIndex(multiselectBox, "1, 3", GlobalVariable.defaultTimeout, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyEqual(WebUI.getNumberOfSelectedOption(multiselectBox), 2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.deselectAllOption(multiselectBox)

WebUI.verifyLessThanOrEqual(WebUI.getNumberOfSelectedOption(multiselectBox), 0)

