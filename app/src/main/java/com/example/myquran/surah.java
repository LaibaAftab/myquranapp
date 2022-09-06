package com.example.myquran;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class surah extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    List<modelsurah> modelclassList;
    surahAdapter surahAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah);
        recyclerView = findViewById(R.id.recyclerView);
        modelclassList = new ArrayList<>();
        DBHelper db = new DBHelper(this);
        modelclassList = db.getsurah();
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(recyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        surahAdapter = new surahAdapter(modelclassList);
        recyclerView.setAdapter(surahAdapter);

    }
}