package com.example.CodeCommander;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class bubbleSort extends AppCompatActivity implements View.OnClickListener {
    int arr[] = {5,1,4,2,8,7};
    int arr1[] = {5,1,4,2,8,7};
    TextView [] number = new TextView[arr.length];
    int n = arr.length;
    int m = arr1.length;
    int i = 0;
    int j = 0;
    TextView arrayNumber;
    TextView currentNumber;


    Animation aniFade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bubble_sort);

        Button onClick = findViewById(R.id.button3);
        onClick.setOnClickListener(this);
        //arrayNumber = findViewById(R.id.currentArrayNumber);
        currentNumber = findViewById(R.id.currentRealNumber);
        aniFade = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);


        //Assigns each button a number from the array
        number[0] = findViewById(R.id.txt_num0);
        number[1] = findViewById(R.id.txt_num1);
        number[2] = findViewById(R.id.txt_num2);
        number[3] = findViewById(R.id.txt_num3);
        number[4] = findViewById(R.id.txt_num4);
        number[5] = findViewById(R.id.txt_num5);


        //Assigns each button a number from the array
        for(int i = 0; i < arr.length; i++){
            number[i].setText(String.valueOf(i));
        }






        //Assigns each button a number from the array
        for(int i = 0; i < arr.length; i++){
            number[i].setText(String.valueOf(arr[i]));

        }






    }

    @Override
    public void onClick(View view) {

        //j++;
        number[j].setTextColor(Color.WHITE);




        //Runs the actual bubble sort iterating one step per user click
        for (; i < n-1; ){
            for(; j < n -i -1; j++){

                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1] = temp;

                    //arrayNumber.setText( "Current Number In Array - " + j);
                    currentNumber.setText("Current Number Represented - " + arr[j + 1]);
                    number[j].setTextColor(Color.RED);


                    break;
                }

            }
            break;
        }





            //Used to keep track of the amount of times the user has clicked the button
           if(j >= n-1){
               i++;
               j=0;
           }



        for(int i = 0; i < arr.length; i++){
            number[i].setText(String.valueOf(arr[i]));

        }










       // number[1].startAnimation(aniFade);


    }
}
