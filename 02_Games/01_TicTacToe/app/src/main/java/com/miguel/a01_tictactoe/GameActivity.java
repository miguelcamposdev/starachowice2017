package com.miguel.a01_tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {
    ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9;
    boolean isPlayingPlayer1 = true;
    boolean gameOver = false;

    /* ARRAY selectedCells
    *
    *   Positions   Default values      Player 1 select cell 7   Player 2 select cell 1
    *   0 1 2         0 0 0             0 0 0                       0 2 0
    *   3 4 5  >>>>   0 0 0    >>>>>    0 0 0         >>>>>>>>>>    0 0 0
    *   6 7 8         0 0 0             0 1 0                       0 1 0
    *
    * */

    //                     0 1 2 3 4 5 6 7 8
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
        if(gameOver) {
            Toast.makeText(this, "Game is over, start a new game!", Toast.LENGTH_SHORT).show();
        } else {
            // Convert the view component to ImageView type
            ImageView imageClicked = (ImageView) view;

            int id = imageClicked.getId();
            int position = 0;

            switch (id) {
                case R.id.imageView1:
                    position = 0;
                    break;
                case R.id.imageView2:
                    position = 1;
                    break;
                case R.id.imageView3:
                    position = 2;
                    break;
                case R.id.imageView4:
                    position = 3;
                    break;
                case R.id.imageView5:
                    position = 4;
                    break;
                case R.id.imageView6:
                    position = 5;
                    break;
                case R.id.imageView7:
                    position = 6;
                    break;
                case R.id.imageView8:
                    position = 7;
                    break;
                case R.id.imageView9:
                    position = 8;
                    break;
            }

            // Selecting the cell where user clicked

            if (selectedCells[position] == 0) { // if the cell is empty it's possible to select
                if (isPlayingPlayer1) {
                    imageClicked.setImageResource(R.drawable.ic_player_1);
                    selectedCells[position] = 1;
                } else {
                    imageClicked.setImageResource(R.drawable.ic_player_2);
                    selectedCells[position] = 2;
                }

                if (checkSolution()) {
                    gameOver = true;
                    // Winner
                    if (isPlayingPlayer1) {
                        Toast.makeText(this, "Player 1 wins!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Player 2 wins!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // continue playing...
                    isPlayingPlayer1 = !isPlayingPlayer1;
                }
            } else { // if cell is not empty, we can select this cell. Try with other!!!
                Toast.makeText(this, "You can't select this cell again!", Toast.LENGTH_SHORT).show();
            }
        } // finish if(gameOver)
    }

    private boolean checkSolution() {
        boolean existSolution = false;

        if(selectedCells[0]==selectedCells[1]
                && selectedCells[1]==selectedCells[2]
                && selectedCells[2]!=0){ // 0,1,2
            existSolution = true;
        } else if(selectedCells[3]==selectedCells[4]
                && selectedCells[4]==selectedCells[5]
                && selectedCells[5]!=0){ // 3,4,5
            existSolution = true;
        } else if(selectedCells[6]==selectedCells[7]
                && selectedCells[7]==selectedCells[8]
                && selectedCells[8]!=0) { // 6,7,8
            existSolution = true;
        } else if(selectedCells[0]==selectedCells[3]
                && selectedCells[3]==selectedCells[6]
                && selectedCells[6]!=0) { // 0,3,6
            existSolution = true;
        } else if(selectedCells[1]==selectedCells[4]
                && selectedCells[4]==selectedCells[7]
                && selectedCells[7]!=0) { // 1,4,7
            existSolution = true;
        } else if(selectedCells[2]==selectedCells[5]
                && selectedCells[5]==selectedCells[8]
                && selectedCells[8]!=0) { // 2,5,8
            existSolution = true;
        } else if(selectedCells[0]==selectedCells[4]
                && selectedCells[4]==selectedCells[8]
                && selectedCells[8]!=0) { // 0,4,8
            existSolution = true;
        } else if(selectedCells[2]==selectedCells[4]
                && selectedCells[4]==selectedCells[6]
                && selectedCells[6]!=0) { // 2,4,6
            existSolution = true;
        }

        return existSolution;
    }
}
