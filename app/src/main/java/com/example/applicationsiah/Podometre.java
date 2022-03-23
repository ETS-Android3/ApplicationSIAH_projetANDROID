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

public class Podometre extends AppCompatActivity implements SensorEventListener {
SensorManager sensorManager;
TextView tv_steps;
boolean running = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_podometre);
        System.out.print("Ici1");
        tv_steps=(TextView)  findViewById(R.id.tv_steps);
        sensorManager = (SensorManager)  getSystemService(Context.SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        running=true;
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if(countSensor !=null) {
            sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_UI);
            System.out.print("Ici");
        }
        else {
            Toast.makeText(this, "pas trouvé", Toast.LENGTH_SHORT).show();
        }

        }

    @Override
    protected void onPause() {
        super.onPause();
        running=false;
        sensorManager.unregisterListener(this);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
    if(running){
        tv_steps.setText(String.valueOf(sensorEvent.values[0]));
    }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}