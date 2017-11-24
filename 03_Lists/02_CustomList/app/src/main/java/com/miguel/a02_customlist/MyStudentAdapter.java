package com.miguel.a02_customlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by miguelcampos on 23/11/17.
 */

class MyStudentAdapter extends ArrayAdapter<Student> {
    Context ctx;
    int layoutTemplate;
    List<Student> students;

    public MyStudentAdapter(@NonNull Context context, int resource, @NonNull List<Student> objects) {
        super(context, resource, objects);
        ctx = context;
        layoutTemplate = resource;
        students = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(layoutTemplate,parent,false);

        // current student information
        Student current = students.get(position);
        String name = current.getName();
        int age = current.getAge();
        String city = current.getCity();
        String photo = current.getPhoto();

        // Get the view components from the template
        ImageView imageViewPhoto = v.findViewById(R.id.imageViewPhoto);
        TextView textViewName = v.findViewById(R.id.textViewName);
        TextView textViewAge = v.findViewById(R.id.textViewAge);
        TextView textViewCity = v.findViewById(R.id.textViewCity);

        // Set the current student info into the view components
        textViewName.setText(name);
        textViewAge.setText(age+" years old");
        textViewCity.setText(city);
        Picasso.with(ctx).load(photo).into(imageViewPhoto);

        return v;
    }
}
