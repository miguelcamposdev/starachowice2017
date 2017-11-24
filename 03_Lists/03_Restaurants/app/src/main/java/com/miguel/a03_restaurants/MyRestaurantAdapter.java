package com.miguel.a03_restaurants;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by miguelcampos on 24/11/17.
 */

class MyRestaurantAdapter extends ArrayAdapter<Restaurant>{
    Context ctx;
    int layoutTemplate;
    List<Restaurant> restaurantList;

    public MyRestaurantAdapter(@NonNull Context context, int resource, @NonNull List<Restaurant> objects) {
        super(context, resource, objects);
        ctx = context;
        layoutTemplate = resource;
        restaurantList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater
                .from(ctx)
                .inflate(layoutTemplate,parent,false);

        return v;
    }
}
