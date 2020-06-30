package com.example.CodeCommander;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class linearSearch extends AppCompatActivity implements View.OnClickListener {

    int[] arr = {5,1,4,2,8,7};
    int arr1[] = {5,1,4,2,8,7};
    TextView[] number = new TextView[arr.length];
    int n = arr.length;
    int m = arr1.length;
    int i = 0;
    int j = 0;
    TextView arrayNumber;
    TextView currentNumber;
    int x = 8;
    int arr2[];
    String z;
    boolean inIsArray = false;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_search);

        //int arr2[] = mIntent.getIntArrayExtra("arrInt");
        Intent mIntent = getIntent();

        Log.w("Array", String.valueOf(mIntent.getIntArrayExtra("arrInt")));
        arr2 = mIntent.getIntArrayExtra("arrInt");


        Log.w("ARrayas", String.valueOf(arr2[1]));
        z = mIntent.getStringExtra("numberChosen");
        Log.w("Numberchose",z);
        x = Integer.parseInt(z);



        Button onClick = findViewById(R.id.buttonLinear);
        onClick.setOnClickListener(this);
        arrayNumber = findViewById(R.id.currentArrayNumber);
        currentNumber = findViewById(R.id.currentRealNumber);
        //aniFade = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
       // Log.w("Array", String.valueOf(arr2[1]));



        //Assigns each number within the array to a number on the screen

        number[0] = findViewById(R.id.txt_num0);
        number[1] = findViewById(R.id.txt_num1);
        number[2] = findViewById(R.id.txt_num2);
        number[3] = findViewById(R.id.txt_num3);
        number[4] = findViewById(R.id.txt_num4);
        number[5] = findViewById(R.id.txt_num5);

        for(int i = 0; i < arr2.length; i++){
            number[i].setText(String.valueOf(i));
        }

        for(int i = 0; i < arr2.length; i++){
            number[i].setText(String.valueOf(arr2[i]));

        }

    }

    @Override
    public void onClick(View view) {
        if(i < arr2.length){
            //Each time the user clicks through it progresses through the array


            number[i].setTextColor(Color.RED);
            arrayNumber.setText(Integer.toString(arr2[i]));
            if(arr2[i] == x){
                //If the users number is found it make the text change to show that is has been completed

                currentNumber.setText("Number Found");
                number[i].setTextColor(Color.BLUE);

            }
            else{
                currentNumber.setText("Not Found");
            }

            i++;
        }





    }
}
