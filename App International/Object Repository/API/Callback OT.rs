<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Callback OT</name>
   <tag></tag>
   <elementGuidId>e31b3205-9bad-49c6-8b55-86fe75920c53</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{ \n    \&quot;caseId\&quot;: 116175, \n    \&quot;caseReference\&quot;: \&quot;${oTcaseRef}\&quot;, \n    \&quot;caseScore\&quot;: \&quot;0\&quot;, \n    \&quot;caseStateId\&quot;: 4100, \n    \&quot;caseState\&quot;: \&quot;TREATED_VALIDATED\&quot;, \n    \&quot;decision\&quot;: \&quot;OK_MANUAL\&quot;, \n    \&quot;docResult\&quot;: \n  {\n        \&quot;IDENTITY\&quot;: \&quot;OK\&quot;\n    },\n    \&quot;subResult_fraud\&quot;: \&quot;RISK_LOW\&quot;, \n    \&quot;subResult_aml_pep\&quot;: \&quot;OK\&quot;,\n    \&quot;flag_existingAddress\&quot;: \&quot;FALSE\&quot;,\n    \&quot;subResult_compliance\&quot;: \&quot;OK\&quot;,\n    \&quot;flag_existingIdentity\&quot;: \&quot;FALSE\&quot;,\n    \&quot;subResult_aml_sanctions\&quot;: \&quot;OK\&quot;, \n    \&quot;caseType\&quot;: 60,\n    \&quot;subResult_bdf\&quot;: \&quot;\&quot;,\n    \&quot;lastUpdate\&quot;: \&quot;\&quot;,\n    \&quot;analysisId\&quot;: \&quot;\&quot;\n}&quot;,
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
      <webElementGuid>dae8cd92-7d31-4d2a-938e-2ceaa8cb95a2</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer ${ot_access_token}</value>
      <webElementGuid>238d7ec2-ccf5-4c04-81db-081e41a1b96f</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.1.0</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${URL}/callbacks/profile/ot/8Z6L7eab42C5vFRn7XTEYDaws2QTzB</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>GlobalVariable.ot_access_token</defaultValue>
      <description></description>
      <id>841acc59-6e08-4999-a25b-606219780e0b</id>
      <masked>false</masked>
      <name>ot_access_token</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.urlPreprod</defaultValue>
      <description></description>
      <id>bc8f861c-db65-4d73-9537-b560fd489546</id>
      <masked>false</masked>
      <name>URL</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.oTcaseRef</defaultValue>
      <description></description>
      <id>b0c9329e-aa7e-4255-87a5-e141f6c7b47a</id>
      <masked>false</masked>
      <name>oTcaseRef</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()


WS.verifyResponseStatusCode(response, 200)

assertThat(response.getStatusCode()).isEqualTo(200)</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
