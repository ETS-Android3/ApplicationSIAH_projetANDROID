package com.example.applicationsiah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Exercices_Specifiques_Avants extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercices_specifiques_avants);
        Button button_exo2 = (Button) findViewById(R.id.btn_exo_explosivité);
        Button button_exo3 = (Button) findViewById(R.id.btn_exo_cou);
        Button button_exo4 = (Button) findViewById(R.id.btn_exo_touche);

        button_exo2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                visualiser_exercice_explosivite();
            }



        });

        button_exo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { visualiser_exercice_cou();

            }
        });

        button_exo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { visualiser_exercice_touche();

            }
        });
    }

    private void visualiser_exercice_explosivite() {
        Intent intent1 = new Intent(this,Exercice_explosivite.class);
        startActivity(intent1);
    }

    private void visualiser_exercice_cou() {
        Intent intent2 = new Intent(this,exo_cou.class);
        startActivity(intent2);
    }

    private void visualiser_exercice_touche() {
        Intent intent3 = new Intent(this,exo_touche.class);
        startActivity(intent3);
    }
}