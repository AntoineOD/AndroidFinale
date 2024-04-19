package com.example.finaleandroid.modele;

public class ModeleManager {

    private static Modele instance = null;


    public static Modele getInstance(){
        if(instance ==null)
            instance = new Modele();

        return instance;
    }
}

