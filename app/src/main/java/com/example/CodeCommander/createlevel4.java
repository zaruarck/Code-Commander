package com.example.CodeCommander;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link createlevel3#newInstance} factory method to
 * create an instance of this fragment.
 */
//Default fragment code used when creating a new fragment
public class createlevel4 extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public createlevel4() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment createlevel3.
     */
    // TODO: Rename and change types and number of parameters
    public static createlevel4 newInstance(String param1, String param2) {
        createlevel4 fragment = new createlevel4();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_createlevel4,container,false);

        //Sets the button on the fragment for the user to click

        Button button = view.findViewById(R.id.btn_startActivityCreateLinear);

        button.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_startActivityCreateLinear:
                //Activates the code when the button on the fragment is clicked
                Log.w("Test","Test");
                Intent intent = new Intent(getActivity(), MainActivity.class);


                intent.putExtra("Page_Number", 4);
                startActivity(intent);


        }
    }
}
