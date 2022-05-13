package com.example.applicationsiah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class menu_hb_ailier extends AppCompatActivity {
    boolean retour=false;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main,menu);

        return true;
        //  retu rn super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.retour) {
            retour = true;
            retour();
        }
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_hb_ailier);
        Button button_tactique_gb = (Button) findViewById((R.id.button_tact_gb));
        button_tactique_gb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_la_tactiquegb();
            }
        });

        Button button_exo_gb = (Button) findViewById((R.id.exo_gb));
        button_exo_gb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_la_exogb();
            }
        });
    }

    private void visualiser_la_exogb() {
        Intent intent2 = new Intent(this, menu_hb_ailier_exo_spe.class);
        startActivity(intent2);
    }

    private void visualiser_la_tactiquegb() {
        Intent intent1 = new Intent(this, menu_hb_ailier_tactique.class);
        startActivity(intent1);
    }
    private void retour() {
        Intent intent60 = new Intent(this, menu_handball.class);
        startActivity(intent60);
    }
    }
