package com.example.applicationsiah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu_basket_interieur_exercice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_basket_interieur_exercice);
        Button exo_spe_interieur = (Button) findViewById(R.id.exo_spe_meneur);
        exo_spe_interieur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                visualiser_basket_interieur_spe();
            }


        });
    }

    private void visualiser_basket_interieur_spe() {
        Intent intent5 = new Intent(this,basket_interieur_spe.class);
        startActivity(intent5);
    }
}