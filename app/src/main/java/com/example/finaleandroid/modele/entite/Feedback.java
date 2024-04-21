package com.example.finaleandroid.modele.entite;

import java.util.ArrayList;
import java.util.List;

public class Feedback {

    private int couleurCorrecteEtPositionCorrecte;
    private int couleurCorrecteEtPositionIncorrecte;
    private  Code code;
    private Code tentative;

    List<Integer> listeResultat = new ArrayList<Integer>();

    public Feedback(Code code, Code tentative) {
        this.couleurCorrecteEtPositionCorrecte = 0;
        this.couleurCorrecteEtPositionIncorrecte = 0;
        this.code = code;
        this.tentative = tentative;

        for (int i = 0; i < code.getCode().size(); i++) {
            if (code.getCode().get(i).equals(tentative.getCode().get(i))) {
//                this.listeResultat.add(2);
                  couleurCorrecteEtPositionCorrecte++;
            }
            else {
                for (int j = 0; j < code.getCode().size(); j++) {
                    if (code.getCode().get(i).equals(tentative.getCode().get(j))) {
//                        this.listeResultat.add(1);
                        couleurCorrecteEtPositionIncorrecte++;
                    }
                }
            }
        }
    }

    public List<Integer> getListeResultat() {
        return listeResultat;
    }

    public int getCouleurCorrecteEtPositionCorrecte() {
        return this.couleurCorrecteEtPositionCorrecte;
    }

    public int getCouleurCorrecteEtPositionIncorrecte() {
        return this.couleurCorrecteEtPositionIncorrecte;
    }
}
