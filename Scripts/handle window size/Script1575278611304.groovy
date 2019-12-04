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

import org.openqa.selenium.Dimension

import org.openqa.selenium.Point

WebUI.openBrowser(GlobalVariable.sampeAUTIndexPage)

Dimension initialSize = new Dimension(600, 600)

'Set initial size for window'
WebUI.setViewPortSize(initialSize.width, initialSize.height)

Dimension currentSize = DriverFactory.getWebDriver().manage().window().getSize()

WebUI.verifyEqual(currentSize, initialSize)

WebUI.maximizeWindow()

currentSize = DriverFactory.getWebDriver().manage().window().getSize()

WebUI.verifyGreaterThan(currentSize.width, initialSize.width)

WebUI.verifyGreaterThan(currentSize.height, initialSize.height)
