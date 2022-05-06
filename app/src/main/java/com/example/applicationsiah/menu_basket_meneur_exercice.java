package com.example.applicationsiah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu_basket_meneur_exercice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_basket_meneur_exercice);

        Button exo_spe_meneur = (Button) findViewById(R.id.exo_spe_meneur);
        exo_spe_meneur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                visualiser_basket_meneur_spe();
            }


        });
    }

    private void visualiser_basket_meneur_spe() {
        Intent intent5 = new Intent(this,basket_meneur_spe.class);
        startActivity(intent5);
    }
}