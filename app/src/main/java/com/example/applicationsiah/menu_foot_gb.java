package com.example.applicationsiah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class menu_foot_gb extends AppCompatActivity {
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
        setContentView(R.layout.activity_menu_foot_gb);

        Button physique = (Button) findViewById((R.id.physique));
        physique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {visualiser_physique_gb();}
        });
        Button technique = (Button) findViewById((R.id.technique));
        physique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {visualiser_technique_gb();}
        });
    }
    private void visualiser_technique_gb(){
        Intent intent1 = new Intent(this, technique_gb.class);
        startActivity(intent1);
    }

    private void visualiser_physique_gb() {
        Intent intent2 = new Intent(this, Physique_gb.class);
        startActivity(intent2);
    }
    private void retour() {
        Intent intent60 = new Intent(this, menu_foot.class);
        startActivity(intent60);
    }
}