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
        Button button_handball = (Button)  findViewById(R.id.handball_button);
        button_handball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_handball();
            }


        });

    }
    private void visualiser_handball() {
        Intent intent3 = new Intent(this, menu_handball.class);
        startActivity(intent3);
    }
}