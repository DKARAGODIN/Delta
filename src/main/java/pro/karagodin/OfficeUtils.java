package pro.karagodin;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.customs.information.commercialfinancedocuments.recyclingdetails._5_23.RecyclingDetailsType;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class OfficeUtils {

	public static void createCalc(RecyclingDetailsType data) throws IOException {
		Workbook workbook = new XSSFWorkbook(OfficeUtils.class.getClassLoader().getResourceAsStream("templates/calc.xlsx"));
		Sheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(4);
		row.getCell(128).setCellValue("12");

		workbook.write(new FileOutputStream(new File("Hello.xlsx")));
		System.out.println();
	}
}
