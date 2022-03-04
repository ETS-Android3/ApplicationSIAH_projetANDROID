package com.example.applicationsiah;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class menu_tactique_gb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_tactique_gb);
        ImageView parade_1 = (ImageView) findViewById(R.id.parade_1);
        Button conseil_1 = (Button) findViewById(R.id.conseil_1);
        ImageView parade_2 = (ImageView) findViewById(R.id.parade_2);
        parade_2.setVisibility(View.INVISIBLE);
        TextView text1 = (TextView) findViewById(R.id.textparade_1);
        TextView text2 = (TextView) findViewById(R.id.textparade_2);
        Button conseil_2 = (Button) findViewById(R.id.conseil_2);
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
}