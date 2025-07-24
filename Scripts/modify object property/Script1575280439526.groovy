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

TestObjectProperty property = new TestObjectProperty("property_1", ConditionType.EQUALS, "property_value_1", true)

testObject.addProperty(property)

'Modify property value with a null value'
WebUI.modifyObjectProperty(testObject, "property_1", ConditionType.EQUALS.toString(), null, true)

'Verify modifying the property value with a null value does not change the value'
WebUI.verifyEqual(property.getValue(), "property_value_1")

'Modify property value with a non-null value'
WebUI.modifyObjectProperty(testObject, "property_1", ConditionType.EQUALS.toString(), "property_value_1_modified", true)

'Verify modifying the property value with a non-null value does update the value'
WebUI.verifyEqual(property.getValue(), "property_value_1_modified")

'Modify property condition type with a null value'
WebUI.modifyObjectProperty(testObject, "property_1", null, "property_value_1_modified", true)

'Verify modifying the condition type with a null value does not change the condition type'
WebUI.verifyEqual(property.getCondition(), ConditionType.EQUALS)

'Modify property condition type with an invalid value (which is not one of the predefined condition types)'
WebUI.modifyObjectProperty(testObject, "property_1", "invalid condition type", "property_value_1_modified", true)

'Verify modifying the condition type with an invalid value does not change the condition type'
WebUI.verifyEqual(property.getCondition(), ConditionType.EQUALS)

'Modify property condition type with a non-null and valid value'
WebUI.modifyObjectProperty(testObject, "property_1", ConditionType.NOT_EQUAL.toString(), "property_value_1_modified", true)

'Verify modifying the condition type with a non-null and valid value does update the condition type'
WebUI.verifyEqual(property.getCondition(), ConditionType.NOT_EQUAL)

'Modify proptery active state to false'
WebUI.modifyObjectProperty(testObject, "property_1", ConditionType.NOT_EQUAL.toString(), "property_value_1_modified", false)

WebUI.verifyEqual(property.isActive(), false)

    