package com.example.prathabodas.cupertinoconnect;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
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
    private static final String TAG = "MainActivity";
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

        Toast.makeText(MainActivity.this, "button", Toast.LENGTH_SHORT).show();
        new HttpsClient().execute("https://api.particle.io/v1/devices/550053001851353338363036/button/?access_token=d75960480ab7db392d6ae6d1909b9d64431e7cdb");

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
*/

        //if ()  //(Math.sqrt(distanceforminsqrt) <= 0.0728) && the button is pressed)
        //Data data = new Data();
        //System.out.println(data.getButton());
        //System.out.println("Yo");

        addNotification();

    } //end of onCreate method
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

    class HttpsClient extends AsyncTask<String, Void, String> {
        private Exception exception;

        public String doInBackground(String... urls) {

            try {
                Log.d(TAG, "*******************    Open Connection    *****************************");
                URL url = new URL(urls[0]);
                Log.d(TAG, "Received URL:  " + url);

                HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
                Log.d(TAG, "Con Status: " + con);

                InputStream in = con.getInputStream();
                Log.d(TAG, "GetInputStream:  " + in);

                Log.d(TAG, "*******************    String Builder     *****************************");
                String line = null;

                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

                Data data = new Data();

                while ((line = br.readLine()) != null) {
                    if (line.contains("event")) {
                        //do nothing since the event tag is of no interest
                        Log.d(TAG, "Failed fetching needed values.");
                        return null;
                    }

                    //check if we have all needed data
                    if (data.isReady()) {
                        //exit endless connection
                        Log.d(TAG, "*******************    Data received    *****************************");
                        Log.d(TAG, "data:  " + data);
                        break;
                    }
                }

                // Creation of finalized containers for UI usage
                final String gButton = data.getButton();
                // To access the findViewById we need this to runOnUiThread
                runOnUiThread(new Runnable() {
                    public void run() {
                        Log.d(TAG, "*******************    Run UI Thread     *****************************");
                        Log.d(TAG, "gButton:   " + gButton);

                    }

                });
                // Closing the stream
                Log.d(TAG, "*******************  Stream closed, exiting     ******************************");
                br.close();
            } catch (Exception e) {
                this.exception = e;
                return null;
            }
            return null;
        }

    }
}