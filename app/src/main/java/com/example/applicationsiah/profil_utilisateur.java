package com.example.applicationsiah;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class profil_utilisateur extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main,menu);

        return true;
        //  retu rn super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.retour){
            retour();


        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_utilisateur);
        SharedPreferences sharedPreferences = getSharedPreferences("utilisateur", MODE_PRIVATE);
        String prenom = sharedPreferences.getString("util_prenom", " ");
        String nom = sharedPreferences.getString("util_nom"," ");
        int taille = sharedPreferences.getInt("util_taille",1);
        int poids = sharedPreferences.getInt("util_poids",1);
        TextView text1 = (TextView) findViewById(R.id.nom_util);
        text1.setText("NOM : "  +  nom);

        TextView text2 = (TextView) findViewById(R.id.prenom_util);
        text2.setText("PRENOM : " +prenom);

        TextView text3 = (TextView) findViewById(R.id.util_taille);
        text3.setText("TAILLE : " + String.valueOf(taille)+" cm");

        TextView text4 = (TextView) findViewById(R.id.util_poids);
        text4.setText("POIDS : " + String.valueOf(poids) +" kg");

        Button btn_modif_info = (Button) findViewById(R.id.retour_informations_perso);

        btn_modif_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_informations();
            }
        });

    }

    private void visualiser_informations() {
        Intent intent = new Intent(this,informations_perso.class);
        startActivity(intent);
    }
    private void retour() {
        Intent intent60 = new Intent(this, Menu_principal.class);
        startActivity(intent60);
    }

}