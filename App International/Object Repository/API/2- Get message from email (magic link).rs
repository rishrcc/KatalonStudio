<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>2- Get message from email (magic link)</name>
   <tag></tag>
   <elementGuidId>8260c67e-41f7-4d97-b3e8-e9b107b3b02c</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Mailsac-Key</name>
      <type>Main</type>
      <value>k_9doHQBNJP3FqBANTFdIUdTSdyIqCOuId9</value>
      <webElementGuid>780090b7-7338-46da-ab56-a8ada786172f</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.1.0</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>https://mailsac.com/api/addresses/${email}/messages</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>GlobalVariable.dynEmail</defaultValue>
      <description></description>
      <id>6c83fbcb-2e3f-4e83-8bf5-bc8d28dffd09</id>
      <masked>false</masked>
      <name>email</name>
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
WS.verifyElementPropertyValue(response, '[0]._id', &quot;m6zfp3nYldYUGNKyWD7d7dG3Tq-0&quot;)
WS.verifyElementPropertyValue(response, '[0].to[0].address', &quot;rg@mailsac.com&quot;)


String[] arrayResponse = [&quot;why&quot;, &quot;hello&quot;, &quot;there&quot;]
String[] arrayExpect = [&quot;there&quot;, &quot;why&quot;, &quot;hello&quot;]
assertThat(arrayResponse).containsOnly(&quot;there&quot;, &quot;hello&quot;, &quot;why&quot;)
assertThat(arrayResponse).containsOnlyElementsOf(Arrays.asList(&quot;why&quot;, &quot;there&quot;, &quot;hello&quot;))

assertThat(arrayResponse).containsExactly(&quot;why&quot;, &quot;hello&quot;, &quot;there&quot;)
assertThat(arrayResponse).containsExactlyElementsOf(Arrays.asList(&quot;why&quot;, &quot;hello&quot;, &quot;there&quot;))

assertThat(arrayResponse).containsSequence(&quot;why&quot;, &quot;hello&quot;)
assertThat(arrayResponse).containsSubsequence(&quot;why&quot;, &quot;there&quot;)
assertThat(arrayResponse).containsAnyOf(&quot;why&quot;, &quot;nothing&quot;, &quot;new&quot;)

assertThat(arrayResponse).contains(&quot;hello&quot;, atIndex(1))</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
