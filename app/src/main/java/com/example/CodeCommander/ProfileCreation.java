package com.example.CodeCommander;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class ProfileCreation extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    EditText username;
    EditText bio;
    EditText language;
    boolean editMode = false;
    Button confirm;
    String firebaseUserId;
    String languageSelect = "";
    Spinner spinner;
    int spinnerID;
    DatabaseReference currentChallenge;
    DatabaseReference currentUserName;
    boolean challengeChecked = false;
    Map challengesPost;
    Button lockBtn;
    Boolean buttonLock = false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_creation);
        username = findViewById(R.id.edt_userName);
        bio = findViewById(R.id.edt_bio);
        confirm = findViewById(R.id.btn_confirm);
        confirm.setOnClickListener(this);
        spinner = findViewById(R.id.edt_language);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.ProgrammingChoices, R.layout.support_simple_spinner_dropdown_item);
        lockBtn = findViewById(R.id.btn_confirm2);
        lockBtn.setOnClickListener(this);


        spinner.setAdapter(adapter);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
         firebaseUserId = FirebaseAuth.getInstance().getUid();
        Log.w("Firebase ID", firebaseUserId);
        spinner.setOnItemSelectedListener(this);
        spinner.setSelection(spinnerID);


        DatabaseReference currentUser = database.getReference("Users").child(firebaseUserId);
        DatabaseReference userNames = database.getReference("UserName").child(firebaseUserId);

         currentChallenge = currentUser.child("Challenges");

         challengesPost = new HashMap();


        if(challengeChecked == false) {
            currentChallenge.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (challengeChecked == false) {

                        for (int i = 1; i < 6; i++) {
                            //checks the database to see if the user has already completed this challenge. If yes display a message to the user if not display a message saying it's not completed to the user
                            if (dataSnapshot.child("Challenge" + i).exists()) {
                                Log.w("Challenge", String.valueOf(dataSnapshot.child("Challenge" + i)));
                                challengesPost.put(dataSnapshot.child("Challenge"+i).getKey(), dataSnapshot.child("Challenge"+i).getValue());

                            } else {
                                challengesPost.put("Challenge" + i, false);


                            }
                        }
                        challengeChecked = true;
                    }


                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }


       // challengesPost.put("Challenge1", false  );




        Map newPost = new HashMap();

        //newPost.put("userName"," ");
        //newPost.put("bio", " ");
        //newPost.put("Language", languageSelect);

        //currentUser.setValue(newPost);

        currentUser.addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.child("LanguageID").getValue() != null){
                    Long lID = (Long) dataSnapshot.child("LanguageID").getValue();
                    spinner.setSelection(Math.toIntExact(lID));
                    username.setText(dataSnapshot.child("userName").getValue().toString());
                    bio.setText(dataSnapshot.child("bio").getValue().toString());

                }
                else{
                    spinner.setSelection(0);
                    username.setText("");
                    bio.setText("");

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });







    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_confirm:
            DatabaseReference currentUser = database.getReference("Users").child(firebaseUserId);

            Map newPost = new HashMap();
            Map newPost1 = new HashMap();

            newPost1.put("userName",username.getText().toString());

            newPost.put("userName", username.getText().toString());
            newPost.put("bio", bio.getText().toString());
            newPost.put("Language", languageSelect);
            newPost.put("LanguageID", spinnerID);

            currentUser.setValue(newPost);
            currentChallenge.setValue(challengesPost);

            Intent intent = new Intent(this, navBar.class);
            startActivity(intent);
            finish();


            case R.id.btn_confirm2:
                //Locks all the buttons when the user clicks the lock button. This stops from editing their detail by mistake.
                if (buttonLock == false) {
                    username.setClickable(false);
                    username.setFocusable(false);
                    username.setFocusableInTouchMode(false);
                    username.setLongClickable(false);
                    username.setInputType(InputType.TYPE_NULL);

                    bio.setClickable(false);
                    bio.setFocusable(false);
                    bio.setFocusableInTouchMode(false);
                    bio.setLongClickable(false);
                    bio.setInputType(InputType.TYPE_NULL);

                    spinner.setClickable(false);
                    spinner.setFocusable(false);
                    spinner.setFocusableInTouchMode(false);
                    spinner.setLongClickable(false);

                    lockBtn.setText("Unlock");
                    buttonLock = true;
                }

                else if (buttonLock == true) {
                    //Unlocks all the buttons when the user clicks the unlock button. Allows the user to edit their profile information.
                    username.setClickable(true);
                    username.setFocusable(true);
                    username.setFocusableInTouchMode(true);
                    username.setLongClickable(true);
                    username.setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);

                    bio.setClickable(true);
                    bio.setFocusable(true);
                    bio.setFocusableInTouchMode(true);
                    bio.setLongClickable(true);
                    bio.setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);

                    spinner.setClickable(true);
                    spinner.setFocusable(true);
                    spinner.setFocusableInTouchMode(true);
                    spinner.setLongClickable(true);

                    lockBtn.setText("Lock");
                    buttonLock = false;
                }
        }


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        languageSelect = spinner.getSelectedItem().toString();
        spinnerID = (int) spinner.getSelectedItemId();
        Log.w("Spinner Item", languageSelect);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
