import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser(GlobalVariable.sampleAUTFileUploadPage)

def uploadedFileName = "sample-text-file.txt"

def fileUploadInput = findTestObject('Object Repository/Page_Demo AUT/input_Capture object_file-upload')

String uploadedFilePath = RunConfiguration.getProjectDir() + File.separator + "Sample Files" + File.separator + uploadedFileName

WebUI.verifyTextNotPresent(uploadedFileName, false)

WebUI.uploadFile(fileUploadInput, uploadedFilePath)

'Verify the name of the uploaded file show up on page (this only occurs if we have uploaded a file)'
WebUI.verifyTextPresent(uploadedFileName, false)
