package com.example.finaleandroid;

public class Stat {
    private String id;
    private String idCode;
    private String record;
    private String courriel;

    public Stat() {
        // Default constructor
    }

    public Stat(String id, String idCode, String record, String courriel) {
        this.id = id;
        this.idCode = idCode;
        this.record = record;
        this.courriel = courriel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }


}
