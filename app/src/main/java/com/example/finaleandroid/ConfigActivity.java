package com.example.finaleandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config_activity);

        txtTitre = findViewById(R.id.txtConfig);
        txtLongCode = findViewById(R.id.txtLongeurCode);
        txtNbCouleurs = findViewById(R.id.txtNbCouleurs);
        txtNbTentatives = findViewById(R.id.txtNbTentatives);


        spin1 = findViewById(R.id.spin1);
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayList<String> listeSpin1 = new ArrayList<>();
        for(int i = 2; i<7; i++){
            listeSpin1.add(String.valueOf(i));
        }
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listeSpin1);
        adapter1.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spin1.setAdapter(adapter1);
        spin2 = findViewById(R.id.spin2);
        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayList<String> listeSpin2 = new ArrayList<>();
        for(int i = 2; i<9; i++){
            listeSpin2.add(String.valueOf(i));
        }
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listeSpin2);
        adapter2.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spin2.setAdapter(adapter2);
        spin3 = findViewById(R.id.spin3);
        spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayList<String> listeSpin3 = new ArrayList<>();
        for(int i = 8; i<13; i++){
            listeSpin3.add(String.valueOf(i));
        }
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listeSpin3);
        adapter3.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spin3.setAdapter(adapter3);

        spin1.setSelection(2);
        spin2.setSelection(6);
        spin3.setSelection(2);

        btnSave = findViewById(R.id.btnSave);
    }
    @Override
    public void onClick(View v) {

    }
}
