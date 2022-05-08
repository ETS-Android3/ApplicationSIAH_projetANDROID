package com.example.applicationsiah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class menu_basket_interieur extends AppCompatActivity {
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
    private void retour() {
        Intent intent60 = new Intent(this, menu_basket.class);
        startActivity(intent60);
    }
}