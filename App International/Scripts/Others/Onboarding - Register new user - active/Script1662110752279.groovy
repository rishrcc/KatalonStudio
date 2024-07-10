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

String charset = (('a'..'z')).join()

//Generate random email after each execution
Random random = new Random()
String initial = RandomStringUtils.random(3, charset.toCharArray())
String newEmail = initial + "_" + random.nextInt(9999) +"@mailsac.com"
GlobalVariable.dynEmail = newEmail
println ("Email is" + " " + newEmail)

//Generate random valid mobile number after each execution
String frenchMob = "+336"+ random.nextInt(99999999)
GlobalVariable.mobNum = frenchMob
println ("Mobile Number is" + " " + frenchMob)

//Create Random name
Integer length = 10
String Firstname = RandomStringUtils.random(length, charset.toCharArray())
String Lastname = RandomStringUtils.random(length, charset.toCharArray())
GlobalVariable.firstName = Firstname
GlobalVariable.lastName = Lastname
println ("First name is" + " " + Firstname)
println ("Last name is" + " " + Lastname)

//1. Register Create
def RegisterCreate = WS.sendRequest(findTestObject('Object Repository/API/1- Register create', ['email':GlobalVariable.dynEmail]))
def result0 = slurper.parseText(RegisterCreate.getResponseBodyContent())
String UID =  result0.(uid)
GlobalVariable.UID = UID
println ("UID of" + " " + GlobalVariable.dynEmail + " " + "is" + " " + UID)

//2. Get message from email (magic link)
sleep(5000)
def getMessagefromemail = WS.sendRequest(findTestObject('Object Repository/API/2- Get message from email (magic link)'))
def result1 = slurper.parseText(getMessagefromemail.getResponseBodyContent())
mailID = (result1.first().getAt("_id"))
GlobalVariable.emailID = mailID
//println ("Mail ID of" + " " + GlobalVariable.dynEmail + " " + "is" + " " + mailID)

//3. Get magic link from message

sleep(5000)

def WholeMes = WS.sendRequest(findTestObject('API/3- Get magic link from message'))
String MagicLinkMsg = WholeMes.getResponseText()
//println MagicLinkMsg
int MagicLinkC = MagicLinkMsg.indexOf("https://oney.page.link/")
String magicLink = MagicLinkMsg.substring(MagicLinkC,423)
GlobalVariable.magicLink = magicLink
//println ("Magic Link is" + " " + GlobalVariable.magicLink)

//4. Get invitation token from magic link 1_2
def confirmEmail = WS.sendRequest(findTestObject('Object Repository/API/4- Get invitation token from magic link 1_2'))

//4. Get invitation token from magic link 2_2
sleep(5000)
def confirmEmail2 = WS.sendRequest(findTestObject('Object Repository/API/4- Get invitation token from magic link 2_2'))
def result2 = slurper.parseText(confirmEmail2.getResponseBodyContent())
String deepLink =  result2.(deepLink)
int deepLinkStart = deepLink.indexOf("=")
String deepLinkToken = deepLink.substring(deepLinkStart+1,deepLink.length())
GlobalVariable.deepLinkToken = deepLinkToken
//println ("Deeplink of" + " " + GlobalVariable.dynEmail + " " + "is" + " " + deepLink)
//println ("Token of" + " " + GlobalVariable.dynEmail + " " + "is" + " " + deepLinkToken)

//5. Register validate (get user token)
sleep(5000)

def registerValidate = WS.sendRequest(findTestObject('Object Repository/API/5- Register validate (get user token)'))
def result3 = slurper.parseText(registerValidate.getResponseBodyContent())
String UID1 =  result3.(uid)
parsed = registerValidate.getHeaderFields().getAt("user_token")
String user_token = parsed.toString()
user_token_trim = user_token.substring(1,user_token.length()-1);
GlobalVariable.user_token = user_token_trim
println user_token_trim
println UID1

//5. Get user info

sleep(10000)

def getInfo = WS.sendRequest(findTestObject('Object Repository/API/5- Get user info'))
def getInfoJson = slurper.parseText(getInfo.getResponseBodyContent())
//println getInfoJson

parsed = getInfo.getHeaderFields()
String getInfotxt = parsed.toString()
//println getInfotxt

//6. Sign in

sleep(10000)

def signIn = WS.sendRequest(findTestObject('Object Repository/API/6- Sign in'))
def result4 = slurper.parseText(registerValidate.getResponseBodyContent())
parsed_sca = signIn.getHeaderFields().getAt("sca_token")
String sca_token = parsed_sca.toString()
sca_token_trim = sca_token.substring(1,sca_token.length()-1);
GlobalVariable.sca_token = sca_token_trim
println sca_token_trim


//set pin code
/*
def definePin = WS.sendRequest(findTestObject('Object Repository/API/setPinCode'))
def definePin_result = slurper.parseText(definePin.getResponseBodyContent())
println definePin_result
*/
//7. Sca Verify

sleep(10000)

def sca_verify = WS.sendRequest(findTestObject('Object Repository/API/7- Sca verify'))
def result5 = slurper.parseText(sca_verify.getResponseBodyContent())
verifier_id = (result5.getAt("verifierId"))
println "SCA verifier id:" + verifier_id

//12. KYC phone OTP

sleep(3000)

sleep(10000)

def KYC_PHONE_OTP = WS.sendRequest(findTestObject('Object Repository/API/12- KYC phone OTP'))
String code = KYC_PHONE_OTP.getStatusCode()
println "KYC phone code:" + code

//13. KYC phone validate

sleep(3000)

sleep(10000)

def KYC_PHONE_VALIDATE = WS.sendRequest(findTestObject('Object Repository/API/13- KYC phone validate'))
def result6 = slurper.parseText(KYC_PHONE_VALIDATE.getResponseBodyContent())
println "KYC phone validate:" + result6

//16. Set Subscription

sleep(3000)

sleep(10000)

def SET_SUBSCRIPTION = WS.sendRequest(findTestObject('Object Repository/API/16- Set Subscription'))
def result7 = slurper.parseText(SET_SUBSCRIPTION.getResponseBodyContent())
println "Subscription set:" + result7

//18. KYC Upload Identity

sleep(3000)

sleep(10000)

def KYC_UPLOAD_ID = WS.sendRequest(findTestObject('API/18- KYC step identity document passport pdf'))
def result8 = slurper.parseText(KYC_UPLOAD_ID.getResponseBodyContent())
println "KYC uploaded:" + result8

//20. KYC Civil Status

sleep(3000)

sleep(10000)

def KYC_CIVIL_STATUS = WS.sendRequest(findTestObject('Object Repository/API/20- KYC step civil status fr'))
def result9 = slurper.parseText(KYC_CIVIL_STATUS.getResponseBodyContent())
println "KYC civil status:" + result9

//22. Skip Face id
sleep(3000)
def SKIP_FACE_ID = WS.sendRequest(findTestObject('Object Repository/API/22- KYC step facematch'))
def result10 = slurper.parseText(SKIP_FACE_ID.getResponseBodyContent())

println "Face id skipped:" + result10

//24. KYC Address
sleep(3000)

sleep(10000)
println "Face id skipped:" + result10

//24. KYC Address
sleep(10000)

def KYC_ADDRESS = WS.sendRequest(findTestObject('Object Repository/API/24- KYC step address'))
def result11 = slurper.parseText(KYC_ADDRESS.getResponseBodyContent())
println "KYC address:" + result11

//26. KYC Fiscal

sleep(3000)

sleep(10000)

def KYC_FISCAL = WS.sendRequest(findTestObject('Object Repository/API/26- KYC step fiscal status'))
def result12 = slurper.parseText(KYC_FISCAL.getResponseBodyContent())
println result12


//28. KYC Sign Contract

String now = Instant.now()
println now
GlobalVariable.contractDate = now

sleep(3000)

sleep(10000)

def KYC_SIGN_CONTRACT = WS.sendRequest(findTestObject('Object Repository/API/28- KYC step contract'))
def result13 = slurper.parseText(KYC_SIGN_CONTRACT.getResponseBodyContent())
//println result13


//23. Get oTcaseReference from user

sleep(7000)

sleep(10000)

def GET_USER = WS.sendRequest(findTestObject('Object Repository/API/5- Get user info'))
def result14 = slurper.parseText(GET_USER.getResponseBodyContent())
//println result14

//oTLoc = result14.(documents)
oTLoc = result14.getAt("documents").getAt("location")
//println oTLoc

String oTLoc1 = oTLoc.toString()
int oTStartind = oTLoc1.indexOf("cases/")
int oTEndind = oTLoc1.indexOf("/files")
//println oTStartind
//println oTEndind

String OTcaseRef = oTLoc1.substring(oTStartind+6,oTEndind)
GlobalVariable.oTcaseRef = OTcaseRef
println OTcaseRef

//Get Oney Trust Token

sleep(10000)

def ONEY_TRUST_TOKEN = WS.sendRequest(findTestObject('Object Repository/API/Get OT Callback token'))
def result15 = slurper.parseText(ONEY_TRUST_TOKEN.getResponseBodyContent())
//println result15

oneyTrust_accessToken = result15.getAt("access_token")
GlobalVariable.ot_access_token = oneyTrust_accessToken
//println oneyTrust_accessToken

//Validate user in Oney Trust

sleep(10000)

def ONEY_TRUST_VALID = WS.sendRequest(findTestObject('Object Repository/API/Callback OT'))
println "Oney Trust callback Status Code:" + ONEY_TRUST_VALID.getStatusCode()

//Get Status of User
sleep(10000)
def GET_USER_STATUS_BEFORE_SCT = WS.sendRequest(findTestObject('Object Repository/API/5- Get user info'))
def userStatusResBef = slurper.parseText(GET_USER_STATUS_BEFORE_SCT.getResponseBodyContent())
userStatusResBefSCT = (userStatusResBef.getAt("profile").getAt("status")).toString()
println userStatusResBefSCT


//Simulate callback 32

sleep(5000)

def ACTION_REQUIRED_ACTIVATE = WS.sendRequest(findTestObject('Object Repository/API/32 - Callback for XPO'))
println "The status code of callback 32:" + ACTION_REQUIRED_ACTIVATE.getStatusCode()


//Get XPOLLEN access token

sleep(3000)

sleep(10000)

def XPO_ACCESS = WS.sendRequest(findTestObject('Object Repository/API/X1- SMO Get STS access token'))
def result16 = slurper.parseText(XPO_ACCESS.getResponseBodyContent())
xpo_access_token = result16.getAt("access_token")
GlobalVariable.xpo_access_token = xpo_access_token
println xpo_access_token

//Get user
sleep(10000)
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


//Get Status of User

sleep(3000)

sleep(10000)

def GET_USER_STATUS_AFTER_SCT = WS.sendRequest(findTestObject('Object Repository/API/5- Get user info'))
def userStatusResAfter = slurper.parseText(GET_USER_STATUS_AFTER_SCT.getResponseBodyContent())
userStatusResAfterSCT = (userStatusResAfter.getAt("profile").getAt("status")).toString()



//Check in DB
MongoClientURI connectionString = new MongoClientURI('mongodb://pprd-odb-cosmos-hmzsm:BtNSVU75CfG6v9dDqKaDtC6lbvHOOWbyHFYHgKOnYckJm1cdkM2QFUVs2IfTHFF0poFUe7vLGCxaZa3HzsdSmw%3D%3D@pprd-odb-cosmos-hmzsm.mongo.cosmos.azure.com:10255/admin?ssl=true&replicaSet=globaldb&readPreference=primary&maxIdleTimeMS=120000&connectTimeoutMS=10000&authSource=admin&authMechanism=SCRAM-SHA-1&3t.uriVersion=3&3t.connection.name=PREPROD&3t.databases=admin&3t.alwaysShowAuthDB=true&3t.alwaysShowDBFromUserRole=true&3t.sslTlsVersion=TLS')
MongoClient mongoClient = new MongoClient(connectionString)
println('Connect to database successfully')

MongoDatabase mongoDb = mongoClient.getDatabase('odb_account')
MongoCollection<Document> mongoUsersCollection = mongoDb.getCollection('users')
Document oneyuser = mongoUsersCollection.find(new Document('uid', GlobalVariable.UID)).first()

All_details = oneyuser.toJson()
println(All_details)
//JsonSlurper slurper = new JsonSlurper()

Map parsedJson = slurper.parseText(All_details)
String profile_status = parsedJson.user_profile.status
println(profile_status)
GlobalVariable.userprofile_status = profile_status


ActiveUser = new File(GlobalVariable.filePath)
ActiveUser.append("\n")
ActiveUser.append(Instant.now())
ActiveUser.append("\n")
ActiveUser.append("Email is" + " " + newEmail + "\n")
ActiveUser.append("Mobile Number is" + " " + frenchMob + "\n")
ActiveUser.append("First name is" + " " + Firstname + "\n")
ActiveUser.append("Last name is" + " " + Lastname + "\n")
ActiveUser.append("UID of" + " " + GlobalVariable.dynEmail + " " + "is" + " " + UID + "\n")
ActiveUser.append("Case Reference is" + " " + OTcaseRef + "\n")
ActiveUser.append("Oney Trust callback Status Code:" + ONEY_TRUST_VALID.getStatusCode() + "\n")
ActiveUser.append("User profile status before SCT IN and after OT validation:" + userStatusResBefSCT + "\n")
ActiveUser.append("User Id for SCT IN:" + xpo_user_id + "\n")
ActiveUser.append("Full name:" + xpo_display_name_trim + "\n")
ActiveUser.append("SCT IN order id:" + order_id + "\n")
ActiveUser.append("SCT IN Status Code:" + SIM_SCT_IN.getStatusCode() + "\n")
ActiveUser.append("User profile status after SCT IN:" + userStatusResAfterSCT + "\n")
ActiveUser.append("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX")
ActiveUser.append("\n")


