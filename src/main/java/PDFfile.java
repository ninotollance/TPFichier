import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.parser.PdfTextExtractor;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;

import java.io.IOException;

public class PDFfile implements Fichier{
    private String file;

    public PDFfile(String file) {
        this.file = file; //nom du fichier .pdf (à la racine du projet)
    }

    @Override
    public void readFile() throws IOException {
        PdfReader pr = new PdfReader(file);
        PdfDocument doc = new PdfDocument(pr);
        int num = doc.getNumberOfPages();

        for (int i = 1; i <= num; i++) {
            String str = PdfTextExtractor.getTextFromPage(doc.getPage(i));
            System.out.println(str);
        }
        doc.close();
    }

    @Override
    public void writeFile() throws IOException {
        //gestionnaire de l'ecriture dans le fichier pdf
        PdfWriter writer = new PdfWriter(file);
        //creation d'un document avec plusieurs page
        PdfDocument pdfDoc = new PdfDocument(writer);
        //creation du contenu de la page du document
        Document doc = new Document(pdfDoc);

        PdfFont myFont = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);
        Paragraph p0 = new Paragraph();
        p0.add("Les paroles de la chanson\n");
        p0.setTextAlignment(TextAlignment.CENTER);
        p0.setFont(myFont);
        p0.setFontSize(12);
        doc.add(p0);

        Paragraph p1 = new Paragraph();
        p1.add("We are the champions");
        p1.setTextAlignment(TextAlignment.CENTER);
        p1.setFont(myFont);
        p1.setFontSize(18);
        doc.add(p1);
        doc.add(new Paragraph("\n"));

        String imageFile = "src/main/ressources/disque_we_are_the_champions.jpg";
        ImageData data = ImageDataFactory.create(imageFile);
        Image img = new Image(data);
        img.scaleToFit(200, 200);
        Paragraph image = new Paragraph();
        image.add(img);
        image.setTextAlignment(TextAlignment.CENTER);
        doc.add(image);
        doc.add(new Paragraph("\n"));

        Paragraph p2 = new Paragraph();
        p2.add("I’ve paid my dues\n");
        p2.add("Time after time\n");
        p2.add("I’ve done my sentence\n");
        p2.add("But committed no crime\n");
        p2.add("And bad mistakes\n");
        p2.add("I’ve made a few\n");
        p2.add("I’ve had my share of sand kicked in my face\n");
        p2.add("But I’ve come through");
        p2.setTextAlignment(TextAlignment.CENTER);
        p2.setFont(myFont);
        p2.setFontSize(12);
        doc.add(p2);
        doc.add(new Paragraph("\n"));

        Paragraph p3 = new Paragraph();
        p3.add("We are the champions - my friends\n");
        p3.add("And we’ll keep on fighting - till the end\n");
        p3.add("We are the champions\n");
        p3.add("We are the champions\n");
        p3.add("No time for losers\n");
        p3.add("Cause we are the champions - of the world");
        p3.setTextAlignment(TextAlignment.CENTER);
        p3.setFont(myFont);
        p3.setFontSize(12);
        doc.add(p3);
        doc.add(new Paragraph("\n"));

        Paragraph p4 = new Paragraph();
        p4.add("I’ve taken my bows\n");
        p4.add("And my curtain calls\n");
        p4.add("You brought me fame and fortuen and everything that goes with it\n");
        p4.add("I thank you all");
        p4.setTextAlignment(TextAlignment.CENTER);
        p4.setFont(myFont);
        p4.setFontSize(12);
        doc.add(p4);
        doc.add(new Paragraph("\n"));

        Paragraph p5 = new Paragraph();
        p5.add("But it’s been no bed of roses\n");
        p5.add("No pleasure cruise\n");
        p5.add("I consider it a challenge before the whole human race\n");
        p5.add("And I ain’t gonna lose");
        p5.setTextAlignment(TextAlignment.CENTER);
        p5.setFont(myFont);
        p5.setFontSize(12);
        doc.add(p5);
        doc.add(new Paragraph("\n"));

        Paragraph p6 = new Paragraph();
        p6.add("We are the champions - my friends\n");
        p6.add("And we’ll keep on fighting - till the end\n");
        p6.add("We are the champions\n");
        p6.add("We are the champions\n");
        p6.add("No time for losers\n");
        p6.add("Cause we are the champions - of the world");
        p6.setTextAlignment(TextAlignment.CENTER);
        p6.setFont(myFont);
        p6.setFontSize(12);
        doc.add(p6);
        doc.add(new Paragraph("\n"));


        doc.close();
    }
}
