package com.example.finaleandroid;

public class Mastermind {

//    private Code code;
//    private int nbTentatives;
//    private int nbCouleurs;
//    private int longueurCode;
//    private int nbCouleursCorrectesEtBienPlacees;
//    private int nbCouleursCorrectesEtMalPlacees;
//    private boolean partieGagnee;
//    private boolean partiePerdue;
//    private boolean partieEnCours;
//    private Code[] tentatives;
//    private Feedback[] feedbacks;
//
//    public Mastermind(int nbTentatives, int nbCouleurs, int longueurCode) {
//        this.nbTentatives = nbTentatives;
//        this.nbCouleurs = nbCouleurs;
//        this.longueurCode = longueurCode;
//        this.code = new Code(longueurCode);
//        this.code.genererCodeAleatoire(nbCouleurs);
//        this.nbCouleursCorrectesEtBienPlacees = 0;
//        this.nbCouleursCorrectesEtMalPlacees = 0;
//        this.partieGagnee = false;
//        this.partiePerdue = false;
//        this.partieEnCours = true;
//        this.tentatives = new Code[nbTentatives];
//        this.feedbacks = new Feedback[nbTentatives];
//    }
//
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
//
//    public Code getCode() {
//        return this.code;
//    }
//
//    public int getNbTentatives() {
//        return this.nbTentatives;
//    }
//
//    public int getNbCouleurs() {
//        return this.nbCouleurs;
//    }
//
//    public int getLongueurCode() {
//        return this.longueurCode;
//    }
//
//    public int getNbCouleursCorrectesEtBienPlacees() {
//        return this.nbCouleursCorrectesEtBienPlacees;
//    }
//
//    public int getNbCouleursCorrectesEtMalPlacees() {
//        return this.nbCouleursCorrectesEtMalPlacees;
//    }
//
//    public boolean isPartieGagnee() {
//        return this.partieGagnee;
//    }
//
//    public boolean isPartiePerdue() {
//        return this.partiePerdue;
//    }
//
//    public boolean isPartieEnCours() {
//        return this.partieEnCours;
//    }
//
//    public Code[] getTentatives() {
//        return this.tentatives;
//    }
//
//    public Feedback[] getFeedbacks() {
//        return this.feedbacks;
//    }
//

}
