package com.example.applicationsiah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu_basket_aillier extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_basket_aillier);
        // coucou hugo
        Button button_aillier = (Button) findViewById(R.id.btn_exo_aillier);
        button_aillier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                visualiser_menu_basket_aillier_exercice();
            }


        });
    }
    private void visualiser_menu_basket_aillier_exercice() {
        Intent intent3 = new Intent(this,menu_basket_aillier.class);
        startActivity(intent3);
    }



}