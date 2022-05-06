package com.example.applicationsiah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu_sport extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_sport);
        Button button_rugby = (Button) findViewById(R.id.rugby_menu);
        button_rugby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_rugby();
            }


        });
        Button button_handball = (Button)  findViewById(R.id.handball_button);
        button_handball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_handball();
            }


        });


        Button button_football = (Button)  findViewById(R.id.football_menu);
        button_football.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_football();
            }


        });
        Button button_basketball = (Button)  findViewById(R.id.basketball_menu);
        button_basketball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_basket();
            }


        });

        Button button_recuperation = (Button) findViewById(R.id.btn_recup);
        button_recuperation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_recuperation();
            }
        });
    }

    private void visualiser_rugby() {
        Intent intent4 = new Intent(this, menu_rugby.class);
        startActivity(intent4);
    }

    private void visualiser_handball() {
        Intent intent3 = new Intent(this, menu_handball.class);
        startActivity(intent3);
    }

    private void visualiser_football() {
        Intent intent5 = new Intent(this, menu_foot.class);
        startActivity(intent5);
    }

    private void visualiser_basket() {
        Intent intent6 = new Intent(this, menu_basket.class);
        startActivity(intent6);
    }
    private void visualiser_recuperation() {
        Intent intent69 = new Intent(this, recuperation.class);
        startActivity(intent69);
    }
}