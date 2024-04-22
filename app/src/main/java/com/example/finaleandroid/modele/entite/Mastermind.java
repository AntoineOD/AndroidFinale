package com.example.finaleandroid.modele.entite;

import java.util.ArrayList;
import java.util.List;

public class Mastermind {

    private Code codeSecret;

    private String courrielJoueur;
    private int nbCouleursCorrectesEtBienPlacees;
    private int nbCouleursCorrectesEtMalPlacees;
    private boolean partieGagnee;
    private boolean partiePerdue;
    private boolean partieAbandonnee;
    private boolean partieEnCours;
    private List<Code> listTentatives;
    private List<Feedback> listFeedbacks;
    private int nbTentatives;
    private String resultat;

    public Mastermind(Code codeSecret, String courrielJoueur) {
        this.codeSecret = codeSecret;
        this.courrielJoueur = courrielJoueur;

        this.nbCouleursCorrectesEtBienPlacees = 0;
        this.nbCouleursCorrectesEtMalPlacees = 0;
        this.partieGagnee = false;
        this.partiePerdue = false;
        this.partieEnCours = true;
        listTentatives = new ArrayList<>();
        listFeedbacks = new ArrayList<>();
    }
    public void setPartieAbandonnee(boolean partieAbandonnee) {
        this.partieAbandonnee = partieAbandonnee;
    }

    public String getCourrielJoueur() {
        return this.courrielJoueur;
    }

    public Code getCodeSecret() {
        return this.codeSecret;
    }

    public String getCodeSecretConcat() {
        String result = String.join(" ", this.codeSecret.getCode());
        return result;
    }

    public String getIdCodeSecret() {
        return this.codeSecret.getId();
    }


    public int getNbCouleurs() {
        return codeSecret.getNbCouleurs();
    }

    public String getResultatPartie() {
        return this.resultat;
    }

    public void setNbTentatives(int i) {
        this.nbTentatives = i;
    }

    public int getNbTentatives() {
        return this.nbTentatives;
    }

    public void setResultat(String i) {
        this.resultat = i;
    }
//    public int getLongueurCode() {
//        return this.longueurCode;
//    }

    public void addFeedback(Feedback feedback) {
        this.listFeedbacks.add(feedback);
    }

    public void addTentative(Code tentative) {
        this.listTentatives.add(tentative);
    }


}
