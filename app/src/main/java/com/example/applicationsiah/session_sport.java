package com.example.applicationsiah;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;

public class session_sport extends AppCompatActivity implements SensorEventListener {

    //Partie pour le boutton retour sur la barre d'actvité
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main,menu);

        return true;
        //  retu rn super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.retour){
            retour();


        }
        return true;
    }

    // Initialisation des variables et objets
    SensorManager sensorManager;


    Sensor podometre;// initialisation du capteur podomètre
    TextView nbpas;
    Float pas;
    Float pas_capteur;
    float variation_pas;
    boolean debut;
    TextView chronometre;
    Button lancer,pause;
    Runnable runnable;
    int seconde, minute;
    boolean cliquer,stop,annuler;


    ArrayList<Course> histo_course;//liste qui stocke l'ensemble des

    TextView distance;
    @Override
    protected void onCreate(Bundle savedInstanceState) { // méthode qui crée l'interface visuelle
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session_sport);

        //tv_steps=(TextView)  findViewById(R.id.tv_steps);
        ImageView cercle = (ImageView) findViewById(R.id.imageView21);
        cercle.setVisibility(View.INVISIBLE);
        //tv_steps.setVisibility(View.INVISIBLE);
        distance = findViewById(R.id.distance); // On attribue les différents textView avec leur identifiant
        distance.setVisibility(View.INVISIBLE);// on rend le textView invisible
        sensorManager = (SensorManager)  getSystemService(Context.SENSOR_SERVICE);// on récupère
        podometre = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        debut=true;// Variable qui indique le lancement du podomètre
        chronometre = (TextView) findViewById(R.id.Chrono);
        lancer = (Button) findViewById(R.id.lancer);
        pause = (Button) findViewById(R.id.pause);
        pause.setVisibility(View.INVISIBLE);
        nbpas = findViewById(R.id.nb_pas);
        nbpas.setVisibility(View.INVISIBLE);

        TextView distance_parcou = findViewById(R.id.nb_pas2);
        distance_parcou.setVisibility(View.INVISIBLE);
        // Runnable qui permet d'effectuer un chronomètre
        runnable = new Runnable() {
            @Override
            public void run() {
                seconde +=1;
                if(seconde==60){
                    minute+=1;
                    seconde=00;
                }
                if(annuler==false){
                    if(stop==false){
                        new Handler().postDelayed(runnable,1000);
                    }

                }else{
                    seconde=0;
                    minute=0;
                }
                chronometre.setText("Durée : "+minute+" minutes "+seconde+" secondes ");

            }
        };
        lancer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cliquer==false){
                    new Handler().postDelayed(runnable,100);//lance le runnable cahque sec 1000=1seconde
                    stop=false;
                    annuler=false;
                    pause.setVisibility(View.VISIBLE);
                    lancer.setText("Annuler");
                    cliquer=true;
                    seconde=0;
                    minute=0;
                    cercle.setVisibility(View.VISIBLE);
                    //tv_steps.setVisibility(View.VISIBLE);
                    distance_parcou.setVisibility(View.VISIBLE);
                    distance.setVisibility(View.VISIBLE);
                    nbpas.setVisibility(View.VISIBLE);
                }
                else{
                    annuler = true; // arrêt du podomètre

                    lancer.setText("Lancer");
                    pause.setVisibility(View.INVISIBLE);
                    cliquer=false;
                    cercle.setVisibility(View.INVISIBLE);
                    distance_parcou.setVisibility(View.INVISIBLE);
                    distance.setVisibility(View.INVISIBLE);
                    nbpas.setVisibility(View.INVISIBLE);
                  //  tv_steps.setVisibility(View.INVISIBLE);

                    /** chargement de l'historique des courses **/
                    // on récupère les préférences stockées sous la clé course :
                    SharedPreferences prefsStockees = getSharedPreferences("course", MODE_PRIVATE);
                    Gson gson = new Gson(); // on crée un gestionnaire de format json
                    // on extrait la liste referencée par le mot cle_course qu'on avait stocké dans les
                    // préférences partagées

                    String listeCourseTxtJson = prefsStockees.getString("cle_course", "");

                    // desormais dans listeEtudiantsTxtJson on a tous nos etudiants stockés dans un format json
                    // on reconstruit un tableau d'objets de type Course grace à la liste au format json

                    if (listeCourseTxtJson.equals("")) {//si elle est vide on la créé
                         histo_course= new ArrayList<>();
                    }
                    else {
                        Course[] tableauCoursesTemporaire = gson.fromJson(listeCourseTxtJson, Course[].class);
                        // reconstitution d'une arrayList a partir du tableau tableauCourseTemporaire
                        histo_course = new ArrayList<Course>(Arrays.asList(tableauCoursesTemporaire));
                    }

                    Course course = null;
                    //Forme try catch pour gérer les éventuels erreurs
                    try{
                         course = new Course(minute*60+seconde,pas);//On crée l'objet
                        Context context = getApplicationContext();
                        CharSequence text = "Les données sur la course ont été enregistrées";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                    catch(Exception fzf){
                        Context context = getApplicationContext();
                        CharSequence text = "Les données sur la course n'ont pas été enregistrées";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }

                    try {

                        histo_course.add(course);
                    }
                    catch (Exception e){
                        System.out.println("Erreur ajout");
                    }

                    SharedPreferences sharedPreferences1 = getSharedPreferences("course", MODE_PRIVATE);

                    SharedPreferences.Editor editor= sharedPreferences1.edit();
                    // on transforme la liste d'étudiant en format json :
                    String histo_courseEnJson = gson.toJson(histo_course);
                    // on envoie la liste (json) dans la clé cle_listeEtudiants de mesPrefs :
                    editor.putString("cle_course", histo_courseEnJson);
                    editor.commit(); // on enregistre les préférences
                    Integer a =new Integer(0);
                    pas = a.floatValue();
                    System.out.println(String.valueOf(pas.floatValue()));
                    variation_pas=0;


                    debut=true;


                }
            }
        });
        pause.setOnClickListener(new View.OnClickListener() { // gestion du boutton pause
            @Override
            public void onClick(View view) {
                if(stop==false){
                    stop=true;
                    pause.setText("Play");
                   // debut=true;
                }else{
                    stop=false;
                    pause.setText("Pause");
                    new Handler().postDelayed(runnable,1000);//lance le runnable cahque sec 1000=1seconde
                }
            }
        });
    }

    @Override
    protected void onResume() {
        sensorManager.registerListener(this,podometre,SensorManager.SENSOR_DELAY_UI);


        super.onResume();
    }

    @Override
    protected void onPause() {

        //running=false;
        sensorManager.unregisterListener(this, podometre);

        super.onPause();
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) { //
        boolean reprise =false ;
        if(sensorEvent.sensor.getType()==Sensor.TYPE_STEP_COUNTER){ // on s'intéresse seulement des données de type step counter
            if(stop ==true){
                variation_pas = sensorEvent.values[0]-pas_capteur-pas;// si l'utilisateur met stop le compteur s'arrête
                // variation pas correspond au pas effectué durant la pause
                reprise=true;
            }
            if(debut==true){
                pas_capteur=sensorEvent.values[0];// on récupère les pas déjà enregistés par le capteur

                debut=false;// on indique que le premier lancement est déjà effectué
            }
            if(stop==false && annuler == false) {
                pas = sensorEvent.values[0] - pas_capteur   ;// nombre de pas fais lors de l'activité
                if(reprise=true){
                    pas = pas - variation_pas;

                    reprise=false;
                }
                distance.setText(String.valueOf(Math.round(pas*0.64))+" m");// conversion en nombre de pas en mètre
                nbpas.setText("Nombre de pas : "+String.valueOf(Math.round(pas)));
            }


        }

    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
    //méthode pour revenir au menu précédent
    private void retour() {
        Intent intent60 = new Intent(this, Menu_principal.class);
        startActivity(intent60);
    }
}