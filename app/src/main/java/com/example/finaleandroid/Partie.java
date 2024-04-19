package com.example.finaleandroid;

public class Partie {

    private String id_Partie;
    private String id_Code_Secret;
    private String courriel_Joueur;
    private String code_Secret;
    private int nb_Couleurs;
    private String resultat;
    private int nb_Tentatives;

    public Partie() {
        // Default constructor
    }

    public Partie(String id_Partie, String id_Code_Secret, String courriel_Joueur, String code_Secret, int nb_Couleurs, String resultat, int nb_Tentatives) {
        this.id_Partie = id_Partie;
        this.id_Code_Secret = id_Code_Secret;
        this.courriel_Joueur = courriel_Joueur;
        this.code_Secret = code_Secret;
        this.nb_Couleurs = nb_Couleurs;
        this.resultat = resultat;
        this.nb_Tentatives = nb_Tentatives;
    }

    public String getIdPartie() {
        return id_Partie;
    }

    public void setIdPartie(String id_Partie) {
        this.id_Partie = id_Partie;
    }

    public String getIdCodeSecret() {
        return id_Code_Secret;
    }

    public void setIdCodeSecret(String id_Code_Secret) {
        this.id_Code_Secret = id_Code_Secret;
    }

    public String getCourrielJoueur() {
        return courriel_Joueur;
    }

    public void setCourrielJoueur(String courriel_Joueur) {
        this.courriel_Joueur = courriel_Joueur;
    }

    public String getCodeSecret() {
        return code_Secret;
    }

    public void setCodeSecret(String code_Secret) {
        this.code_Secret = code_Secret;
    }

    public int getNbCouleurs() {
        return nb_Couleurs;
    }

    public void setNbCouleurs(int nb_Couleurs) {
        this.nb_Couleurs = nb_Couleurs;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public int getNbTentatives() {
        return nb_Tentatives;
    }

    public void setNbTentatives(int nb_Tentatives) {
        this.nb_Tentatives = nb_Tentatives;
    }
}
