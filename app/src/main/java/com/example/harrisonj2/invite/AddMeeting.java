package com.example.harrisonj2.invite;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddMeeting extends AppCompatActivity {

    EditText name, description, location, date, time, host;
    Intent intent;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meeting);

        name = (EditText) findViewById(R.id.nameEditText);
        description = (EditText) findViewById(R.id.descriptionEditText);
        location = (EditText) findViewById(R.id.locationEditText);
        date = (EditText) findViewById(R.id.dateEditText);
        time = (EditText) findViewById(R.id.timeEditText);
        host = (EditText) findViewById(R.id.hostIDEditText);

        dbHandler = new DBHandler(this, null);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void viewMeeting(View view){
        intent = new Intent(this, meeting_results.class);
        startActivity(intent);
    }

    public void goToHost(View view){
        intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void addMeeting(View view){
        String nam = name.getText().toString();
        String des = description.getText().toString();
        String loc = location.getText().toString();
        String dat = date.getText().toString();
        String tim = time.getText().toString();
        String hos = host.getText().toString();

        if(nam.equals("") || des.equals("") || loc.equals("") || dat.equals("") ||
                tim.equals("") || hos.equals(""))
            Toast.makeText(this, "Please enter data in each field!", Toast.LENGTH_LONG).show();
        else{
            int ho = Integer.parseInt(hos);
            dbHandler.addMeeting(nam, des, loc, dat, tim, ho);
            Toast.makeText(this, "Meeting added!", Toast.LENGTH_LONG).show();
        }
    }

}
