package com.example.CodeCommander;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PlayableLevelSelect extends AppCompatActivity {
    ViewPager viewPager;

    PageAdapter pageAdapter;
    Boolean finalPage = false;
    Button startActivity;
    DatabaseReference currentChallenge;
    String firebaseUserId;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    TextView completion;
    int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playable_level_select);

        viewPager = findViewById(R.id.pager);

        pageAdapter = new PageAdapter(getSupportFragmentManager());
        pageAdapter.addFragnent(new level1Fragment(), "Red");
        pageAdapter.addFragnent(new level2Fragment(), "Red");
        pageAdapter.addFragnent(new level3Fragment(),"Red");
        pageAdapter.addFragnent(new level4Fragment(),"Red");
        firebaseUserId = FirebaseAuth.getInstance().getUid();
        DatabaseReference currentUser = database.getReference("Users").child(firebaseUserId);
        completion = findViewById(R.id.completedNew);

        currentChallenge = currentUser.child("Challenges");

        //Sets up the playable level selection screen which allows the user to navigate through each level


        currentChallenge.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //Makes use of the viewpager adapter in order to allow swiping through each fragment
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

















        viewPager.getCurrentItem();
        Log.w("Viewpager", String.valueOf(viewPager.getCurrentItem()));






    }
}
