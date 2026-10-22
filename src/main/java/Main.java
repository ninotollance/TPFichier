import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            Fichier pdf = new PDFfile("fichier.pdf");
            pdf.writeFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
