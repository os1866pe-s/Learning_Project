package Test;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class PDFTest {

	public static void main(String[] args) {

		Document doc = new Document(PageSize.A4, 50, 50, 50, 50);

		{
			try {

				PdfWriter.getInstance(doc, new FileOutputStream("src/Test/FirstPDF.xml"));

				doc.open();

				Anchor anchor = new Anchor("First page of the document.");
				anchor.setName("BackToTop");
				Paragraph paragraph1 = new Paragraph();

				paragraph1.setSpacingBefore(50);
				paragraph1.add(anchor);
				doc.add(paragraph1);

				doc.newPage();
				doc.add(new Paragraph("Some more text on the second page with different color and font type.",
						FontFactory.getFont(
								FontFactory.HELVETICA_BOLD,
								14,
								Font.BOLD,
								new CMYKColor(0, 255, 0, 0))));
				doc.close();

			} catch (DocumentException | FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}




}
