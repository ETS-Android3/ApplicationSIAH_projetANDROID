package com.example.applicationsiah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu_rugby extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_rugby);
        Button button_avant = (Button) findViewById(R.id.button_avant);
        button_avant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_interface_conseil_sportif();
            }


        });

    }

    private void visualiser_interface_conseil_sportif() {
        Intent intent = new Intent(this,interface_conseil_sportif.class);
        startActivity(intent); //test
    }

}