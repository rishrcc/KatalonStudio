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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable
import java.time.*
import org.apache.commons.lang.RandomStringUtils
import java.io.File

import com.mongodb.client.MongoCursor as MongoCursor
import com.mongodb.MongoClient as MongoClient
import com.mongodb.BasicDBObject as BasicDBObject
import com.mongodb.DBObject as DBObject
import com.mongodb.DBCursor as DBCursor
import com.mongodb.MongoCredential as MongoCredential
import com.mongodb.client.MongoCollection as MongoCollection
import com.mongodb.client.MongoDatabase as MongoDatabase
import com.mongodb.MongoClientURI as MongoClientURI
import com.mongodb.client.result.DeleteResult as DeleteResult
import com.mongodb.client.FindIterable as FindIterable
import org.bson.Document as Document

def slurper= new groovy.json.JsonSlurper()

//Get access token
def XPO_ACCESS = WS.sendRequest(findTestObject('Object Repository/API/X1- SMO Get STS access token'))
def result16 = slurper.parseText(XPO_ACCESS.getResponseBodyContent())
xpo_access_token = result16.getAt("access_token")
GlobalVariable.xpo_access_token = xpo_access_token
println xpo_access_token

//Get user details
def GET_USER_DETAILS_XPO = WS.sendRequest(findTestObject('Object Repository/API/X2- Get user'))
def result17 = slurper.parseText(GET_USER_DETAILS_XPO.getResponseBodyContent())
xpo_user_id = result17.getAt("Id")
xpo_display_name = (result17.getAt("SubAccounts").getAt("DisplayName")).toString()

int XPO_NAME_Startind = xpo_display_name.indexOf("[")
int XPO_NAME_Endind = xpo_display_name.indexOf("]")
String xpo_display_name_trim = xpo_display_name.substring(XPO_NAME_Startind+1,XPO_NAME_Endind)

xpo_onboarding_date =result17.getAt("OnBoardingDate")

GlobalVariable.xpo_user_id = xpo_user_id
GlobalVariable.xpo_display_name_trim =xpo_display_name_trim
GlobalVariable.xpo_onboarding_date = xpo_onboarding_date

println "User Id:" + xpo_user_id
println "Full name:" + xpo_display_name_trim
println "Onboarding date:" + xpo_onboarding_date

//Generate order id
String order_id_gen = Instant.now()
String trim_order_id_gen_1 = order_id_gen.replaceAll('-', '')
println trim_order_id_gen_1
String trim_order_id_gen_2 = trim_order_id_gen_1.replaceAll('T', '')
println trim_order_id_gen_2
String trim_order_id_gen_3 = trim_order_id_gen_2.replaceAll(':', '')
println trim_order_id_gen_3
String trim_order_id_gen_4 = trim_order_id_gen_3.replaceAll('Z', '')
println trim_order_id_gen_4
String trim_order_id_gen_5 = trim_order_id_gen_4.replace('.', '')
println trim_order_id_gen_5

String order_id = "ORDER_"+ trim_order_id_gen_5
GlobalVariable.order_id = order_id
println "Order id: " + order_id


//Simulate SCT IN

sleep(3000)

sleep(10000)

def SIM_SCT_IN = WS.sendRequest(findTestObject('Object Repository/API/X3- SCT IN'))
println "SCT IN Status Code:" + SIM_SCT_IN.getStatusCode()
def result18 = slurper.parseText(SIM_SCT_IN.getResponseBodyContent())
