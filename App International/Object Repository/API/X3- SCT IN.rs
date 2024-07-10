<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>X3- SCT IN</name>
   <tag></tag>
   <elementGuidId>1cafd4a7-fb8a-4597-bf47-6802b86611e2</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;Amount\&quot;: 100,\n  \&quot;ExecutionDate\&quot;: \&quot;${onboarding_date}\&quot;,\n  \&quot;UserId\&quot;: ${user_id},\n  \&quot;ThirdPartyBIC\&quot;: \&quot;SMOEFRP1\&quot;,\n  \&quot;ThirdPartyIban\&quot;: \&quot;FR5212869000020PC000001PR62\&quot;,\n  \&quot;ThirdPartyFullName\&quot;: \&quot;${Fullname}\&quot;,\n  \&quot;Type\&quot;: 506,\n  \&quot;OrderId\&quot;: \&quot;${order_id}\&quot;,\n  \&quot;Message\&quot;: \&quot;transfer S-money\&quot;,\n  \&quot;Reference\&quot;: \&quot;ref04511\&quot;,\n  \&quot;UniqueIdentification\&quot;: \&quot;Identif SCT_IN_1216\&quot;,\n  \&quot;Motif\&quot;: \&quot;Virement entrant pour cet utilisateur\&quot;,\n  \&quot;FeeAmountTTC\&quot;: 0,\n  \&quot;FeeVAT\&quot;: 0,\n  \&quot;FeeRecipientId\&quot;: 0\n}&quot;,
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
      <webElementGuid>04899501-bdc0-4c60-8dc6-aeaa151462c4</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer ${xpo_acess_token}</value>
      <webElementGuid>e51740be-8862-4a40-8a53-1334f67e56cc</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.1.0</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://sb-api.xpollens.com/api/V1.1/api/sct/in/registration</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>GlobalVariable.xpo_access_token</defaultValue>
      <description></description>
      <id>26c9dce8-ef36-45a7-a0ca-6ccece0b2b1b</id>
      <masked>false</masked>
      <name>xpo_acess_token</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.xpo_onboarding_date</defaultValue>
      <description></description>
      <id>6faeaabf-3bad-4e97-88e5-e3b3bac45a88</id>
      <masked>false</masked>
      <name>onboarding_date</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.xpo_user_id</defaultValue>
      <description></description>
      <id>3f7e73ce-7c57-44d2-ba87-87e82d3debfc</id>
      <masked>false</masked>
      <name>user_id</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.xpo_display_name_trim</defaultValue>
      <description></description>
      <id>df5b7c22-ffef-4329-a573-64d9f74c824d</id>
      <masked>false</masked>
      <name>Fullname</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.order_id</defaultValue>
      <description></description>
      <id>275cd316-9483-48e3-99d2-83d2dd83eb7b</id>
      <masked>false</masked>
      <name>order_id</name>
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
