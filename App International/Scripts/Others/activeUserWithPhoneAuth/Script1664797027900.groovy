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

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.keyword.builtin.VerifyMatchKeyword as VerifyMatchKeyword
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
import groovy.json.JsonSlurper as JsonSlurper
import java.text.SimpleDateFormat as SimpleDateFormat
import java.time.LocalDate as LocalDate
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

if (GlobalVariable.db == 'pprd')
{
	MongoClientURI connectionString = new MongoClientURI(GlobalVariable.mongoPreprodURI)
	MongoClient mongoClient = new MongoClient(connectionString)
	println('Connect to database successfully')

	MongoDatabase mongoDb = mongoClient.getDatabase('odb_account')
	MongoCollection<Document> mongoUsersCollection = mongoDb.getCollection('users')
	Document oneyuser_active = mongoUsersCollection.find(new Document('user_profile.status', 'active')).first()
	ActiveUser = oneyuser_active.toJson()
	println(ActiveUser)
	
	JsonSlurper slurper = new JsonSlurper()
	Map parsedJson = slurper.parseText(ActiveUser)
	String ActiveUser_email = parsedJson.email
	String UID = parsedJson.uid
	println ActiveUser_email
	println UID
	
	MongoDatabase mongoDb2 = mongoClient.getDatabase('odb_authentication')
	MongoCollection<Document> mongoUsersCollection2 = mongoDb2.getCollection('users')
	Document ActiveUser_auth = mongoUsersCollection2.find(new Document('email', ActiveUser_email)).first()
	ActiveUserAuth = ActiveUser_auth.toJson()
	println(ActiveUserAuth)
	
	Map parsedJson2 = slurper.parseText(ActiveUserAuth)
	String phoneauth = parsedJson2.phone
	String pincode = parsedJson2.pinCode
	println phoneauth
	println pincode
	
	
	if ((phoneauth != null) && (pincode == null))
	{
		GlobalVariable.dynEmail = ActiveUser_email
		GlobalVariable.userprofile_status = 'active'
		println "Email: " + ActiveUser_email
		println "UID: " + UID
	}

	else
	{
		println ("Data issue. Phone number may be absent or pin code has been set for this user.")
	}
}

else if (GlobalVariable.db == 'dev')
{
	MongoClientURI connectionString = new MongoClientURI(GlobalVariable.mongoDevURI)
	MongoClient mongoClient = new MongoClient(connectionString)
	println('Connect to database successfully')

	MongoDatabase mongoDb = mongoClient.getDatabase('odb_account')
	MongoCollection<Document> mongoUsersCollection = mongoDb.getCollection('users')
	Document oneyuser_active = mongoUsersCollection.find(new Document('user_profile.status', 'active')).first()
	ActiveUser = oneyuser_active.toJson()
	println(ActiveUser)

	JsonSlurper slurper = new JsonSlurper()
	Map parsedJson = slurper.parseText(ActiveUser)
	String ActiveUser_email = parsedJson.email
	String UID = parsedJson.uid
	println ActiveUser_email
	println UID


	MongoDatabase mongoDb2 = mongoClient.getDatabase('odb_authentication')
	MongoCollection<Document> mongoUsersCollection2 = mongoDb2.getCollection('users')
	Document ActiveUser_auth = mongoUsersCollection2.find(new Document('email', ActiveUser_email)).first()
	ActiveUserAuth = ActiveUser_auth.toJson()
	println(ActiveUserAuth)

	Map parsedJson2 = slurper.parseText(ActiveUserAuth)
	String phoneauth = parsedJson2.phone
	String pincode = parsedJson2.pinCode
	println phoneauth
	println pincode

	if ((phoneauth != null) && (pincode == null))
	{
		GlobalVariable.dynEmail = ActiveUser_email
		GlobalVariable.userprofile_status = 'active'
		println "Email: " + ActiveUser_email
		println "UID: " + UID
	}

	else
	{
		println ("Data issue. Phone number may be absent or pin code has been set for this user.")
	}
}

else
{
	println "Please specify database in Profile"
}
