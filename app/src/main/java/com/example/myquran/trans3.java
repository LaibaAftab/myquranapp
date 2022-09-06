package com.example.myquran;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class trans3 extends Fragment {
    int surahID;
    View view;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    List<Modelclass> ayaatlist;
    Adapter adapter;

    public trans3(int s)
    {
        surahID = s;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_trans3, container, false);
        ayaatlist = new ArrayList<>();
        DBHelper db =  new DBHelper(view.getContext());
        ayaatlist= db.getAyaa(surahID,6);
        recyclerView= view.findViewById(R.id.recyclertrans3);
        linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new Adapter(ayaatlist);
        recyclerView.setAdapter(adapter);
        return view;
    }
}