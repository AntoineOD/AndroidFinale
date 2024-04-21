package com.example.finaleandroid.modele.entite;

import java.util.ArrayList;
import java.util.List;

public class Feedback {
    private int couleurCorrecteEtPositionCorrecte;
    private int couleurCorrecteEtPositionIncorrecte;
    private Code code;
    private Code tentative;

    public Feedback(Code code, Code tentative) {
        this.code = code;
        this.tentative = tentative;
        computeFeedback();
    }

    private void computeFeedback() {
        List<String> secret = new ArrayList<>(code.getCode());
        List<String> guess = new ArrayList<>(tentative.getCode());

        // First pass to find correct position and color
        for (int i = 0; i < secret.size(); i++) {
            if (secret.get(i).equals(guess.get(i))) {
                couleurCorrecteEtPositionCorrecte++;
                secret.set(i, null); // Mark as matched
                guess.set(i, null);
            }
        }

        // Second pass to find correct color, wrong position
        for (int i = 0; i < guess.size(); i++) {
            if (guess.get(i) != null && secret.contains(guess.get(i))) {
                couleurCorrecteEtPositionIncorrecte++;
                secret.set(secret.indexOf(guess.get(i)), null); // Mark as matched
            }
        }
    }

    public int getCouleurCorrecteEtPositionCorrecte() {
        return couleurCorrecteEtPositionCorrecte;
    }

    public int getCouleurCorrecteEtPositionIncorrecte() {
        return couleurCorrecteEtPositionIncorrecte;
    }
}
