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

public class Exercice_explosivite extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main,menu);
        return true;
        //  retu rn super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.retour) {

            retour();
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice_explosivite);
        ImageView parade_1 = (ImageView) findViewById(R.id.image_squat);
        Button conseil_1 = (Button) findViewById(R.id.btn_exo1_explo);
        ImageView parade_2 = (ImageView) findViewById(R.id.image_sprint);
        parade_2.setVisibility(View.INVISIBLE);
        parade_1.setVisibility(View.INVISIBLE);
        TextView text1 = (TextView) findViewById(R.id.textparade_1);
        TextView text2 = (TextView) findViewById(R.id.textparade_2);
        Button conseil_2 = (Button) findViewById(R.id.btn_exo2_explo);
        text2.setVisibility((View.INVISIBLE));
        conseil_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parade_1.setVisibility(View.INVISIBLE);
                parade_2.setVisibility(View.VISIBLE);

                text1.setVisibility((View.INVISIBLE));
                text2.setVisibility((View.VISIBLE));
            }
        });
        conseil_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parade_1.setVisibility(View.VISIBLE);
                parade_2.setVisibility(View.INVISIBLE);
                text2.setVisibility((View.INVISIBLE));
                text1.setVisibility((View.VISIBLE));
            }
        });
    }
    private void retour() {
        Intent intent60 = new Intent(this, Exercices_Specifiques_Avants.class);
        startActivity(intent60);
    }
}