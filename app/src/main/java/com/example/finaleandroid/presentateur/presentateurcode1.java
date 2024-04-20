package com.example.finaleandroid.presentateur;

import com.example.finaleandroid.dao.DAO;
import com.example.finaleandroid.modele.Modele;
import com.example.finaleandroid.modele.ModeleManager;
import com.example.finaleandroid.modele.entite.Code;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public class presentateurcode1 {
    Modele modele;
    public void getCodelist() throws IOException
    {
        modele = ModeleManager.getInstance();
        List<Code> liste = null;
        liste =DAO.getCodes();
        modele.setCodes(liste);
    }
}
