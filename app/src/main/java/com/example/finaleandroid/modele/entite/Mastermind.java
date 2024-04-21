package com.example.finaleandroid.modele.entite;

import java.util.ArrayList;
import java.util.List;

public class Mastermind {

    private Code  codeSecret;

    private String courrielJoueur;
  //  private int nbTentatives;
  //  private int nbCouleurs;
  //  private int longueurCode;
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
      //  this.tentatives = new Code[nbTentatives];
        //this.feedbacks = new Feedback[nbTentatives];
    }

//    public void jouer(Code tentative) {
//        if (this.partieEnCours) {
//            Feedback feedback = new Feedback(this.code, tentative);
//            this.feedbacks[this.nbCouleursCorrectesEtBienPlacees + this.nbCouleursCorrectesEtMalPlacees] = feedback;
//            this.tentatives[this.nbCouleursCorrectesEtBienPlacees + this.nbCouleursCorrectesEtMalPlacees] = tentative;
//            this.nbCouleursCorrectesEtBienPlacees = feedback.getCouleurCorrecteEtPositionCorrecte();
//            this.nbCouleursCorrectesEtMalPlacees = feedback.getCouleurCorrecteEtPositionIncorrecte();
//            if (this.nbCouleursCorrectesEtBienPlacees == this.longueurCode) {
//                this.partieGagnee = true;
//                this.partieEnCours = false;
//            } else if (this.nbCouleursCorrectesEtBienPlacees + this.nbCouleursCorrectesEtMalPlacees == this.nbTentatives) {
//                this.partiePerdue = true;
//                this.partieEnCours = false;
//            }
//        }
//    }
public void setPartieGagnee(boolean partieGagnee) {
    this.partieGagnee = partieGagnee;
}
    public void setPartiePerdue(boolean partiePerdue) {
        this.partiePerdue = partiePerdue;
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
    public String getCodeSecretConcat(){
        String result = String.join("", this.codeSecret.getCode());
        return result;
    }
    public String getIdCodeSecret() {
        return this.codeSecret.getId();
    }


    public int getNbCouleurs() {
        return codeSecret.getNbCouleurs();
    }
    public String getResultatPartie() {
        String resultat = "";
        if (this.partieGagnee) {
            resultat =  "réussie";
        } else if (this.partiePerdue) {
            resultat = "échouée";
        } else if (this.partieAbandonnee) {
            resultat =  "abandonnée";
        }
        return resultat;
    }
    public void setNbTentatives(int i){
        this.nbTentatives = i;
    }
    public int getNbTentatives(){
        return this.nbTentatives;
    }
    public void setResultat(String i){
        this.resultat = i;
    }
//    public int getLongueurCode() {
//        return this.longueurCode;
//    }

    public int getNbCouleursCorrectesEtBienPlacees() {
        return this.nbCouleursCorrectesEtBienPlacees;
    }

    public int getNbCouleursCorrectesEtMalPlacees() {
        return this.nbCouleursCorrectesEtMalPlacees;
    }

    public boolean isPartieGagnee() {
        return this.partieGagnee;
    }

    public boolean isPartiePerdue() {
        return this.partiePerdue;
    }

    public boolean isPartieEnCours() {
        return this.partieEnCours;
    }

    public List<Code> getTentatives() {
        return this.listTentatives;
    }

    public List<Feedback> getFeedbacks() {
        return this.listFeedbacks;
    }

    public void addFeedback(Feedback feedback) {
       this.listFeedbacks.add(feedback);
    }

    public void addTentative(Code tentative) {
        this.listTentatives.add(tentative);
    }


}
