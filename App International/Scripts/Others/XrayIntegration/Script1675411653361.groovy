import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.poi.xssf.usermodel.XSSFWorkbook

import com.kms.katalon.core.configuration.RunConfiguration

/*
def slurper= new groovy.json.JsonSlurper()

def jsonFile = new File("C:\\Users\\RishabhGungah\\OneDrive - Gamma Civic Ltd\\Desktop-2022\\SwitchTestKatalon\\Workspace_OneyPlus\\odb_qa\\qa_auto\\OneyPlus\\OneyPlus\\Reports\\20230208_193851\\Auto balance\\20230208_193851\\cucumber_report\\1675870745376\\cucumber.json")
def jsonData = jsonFile.getText('UTF-8')
println "Not in global: " + jsonData

String jsonDataToString = jsonData.toString()
println jsonDataToString
GlobalVariable.reportJson = jsonDataToString
println GlobalVariable.reportJson

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
*/
/*
// Open the Excel file
def excelFilePath = RunConfiguration.getProjectDir() + "\\Data Files\\Xray.xlsx"
def excelFile = new File(excelFilePath)
def excelStream = new FileInputStream(excelFile)
def workbook = new XSSFWorkbook(excelStream)
def worksheet = workbook.getSheet('XRAY_INTEGRATION')

// Find the column index of the dynamic column
def dynamicColumnName = 'STATUS'
def headerRow = worksheet.getRow(0)
def columnIndex = -1
for (int i = 0; i <= headerRow.getLastCellNum(); i++) {
	def cell = headerRow.getCell(i)
	if (cell && cell.getStringCellValue() == dynamicColumnName) {
		columnIndex = i
		break
	}
}

// Write a value to the next column if the dynamic column value is "PASSED"
def lastRowIndex = worksheet.getLastRowNum()
for (int i = 1; i <= lastRowIndex; i++) {
	def row = worksheet.getRow(i)
	def cell = row.getCell(columnIndex)
	
	
	//cell && cell.getStringCellValue() == "NOT_IMPORTED"
	if (cell == null) {
		def nextCell = row.createCell(columnIndex + 1)
		def previousCell = row.createCell(columnIndex)
		
		nextCell.setCellValue('XRAY_KEY')
		previousCell.setCellValue("IMPORTED")
		
	}
}

// Save the changes to the Excel file
excelStream.close()
def outputStream = new FileOutputStream(excelFile)
workbook.write(outputStream)
outputStream.close()
*/

CustomKeywords.'updateXray.createTestExecutionXSSF'()
