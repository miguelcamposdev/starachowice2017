package com.miguel.a01_tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class GameActivity extends AppCompatActivity {
    ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9;
    boolean isPlayingPlayer1 = true;
    int[] selectedCells = {0,0,0,0,0,0,0,0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        img1 = findViewById(R.id.imageView1);
        img2 = findViewById(R.id.imageView2);
        img3 = findViewById(R.id.imageView3);
        img4 = findViewById(R.id.imageView4);
        img5 = findViewById(R.id.imageView5);
        img6 = findViewById(R.id.imageView6);
        img7 = findViewById(R.id.imageView7);
        img8 = findViewById(R.id.imageView8);
        img9 = findViewById(R.id.imageView9);
    }

    public void cellClick(View view) {
        // Convert the view component to ImageView type
        ImageView imageClicked = (ImageView) view;

        int id = imageClicked.getId();
        int position = 0;

        switch (id) {
            case R.id.imageView1: position = 0;
                break;
            case R.id.imageView2: position = 1;
                break;
            case R.id.imageView3: position = 2;
                break;
            case R.id.imageView4: position = 3;
                break;
            case R.id.imageView5: position = 4;
                break;
            case R.id.imageView6: position = 5;
                break;
            case R.id.imageView7: position = 6;
                break;
            case R.id.imageView8: position = 7;
                break;
            case R.id.imageView9: position = 8;
                break;
        }

        if(isPlayingPlayer1) {
            imageClicked.setImageResource(R.drawable.ic_player_1);
            isPlayingPlayer1 = false;
            selectedCells[position] = 1;
        } else {
            imageClicked.setImageResource(R.drawable.ic_player_2);
            isPlayingPlayer1 = true;
            selectedCells[position] = 2;
        }
    }
}
