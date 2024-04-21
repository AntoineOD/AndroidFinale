package com.example.finaleandroid.activites;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finaleandroid.R;
import com.example.finaleandroid.dao.DAO;
import com.example.finaleandroid.modele.entite.Code;
import com.example.finaleandroid.modele.entite.Couleur;
import com.example.finaleandroid.modele.entite.Feedback;
import com.example.finaleandroid.modele.entite.Mastermind;
import com.example.finaleandroid.modele.entite.Stat;
import com.example.finaleandroid.presentateur.PrensentateurCode;
import com.example.finaleandroid.presentateur.PresentateurCouleur;
import com.example.finaleandroid.presentateur.PresentateurStat;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JeuxActivity extends AppCompatActivity implements View.OnClickListener {
    int row;
    int column;
    LinearLayout layoutFeedback;
    Drawable dice;
    private Code codeSecret;
    private Stat statistique;
    private List<String> listCouleur;
    private List<Code> listCodes;
    private List<Stat> listStats;
    private PrensentateurCode prensentateurCode;
    private PresentateurStat prensentateurStat;
    private PresentateurCouleur presentateurCouleur;
    private int longueurCode;
    private int nbCouleurs;
    private int nbTentatives;
    private Mastermind mastermind;
    private int selectedColor = -1;
    private int currentRow;
    Button btnValider;
    Button btnAbandonner;
    Button btnNouvellePartie;
    Button btnMenuPrincipal;
    Feedback feedback;
    Code tentative;
    List<String> tentativeCouleurs;

    int[][] buttonCouleurs;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeux);

        btnValider = findViewById(R.id.btnValider);
        btnAbandonner = findViewById(R.id.btnAbandonner);
        btnNouvellePartie = findViewById(R.id.btnNouvellePartie);
        btnMenuPrincipal = findViewById(R.id.btnMenuPrincipal);
        btnValider.setOnClickListener(this);
        btnAbandonner.setOnClickListener(this);
        btnNouvellePartie.setOnClickListener(this);
        btnMenuPrincipal.setOnClickListener(this);


        Intent intention = this.getIntent();
        nbCouleurs = intention.getIntExtra("NB_COULEURS", 8);
        longueurCode = intention.getIntExtra("LONGUEUR_CODE", 4);
        nbTentatives = intention.getIntExtra("NB_TENTATIVES", 10);
        currentRow = nbTentatives -1;

        prensentateurCode=new PrensentateurCode(this);
        listCodes = prensentateurCode.getCodes();
        codeSecret = prensentateurCode.obtenirCodeSecret(longueurCode, nbCouleurs);

        prensentateurStat = new PresentateurStat(this);
        prensentateurStat.ObtenirStatistiques();
        listStats = prensentateurStat.getStats();
        statistique = prensentateurStat.obtenirStatistiqueCorrespondante(codeSecret.getId());

        presentateurCouleur = new PresentateurCouleur(this);
        presentateurCouleur.ObtenirCouleurs();
        presentateurCouleur.getCouleurs();
        listCouleur = presentateurCouleur.getCouleursCorespondantes(nbCouleurs);

        androidx.gridlayout.widget.GridLayout gridLayoutTentatives = findViewById(R.id.gridLayoutTentatives);

        row = nbTentatives;
        column = longueurCode;

        tentativeCouleurs = new ArrayList<>();
        buttonCouleurs = new int[nbTentatives][longueurCode];

        mastermind = new Mastermind(longueurCode, nbCouleurs, nbTentatives);

        gridLayoutTentatives.setRowCount(row);
        gridLayoutTentatives.setColumnCount(column);
        for (int i = 0; i < row * column; i++) {
            Drawable drawable = getResources().getDrawable(R.drawable.ovale);
            Button btnTentatives = new Button(this);
            btnTentatives.setBackground(drawable);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = 100;
            params.height = 100;
            params.setMargins(5, 10, 5, 10);
            btnTentatives.setLayoutParams(params);
            final int rowNum = i / column;
            final int colNum = i % column;
            btnTentatives.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (selectedColor != -1 && rowNum == currentRow) {
                        v.setBackgroundColor(selectedColor);
                        buttonCouleurs[rowNum][colNum] = selectedColor; // Update the color in the array
                    }
                }
            });
            gridLayoutTentatives.addView(btnTentatives);
        }
        //Palette de couleurs

        androidx.gridlayout.widget.GridLayout gridLayoutPalette = findViewById(R.id.layoutPalette);
        if (nbCouleurs > 6) {
            gridLayoutPalette.setRowCount(6);
            gridLayoutPalette.setColumnCount(2);
        } else {
            gridLayoutPalette.setRowCount(1);
            gridLayoutPalette.setColumnCount(6);
        }
        for (int i = 0; i < nbCouleurs; i++) {
            Button btnPalette = new Button(this);
            String colorString = listCouleur.get(i);
            if (!colorString.startsWith("#")) {
                colorString = "#" + colorString;
            }
            try {
                int couleur = Color.parseColor(colorString);
                btnPalette.setBackgroundColor(couleur);
            } catch (IllegalArgumentException e) {
            }
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = 100;
            params.height = 100;
            params.setMargins(5, 10, 5, 10);
            btnPalette.setLayoutParams(params);
            btnPalette.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedColor = ((ColorDrawable) v.getBackground()).getColor();
                }
            });
            gridLayoutPalette.addView(btnPalette);
        }
        // Feedback
        layoutFeedback = findViewById(R.id.layoutReponses);
        if(column==2)
        {
            this.dice = getResources().getDrawable(R.drawable.dice2);
        }
        if(column==3)
        {
            this.dice = getResources().getDrawable(R.drawable.dice3);
        }
        if (column == 4) {
            this.dice = getResources().getDrawable(R.drawable.dice4);
        }
        if (column == 5) {
            this.dice = getResources().getDrawable(R.drawable.dice5);
        }
        if (column == 6) {
            this.dice = getResources().getDrawable(R.drawable.dice6);
        }
        for (int i = 0; i < row; i++) {
            ImageView imgDice = new ImageView(this);
            imgDice.setImageDrawable(dice);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(100, 100);
            layoutParams.setMargins(5, 10, 5, 10);
            imgDice.setLayoutParams(layoutParams);
            layoutFeedback.addView(imgDice);
        }

    }

    public void afficherMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        if (v == btnValider) {
            if (currentRow >= 0) {
                tentativeCouleurs.clear();
                for (int i = 0; i < longueurCode; i++) {
                    int couleur = buttonCouleurs[currentRow][i];
                    String hexCoulor = String.format("%08X", couleur).toLowerCase();
                    tentativeCouleurs.add(hexCoulor);
                }
                tentative = new Code(codeSecret.getId(), tentativeCouleurs, codeSecret.getNbCouleurs());
                feedback = new Feedback(codeSecret, tentative);
                mastermind.addTentative(tentative);
                mastermind.addFeedback(feedback);
                // Log or use tentativeCouleurs as needed
                if (currentRow > 0) {
                    currentRow--; // Prepare for the next row
                }
            }
        }else if (v == btnAbandonner) {

        } else if (v == btnNouvellePartie) {

        } else if (v == btnMenuPrincipal) {
            {
                finish();
            }

        }
    }
}
