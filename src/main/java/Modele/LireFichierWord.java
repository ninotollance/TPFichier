package Modele;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LireFichierWord {
    public static List<String> lireLignes() throws IOException {
        Scanner lecteur;
        List<String> lignes = new ArrayList<>();

        String nomFichierEntree = "src/main/java/ressources/texte" + File.separator + "cinema.txt";
        BufferedReader lecteurAvecBuffer = null;
        File fichier = new File(nomFichierEntree);
        lecteur = new Scanner(fichier);

        while (lecteur.hasNextLine())
            lignes.add(lecteur.nextLine());

        return lignes;

    }
}
