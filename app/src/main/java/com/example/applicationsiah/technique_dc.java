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

public class technique_dc extends AppCompatActivity {
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
        setContentView(R.layout.activity_technique_dc);
        ImageView image1 = (ImageView) findViewById(R.id.imagetete);
        Button tete = (Button) findViewById(R.id.btn_exo_1);
        ImageView image2 = (ImageView) findViewById(R.id.imageconduite);
        image2.setVisibility(View.INVISIBLE);
        TextView text1 = (TextView) findViewById(R.id.texttete);
        TextView text2 = (TextView) findViewById(R.id.textconduite);
        Button conduite = (Button) findViewById(R.id.btn_exo2);
        text2.setVisibility((View.INVISIBLE));
        ImageView image3 = (ImageView) findViewById(R.id.imagepasse);
        image3.setVisibility(View.INVISIBLE);
        Button passe = (Button) findViewById(R.id.btn_exo_3);
        TextView text3 = (TextView) findViewById(R.id.textpasse);
        text3.setVisibility((View.INVISIBLE));
        conduite.setOnClickListener(new View.OnClickListener() {
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
        tete.setOnClickListener(new View.OnClickListener() {
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
        passe.setOnClickListener(new View.OnClickListener() {
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
        Intent intent60 = new Intent(this, menu_foot_dc.class);
        startActivity(intent60);
    }
}