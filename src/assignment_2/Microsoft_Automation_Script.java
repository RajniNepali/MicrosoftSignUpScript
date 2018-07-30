package assignment_2;
import org.openqa.selenium.WebElement;

import assignment_3.ReadExcelFile;


public class Microsoft_Automation_Script extends Microsoft_Common {

	public static void main(String[] args)throws Exception {
		try {String filePath = "C:\\Users\\rajni.nepali\\Aumatomation_Assignment_Rajni_Nepali\\src";
		//Call to closePage() method to close the current page
		
		ReadExcelFile objExcelFile = new ReadExcelFile();
		String file_Path = System.getProperty("user.dir")+"\\src\\excelExportAndFileIO";
		System.out.println(filePath);
		objExcelFile.readExcel(file_Path,"ExcelDataFile","ExportExcel.xlsx");


			Microsoft_Common mc = new Microsoft_Common();
			mc.getGecko();
			//To open the webpage
			mc.urlAccess();
			//To return the webElement instance for signin
			WebElement Signin= mc.identify(mc.xpath, mc.Signin_xpath);
			//Call to Sign_click() method with webElement instance as parameter to perform click operation
			mc.Signin_click(Signin);
			////To return the webElement instance for username field
			WebElement username = mc.identify(mc.id, mc.username_Id);
			//Call to InsertUsername() method with webElement instance as parameter to populate the username field
			mc.InsertUsername(username);
			//To return the webElement instance for Next button
			WebElement Nextbtn = mc.identify(mc.id, mc.Next_Id);
			//Call to Nextbtn_Click() method with webElement instance as parameter to perform click operation
			mc.Nextbtn_Click(Nextbtn);
			//To return the webElement instance for password 
			WebElement pwd = mc.identify(mc.id, mc.pwd_Id);
			//Call to Insert_pwd() method with webElement instance as parameter to populate the password field
			mc.Insert_pwd(pwd);
			
				mc.closePage();
			}catch(Exception e) {
				e.getStackTrace();
				System.out.println("Exception occured "+e.getMessage());
			}

		}	
	}
