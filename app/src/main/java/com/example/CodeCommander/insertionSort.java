package com.example.CodeCommander;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class insertionSort extends AppCompatActivity {

    int arr[] = {5,1,4,2,8,7};
    int n = arr.length;
//Not used


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertion_sort);

        for(int i = 1; i < n; i++){
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j = j -1;
            }
            arr[j + 1] = key;
        }

        Log.w("Array", arr.toString());
    }
}
