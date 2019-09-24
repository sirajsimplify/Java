package Excel_Operations;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Write_Excel_1 {
	
	// Write into excel by keeping everything in the buffer memory
	public static void main(String[] args) throws Exception {
		
		XSSFWorkbook workbook = new XSSFWorkbook();
	    
	    //Create a blank sheet
	    XSSFSheet spreadsheet = workbook.createSheet("Test");
	    
	    XSSFRow row;
	    for (int i=0; i<4 ; i++){
	    	row = spreadsheet.createRow(i);
	    	
	    	for(int j=0;j<5;j++){
	    		Cell cel = row.createCell(j);
	    		cel.setCellValue("Cell num is " + j + " row num is " + i);;
	    	}
	    }
	    
	    FileOutputStream out = new FileOutputStream(
	    	       new File("Excel_Files\\Test_Data_Write.xlsx"));
	    
	    workbook.write(out);
	    workbook.close();
	    out.close();
	    System.out.println("Writesheet.xlsx written successfully");
	}

}
