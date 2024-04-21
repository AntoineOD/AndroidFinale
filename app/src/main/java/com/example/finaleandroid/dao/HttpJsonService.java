package com.example.finaleandroid.dao;
import android.util.Log;


import com.example.finaleandroid.modele.entite.Code;
import com.example.finaleandroid.modele.entite.Couleur;
import com.example.finaleandroid.modele.entite.Stat;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpJsonService {
    private static String URL_POINT_ENTREE = "http://10.0.2.2:3000";

    public List<Code> getCodes() throws IOException, JSONException {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(URL_POINT_ENTREE + "/codesSecrets")
                .build();
        Response response = okHttpClient.newCall(request).execute();
        String responseBody = response.body().string();
        if (isValidJSON(responseBody)) {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Code> codes = Arrays.asList(objectMapper.readValue(responseBody, Code[].class));
            return codes;
        } else {
            Log.e("HttpJsonService:getCodes()", "Invalid JSON response");
            return null;
        }
    }

    public List<Stat> getStats() throws IOException, JSONException {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(URL_POINT_ENTREE + "/stats")
                .build();
        Response response = okHttpClient.newCall(request).execute();
        String responseBody = response.body().string();
        if (isValidJSON(responseBody)) {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Stat> stats = Arrays.asList(objectMapper.readValue(responseBody, Stat[].class));
            return stats;
        } else {
            Log.e("HttpJsonService:getStats()", "Invalid JSON response");
            return null;
        }
    }
    public void putStat(Stat stat) throws IOException, JSONException {
        OkHttpClient okHttpClient = new OkHttpClient();
        MediaType JSON = MediaType.parse("application/json; chartset=utf-8");

        JSONObject obj = new JSONObject();

        obj.put("id", stat.getId());
        obj.put("idCode", stat.getIdCode());
        obj.put("record",stat.getRecord());
        obj.put("courriel", stat.getCourriel() );

        RequestBody corpsRequete = RequestBody.create(String.valueOf(obj), JSON);
        String url = URL_POINT_ENTREE + "/stats/"+stat.getId();
        Request request = new Request.Builder().url(url)
                .post(corpsRequete)
                .build();
        Response response = okHttpClient.newCall(request).execute();

//        Log.e("HttpJsonService:enregistrerCompte()", "Code reponse : "+response.code());
//        if (response.code() == 200) {
//            Log.d("HttpJsonService:enregistrerCompte()", "Compte modifié avec succès");
//
//        }
//        else {
//            Log.d("HttpJsonService:enregistrerCompte()", "Compte non modifié");
//
//        }

    }

    public void postStat(Stat stat) throws IOException, JSONException {
        OkHttpClient okHttpClient = new OkHttpClient();
        MediaType JSON = MediaType.parse("application/json; chartset=utf-8");

        JSONObject obj = new JSONObject();

        obj.put("id", stat.getId());
        obj.put("idCode", stat.getIdCode());
        obj.put("record",stat.getRecord());
        obj.put("courriel", stat.getCourriel() );

        RequestBody corpsRequete = RequestBody.create(String.valueOf(obj), JSON);
        String url = URL_POINT_ENTREE + "/stats";
        Request request = new Request.Builder().url(url)
                .post(corpsRequete)
                .build();
        Response response = okHttpClient.newCall(request).execute();
    }

    private boolean isValidJSON(String test) {
        try {
            new JSONObject(test);
        } catch (JSONException ex) {
            try {
                new JSONArray(test);
            } catch (JSONException ex1) {
                return false;
            }
        }
        return true;
    }

    public Couleur getCouleurs() throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(URL_POINT_ENTREE + "/couleursDisponibles")
                .build();
        Response response = okHttpClient.newCall(request).execute();
        String responseBody = response.body().string();
        if (isValidJSON(responseBody)) {
            ObjectMapper objectMapper = new ObjectMapper();
            Couleur listeCouleur =  objectMapper.readValue(responseBody, Couleur.class);
            System.out.println("test");
            return listeCouleur;
        } else {
            Log.e("HttpJsonService:getStats()", "Invalid JSON response");
            return null;
        }
    }
}
