import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

response1 = WS.sendRequest(findTestObject('SOAP/GetCountries'))

String xml1 = response1.responseBodyContent

println('\n xml1 value is ' + xml1)

def dataValue = new XmlSlurper().parseText(xml1)

def countryCode = dataValue.ListOfCountryNamesByNameResult.tCountryCodeAndName[2].sISOCode

println('\n.. Country Code extracted is: ' + countryCode)

GlobalVariable.countryCode = countryCode

println('\n.. Global variable CountryCode is: ' + GlobalVariable.countryCode)

response2 = WS.sendRequest(findTestObject('SOAP/GetCapital', [('countryCode') : GlobalVariable.countryCode]))

xml2 = response2.responseBodyContent

println('\n xml2 value is ' + xml2)

def dataValue2 = new XmlSlurper().parseText(xml2)

println('\n dataValue2 is ' + dataValue2)

