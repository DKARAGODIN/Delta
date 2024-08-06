package pro.karagodin;

import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.File;
import java.io.IOException;

public class OfficeUtils {
	public static void createDoc() throws IOException {
		File file = new File("C:/username/document.docx");
		XWPFDocument document = new XWPFDocument(OfficeUtils.class.getClassLoader().getResourceAsStream("templates/request.docx"));
		IBodyElement elem = document.getBodyElements().get(6);
		XWPFParagraph doc = (XWPFParagraph) elem;
		System.out.println();
	}
}
