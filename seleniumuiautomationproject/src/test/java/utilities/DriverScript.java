package utilities;

import java.io.File;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DriverScript {
	
	KeywordActions keywordActions;
	
	public DriverScript() {
		keywordActions=new KeywordActions();
	}
	
	/**
	 * What this method is all about
	 * @param excelFilePath - This is a test data file
	 * @param sheetName - Specify sheet name
	 * @param testCaseId
	 * @throws Exception
	 */
	public void runScript(String excelFilePath,String sheetName,String testCaseId) throws Exception {
		
		try {
			File excelFile=new File(excelFilePath);

			XSSFWorkbook workBook=new XSSFWorkbook(excelFile);
			XSSFSheet sheet=workBook.getSheet(sheetName);

			int rowCount=sheet.getLastRowNum();
			System.out.println("No.of rows in excel sheet are:="+rowCount);


			for (int i=0; i<=sheet.getLastRowNum(); i++) {
				Row row=sheet.getRow(i);
				if(row==null) {
					System.out.println("Skipping row reading as it is null");
					continue;
				}
				String testId=getCellValue(row, 0);
				//Check if testId is matching with the given testCaseId, if not skip that step
				if(!testId.equalsIgnoreCase(testCaseId)) {
					continue;
				}

				String stepName=getCellValue(row, 1);
				String locatorType=getCellValue(row, 2);
				String locatorValue=getCellValue(row, 3);
				String testData=getCellValue(row, 4);
				String action=getCellValue(row, 5);
				keywordActions.performAction(action, locatorType, locatorValue, testData);
			}
			workBook.close();
		}
		catch(Exception e) {
			throw e;
		}
		
	}
	
	private String getCellValue(Row row,int colIndex) {
		Cell cell = row.getCell(colIndex);
		if (cell == null) {
			return "";
		} 
		else if(cell.getCellType()==CellType.STRING) {
			return cell.getStringCellValue();
		}
		else {
			System.out.println("*************Invalid Cell Type****************");
		}

		return "";
	}

}
