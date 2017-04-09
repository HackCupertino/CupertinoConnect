package com.example.prathabodas.cupertinoconnect;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by oleonh on 4/9/17.
 */

public class RequestActivity extends Activity {

    ArrayList<String> test = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        test.add("Eliot");
        test.add("Oleon");
        test.add("Pratha");
        test.add("Ryan");
        test.add("Sukanya");
        test.add("Surendra");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, test);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        startActivity(intent);

    }
}
