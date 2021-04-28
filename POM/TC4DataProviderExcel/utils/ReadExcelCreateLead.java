package TC4DataProviderExcel.utils;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelCreateLead {

	public static String[][] excelRead(String filename) throws IOException {
		//setup excel doc path
		XSSFWorkbook wb = new XSSFWorkbook("./Data/"+filename+".xlsx");
		//setup work sheet
		XSSFSheet sheet = wb.getSheet("Sheet1");
		//Find no of rows in a sheet
		int rowCount = sheet.getLastRowNum();
		System.out.println("rowCount is " + rowCount );
		//Get no of cells in row1
		short cellCount = sheet.getRow(0).getLastCellNum();
		System.out.println("cellCount is " + cellCount );
		//Declare 2D array
		String data[] [] = new String [rowCount] [cellCount];
		//Print all cell values from sheet
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				String text = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.print(text+" ");
				//Assign excel data to 2D array
				data[i-1][j]=text;
			}
			System.out.println();
		}
		wb.close();
		return data;
	}
}
