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
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

WebUI.openBrowser(GlobalVariable.sampleAUTLinkPage)

def urls = WebUI.getAllLinksOnCurrentPage(true, null)

List<WebElement> scriptLinks = DriverFactory.getWebDriver().findElements(By.tagName("script"))

'Not count invisible script links, just count those that are visible on the page'
def allUrlsCount = urls.size() - scriptLinks.size()

'Verify the number of valid visible links on page is 4, while there are 5 visible links on page. This is because there is one email link which has href starting with mailto: and this is not counted by Katalon. Katalon just count href which starts with http or https'
WebUI.verifyEqual(allUrlsCount, 4)

'Get all links from the page, except for those that have the URL of https://www.google.com. There is only one such link on the page.'
urls = WebUI.getAllLinksOnCurrentPage(true, ["https://www.google.com/"])

WebUI.verifyEqual(urls.size() - scriptLinks.size(), allUrlsCount - 1)

'Get all links from the page, but does not allow links which have URL coming from other hosts.'
urls = WebUI.getAllLinksOnCurrentPage(false, null)

'Verify that there is only one link which has the URL coming from the current host. That is the only iframe in the page.'
WebUI.verifyEqual(urls.size(), 1)

