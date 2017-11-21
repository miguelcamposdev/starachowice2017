package com.miguel.helloapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Launch the onCreate method that exists in
        // the AppCompatActivity (super, parent)
        super.onCreate(savedInstanceState);

        //  Load in the screen the activity_main.xml
        // file that includes the layout User Interface.
        setContentView(R.layout.activity_main);
    }
}
