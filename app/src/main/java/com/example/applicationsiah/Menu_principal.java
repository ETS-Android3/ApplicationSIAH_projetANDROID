package com.example.applicationsiah;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import java.text.DateFormat;
import java.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
        TextView text = findViewById(R.id.textView);
        SharedPreferences sharedPreferences = getSharedPreferences("utilisateur", MODE_PRIVATE);
        String prenom = sharedPreferences.getString("util_prenom"," ");
        text.setText("Bienvenu " + prenom);
        Button boutton_podo = (Button) findViewById(R.id.acces_podometre);

        boutton_podo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_podo();
            }
        });

        Button button_sports = (Button) findViewById(R.id.sport_buttton);
        button_sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_sports();
            }
        });

        Button button_NOUS = (Button) findViewById(R.id.nous);
        button_NOUS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_NOUS();
            }
        });
        Button btn_health = (Button) findViewById(R.id.btn_health);
        btn_health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_sante_accueil();
            }
        });

        }




private void visualiser_sports(){
        Intent intent1 = new Intent(this, Menu_sport.class);
        startActivity(intent1);
}
    private void visualiser_sante_accueil(){
        Intent intent11 = new Intent(this, sante_accueil.class);
        startActivity(intent11);
    }
    private void visualiser_NOUS(){
        Intent intent51 = new Intent(this,a_propos_de_nous.class);
        startActivity(intent51);
    }



    private void visualiser_podo() {
        Intent intent = new Intent(this, session_sport.class);
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