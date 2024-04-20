package com.example.finaleandroid.presentateur;

import android.app.Activity;

import com.example.finaleandroid.activites.JeuxActivity;
import com.example.finaleandroid.activites.MainActivity;
import com.example.finaleandroid.dao.DAO;
import com.example.finaleandroid.modele.Modele;
import com.example.finaleandroid.modele.ModeleManager;
import com.example.finaleandroid.modele.entite.Code;
import com.example.finaleandroid.modele.entite.Couleur;
import com.example.finaleandroid.modele.entite.Stat;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PresentateurCouleur {

    private Activity activite;
    private Modele modele;

    public PresentateurCouleur(Activity activite) {
        this.activite = activite;
        this.modele = ModeleManager.getInstance();
    }

    public List<Couleur> getCouleurs() {
        return modele.getCouleurs();
    }


    public Couleur getCouleur(String id) {
        return modele.getCouleur(id);
    }


    public void ObtenirCouleurs(){
        new Thread() {
            @Override
            public void run() {

                try {
                    //Demander au DAO de récupérer la liste des comptes bancaires :
                    modele = ModeleManager.getInstance();
                    List<Couleur> liste = null;
                    liste = DAO.getCouleurs();
                    //Injecter la liste dans le modèle :
                    modele.setCouleurs(liste);
                    //Demander à la vue (activité) de rafraichir le ListView :
                } catch (JSONException e) {

                } catch (IOException e) {

                }
            }
        }.start();
    }

    public List<Couleur> getCouleursCorespondantes(int nbCouleurs) {

        List<Couleur> couleurs = modele.getCouleurs();
        List<Couleur> couleursCorespondantes = new ArrayList<>();
        for (int i = 0; i < nbCouleurs; i++) {
            couleursCorespondantes.add(couleurs.get(i));
        }
        return couleursCorespondantes;
    }
}
