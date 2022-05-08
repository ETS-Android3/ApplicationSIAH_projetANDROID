package com.example.applicationsiah;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Random;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Menu_principal extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal); //affiche l'acran
        String tab_conseilsante [] = new String [10] ;
        tab_conseilsante[0]="Buvez de l'eau" ;
        tab_conseilsante[1]="Ilona est gentille";
        tab_conseilsante[2]="Il est minuit 9 je fais encore ça ptn";
        tab_conseilsante[3]="Baptiste a plus d'appendicite lol";
        tab_conseilsante[4]="Et dire qu'on a eu 19.3 en projet innov";
        tab_conseilsante[5]="Allez LE FOOT";
        tab_conseilsante[6]="Scott t'es vrmt un bg (surtout pour un anglais suisse résidant au Crès";
        tab_conseilsante[7]="AXEL FAIS TA PARTIE";
        tab_conseilsante[8]="Je t'aime de ouf je crois que je t'ai dans la peau";
        tab_conseilsante[9]="Entre nous Marion est insupportable quand elle a bu, Scott est marrant, axel est incr mais marion.. ";
        Calendar calendar = Calendar.getInstance(); // on crée un calndrier on récupère la date du jour
        String currentDate = DateFormat.getDateInstance().format(calendar.getTime());
        TextView textViewDate = findViewById(R.id.text_date);
        textViewDate.setText(currentDate);
        TextView text = findViewById(R.id.textView);
        SharedPreferences sharedPreferences = getSharedPreferences("utilisateur", MODE_PRIVATE);
        String prenom = sharedPreferences.getString("util_prenom", " ");
        text.setText("Bienvenu " + prenom);
        TextView text2 = findViewById(R.id.text_feed2);
        int min = 0;
        int max = 9;

        Random random = new Random();

        int value = random.nextInt(max + min) + min;
        text2.setText(tab_conseilsante[value]);


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



    private void visualiser_sports() {
        Intent intent1 = new Intent(this, Menu_sport.class);
        startActivity(intent1);
    }

    private void visualiser_sante_accueil() {
        Intent intent11 = new Intent(this, sante_accueil.class);
        startActivity(intent11);
    }

    private void visualiser_NOUS() {
        Intent intent51 = new Intent(this, a_propos_de_nous.class);
        startActivity(intent51);
    }


    private void visualiser_podo() {
        Intent intent = new Intent(this, session_sport.class);
        startActivity(intent);
    }


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

