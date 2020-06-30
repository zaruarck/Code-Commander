package com.example.CodeCommander;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
//import com.google.android.gms.ads.MobileAds;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;



public class MainMenu extends AppCompatActivity implements View.OnClickListener {
    Button signInBtn;
    Button createBtn;
    FirebaseUser user;
    TextView UserName;
    Button profilebtn;
    WebView mWebView;
    YouTubePlayer youTubePlayer;
    private AdView mAdView;
    AdRequest adRequest;
    private InterstitialAd mInterstitialAd;
    ImageView faceBook;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
                    @Override
                    public void onInitializationComplete(InitializationStatus initializationStatus) {
                    }
                });

        mAdView = findViewById(R.id.adView);
        adRequest = new AdRequest.Builder().build();

        mAdView.loadAd(adRequest);





        //signInBtn = findViewById(R.id.btn_signin);
        //signInBtn.setOnClickListener(this);
        //profilebtn = findViewById(R.id.btn_profile);
       // profilebtn.setOnClickListener(this);
       // createBtn = findViewById(R.id.btn_createscreen);
       // createBtn.setOnClickListener(this);
         user = FirebaseAuth.getInstance().getCurrentUser();
     //   UserName = findViewById(R.id.NameText);
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if(action.equals("Finish_Activity")){
                    finish();
                }
            }
        };

        Log.w("OnStart","Start");



















        setText();

    }



    @Override
    public void onClick(View view) {
        switch(view.getId()){
        /*    case R.id.btn_signin:
                String user_name = FirebaseAuth.getInstance().getUid();
                Toast.makeText(this,user_name,Toast.LENGTH_SHORT);
                user = FirebaseAuth.getInstance().getCurrentUser();

                try {
                    Log.w("Auth", user_name);

                }
                catch (Exception e){
                    Log.w("Error", e);
                }

               if(user!= null) {
                   FirebaseAuth.getInstance().signOut();
                   AuthUI.getInstance().signOut(MainMenu.this);
                   user = FirebaseAuth.getInstance().getCurrentUser();
                   setText();
                   Log.w("User", String.valueOf(user));

               }
               else{
                   final Intent intent = new Intent(this,Login.class);
                   startActivity(intent);
                   //finish();


               }
               // setText();




                break;*/
          /*  case R.id.btn_createscreen:
                Log.w("Createscreen","Ping");
                final Intent createScreen = new Intent(this,ProjectSelection.class);
                startActivity(createScreen);

                break;*/
           // case  R.id.btn_profile:
               // if(user !=null) {
                   // final Intent profileScreen = new Intent(this, ProfileCreation.class);
                    //startActivity(profileScreen);
              //  }
              //  else{
                //    Toast.makeText(getApplicationContext(), "You are not logged in", Toast.LENGTH_LONG);
              //  }
              //  break;


        }



    }

    public void setText(){
        if(user != null){
            //UserName.setText(user.getEmail());
            UserName.setText(user.getEmail());


            signInBtn.setText("Sign Out");
            Log.w("IfDebugger", String.valueOf(user.getEmail()));

        }
        else{
            Log.w("elseDebugger", "Test");
            UserName.setText("Name");
            signInBtn.setText("Login");
        }

    }


}
