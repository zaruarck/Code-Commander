package com.example.CodeCommander;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PointF;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;



import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


private int varaibleY;
private String variableName;
private int variableYTest;

//LayoutParams lp;
private String buttonClickVariableName;
private Map<Integer, String> blockPlacements;
private String buttonClick;
//private String[] testArray = {"if", "else"};
private ImageView ifBtn;
private ImageView elseBtn;
private ImageView elseIfbtn;
private ImageView whilebtn;
private ImageView whileDoBtn;
 ImageView forBtn;
 ImageView displayBtn;
 ImageView endBtn;

public ImageView integerBtn;
ImageView intBtn;
ImageView intVaraibleBtn;
ImageView stringBtn;
ImageView stringVariablebtn;
ImageView charBtn;
ImageView blockPlaceSpot;
ImageView equalsOperator;
ImageView plusOperator;
ImageView minusOperator;
ImageView charVariableBtn;
ImageView minusEqualOperator;
ImageView plusEqualOperator;
ImageView equalEqualOperator;
ImageView intVariableName1;
ImageView intVariableName2;
ImageView booleanBtn;
ImageView booleanVariableValue;
ImageView lowerThan;
ImageView greaterThan;
ImageView divisionBtn;
ImageView modulusBtn;
ImageView multiplyBtn;
ImageView lowerEqualThan;
ImageView greaterEqualThan;
ImageView notEqualBtn;
ImageView inputBtn;
ImageView arrayValue;
ImageView arrayName;
ImageView randomBlock;
ImageView andBlock;
ImageView plusPlusOperator;
private boolean snapOn = false;
private boolean snapOn2 = false;
private int finalPosY = 0;
private int finalPosX = 0;
private int Yvalue = 0;
private int yValueHigh = 0;
private int yValueLow  = 0;
int PointerY = 0;
private ImageView trashCan;
private ImageView commentBtn;
ImageButton commentBtn1;
boolean trashCanEnabled = false;
int diaLogNumber = 0;
int lineWithError;
private Map<Integer,String> blockXYPlacements;
int PointerX = 0;
MyScrollView scrollView;
MyHorizontalScrollView scrollHorizontalView;
private String variableAssignmentName;
private String variableAssignmentName1;
public int test = 0;
String intVariableName;
final String buttonClickedArray[] = {"equals"} ;
final String connectedBlock[] = {"intergerName","intergerVariable","equals","if","else","elseIf","display","end","for",
        "while","doWhile","stringName","stringVariable","charName","charVariable","booleanName","booleanVariable",
        "minus","plus","equal","equalEqual","multiply","modulus","plusEqual","minusEqual","lowerThan","greaterThan","lowerEqualThan","greaterEqualThan","notEqual","random","arrayName","arrayValue"};
final String connectingBlock[] = {"intergerName","intergerVariable","equals","if","else","elseIf","display","end","for",
        "while","doWhile","stringName","stringVariable","charName","charVariable","booleanName","booleanVariable",
        "minus","plus","equal","equalEqual","multiply","modulus","plusEqual","minusEqual","lowerThan","greaterThan","lowerEqualThan","greaterEqualThan","notEqual","random","arrayName","arrayValue"};
public TextView textViewCompiled;
int challengeNumber = 0;

TextView compiledCode;

int pageNumber;
Intent intent = new Intent();
int stepInChallenge = 1;
ViewPager viewPager;
PageAdapter pageAdapter;
Button btnCompiledNotCompiled;
Boolean isCompiledClicked = false;
int variableNumber = 1;
String variableInformation;
String variableInformation2;
String x,y,z,m,n = "";
String[] arr = {};
int[] arrInt = new int[6];
String numberChose = "";
Button hintView;











/*
toDo
Snap To Side is currently broke. Need to at least turn off snapon2 off when the backdrop goes off otherwise the user will snap straight to it if they try and drop block into top or bottom.
Snapon side also isn't snapping on the block at the side for unknown reasons. Seems to be getting the x and the y confused. Needs looking at.

*/


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        blockPlacements = new HashMap<Integer, String>();
        final LinearLayout sv = findViewById(R.id.scrollViewLinear);
        blockXYPlacements = new HashMap<Integer, String>();
        scrollView = findViewById(R.id.scrollViewMain);
        scrollHorizontalView = findViewById(R.id.horizontalScrollView);
        textViewCompiled = findViewById(R.id.textViewCompiled);
        compiledCode = findViewById(R.id.txt_compiledCodeBlock);
        compiledCode.setMovementMethod(new ScrollingMovementMethod());

        //Sets the variables to the views on screen
        whilebtn = findViewById(R.id.While);
        whileDoBtn = findViewById(R.id.doWhile);
        forBtn = findViewById(R.id.For);
        displayBtn = findViewById(R.id.Display);
        endBtn = findViewById(R.id.End);
        stringBtn = findViewById(R.id.String);
        stringVariablebtn = findViewById(R.id.stringVaraibleNamne);
        charBtn = findViewById(R.id.Char);
        charVariableBtn = findViewById(R.id.charVariableName);
        plusOperator = findViewById(R.id.Plus);
        minusOperator = findViewById(R.id.Minus);
        minusEqualOperator = findViewById(R.id.minusEqual);
        plusEqualOperator = findViewById(R.id.plusEqual);
        equalEqualOperator = findViewById(R.id.equalEqual);
        equalsOperator = findViewById(R.id.Equals);
        intBtn = (ImageView) findViewById(R.id.Integer);
        intVaraibleBtn = findViewById(R.id.IntergerVariable);
        elseIfbtn = findViewById(R.id.elseIf);
        ifBtn = (ImageView) findViewById(R.id.IF);
        elseBtn = findViewById(R.id.Else);
        booleanBtn = findViewById(R.id.Boolean);
        booleanVariableValue = findViewById(R.id.booleanVariableValue);
        lowerEqualThan = findViewById(R.id.lowerThanEqual);
        lowerThan = findViewById(R.id.lowerThan);
        greaterEqualThan = findViewById(R.id.greaterThanEqual);
        greaterThan = findViewById(R.id.greaterThan);
        modulusBtn = findViewById(R.id.Modulus);
        divisionBtn = findViewById(R.id.Division);
        multiplyBtn = findViewById(R.id.Multiply);
        notEqualBtn = findViewById(R.id.notEqual1);
        inputBtn = findViewById(R.id.Input);
        arrayName = findViewById(R.id.ArrayName);
        arrayValue = findViewById(R.id.ArrayValue);
        randomBlock = findViewById(R.id.Random);
        andBlock = findViewById(R.id.And);
        plusPlusOperator = findViewById(R.id.plusPlus);
        hintView = findViewById(R.id.Hint);


        //Set clickable the buttons as defined above
        stringBtn.setOnClickListener(this);
        randomBlock.setOnClickListener(this);
        arrayValue.setOnClickListener(this);
        andBlock.setOnClickListener(this);
        arrayName.setOnClickListener(this);
        equalEqualOperator.setOnClickListener(this);
        intBtn.setOnClickListener(this);
        intVaraibleBtn.setOnClickListener(this);
        elseIfbtn.setOnClickListener(this);
        ifBtn.setOnClickListener(this);
        elseBtn.setOnClickListener(this);
        whileDoBtn.setOnClickListener(this);
        equalsOperator.setOnClickListener(this);
        minusEqualOperator.setOnClickListener(this);
        plusEqualOperator.setOnClickListener(this);
        charVariableBtn.setOnClickListener(this);
        charBtn.setOnClickListener(this);
        endBtn.setOnClickListener(this);
        displayBtn.setOnClickListener(this);
        forBtn.setOnClickListener(this);
        whilebtn.setOnClickListener(this);
        minusOperator.setOnClickListener(this);
        plusOperator.setOnClickListener(this);
        stringVariablebtn.setOnClickListener(this);
        booleanBtn.setOnClickListener(this);
        booleanVariableValue.setOnClickListener(this);
        lowerEqualThan.setOnClickListener(this);
        lowerThan.setOnClickListener(this);
        greaterEqualThan.setOnClickListener(this);
        greaterThan.setOnClickListener(this);
        modulusBtn.setOnClickListener(this);
        divisionBtn.setOnClickListener(this);
        multiplyBtn.setOnClickListener(this);
        notEqualBtn.setOnClickListener(this);
        inputBtn.setOnClickListener(this);
        plusPlusOperator.setOnClickListener(this);
        hintView.setOnClickListener(this);

        btnCompiledNotCompiled = findViewById(R.id.btn_compiledNotCompiled);
        btnCompiledNotCompiled.setOnClickListener(this);






        viewPager = findViewById(R.id.pager2);

        pageAdapter = new PageAdapter(getSupportFragmentManager());











        Intent mIntent = getIntent();
         pageNumber = mIntent.getIntExtra("Page_Number",0);

        if(pageNumber == 1) {
            pageAdapter.addFragnent(new sidePanelInformationRock1(), "Red");
            pageAdapter.addFragnent(new sidePanelInformationRock2(), "Red");
            viewPager.setAdapter(pageAdapter);
        }
        else if(pageNumber == 2){
            pageAdapter.addFragnent(new sidePanelInformationNought1(), "Red");
            pageAdapter.addFragnent(new sidePanelInformationNought2(), "Red");
            viewPager.setAdapter(pageAdapter);
        }
        else if(pageNumber == 3){
            pageAdapter.addFragnent(new sidePanelInformationBubble1(), "Red");
            pageAdapter.addFragnent(new sidePanelInformationBubble2(), "Red");
            pageAdapter.addFragnent(new sidePanelInformationBubble3(), "Red");
            viewPager.setAdapter(pageAdapter);

        }
        else if (pageNumber == 4){
            pageAdapter.addFragnent(new sidePanelInformationLinear(),"red");
            viewPager.setAdapter(pageAdapter);
        }






        blockPlaceSpot = findViewById(R.id.blockPlace);


        trashCan = findViewById(R.id.trashCan);
        trashCan.setOnClickListener(this);

        scrollView = findViewById(R.id.scrollViewMain);
        //scrollView.setVerticalScrollBarEnabled(false);
       commentBtn1 = findViewById(R.id.btn_comment);
        commentBtn1.setOnClickListener(this);



        final Button start = findViewById(R.id.Check);

       Log.w("ScrollView", String.valueOf(sv.getScrollX()));
       Log.w("ScrollvIew Right", String.valueOf(elseBtn.getX()));
       if(pageNumber == 1){
             intent = new Intent(this,rockPaperScissors.class);

       }
       else if(pageNumber == 2){
             intent = new Intent(this,NoughtsAndCrossesWithMoreAdvancedAI.class);
       }

       else if(pageNumber == 3){
           intent = new Intent(this,bubbleSort.class);

       }

       else if (pageNumber == 4){
           intent = new Intent(this,linearSearch.class);

        }
       customDialogOpener();







//Sets the on click listener for each button or code block within the screen. This responds directly to the users input.
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TreeMap<Integer,String> sorted = new TreeMap<>(blockPlacements);

                Set<Map.Entry<Integer, String>> mappings = sorted.entrySet();

                Collection<String> values = sorted.values();
                final Dialog levelInformation1 = new Dialog(MainActivity.this);
                levelInformation1.requestWindowFeature(Window.FEATURE_NO_TITLE);
                levelInformation1.setContentView(R.layout.popupbox);

                final TextView levelInfo = levelInformation1.findViewById(R.id.txt_Instruct);
                Button nextBtn = levelInformation1.findViewById(R.id.Next);



                final String[] targetArray = values.toArray(new String[values.size()]);
                compiledCode();




                getResult(false);

                if(getResult(false) == true){
                    Log.w("GetResult", "True");
                    if(pageNumber == 1){
                        Log.w("GetResult", "True1");
                        if(stepInChallenge == 1){
                            Log.w("GetResult", "True2");
                            stepInChallenge++;
                            levelInfo.setText("Congratulations, You have completed the first step of this challenge. For this next step you will be tasked with deciding who wins between the players.  ");

                            levelInformation1.show();


                        }
                        else if(stepInChallenge == 2){
                            startActivity(intent);
                        }

                    }

                    else if(pageNumber == 2){
                        if(stepInChallenge == 1){
                            stepInChallenge++;
                            levelInfo.setText("Congratulations, You have completed the first step of this challenge. For this next step you will be tasked with getting the users input ");

                            levelInformation1.show();

                        }
                        else if (stepInChallenge == 2){
                            stepInChallenge++;
                            levelInfo.setText("Congratulations, You have completed the second step of this challenge. For this next step you will be tasked with deciding who wins between the players.  ");

                            levelInformation1.show();
                        }
                        else if (stepInChallenge == 3){
                            stepInChallenge++;
                            levelInfo.setText("Congratulations, You have completed the first step of this challenge. For this next step you will be tasked with creating an AI   ");

                            levelInformation1.show();
                        }
                        else if (stepInChallenge == 4){
                            startActivity(intent);
                        }
                    }
                    else if(pageNumber == 3){
                        if(stepInChallenge == 1){
                            startActivity(intent);

                    }
                        }
                    else if (pageNumber == 4){
                        if(stepInChallenge == 1){
                            stepInChallenge++;
                            levelInfo.setText("Congratulations, You have completed the first step of this challenge. For the next step you will iterate through this array until the number is found. ");

                            levelInformation1.show();
                        }
                        else if(stepInChallenge == 2){


                            intent.putExtra("arrInt", arrInt);
                            intent.putExtra("numberChosen",numberChose);

                            Log.w("Arrint", String.valueOf(arrInt[2]));





                            Log.w("arrays2", String.valueOf(numberChose));
                            startActivity(intent);
                        }
                        }
                    //startActivity(intent);
                }
                else{
                    Log.w("False", "False");
                    Toast.makeText(getApplicationContext(),"False, error at line" + lineWithError,Toast.LENGTH_LONG).show();
                }

                }

           // }
        });

    }




    private boolean compiledCode() {

        TreeMap<Integer,String> sorted = new TreeMap<>(blockPlacements);

        Set<Map.Entry<Integer, String>> mappings = sorted.entrySet();

        Collection<String> values = sorted.values();


        final String[] targetArray = values.toArray(new String[values.size()]);

        Log.w("targetarray", String.valueOf(targetArray.length));

        for (int i = 0; i < targetArray.length; i++){

            try {
                x = targetArray[i];
            }
            catch (Exception e){
                Log.w("Error","Error");
            }

            int variableCounter = 0;

            if(x == "if"){
                compiledCode.append("If(");
                for(int d = 0; d < targetArray.length; d++) {
                    y = targetArray[d];

                    if (y == "intergerName") {
                        compiledCode.append(" intergerName");
                        variableCounter++;


                    } else if (y == "equals") {
                        compiledCode.append(" =");
                        variableCounter++;
                    } else if (y == "intergerVariable") {
                        compiledCode.append(" intergerVariable");
                        variableCounter++;
                    }

                }
                compiledCode.append(")");

            }

            if(x == "else"){
                compiledCode.append("else \n {");
                compiledCode.append("}");
            }
            if (x == "stringName"){
                if(variableNumber == 1){
                    compiledCode.append(" String " + variableAssignmentName);
                    Log.w("Variablenumber1","Hit");


                }
            if(x == "stringVariable"){
                compiledCode.append(" String " + variableAssignmentName1);
            }

            }
            if(x == "equals"){
                compiledCode.append(" =");
            }
            if (x == "input"){
                compiledCode.append(" myInput.nextLine");
            }


        }


        return true;
    }


//Sets an on click listener for every button defined to it within the create function

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onClick(final View view){
        Log.w("Bigbutton1" , String.valueOf(view.getId()));
        //Sets up base variables for buttons being created
        final ImageView iv = new ImageView(getApplicationContext());
       final TextView tv = new TextView(getApplicationContext());

        //Creates the layout in which the newly created buttons will be assigned to. Uses the Wrap feature to ensure they don't go off the screen
        final LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        //Assigns the variable rL and rL1 to the main layout for the mainactivity XML
        final RelativeLayout rl = (RelativeLayout) findViewById(R.id.rlStine);
        final LayoutParams lp1 = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
       final RelativeLayout rl1 = (RelativeLayout) findViewById(R.id.rlStine);


        // Assigns the values to create each new button
        final int ifIntValue = 1;
        final int elseIntValue = 2;
        final int intergerNameValue = 3;
        final int intergerVariableName = 4;
        final int equalOperatorName = 5;
        final int elseIfValue = 6;
        final int minusEqualOperatorName = 7;
        final int plusOperatorName = 8;
        final int plusEqualOperatorName = 9;
        final int equalEqualOperatorName = 10;
        final int whileValue = 11;
        final int doWhileValue = 12;
        final int forValue = 13;
        final int displayValue = 14;
        final int stringNameValue = 15;
        final int stringVariableNameValue = 16;
        final int booleanVariableValue = 17;
        final int charNameValue = 18;
        final int charVariableNameValue = 19;
        final int endValue = 20;
        final int minusValue = 21;
        final int booleanValue = 22;
        final int lowerThanOperatorName = 23;
        final int lowerEqualOperatorName = 24;
        final int greaterThanOperatorName = 25;
        final int greaterEqualOperatorName = 26;
        final int modulusOperatorName = 27;
        final int divisionOperatorName = 28;
        final int multiplyOperatorName = 29;
        final int notEqualOperatorName = 30;
        final int inputValue = 31;
        final int random = 32;
        final int arrayNamne = 33;
        final int arrayValue = 34;
        final int  andValue = 35;
        final int plusPlus = 36;



        final ImageView backDrop = new ImageView(getApplicationContext());
        //final TextView variableNameTest = findViewById(R.id.VariableTextPlaceHolder);
       // final TextView variableNameTest1 = findViewById(R.id.variableTextPlaceHolder1);
        //variableNameTest.buildDrawingCache();
       // variableNameTest1.buildDrawingCache();





        //Begins a switch statment which tracks each individual button
        switch (view.getId()){



            case R.id.IF:

                //Sets the variable for the if the statment
                iv.setId(ifIntValue);
               // variableNameTest.setText("Dog");


                //Sets the name of the button clicked
                buttonClick = "if";
                Log.w("Bigbutton" ,"Working");

                // Set an image for ImageView
                iv.setImageDrawable(getDrawable(R.drawable.ifnewblock));


                Log.w("Test", String.valueOf(iv.getId()));

                // Create layout parameters for ImageView


                // Add rule to layout parameters
                // Add the ImageView below to Button


                lp.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());




                iv.setLayoutParams(lp);
                break;



            case R.id.Else:
                iv.setId(elseIntValue);
                buttonClick = "else";
                Log.w("Bigbutton" ,"Working");
                Log.w("Bigbutton1" , String.valueOf(view.getId()));

                iv.setImageDrawable(getDrawable(R.drawable.elsenewblock));



                Log.w("Test", String.valueOf(iv.getId()));


                lp.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());

                break;

            case R.id.Random:
                iv.setId(random);
                buttonClick = "random";
                Log.w("Bigbutton" ,"Working");
                Log.w("Bigbutton1" , String.valueOf(view.getId()));


                // Set an image for ImageView
                iv.setImageDrawable(getDrawable(R.drawable.randomblock));

                Log.w("Test", String.valueOf(iv.getId()));


                lp.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());

                break;


            case R.id.elseIf:
                iv.setId(elseIfValue);
                buttonClick = "elseIf";
                Log.w("Bigbutton" ,"Working");
                Log.w("Bigbutton1" , String.valueOf(view.getId()));




                // Set an image for ImageView
                iv.setImageDrawable(getDrawable(R.drawable.elseifnew));



                Log.w("Test", String.valueOf(iv.getId()));


                lp.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());


                break;

            case R.id.minusEqual:
                iv.setId(minusEqualOperatorName);
                buttonClick = "minusEqual";
                Log.w("Bigbutton" ,"Working");
                Log.w("Bigbutton1" , String.valueOf(view.getId()));



                // Set an image for ImageView
                iv.setImageDrawable(getDrawable(R.drawable.minusequalsnewblock));



                Log.w("Test", String.valueOf(iv.getId()));


                lp.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());


                break;


            case R.id.Plus:
                iv.setId(plusOperatorName);
                buttonClick = "plus";
                Log.w("Bigbutton" ,"Working");
                Log.w("Bigbutton1" , String.valueOf(view.getId()));


                iv.setImageDrawable(getDrawable(R.drawable.plusnewblock));


                Log.w("Test", String.valueOf(iv.getId()));


                lp.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());


                break;

            case R.id.plusEqual:
                iv.setId(plusEqualOperatorName);
                buttonClick = "plusequal";
                Log.w("Bigbutton" ,"Working");
                Log.w("Bigbutton1" , String.valueOf(view.getId()));







                iv.setImageDrawable(getDrawable(R.drawable.plusequalsnewblock));



                Log.w("Test", String.valueOf(iv.getId()));



                lp.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());


                break;

            case R.id.Display:
                iv.setId(displayValue);
                buttonClick = "display";
                Log.w("Bigbutton" ,"Working");
                Log.w("Bigbutton1" , String.valueOf(view.getId()));

                iv.setImageDrawable(getDrawable(R.drawable.displaynewblock));


                Log.w("Test", String.valueOf(iv.getId()));



                lp.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());

                break;

            case R.id.Input:
                iv.setId(inputValue);
                buttonClick = "input";
                Log.w("Bigbutton" ,"Working");
                Log.w("Bigbutton1" , String.valueOf(view.getId()));

                iv.setImageDrawable(getDrawable(R.drawable.inputnewblock));


                Log.w("Test", String.valueOf(iv.getId()));


                lp.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());


                break;

            case R.id.plusPlus:
                iv.setId(plusPlus);
                buttonClick = "plusPlus";
                Log.w("Bigbutton" ,"Working");
                Log.w("Bigbutton1" , String.valueOf(view.getId()));

                iv.setImageDrawable(getDrawable(R.drawable.plusplus));


                Log.w("Test", String.valueOf(iv.getId()));


                lp.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());

                break;

            case R.id.Hint:
                final Dialog levelInformation1 = new Dialog(MainActivity.this);
                levelInformation1.requestWindowFeature(Window.FEATURE_NO_TITLE);
                levelInformation1.setContentView(R.layout.popupbox);

                final TextView levelInfo = levelInformation1.findViewById(R.id.txt_Instruct);
                levelInfo.setText("Have you ensured all your blocks are in the right order? ");

                levelInformation1.show();

                break;



            case R.id.Equals:
                iv.setId(equalOperatorName);
                buttonClick = "equals";
                Log.w("Bigbutton" ,"Working");
                Log.w("Bigbutton1" , String.valueOf(view.getId()));



                // Set an image for ImageView
                iv.setImageDrawable(getDrawable(R.drawable.equalsnewblock));

                Log.w("Test", String.valueOf(iv.getId()));

                lp.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());


                break;

            case R.id.End:
                iv.setId(endValue);
                buttonClick = "end";
                Log.w("Bigbutton" ,"Working");
                Log.w("Bigbutton1" , String.valueOf(view.getId()));

                // Set an image for ImageView
                iv.setImageDrawable(getDrawable(R.drawable.endnewblock));



                Log.w("Test", String.valueOf(iv.getId()));


                lp.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());


                break;

            case R.id.While:
                iv.setId(whileValue);
                buttonClick = "while";
                Log.w("Bigbutton" ,"Working");
                Log.w("Bigbutton1" , String.valueOf(view.getId()));





                // Set an image for ImageView
                iv.setImageDrawable(getDrawable(R.drawable.whilenewblock));



                Log.w("Test", String.valueOf(iv.getId()));


                lp.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());

                break;

            case R.id.For:
                iv.setId(forValue);
                buttonClick = "for";
                Log.w("Bigbutton" ,"Working");
                Log.w("Bigbutton1" , String.valueOf(view.getId()));





                // Set an image for ImageView
                iv.setImageDrawable(getDrawable(R.drawable.fornewblock));



                Log.w("Test", String.valueOf(iv.getId()));
                // Create layout parameters for ImageView


                lp.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());


                break;


            case R.id.doWhile:
                iv.setId(doWhileValue);
                buttonClick = "dowhile";
                Log.w("Bigbutton" ,"Working");
                Log.w("Bigbutton1" , String.valueOf(view.getId()));




                // Set an image for ImageView
                iv.setImageDrawable(getDrawable(R.drawable.dowhilenewnblock));



                Log.w("Test", String.valueOf(iv.getId()));


                lp.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());

                //else if (test == 1) {
                //lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, btn1.getId());
                break;

            case R.id.Minus:
                iv.setId(minusValue);
                buttonClick = "minus";
                Log.w("Bigbutton" ,"Working");
                Log.w("Bigbutton1" , String.valueOf(view.getId()));


                // Set an image for ImageView
                iv.setImageDrawable(getDrawable(R.drawable.minusnewblock));


                Log.w("Test", String.valueOf(iv.getId()));



                lp.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());

                break;

            case R.id.And:
                iv.setId(andValue);
                buttonClick = "and";
                Log.w("Bigbutton" ,"Working");
                Log.w("Bigbutton1" , String.valueOf(view.getId()));





                // Set an image for ImageView
                iv.setImageDrawable(getDrawable(R.drawable.andblock));



                Log.w("Test", String.valueOf(iv.getId()));


                lp.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());

                //else if (test == 1) {
                //lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, btn1.getId());
                break;


            case R.id.equalEqual:
                iv.setId(equalEqualOperatorName);
                buttonClick = "equalequal";
                Log.w("Bigbutton" ,"Working");
                Log.w("Bigbutton1" , String.valueOf(view.getId()));





                iv.setImageDrawable(getDrawable(R.drawable.equalsequalsnewblock));



                Log.w("Test", String.valueOf(iv.getId()));

                lp.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());

                break;




            case R.id.Integer:
                //Used for testing out functionallty which has later been removed. Worth keeping in case the testing needs to be done again
                //String[] stringVariableName = {"Int Variable1"," Int Variable2"};





               // final ImageView imageviewtest = new ImageView(getApplicationContext());
                //final ImageView imageviewtest2 = new ImageView(getApplicationContext());



                final AlertDialog.Builder builder = new AlertDialog.Builder(this);

                final EditText input = new EditText(this);

                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);

                //Sets up a pop up box in order to obtain the users input
                builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        intVariableName = input.getText().toString();
                        iv.setImageDrawable(getDrawable(R.drawable.variablevalueblock));
                        lp.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());
                        lp1.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());
                        tv.setTypeface(Typeface.create("R.font.tomnr",Typeface.BOLD));
                        tv.setText(intVariableName);



                        tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        tv.setX(iv.getX() + 200);
                        tv.setY(iv.getY()+11);






                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                        iv.setId(intergerNameValue);

                        buttonClick = "intergerName";



                builder.show();
                test++;

                break;
            case R.id.IntergerVariable:
                final  AlertDialog.Builder builder1 = new AlertDialog.Builder(this);

                final EditText input1 = new EditText(this);

                input1.setInputType(InputType.TYPE_CLASS_TEXT);
                builder1.setView(input1);


                builder1.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        intVariableName = input1.getText().toString();
                        iv.setImageDrawable(getDrawable(R.drawable.variablevalueblock));
                        lp.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());
                        lp1.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());
                        tv.setText(intVariableName);
                        tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        tv.setX(iv.getX() + 200);
                        tv.setY(iv.getY()+11);
                        tv.setTypeface(null, Typeface.BOLD);
                        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
                        //Assigns variable when on step 1 of the challenge. Later used for the main acitivity
                        if (stepInChallenge == 1){
                            numberChose = intVariableName;
                        }

                    }
                });
                iv.setId(intergerVariableName);

                buttonClick = "intergerVariable";
                builder1.show();
                break;



            case R.id.String:
                final  AlertDialog.Builder builder2 = new AlertDialog.Builder(this);

                final EditText input2 = new EditText(this);

                input2.setInputType(InputType.TYPE_CLASS_TEXT);
                builder2.setView(input2);



                builder2.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        intVariableName = input2.getText().toString();
                        iv.setImageDrawable(getDrawable(R.drawable.variablevalueblock));
                        lp.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());
                        lp1.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());
                        tv.setText(intVariableName);
                        tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        tv.setX(iv.getX() + 200);
                        tv.setY(iv.getY()+11);
                        tv.setTypeface(null, Typeface.BOLD);
                        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
                        if(variableNumber == 1) {
                            //Assigns variable when variableNumber = 1
                            variableAssignmentName = intVariableName;

                            Log.w("VariableAssignment", variableAssignmentName);
                        }

                    }
                });
                iv.setId(stringNameValue);

                buttonClick = "stringName";


                builder2.show();
                break;

            case R.id.stringVaraibleNamne:
                final  AlertDialog.Builder builder3 = new AlertDialog.Builder(this);

                final EditText input3 = new EditText(this);

                input3.setInputType(InputType.TYPE_CLASS_TEXT);
                builder3.setView(input3);


                builder3.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        intVariableName = input3.getText().toString();
                        iv.setImageDrawable(getDrawable(R.drawable.variablevalueblock));
                        lp.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());
                        lp1.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());
                        tv.setText(intVariableName);
                        tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        tv.setX(iv.getX() + 200);
                        tv.setY(iv.getY()+11);
                        tv.setTypeface(null, Typeface.BOLD);
                        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
                        if(variableNumber == 1) {

                            variableAssignmentName1 = intVariableName;

                            Log.w("VariableAssignment", variableAssignmentName1);
                        }
                        if (stepInChallenge == 1){
                            //Creates a variable to later be used
                            numberChose = intVariableName;
                        }


                    }
                });
                iv.setId(stringVariableNameValue);

                buttonClick = "stringVariable";
                builder3.show();
                break;

            case R.id.Char:
                final  AlertDialog.Builder builder4 = new AlertDialog.Builder(this);

                final EditText input4 = new EditText(this);

                input4.setInputType(InputType.TYPE_CLASS_TEXT);
                builder4.setView(input4);


                builder4.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        intVariableName = input4.getText().toString();
                        iv.setImageDrawable(getDrawable(R.drawable.variablevalueblock));
                        lp.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());
                        lp1.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());
                        tv.setText(intVariableName);
                        tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        tv.setX(iv.getX() + 200);
                        tv.setY(iv.getY()+11);
                        tv.setTypeface(null, Typeface.BOLD);
                        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);

                    }
                });
                iv.setId(charNameValue);

                buttonClick = "charName";
                builder4.show();
                break;

            case R.id.charVariableName:
                final  AlertDialog.Builder builder5 = new AlertDialog.Builder(this);

                final EditText input5 = new EditText(this);

                input5.setInputType(InputType.TYPE_CLASS_TEXT);
                builder5.setView(input5);


                builder5.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        intVariableName = input5.getText().toString();
                        iv.setImageDrawable(getDrawable(R.drawable.variablevalueblock));
                        lp.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());
                        lp1.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());
                        tv.setText(intVariableName);
                        tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        tv.setX(iv.getX() + 200);
                        tv.setY(iv.getY()+11);
                        tv.setTypeface(null, Typeface.BOLD);
                        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);

                    }
                });
                iv.setId(charVariableNameValue);

                buttonClick = "charVariable";
                builder5.show();
                break;

            case R.id.Boolean:
                final  AlertDialog.Builder builder6 = new AlertDialog.Builder(this);

                final EditText input6 = new EditText(this);

                input6.setInputType(InputType.TYPE_CLASS_TEXT);
                builder6.setView(input6);


                builder6.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        intVariableName = input6.getText().toString();
                        iv.setImageDrawable(getDrawable(R.drawable.variablevalueblock));
                        lp.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());
                        lp1.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());
                        tv.setText(intVariableName);
                        tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        tv.setX(iv.getX() + 200);
                        tv.setY(iv.getY()+11);
                        tv.setTypeface(null, Typeface.BOLD);
                        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);

                    }
                });
                iv.setId(booleanValue);

                buttonClick = "booleanName";
                builder6.show();
                break;

            case R.id.booleanVariableValue:
                final  AlertDialog.Builder builder7 = new AlertDialog.Builder(this);

                final EditText input7 = new EditText(this);

                input7.setInputType(InputType.TYPE_CLASS_TEXT);
                builder7.setView(input7);


                builder7.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        intVariableName = input7.getText().toString();
                        iv.setImageDrawable(getDrawable(R.drawable.variablevalueblock));
                        lp.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());
                        lp1.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());
                        tv.setText(intVariableName);
                        tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        tv.setX(iv.getX() + 200);
                        tv.setY(iv.getY()+11);
                        tv.setTypeface(null, Typeface.BOLD);
                        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);

                    }
                });
                iv.setId(booleanVariableValue);

                buttonClick = "booleanVariable";
                builder7.show();
                break;

            case R.id.ArrayName:
                final  AlertDialog.Builder builder8 = new AlertDialog.Builder(this);

                final EditText input8 = new EditText(this);

                input8.setInputType(InputType.TYPE_CLASS_TEXT);
                builder8.setView(input8);
                builder8.setMessage("Enter series of numbers separated by a comma");


                builder8.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        intVariableName = input8.getText().toString();
                        iv.setImageDrawable(getDrawable(R.drawable.variablevalueblock));
                        lp.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());
                        lp1.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());
                        tv.setText(intVariableName);
                        tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        tv.setX(iv.getX() + 200);
                        tv.setY(iv.getY()+11);
                        tv.setTypeface(null, Typeface.BOLD);
                        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);

                    }
                });


                iv.setId(arrayNamne);

                buttonClick = "arrayName";
                builder8.show();
                break;
            case R.id.ArrayValue:
                final  AlertDialog.Builder builder9 = new AlertDialog.Builder(this);

                final EditText input9 = new EditText(this);
                input9.setFilters(new InputFilter[]{new InputFilter.LengthFilter(12)});
                input9.setInputType(InputType.TYPE_CLASS_TEXT);

               // input9.setInputType(InputType.TYPE_CLASS_TEXT);
                builder9.setView(input9);
                builder9.setMessage("Enter a series of 6 numbers separated commas");

                //Creates text box builder that allows the user to enter their variable.
                builder9.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        intVariableName = input9.getText().toString();
                      //  Integer intVariableNameInt = Integer.parseInt(intVariableName);
                        iv.setImageDrawable(getDrawable(R.drawable.variablevalueblock));
                        lp.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());
                        lp1.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());
                        tv.setText(intVariableName);
                        tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        tv.setX(iv.getX() + 100);
                        tv.setY(iv.getY()+11);
                        tv.setTypeface(null, Typeface.BOLD);
                        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
                        //Below code assigns user input to array which is then used for the lineaer search activity
                        if(stepInChallenge == 1){
                            try {
                                arr = intVariableName.split(",");
                            } catch (Exception e) {

                            }
                            try{
                                for(int j = 0; j <arr.length ;j++){
                                    arrInt[j] = Integer.parseInt(arr[j]);
                                    Log.w("Number", String.valueOf(arrInt[j]));
                                }
                            }
                            catch (Exception e){
                                Log.w("Error123123","error12123");

                            }

                            Log.w("Arr", String.valueOf(arr.length));

                        }

                    }
                });


                iv.setId(arrayValue);

                buttonClick = "arrayValue";
                builder9.show();
                break;



            case R.id.lowerThan:
                iv.setId(lowerThanOperatorName);
                buttonClick = "lowerThan";
                Log.w("Button clicked", "Test");
                iv.setImageDrawable(getDrawable(R.drawable.lowerthannewblock));
                lp.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());
                break;

            case R.id.lowerThanEqual:
                iv.setId(lowerEqualOperatorName);
                buttonClick = "lowerEqualThan";
                Log.w("Button clicked", "Test");
                iv.setImageDrawable(getDrawable(R.drawable.lowerthanequalnewblock));
                lp.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());
                break;

            case R.id.greaterThan:
                iv.setId(greaterThanOperatorName);
                buttonClick = "greaterThan";
                Log.w("Button clicked", "Test");
                iv.setImageDrawable(getDrawable(R.drawable.greaterthannewblock));
                lp.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());
                break;

            case R.id.greaterThanEqual:
                iv.setId(greaterEqualOperatorName);
                buttonClick = "greaterEqualThan";
                Log.w("Button clicked", "Test");
                iv.setImageDrawable(getDrawable(R.drawable.greaterthanequalnewblock));
                lp.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());
                break;

            case R.id.Division:
                iv.setId(divisionOperatorName);
                buttonClick = "division";
                Log.w("Button clicked", "Test");
                iv.setImageDrawable(getDrawable(R.drawable.divisionnewblock));
                lp.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());
                break;
            case R.id.Modulus:
                iv.setId(modulusOperatorName);
                buttonClick = "modulus";
                Log.w("Button clicked", "Test");
                iv.setImageDrawable(getDrawable(R.drawable.modulusnewblock));
                lp.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());
                break;

            case R.id.notEqual1:
                iv.setId(notEqualOperatorName);
                buttonClick = "notEqual";
                Log.w("Button clicked", "Test");
                iv.setImageDrawable(getDrawable(R.drawable.notequalnewblock));
                lp.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());
                break;


            case R.id.Multiply:
                iv.setId(multiplyOperatorName);
                buttonClick = "multiply";
                Log.w("Button clicked", "Test");
                iv.setImageDrawable(getDrawable(R.drawable.multiplynewblock));
                lp.addRule(RelativeLayout.ALIGN_START, blockPlaceSpot.getId());
                break;


            case R.id.trashCan:
                if(trashCanEnabled == true){

                    trashCan.setImageDrawable(getDrawable(R.drawable.trashcan));
                    trashCanEnabled = false;

                }
                else{
                    trashCan.setImageDrawable(getDrawable(R.drawable.cursoricon));
                    trashCanEnabled = true;

                }
                buttonClick = "trashcan";

                break;

            case R.id.btn_comment:
                Intent intent = new Intent(this,commentSystem.class);
                intent.putExtra("Page_Number", pageNumber);
                startActivity(intent);


        }
        if(buttonClick != "trashcan"){

            scrollView.setScrollY((int) blockPlaceSpot.getY() - 100);
            scrollHorizontalView.setScrollX(0) ;
            trashCan.setImageDrawable(getDrawable(R.drawable.trash));
            trashCanEnabled = false;


        }
        iv.setLayoutParams(lp);
        tv.setLayoutParams(lp1);


        //Gets the block the user is currently touching and begins the below set of code
        iv.setOnTouchListener(new OnTouchListener() {

            PointF DownPT = new PointF();
            PointF StartPT = new PointF();


            @Override

            public boolean onTouch(View view, MotionEvent motionEvent) {
               // final int x = (int) motionEvent.getRawX();
                int variableXHash = 0;

                Log.w("IntergerNameValue", String.valueOf(iv.getId()));

                //Sets the variabletestname variable depending on the value of the getID
                if(iv.getId() == ifIntValue){
                    buttonClickVariableName = "if";

                }
                else if(iv.getId() == elseIntValue){
                    buttonClickVariableName = "else";
                }
                else if(iv.getId() == intergerNameValue){
                    buttonClickVariableName = "intergerName";
                }
                else if(iv.getId() == intergerVariableName){
                    buttonClickVariableName = "intergerVariable";
                }
                else if(iv.getId() == equalOperatorName){
                    buttonClickVariableName = "equals";
                }
                else if(iv.getId() == elseIfValue){
                    buttonClickVariableName = "elseIf";
                }
                else if(iv.getId() == minusEqualOperatorName){
                    buttonClickVariableName = "minusEqual";
                }
                else if(iv.getId() == plusOperatorName){
                    buttonClickVariableName = "plus";
                }
                else if(iv.getId() == endValue){
                    buttonClickVariableName = "end";
                }
                else if(iv.getId() == displayValue){
                    buttonClickVariableName = "display";
                }
                else if(iv.getId() == whileValue){
                    buttonClickVariableName = "while";
                }
                else if(iv.getId() == doWhileValue){
                    buttonClickVariableName = "dowhile";
                }
                else if(iv.getId() == forValue){
                    buttonClickVariableName = "for";
                }
                else if(iv.getId() == equalEqualOperatorName){
                    buttonClickVariableName = "equalequal";

                } else if(iv.getId() == minusValue){
                    buttonClickVariableName = "minus";
                }
                else if(iv.getId() == stringNameValue){
                    buttonClickVariableName = "stringName";
                }
                else if(iv.getId() == stringVariableNameValue){
                    buttonClickVariableName = "stringVariable";
                }
                else if(iv.getId() == charNameValue){
                    buttonClickVariableName = "charName";
                }
                else if(iv.getId() == charVariableNameValue){
                    buttonClickVariableName = "charVariable";
                }

                else if(iv.getId() == booleanValue){
                    buttonClickVariableName = "booleanName";
                }
                else if(iv.getId() == greaterThanOperatorName){
                    buttonClickVariableName = "greaterThan";
                }
                else if(iv.getId() == greaterEqualOperatorName){
                    buttonClickVariableName = "greaterEqualThan";
                }
                else if(iv.getId() == lowerThanOperatorName){
                    buttonClickVariableName = "lowerThan";
                }
                else if(iv.getId() == lowerEqualOperatorName){
                    buttonClickVariableName = "lowerEqualThan";
                }
                else if(iv.getId() == notEqualOperatorName){
                    buttonClickVariableName = "notEqual";
                }
                else if(iv.getId() == modulusOperatorName){
                    buttonClickVariableName = "modulus";
                }
                else if(iv.getId() == multiplyOperatorName){
                    buttonClickVariableName = "multiply";
                }
                else if(iv.getId() == divisionOperatorName){
                    buttonClickVariableName = "division";
                }
                else if(iv.getId() == inputValue){
                    buttonClickVariableName = "input";
                }
                else if(iv.getId() == random){
                    buttonClickVariableName = "random";
                }
                else if(iv.getId() == arrayNamne){
                    buttonClickVariableName = "arrayName";
                }

                else if(iv.getId() == arrayValue){
                    buttonClickVariableName = "arrayValue";
                }
                else if(iv.getId() == andValue){
                    buttonClickVariableName = "and";
                }
                else if (iv.getId() == plusPlus){
                    buttonClickVariableName = "plusPlus";

                }







                Log.w("IntergerNameValue1", buttonClickVariableName);







                switch (motionEvent.getAction() & motionEvent.ACTION_MASK){
                    //Case statement for when the user is moving a block. This is different than when a user lets go or clicks on the block for a first time
                    case MotionEvent.ACTION_MOVE:
                        //Tracks the users point movement
                        iv.setX((int)StartPT.x + motionEvent.getX() - DownPT.x);
                        iv.setY((int)StartPT.y + motionEvent.getY() - DownPT.y);
                        StartPT.set(iv.getX(), iv.getY());
                        //Sets scroll view to false when moving a block. Otherwise application gets hung in a loop of trying to move the screen as well the block
                        scrollView.setScrolling(false);
                        scrollHorizontalView.setScrolling(false);
                        tv.setX(iv.getX() + 100);
                        tv.setY(iv.getY()+11);

                        Log.w("Rect", String.valueOf(iv.getX()));
                        boolean test = true;
                        Log.w("Snap", String.valueOf(snapOn2));



                         PointerY = (int) iv.getY();
                         PointerX = (int) iv.getX();
                         //Creates a new series of iterators used for parsing the hashtest constantly

                        Set<Map.Entry<Integer, String>> setOfEntries1 = blockXYPlacements.entrySet();

                        Iterator<Map.Entry<Integer, String>> iterator1 = setOfEntries1.iterator();

                        Set<Map.Entry<Integer, String>> buttonSideSnapSet = blockPlacements.entrySet();

                        Iterator<Map.Entry<Integer, String>> buttonSideSnapIterator = buttonSideSnapSet.iterator();
                        //Creates the overlay function. By iterating through the Xhashmap and Y haspmap and when it finds one with a parameter. It creates the overlay
                        while(iterator1.hasNext()){

                                Map.Entry<Integer, String> entry = iterator1.next();

                                //Sets the threshhold variables for the Yaxis
                                 Yvalue = entry.getKey();
                                 yValueHigh = entry.getKey() + 150;
                                 yValueLow = entry.getKey() - 150;
                                 int xValue = Integer.parseInt(entry.getValue());
                                 int xValueLeft = Integer.parseInt(entry.getValue()) - 200;
                                 int xValueRight = Integer.parseInt(entry.getValue()) + 200;
                                 Log.w("YValue", String.valueOf(Yvalue));
                                 Log.w("YValueHigh", String.valueOf(yValueHigh));
                                 Log.w("YValueLow", String.valueOf(yValueLow));

                                 Log.w("YvalueTesto", String.valueOf(PointerY));
                                 //backDrop.setVisibility(View.INVISIBLE);





                                if (PointerY >= yValueLow && PointerY <= Yvalue && PointerX >= xValueLeft && PointerX <= xValueRight) {
                                    //Sets the snapon to represent that it'll snap the block
                                    snapOn = true;
                                    finalPosY = Yvalue;
                                    finalPosX = xValue;

                                    Log.w("Touching", "Hit");
                                    Log.w("YValue", String.valueOf(Yvalue));
                                    //backDrop.setVisibility(View.VISIBLE);

                                    backDrop.setImageDrawable(getDrawable(R.drawable.newblock1));
                                    backDrop.setAlpha((float) 0.2);
                                    backDrop.setY( Yvalue - 70);
                                    backDrop.setX(xValue);



                                    //test = false;



                                }
                                //Snaps above the current block when triggered
                                else if(PointerY <= yValueHigh  && PointerY >= Yvalue && PointerX >= xValueLeft  && PointerX <= xValueRight){
                                    snapOn = true;
                                    finalPosY = Yvalue;
                                    finalPosX = xValue;

                                    Log.w("Touching", "Hit");
                                    Log.w("YValue", String.valueOf(Yvalue));


                                    backDrop.setImageDrawable(getDrawable(R.drawable.newblock1));
                                    backDrop.setAlpha((float) 0.2);
                                    backDrop.setY( Yvalue + 70);

                                    backDrop.setX(xValue);
                                }


                                 if(PointerY <= yValueHigh -100 && PointerY >= yValueLow +100 && PointerX >= xValue + 150 && PointerX <= xValueRight + 350 ) {

                                     //Checks to see if block can snap to the side. Currently this works with every block but with this piece of code only certain blocks could be snapped togther if desired


                                     while (buttonSideSnapIterator.hasNext()) {
                                         Map.Entry<Integer, String> buttonSideSnap = buttonSideSnapIterator.next();
                                         String buttonSideStepName = String.valueOf(buttonSideSnap.getValue());
                                         Log.w("Iterator",buttonSideStepName);


                                         for (String element : connectedBlock) {
                                             Log.w("ForLoopWorkling","ForloopWorks");
                                             if (element.equals(buttonSideStepName)) {
                                                 Log.w("ForLoopWorkling1","ForloopWorks1");
                                                 for(String element1 : connectingBlock) {
                                                     Log.w("ForLoopWorkling2",element1);

                                                     if(element1.equals(variableName)) {


                                                         snapOn2 = true;
                                                         finalPosY = Yvalue;
                                                         finalPosX = xValue;

                                                         backDrop.setImageDrawable(getDrawable(R.drawable.newblock1));
                                                         backDrop.setAlpha((float) 0.2);
                                                         backDrop.setY(Yvalue);

                                                         backDrop.setX(xValue + 300);
                                                         Log.w("Snapon2", "Snapon2 is true");
                                                     }
                                                 }
                                             }
                                         }
                                     }
                                 }

                                //If snapon is on and the cursor moves outside of the range then set the overlay to null

                                if(snapOn == true){
                                    if(iv.getY() <= finalPosY -150 || iv.getY() >= finalPosY +150 || iv.getX() >= finalPosX + 200 || iv.getX() <= finalPosX - 200 ) {

                                            backDrop.setImageDrawable(null);
                                            snapOn = false;


                                    }
                                }
                                if(snapOn2 == true){
                                    if(iv.getX() < finalPosX || iv.getX() > finalPosX + 400) {

                                        backDrop.setImageDrawable(null);
                                        snapOn2 = false;


                                    }

                                }
                        //If iterator entry is within array





                        }
                        break;
                        //When the user  presses the block begin this next section of code
                    case MotionEvent.ACTION_DOWN:
                        DownPT.set(motionEvent.getX(),motionEvent.getY());
                        StartPT.set(iv.getX(),iv.getY());
                        Log.w("Id", String.valueOf(iv.getId()));


                        variableYTest = (int) iv.getY();



                        Set<Map.Entry<Integer, String>> setOfEntries = blockPlacements.entrySet();

                        Iterator<Map.Entry<Integer, String>> iterator = setOfEntries.iterator();

                        Set<Map.Entry<Integer, String>> xyEntries = blockXYPlacements.entrySet();

                        Iterator<Map.Entry<Integer,String>> xyIterator = xyEntries.iterator();
                        //If the trashcan has been clicked and the user clicks a block remove the block from the view as well as from the haspmap
                        if(trashCanEnabled == true) {
                            if (buttonClick == "trashcan") {

                                Log.w("YValueTrashcan", String.valueOf(variableYTest));
                                iv.setImageDrawable(null);
                                tv.setVisibility(View.INVISIBLE);
                                while (iterator.hasNext()) {
                                    Map.Entry<Integer, String> entry = iterator.next();
                                    Integer value = entry.getKey();
                                    String variableEntryCheckName = entry.getValue();
                                    if ((value.equals(variableYTest))) {
                                        iterator.remove();

                                    }
                                }


                                while (xyIterator.hasNext()) {
                                    Map.Entry<Integer, String> entryXY = xyIterator.next();
                                    Integer value = entryXY.getKey();

                                    if ((value.equals(variableYTest))) {
                                        xyIterator.remove();

                                    }

                                }
                                Log.w("Hashtest1", blockPlacements.toString());
                                Log.w("VaraibleXY1", blockXYPlacements.toString());
                            }
                        }
                        //Checks the block the user is holding and updates the X and Y accoridingly in the hashmap
                        while(iterator.hasNext()){
                            Map.Entry<Integer,String> entry = iterator.next();
                            Integer value = entry.getKey();
                            String variableEntryCheckName = entry.getValue();
                            if ((value.equals(variableYTest))){
                                iterator.remove();

                            }
                            if(buttonClick != "trashcan") {
                                if (variableEntryCheckName.equals(buttonClickVariableName)) {
                                    buttonClick = buttonClickVariableName;


                                }
                            }

                        }
                        //Checks the block the user is holding and updates the X and Y accoridingly in the hashmap

                        while(xyIterator.hasNext()){
                            Map.Entry<Integer,String> entryXY = xyIterator.next();
                            Integer value = entryXY.getKey();

                            if ((value.equals(variableYTest))){
                                xyIterator.remove();

                            }

                        }

                        break;

                        //When the user lets go of a block trigger this section of code. Essentially places the block within the list which is then transformed into the hashmap in sorted order
                    case MotionEvent.ACTION_UP:
                        boolean breakElse = false;
                        varaibleY = (int) iv.getY();
                        int variableX = (int) iv.getX();
                        Log.w("VariableY", String.valueOf(iv.getY()));
                        Set<Map.Entry<Integer, String>> buttonVariableNameCheckerEntry = blockPlacements.entrySet();

                        Iterator<Map.Entry<Integer, String>> buttonVariableNameCheckerIterator = buttonVariableNameCheckerEntry.iterator();

                        Set<Map.Entry<Integer, String>> ifBlockInPlaceSet = blockXYPlacements.entrySet();
                        Iterator<Map.Entry<Integer, String>> ifBlockInPlaceIterator = ifBlockInPlaceSet.iterator();

                        //Ensures that the block the user click is the same one as before. This is to stop duplicate blocks being created ontop of each other.


                        switch (buttonClick) {
                            case "else":
                                variableName = "else";
                                Log.w("Image", String.valueOf(iv.getDrawable()));

                                break;
                            case "if":
                                variableName = "if";


                                Log.w("Image", String.valueOf(iv.getDrawable()));
                                break;

                            case "intergerName":
                                variableName = "intergerName";
                                break;
                            case "intergerVariable":
                                variableName = "intergerVariable";
                                break;
                            case "equals" :
                                variableName = "equals";
                                break;
                            case "elseIf":
                                variableName = "elseIf";
                                break;

                            case "minusEqual":
                                variableName = "minusEqual";
                                break;

                            case"plus":
                                variableName = "plus";
                                break;

                            case "end":
                                variableName = "end";
                                break;

                            case "for":
                                variableName = "for";
                                break;


                            case "display":
                                variableName = "display";
                                break;

                            case "while":
                                variableName = "while";
                                break;

                            case "minus":
                                variableName = "minus";
                                break;

                            case "do":
                                variableName = "dowhile";
                                break;

                            case "stringName":
                                variableName = "stringName";
                                break;
                            case "stringVariable":
                                variableName = "stringVariable";
                                break;
                            case "charName":
                                variableName = "charName";
                                break;
                            case "charVariable":
                                variableName = "charVariable";
                                break;
                            case "booleanName":
                                variableName = "booleanName";
                                break;
                            case "booleanVariable":
                                variableName = "booleanVariable";
                                break;
                            case "division":
                                variableName = "division";
                                break;
                            case "lowerThan":
                                variableName = "lowerThan";
                                break;

                            case "greaterThan":
                                variableName = "greaterThan";
                                break;
                            case "greaterEqualThan":
                                variableName = "greaterEqualThan";
                                break;

                            case "multiply":
                                variableName = "multiply";
                                break;

                            case "notEqual":
                                variableName = "notEqual";
                                break;

                            case "modulus":
                                variableName = "modulus";
                                break;
                            case "input":
                                variableName = "input";
                                break;
                            case "random":
                                variableName = "random";
                                break;

                            case "arrayName":
                                variableName = "arrayName";
                                break;
                            case "arrayValue":
                                variableName = "arrayValue";
                                break;
                            case "and":
                                variableName = "and";
                                break;
                            case "plusPlus":
                                variableName = "plusPlus";
                                break;
                            case "equalequal":
                                variableName = "equalequal";
                                break;








                        }

                        if(snapOn == true) {
                            //Snaps to the X axis of blocks if they within a certain distance

                        if (iv.getY() <= finalPosY + 150 && iv.getY() >= finalPosY) {
                            if (iv.getX() >= finalPosX - 200 && iv.getX() <= finalPosX + 200) {
                                while (ifBlockInPlaceIterator.hasNext()) {
                                    Map.Entry<Integer, String> blockChecker = ifBlockInPlaceIterator.next();
                                    Integer blockCheckY = blockChecker.getKey();
                                    Integer blockCheckX = Integer.valueOf(blockChecker.getValue());

                                    if (iv.getY() + 120 >= blockCheckY && iv.getY() + 120 <= blockCheckY + 100 && iv.getX() == blockCheckX && breakElse == false) {
                                        breakElse = true;
                                        Log.w("ValueY", String.valueOf(iv.getY()));
                                        iv.setY(blockPlaceSpot.getY());
                                        iv.setX(blockPlaceSpot.getX());
                                        tv.setX(iv.getX() + 100);
                                        tv.setY(iv.getY()+11);

                                        varaibleY = (int) iv.getY();
                                        variableX = (int) iv.getX();

                                        Log.w("Y", String.valueOf(iv.getY()));


                                    }

                                    else {
                                        if (breakElse == false) {
                                            Log.w("ValueY", String.valueOf(iv.getY()));
                                            Log.w("ValueY List", String.valueOf(blockCheckY));
                                            iv.setY(finalPosY + 70);
                                            iv.setX(finalPosX);
                                            tv.setX(iv.getX() + 100);
                                            tv.setY(iv.getY()+11);

                                            varaibleY = finalPosY + 70;
                                            variableX = finalPosX;

                                        }
                                    }
                                }
                                //backDrop.setVisibility(View.INVISIBLE);
                                //backDrop.setImageDrawable(null);
                            }
                        }
                        else if (iv.getY() >= finalPosY - 150 && iv.getY() <= finalPosY) {
                            if (iv.getX() >= finalPosX - 200 && iv.getX() <= finalPosX + 200) {
                                while (ifBlockInPlaceIterator.hasNext()) {
                                    Map.Entry<Integer, String> blockChecker = ifBlockInPlaceIterator.next();
                                    Integer blockCheckY = blockChecker.getKey();
                                    Integer blockCheckX = Integer.valueOf(blockChecker.getValue());
                                    if (iv.getY() - 120 <= blockCheckY && iv.getY() - 120 >= blockCheckY - 100 && breakElse == false) {
                                        breakElse = true;
                                        Log.w("ValueY", String.valueOf(iv.getY()));
                                        iv.setY(blockPlaceSpot.getY());
                                        iv.setX(blockPlaceSpot.getX());
                                        tv.setX(iv.getX() + 100);
                                        tv.setY(iv.getY()+11);
                                        varaibleY = (int) iv.getY();
                                        variableX = (int) iv.getX();

                                        Log.w("Y", String.valueOf(iv.getY()));
                                        break;
                                    } else {

                                        iv.setY(finalPosY - 70);
                                        iv.setX(finalPosX);
                                        varaibleY = finalPosY - 70;
                                        variableX = finalPosX;
                                        tv.setX(iv.getX() + 100);
                                        tv.setY(iv.getY()+11);

                                    }

                                    //backDrop.setVisibility(View.INVISIBLE);
                                    //backDrop.setImageDrawable(null);
                                }
                            }


                        }
                        //Needs iteration added to it to make sure it checks the variable name is within the variable name array


                    }

                        //Snaps the textview as well as the block to the x axis. If for example the block had user input.
                        if (snapOn2 == true) {
                            Log.w("Snapon23", "test");
                            while (buttonVariableNameCheckerIterator.hasNext()) {
                                Map.Entry<Integer, String> entry = buttonVariableNameCheckerIterator.next();
                                Integer valueY = entry.getKey();
                                String valueName = entry.getValue();
                                int valueYLow = (int) (iv.getY() - 150);
                                int valueYHigh = (int) (iv.getY() + 150);

                                if (valueY >= valueYLow && valueY <= valueYHigh) {
                                    //for(String element : buttonClickedArray ){
                                    //if (element.equals(valueName)){
                                    if (iv.getY() >= finalPosY - 150 && iv.getY() <= finalPosY + 150) {
                                        if (iv.getX() >= finalPosX - 600 && iv.getX() <= finalPosX + 600) {
                                            iv.setY(finalPosY + 1);
                                            Log.w("IDTEST", String.valueOf(iv.getId()));
                                            iv.setX(finalPosX + 350);
                                            varaibleY = finalPosY + 1;
                                            variableX = finalPosX + 350;
                                            buttonClick = buttonClickVariableName;


                                            tv.setX(iv.getX() + 100);
                                            tv.setY(iv.getY()+13);
                                        }

                                    }


                                }
                            }
                        }






                        //Removes the backdrop outline

                        backDrop.setImageDrawable(null);
                        snapOn = false;
                        snapOn2 = false;
                        Log.w("VariableName", variableName);

                        Set<Map.Entry<Integer, String>> setOfEntries3 = blockPlacements.entrySet();

                        Iterator<Map.Entry<Integer, String>> iterator3 = setOfEntries3.iterator();

                        if(iv.getY() >= trashCan.getY() -50 && iv.getY() <= trashCan.getY() +50 && iv.getX() >= trashCan.getX() - 200 && iv.getX() <= trashCan.getX() +200) {

                        }
                        else {
                            if(buttonClick != "trashcan") {
                                Log.w("ButtonclickTrashCan","Test");

                                blockPlacements.put(varaibleY, variableName);
                                // Log.w()


                                blockXYPlacements.put(varaibleY, String.valueOf(variableX));
                                breakElse = false;
                                Log.w("Hashtest", blockPlacements.toString());
                                Log.w("VaraibleXY", blockXYPlacements.toString());
                            }
                        }
                        scrollView.setScrolling(true);
                        scrollHorizontalView.setScrolling(true);
                        if(buttonClick != "trashcan") {
                            blockPlacements.put(varaibleY, variableName);
                            // Log.w()


                            blockXYPlacements.put(varaibleY, String.valueOf(variableX));
                        }











                }

                return true;
            }
        });




        rl.addView(iv);
        rl.addView(backDrop);
        rl.addView(tv);




    }
    //Searched whenever the user hits the run button. Checks to see if their answers are correct.
    public boolean  getResult(boolean x){

        //Each correct answer is stored in order inside of arrays specific to each challenge. Some have multiple ways of solving so have multiple arrays for them
         String[] testArray = {"if", "elseIf"};
        String[] rockPaper = {"stringName", "equals","input","stringName","equals","random"};
        String[] rockPaper1 = {"if", "stringName","equals","stringVariable","and","stringName","equals","stringVariable","end","if", "stringName","equals","stringVariable","and","stringName","equals","stringVariable","end",
                "if", "stringName","equals","stringVariable","and","stringName","equals","stringVariable","end","if", "stringName","equals","stringVariable","and","stringName","equals","stringVariable","end",
                "if", "stringName","equals","stringVariable","and","stringName","equals","stringVariable","end","if", "stringName","equals","stringVariable","and","stringName","equals","stringVariable","end","else","end"};
        String[] rockPaper2 = {"if", "stringName","equals","stringVariable","and","stringName","equals","stringVariable","dispay","end","if", "stringName","equals","stringVariable","and","stringName","equals","stringVariable","dispay","end",
                "if", "stringName","equals","stringVariable","and","stringName","equals","stringVariable","dispay","end","if", "stringName","equals","stringVariable","and","stringName","equals","stringVariable","dispay","end",
                "if", "stringName","equals","stringVariable","and","stringName","equals","stringVariable","dispay","end","if", "stringName","equals","stringVariable","and","stringName","equals","stringVariable","dispay","end","else","dispay","end"};
        String[] rockPaper3 = {"if", "stringName","equals","stringVariable","and","stringName","equals","stringVariable","end","elseIf", "stringName","equals","stringVariable","and","stringName","equals","stringVariable","end",
                "elseIf", "stringName","equals","stringVariable","and","stringName","equals","stringVariable","end","elseIf", "stringName","equals","stringVariable","and","stringName","equals","stringVariable","end",
                "elseIf", "stringName","equals","stringVariable","and","stringName","equals","stringVariable","end","elseIf", "stringName","equals","stringVariable","and","stringName","equals","stringVariable","end","else","end"};
        String[] rockPaper4 = {"if", "stringName","equals","stringVariable","and","stringName","equals","stringVariable","end","elseIf", "stringName","equals","stringVariable","and","stringName","equals","stringVariable","end",
                "elseIf", "stringName","equals","stringVariable","and","stringName","equals","stringVariable","end","elseIf", "stringName","equals","stringVariable","and","stringName","equals","stringVariable","end",
                "elseIf", "stringName","equals","stringVariable","and","stringName","equals","stringVariable","end","elseIf", "stringName","equals","stringVariable","and","stringName","equals","stringVariable","end",
                "elseIf", "stringName","equals","stringVariable","and","stringName","equals","stringVariable","end","elseIf", "stringName","equals","stringVariable","and","stringName","equals","stringVariable","end",
                "elseIf", "stringName","equals","stringVariable","and","stringName","equals","stringVariable","end"};
        String[] rockPaper5 = {"if", "stringName","equals","stringVariable","and","stringName","equals","stringVariable","end"};

        String[] noughtAndCrosses1 = {"arrayValue","arrayValue","for","intergerName","equals","intergerVariable","intergerName","lowerThan","arrayValue","intergerName","plusPlus","if","arrayValue","intergerName","equals","intergerVariable",
                "arrayValue","equals","stringVaraible","display"};
        String [] noughtAndCrosses2 = {"stringName","equals","stringVariable","stringName","equals","stringVariable","stringName","equals","input","stringName","equals","input","arrayValue","stringName"};

        String [] noughtAndCrosses3 = {"for","intergerName","equals","intergerVariable","intergerName","lowerThan","intergerVariable","intergerName","plusPlus", "for","intergerName","equals","intergerVariable","intergerName","lowerThan","intergerVariable","intergerName","plusPlus",
                "arrayValue","arrayValue","equals","arrayValue","arrayValue",
                "for","intergerName","equals","intergerVariable","intergerName","lowerThan","intergerVariable","intergerName","plusPlus","if","arrayValue","intergerVariable","arrayValue","intergerVariable","equals","arrayValue","intergerVariable","arrayValue","intergerVariable",
                "and","arrayValue","intergerVariable","arrayValue","intergerVariable","equals","arrayValue","intergerVariable","arrayValue","intergerVariable","and","arrayValue","intergerVariable","arrayValue","intergerVariable","equals","arrayValue","intergerVariable","arrayValue","intergerVariable",
                 "for","intergerName","equals","intergerVariable","intergerName","lowerThan","intergerVariable","intergerName","plusPlus","if","arrayValue","intergerVariable","arrayValue","intergerVariable","equals","arrayValue","intergerVariable","arrayValue","intergerVariable",
                 "and","arrayValue","intergerVariable","arrayValue","intergerVariable","equals","arrayValue","intergerVariable","arrayValue","intergerVariable","and","arrayValue","intergerVariable","arrayValue","intergerVariable","equals","arrayValue","intergerVariable","arrayValue","intergerVariable",
        };
        String [] noughtAndCrosses4 = {"stringName","equals","random"};
        String[] bubbleSort1 = {"arrayValue","for","intergerName","equals","intergerVariable","intergerName","lowerThan","arrayValue","minus","intergerVariable","intergerName","plusPlus","for","intergerName","equals","intergerVariable","intergerName","lowerThan","arrayValue","minus","intergerName","minus",
                "intergerVariable","intergerName","plusPlus","if","arrayValue","intergerName","greaterThan","arrayValue","intergerName","plus","intergerVariable","intergerName", "equals","arrayValue","intergerName","arrayValue",
                "intergerName","equals","arrayValue","intergerName","plus","intergerVariable","arrayValue","intergerName","plus","intergerVariable","equals","intergerName"};
        String[] lineaerSearch = {"arrayName","equals","arrayValue","intergerName","equals","intergerVariable"};
        String[] lineaerSearch1 = {"for","intergerName", "equals","intergerVariable","intergerName","lowerThan","arrayName","intergerName","plusPlus","if","arrayName","intergerName","equalequal","intergerName"};
        String[] lineaerSearch2 = {"if","arrayName","intergerName","equalequal","intergerName"};
        String[] lineaerSearch3 = {"if"};

        //Sorts the users answers into an order based upon their Y positions




        TreeMap<Integer,String> sorted = new TreeMap<>(blockPlacements);

        Set<Map.Entry<Integer, String>> mappings = sorted.entrySet();

        Collection<String> values = sorted.values();
        //TextView instructions = findViewById(R.id.txt_Instruct);
        //instructions.setText("Dog");

        final String[] targetArray = values.toArray(new String[values.size()]);
        //Pagenumber equals the different challenge 1 - Rock Paper, 2 - Nought And Crosses - 3 Bubble Sort - 4 Linear search. Prehaps string names would have worked better?
        //Step in challenge is the stage the user is on for the challenge.
        if(pageNumber == 1 ){
            if(stepInChallenge == 1){
                if(java.util.Arrays.deepEquals(rockPaper,targetArray)){
                    return true;
                }
                else {
                    for(int i = 0; i < rockPaper.length; i++){
                        String k = rockPaper[i];
                        String j = "";
                        try {
                             j = targetArray[i];
                             Log.w("Log1","log1");
                        }
                        catch (Exception e){
                            lineWithError = rockPaper.length+1;
                            Log.w("Log2","log2");
                        }

                        if (k != j){
                            lineWithError = i+1;
                            Log.w("Log3","log3");
                            break;

                        }
                    }
                    return false;
                }

            }
            else if(stepInChallenge == 2){
                if(java.util.Arrays.deepEquals(rockPaper1,targetArray) || java.util.Arrays.deepEquals(rockPaper2,targetArray)  || java.util.Arrays.deepEquals(rockPaper3,targetArray) || java.util.Arrays.deepEquals(rockPaper4,targetArray) || java.util.Arrays.deepEquals(rockPaper5,targetArray)  ){
                    return true;
                }
                else {
                    for(int i = 0; i < rockPaper2.length; i++){
                        String k = rockPaper[i];
                        String j = "";
                        try {
                            j = targetArray[i];
                            Log.w("Log1","log1");
                        }
                        catch (Exception e){
                            lineWithError = rockPaper.length+1;
                            Log.w("Log2","log2");
                        }

                        if (k != j){
                            lineWithError = i+1;
                            Log.w("Log3","log3");
                            break;

                        }
                    }
                    return false;
                }
            }
        }

        else if( pageNumber == 2) {
            if(stepInChallenge == 1) {
                if (java.util.Arrays.deepEquals(noughtAndCrosses1, targetArray)) {
                    return true;

                } else {
                    for(int i = 0; i < noughtAndCrosses1.length; i++){
                        String k = noughtAndCrosses1[i];
                        String j = "";
                        try {
                            j = targetArray[i];
                            Log.w("Log1","log1");
                        }
                        catch (Exception e){
                            lineWithError = noughtAndCrosses1.length+1;
                            Log.w("Log2","log2");
                        }

                        if (k != j){
                            lineWithError = i+1;
                            Log.w("Log3","log3");
                            break;

                        }
                    }
                    return false;
                }
            }
            else if(stepInChallenge == 2){
                if (java.util.Arrays.deepEquals(noughtAndCrosses2, targetArray)) {
                    return true;

                } else {
                    for(int i = 0; i < noughtAndCrosses2.length; i++){
                        String k = noughtAndCrosses2[i];
                        String j = "";
                        try {
                            j = targetArray[i];
                            Log.w("Log1","log1");
                        }
                        catch (Exception e){
                            lineWithError = noughtAndCrosses2.length+1;
                            Log.w("Log2","log2");
                        }

                        if (k != j){
                            lineWithError = i+1;
                            Log.w("Log3","log3");
                            break;

                        }
                    }
                    return false;
                }

            }
            else if(stepInChallenge == 3){
                if (java.util.Arrays.deepEquals(noughtAndCrosses3, targetArray)) {
                    return true;

                } else {
                    for(int i = 0; i < noughtAndCrosses3.length; i++){
                        String k = noughtAndCrosses3[i];
                        String j = "";
                        try {
                            j = targetArray[i];
                            Log.w("Log1","log1");
                        }
                        catch (Exception e){
                            lineWithError = noughtAndCrosses3.length+1;
                            Log.w("Log2","log2");
                        }

                        if (k != j){
                            lineWithError = i+1;
                            Log.w("Log3","log3");
                            break;

                        }
                    }
                    return false;
                }

            }
            else if(stepInChallenge == 4){
                if (java.util.Arrays.deepEquals(noughtAndCrosses4, targetArray)) {
                    return true;

                } else {
                    for(int i = 0; i < noughtAndCrosses4.length; i++){
                        String k = rockPaper[i];
                        String j = "";
                        try {
                            j = targetArray[i];
                            Log.w("Log1","log1");
                        }
                        catch (Exception e){
                            lineWithError = noughtAndCrosses4.length+1;
                            Log.w("Log2","log2");
                        }

                        if (k != j){
                            lineWithError = i+1;
                            Log.w("Log3","log3");
                            break;

                        }
                    }
                    return false;
                }

            }




        }
        else if(pageNumber == 3 ){
            Log.w("Why does this not ?","Test");
            if(stepInChallenge == 1){
                if (java.util.Arrays.deepEquals(bubbleSort1, targetArray)) {
                    return true;
                }
                else {
                    for(int i = 0; i < bubbleSort1.length; i++){
                        String k = bubbleSort1[i];
                        String j = "";
                        try {
                            j = targetArray[i];
                            Log.w("Log1","log1");
                        }
                        catch (Exception e){
                            lineWithError = bubbleSort1.length+1;
                            Log.w("Log2","log2");
                        }

                        if (k != j){
                            lineWithError = i+1;
                            Log.w("Log3","log3");
                            break;

                        }
                    }
                    return false;
                }

            }


        }

        else if(pageNumber == 4 ){
            Log.w("Why does this not ?","Test");
            if(stepInChallenge == 1){
                Log.w("Why does this not work?","Test");
                if (java.util.Arrays.deepEquals(lineaerSearch, targetArray)) {
                    return true;
                }
                else {
                    for(int i = 0; i < lineaerSearch.length; i++){
                        String k = lineaerSearch[i];
                        String j = "";
                        try {
                            j = targetArray[i];
                            Log.w("Log1","log1");
                        }
                        catch (Exception e){
                            lineWithError = lineaerSearch.length+1;
                            Log.w("Log2","log2");
                        }

                        if (k != j){
                            lineWithError = i+1;
                            Log.w("Log3","log3");
                            break;

                        }
                    }
                    return false;
                }

            }
            else if(stepInChallenge == 2){
                if (java.util.Arrays.deepEquals(lineaerSearch1, targetArray) || java.util.Arrays.deepEquals(lineaerSearch2,targetArray) || java.util.Arrays.deepEquals(lineaerSearch3,targetArray)) {
                    return true;
                }
                else {
                    for(int i = 0; i < lineaerSearch1.length; i++){
                        String k = lineaerSearch1[i];
                        String j = "";
                        try {
                            j = targetArray[i];
                            Log.w("Log1","log1");
                        }
                        catch (Exception e){
                            lineWithError = lineaerSearch1.length+1;
                            Log.w("Log2","log2");
                        }

                        if (k != j){
                            lineWithError = i+1;
                            Log.w("Log3","log3");
                            break;

                        }
                    }
                    return false;
                }

            }


        }




        return false;
    }

    public void customDialogOpener(){
        //Opens the text boxes when the user starts the activity. Text differs depending on the acitivity chosen.

        final Dialog levelInformation = new Dialog(MainActivity.this);
        levelInformation.requestWindowFeature(Window.FEATURE_NO_TITLE);
        levelInformation.setContentView(R.layout.popupbox);

        final TextView levelInfo = levelInformation.findViewById(R.id.txt_Instruct);
        Button nextBtn = levelInformation.findViewById(R.id.Next);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (diaLogNumber < 6) {
                    diaLogNumber++;
                    disalogTree(levelInfo);
                }
                else {
                    finish();
                }



            }
        });
        Button previousBtn = levelInformation.findViewById(R.id.Previous);
        previousBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (diaLogNumber > 0){
                    diaLogNumber --;
                    disalogTree(levelInfo);
                }



            }
        });


        disalogTree(levelInfo);








        levelInformation.show();


    }

    public TextView disalogTree(TextView levelInfo){





        if(pageNumber == 1) {
            if (diaLogNumber == 0){
                levelInfo.setText("This activity will teach you how to create a working Rock Paper Scissors game playable between a human and an AI. ");
            }
            else if(diaLogNumber == 1){
                levelInfo.setText("Rock Paper Scissors is a game between two players in which the players compete to beat each other by making a move of either Rock, Paper or Scissors. ");
            }

            else if(diaLogNumber == 2){
                levelInfo.setText(" Rock beats Scissors, Scissors beats Paper and Paper beats Rock.");
            }
            else if(diaLogNumber == 3){
                levelInfo.setText("The first stage for this activity is getting the input from both the player and the computer. This will be used in later stages to begin comparing the move against each other");
            }
            else if(diaLogNumber == 4){
                levelInfo.setText("This will be done by making use of the variables, random and input blocks. ");
            }
            else if(diaLogNumber == 5){
                levelInfo.setText("Remember to fill out this activity as if it was text based, as the compiler will handle the graphics and graphical input. For example as a getting started hint you may choose to use blocks such as variable = input");
            }





        }
        else if(pageNumber == 2) {
            if (diaLogNumber == 0){
                levelInfo.setText("This activity will teach how to create a Noughts And Crosses game including both a human vs human mode and a human vs AI mode ");
            }
            else if(diaLogNumber == 1){
                levelInfo.setText("Nought And Crosses is a game played between two players in which each player will take turns placing a naught or cross on the board. Depending upon what the player is playing as");
            }
            else if(diaLogNumber == 2){
                levelInfo.setText("The objective of the game is simple, be the first player to make a line of their chosen block. This line can be vertical, horizontal or diagonal.");
            }
            else if(diaLogNumber == 3){
                levelInfo.setText("The first stage for this challenge will be to create the human vs human aspect of this game. This will require getting both players input, assigning the input to the board and checking for a winner.");
            }
            else if(diaLogNumber == 4){
                levelInfo.setText("To start with lets break this down to smaller steps. Your first challenge will be creating the board state. One way which this could be done is via the use of multi dimensional arrays.");
            }

            else if(diaLogNumber == 5){
                levelInfo.setText("Remember to fill out this activity as if it was text based, as the compiler will handle the graphics and graphical input. For example as a getting started hint you may choose to pair multiple int arrays together");
            }



        }
        else if(pageNumber == 3) {
            if (diaLogNumber == 0){
                levelInfo.setText("This activity introduces the idea of algorithms. In this case the algorithm is a basic form of a sorting algorithm known as the bubble sort.");
            }
            else if(diaLogNumber == 1){
                levelInfo.setText("The bubble sort is one of the most simple sorting algorithms that has been created and makes a perfect starting point for learning what a sorting algorithm does.");
            }
            else if(diaLogNumber == 2){
                levelInfo.setText("The way the bubble sort works is be iterating through a series of numbers. This iteration will go through each number and essentially if the next number is lower the two will swap. ");
            }
            else if(diaLogNumber == 3){
                levelInfo.setText("This will be done until the entire series of numbers has been iterated through and no numbers have been swapped. The time complexity for this sort is O(n^2).");
            }
            else if(diaLogNumber == 4){
                levelInfo.setText("Typically to perform this type of sort a loop within a loop will be utilize. With one loop iterating through the numbers themselves and the other looping through the amount of numbers.  ");
            }

            else if(diaLogNumber == 5){
                levelInfo.setText("For this challenge you will be responsible for creating this bubble sort. As a starting hint this will require the use of for loops and arrays. ");
            }

        }
        else if(pageNumber == 4) {
            if (diaLogNumber == 0){
                levelInfo.setText("This activity introduces another algorithms. In this case the algorithm is a basic form of searching known as a linear search.");
            }
            else if(diaLogNumber == 1){
                levelInfo.setText("The linear search makes a perfect starting for learning about different searching algorithims. Due to its simplicity");
            }
            else if(diaLogNumber == 2){
                levelInfo.setText("A linear search works by iteratting through a series of numbers or in some cases words one at a time until it finds the target.");
            }
            else if(diaLogNumber == 3){
                levelInfo.setText("This will be done until the entire series of numbers has been iterated through and the number either has been found or there are no numbers left to search.");
            }
            else if(diaLogNumber == 4){
                levelInfo.setText("The Big O notation for this algorithm is O(n) as it scales linearly depending on the amount of values it needs to search through");
            }

            else if(diaLogNumber == 5){
                levelInfo.setText("To perform this type of search it worth considering what type of loops you will utilize and how to exit out of the loop if a condition is met");
            }

        }

        return levelInfo;
    }






    }




