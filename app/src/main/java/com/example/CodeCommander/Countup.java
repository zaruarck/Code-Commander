package com.example.CodeCommander;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Countup extends AppCompatActivity implements View.OnClickListener {





   public int i = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countup);
        final TextView countup = findViewById(R.id.countup);
        final Button countUpButton = findViewById(R.id.countupbutton);
        countUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Increments by one each user click providing they haven't clicked more than 10 time
                if(i <= 10)
                {
                    countup.setText(Integer.toString(i));

                    i++;
                }
                else if(i >= 11 ){
                    countup.setText("Limit Reached");
                }

            }
        });











            }


    @Override
    public void onClick(View view) {



    }
}





