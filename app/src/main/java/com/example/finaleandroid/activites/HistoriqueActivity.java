package com.example.finaleandroid.activites;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finaleandroid.R;

public class HistoriqueActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnRetour;
    private ListView lvHistorique;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historique);

        btnRetour = findViewById(R.id.historiquebtn);
        btnRetour.setOnClickListener(this);

        lvHistorique = findViewById(R.id.historiqueLv);

        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.layout_element_historique,);
        lvHistorique.setAdapter(adapter);


    }

    @Override
    public void onClick(View v) {
        if(v == btnRetour)  {
            finish();
        }
    }
}

