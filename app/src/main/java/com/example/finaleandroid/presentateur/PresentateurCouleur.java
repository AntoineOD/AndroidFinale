package com.example.finaleandroid.presentateur;

import android.app.Activity;

import com.example.finaleandroid.activites.MainActivity;
import com.example.finaleandroid.dao.DAO;
import com.example.finaleandroid.modele.Modele;
import com.example.finaleandroid.modele.ModeleManager;
import com.example.finaleandroid.modele.entite.Code;
import com.example.finaleandroid.modele.entite.Couleur;
import com.example.finaleandroid.modele.entite.Stat;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public class PresentateurCouleur {

        private Activity activite;
        private Modele modele;

        public PresentateurCouleur(Activity activite) {
            this.activite = activite;
            this.modele = ModeleManager.getInstance();
        }

        public List<Couleur > getCouleurs(String id) {
            return modele.getCouleurs();
        }
        public Couleur getCouleur(String id) {
            return modele.getCouleur(id);
        }
        public void ObtenirCouleur(){

        }
    public void obtenirCouleurs(){
        new Thread() {
            @Override
            public void run() {

                try {
                    //Demander au DAO de récupérer la liste des comptes bancaires :
                    List<Couleur> liste = DAO.getCouleurs();
                    //Injecter la liste dans le modèle :
                    modele.setCouleurs(liste);
                    //Demander à la vue (activité) de rafraichir le ListView :
                    ((MainActivity)activite).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ((MainActivity)activite).raffraichirListe();
                        }
                    });
                } catch (JSONException e) {
                    ((MainActivity)activite).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ((MainActivity)activite).afficherMessage("Problème dans le JSON des comptes");
                        }
                    });
                } catch (IOException e) {
                    ((MainActivity)activite).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ((MainActivity)activite).afficherMessage("Problème d'accès à l'API");
                        }
                    });
                }
            }
        }.start();
    }
}



}
