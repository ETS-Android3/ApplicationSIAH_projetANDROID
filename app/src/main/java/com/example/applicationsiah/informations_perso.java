package com.example.applicationsiah;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class informations_perso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informations_perso);
        EditText editprenom;
        editprenom = (EditText) findViewById(R.id.prenom);
        Editable prenom;
        prenom = editprenom.getText();
        TextView text = (TextView) findViewById(R.id.textView45);

        Button save = (Button)  findViewById(R.id.enregistrer);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                text.setText(prenom);
            }
        });
    }
}