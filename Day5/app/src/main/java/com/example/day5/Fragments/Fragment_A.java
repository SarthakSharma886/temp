package com.example.day5.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day5.Adapters.Custom_Adapter;
import com.example.day5.Interfaces.ICommunicator;
import com.example.day5.POJO.Models;
import com.example.day5.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_A extends Fragment {
    private RecyclerView recyclerView;
    private ICommunicator communicator;




    public void setCommunicator(ICommunicator communicator){
        this.communicator = communicator;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<Models> arrayList = new ArrayList<>();
        Models models = new Models();
        models.setName("Ice Cream Sundae");
        models.setTimestamp(new SimpleDateFormat("dd MMMM yyyy hh:mm:ss").format(new Date()));
        models.setImage(R.mipmap.recipe1);
        arrayList.add(models);
        arrayList.add(models);
        arrayList.add(models);
        arrayList.add(models);
        arrayList.add(models);
        arrayList.add(models);
        arrayList.add(models);
        arrayList.add(models);
        arrayList.add(models);
        Custom_Adapter custom_adapter = new Custom_Adapter(arrayList);
        custom_adapter.setCommunicator(communicator);
        recyclerView.setAdapter(custom_adapter);
    }

    public Fragment_A() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        recyclerView = view.findViewById(R.id.recyclerView_first);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        // Inflate the layout for this fragment
        return view;
    }

}
