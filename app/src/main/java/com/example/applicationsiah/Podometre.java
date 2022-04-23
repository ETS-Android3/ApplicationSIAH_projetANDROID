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
Sensor podometre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_podometre);

        tv_steps=(TextView)  findViewById(R.id.tv_steps);
        sensorManager = (SensorManager)  getSystemService(Context.SENSOR_SERVICE);
        podometre = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if(podometre.isWakeUpSensor()==false){
            tv_steps.setText("pute");
        };
    }

    @Override
    protected void onResume() {
        sensorManager.registerListener(this,podometre,SensorManager.SENSOR_DELAY_UI);
        if(podometre.isWakeUpSensor()==false){
            tv_steps.setText("puuu");
            if(podometre.isWakeUpSensor()==true){
                tv_steps.setText("En vrai");
            };
        };
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
        float[] pas;
        if(sensorEvent.sensor.getType()==Sensor.TYPE_STEP_COUNTER){
            pas = sensorEvent.values;
            tv_steps.setText("pas");

        }
        if(podometre.isWakeUpSensor()==false){
            tv_steps.setText("changement");
        };
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}