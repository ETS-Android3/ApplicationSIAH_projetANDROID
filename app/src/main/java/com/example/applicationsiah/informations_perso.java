package com.example.applicationsiah;

import static android.widget.Toast.makeText;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class informations_perso extends AppCompatActivity {
    String prenom;
    String nom;
    String taille;
    String poids;
    SharedPreferences prefsStockees = null ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informations_perso);
        EditText editprenom;
        editprenom = (EditText) findViewById(R.id.prenom);
        EditText editnom = (EditText) findViewById(R.id.nom);
        EditText edittaille = (EditText) findViewById(R.id.taille);
        EditText editpoids = (EditText) findViewById(R.id.poids);
        SharedPreferences sharedPreferences = getSharedPreferences("utilisateur", MODE_PRIVATE);
        prenom = sharedPreferences.getString("util_prenom"," ");

        TextView text = (TextView) findViewById(R.id.textView45);
        text.setText(prenom);
        Button save = (Button)  findViewById(R.id.enregistrer);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                prenom = editprenom.getText().toString();
                nom = editnom.getText().toString();
                taille = edittaille.getText().toString();
                poids = editpoids.getText().toString();
                text.setText(prenom);

                SharedPreferences sharedPreferences= getSharedPreferences("utilisateur", MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedPreferences.edit();





                editor.putString("util_prenom", prenom);

                // Save.
                editor.apply();

             
            }
        });
    }
}