import Modele.Fichier;
import Modele.PDFfile;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            //Instanciation d'un fichier PDFfile
            Fichier pdf = new PDFfile("fichier.pdf", "paroles.txt");
            //Création du fichier pdf
            pdf.writeFile();
            //Lecture d'un fichier pdf
            //pdf.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
