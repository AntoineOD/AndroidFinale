package com.example.finaleandroid;

public class Contrat {

    public static final String DATABASE_NOM = "finale.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_PARTIES = "parties";

    public class Colonnes{
        public static final String COLONNE_ID = "_id_partie";
        public static final String COLONNE_ID_CODE_SECRET = "_id_code_secret";
        public static final String COLONNE_COURRIEL = "_courriel";
        public static final String COLONNE_CODE = "_code";
        public static final String COLONNE_NB_COULEURS = "_nb_couleurs";
        public static final String COLONNE_RESULTAT = "_resultat";
        public static final String COLONNE_NB_TENTATIVES = "_nb_tentatives";

    }
}
