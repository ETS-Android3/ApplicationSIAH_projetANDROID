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
    }



    private void visualiser_menu_demi() {
        Intent intent1 = new Intent(this,menu_demi_hb.class);
        startActivity(intent1);
    }

    private void visualiser_menu_gardien() {
        Intent intent = new Intent(this,menu_gardien.class);
        startActivity(intent);
    }
}
