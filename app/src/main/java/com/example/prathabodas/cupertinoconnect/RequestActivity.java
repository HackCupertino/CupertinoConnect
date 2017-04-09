package com.example.prathabodas.cupertinoconnect;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Created by oleonh on 4/9/17.
 */

public class RequestActivity extends ListActivity {


    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        Intent intent = getIntent();

        ArrayList<EventInfo> test = new ArrayList<>();
        test.add(new EventInfo("Quinlan Center", new MyGregorianCalendar(2017, 1, 1)));
        test.add(new EventInfo("Quinlan Centerr", new MyGregorianCalendar(2017, 1, 2)));
        test.add(new EventInfo("Quinlan Centerrr", new MyGregorianCalendar(2017, 1, 3)));
        test.add(new EventInfo("Quinlan Centerrrrr", new MyGregorianCalendar(2017, 1, 4)));
        test.add(new EventInfo("Quinlan Centerrrrrr", new MyGregorianCalendar(2017, 1, 5)));
        test.add(new EventInfo("Quinlan Centerrrrrrr", new MyGregorianCalendar(2017, 1, 6)));
        test.add(new EventInfo("Quinlan Centerrrrrrrr", new MyGregorianCalendar(2017, 1, 7)));
        test.add(new EventInfo("Quinlan Centerrrrrrrrr", new MyGregorianCalendar(2017, 1, 8)));
        test.add(new EventInfo("Quinlan Centerrrrrrrrrr", new MyGregorianCalendar(2017, 1, 9)));
        test.add(new EventInfo("Quinlan Centerrrrrrrrrrr", new MyGregorianCalendar(2017, 1, 10)));
        test.add(new EventInfo("Quinlan Centerrrrrrrrrrrr", new MyGregorianCalendar(2017, 1, 11)));
        test.add(new EventInfo("Quinlan Centerrrrrrrrrrrrr", new MyGregorianCalendar(2017, 1, 12)));
        test.add(new EventInfo("Quinlan Centerrrrrrrrrrrrrr", new MyGregorianCalendar(2017, 1, 13)));
        test.add(new EventInfo("Quinlan Centerrrrrrrrrrrrrrr", new MyGregorianCalendar(2017, 1, 14)));


        setListAdapter(new ArrayAdapter<>(RequestActivity.this, android.R.layout.simple_list_item_1, test));

    }
}

class EventInfo {
    private String eventLocation;
    private MyGregorianCalendar date;
    private boolean accepted = false, declined = false;

    public EventInfo(String eventLocation, MyGregorianCalendar date) {
        this.eventLocation = eventLocation;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Location: " + eventLocation + "\r\nDate: " + date;
    }
}

class MyGregorianCalendar extends GregorianCalendar {
    private int year, month, dayOfMonth;

    MyGregorianCalendar(int year, int month, int dayOfMonth) {
        super(year, month, dayOfMonth);
        this.year = year;
        this.month = month;
        this.dayOfMonth = dayOfMonth;
    }

    @Override
    public String toString() {
        return dayOfMonth + "/" + month + "/" + year;
    }
}
