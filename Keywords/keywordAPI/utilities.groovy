package keywordAPI

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import groovy.json.JsonSlurper
import com.kms.katalon.core.testobject.ResponseObject
import internal.GlobalVariable

public class utilities {

	@Keyword
	def jsonSlurper(ResponseObject responseObject) {
		JsonSlurper jsonSlurper = new JsonSlurper()
		def jsonResp = jsonSlurper.parseText(responseObject.getResponseText())
	}

	@Keyword
	def getSingleUser (ResponseObject response){
		KeywordUtil.logInfo("HEADER\n"+response.getHeaderFields()+"\n\nBODY\n"+response.getResponseBodyContent())
		JsonSlurper jsonSluper = new JsonSlurper()
		WS.verifyResponseStatusCode(response, 200)
		WS.verifyElementPropertyValue(response, 'data.email', 'janet.weaver@reqres.in')
		def jsonResp = jsonSluper.parseText(response.getResponseText())
		KeywordUtil.logInfo("id : " + jsonResp.data.id)
		KeywordUtil.logInfo("Email : " + jsonResp.data.email)
		KeywordUtil.logInfo("First Name : " + jsonResp.data.first_name)
		KeywordUtil.logInfo("Last Name : " + jsonResp.data.last_name)
		KeywordUtil.logInfo("Avatar : " + jsonResp.data.avatar)
	}

	@Keyword
	def deleteUser (ResponseObject response){
		KeywordUtil.logInfo("HEADER\n"+response.getHeaderFields()+"\n\nBODY\n"+response.getResponseBodyContent())
		WS.verifyResponseStatusCode(response, 204)
	}

	@Keyword
	def createUser (ResponseObject response){
		KeywordUtil.logInfo("HEADER\n"+response.getHeaderFields()+"\n\nBODY\n"+response.getResponseBodyContent())
		JsonSlurper jsonSluper = new JsonSlurper()
		WS.verifyResponseStatusCode(response, 201)
		WS.verifyElementPropertyValue(response, 'name', 'morpheus')
		def jsonResp = jsonSluper.parseText(response.getResponseText())
		KeywordUtil.logInfo("id : " + jsonResp.name)
		KeywordUtil.logInfo("Job : " + jsonResp.job)
		KeywordUtil.logInfo("Id : " + jsonResp.id)
		KeywordUtil.logInfo("Created At : " + jsonResp.createdAt)
	}

	@Keyword
	def updateUser (ResponseObject response){
		KeywordUtil.logInfo("HEADER\n"+response.getHeaderFields()+"\n\nBODY\n"+response.getResponseBodyContent())
		JsonSlurper jsonSluper = new JsonSlurper()
		WS.verifyResponseStatusCode(response, 200)
		WS.verifyElementPropertyValue(response, 'job', 'staff')
		def jsonResp = jsonSluper.parseText(response.getResponseText())
		KeywordUtil.logInfo("id : " + jsonResp.name)
		KeywordUtil.logInfo("job : " + jsonResp.job)
		KeywordUtil.logInfo("Created At : " + jsonResp.createdAt)
	}

	@Keyword
	def registerUser (ResponseObject response){
		KeywordUtil.logInfo("HEADER\n"+response.getHeaderFields()+"\n\nBODY\n"+response.getResponseBodyContent())
		JsonSlurper jsonSluper = new JsonSlurper()
		WS.verifyResponseStatusCode(response, 200)
		def jsonResp = jsonSluper.parseText(response.getResponseText())
		KeywordUtil.logInfo("id : " + jsonResp.id)
		KeywordUtil.logInfo("token : " + jsonResp.token)
	}

	@Keyword
	def loginUser (ResponseObject response){
		KeywordUtil.logInfo("HEADER\n"+response.getHeaderFields()+"\n\nBODY\n"+response.getResponseBodyContent())
		JsonSlurper jsonSluper = new JsonSlurper()
		WS.verifyResponseStatusCode(response, 200)
		def jsonResp = jsonSluper.parseText(response.getResponseText())
		KeywordUtil.logInfo("token : " + jsonResp.token)
	}
}
