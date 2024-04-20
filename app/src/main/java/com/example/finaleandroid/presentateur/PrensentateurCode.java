package com.example.finaleandroid.presentateur;

import android.app.Activity;

import com.example.finaleandroid.activites.JeuxActivity;
import com.example.finaleandroid.activites.MainActivity;
import com.example.finaleandroid.dao.CodeThread;
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



    public void ObtenirCode() {
        modele = ModeleManager.getInstance();
        (new Thread() {
            @Override
            public void run() {
                System.out.println("Thread is running..."); // Add logging
                try {
                    CodeThread c = new CodeThread();
                    c.runThread();
                } catch (JSONException | IOException e) {
                    e.printStackTrace(); // Handle or log the exception
                }
            }
        }).start();
    }
    public Code obtenirCodeSecret(int longueurCode, int nbCouleurs) {
        List<Code> codesCorespondant = new ArrayList();
        for( Code code:modele.getCodes()){
            if(code.getCode().size() == longueurCode && code.getNbCouleurs() == nbCouleurs){
                codesCorespondant.add(code);
            }
        }
        if (!codesCorespondant.isEmpty()) {
            int randomIndex = new Random().nextInt(codesCorespondant.size());
            return codesCorespondant.get(randomIndex);
        }
        return null;
    }
}


