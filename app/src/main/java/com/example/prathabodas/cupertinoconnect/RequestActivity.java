package com.example.prathabodas.cupertinoconnect;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by oleonh on 4/9/17.
 */

public class RequestActivity extends ListActivity {


    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        Intent intent = getIntent();

        ArrayList<String> test = new ArrayList<>();

        test.add("Eliot");
        test.add("Oleon");
        test.add("Prath@");
        test.add("Ryan");
        test.add("Sukanya");
        test.add("Surendra");
        test.add("Karel");
        test.add("Eliot");
        test.add("Oleon");
        test.add("Prath@");
        test.add("Ryan");
        test.add("Sukanya");
        test.add("Surendra");
        test.add("Karel");
        test.add("Eliot");
        test.add("Oleon");
        test.add("Prath@");
        test.add("Ryan");
        test.add("Sukanya");
        test.add("Surendra");
        test.add("Karel");
        test.add("Eliot");
        test.add("Oleon");
        test.add("Prath@");
        test.add("Ryan");
        test.add("Sukanya");
        test.add("Surendra");
        test.add("Karel");


        setListAdapter(new ArrayAdapter<>(RequestActivity.this, android.R.layout.simple_list_item_1, test));

    }
}
