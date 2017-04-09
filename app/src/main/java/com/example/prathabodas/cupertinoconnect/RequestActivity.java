package com.example.prathabodas.cupertinoconnect;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Comparator;
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
        test.add(new EventInfo("Quinlan Center", new MyGregorianCalendar(2017, 1, 1, 12, 10)));
        test.add(new EventInfo("Quinlan Centerr", new MyGregorianCalendar(2017, 1, 2, 12, 11)));
        test.add(new EventInfo("Quinlan Centerrr", new MyGregorianCalendar(2017, 1, 3, 12, 12)));
        test.add(new EventInfo("Quinlan Centerrrrr", new MyGregorianCalendar(2017, 1, 4, 12, 13)));
        test.add(new EventInfo("Quinlan Centerrrrrr", new MyGregorianCalendar(2017, 1, 5, 12, 14)));
        test.add(new EventInfo("Quinlan Centerrrrrrr", new MyGregorianCalendar(2017, 1, 6, 12, 15)));
        test.add(new EventInfo("Quinlan Centerrrrrrrr", new MyGregorianCalendar(2017, 1, 7, 12, 16)));
        test.add(new EventInfo("Quinlan Centerrrrrrrrr", new MyGregorianCalendar(2017, 1, 8, 12, 17)));
        test.add(new EventInfo("Quinlan Centerrrrrrrrrr", new MyGregorianCalendar(2017, 1, 9, 12, 18)));
        test.add(new EventInfo("Quinlan Centerrrrrrrrrrr", new MyGregorianCalendar(2017, 1, 10, 12, 19)));
        test.add(new EventInfo("Quinlan Centerrrrrrrrrrrr", new MyGregorianCalendar(2017, 1, 11, 12, 20)));
        test.add(new EventInfo("Quinlan Centerrrrrrrrrrrrr", new MyGregorianCalendar(2017, 1, 12, 12, 21)));
        test.add(new EventInfo("Quinlan Centerrrrrrrrrrrrrr", new MyGregorianCalendar(2017, 1, 13, 12, 22)));
        test.add(new EventInfo("Quinlan Centerrrrrrrrrrrrrrr", new MyGregorianCalendar(2017, 1, 14, 12, 23)));

        test.sort(new Comparator<EventInfo>() {
            @Override
            public int compare(EventInfo o1, EventInfo o2) {
                if(o2.getDate().getYear() != o1.getDate().getYear()) return o1.getDate().getYear() - o2.getDate().getYear();
                else if(o2.getDate().getMonth() != o1.getDate().getMonth()) return o1.getDate().getMonth() - o2.getDate().getMonth();
                else return o1.getDate().getDayOfMonth() - o2.getDate().getDayOfMonth();
            }
        });


        setListAdapter(new ArrayAdapter<EventInfo>(RequestActivity.this, android.R.layout.simple_list_item_1, test) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                return super.getView(position, convertView, parent);
            }
        });

    }
}

class EventLayout extends TableLayout {

    private EventInfo eventInfo;

    public EventLayout(Context context, EventInfo eventInfo) {
        super(context);
        this.eventInfo = eventInfo;

        TableLayout eventDetails = new TableLayout(context);
            TableRow locationRow = new TableRow(context);
                TextView locationText = new TextView(context);
                locationText.setText(eventInfo.getEventLocation());
                locationRow.addView(locationText);
            eventDetails.addView(locationRow);
            TableRow dateRow = new TableRow(context);
                TextView dateText = new TextView(context);
                dateText.setText(eventInfo.getDate().toString());
                dateRow.addView(dateText);
            eventDetails.addView(dateRow);
        addView(eventDetails);

        Button ignoreButton = new Button(context);
        ignoreButton.setText("Ignore");
        addView(ignoreButton);
    }

}

class EventInfo {
    private String eventLocation;
    private MyGregorianCalendar date;

    public EventInfo(String eventLocation, MyGregorianCalendar date) {
        this.eventLocation = eventLocation;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Location: " + eventLocation + "\r\nDate: " + date;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public MyGregorianCalendar getDate() {
        return date;
    }

}

class MyGregorianCalendar extends GregorianCalendar {
    private int year, month, dayOfMonth, hourOfDay, minute;

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public int getHourOfDay() {
        return hourOfDay;
    }

    public int getMinute() {
        return minute;
    }

    MyGregorianCalendar(int year, int month, int dayOfMonth, int hourOfDay, int minute) {
        super(year, month, dayOfMonth, hourOfDay, minute);
        this.year = year;
        this.month = month;
        this.dayOfMonth = dayOfMonth;
        this.hourOfDay = hourOfDay;
        this.minute = minute;
    }

    @Override
    public String toString() {
        return dayOfMonth + "/" + month + "/" + year + ", " + hourOfDay + ":" + minute;
    }
}
