package jsample.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

	public void readExcelFile(String excelFilePath)
			throws FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException {
		/**
		 * When opening a workbook, either a .xls HSSFWorkbook, or a .xlsx XSSFWorkbook,
		 * the Workbook can be loaded from either a File or an InputStream. Using a File
		 * object allows for lower memory consumption, while an InputStream requires
		 * more memory as it has to buffer the whole file.
		 */
		try (Workbook workbook = WorkbookFactory.create(new File(excelFilePath))) {
			for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
				Sheet sheet = workbook.getSheetAt(sheetNum);
				System.out.println("-----------Sheet " + sheet.getSheetName() + " Data-----------");
				readSheet(sheet);
			}
		}
	}

	private void readSheet(Sheet sheet) {
		/**
		 * Note that sheet.getLastRowNum() return last row no (last row index) of the
		 * sheet (0-based)
		 */
		for (int rowNum = 0; rowNum <= sheet.getLastRowNum(); rowNum++) {
			Row row = sheet.getRow(rowNum);
			/**
			 * row can be null if it does not exist physically.
			 * 
			 * Here, physically exist row means row which contains at least one physically
			 * exist cell.
			 */
			if (row != null) {
				readRow(row);
			}
			System.out.println();
		}
	}

	private void readRow(Row row) {
		for (int colNum = 0; colNum < row.getLastCellNum(); colNum++) {
			/**
			 * Cell can be null if it does not exist physically.
			 * 
			 * Physically exist cell means cell which contains data or excel formatting like
			 * color, border etc.
			 * 
			 * If cell contains some text, it is said that cell exist logically and
			 * physically both. However, if cell contains formatting only, it is said that
			 * cell exist physically but not logically.
			 * 
			 * Use Row.MissingCellPolicy in row.getCell() method for handling null and blank
			 * cells.
			 */
			Cell cell = row.getCell(colNum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			String cellValue = null;
			/**
			 * Use formatCellValue() method of DataFormatter class to get the text that
			 * appears in the cell. With this method, there is no need to know the type of
			 * data a cell contains.
			 * 
			 * However, it will give values which are displayed in the excel after
			 * formatting.
			 * 
			 * Suppose, a cell contains time 09:20:10. But use format h:mm for displaying.
			 * In this case, this method will also return 9:20 as value, skipping seconds
			 * information.
			 */
			// System.out.print(new DataFormatter().formatCellValue(cell));
			/**
			 * Alternatively, get the value based on the type of data a cell contains and
			 * format it as per the need.
			 */
			switch (cell.getCellTypeEnum()) {

			case BLANK:
				cellValue = "";
				break;
			case BOOLEAN:
				cellValue = Boolean.toString(cell.getBooleanCellValue());
				break;
			case ERROR:
				cellValue = Byte.toString(cell.getErrorCellValue());
				break;
			case FORMULA:
				cellValue = cell.getCellFormula();
				break;
			case NUMERIC:
				/**
				 * Date or time cell are also return as numeric type.
				 * 
				 * Use DateUtil.isCellDateFormatted() method to check whether cell contains date
				 * or time.
				 */
				if (DateUtil.isCellDateFormatted(cell)) {
					/**
					 * For Date fields, getDateCellValue() will return Date class objects after
					 * setting time (hour, minutes and seconds) information to zero.
					 * 
					 * For time fields, getDateCellValue() will return Date class objects after
					 * setting date information to 31-Dec-1899
					 * 
					 * For date time fields, it will return Date class objects with complete cell
					 * information.
					 */
					cellValue = cell.getDateCellValue().toString();
				} else {
					cellValue = Double.toString(cell.getNumericCellValue());
				}
				break;
			case STRING:
				cellValue = cell.getStringCellValue();
				break;
			default:
				cellValue = "";
			}
			System.out.print(cellValue + "\t");
		}
	}
}