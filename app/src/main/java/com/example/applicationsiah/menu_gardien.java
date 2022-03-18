package com.example.applicationsiah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu_gardien extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_gardien);
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
        Intent intent2 = new Intent(this, menu_exo_gb.class);
        startActivity(intent2);
    }

    private void visualiser_la_tactiquegb() {
        Intent intent1 = new Intent(this, menu_tactique_gb.class);
        startActivity(intent1);
    }
}