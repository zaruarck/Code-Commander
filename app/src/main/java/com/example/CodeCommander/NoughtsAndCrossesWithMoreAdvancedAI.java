package com.example.CodeCommander;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class NoughtsAndCrossesWithMoreAdvancedAI extends AppCompatActivity implements View.OnClickListener {

    private Button[][] buttons = new Button[3][3];

    private Boolean player1Turn = true;

    private int roundCount;

    private int player1Score;
    private int player2Score;

    private TextView txtPlayer1;
    private TextView txtPlayer2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noughts_and_crosses);

        txtPlayer1 = findViewById(R.id.txt_TicTacToePlayer1Score);
        txtPlayer2 = findViewById(R.id.txt_TicTacToePlayer2Score);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonId = "btn_" + i + j;
                int resID = getResources().getIdentifier(buttonId, "id", getPackageName());
                //Converts each button on the screen to either blank spaces, x's or o's depending on what has been placed there
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);

            }
        }

    }

    @Override
    public void onClick(View view) {

        if (!((Button) view).getText().toString().equals("")) {
            return;
        }
        if (player1Turn) {
            ((Button) view).setText("X");

        } else {
            ((Button) view).setText("0");
        }

        roundCount++;
        //Performs the check for the win function and decides based on who last played a move which player wins
        if (checkForWin(null)){
            if (player1Turn){
                player1Wins();
            }
            
            else{
                player2Wins();
            }
        }
        
        else if (roundCount == 9){
            draw();
        }
        else{
            player1Turn = !player1Turn;
        }
        playerAIClick();


    }




    private void playerAIClick() {
        String[][] boardCopy = new String[3][3];
        int winCondition = 0;
        boolean move = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardCopy[i][j] = buttons[i][j].getText().toString();
            }
        }


        Random rand = new Random();

        int ran1 = rand.nextInt(3);
        int jran2 = rand.nextInt(3);
        if(roundCount % 2 != 0) {
//Performs the AI move based on if the user can win then block it, if the AI can win then play that move and if none of those are valid then play a random move
            while (move) {




                    for (int x = 0; x < 3; x++) {
                        for (int y = 0; y < 3; y++) {

                            for (int i = 0; i < 3; i++) {
                                for (int j = 0; j < 3; j++) {
                                    boardCopy[i][j] = buttons[i][j].getText().toString();
                                }
                            }


                            if (buttons[x][y].getText().toString().equals("")) {
                                boardCopy[x][y] = "0";
                                if (checkForWin(boardCopy)) {
                                    if(move == true) {
                                        //Performs a click on the designated button
                                        buttons[x][y].performClick();
                                        winCondition = 0;
                                        move = false;
                                        resetBoard();
                                        break;
                                    }

                                }

                            }
                        }
                    }

                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            boardCopy[i][j] = buttons[i][j].getText().toString();
                        }
                    }






                    for (int x = 0; x < 3; x++) {
                        for (int y = 0; y < 3; y++) {
                            for (int i = 0; i < 3; i++) {
                                for (int j = 0; j < 3; j++) {
                                    boardCopy[i][j] = buttons[i][j].getText().toString();
                                }
                            }
                            if (buttons[x][y].getText().toString().equals("")) {
                                boardCopy[x][y] = "X";
                                if (checkForWin(boardCopy)) {
                                    if(move == true) {
                                        buttons[x][y].performClick();
                                        winCondition = 0;
                                        move = false;
                                        return;
                                    }


                                }

                            }
                        }
                    }



                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            boardCopy[i][j] = buttons[i][j].getText().toString();
                        }
                    }
                    //If it's the AIS move then chooce a random square to click

                    if(move == true){
                        if (buttons[ran1][jran2].getText().toString().equals("")) {
                            buttons[ran1][jran2].performClick();
                            move = false;


                        }
                    }












                //move=false;

                move = false;


            }
            move = false;

        }





    }











    private void draw() {
        Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show();
        resetBoard();
    }



    private void player2Wins() {
        player2Score++;
        Toast.makeText(this, "Player 2 Wins", Toast.LENGTH_SHORT).show();
        updatePointsText();
        resetBoard();

    }

    private void updatePointsText() {
        txtPlayer1.setText("Player 1: " + player1Score);
        txtPlayer2.setText("Player 2: " + player2Score);
    }

    private void player1Wins() {
        player1Score++;
        Toast.makeText(this, "Player 1 Wins", Toast.LENGTH_SHORT).show();
        updatePointsText();
        resetBoard();
    }

    private void resetBoard() {
        Button btn = findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(getIntent());


            }
        });





    }


    private boolean checkForWin(String boardCopy[][]) {
        //Performs a check for win
        String[][] board;
        if(boardCopy == null) {
            board = new String[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = buttons[i][j].getText().toString();
                }
            }
        }
        else {
            board = boardCopy;

        }


        //Checks on the horizontal if three of either O's or X's are in a row
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2]) && !board[i][0].equals("")) {
                return true;
            }
        }
        //Checks on the Vertical if three of either O's or X's are in a row
        for (int i = 0; i < 3; i++) {
            if (board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i]) && !board[0][i].equals("")) {
                return true;
            }
        }
        //Checks diagnol
        if (board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]) && !board[0][0].equals("")) {
            return true;
        }
        if (board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]) && !board[0][2].equals("")) {
            return true;
        }
        return false;


    }
}