package com.example.CodeCommander;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Instrumentation;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Login extends AppCompatActivity {

    private static final int MY_REQUEST_CODE = 7117 ;
    List<AuthUI.IdpConfig> providers;

    Button btn_sign_out;
    EditText editText;

    Button increment;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    //Sets up the login section of the app making use of FIREBASE



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //editText = findViewById(R.id.Editext);
        FirebaseUser userLoggedIn = FirebaseAuth.getInstance().getCurrentUser();


        providers = Arrays.asList(new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.PhoneBuilder().build(),
                //  new AuthUI.IdpConfig.FacebookBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build());
        //btn_sign_out = (Button) findViewById(R.id.btn_sign_out);
        // btn_sign_out.setEnabled(true);
        //increment = findViewById(R.id.Increment);
        // increment.setOnClickListener(this);


        // btn_sign_out.setOnClickListener(new View.OnClickListener() {


        showSignInOptions();


    }

    private void showSignInOptions() {

        startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder()
                .setAvailableProviders(providers).setTheme(R.style.MyTheme).build(), MY_REQUEST_CODE );
    }

@Override
    protected void onActivityResult (int requestCode, int resultCode, @Nullable Intent data){
    Intent killIntent = new Intent("Finish_Activity");

        super.onActivityResult(requestCode,resultCode,data);
        //If the user request is accepted when.I.E they have stable internet connection a response is generated
        if(requestCode == MY_REQUEST_CODE){
            IdpResponse response = IdpResponse.fromResultIntent(data);
            if(resultCode != Activity.RESULT_CANCELED){

                //btn_sign_out.setEnabled(true);

                sendBroadcast(killIntent);
                final Intent createScreen = new Intent(this,ProfileCreation.class);
                startActivity(createScreen);

                finish();
                return;





            }
            else{
                //Flags an error if the login didn't go through due to loss of internet for example
                Log.w("ElseError", "Error");
               // Toast.makeText(this,""+response.getError().getMessage(), Toast.LENGTH_SHORT).show();

                finish();



            }
        }
    }
}
