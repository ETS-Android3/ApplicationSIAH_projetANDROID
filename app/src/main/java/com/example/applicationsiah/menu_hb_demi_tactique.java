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

public class menu_hb_demi_tactique extends AppCompatActivity {
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
        setContentView(R.layout.activity_menu_hb_demi_tactique);
      ImageView image1 = findViewById(R.id.imagestricte);
      ImageView image2 = findViewById(R.id.imagetactique);
      image2.setVisibility(View.INVISIBLE);
      Button conseil1 = findViewById(R.id.conseil_1);
      Button conseil2 = findViewById(R.id.conseil_2);
      TextView text1 = findViewById(R.id.textparade_1);
        TextView text2 = findViewById(R.id.textparade_2);
        text2.setVisibility(View.INVISIBLE);
      conseil1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              image1.setVisibility(View.VISIBLE);
              image2.setVisibility(View.INVISIBLE);
              text1.setVisibility(View.VISIBLE);
              text2.setVisibility(View.INVISIBLE);

          }
      });

      conseil2.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              image1.setVisibility(View.INVISIBLE);
              image2.setVisibility(View.VISIBLE);
              text1.setVisibility(View.INVISIBLE);
              text2.setVisibility(View.VISIBLE);

          }
      });


    }private void retour() {
        Intent intent60 = new Intent(this, menu_hb_demi.class);
        startActivity(intent60);
    }
}