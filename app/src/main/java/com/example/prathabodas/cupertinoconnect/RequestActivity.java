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
    private int year, month, dayOfMonth;

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

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
