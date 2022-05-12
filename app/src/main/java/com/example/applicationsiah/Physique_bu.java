package com.example.applicationsiah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Physique_bu extends AppCompatActivity {
    boolean retour=false;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main,menu);

        return true;
        //  retu rn super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.retour) {
            retour = true;
            retour();
        }
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physique_bu);
        ImageView image1 = (ImageView) findViewById(R.id.imageagilite);
        Button agilite = (Button) findViewById(R.id.btn_exo_1);
        ImageView image2 = (ImageView) findViewById(R.id.imageforce);
        image2.setVisibility(View.INVISIBLE);
        TextView text1 = (TextView) findViewById(R.id.textagilite);
        TextView text2 = (TextView) findViewById(R.id.textforce);
        Button force = (Button) findViewById(R.id.btn_exo2);
        text2.setVisibility((View.INVISIBLE));
        ImageView image3 = (ImageView) findViewById(R.id.imagecoordination);
        image3.setVisibility(View.INVISIBLE);
        Button coordination = (Button) findViewById(R.id.btn_exo_3);
        TextView text3 = (TextView) findViewById(R.id.textcoordination);
        text3.setVisibility((View.INVISIBLE));
        force.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image1.setVisibility(View.INVISIBLE);
                image2.setVisibility(View.VISIBLE);
                image3.setVisibility(View.INVISIBLE);

                text1.setVisibility((View.INVISIBLE));
                text2.setVisibility((View.VISIBLE));
                text3.setVisibility((View.INVISIBLE));
            }
        });
        agilite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image1.setVisibility(View.VISIBLE);
                image2.setVisibility(View.INVISIBLE);
                image3.setVisibility(View.INVISIBLE);

                text2.setVisibility((View.INVISIBLE));
                text1.setVisibility((View.VISIBLE));
                text3.setVisibility((View.INVISIBLE));
            }
        });
        coordination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image1.setVisibility(View.INVISIBLE);
                image2.setVisibility(View.INVISIBLE);
                image3.setVisibility(View.VISIBLE);

                text2.setVisibility((View.INVISIBLE));
                text1.setVisibility((View.INVISIBLE));
                text3.setVisibility((View.VISIBLE));
            }
        });
    }
    private void retour() {
        Intent intent60 = new Intent(this, menu_foot_bu.class);
        startActivity(intent60);
    }
}