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

public class session_sport extends AppCompatActivity implements SensorEventListener {
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
    SensorManager sensorManager;
    TextView tv_steps;
    boolean running = false;
    Sensor podometre;
    Sensor accelerometre;
    float pas;
    float pas_capteur;
    float variation_pas;
    boolean debut;
    TextView chronometre;
    Button lancer,pause;
    Runnable runnable;
    int seconde, minute;
    boolean cliquer,stop,annuler;
    boolean relancer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session_sport);

        tv_steps=(TextView)  findViewById(R.id.tv_steps);
        ImageView cercle = (ImageView) findViewById(R.id.imageView21);
        cercle.setVisibility(View.INVISIBLE);
        tv_steps.setVisibility(View.INVISIBLE);
        sensorManager = (SensorManager)  getSystemService(Context.SENSOR_SERVICE);
        podometre = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        debut=true;
        chronometre = (TextView) findViewById(R.id.Chrono);
        lancer = (Button) findViewById(R.id.lancer);
        pause = (Button) findViewById(R.id.pause);
        pause.setVisibility(View.INVISIBLE);
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
                    tv_steps.setVisibility(View.VISIBLE);
                }
                else{
                    annuler = true;
                    pas= 0;
                    lancer.setText("Lancer");
                    pause.setVisibility(View.INVISIBLE);
                    cliquer=false;
                    cercle.setVisibility(View.INVISIBLE);
                    tv_steps.setVisibility(View.INVISIBLE);


                    debut=true;


                }
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
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
        running=true;

        super.onResume();
    }

    @Override
    protected void onPause() {

        //running=false;
        sensorManager.unregisterListener(this, podometre);

        super.onPause();
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        if(sensorEvent.sensor.getType()==Sensor.TYPE_STEP_COUNTER){
            if(stop ==true){
                variation_pas = sensorEvent.values[0]-pas_capteur-pas;
                TextView textess = findViewById(R.id.textView76);
                textess.setText(String.valueOf(variation_pas));
            }
            if(debut==true){
                pas_capteur=sensorEvent.values[0];

                debut=false;
            }
            if(stop==false && annuler == false) {
                pas = sensorEvent.values[0] - pas_capteur - variation_pas  ;
                variation_pas=0;
                tv_steps.setText(String.valueOf(pas));
            }


        }

    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
    private void retour() {
        Intent intent60 = new Intent(this, Menu_principal.class);
        startActivity(intent60);
    }
}