package com.example.applicationsiah;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class profil_utilisateur extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_utilisateur);

        TextView text1 = (TextView) findViewById(R.id.nom_utilisateur);
        text1.setText("nom");

        TextView text2 = (TextView) findViewById(R.id.prenom_utilisateur);
        text2.setText("prenom");

        TextView text3 = (TextView) findViewById(R.id.taille_utilisateur);
        text3.setText("taille");

        TextView text4 = (TextView) findViewById(R.id.poids_utilisateur);
        text4.setText("poids");


    }

}