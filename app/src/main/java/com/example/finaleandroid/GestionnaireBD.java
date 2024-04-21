package com.example.finaleandroid;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.finaleandroid.modele.entite.Code;
import com.example.finaleandroid.modele.entite.Mastermind;
import com.example.finaleandroid.modele.entite.Partie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GestionnaireBD extends SQLiteOpenHelper{
    public GestionnaireBD(Context context){
        super(context, Contrat.DATABASE_NOM, null, Contrat.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String requeteCreation = String.format("create table %s (%s integer primary key autoincrement, %s text, %s text, %s text, %s interger, %s text, %s interger)",
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
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        String requeteModification = String.format("alter table %s add %s int not null", Contrat.DATABASE_NOM, "NOUVELLE_COLONNE");
        db.execSQL(requeteModification);
    }

    public void ajouterPartie(Mastermind partie){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Contrat.Colonnes.COLONNE_ID_CODE_SECRET, partie.getIdCodeSecret());
        values.put(Contrat.Colonnes.COLONNE_COURRIEL, partie.getCourrielJoueur());
        values.put(Contrat.Colonnes.COLONNE_CODE, partie.getCodeSecretConcat());
        values.put(Contrat.Colonnes.COLONNE_NB_COULEURS, partie.getNbCouleurs());
        values.put(Contrat.Colonnes.COLONNE_RESULTAT, partie.getResultatPartie());
        values.put(Contrat.Colonnes.COLONNE_NB_TENTATIVES, partie.getNbTentatives());
        db.insertWithOnConflict(Contrat.TABLE_PARTIES, null, values, SQLiteDatabase.CONFLICT_REPLACE);
    }

    public void supprimerPartie(int id_Partie){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + Contrat.TABLE_PARTIES + " WHERE " + Contrat.Colonnes.COLONNE_ID + " = " + id_Partie;
        db.execSQL(query);
    }

    public ArrayList<Mastermind> retournerListsPartie() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = null;
        ArrayList<Mastermind> listeParties = new ArrayList<>();
            String query = "SELECT * FROM " + Contrat.TABLE_PARTIES;
            cursor = db.rawQuery(query, null);
            while (cursor.moveToNext()) {
                int idIndex = cursor.getColumnIndex(Contrat.Colonnes.COLONNE_ID);
                int idCodeSecretIndex = cursor.getColumnIndex(Contrat.Colonnes.COLONNE_ID_CODE_SECRET);
                int emailIndex = cursor.getColumnIndex(Contrat.Colonnes.COLONNE_COURRIEL);
                int codeSecretIndex = cursor.getColumnIndex(Contrat.Colonnes.COLONNE_CODE);
                int nbCouleursIndex = cursor.getColumnIndex(Contrat.Colonnes.COLONNE_NB_COULEURS);
                int resultatIndex = cursor.getColumnIndex(Contrat.Colonnes.COLONNE_RESULTAT);
                int nbTentativesIndex = cursor.getColumnIndex(Contrat.Colonnes.COLONNE_NB_TENTATIVES);
                if (idIndex == -1 || idCodeSecretIndex == -1 || emailIndex == -1 || codeSecretIndex == -1 ||
                        nbCouleursIndex == -1 || resultatIndex == -1 || nbTentativesIndex == -1) {
                    throw new IllegalArgumentException("Problème avec les colonnes dans la table de bd.");
                }
                String text = cursor.getString(idCodeSecretIndex);
                List<String> list = Arrays.asList(text.split(""));
                Code code = new Code(String.valueOf(cursor.getInt(idIndex)),list, cursor.getInt(nbCouleursIndex) );
                Mastermind mastermind = new Mastermind(code, cursor.getString(emailIndex));
                mastermind.setNbTentatives(cursor.getInt(nbTentativesIndex));
                listeParties.add(mastermind);
            }
            return listeParties;
    }
}
