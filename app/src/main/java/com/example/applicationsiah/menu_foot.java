package com.example.applicationsiah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class menu_foot extends AppCompatActivity {

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
        setContentView(R.layout.activity_menu_foot);
        Button button_g = (Button) findViewById(R.id.g);
        button_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { visualiser_menu_foot_gb();}
        });
        Button button_dc1 = (Button) findViewById(R.id.dc1);
        button_dc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { visualiser_menu_foot_dc();}
        });
        Button button_dc2 = (Button) findViewById(R.id.dc2);
        button_dc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { visualiser_menu_foot_dc();}
        });
        Button button_dg = (Button) findViewById(R.id.dg);
        button_dg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { visualiser_menu_foot_dg_dd();}
        });
        Button button_dd = (Button) findViewById(R.id.dd);
        button_dd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { visualiser_menu_foot_dg_dd();}
        });
        Button button_mdc = (Button) findViewById(R.id.mdc);
        button_mdc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { visualiser_menu_foot_mdc();}
        });
        Button button_mc1 = (Button) findViewById(R.id.mc1);
        button_mc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { visualiser_menu_foot_mc();}
        });
        Button button_mc2 = (Button) findViewById(R.id.mc2);
        button_mc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { visualiser_menu_foot_mc();}
        });
        Button button_ag = (Button) findViewById(R.id.ag);
        button_ag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { visualiser_menu_foot_ad_ag();}
        });
        Button button_ad = (Button) findViewById(R.id.ad);
        button_ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { visualiser_menu_foot_ad_ag();}
        });
        Button button_bu = (Button) findViewById(R.id.bu);
        button_bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { visualiser_menu_foot_bu();}
        });
    }

    private void visualiser_menu_foot_gb() {
        Intent intent1 = new Intent(this,menu_foot_gb.class);
        startActivity(intent1);
    }
    private void visualiser_menu_foot_dc() {
        Intent intent2 = new Intent(this,menu_foot_dc.class);
        startActivity(intent2);
    }
    private void visualiser_menu_foot_dg_dd() {
        Intent intent3 = new Intent(this,menu_foot_dg_dd.class);
        startActivity(intent3);
    }
    private void visualiser_menu_foot_mdc() {
        Intent intent4 = new Intent(this,menu_foot_mdc.class);
        startActivity(intent4);
    }
    private void visualiser_menu_foot_mc() {
        Intent intent5 = new Intent(this,menu_foot_mc.class);
        startActivity(intent5);
    }
    private void visualiser_menu_foot_ad_ag() {
        Intent intent6 = new Intent(this,menu_foot_ad_ag.class);
        startActivity(intent6);
    }
    private void visualiser_menu_foot_bu() {
        Intent intent7 = new Intent(this,menu_foot_bu.class);
        startActivity(intent7);
    }
    private void retour() {
        Intent intent60 = new Intent(this, Menu_sport.class);
        startActivity(intent60);
    }

    }
