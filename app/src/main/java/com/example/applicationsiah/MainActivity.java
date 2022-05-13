package com.example.applicationsiah;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


Boolean co;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // On récupère les données dans le shared preferences
        SharedPreferences sharedPreferences = getSharedPreferences("utilisateur", MODE_PRIVATE);
        co = sharedPreferences.getBoolean("1_co",false);

        ImageView connexion = findViewById(R.id.imageView60);
        // videoView = (VideoView) findViewById(R.id.video_sport);
        connexion.setVisibility(View.INVISIBLE);

        Button monBouton = (Button)findViewById(R.id.button_demarrer);
        monBouton.setVisibility((View.INVISIBLE));
        if(co==Boolean.TRUE){// 1 ere connexion ou pas ?
            monBouton.setVisibility((View.VISIBLE));
            connexion.setVisibility(View.VISIBLE);
        }
        monBouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_la_suite();
            }
        });
Button conexion1 = (Button) findViewById(R.id.co_1);
conexion1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        visualiser_info();
    }
});


    }

    private void visualiser_info() {
        Intent intent1 = new Intent(this,informations_perso.class);
        startActivity(intent1);
    }

    private void visualiser_la_suite() {
        Intent intent = new Intent(this, Menu_principal.class);
        startActivity(intent);
    }

}