import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.poi.xssf.usermodel.*

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable


public class updateXray {

	@Keyword
	public static getSubfolderCucumberReport(int index) {

		// Open the Excel file
		def excelFilePath = RunConfiguration.getProjectDir() + GlobalVariable.Xray_Excel
		def excelFile = new File(excelFilePath)
		def excelStream = new FileInputStream(excelFile)
		def workbook = new XSSFWorkbook(excelStream)
		def worksheet = workbook.getSheet('XRAY_INTEGRATION')

		//Get Sub folder
		def reportPath = RunConfiguration.getReportFolder()
		def absolute_path = new File(reportPath)

		//def absolute_path = new File("C:\\Users\\RishabhGungah\\OneDrive - Gamma Civic Ltd\\Desktop-2022\\SwitchTestKatalon\\Workspace_OneyPlus\\odb_qa\\qa_auto\\OneyPlus\\OneyPlus\\Reports\\20230130_185037\\Auto balance\\20230130_185037")

		String report_path = absolute_path.getAbsolutePath() + "\\cucumber_report"
		Mobile.comment("Absolute path: " + report_path)

		def folder = new File(report_path)
		def subfolders = []

		folder.listFiles().each { file ->
			if (file.isDirectory())
			{
				subfolders.add(file)
			}
		}
		println(subfolders)

		//Assign sub folder to Global Variable
		String full_cucumber_json_path = subfolders[index].toString() + '\\cucumber.json'
		println full_cucumber_json_path
		GlobalVariable.cucumber_json = full_cucumber_json_path

		File file = new File(RunConfiguration.getProjectDir() + GlobalVariable.ReportPathTemp)
		file.append(full_cucumber_json_path + "\n")

		// Find the last row in the Excel file
		def lastRowIndex = worksheet.getLastRowNum()

		// Create a new row and write the data to it
		def newRow = worksheet.createRow(lastRowIndex + 1)
		newRow.createCell(0).setCellValue(full_cucumber_json_path)

		// Save the changes to the Excel file
		excelStream.close()
		def outputStream = new FileOutputStream(excelFile)
		workbook.write(outputStream)
		outputStream.close()
	}

	@Keyword
	public static createTestExecution()
	{

		//Read text file
		File file = new File(GlobalVariable.ReportPathTemp)
		def content = file.getText('UTF-8')
		println(content)


		file.eachLine{ line ->

			println line
			//Assign cucumber_json to content
			GlobalVariable.cucumber_json =line


			def slurper= new groovy.json.JsonSlurper()

			//Get Json Data
			def jsonFile = new File(GlobalVariable.cucumber_json)
			def jsonData = jsonFile.getText('UTF-8')

			Mobile.comment("Path: " + GlobalVariable.cucumber_json)

			String jsonDataToString = jsonData.toString()
			GlobalVariable.reportJson = jsonDataToString
			Mobile.comment("Json content: " + GlobalVariable.reportJson)

			//Get xray token
			def getXrayToken = WS.sendRequest(findTestObject('Object Repository/API/getXrayToken'))
			def xraytoken = slurper.parseText(getXrayToken.getResponseBodyContent())
			GlobalVariable.XrayToken =  xraytoken
			println GlobalVariable.XrayToken

			//Post Cucumber.json report to Xray
			def postCucumberResult = WS.sendRequest(findTestObject('Object Repository/API/postCucumberReportToXray'))
			def postCucumberResult_jsonData = slurper.parseText(postCucumberResult.getResponseBodyContent())
			String test_execution_key =  postCucumberResult_jsonData.(key)
			Mobile.comment(test_execution_key)

		}
	}

	@Keyword
	public static createTestExecutionXSSF()
	{
		// Load the Excel file
		def file = new File(RunConfiguration.getProjectDir() + GlobalVariable.Xray_Excel)
		def workbook = new XSSFWorkbook(file)

		// Get the first sheet in the workbook
		def sheet = workbook.getSheetAt(0)

		// Get the column index for the "REPORT_PATH" header
		def pathIndex = sheet.getRow(0).cellIterator().findIndexOf { it.stringCellValue == "REPORT_PATH" }

		// Loop through the rows in the column
		for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++)
		{
			def row = sheet.getRow(rowIndex)
			def pathCell = row.getCell(pathIndex)
			def path = pathCell?.stringCellValue
			Mobile.comment(path)

			//Assign cucumber_json to content
			GlobalVariable.cucumber_json =path


			def slurper= new groovy.json.JsonSlurper()

			//Get Json Data
			def jsonFile = new File(GlobalVariable.cucumber_json)
			def jsonData = jsonFile.getText('UTF-8')

			Mobile.comment("Path: " + GlobalVariable.cucumber_json)

			String jsonDataToString = jsonData.toString()
			GlobalVariable.reportJson = jsonDataToString
			Mobile.comment("Json content: " + GlobalVariable.reportJson)

			//Get xray token
			def getXrayToken = WS.sendRequest(findTestObject('Object Repository/API/getXrayToken'))
			def xraytoken = slurper.parseText(getXrayToken.getResponseBodyContent())
			GlobalVariable.XrayToken =  xraytoken
			println GlobalVariable.XrayToken

			//Post Cucumber.json report to Xray
			def postCucumberResult = WS.sendRequest(findTestObject('Object Repository/API/postCucumberReportToXray'))
			def postCucumberResult_jsonData = slurper.parseText(postCucumberResult.getResponseBodyContent())
			String test_execution_key =  postCucumberResult_jsonData.(key)
			Mobile.comment(test_execution_key)

			workbook.close()
		}
	}
}