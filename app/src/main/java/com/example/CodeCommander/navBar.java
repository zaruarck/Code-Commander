package com.example.CodeCommander;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class navBar extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    MenuItem login;
    ImageView createBtn;
    MenuItem profile;
    String user_name;
    BroadcastReceiver broadcastReceiver;
    String userLoggedIn;
    TextView userLogIn;
    NavigationView useruserLoggedIN;
    View headerview;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference currentUser;
    private AdView mAdView;
    AdRequest adRequest;
    private InterstitialAd mInterstitialAd;
    ImageView playBtn;
    ImageView faceBook;
    ImageView twitter;
    ImageView gitHub;
    ImageView instragram;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Creates a top nav bar making use of the main menu screen as the template
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_bar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        Intent i = new Intent(Intent.ACTION_VIEW);


        //Assigns alll the variables to buttons and imageviews displayed on the screen



        profile = navigationView.getMenu().findItem(R.id.nav_profile);
        login = navigationView.getMenu().findItem(R.id.login);
        createBtn = findViewById(R.id.btn_playbtn4);
        createBtn.setOnClickListener(this);
        useruserLoggedIN = navigationView;
        headerview = useruserLoggedIN.getHeaderView(0);
        userLogIn = headerview.findViewById(R.id.userLoggedIN);
        faceBook = findViewById(R.id.img_facebook);
        twitter = findViewById(R.id.img_twitter);
        instragram = findViewById(R.id.img_instragram);
        gitHub = findViewById(R.id.img_github);


        playBtn = findViewById(R.id.btn_playbtn);
        //Makes the buttons clickable and perform and action when clicked
        playBtn.setOnClickListener(this);
        faceBook.setOnClickListener(this);
        twitter.setOnClickListener(this);
        gitHub.setOnClickListener(this);
        instragram.setOnClickListener(this);


        mAdView = findViewById(R.id.adView);
        adRequest = new AdRequest.Builder().build();

        mAdView.loadAd(adRequest);


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());




         user_name = FirebaseAuth.getInstance().getUid();
         if(user_name!= null) {
              currentUser = database.getReference("Users").child(user_name);
         }




         broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if(action.equals("Finish_Activity")){
                    finish();
                }
            }
        };
        //If the user is logged in then display their username at the top bar if not then do not display anything
        if(user_name !=null) {
            login.setVisible(false);
            profile.setVisible(true);

            currentUser.addValueEventListener(new ValueEventListener() {
                                                  @Override
                                                  public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                      userLogIn.setText((dataSnapshot.child("userName").getValue().toString()));

                                                  }

                                                  @Override
                                                  public void onCancelled(@NonNull DatabaseError databaseError) {

                                                  }
                                              });



        }
        else{

            login.setVisible(true);
            profile.setVisible(false);
            userLogIn.setText("Code Commander");

        }




    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            FirebaseAuth.getInstance().signOut();
            AuthUI.getInstance().signOut(navBar.this);
            user_name = FirebaseAuth.getInstance().getUid();
            login.setVisible(true);
            profile.setVisible(false);
            currentUser.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    userLogIn.setText((dataSnapshot.child("userName").getValue().toString()));

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });







        }
        else {
            userLogIn.setText("Code Commander");
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        //Performs the corresponding activity when the user performs a click on a button within the navigation view







        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            final Intent profileScreen = new Intent(this, ProfileCreation.class);
            startActivity(profileScreen);
        } else if (id == R.id.login) {
            //Takes the user to the login screen
            final Intent intent = new Intent(this,Login.class);
            startActivity(intent);



        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        String url;
        switch (view.getId()){
            case R.id.btn_playbtn4:
                Log.w("Createbutton", "Hit");
                final Intent createScreen = new Intent(this,ProjectSelection.class);
                //Shows an add to the user. Currently only a temp add but could be changed for a real with ease

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                    Log.w("Ad","Ad");
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
                startActivity(createScreen);
                break;
            //Sets up the widgets for the pages taking the user to the designated sites
            case R.id.btn_playbtn:
                final Intent playSCreen = new Intent(this, PlayableLevelSelect.class);
                startActivity(playSCreen);
                break;
            case R.id.img_facebook:
                 url = "https://www.facebook.com/Code-Commander-106962880977755/?modal=admin_todo_tour";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                break;
            case R.id.img_github:
                 url = "https://github.com/zaruarck";
                Intent j = new Intent(Intent.ACTION_VIEW);
                j.setData(Uri.parse(url));
                startActivity(j);
                break;
            case R.id.img_twitter:
                url = "https://twitter.com/CodeCommander1";
                Intent k = new Intent(Intent.ACTION_VIEW);
                k.setData(Uri.parse(url));
                startActivity(k);
                break;









        }




    }
}
