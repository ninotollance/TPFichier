import Modele.Fichier;
import Modele.PDFfile;
import Modele.WordFile;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choix ;

        do {
            System.out.println("\n Choisir un fichier ");
            System.out.println("1. Word");
            System.out.println("2. Pdf");
            System.out.println("3. Excel");
            System.out.println("4. Quitter");
            choix = sc.nextInt();

            Fichier f = null;
            switch (choix) {
                case 1 -> f = new WordFile("fichier.docx");
                case 2 -> f = new PDFfile("fichier.pdf", "src/main/java/ressources/texte/paroles.txt");
                //case 3 -> f = new ExcelFile("statsF1.xlsx");
                case 0 -> System.out.println("Au revoir ! ");
                default -> System.out.println("Choix invalide !");
            }

            if (f != null) {
                System.out.println("1. Ecrire");
                System.out.println("2. Lire");
                int numero = sc.nextInt();


                try {
                    switch (numero) {
                        case 1 -> f.writeFile();
                        case 2 -> f.readFile();
                        default -> System.out.println("Action invalide");

                    }
                } catch (IOException e) {
                    System.out.println("Erreur : " + e.getMessage());
                }
            }
        } while (choix != 0);
            sc.close();

    }
}
