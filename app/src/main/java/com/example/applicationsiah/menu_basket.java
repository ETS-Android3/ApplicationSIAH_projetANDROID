package com.example.applicationsiah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu_basket extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_basket);
        Button button_meneur= (Button) findViewById(R.id.button_meneur);
        button_meneur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { visualiser_menu_basket_meneur();

        });

        private void visualiser_menu_basket_meneur(){
            Intent intent1 = new Intent(this, menu_basket_meneur.class);
            startActivity(intent1);
        }

        Button button_aillier = (Button) findViewById(R.id.button_aillier);
        button_aillier.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View view){
                visualiser_menu_basket_aillier();



        });

        private void visualiser_menu_basket_aillier(){
            Intent intent2 = new Intent(this,menu_basket_aillier.class);
            startActivity(intent2);
        }


            Button button_interieur = (Button) findViewById(R.id.button_interieur);
            button_interieur.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick (View view){
                    visualiser_menu_basket_interieur();

                });

                private void visualiser_menu_basket_interieur() {
                    Intent intent3 = new Intent(this,menu_basket_meneur.class);
                    startActivity(intent3);
                }

            }




