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

    int positionSpin1;
    int positionSpin2;
    int positionSpin3;

    private int nbTentatives;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config_activity);

        getPreferences(MODE_PRIVATE).edit()
                .remove("positionSpin1")
                .remove("positionSpin2")
                .remove("positionSpin3")
                .apply();

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
        if (savedInstanceState == null) {
            restoreSpinnerPositions();
        } else {
            positionSpin1 = savedInstanceState.getInt("positionSpin1", 2);
            positionSpin2 = savedInstanceState.getInt("positionSpin2", 6);
            positionSpin3 = savedInstanceState.getInt("positionSpin3", 2);
            updateSpinners();
        }

        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                longeurCode = Integer.parseInt(selectedItem);
                positionSpin1 = position;
                spin1.setSelection(positionSpin1);
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
                positionSpin2 = position;
                spin2.setSelection(positionSpin2);
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
                positionSpin3 = position;
                spin3.setSelection(positionSpin3);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save spinner positions
        outState.putInt("positionSpin1", positionSpin1);
        outState.putInt("positionSpin2", positionSpin2);
        outState.putInt("positionSpin3", positionSpin3);
    }


    private void restoreSpinnerPositions() {
        // Restore the spinner positions from preferences
        positionSpin1 = 2;
        positionSpin2 = 6;
        positionSpin3 = 2;
        updateSpinners();
    }

    private void updateSpinners() {
        spin1.setSelection(positionSpin1);
        spin2.setSelection(positionSpin2);
        spin3.setSelection(positionSpin3);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Restore the spinner positions
        positionSpin1 = getPreferences(MODE_PRIVATE).getInt("positionSpin1", 2);
        positionSpin2 = getPreferences(MODE_PRIVATE).getInt("positionSpin2", 6);
        positionSpin3 = getPreferences(MODE_PRIVATE).getInt("positionSpin3", 2);
        spin1.setSelection(positionSpin1);
        spin2.setSelection(positionSpin2);
        spin3.setSelection(positionSpin3);
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Clear the saved spinner positions
        getPreferences(MODE_PRIVATE).edit()
                .remove("positionSpin1")
                .remove("positionSpin2")
                .remove("positionSpin3")
                .apply();
    }


    @Override
    protected void onPause() {
        super.onPause();
        // Save the spinner positions
        getPreferences(MODE_PRIVATE).edit()
                .putInt("positionSpin1", positionSpin1)
                .putInt("positionSpin2", positionSpin2)
                .putInt("positionSpin3", positionSpin3)
                .apply();
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
