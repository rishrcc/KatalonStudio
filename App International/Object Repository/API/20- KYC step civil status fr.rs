<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>20- KYC step civil status fr</name>
   <tag></tag>
   <elementGuidId>dbd4b006-d3e0-4d4e-8258-a4777bc39656</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n    \&quot;gender\&quot; : \&quot;1\&quot;,\n    \&quot;firstName\&quot; : \&quot;${firstName}\&quot;,\n    \&quot;lastName\&quot; : \&quot;${lastName}\&quot;,\n    \&quot;birthDate\&quot; : \&quot;1990-01-01T00:00:00.000Z\&quot;,\n    \&quot;birthCity\&quot; : \&quot;Paris\&quot;,\n    \&quot;birthCountry\&quot; : \&quot;FR\&quot;,\n    \&quot;nationality\&quot; : \&quot;FR\&quot;,\n    \&quot;familyName\&quot; : \&quot;${lastName}\&quot;,\n    \&quot;birthDepartmentCode\&quot; : \&quot;75\&quot;,\n    \&quot;birthDistrictCode\&quot; : \&quot;2\&quot;\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>9babf517-55fa-4eb8-8863-d9830c688daa</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer ${user_token}</value>
      <webElementGuid>9cda5d22-eb33-4617-9f9c-cfce1df8ad1c</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.1.0</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${URL}/profile/${UID}/onboarding/step/civilstatus</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>GlobalVariable.urlPreprod</defaultValue>
      <description></description>
      <id>7713db01-af42-4cc2-8afe-4b28315293de</id>
      <masked>false</masked>
      <name>URL</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.UID</defaultValue>
      <description></description>
      <id>06d0a706-bb34-4878-a9fc-fa5e35d491c9</id>
      <masked>false</masked>
      <name>UID</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.user_token</defaultValue>
      <description></description>
      <id>884f0883-f8e2-42ec-ac24-0e7258023cb7</id>
      <masked>false</masked>
      <name>user_token</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.firstName</defaultValue>
      <description></description>
      <id>b9e6e5e7-f7c7-4abc-b105-0118c4d2c520</id>
      <masked>false</masked>
      <name>firstName</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.lastName</defaultValue>
      <description></description>
      <id>a741a112-8e2d-4d56-ac62-5607bbb19238</id>
      <masked>false</masked>
      <name>lastName</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
