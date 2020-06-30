package com.example.CodeCommander;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProjectSelection extends AppCompatActivity implements View.OnClickListener {
    String firebaseUserId;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    int page = 1;
    TextView completion;
    ImageView rightArrow;
    ImageView leftArrow;
    TextView levelNumber;
    DatabaseReference currentChallenge;
    Button startMain;
    Animation animSlide;
    ViewPager viewPager;

    PageAdapter pageAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_selection);
        completion = findViewById(R.id.completedNew);
      /*  rightArrow = findViewById(R.id.btn_rightArrow);
        leftArrow = findViewById(R.id.btn_leftArrow);
        startMain = findViewById(R.id.btn_startActivityProject);*/
        //startMain.setOnClickListener(this);
        /*rightArrow.setOnClickListener(this);
        leftArrow.setOnClickListener(this);*/
        //levelNumber = findViewById(R.id.txt_level);
       // levelNumber.setText("Level " + page );
        firebaseUserId = FirebaseAuth.getInstance().getUid();
        DatabaseReference currentUser = database.getReference("Users").child(firebaseUserId);
        //animSlide = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);

        viewPager = findViewById(R.id.pager1);

        pageAdapter = new PageAdapter(getSupportFragmentManager());
        pageAdapter.addFragnent(new createlevel1(), "Red");
        pageAdapter.addFragnent(new createlevel2(), "Red");
        pageAdapter.addFragnent(new createlevel3(),"Red");
        pageAdapter.addFragnent(new createlevel4(),"Red");
        //Sets up the creation level selection screen which allows the user to navigate through each level




         currentChallenge = currentUser.child("Challenges");

        currentChallenge.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.child("Challenge"+page).exists()){
                    if(dataSnapshot.child("Challenge"+page).getValue().equals(true)){
                        completion.setText("Completed");
                    }
                    else{
                        completion.setText("Not Completed");
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        viewPager.setAdapter(pageAdapter);




        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(int position) {
                //Makes use of the viewpager adapter in order to allow swiping through each fragment
                viewPager.getCurrentItem();
                page = viewPager.getCurrentItem() + 1;
                Log.w("Viewpager", String.valueOf(viewPager.getCurrentItem()));
                currentChallenge.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child("Challenge"+page).exists()){
                            if(dataSnapshot.child("Challenge"+page).getValue().equals(true)){
                                completion.setText("Completed");
                            }
                            else{
                                completion.setText("Not Completed");
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });




            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    @Override
    public void onClick(View view) {



        }




}
