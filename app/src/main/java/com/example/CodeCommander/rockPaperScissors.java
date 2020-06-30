package com.example.CodeCommander;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class rockPaperScissors extends AppCompatActivity implements View.OnClickListener  {

    ImageView userInput;
    ImageView computerOutput;
    Button rock;
    Button paper;
    Button scissors;
    String userInputName;
    String computerMoves;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_paper_scissors);
        userInput= findViewById(R.id.img_userImage2);
        computerOutput = findViewById(R.id.img_computerImage);
        rock = findViewById(R.id.btn_rock2);
        paper = findViewById(R.id.btn_paper);
        scissors = findViewById(R.id.btn_scissors);

        rock.setOnClickListener(this);
        paper.setOnClickListener(this);
        scissors.setOnClickListener(this);





    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onClick(View v){
        int id = v.getId();
        switch(id){
            //Allows the user to choose a move and assigns the variable related to it as well as the image related to that move.

            case R.id.btn_rock2:
                userInputName = "Rock";
                userInput.setImageDrawable(getDrawable(R.drawable.rock));

                break;
            case R.id.btn_paper:
                userInputName = "Paper";
                userInput.setImageDrawable(getDrawable(R.drawable.paper));

                break;
            case R.id.btn_scissors:
                userInputName = "Scissors";
                userInput.setImageDrawable(getDrawable(R.drawable.scissors));


                break;






        }
        setComputerOutput();

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setComputerOutput(){
        //Generates a random number between 0 and 2 and decides the computers move based on it.
        int computerMoveRandom = (int) (Math.random() * 3);
        Log.w("Computer Moves", String.valueOf(computerMoveRandom));
        if(computerMoveRandom == 0){
            computerOutput.setImageDrawable(getDrawable(R.drawable.rock));
            computerMoves = "Rock";
            Log.w("Computer Moves", String.valueOf(computerMoves));
            resultChecker(computerMoves);
        }
        else if(computerMoveRandom == 1){
            computerOutput.setImageDrawable(getDrawable(R.drawable.paper));
            computerMoves = "Paper";
            resultChecker(computerMoves);

        }
        else if(computerMoveRandom == 2){
            computerOutput.setImageDrawable(getDrawable(R.drawable.scissors));
            computerMoves = "Scissors";
            resultChecker(computerMoves);

        }


    }

    private void resultChecker(String computerMoves){
        if(userInputName == "Rock" && computerMoves == "Scissors"){
            resultShower(1);

        }
        else if(userInputName == "Rock" && computerMoves == "Paper"){
            resultShower(2);

        }

        else if(userInputName == "Paper" && computerMoves == "Scissors"){
            resultShower(2);

        }
        else if(userInputName == "Paper" && computerMoves == "Rock"){
            resultShower(1);

        }
        else if(userInputName == "Scissors" && computerMoves == "Paper"){
            resultShower(1);

        }
        else if(userInputName == "Scissors" && computerMoves == "Rock"){
            resultShower(2);

        }
        else{
            resultShower(0);
        }



    }

    private void resultShower(int result){
        if(result == 0){
            Toast.makeText(getApplicationContext(), "You Tied!", Toast.LENGTH_SHORT).show();
        }
        else if(result == 1){
            Toast.makeText(getApplicationContext(), "You Win!", Toast.LENGTH_SHORT).show();
        }
        else if(result == 2){
            Toast.makeText(getApplicationContext(), "You Lose!", Toast.LENGTH_SHORT).show();
        }

    }
}
