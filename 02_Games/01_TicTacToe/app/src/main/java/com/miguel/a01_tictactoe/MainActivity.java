package com.miguel.a01_tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText p1, p2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p1 = findViewById(R.id.editTextPlayer1);
        p2 = findViewById(R.id.editTextPlayer2);
    }

    public void startGame(View view) {
        String p1Name = p1.getText().toString();
        String p2Name = p2.getText().toString();

        if(p1Name.equals("")) {
            // Show a warning/error for Player 1
            p1.setError("Please write the P1 name");
        } else if(p2Name.equals("")) {
            // Show a warning/error for Player 2
            p2.setError("Please write the P2 name");
        } else {
            // It's possible to start game!
            Intent i = new Intent(MainActivity.this,GameActivity.class);
            startActivity(i);
        }
    }
}
