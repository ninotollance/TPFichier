import Modele.Fichier;
import Modele.WordFile;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try {
            Fichier tab[]= new Fichier[2];
            Fichier f3 = new WordFile("fichier.docx");
            Fichier f4 = new WordFile("fichier.docx");
            tab[0]=f3;




            for(Fichier f : tab) {
                f.writeFile();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
