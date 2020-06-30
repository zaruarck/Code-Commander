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
 * Use the {@link level3Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class level3Fragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public level3Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment level3Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static level3Fragment newInstance(String param1, String param2) {
        level3Fragment fragment = new level3Fragment();
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

        View view = inflater.inflate(R.layout.fragment_level3,container,false);

        Button button = view.findViewById(R.id.btn_startActivityPlay);

        button.setOnClickListener(this);

        return view;

        // Inflate the layout for this fragment

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btn_startActivityPlay:
                //Activates the code when the button on the fragment is clicked
                Intent intent = new Intent(getActivity(), bubbleSort.class);
                Log.w("Test","Test");

                startActivity(intent);

        }
    }
}
