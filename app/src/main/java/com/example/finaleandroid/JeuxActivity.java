package com.example.finaleandroid;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import androidx.appcompat.app.AppCompatActivity;

public class JeuxActivity extends AppCompatActivity implements View.OnClickListener{
    GridLayout gridLayoutTentatives;
    int row;
    int column;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeux);

        gridLayoutTentatives = findViewById(R.id.gridLayoutTentatives);
        row=4;
        column=10;
        gridLayoutTentatives.setRowCount(row);
        gridLayoutTentatives.setColumnCount(column);
        Drawable drawable = getResources().getDrawable(R.drawable.ovale);
        Button btnTentatives = new Button(this);
        btnTentatives.setBackground(drawable);
        gridLayoutTentatives.addView(btnTentatives);

    }
    @Override
    public void onClick(View v) {

    }
}
