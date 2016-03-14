package com.example.kiran.testdemo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
/**
 * Created by kiran on 3/9/2016.
 */
public class TabFragment2 extends Fragment {
    double latitude;
    double longitude;
    String title;
    public TabFragment2() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab_fragment2, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final Spinner spinner = (Spinner) getActivity().findViewById(R.id.spinner);
        final TextView latLong = (TextView) getActivity().findViewById(R.id.lat_long);
        Button navigate = (Button) getActivity().findViewById(R.id.navigateBtn);
        navigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent map = new Intent(getActivity(), MapsActivity.class);
                map.putExtra("latitude", latitude);
                map.putExtra("longitude", longitude);
                map.putExtra("title",title);
                startActivity(map);
            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String car = ((TextView) view.findViewById(R.id.car))
                        .getText().toString();
                String train = ((TextView) view.findViewById(R.id.train))
                        .getText().toString();
                latitude = Double.parseDouble(((TextView) view.findViewById(R.id.latitude))
                        .getText().toString());
                longitude = Double.parseDouble(((TextView) view.findViewById(R.id.longitude))
                        .getText().toString());
                title = ((TextView) view.findViewById(R.id.name))
                        .getText().toString();
                latLong.setText("Car - "+car +"   Train- "+train);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
