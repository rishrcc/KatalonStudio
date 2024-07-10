<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>32 - Callback for XPO</name>
   <tag></tag>
   <elementGuidId>331a89b6-09aa-4c30-8040-f2f40736a984</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{ \n    \&quot;eventDate\&quot;: \&quot;2022-09-02T08:48:00.5883187+00:00\&quot;, \n    \&quot;appUserId\&quot;: \&quot;${UID}\&quot;,\n    \&quot;riskLevel\&quot;: \&quot;Low\&quot;,\n    \&quot;type\&quot;: \&quot;32\&quot;\n}&quot;,
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
      <webElementGuid>11fd1ab8-234a-42ed-b53d-2eb30b2338e6</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer MTQ7NDt6dTZjWTBTTUZQ</value>
      <webElementGuid>a44df8fe-8a46-41b4-a4c1-7bb4e7ba86fc</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.4.0</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${URL}/callback/users/kyc/29rba2yq6jbh5z6gd23lic873xzab</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>GlobalVariable.UID</defaultValue>
      <description></description>
      <id>b63bc0cc-0c1f-4687-8544-bf415f8be36b</id>
      <masked>false</masked>
      <name>UID</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.urlPreprod</defaultValue>
      <description></description>
      <id>c5216b4c-7bf8-4e37-88ad-66e02ce2b40d</id>
      <masked>false</masked>
      <name>URL</name>
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
