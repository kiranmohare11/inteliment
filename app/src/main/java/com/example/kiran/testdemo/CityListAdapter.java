package com.example.kiran.testdemo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kiran on 3/10/2016.
 */
public class CityListAdapter extends BaseAdapter {
    private final Context activity;
    private LayoutInflater inflater;
    private final List<City> catItems;

    public CityListAdapter(Context activity, List<City> catItems) {
        this.activity = activity;
        this.catItems = catItems;
    }

    @Override
    public int getCount() {
        return catItems.size();
    }

    @Override
    public Object getItem(int location) {
        return catItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_city_row, null);

        holder = new ViewHolder();

        holder.name = (TextView) convertView.findViewById(R.id.name);
        holder. id = (TextView) convertView.findViewById(R.id.id);
        holder.latitude = (TextView) convertView.findViewById(R.id.latitude);
        holder.longitude = (TextView) convertView.findViewById(R.id.longitude);
        holder.car = (TextView) convertView.findViewById(R.id.car);
        holder.train = (TextView) convertView.findViewById(R.id.train);
        holder.city = catItems.get(position);
        holder.name.setText(holder.city.getName());
        holder.latitude.setText(Double.toString(holder.city.getLatitude()));
        holder.longitude.setText(Double.toString(holder.city.getLongitude()));
        holder.car.setText((holder.city.getCar()));
        holder.train.setText((holder.city.getTrain()));
        return convertView;
    }

    public static class ViewHolder {
        City city;
        TextView name;
        TextView id;
        TextView latitude;
        TextView longitude;
        TextView car;
        TextView train;
    }
}
