package com.example.applicationsiah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class exercices_specifiques_arrieres extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main,menu);
        return true;
        //  retu rn super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.retour) {

            retour();
        }
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercices_specifiques_arrieres);

        Button button_exoA = (Button) findViewById(R.id.button_running);
        Button button_exoB = (Button) findViewById(R.id.button_2v1);
        Button button_exoC = (Button) findViewById(R.id.button_tackle);



        button_exoA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_exercice_running();

            }
        });

        button_exoB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_exercice_2V1();

            }
        });

        button_exoC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_exercice_plaquage();

            }
        });
    }

    private void visualiser_exercice_running() {
        Intent intentA = new Intent(this,exo_running.class);
        startActivity(intentA);
    }

    private void visualiser_exercice_2V1() {
        Intent intentB = new Intent(this,exo_2V1.class);
        startActivity(intentB);
    }

    private void visualiser_exercice_plaquage() {
        Intent intentC = new Intent(this,exo_plaquage.class);
        startActivity(intentC);
    }
    private void retour() {
        Intent intent60 = new Intent(this, menu_rugby.class);
        startActivity(intent60);
    }
}
