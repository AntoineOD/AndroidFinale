package com.example.finaleandroid;

public class Code {
    private String[] code;

    public Code(int longueur) {
        this.code = new String[longueur];
    }

    public void setElement(int index, String element) {
        this.code[index] = element;
    }

    public String getElement(int index) {
        return this.code[index];
    }

    public String[] getCode() {
        return this.code;
    }

    public void genererCodeAleatoire(int nbCouleurs) {

    }

}
