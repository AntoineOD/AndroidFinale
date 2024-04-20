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
    public static Couleur getCouleurs() throws IOException, JSONException {
        return new HttpJsonService().getCouleurs();
    }



}
