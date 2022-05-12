package com.example.applicationsiah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu_foot_ad_ag extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_foot_ad_ag);
        Button physique = (Button) findViewById((R.id.physique));
        physique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {visualiser_physique_ag_ad();}
        });
    }

        private void visualiser_physique_ag_ad() {
            Intent intent2 = new Intent(this, Physique_ag_ad.class);
            startActivity(intent2);
        }
}