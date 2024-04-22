package com.example.finaleandroid.dao;

import com.example.finaleandroid.modele.entite.Code;
import com.example.finaleandroid.modele.entite.Couleur;
import com.example.finaleandroid.modele.entite.Stat;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public class DAO {
    public static List<Code> getCodes() throws IOException, JSONException {
        return new HttpJsonService().getCodes();
    }

    public static List<Stat> getStats() throws IOException, JSONException {
        return new HttpJsonService().getStats();
    }
    public static void ajouterStat(Stat stat) throws IOException, JSONException {
        new HttpJsonService().postStat(stat);
    }

    public static void modifierStat(Stat stat) throws IOException, JSONException {
        new HttpJsonService().putStat(stat);
    }
    public static Couleur getCouleurs() throws IOException, JSONException {
        return new HttpJsonService().getCouleurs();
    }

}
