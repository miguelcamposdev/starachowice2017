package com.miguel.a01_notesdatabase;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    RealmResults<Note> noteList;
    Realm realm;
    MyNotesAdapter adapter;
    EditText name;
    CheckBox important;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Get the database connection
        realm = Realm.getDefaultInstance();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogNewNote();
            }
        });


        // 1.
        lista = findViewById(R.id.listViewNotes);

        // 2. SELECT * FROM Note
        noteList = realm.where(Note.class).findAll();

        // 3.
        adapter = new MyNotesAdapter(
                this,
                R.layout.notes_item,
                noteList
        );

        // 4.
        lista.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void showDialogNewNote() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();

        View v = inflater.inflate(R.layout.dialog_signin, null);
        name = v.findViewById(R.id.editTextTitle);
        important = v.findViewById(R.id.checkBoxImportant);

        builder.setView(v);

        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String noteText = name.getText().toString();
                        boolean noteImportant = important.isChecked();

                        Note newNote = new Note();
                        newNote.setTitle(noteText);
                        newNote.setImportant(noteImportant);

                        realm.beginTransaction();
                        realm.copyToRealm(newNote);
                        realm.commitTransaction();

                        // Refresh the list - adapter
                        noteList = realm.where(Note.class).findAll();
                        adapter.notifyDataSetChanged();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        builder.create();

        builder.show();

    }
}
