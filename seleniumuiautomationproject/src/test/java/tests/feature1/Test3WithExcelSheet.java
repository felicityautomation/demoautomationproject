package tests.feature1;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test3WithExcelSheet {

	@Test
	public void loginMultipleTest() throws IOException {

		XSSFWorkbook workBook=new XSSFWorkbook("testdata/testdata.xlsx");
		XSSFSheet sheet=workBook.getSheet("Login");
		int rowCount=sheet.getLastRowNum();
		System.out.println("Total number of rows prsent in 'Login' sheet:="+rowCount);

//		for(int i=1;i<=sheet.getLastRowNum();i++) {
//
//			//Get the row
//			XSSFRow row=sheet.getRow(i);
//			int lastCellIndex=row.getLastCellNum();
//			for(int j=0;j<lastCellIndex;j++) {
//				System.out.println(row.getCell(j).getStringCellValue());
//			}
//		}
//		System.out.println("_________________________________");
		for(int i=1;i<=sheet.getLastRowNum();i++) {

			//Get the row
			XSSFRow row=sheet.getRow(i);
			String userName=null,password=null;
			
			
			//Reading user name value from the first column
			XSSFCell  userNameCell=row.getCell(0);
			userName=userNameCell.getStringCellValue();
			XSSFCell  passwordCell=row.getCell(1);
			if(passwordCell==null) {
				password="";
			}else if(passwordCell.getCellType()==CellType.NUMERIC) {
				System.out.println(passwordCell.getCellType());
				password=Double.toString(passwordCell.getNumericCellValue());
			}
			else if(passwordCell.getCellType()==CellType.STRING) {
				System.out.println(passwordCell.getCellType());
				password=passwordCell.getStringCellValue();
			}
			
			System.out.println("Testing with User name:= "+userName+" and Password:= "+password);
			WebDriver driver=new ChromeDriver();
			driver.get("https://www.facebook.com");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			driver.findElement(By.id("email")).sendKeys(userName);
			driver.findElement(By.id("pass")).sendKeys(password);
			driver.findElement(By.name("login")).click();
			boolean flag=driver.findElement(By.linkText("Find your account and log in.")).isDisplayed();
			Assert.assertEquals(flag, true,"Verify error message");
			driver.quit();
		}

		workBook.close();

	}

}
