package com.example.day5.Fragments;



import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.day5.POJO.Models;
import com.example.day5.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_B extends Fragment {

    private Models mModels = new Models();
    TextView name, timestamp;
    ImageView imageView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }


    public Fragment_B() {
        // Required empty public constructor
    }

    public void setModel(Models models){
    this.mModels =models;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView = view.findViewById(R.id.imageView_b);
        name = view.findViewById(R.id.textView_name_b);
        timestamp = view.findViewById(R.id.textView_time_b);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState!=null) {
            mModels = (Models) savedInstanceState.getSerializable("models");
        }

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("models",mModels);
    }


    @Override
    public void onStart() {
        super.onStart();
        if(mModels!=null) {
            imageView.setImageResource(mModels.getImage());
            name.setText(mModels.getName());
            timestamp.setText(mModels.getTimestamp());
        }
    }
}
