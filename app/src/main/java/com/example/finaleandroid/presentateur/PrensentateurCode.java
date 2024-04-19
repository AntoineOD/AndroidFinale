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
import java.util.Random;

public class PrensentateurCode {
    private Activity activite;
    private Modele modele;

    public PrensentateurCode(Activity activite) {
        this.activite = activite;
        this.modele = ModeleManager.getInstance();
    }

    public List<Code> getCodes() {
       return modele.getCodes();
    }


    public Code getCode(String id) {
        return modele.getCode(id);
    }


public void ObtenirCode(){
    new Thread() {
        @Override
        public void run() {

            try {
                //Demander au DAO de récupérer la liste des comptes bancaires :
                List<Code> liste = DAO.getCodes();
                //Injecter la liste dans le modèle :
                modele.setCodes(liste);
                //Demander à la vue (activité) de rafraichir le ListView :
                ((JeuxActivity)activite).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ((JeuxActivity)activite).afficherMessage("Code obtenus avec succès");
                    }
                });
            } catch (JSONException e) {
                ((JeuxActivity)activite).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ((JeuxActivity)activite).afficherMessage("Problème dans le JSON des comptes");
                    }
                });
            } catch (IOException e) {
                ((JeuxActivity)activite).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ((JeuxActivity)activite).afficherMessage("Problème d'accès à l'API");
                    }
                });
            }
        }
    }.start();
    }
    public Code obtenirCodeSecret(int longueurCode, int nbCouleurs) {
        ArrayList<Code> codesCoresspondant = new ArrayList();
        for( Code code:modele.getCodes()){
            if(code.getCode().size() == longueurCode && code.getNumberOfColors() == nbCouleurs){
                codesCoresspondant.add(code);
            }
        }
        if (!codesCoresspondant.isEmpty()) {
            int randomIndex = new Random().nextInt(codesCoresspondant.size());
            return codesCoresspondant.get(randomIndex);
        }
        return null;

    }
}


