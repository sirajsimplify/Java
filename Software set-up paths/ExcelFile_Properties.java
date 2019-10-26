package Excel_Properties_Files_Operation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFile_Properties {

	public static void main(String[] args) {
		ExcelFile_Properties h = new ExcelFile_Properties();
		int a = 7, b = 8;
		System.out.println(a & b);
		h.test(8);
		ExcelOperation();
		propertiesConfig();
	}

	public void test(int x) {
		if (x < 50 && x > 0) {
			System.out.println("Logical AND operation");
		} else {
			System.out.println("Element less than");
		}
	}

	public static void ExcelOperation() {
		try {
			File fc = new File("Excel_Files/Twit.xlsx");
			FileInputStream fis = new FileInputStream(new File("Excel_Files/Twit.xlsx"));
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh = wb.getSheet("Test1");
			String lovely = sh.getRow(1).getCell(1).getStringCellValue();
			System.out.println(lovely);
			sh.createRow(sh.getLastRowNum()).createCell(sh.getRow(0).getLastCellNum())
					.setCellValue("This is my First Class");
			FileOutputStream fos = new FileOutputStream(fc);
			wb.write(fos);
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void propertiesConfig() {
		try {
			Properties prop = new Properties();
			FileReader reader = new FileReader("Excel_Files/config.properties");
			prop.load(reader);
			String li = (String) prop.get("user");
			String lp = (String) prop.get("password");
			System.out.println(li + " == " + lp + " == " + prop);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
