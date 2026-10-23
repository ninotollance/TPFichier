import Modele.Fichier;
import Modele.WordFile;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try {
            Fichier tab[]= new Fichier[2];
            Fichier f1 = new WordFile("fichier.docx");
            Fichier f2 = new PDFFile("fichier.pdf");
            tab[0]=f1;
            tab[1]=f2;


            for(Fichier f : tab) {
                f.writeFile();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
