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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class informations_perso extends AppCompatActivity {
    String prenom;
    String nom;
    String taille;
    String poids;
    Boolean connexion1;
    SharedPreferences prefsStockees = null;

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
        prenom = sharedPreferences.getString("util_prenom", " ");

        TextView text = (TextView) findViewById(R.id.textView45);
        ImageView croix1 = (ImageView) findViewById(R.id.croix1);
        croix1.setVisibility(View.INVISIBLE);
        ImageView croix2 = (ImageView) findViewById(R.id.croix2);
        ImageView croix3 = (ImageView) findViewById(R.id.croix3);
        ImageView croix4 = (ImageView) findViewById(R.id.croix4);
        croix3.setVisibility(View.INVISIBLE);
        croix2.setVisibility(View.INVISIBLE);
        croix4.setVisibility(View.INVISIBLE);

        text.setText(prenom);
        Button save = (Button) findViewById(R.id.enregistrer);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //prenom = editprenom.getText().toString();
                //  System.out.println("test:"+editprenom.getText().toString());
                if (editprenom.getText().toString().equals("")) {
                    croix1.setVisibility(View.VISIBLE);
                    System.out.println("test2:" + editprenom.getText().toString());
                    connexion1=false;


                } else {
                    prenom = editprenom.getText().toString();
                    croix1.setVisibility(View.INVISIBLE);

                }
                if(editnom.getText().toString().equals("")){
                    croix2.setVisibility(View.VISIBLE);
                    connexion1=false;
                }else{
                    nom=editnom.getText().toString();
                    croix2.setVisibility(View.INVISIBLE);
                }


                try {
                    poids = editpoids.getText().toString();
                    int b = Integer.parseInt(poids);
                    SharedPreferences sharedPreferences = getSharedPreferences("utilisateur", MODE_PRIVATE);

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    croix3.setVisibility(View.INVISIBLE);

                    editor.putInt("util_poids", b);


                    // Save.
                    editor.apply();

                } catch (NumberFormatException i) {
                    croix3.setVisibility(View.VISIBLE);
                    connexion1=false;
                }
                text.setText(prenom);

                try {
                    taille = edittaille.getText().toString();
                    int a = Integer.parseInt(taille);
                    croix4.setVisibility(View.INVISIBLE);
                    SharedPreferences sharedPreferences = getSharedPreferences("utilisateur", MODE_PRIVATE);

                    SharedPreferences.Editor editor = sharedPreferences.edit();


                    editor.putInt("util_taille", a);


                    // Save.
                    editor.apply();
                    connexion1=true;
                } catch (NumberFormatException e) {
                    // e.printStackTrace();
                    croix4.setVisibility(View.VISIBLE);
                    connexion1=false;
                }
                if(connexion1) {
                    Context context = getApplicationContext();
                    CharSequence text = "Les informations sont saissies";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                if(connexion1==false) {
                    Context context = getApplicationContext();
                    CharSequence text = "Veuillez resaissir les informations";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }


                    SharedPreferences sharedPreferences = getSharedPreferences("utilisateur", MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedPreferences.edit();


                editor.putString("util_prenom", prenom);
                editor.putString("util_nom", nom);

                // Save.
                editor.apply();



            }
        });
    }
}