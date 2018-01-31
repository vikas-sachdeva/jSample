package jsample;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import jsample.excel.ExcelReader;

public class App 
{
	private static final String EXCEL_FILE_PATH = "./input/currencyCodes.xlsx";

	public static void main(String[] args)
			throws FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException {
		new ExcelReader().readExcelFile(EXCEL_FILE_PATH);
	}
}
