package com.miguel.a01_notesdatabase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by miguelcampos on 30/11/17.
 */

class MyNotesAdapter extends ArrayAdapter<Note> {
    Context ctx;
    int template;
    List<Note> notes;

    public MyNotesAdapter(@NonNull Context context, int resource, @NonNull List<Note> objects) {
        super(context, resource, objects);
        ctx = context;
        template = resource;
        notes = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(template, parent, false);

        // 1. Get current Note
        Note currentNote = notes.get(position);

        // 2. Get the view components
        TextView textViewTitle = v.findViewById(R.id.textViewTitle);
        ImageView imageViewImportant = v.findViewById(R.id.imageViewImportant);
        TextView textViewDescription = v.findViewById(R.id.textViewDescription);

        // 3. Set into the view components the current Note info
        textViewTitle.setText(currentNote.getTitle());
        textViewDescription.setText(currentNote.getDescription());

        if(currentNote.isImportant()) {
          imageViewImportant.setImageResource(android.R.drawable.star_on);
        }

        return v;
    }
}
