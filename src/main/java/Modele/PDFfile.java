package Modele;

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
import com.itextpdf.layout.properties.Property;
import com.itextpdf.layout.properties.TextAlignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PDFfile implements Fichier {
    private String file;
    private String text;

    public PDFfile(String file, String text) {
        this.file = file; //nom du fichier .pdf (à la racine du projet)
        this.text = text; //nom du fichier .txt à lire
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

        List<String> paroles = new ArrayList<>();

        //Récupérer du texte d'un fichier .txt
        try (BufferedReader in = Files.newBufferedReader(Path.of(text), StandardCharsets.UTF_8)) {
            String line;
            while ((line = in.readLine()) != null) {
                paroles.add(line);
                //System.out.println(line);
            }
        }

        //Écriture du pdf
        //Font
        PdfFont myFont = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);

        //Titre
        Paragraph titre = new Paragraph();
        titre.add(paroles.get(0));
        titre.setTextAlignment(TextAlignment.CENTER);
        titre.setFont(myFont);
        titre.setFontSize(18);
        doc.add(titre);

        //Nom du groupe
        Paragraph nomGroupe = new Paragraph();
        nomGroupe.add(paroles.get(1));
        nomGroupe.setTextAlignment(TextAlignment.CENTER);
        nomGroupe.setFont(myFont);
        nomGroupe.setProperty(Property.ITALIC_SIMULATION, true);
        nomGroupe.setFontSize(16);
        doc.add(nomGroupe);
        doc.add(new Paragraph("\n"));

        //Image du disque
        String imageFile = "src/main/java/ressources/texte/disque_we_are_the_champions.jpg";
        ImageData data = ImageDataFactory.create(imageFile);
        Image img = new Image(data);
        img.scaleToFit(200, 200);
        Paragraph image = new Paragraph();
        image.add(img);
        image.setTextAlignment(TextAlignment.CENTER);
        doc.add(image);
        doc.add(new Paragraph("\n"));

        //Lyrics
        Paragraph p2 = new Paragraph();
        for (int i = 2; i < paroles.size(); i++) {
            p2.add(paroles.get(i) + "\n");
        }
        p2.setTextAlignment(TextAlignment.CENTER);
        p2.setFont(myFont);
        p2.setFontSize(12);
        doc.add(p2);
        doc.close();
    }
}
