package com.example.finaleandroid.presentateur;

import android.app.Activity;

import com.example.finaleandroid.activites.MainActivity;
import com.example.finaleandroid.dao.DAO;
import com.example.finaleandroid.modele.Modele;
import com.example.finaleandroid.modele.ModeleManager;
import com.example.finaleandroid.modele.entite.Code;
import com.example.finaleandroid.modele.entite.Stat;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public class PresentateurStat {
    private Activity activite;
    private Modele modele;

    public PresentateurStat(Activity activite) {
        this.activite = activite;
        this.modele = ModeleManager.getInstance();
    }

    public Code getCode(String id) {
        return modele.getCode(id);
    }
    public Stat getStat(String id) {
        return modele.getStat(id);
    }
    public void ObtenirStat(){

    }
    public void obtenirStatistiques(){
        new Thread() {
            @Override
            public void run() {

                try {
                    //Demander au DAO de récupérer la liste des comptes bancaires :
                    List<Stat> liste = DAO.getStats();
                    //Injecter la liste dans le modèle :
                    modele.setStats(liste);
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
