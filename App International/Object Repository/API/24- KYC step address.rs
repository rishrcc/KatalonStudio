<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>24- KYC step address</name>
   <tag></tag>
   <elementGuidId>1ff01f15-6097-4e8f-9eb4-eac2ba16274b</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;street\&quot;: \&quot;2 Rue Gaston Rebuffat\&quot;,\n  \&quot;postalCode\&quot;: \&quot;75019\&quot;,\n  \&quot;city\&quot;: \&quot;Paris\&quot;,\n  \&quot;country\&quot;: \&quot;FR\&quot;\n}&quot;,
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
      <webElementGuid>e9c29f2f-1bcf-463a-a8b9-37eb1c673e18</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer ${user_token}</value>
      <webElementGuid>897241fc-8d7a-4765-a0d6-8d851b17dfa3</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.1.0</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${URL}/profile/${UID}/onboarding/step/address</restUrl>
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
      <id>71c17ad3-b5a9-468b-8751-23af6412b698</id>
      <masked>false</masked>
      <name>URL</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.UID</defaultValue>
      <description></description>
      <id>f16e66f3-8258-42a8-83f8-b99a2f5ec77f</id>
      <masked>false</masked>
      <name>UID</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.user_token</defaultValue>
      <description></description>
      <id>47482cb4-440c-4afb-9560-b7fe9fc53201</id>
      <masked>false</masked>
      <name>user_token</name>
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
