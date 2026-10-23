import Modele.ExcelFile;
import Modele.Fichier;
import Modele.PiloteF1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Modele.Fichier;
import Modele.PDFfile;
import Modele.PowerPointFile;
import Modele.WordFile;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Statistiques Pilote F1
        List<PiloteF1> pilotes = new ArrayList<>();
        pilotes.add(new PiloteF1("Hamilton", "Lewis", "Ferrari", 106, 207, 7));
        pilotes.add(new PiloteF1("Leclerc", "Charles", "Ferrari", 9, 54, 0));
        pilotes.add(new PiloteF1("Gasly", "Pierre", "Alpine", 1, 6, 0));
        pilotes.add(new PiloteF1("Alonso", "Fernando", "Aston Martin", 32, 106, 2));
        pilotes.add(new PiloteF1("Schumacher", "Michael", "Ferrari", 91, 155, 7));

        //System.out.println(pilotes);

        try {
            Fichier stats[] = new Fichier[1];
            Fichier excel = new ExcelFile("statsF1.xlsx", pilotes);
            stats[0]=excel;

            for(Fichier f : stats) {
                f.writeFile();
                f.readFile();
            }
        Scanner sc = new Scanner(System.in);
        int choix ;

        do {
            System.out.println("\n Choisir un fichier ");
            System.out.println("1. Word");
            System.out.println("2. Pdf");
            System.out.println("3. Excel");
            System.out.println("4. PowerPoint");
            System.out.println("5. Quitter");
            choix = sc.nextInt();

            Fichier f = null;
            switch (choix) {
                case 1 -> f = new WordFile("fichier.docx");
                case 2 -> f = new PDFfile("fichier.pdf", "src/main/java/ressources/texte/paroles.txt");
                //case 3 -> f = new ExcelFile("statsF1.xlsx");
                case 4 -> f = new PowerPointFile("fichier.ppt");
                case 5 -> System.out.println("Au revoir ! ");
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

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
