package com.example.applicationsiah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button monBouton = (Button)findViewById(R.id.button_demarrer);
        monBouton.setText("Validez");
        monBouton.setOnClickListener(new View.OnClickListener());

    }
    private void visualiser_la_suite()
    {
        Intent intent = new Intent(this, Menu_principal.class);
        startActivity(intent);
        public void onClick(View view) {
        visualiser_la_suite();
    }
    }
}