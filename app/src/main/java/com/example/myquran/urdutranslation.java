package com.example.myquran;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class urdutranslation extends AppCompatActivity {

    ListView l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urdutranslation);
        l =  findViewById(R.id.l);
        DBHelper dbHelper=new DBHelper(urdutranslation.this);
        ArrayList<String> a =  dbHelper.getAyaat();
        ArrayAdapter<String> aa =  new ArrayAdapter<>(urdutranslation.this, android.R.layout.simple_list_item_1,a);
        l.setAdapter(aa);
    }
}