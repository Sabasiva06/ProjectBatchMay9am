package org.sample;

import org.openqa.selenium.By;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\MavenSampleProgramm\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		WebElement txtUserName = driver.findElement(By.id("email"));
		txtUserName.sendKeys("welcomejavaa");
		WebElement txtPassword = driver.findElement(By.id("pass"));
		txtPassword.sendKeys("javawelocmesyoy");
		WebElement btnLogin = driver.findElement(By.name("login"));
		btnLogin.click();
		File file = new File("D:\\3PmFrameWorkBatch\\ExcelData\\Book1.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet("Sheet1");
		// getPhysicalNumberOfRows()
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				int cellType = cell.getCellType();
				if (cellType == 1) {
					String stringCellValue = cell.getStringCellValue();
					System.out.println(stringCellValue);
				} else if (DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat datee = new SimpleDateFormat("dd-MMM-yyyy");
					String format = datee.format(dateCellValue);
					System.out.println(format);
				}

				else {
					double numericCellValue = cell.getNumericCellValue();
					long l = (long) numericCellValue;
					System.out.println(l);
				}
			}

		}
		driver.findElement(By.id("username")).sendKeys("karthi007");
		driver.findElement(By.id("password")).sendKeys("Karthi@1898");
		driver.findElement(By.tagName("tr")).click();

	}
}
