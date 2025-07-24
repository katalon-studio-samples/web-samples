import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser(GlobalVariable.sampleAUTElementAttributeChangePage)

def changeColorButton = findTestObject('Object Repository/Page_Demo AUT/button_Click this button to change its color after 5 seconds')

'Click the changeColorButton to change its "class" attribute value after 5 seconds'
WebUI.click(changeColorButton)

'Verify the value of "class" attribute before 5 seconds elapse'
WebUI.verifyEqual(WebUI.getAttribute(changeColorButton, "class"), "btn btn-primary")

WebUI.waitForElementAttributeValue(changeColorButton, "class", "btn btn-success", 10)

'Verify the value of "class" attribute has been changed after waiting for 5 seconds'
WebUI.verifyEqual(WebUI.getAttribute(changeColorButton, "class"), "btn btn-success")




