package assignment_3;

import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ReadExcelFile {
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


	public static void main(String...strings) throws IOException{
		try {
				ReadExcelFile objExcelFile = new ReadExcelFile();
				String filePath = System.getProperty("user.dir")+"\\src\\excelExportAndFileIO";
				System.out.println(filePath);
				objExcelFile.readExcel(filePath,"ExcelDataFile","ExportExcel.xlsx");
			}catch(Exception e){	
					e.printStackTrace();
				}
	}
}


