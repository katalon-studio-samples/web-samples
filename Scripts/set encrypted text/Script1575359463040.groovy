import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser(GlobalVariable.sampleAUTWebFormPage)

def rawText = "John"

'Encrypted text for rawText value'
def encryptedText = "sY0Lk5WfjiQ="

def firstnameInput = findTestObject('Object Repository/Page_Demo AUT/input_First name_firstName')

WebUI.setEncryptedText(firstnameInput, encryptedText)

WebUI.verifyElementAttributeValue(firstnameInput, "value", rawText, GlobalVariable.defaultTimeout)