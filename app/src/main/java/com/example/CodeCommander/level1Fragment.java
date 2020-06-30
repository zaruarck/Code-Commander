package com.example.CodeCommander;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link level1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class level1Fragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    DatabaseReference currentChallenge;


    public level1Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment level1Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static level1Fragment newInstance(String param1, String param2) {
        level1Fragment fragment = new level1Fragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_level1,container,false);

        Button button = view.findViewById(R.id.btn_startActivity1);

        button.setOnClickListener(this);





        //return inflater.inflate(R.layout.fragment_level1, container, false);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //Activates the code when the button on the fragment is clicked
            case R.id.btn_startActivity1:
                Intent intent = new Intent(getActivity(), rockPaperScissors.class);

                startActivity(intent);
        }

    }
}
