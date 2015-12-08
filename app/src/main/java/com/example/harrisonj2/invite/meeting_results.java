package com.example.harrisonj2.invite;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class meeting_results extends AppCompatActivity {

    private Meeting[] meetingData;
    DBHandler dbHandler;
    ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_results);

        dbHandler = new DBHandler(this, null);

        String [] noMeeting = {"No meetings found!"};

        meetingData = dbHandler.getMeeting();

        if (meetingData != null) {
            adapter = new meeting_adapter(this, meetingData);
        }else{
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, noMeeting);
        }

        ListView listView = (ListView) findViewById(R.id.meetingListView);
        listView.setAdapter(adapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

}
