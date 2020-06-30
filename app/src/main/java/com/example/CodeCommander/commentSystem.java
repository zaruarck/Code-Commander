package com.example.CodeCommander;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
//import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class commentSystem extends AppCompatActivity implements View.OnClickListener {
    private ImageButton postButton;

    private RecyclerView commentList;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference userRef;
    String firebaseUserId;
    DatabaseReference currentChallenge1;
    DatabaseReference currentChallenge2;
    DatabaseReference currentChallenge3;
    DatabaseReference currentChallenge4;
    DatabaseReference currentChallenge5;
    DatabaseReference currentUser;
    DatabaseReference currentUser1;
    DatabaseReference currentUser2;
    DatabaseReference currentUser3;
    DatabaseReference currentUser4;
    DatabaseReference currentUserChallenge1;
    FirebaseRecyclerAdapter recyclerAdapter;
    FirebaseUser userLoggedIn;
    int pageNumber;
    String userName;
    int i;
    Random rand = new Random();



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_system);

        //commentList = (RecyclerView) findViewById(R.id.commentList);

//        commentList.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        firebaseUserId = FirebaseAuth.getInstance().getUid();
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
//        commentList.setLayoutManager(linearLayoutManager);
         userLoggedIn = FirebaseAuth.getInstance().getCurrentUser();
        Intent mIntent = getIntent();
        pageNumber = mIntent.getIntExtra("Page_Number",0);
        i = rand.nextInt(1000);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("posts").push();
        Map<String, Object> map = new HashMap<>();
        map.put("id", databaseReference.getKey());
        map.put("title", "Dog");
        map.put("desc", "Bog");

        databaseReference.setValue(map);








        postButton = findViewById(R.id.postComment);
        postButton.setOnClickListener(this);



        currentUser = database.getReference("Challengess").child("Challenge 1");
        currentUser1 = database.getReference("Challengess").child("Challenge 2");
        DatabaseReference currentUserName = database.getReference("Users").child(firebaseUserId);

        currentUserName.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                userName = dataSnapshot.child("userName").getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




        //currentChallenge1 = currentUser.child("Challenge 1").push();



        //currentChallenge2 = currentUser.child("Challenge 2").push();
        //currentChallenge3 = currentUser.child("Challenge 3").push();
        //currentChallenge4 = currentUser.child("Challenge 4").push();
        //currentChallenge5 = currentUser.child("Challenge 5").push();



        Map currentUserPost;
        Map currentChallengeMap1;
        Map currentChallengeMap2;
        Map currentChallengeMap3;
        Map currentChallengeMap4;
        Map currentChallengeMap5;
        Map currentUserChallenge1;

        currentChallengeMap1 = new HashMap();
        currentChallengeMap1.put("Test", "test");
        currentChallengeMap2 = new HashMap();
        currentChallengeMap2.put("Test", "test");
        currentChallengeMap3 = new HashMap();
        currentChallengeMap3.put("Test", "test");
        currentChallengeMap4 = new HashMap();
        currentChallengeMap4.put("Test", "test");
        currentChallengeMap5 = new HashMap();
        currentChallengeMap5.put("Test", "test");





        //currentUserPost = new HashMap();
        //currentUserPost.put("Test", "Test");




        //currentUser.setValue(currentUserPost);
       // currentUser.setValue(currentChallengeMap1);
      //  currentUser1.setValue(currentChallengeMap2);
       // currentChallenge3.setValue(currentChallengeMap3);
        //currentChallenge4.setValue(currentChallengeMap4);
       // currentChallenge5.setValue(currentChallengeMap5);







    }

    @Override
    public void onClick(View view) {

        validateComment();



    }









    private void validateComment( ){
        EditText commentTextBox = findViewById(R.id.commentInput);
        final String commentText = commentTextBox.getText().toString();
        final TextView userNameTextBox = findViewById(R.id.txt_userName);
        final TextView dateTextBox = findViewById(R.id.txt_Date);
        final TextView commentAreaTextBox = findViewById(R.id.txt_CommentBox);
        final ConstraintLayout comment1 = findViewById(R.id.textBox1);

        comment1.setVisibility(View.INVISIBLE);

        i++;

        if(TextUtils.isEmpty(commentText)){
            Toast.makeText(this,"Please enter your comment within the field", Toast.LENGTH_LONG).show();
        }
        else{
            Calendar calDate = Calendar.getInstance();
            SimpleDateFormat currentDate = new SimpleDateFormat("dd-mm-yyyy");
            final String saveCurrentDate = currentDate.format(calDate.getTime());

            Calendar calTime = Calendar.getInstance();
            SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm");
            final String saveCurrentTime = currentTime.format(calDate.getTime());

            final String randomKey = firebaseUserId + saveCurrentDate + saveCurrentTime + i;

            HashMap commentMap = new HashMap();

            commentMap.put("UserID", userLoggedIn.toString());
            commentMap.put("Comments", commentText.toString());
            commentMap.put("Date", saveCurrentDate.toString());
            commentMap.put("Time", saveCurrentTime.toString());
            commentMap.put("UserName", userName.toString());

            if(pageNumber == 1){
                //currentUser = database.getReference("Challengess").child("Challenge 1").child(randomKey);
                currentUser.child(randomKey).updateChildren(commentMap).
                        addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            //finish();
                            userNameTextBox.setText(userName);
                            dateTextBox.setText(saveCurrentDate);
                            commentAreaTextBox.setText(commentText);
                            comment1.setVisibility(View.VISIBLE);
                        }

                    }
                });
            }
            if(pageNumber == 2){
                currentChallenge2.child(randomKey).updateChildren(commentMap).
                        addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    finish();
                                }

                            }
                        });
            }
            if(pageNumber == 3){
                currentChallenge3.child(randomKey).updateChildren(commentMap).
                        addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    finish();
                                }

                            }
                        });
            }
            if(pageNumber == 4){
                currentChallenge4.child(randomKey).updateChildren(commentMap).
                        addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    finish();
                                }

                            }
                        });
            }
            if(pageNumber == 5){
                currentChallenge5.child(randomKey).updateChildren(commentMap).
                        addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    finish();
                                }

                            }
                        });
            }

        }
    }

}
