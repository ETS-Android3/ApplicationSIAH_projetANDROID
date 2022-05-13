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

public class menu_hb_ailier_tactique extends AppCompatActivity {
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
        setContentView(R.layout.activity_menu_hb_ailier_tactique);
        ImageView image1 = (ImageView) findViewById(R.id.imagetiraile);
        Button conseil1 = (Button) findViewById(R.id.btn_exo_1);
        ImageView image2 = (ImageView) findViewById(R.id.imageView64);
        image2.setVisibility(View.INVISIBLE);
        TextView text1 = (TextView) findViewById(R.id.textparade_1);
        TextView text2 = (TextView) findViewById(R.id.textparade_2);
        Button conseil2 = (Button) findViewById(R.id.btn_exo2);
        text2.setVisibility((View.INVISIBLE));

        conseil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image1.setVisibility(View.INVISIBLE);
                image2.setVisibility(View.VISIBLE);

                text1.setVisibility((View.INVISIBLE));
                text2.setVisibility((View.VISIBLE));
            }
        });
        conseil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image1.setVisibility(View.VISIBLE);
                image2.setVisibility(View.INVISIBLE);

                text2.setVisibility((View.INVISIBLE));
                text1.setVisibility((View.VISIBLE));
            }
        });
    }
    private void retour() {
        Intent intent60 = new Intent(this, menu_hb_ailier.class);
        startActivity(intent60);
    }
}