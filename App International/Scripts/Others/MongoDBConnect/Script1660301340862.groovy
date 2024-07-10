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
/*
MongoClientURI connectionString = new MongoClientURI('mongodb://pprd-odb-cosmos-hmzsm:BtNSVU75CfG6v9dDqKaDtC6lbvHOOWbyHFYHgKOnYckJm1cdkM2QFUVs2IfTHFF0poFUe7vLGCxaZa3HzsdSmw%3D%3D@pprd-odb-cosmos-hmzsm.mongo.cosmos.azure.com:10255/admin?ssl=true&replicaSet=globaldb&readPreference=primary&maxIdleTimeMS=120000&connectTimeoutMS=10000&authSource=admin&authMechanism=SCRAM-SHA-1&3t.uriVersion=3&3t.connection.name=PREPROD&3t.databases=admin&3t.alwaysShowAuthDB=true&3t.alwaysShowDBFromUserRole=true&3t.sslTlsVersion=TLS')

MongoClient mongoClient = new MongoClient(connectionString)

println('Connect to database successfully')

MongoDatabase mongoDb = mongoClient.getDatabase('odb_account')

MongoCollection<Document> mongoUsersCollection = mongoDb.getCollection('users')

Document oneyuser = mongoUsersCollection.find(new Document('uid', GlobalVariable.UID)).first()

pop = oneyuser.toJson()

println(pop)

JsonSlurper slurper = new JsonSlurper()

Map parsedJson = slurper.parseText(pop)

String onboardid = parsedJson.user_profile.status

println(onboardid)
*/

MongoClientURI connectionString = new MongoClientURI(GlobalVariable.mongoPreprodURI)
MongoClient mongoClient = new MongoClient(connectionString)
println ("Connect to database successfully")

MongoDatabase mongoDb = mongoClient.getDatabase("odb_account_management")
MongoCollection<Document> mongoUsersCollection = mongoDb.getCollection("accounts")

Document bankacc_details = mongoUsersCollection.find(new Document('uid', GlobalVariable.UID)).first()
def full_bankacc_details = bankacc_details.toJson()
println full_bankacc_details

JsonSlurper slurper = new JsonSlurper()
Map parsedJson = slurper.parseText(full_bankacc_details)

//to use external id instead - Still in dev yet to be deployed on preprod
String accountId = parsedJson.situation.status
//String accountId = parsedJson.id
println accountId
