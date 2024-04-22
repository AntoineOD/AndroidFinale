package com.example.finaleandroid.presentateur;

import android.app.Activity;

import com.example.finaleandroid.activites.JeuxActivity;
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


    public Stat getStat(String id) {
        return modele.getStat(id);
    }

    public List<Stat> getStats() {
        return modele.getStats();
    }

    public void ObtenirStatistiques() {
        new Thread() {
            @Override
            public void run() {

                try {
                    //Demander au DAO de récupérer la liste des comptes bancaires :
                    modele = ModeleManager.getInstance();
                    List<Stat> liste = null;
                    liste = DAO.getStats();
                    //Injecter la liste dans le modèle :
                    modele.setStats(liste);
                    //Demander à la vue (activité) de rafraichir le ListView :
                } catch (JSONException e) {
                } catch (IOException e) {
                }
            }
        }.start();
    }

    public void modifierStatistique(Stat stat) {
        new Thread() {
            @Override
            public void run() {
                try {
                    DAO.modifierStat(stat);
                } catch (IOException e) {
                } catch (JSONException e) {
                }
            }
        }.start();
    }

    public void ajouterStatistique(Stat stat) {
        new Thread() {
            @Override
            public void run() {
                try {
                    DAO.ajouterStat(stat);
                } catch (IOException e) {
                } catch (JSONException e) {
                }
            }
        }.start();
    }

    public Stat obtenirStatistiqueCorrespondante(String idCodeSecret) {

        Stat statCorespondante = null;
        for (Stat stat : modele.getStats()) {
            if (stat.getIdCode().equals(idCodeSecret)) {
                statCorespondante = stat;
            }
        }
        return statCorespondante;
    }
}






