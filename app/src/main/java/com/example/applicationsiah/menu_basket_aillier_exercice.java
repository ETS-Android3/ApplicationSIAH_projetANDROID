package com.example.applicationsiah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu_basket_aillier_exercice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_basket_aillier_exercice);

        Button exo_spe_aillier = (Button) findViewById(R.id.exo_spe_meneur);
        exo_spe_aillier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                visualiser_basket_aillier_spexo();
            }


        });
    }

    private void visualiser_basket_aillier_spexo() {
        Intent intent3 = new Intent(this,basket_aillier_spexo.class);
        startActivity(intent3);
    }

}