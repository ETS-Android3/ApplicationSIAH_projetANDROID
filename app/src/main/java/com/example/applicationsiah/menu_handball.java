package com.example.applicationsiah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class menu_handball extends AppCompatActivity {
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
        setContentView(R.layout.activity_menu_handball);
        Button button_gardien = (Button) findViewById(R.id.button_gardien);
        button_gardien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_menu_gardien();
            }


        });
        Button button_demicentre = (Button) findViewById(R.id.button_demi);
        button_demicentre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_menu_demi();
            }


        });


        Button button_arriere = (Button) findViewById(R.id.button_arriere);
        button_arriere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_menu_hb_arriere();
            }


        });
        Button btn_hb_ailier = (Button) findViewById(R.id.btn_hb_ailier);
        btn_hb_ailier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_menu_hb_ailier();
            }


        });
    }



    private void visualiser_menu_demi() {
        Intent intent1 = new Intent(this,menu_hb_demi.class);
        startActivity(intent1);
    }

    private void visualiser_menu_gardien() {
        Intent intent = new Intent(this,menu_gardien.class);
        startActivity(intent);
    }
    private void visualiser_menu_hb_ailier() {
        Intent intent1 = new Intent(this,menu_hb_ailier.class);
        startActivity(intent1);
    }
    private void visualiser_menu_hb_arriere() {
        Intent intent1 = new Intent(this,menu_hb_arriere.class);
        startActivity(intent1);
    }
    private void retour() {
        Intent intent60 = new Intent(this, Menu_sport.class);
        startActivity(intent60);
    }
}
