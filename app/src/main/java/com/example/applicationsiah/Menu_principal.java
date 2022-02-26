package com.example.applicationsiah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import java.text.DateFormat;
import java.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class Menu_principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal); //affiche l'acran
        Calendar calendar = Calendar.getInstance(); // on crée un calndrier on récupère la date du jour
        String currentDate = DateFormat.getDateInstance().format(calendar.getTime());
        TextView textViewDate = findViewById(R.id.text_date);
        textViewDate.setText(currentDate);

        Button boutton_podo = (Button) findViewById(R.id.acces_podometre);
        boutton_podo.setText("Validez");
        boutton_podo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_podo();
            }
        });

        ImageButton button_sports = (ImageButton) findViewById(R.id.sport_buttton);
        button_sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_sports();
            }
        });

        }




private void visualiser_sports(){
        Intent intent1 = new Intent(this, Menu_sport.class);
        startActivity(intent1);
}




    private void visualiser_podo() {
        Intent intent = new Intent(this, Podometre.class);
        startActivity(intent);
    }
 /*/
        // 1) creation d’un objet-reference spinner vers le spinner de l’activite
        Spinner monSpinner = (Spinner) findViewById(R.id.menu_sports);
        // 2) creation d’un ArrayAdapter à partir de tab_pokemon et mise en forme par defaut
        ArrayAdapter<CharSequence> monAdapter = ArrayAdapter.createFromResource (this,
                R.array.tab_sports, android.R.layout.simple_spinner_item);
        // 3) définition de la mise en page
        monAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // 4) Association de adapter au spinner
        monSpinner.setAdapter(monAdapter);
    }
    /*/

}