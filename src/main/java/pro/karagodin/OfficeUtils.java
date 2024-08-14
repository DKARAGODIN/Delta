package pro.karagodin;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import ru.customs.information.commercialfinancedocuments.recyclingdetails._5_23.RecyclingDetailsType;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class OfficeUtils {
	public static void createDoc(RecyclingDetailsType data) throws IOException {
		XWPFDocument document = new XWPFDocument(OfficeUtils.class.getClassLoader().getResourceAsStream("templates/request.docx"));
		IBodyElement elem = document.getBodyElements().get(6);
		XWPFParagraph doc = (XWPFParagraph) elem;
		XWPFDocument body = (XWPFDocument) doc.getBody();
		List<IBodyElement> elements = body.getBodyElements();
		XWPFParagraph paragraph = (XWPFParagraph) elements.get(6);
		XWPFRun run = paragraph.getRuns().get(1);
		run.setText("т Карагодина Д.А.", 0);
		//document.write(new FileOutputStream(new File("Hello.docx")));

		System.out.println();
	}

	public static void createCalc(RecyclingDetailsType data) throws IOException {
		Workbook workbook = new XSSFWorkbook(OfficeUtils.class.getClassLoader().getResourceAsStream("templates/calc.xlsx"));
		Sheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(4);
		row.getCell(128).setCellValue("12");

		workbook.write(new FileOutputStream(new File("Hello.xlsx")));
		System.out.println();
	}
}
