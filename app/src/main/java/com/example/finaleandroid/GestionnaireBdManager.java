package com.example.finaleandroid;

import android.app.Activity;

import com.example.finaleandroid.activites.JeuxActivity;
import com.example.finaleandroid.modele.Modele;

public class GestionnaireBdManager {

    GestionnaireBD gestionnaireDataBase;
    public GestionnaireBdManager(Activity activite)
    {
        gestionnaireDataBase = new GestionnaireBD(activite);
    }
    public GestionnaireBD getDBUtil()
    {
        return gestionnaireDataBase;
    }
}
