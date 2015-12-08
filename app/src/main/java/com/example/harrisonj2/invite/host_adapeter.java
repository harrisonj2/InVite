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
public class host_adapeter extends ArrayAdapter<Host>{
    Host host;
    TextView hostIDTextView, hostEmailTextView;

    public host_adapeter(Context context, Host[] objects){
        super(context, R.layout.host_row, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());

        View hostView = inflater.inflate(R.layout.host_row, parent, false);

        host = getItem(position);
        hostIDTextView = (TextView) hostView.findViewById(R.id.hostIDTextView);
        hostEmailTextView = (TextView) hostView.findViewById(R.id.hostEmailTextView);

        hostIDTextView.setText(host.getId());
        hostEmailTextView.setText(host.getEmail());

        return hostView;
    }
}
