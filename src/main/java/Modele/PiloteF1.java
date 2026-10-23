package Modele;

public class PiloteF1 {
    private String nom;
    private String prenom;
    private String ecurie;
    private int victoire;
    private int podium;
    private int championnat;

    public PiloteF1(String nom, String prenom, String ecurie, int victoire, int podium, int championnat) {
        this.nom = nom;
        this.prenom = prenom;
        this.ecurie = ecurie;
        this.victoire = victoire;
        this.podium = podium;
        this.championnat = championnat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEcurie() {
        return ecurie;
    }

    public void setEcurie(String ecurie) {
        this.ecurie = ecurie;
    }

    public int getVictoire() {
        return victoire;
    }

    public void setVictoire(int victoire) {
        this.victoire = victoire;
    }

    public int getPodium() {
        return podium;
    }

    public void setPodium(int podium) {
        this.podium = podium;
    }

    public int getChampionnat() {
        return championnat;
    }

    public void setChampionnat(int championnat) {
        this.championnat = championnat;
    }

    @Override
    public String toString() {
        return "PiloteF1{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", ecurie='" + ecurie + '\'' +
                ", victoire=" + victoire +
                ", podium=" + podium +
                ", championnat=" + championnat +
                '}';
    }
}
