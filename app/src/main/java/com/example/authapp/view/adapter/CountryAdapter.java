package com.example.authapp.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.authapp.R;

import java.util.List;

public class CountryAdapter extends ArrayAdapter<String> {

    private Context context;
    private List<String> countryList;
    private int resource;

    public CountryAdapter(@NonNull Context context, List<String> countryList, int resource) {
        super(context, resource);
        this.resource = resource;
        this.context = context;
        this.countryList = countryList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(resource,parent,false);
        TextView tvCountry = v.findViewById(R.id.tvCountry);
        tvCountry.setText(countryList.get(position));
        return v;
    }

    @Override
    public int getCount() {
        return countryList.size();
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(resource,parent,false);
        TextView tvCountry = v.findViewById(R.id.tvCountry);
        tvCountry.setText(countryList.get(position));
        return v;
    }

    @Nullable
    @Override
    public String getItem(int position) {
        return countryList.get(position);
    }
}
