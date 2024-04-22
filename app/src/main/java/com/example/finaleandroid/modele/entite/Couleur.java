package com.example.finaleandroid.modele.entite;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Couleur {

    @JsonProperty("liste")
    private List<String> liste;

    public Couleur() {

    }

    public Couleur(List<String> liste) {
        this.liste = liste;
    }

    public List<String> getCouleur() {
        return liste;
    }

    public void setCouleur(List<String> couleur) {
        this.liste = couleur;
    }
}
