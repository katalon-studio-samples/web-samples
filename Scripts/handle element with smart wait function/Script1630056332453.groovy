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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.comment('Smart Wait function is enable for this project')

TestObject page1 = findTestObject('Page_AjaxDemo/a_Page 1')
TestObject page2 = findTestObject('Page_AjaxDemo/a_Page 2')
TestObject contentPage2 = findTestObject('Page_AjaxDemo/div_Page2_Content')

String textInPage1 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam feugiat neque vel metus sodales auctor sed et arcu. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Phasellus cursus tellus ac urna sollicitudin viverra."
String textInPage2 = "Aliquam imperdiet tempor facilisis. Sed elementum ultrices vulputate. In hac habitasse platea dictumst. In et accumsan turpis. Nullam laoreet posuere eros ac iaculis. Nullam ut velit arcu. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam erat volutpat."

WebUI.openBrowser('')
"Navigate to a ajax website - required to wait a few for loading content"

WebUI.navigateToUrl(GlobalVariable.sampleAJAXWebsiteForSmartWait)

WebUI.click(page1)

"Cus Smart Wait is enable, this step should be passed"
WebUI.verifyTextPresent(textInPage1, false)

'Disable the Smart Wait function when it\'s enabled by default in Project Settings.'
WebUI.disableSmartWait()

WebUI.click(page2)

'Without enableSmartWait, this step should be failed due to no wait for loading content - mark steps as warning'
WebUI.verifyElementText(contentPage2, textInPage2, FailureHandling.OPTIONAL)

WebUI.navigateToUrl(GlobalVariable.sampleAJAXWebsiteForSmartWait)

WebUI.click(page1)

'Enable the Smart Wait function when it\'s disabled by using above keyword.'
WebUI.enableSmartWait()

WebUI.click(page2)

'Cus Smart Wait is enable, this step should be passed'
WebUI.verifyElementText(contentPage2, textInPage2, FailureHandling.CONTINUE_ON_FAILURE)