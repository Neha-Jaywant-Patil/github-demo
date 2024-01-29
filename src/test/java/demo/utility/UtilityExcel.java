package demo.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UtilityExcel {


	public static ArrayList<Object> readExcel(int rowNumber) throws IOException {

		ArrayList<Object> data = new ArrayList<Object>();
		File file = new File("src/test/resources/testdata/excel test data.xlsx");
		FileInputStream fis = new FileInputStream(file);

		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = xssfWorkbook.getSheet("Sheet1");

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

		

	}
		return data;
}
}