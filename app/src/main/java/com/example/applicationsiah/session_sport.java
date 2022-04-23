package com.example.applicationsiah;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session_sport);

        tv_steps=(TextView)  findViewById(R.id.tv_steps);
        sensorManager = (SensorManager)  getSystemService(Context.SENSOR_SERVICE);
        podometre = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        debut=true;
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
        if(podometre.isWakeUpSensor()==false){
            tv_steps.setText("peee");
        };
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