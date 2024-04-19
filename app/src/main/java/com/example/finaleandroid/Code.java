package com.example.finaleandroid;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Code {
    private String id;
    private List<String> code;
    private int nbCouleurs;

    // Constructor
    public Code() {
        // Default constructor
    }

    public Code(String id, List<String> code, int nbCouleurs) {
        this.id = id;
        this.code = code;
        this.nbCouleurs = nbCouleurs;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getCode() {
        return code;
    }

    public void setCode(List<String> code) {
        this.code = code;
    }

    public int getNumberOfColors() {
        return nbCouleurs;
    }

    public void setNumberOfColors(int numberOfColors) {
        this.nbCouleurs = numberOfColors;
    }

}


