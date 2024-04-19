package com.example.finaleandroid;
import android.util.Log;


import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
public class HttpJsonService {
    private static String URL_POINT_ENTREE = "http://http://10.0.2.2:3000";

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
}
