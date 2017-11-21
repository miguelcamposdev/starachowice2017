package com.miguel.a04_formselements;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    TextView hello;
    EditText comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hello = findViewById(R.id.textViewHotelName);
        comment = findViewById(R.id.editTextComment);

        hello.setText("HOTEL EUROPA STARACHOWICE");
    }

    public void showComment(View view) {
        String commentText = comment.getText().toString();
        Toast.makeText(this, commentText, Toast.LENGTH_SHORT).show();
    }
}
