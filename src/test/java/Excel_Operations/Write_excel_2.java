package Excel_Operations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Write_excel_2 {
	
	public static void main(String[] args) throws Exception {
		
	
	File src=new File("Excel_Files\\Test_Data_Write.xlsx");
	FileInputStream fis=new FileInputStream(src);
	XSSFWorkbook wb=new XSSFWorkbook(fis);
	XSSFSheet sh = wb.getSheet("Test1");
	
	for(int i=0; i<3; i++){
		XSSFRow rox = sh.createRow(i);
	for(int j=0; j<5; j++){
	rox.createCell(j).setCellValue("Cell num is " + j + " row num is " + i);
	}}	
	
	
	FileOutputStream out = new FileOutputStream(new File("Excel_Files\\Test_Data_Write.xlsx")); 
			wb.write(out);
			wb.close();
			out.close();
			
	System.out.println("Test completed");
	}
}
