package com.example.applicationsiah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu_rugby extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_rugby);
        Button button_9 = (Button) findViewById(R.id.button_10);
        button_9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                visualiser_exercices_specifiques_arrieres();
            }


        });

        Button button_dix = (Button) findViewById(R.id.button_dix);
        button_dix.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                visualiser_exercices_specifiques_arrieres();
            }


        });
        Button button_11 = (Button) findViewById(R.id.button_11);
        button_11.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                visualiser_exercices_specifiques_arrieres();
            }


        });
        Button button_12 = (Button) findViewById(R.id.button_12);
        button_12.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                visualiser_exercices_specifiques_arrieres();
            }


        });
        Button button_13 = (Button) findViewById(R.id.button_13);
        button_13.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                visualiser_exercices_specifiques_arrieres();
            }


        });
        Button button_14 = (Button) findViewById(R.id.button_14);
        button_14.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                visualiser_exercices_specifiques_arrieres();
            }


        });
        Button button_15 = (Button) findViewById(R.id.button_15);
        button_15.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                visualiser_exercices_specifiques_arrieres();
            }


        });
        //gestion boutons du pack
        Button button_1ligne = (Button) findViewById(R.id.button_1ligne);
        button_1ligne.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                visualiser_exercices_specifiques_avants();
            }


        });
        Button button_2ligne = (Button) findViewById(R.id.button_2ligne);
        button_2ligne.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                visualiser_exercices_specifiques_avants();
            }


        });
        Button button_3ligne = (Button) findViewById(R.id.button_3ligne);
        button_3ligne.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                visualiser_exercices_specifiques_avants();
            }


        });

    }

    private void visualiser_exercices_specifiques_arrieres() {
        Intent intent = new Intent(this,exercices_specifiques_arrieres.class);
        startActivity(intent); //test
    }
    private void visualiser_exercices_specifiques_avants() {
        Intent intent = new Intent(this,Exercices_Specifiques_Avants.class);
        startActivity(intent); //test
    }


}