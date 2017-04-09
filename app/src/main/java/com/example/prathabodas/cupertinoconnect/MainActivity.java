package com.example.prathabodas.cupertinoconnect;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.app.Notification;

import android.content.res.Resources;

public class MainActivity extends AppCompatActivity {
    private double latitude;
    private double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button viewLoc = (Button) findViewById(R.id.viewLoc);
        viewLoc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent transition = new Intent(MainActivity.this, MapActivity.class);
                MainActivity.this.startActivity(transition);
            }
        });

        Button viewReq = (Button) findViewById(R.id.viewReq);
        viewReq.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent transition = new Intent(MainActivity.this, RequestActivity.class);
                MainActivity.this.startActivity(transition);
            }
        });

       /* LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        longitude = location.getLongitude();
        latitude = location.getLatitude();

        double distanceforminsqrt = Math.pow(longitude - 37.3258,2) + Math.pow(latitude - 122.0424, 2);

        if (Math.sqrt(distanceforminsqrt) <= 0.0728) {//&& the button is pressed)
       */
            addNotification();
        }
    //}
    public void addNotification() {
        PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent(this, MapActivity.class), 0);
        Resources r = getResources();
        Notification notification = new NotificationCompat.Builder(this)
                .setTicker(r.getString(R.string.notification_titles))
                .setSmallIcon(android.R.drawable.ic_menu_report_image)
                .setContentTitle(r.getString(R.string.notification_titles))
                .setContentText(r.getString(R.string.notification_tex))
                .setContentIntent(pi)
                .setAutoCancel(true)
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification);
    }

}
