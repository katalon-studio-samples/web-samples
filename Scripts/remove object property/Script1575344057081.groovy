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

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.TestObjectProperty

TestObject testObject = new TestObject()

TestObjectProperty property1 = new TestObjectProperty("property_1", ConditionType.EQUALS, "property_value_1", true)

TestObjectProperty property2 = new TestObjectProperty("property_2", ConditionType.EQUALS, "property_value_2", true)

testObject.addProperty(property1)

testObject.addProperty(property2)

WebUI.verifyEqual(testObject.getProperties().size(), 2)

'Remove a property with undefined name'
WebUI.removeObjectProperty(testObject, "property_3")

'Verify that removing a property with undefined name does not remove anything'
WebUI.verifyEqual(testObject.getProperties().size(), 2)

'Remove a property with pre-defined name'
WebUI.removeObjectProperty(testObject, "property_2")

'Verify that removing a property with pre-defined name does remove the corresponding property'
WebUI.verifyEqual(testObject.getProperties().size(), 1)

WebUI.verifyEqual(((TestObjectProperty) testObject.getProperties().get(0)).getName(), "property_1")

