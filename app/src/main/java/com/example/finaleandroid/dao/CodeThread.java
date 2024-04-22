package com.example.finaleandroid.dao;

import com.example.finaleandroid.modele.Modele;
import com.example.finaleandroid.modele.ModeleManager;
import com.example.finaleandroid.modele.entite.Code;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public class CodeThread {
    Modele modele;

    public void runThread() throws IOException, JSONException {
        modele = ModeleManager.getInstance();
        List<Code> liste = null;
        liste = DAO.getCodes();
        modele.setCodes(liste);
    }
}
