package Modele;

import java.io.*;

public class EcrireFichierWord {
    public static void ecrire() throws IOException {

        PrintWriter ecrire;
        // créer 2 dossier "ressources" et "texte" grace à mkdirs
        File rep = new File("src/main/java/ressources/texte");
        rep.mkdirs();

        String nomFichierSortie = rep + File.separator + "cinema.txt";

        ecrire = new PrintWriter(new BufferedWriter(new FileWriter(nomFichierSortie)));

        ecrire.println("No Country for Old Men");
        ecrire.println("Est un film américain réalisé par Joel et Ethan Coen et sorti en 2007. Il s'agit d'une adaptation du roman Non, ce pays n'est pas pour le vieil homme de Cormac McCarthy paru en 2005.");
        ecrire.println("En 2024, il est sélectionné par le National Film Registry pour conservation à la bibliothèque du Congrès des États-Unis, en raison de son « importance culturelle, historique ou esthétique ».");
        ecrire.println();
        ecrire.println("Crédit :");
        ecrire.println("Réalisation : Joel et Ethan Coen\n" +
                "Scénario : Joel et Ethan Coen\n" +
                "Musique : Carter Burwell\n" +
                "Acteurs principaux : Tommy Lee Jones" +
                ", Javier Bardem " +
                ", Josh Brolin " +
                ", Woody Harrelson ");
        ecrire.close();
    }
}
