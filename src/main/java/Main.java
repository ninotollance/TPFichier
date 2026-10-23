import Modele.ExcelFile;
import Modele.Fichier;
import Modele.PiloteF1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
