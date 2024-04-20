package com.example.finaleandroid.activites;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finaleandroid.R;
import com.example.finaleandroid.activites.ConfigActivity;
import com.example.finaleandroid.activites.JeuxActivity;
import com.example.finaleandroid.modele.entite.Code;
import com.example.finaleandroid.modele.entite.Couleur;
import com.example.finaleandroid.modele.entite.Stat;
import com.example.finaleandroid.presentateur.PrensentateurCode;
import com.example.finaleandroid.presentateur.PresentateurCouleur;
import com.example.finaleandroid.presentateur.PresentateurStat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txtTitre;
    TextView txtEmail;
    EditText inpEmail;
    Button btnStart;
    Button btnConfig;
    Button btnHistorique;
    Button btnEmail;
    Boolean emailVerfi;
    final int REQUEST_CODE = 1;
    private int longueurCode =4;
    private int nbCouleurs=8;
    private  int nbTentatives=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTitre = findViewById(R.id.titre);
        txtEmail= findViewById(R.id.messageCouriel);
        inpEmail = findViewById(R.id.inputCouriel);
        btnEmail = findViewById(R.id.btnEmail);
        btnStart = findViewById(R.id.btnPlay);
        btnConfig = findViewById(R.id.btnConfig);
        btnHistorique = findViewById(R.id.btnHistorique);
        emailVerfi = false;
        btnStart.setEnabled(false);

        btnEmail.setOnClickListener(this);
        btnStart.setOnClickListener(this);
        btnConfig.setOnClickListener(this);
        btnHistorique.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v == btnStart){
            Intent intention = new Intent(this, JeuxActivity.class);
            intention.putExtra("LONGUEUR_CODE", longueurCode);
            intention.putExtra("NB_COULEURS", nbCouleurs);
            intention.putExtra("NB_TENTATIVES", nbTentatives);
            startActivity(intention);
        }
        else if(v == btnConfig){
            Intent intention = new Intent(this, ConfigActivity.class);
            startActivityForResult(intention,REQUEST_CODE);
        }
        else if(v == btnHistorique){

        }
        else if(v == btnEmail){
            String email = String.valueOf(inpEmail.getText());
            //VerifEmail(email); On check si le email est un email valide
            //if(verifEmail() == true)
            emailVerfi = true;
            Intent intention = new Intent();
            intention.putExtra("email", email);
            btnStart.setEnabled(true);
            //else
            //Message comme quoi mail est invalide
        }
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_CODE:
                if (resultCode == RESULT_OK) {
                     longueurCode = data.getIntExtra("LONGUEUR_CODE",2);
                     nbCouleurs = data.getIntExtra("NB_COULEURS",6);
                     nbTentatives = data.getIntExtra("NB_TENTATIVES",2);
                }
                break;
        }


    }
}



