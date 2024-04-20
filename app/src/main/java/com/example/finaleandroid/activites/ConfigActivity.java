package com.example.finaleandroid.activites;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finaleandroid.R;

import java.util.ArrayList;

public class ConfigActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txtTitre;
    TextView txtLongCode;
    TextView txtNbCouleurs;
    TextView txtNbTentatives;
    Spinner spin1;
    Spinner spin2;
    Spinner spin3;
    Button btnSave;
    private int longeurCode;
    private int nbCouleurs;

    int positionSpin1 = 2;
    int positionSpin2 =6;
    int positionSpin3=2;

    private int nbTentatives;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config_activity);

        txtTitre = findViewById(R.id.txtConfig);
        txtLongCode = findViewById(R.id.txtLongeurCode);
        txtNbCouleurs = findViewById(R.id.txtNbCouleurs);
        txtNbTentatives = findViewById(R.id.txtNbTentatives);
        spin1 = findViewById(R.id.spin1);
        spin2 = findViewById(R.id.spin2);
        spin3 = findViewById(R.id.spin3);
        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);



        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.spinner_longueur_code, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spin1.setAdapter(adapter1);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.spinner_nb_couleurs, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spin2.setAdapter(adapter2);

        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.spinner_nb_tentatives, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spin3.setAdapter(adapter3);

        spin1.setSelection(positionSpin1);
        spin2.setSelection(positionSpin2);
        spin3.setSelection(positionSpin3);
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                longeurCode = Integer.parseInt(selectedItem);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                nbCouleurs = Integer.parseInt(selectedItem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                nbTentatives = Integer.parseInt(selectedItem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v == btnSave){
            Intent data = new Intent();
            data.putExtra("LONGUEUR_CODE",longeurCode);
            data.putExtra("NB_COULEURS", nbCouleurs);
            data.putExtra("NB_TENTATIVES", nbTentatives);
            setResult(RESULT_OK,data);
            finish();
        }
    }
}
