import java.io.File;
import java.io.FileOutputStream;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {

	public static void main(String[] args) throws Exception{

		XSSFWorkbook workbook = new XSSFWorkbook(); // blank workbook
		
		// blank spreadsheet
		XSSFSheet spreadsheet = workbook.createSheet("Performance Reports Template");
		
		XSSFRow row; // row object
		int rowIndex = 0; // the current row index
		row = spreadsheet.createRow(rowIndex++); // the title row to indicate the data to be entered

		String[] columnTitles = {"Name", "EmployeeID", "Email"};
		int columnIndex = 0;
		// go through titles, write their values in consecutive cells
		for(String colTitle: columnTitles) {
			Cell cell = row.createCell(columnIndex++);
			cell.setCellValue(colTitle);
		}
		
		FileOutputStream out = new FileOutputStream(
			new File("C:/Chris/Projects/Performance-Reports-Generator/data/template.xlsx"));
		
		workbook.write(out);
		out.close();
		System.out.println("Template spreadsheet was written successfully");
	}

}