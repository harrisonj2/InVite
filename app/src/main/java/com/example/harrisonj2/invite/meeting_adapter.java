package com.example.harrisonj2.invite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by harrisonj2 on 12/8/2015.
 */
public class meeting_adapter extends ArrayAdapter<Meeting> {
    Meeting meeting;
    TextView nameTV, hostTV, locationTV, dateTV, timeTV, descriptionTV;

    public meeting_adapter(Context context, Meeting[] objects){
        super(context, R.layout.meeting_row, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());

        View meetingView = inflater.inflate(R.layout.meeting_row, parent, false);

        meeting = getItem(position);
        nameTV = (TextView) meetingView.findViewById((R.id.nameTV));
        hostTV = (TextView) meetingView.findViewById((R.id.hostTV));
        locationTV = (TextView) meetingView.findViewById((R.id.locationTV));
        dateTV = (TextView) meetingView.findViewById((R.id.dateTV));
        timeTV = (TextView) meetingView.findViewById((R.id.timeTV));
        descriptionTV = (TextView) meetingView.findViewById((R.id.descriptionTV));

        nameTV.setText(meeting.getName());
        Integer id = meeting.getHostId();
        hostTV.setText(id.toString());
        locationTV.setText(meeting.getLocation());
        dateTV.setText(meeting.getDate());
        timeTV.setText(meeting.getTime());
        descriptionTV.setText(meeting.getDescription());

        return meetingView;
    }
}
