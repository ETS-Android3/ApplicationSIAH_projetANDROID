package com.example.applicationsiah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu_handball extends AppCompatActivity {

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
        Intent intent1 = new Intent(this,menu_demi_hb.class);
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
}
