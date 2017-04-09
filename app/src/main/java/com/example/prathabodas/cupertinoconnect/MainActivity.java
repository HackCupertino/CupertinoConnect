package com.example.prathabodas.cupertinoconnect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button go = (Button)findViewById(R.id.go);
        go.setOnClickListener(new View.OnClickListener() {
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
    }
}
