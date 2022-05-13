package com.example.applicationsiah;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

public class Menu_principal extends AppCompatActivity implements SensorEventListener {
    Sensor podometre;
    SensorManager sensorManager;
    float pas_ajd;
    TextView text_vitesse;
    ArrayList<Course> listesCourse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_menu_principal); //affiche l'acran
        text_vitesse= findViewById(R.id.text_feed6);

        // Table conseillant avec les conseils santé
        String tab_conseilsante[] = new String[7];
        tab_conseilsante[0] = "Buvez de l'eau lors de vos pauses sans couper la respiration";
        tab_conseilsante[1] = "Etirez-vous à la fin de chaque entraînement ";
        tab_conseilsante[2] = "Priviligiez les féculents avant une séance de sport";
        tab_conseilsante[3] = "Echauffez-vous bien avant une activité physique";
        tab_conseilsante[4] = "Travaillez votre cardio et lancez une activité sportive sur SIAHapp ! ";
        tab_conseilsante[5] = "Consultez votre IMC dans l'onglet santé !";
        tab_conseilsante[6] = "Pensez à faire des exercices de récupérations";

        Calendar calendar = Calendar.getInstance(); // on crée un calndrier on récupère la date du jour
        String currentDate = DateFormat.getDateInstance().format(calendar.getTime());
        //Initialisation des textView via leur identifiant
        TextView textViewDate = findViewById(R.id.text_date);
        textViewDate.setText(currentDate);
        TextView text = findViewById(R.id.textView);
        //On récupère le prénom de l'utilisateur avec les ahared preferences
        SharedPreferences sharedPreferences = getSharedPreferences("utilisateur", MODE_PRIVATE);
        String prenom = sharedPreferences.getString("util_prenom", " ");
        TextView text_pas = findViewById(R.id.text_feed4);
        Float pas;
        // On initialise les capteurs
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        podometre = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        SharedPreferences sharedPreferences1= getSharedPreferences("course", MODE_PRIVATE);


            Gson gson = new Gson(); // on crée un gestionnaire de format json
            // on extrait la liste referencée  dans les
            // préférences partagées
            String listeCourseTxtJson = sharedPreferences1.getString("cle_course", "");
            // desormais dans listeCoursesTxtJson on a tous nos courses stockées dans un format json
            // on reconstruit un tableau d'objets de type Course grace à al liste au format json
            if (listeCourseTxtJson.equals("")) {
                listesCourse = new ArrayList<Course>();
            } else {
                Course[] tableauCoursesTemporaire = gson.fromJson(listeCourseTxtJson, Course[].class);
                // reconstitution d'une arrayList a partir du tableau
                listesCourse = new ArrayList<Course>(Arrays.asList(tableauCoursesTemporaire));
            }



        try {
            text_pas.setText(String.valueOf(Math.round(listesCourse.get(listesCourse.size()-1).km))+" pas");
            text_vitesse.setText((String.valueOf(Math.round(listesCourse.get(listesCourse.size()-1).km/listesCourse.get(listesCourse.size()-1).duree)))+" m/s");
        }catch(Exception a){
            text_pas.setText("Pas de course");
            text_vitesse.setText("Pas de course");
        }
        text.setText("Bienvenue " + prenom);
        TextView text2 = findViewById(R.id.text_feed2);

        // Tirage d'un nombre aléatoire
        int min = 0;
        int max = 6;

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

        Button btn_profil = (Button) findViewById(R.id.btn_profil);
        btn_profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_profil();
            }
        });

    }

    private void visualiser_profil() {
        Intent intent3 = new Intent(this, profil_utilisateur.class);
        startActivity(intent3);
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


    @Override
    protected void onResume() {
        sensorManager.registerListener((SensorEventListener) this, podometre, SensorManager.SENSOR_DELAY_UI);


        super.onResume();
    }

    @Override
    protected void onPause() {

        //running=false;
        sensorManager.unregisterListener((SensorEventListener) this, podometre);

        super.onPause();
    }


    public void onSensorChanged(SensorEvent sensorEvent) {

        if (sensorEvent.sensor.getType() == Sensor.TYPE_STEP_COUNTER) {

            pas_ajd = sensorEvent.values[0];
           // text_pas_ajd.setText(String.valueOf(pas_ajd));


        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

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

