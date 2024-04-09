package com.example.finaleandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txtTitre;
    TextView txtEmail;
    EditText inpEmail;
    Button btnStart;
    Button btnConfig;
    Button btnHistorique;
    Button btnEmail;
    Boolean emailVerfi;

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
        if(v.getId() == R.id.btnPlay){

        }
        else if(v.getId() == R.id.btnConfig){
            System.out.println("Oui");
            Intent intention = new Intent(this, ConfigActivity.class);
            startActivity(intention);
        }
        else if(v.getId() == R.id.btnHistorique){

        }
        else if(v.getId() == R.id.btnEmail){
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
}
