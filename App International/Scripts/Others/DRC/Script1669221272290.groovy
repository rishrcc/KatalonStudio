package com.utils;

import internal.GlobalVariable;
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint;
import static com.kms.katalon.core.model.FailureHandling.CONTINUE_ON_FAILURE
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase;
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData;
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject;
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject;

import com.kms.katalon.core.annotation.Keyword;
import com.kms.katalon.core.checkpoint.Checkpoint;
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords;
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords;
import com.kms.katalon.core.model.FailureHandling;
import com.kms.katalon.core.testcase.TestCase;
import com.kms.katalon.core.testdata.TestData;
import com.kms.katalon.core.testobject.TestObject;
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords;
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords;
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords;


import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import io.appium.java_client.AppiumDriver
import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent

import com.mongodb.client.MongoCursor
import com.mongodb.MongoClient
import com.mongodb.BasicDBObject
import com.mongodb.DBObject
import com.mongodb.DBCursor
import com.mongodb.MongoCredential as MongoCredential
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import com.mongodb.MongoClientURI
import com.mongodb.client.result.DeleteResult
import com.networknt.schema.CustomErrorMessageType
import com.mongodb.client.FindIterable
import org.bson.Document
import groovy.json.JsonSlurper
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Date
import java.text.NumberFormat

import CustomKeywords.*
/*
Mobile.startApplication('C:\\Users\\RishabhGungah\\Downloads\\app-odb-release (2).apk', false)

Mobile.tap(findTestObject('null'), 10)

Mobile.tap(findTestObject('null'), 10)

Mobile.tap(findTestObject('null'), 10)

Mobile.setText(findTestObject('null'), 'test', 10)

Mobile.tap(findTestObject('null'), 10)

//Mobile.hideKeyboard()
Mobile.tap(findTestObject('null'), 10)

Mobile.tap(findTestObject('null'), 10)

Mobile.tap(findTestObject('null'), 10)

Mobile.tap(findTestObject('null'), 10)

Mobile.delay(5)

int deviceWidth = Mobile.getDeviceWidth()
println deviceWidth

int deviceEnd = deviceWidth/10

Mobile.swipe(deviceWidth-80, deviceWidth-80, deviceWidth-80, deviceEnd+350)

Mobile.tap(findTestObject('null'), 10)


import java.text.SimpleDateFormat
import java.util.Date

Date date = new Date()

SimpleDateFormat myDateFormat = new SimpleDateFormat("EEEE d MMM")
String dateText = myDateFormat.format(date)
println(dateText)



		double finalamount = -19.29
		double iniamount = -18.18
		println finalamount
		
		NumberFormat nf = NumberFormat.getInstance()
		nf.setMinimumFractionDigits(2)
		nf.setMaximumFractionDigits(2)
		
		double cal3x = ((3.18) - ((3.18/3) + (0.0145*3.18)))
		println cal3x
		
		String expectedAmtAfter3xSplit = nf.format(GlobalVariable.initialAmt - 3.18 + cal3x)
		String expectedAmtAfter3xSplitstr = expectedAmtAfter3xSplit.toString()
		println expectedAmtAfter3xSplitstr
		String finalAmountAfter3xSplitStr = finalamount.toString()
		GlobalVariable.autobalanceFilterExpAmt3xSplit = expectedAmtAfter3xSplitstr
		Mobile.verifyMatch(finalAmountAfter3xSplitStr, expectedAmtAfter3xSplitstr, false)

*/

		JsonSlurper slurper = new JsonSlurper()

		//Get token
		def XPO_ACCESS = WS.sendRequest(findTestObject('Object Repository/API/X1- SMO Get STS access token'))
		def get_token_result = slurper.parseText(XPO_ACCESS.getResponseBodyContent())
		def xpo_access_token = get_token_result.getAt("access_token")
		GlobalVariable.xpo_access_token = xpo_access_token
		println xpo_access_token

		//Execute api to simulate card transaction
		//GlobalVariable.cardNo = card
		//println GlobalVariable.cardNo
		
		def card_transaction = WS.sendRequest(findTestObject('Object Repository/API/cardAuthorization3x'))
		String cardTransactionCODE = card_transaction.getStatusCode()
		def result0 = slurper.parseText(card_transaction.getResponseBodyContent())
		println "Status code for card transaction:" + cardTransactionCODE
		
		//Retrieve id
		def cardauth_id = result0.getAt("id")
		GlobalVariable.cardauth_id = cardauth_id
		println GlobalVariable.cardauth_id
		
		//MobileElement element = (MobileElement) driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"text_to_find\"));");
		