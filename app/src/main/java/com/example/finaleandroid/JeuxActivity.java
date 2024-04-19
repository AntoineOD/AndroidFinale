package com.example.finaleandroid;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class JeuxActivity extends AppCompatActivity implements View.OnClickListener{
    int row;
    int column;
    LinearLayout layoutFeedback;
    Drawable dice;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeux);

        androidx.gridlayout.widget.GridLayout gridLayoutTentatives = findViewById(R.id.gridLayoutTentatives);
        row=10;
        column=4;
        gridLayoutTentatives.setRowCount(row);
        gridLayoutTentatives.setColumnCount(column);
        for(int i = 0; i < row * column; i++) {
            Drawable drawable = getResources().getDrawable(R.drawable.ovale);
            Button btnTentatives = new Button(this);
            btnTentatives.setBackground(drawable);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = 100;
            params.height = 100;
            params.setMargins(5,10,5,10);
            btnTentatives.setLayoutParams(params);
            gridLayoutTentatives.addView(btnTentatives);
        }
        androidx.gridlayout.widget.GridLayout gridLayoutPalette = findViewById(R.id.layoutPalette);
        gridLayoutPalette.setRowCount(4);
        gridLayoutPalette.setColumnCount(2);
        for(int i=0; i<8; i++){
            Button btnPalette = new Button(this);
            btnPalette.setBackgroundColor(0xffff0000);
            //Couleur a modifier avec le JSON
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = 100;
            params.height = 100;
            params.setMargins(5,10,5,10);
            btnPalette.setLayoutParams(params);
            gridLayoutPalette.addView(btnPalette);
        }
        layoutFeedback = findViewById(R.id.layoutReponses);
        if(column == 4){
            this.dice = getResources().getDrawable(R.drawable.dice4);
        }
        if(column == 5){
            //Shape 5
        }
        if(column == 6){
            //Shape 6
        }
        for(int i = 0; i<row; i++){
            ImageView imgDice = new ImageView(this);
            imgDice.setImageDrawable(dice);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(100,100);
            layoutParams.setMargins(5,10,5,10);
            imgDice.setLayoutParams(layoutParams);
            layoutFeedback.addView(imgDice);
        }
    }
    @Override
    public void onClick(View v) {

    }
}
