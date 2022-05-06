package com.example.applicationsiah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu_basket_interieur extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_basket_interieur);
        Button btn_exo_interieur = (Button) findViewById(R.id.btn_exo_meneur);
        btn_exo_interieur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                visualiser_menu_basket_interieur_exercice();
            }


        });
    }
    private void visualiser_menu_basket_interieur_exercice() {
        Intent intent5 = new Intent(this,menu_basket_interieur_exercice.class);
        startActivity(intent5);
    }
}