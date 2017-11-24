package com.miguel.a03_restaurants;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

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

        // 1.
        Restaurant current = restaurantList.get(position);
        String name = current.getName();
        String address = current.getAddress();
        String phone = current.getPhoneNumber();
        int rate = current.getRate();
        final String website = current.getWebsite();
        String photo = current.getPhoto();

        // 2.
        TextView textViewName = v.findViewById(R.id.textViewName);
        TextView textViewAddress = v.findViewById(R.id.textViewAddress);
        TextView textViewPhone = v.findViewById(R.id.textViewPhone);
        ImageView imageViewPhoto = v.findViewById(R.id.imageViewPhoto);
        ImageView imageViewLink = v.findViewById(R.id.imageViewLink);
        RatingBar ratingBar = v.findViewById(R.id.ratingBar);

        // 3.
        textViewName.setText(name);
        textViewAddress.setText(address);
        textViewPhone.setText(phone);
        ratingBar.setRating(rate);

        imageViewLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webpage = Uri.parse(website);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(ctx.getPackageManager()) != null) {
                    ctx.startActivity(intent);
                }
            }
        });

        Picasso.with(ctx).load(photo).into(imageViewPhoto);

        return v;
    }
}
