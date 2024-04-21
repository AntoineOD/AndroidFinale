package com.example.finaleandroid.adaptateur;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.finaleandroid.R;
import com.example.finaleandroid.modele.entite.Mastermind;
import com.example.finaleandroid.modele.entite.Partie;

import java.util.List;

public class MasterMindAdapter extends ArrayAdapter<Mastermind> {
    private Context contexte;
    private int viewResourceId;
    private Resources resources;
    private List<Mastermind> listMasterMind;
     TextView tvNCourrielJoeur;
     TextView tvCodeSecret;
     TextView tvNbCouleurs;
     TextView tvResultatPartie;
     TextView tvNbTentatives;

    public MasterMindAdapter(@NonNull Context context, int resource,  List<Mastermind> listMasterMind) {
        super(context, resource);
        this.contexte = context;
        this.viewResourceId = resource;
        this.resources = contexte.getResources();
        this.listMasterMind = listMasterMind;
    }
    @Override
    public int getCount() {
        return this.listMasterMind.size();
    }
    @SuppressLint("NewApi")
    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {

        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) contexte.getSystemService(Context.
                    LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(this.viewResourceId, parent, false);
        }
        Mastermind mastermind = listMasterMind.get(position);
        if (mastermind != null) {
            final TextView tvNCourrielJoeur = (TextView) view.findViewById(R.id.hisTvCourriel);
            final TextView tvCodeSecret = (TextView) view.findViewById(R.id.hisTvCodeSecret);
            final TextView tvNbCouleurs = (TextView) view.findViewById(R.id.hisTvNbCouleurs);
            final TextView tvResultatPartie = (TextView) view.findViewById(R.id.hisTvResultat);
            final TextView tvNbTentatives= (TextView) view.findViewById(R.id.hisTvNbTentatives);


            tvNCourrielJoeur.setText("Courriel : "+mastermind.getCourrielJoueur());
            tvCodeSecret.setText("Code Secret: "+mastermind.getCodeSecretConcat());
            tvNbCouleurs.setText("Nb couleurs: "+mastermind.getNbCouleurs());
            tvResultatPartie.setText("Resultat partie: " +mastermind.getResultatPartie());
            tvNbTentatives.setText("N tentatives: "+mastermind.getNbTentatives());

        }
        return view;
    }
}
