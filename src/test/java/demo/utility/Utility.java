package demo.utility;
import org.apache.poi.ss.usermodel.Cell;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Utility {

	public static String readProperty(String key) {

		File file = new File("src/test/resources/properties/testdata.properties");
		String value = null;
		try {
			FileInputStream fi = new FileInputStream(file);
			Properties prop = new Properties();
			prop.load(fi);
			value = prop.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
		
		}
	public static ArrayList<Object> readExcel(int rowNumber) throws IOException {
		ArrayList<Object> data = new ArrayList<Object>();
		File file = new File("src/test/resources/properties/Details of Doctors of Pune HQ.xlsx");
		FileInputStream fi = new FileInputStream(file);
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fi);
		XSSFSheet sheet = xssfWorkbook.getSheet("data");
		int lastrow = sheet.getLastRowNum();
		for (int i = 1; i <= lastrow; i++) {

			XSSFRow row = sheet.getRow(rowNumber);

			int lastcellnum = row.getLastCellNum();

			for (int j = 0; j < lastcellnum; j++) {

				if (row.getCell(j) == null) {
					continue;
				}

				if (row.getCell(j).getCellType() == Cell.CELL_TYPE_STRING) {
					data.add(row.getCell(j).getStringCellValue());
				}

				if (row.getCell(j).getCellType() == Cell.CELL_TYPE_NUMERIC) {
					data.add(row.getCell(j).getNumericCellValue());
				}
				
			}

			xssfWorkbook.close();

			return data;

		}
	}
}

