package com.example.applicationsiah;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class session_sport extends AppCompatActivity implements SensorEventListener {
    SensorManager sensorManager;
    TextView tv_steps;
    boolean running = false;
    Sensor podometre;
    Sensor accelerometre;
    float pas;
    float pas_capteur;
    boolean debut;
    TextView chronometre;
    Button lancer,pause;
    Runnable runnable;
    int seconde, minute;
    boolean cliquer,stop,annuler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session_sport);

        tv_steps=(TextView)  findViewById(R.id.tv_steps);
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
                }
                else{
                    annuler = true;
                    lancer.setText("Lancer");
                    pause.setVisibility(View.INVISIBLE);
                    cliquer=false;

                }
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(stop==false){
                    stop=true;
                    pause.setText("Play");
                }else{
                    stop=false;
                    pause.setText("PAuse");
                    new Handler().postDelayed(runnable,1000);//lance le runnable cahque sec 1000=1seconde
                }
            }
        });
    }

    @Override
    protected void onResume() {
        sensorManager.registerListener(this,podometre,SensorManager.SENSOR_DELAY_UI);
        running=true;


        //   Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        //  if(countSensor !=null) {
        //    sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_UI);
        //  System.out.print("Ici");
        //}
        //else {
        //  Toast.makeText(this, "pas trouvé", Toast.LENGTH_SHORT).show();
        //}

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
            if(debut==true){
                pas_capteur=sensorEvent.values[0];
                debut=false;
            }
            pas = sensorEvent.values[0]-pas_capteur;
            tv_steps.setText(String.valueOf(pas));

        }

    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}