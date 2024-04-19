package com.example.finaleandroid;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class GestionnaireBD extends SQLiteOpenHelper{
    public GestionnaireBD(Context context){
        super(context, Contrat.DATABASE_NOM, null, Contrat.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String requeteCreation = String.format("create table %s (%s text primary key, %s text, %s text, %s text, %s interger, %s text, %s interger)",
                Contrat.TABLE_PARTIES,
                Contrat.Colonnes.COLONNE_ID,
                Contrat.Colonnes.COLONNE_ID_CODE_SECRET,
                Contrat.Colonnes.COLONNE_COURRIEL,
                Contrat.Colonnes.COLONNE_CODE,
                Contrat.Colonnes.COLONNE_NB_COULEURS,
                Contrat.Colonnes.COLONNE_RESULTAT,
                Contrat.Colonnes.COLONNE_NB_TENTATIVES);

        db.execSQL(requeteCreation);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, )
}
