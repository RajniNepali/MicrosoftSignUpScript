package assignment_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class Microsoft_Common {
	
	public String main_url = "https://www.microsoft.com/en-in/";
	public String Signin_xpath = "/html/body/header/div/div/header/div/div/div[2]/div/div/div/div[1]";
	public String username_Id = "i0116";
	public String Next_Id ="idSIButton9";
	public String pwd_Id = "i0118";
	public String pwd_data = "Rn@%&2018";
	public String username_data="rajni.nepali@nitorinfotech.com";
	public String id="id";
	public String xpath="xpath";
	public String name="name";
	public String cssSelector="cssSelector";

	WebDriver driver ; 
	public void getGecko()
	{
		System.setProperty("webdriver.firefox.marionette","C:\\Users\\rajni.nepali\\Downloads\\geckodriver-v0.20\\geckodriver.exe");
		 driver = new FirefoxDriver();
	}
	public void urlAccess()
	{
		driver.get(main_url);
	}
	public void closePage()
	{
		driver.close();
	}
	
		public void InsertUsername(WebElement Username)
		{
			
			Username.sendKeys(username_data);
		}
		public void Insert_pwd(WebElement pwd)
		{
			pwd.sendKeys(pwd_data);
		}
		public void Signin_click(WebElement signin)
		{
			signin.click();
		}
		public void Nextbtn_Click(WebElement Nextbtn)
		{
			Nextbtn.click();
		}
		public WebElement identify(String Acces,String value)
	 	{
			
			String acces = Acces.toLowerCase();
			switch(acces)
			{
			case "id":
					System.out.println("For identifying an element by Id");
					return driver.findElement(By.id(value));
			case "xpath":
					System.out.println("For identifying an element by xpath");
					return driver.findElement(By.xpath(value));
			case "name":
					System.out.println("For identifying an element by name");
					return driver.findElement(By.name(value));
			case "cssSelector" :
					System.out.println("For identifying the element by css selector");
					return driver.findElement(By.cssSelector(value));
				default:
					System.out.println("Element not identified");
			}
			return null;
	 	}
		public void readExcel(String filePath,String fileName,String sheetName) throws Exception{
			File file = new File(filePath+"\\"+fileName+"\\"+sheetName);
			FileInputStream inputStream = new FileInputStream(file);
			Workbook workbook = null;
			String fileExtensionName = sheetName.substring(sheetName.indexOf("."));
			if(fileExtensionName.equals(".xlsx")){
				workbook = new XSSFWorkbook(inputStream);
			}
			else if(fileExtensionName.equals(".xls")){
				workbook = new XSSFWorkbook(inputStream);
			}
			Sheet dataSheet = workbook.getSheetAt(0);
			int rowCount = dataSheet.getLastRowNum()-dataSheet.getFirstRowNum();
			for (int i = 0; i < rowCount+1; i++) {
				Row row = dataSheet.getRow(i);
				for (int j = 0; j < row.getLastCellNum(); j++) {
					System.out.print(row.getCell(j).getStringCellValue()+"|| ");
					
				}
				System.out.println();
			}
		}
}