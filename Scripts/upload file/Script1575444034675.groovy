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

import com.kms.katalon.core.configuration.RunConfiguration

import com.kms.katalon.core.webui.common.WebUiCommonHelper

WebUI.openBrowser(GlobalVariable.sampleAUTFileUploadPage)

def uploadedFileName = "sample-text-file.txt"

def fileUploadInput = findTestObject('Object Repository/Page_Demo AUT/input_Capture object_file-upload')

String uploadedFilePath = RunConfiguration.getProjectDir() + File.separator + "Sample Files" + File.separator + uploadedFileName

WebUI.verifyTextNotPresent(uploadedFileName, false)

WebUI.uploadFile(fileUploadInput, uploadedFilePath)

'Verify the name of the uploaded file show up on page (this only occurs if we have uploaded a file)'
WebUI.verifyTextPresent(uploadedFileName, false)
