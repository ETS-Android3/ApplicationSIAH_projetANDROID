package com.example.applicationsiah;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {


private VideoView videoView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      // videoView = (VideoView) findViewById(R.id.video_sport);

        //Uri uri = Uri.parse("android.ressource://"+getPackageName() +"/" +R.raw.video_sport);
    //videoView.setVideoURI(uri);
        Button monBouton = (Button)findViewById(R.id.button_demarrer);

        monBouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_la_suite();
            }
        });
Button conexion1 = (Button) findViewById(R.id.co_1);
conexion1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        visualiser_info();
    }
});
    }

    private void visualiser_info() {
        Intent intent1 = new Intent(this,informations_perso.class);
        startActivity(intent1);
    }

    private void visualiser_la_suite() {
        Intent intent = new Intent(this, Menu_principal.class);
        startActivity(intent);
    }
    /*/
    @Override
    protected void onResume() {

        super.onResume();
        videoView.start();
    }
    @Override
    protected void onPause(){
        super.onPause();
        videoView.suspend();
    }
       // public void onClickListener(View view) {

    //}
*/
    /*private int notificationId =0;
    private void sendNotificationOnChannel ( String title, String message, String channelId, int priority){
        NotificationCompact.Builder notification = new NotificationCompact.Builder ( getApplicationContext(), channelId)
                .setSmallIcon(R.drawable.star)
                .setContentTitle ( title)
                .setContentText ( "id="+ notificationId + " - "+ message)
                .setPriority ( priority);
        ApplicationDemo.getNotificationManager().notify( ++notificationId , notification.build());
*/
}