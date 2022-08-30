package com.example.myquran;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class urdutrans extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urdutrans);
        listView = findViewById(R.id.urdutrans);
        Intent intent = getIntent();
        int position = intent.getIntExtra("surat",0);
        DBHelper dbHelper = new DBHelper(urdutrans.this);
        ArrayList<String> urdu = dbHelper.getAyaat(position+1);
       // ArrayAdapter<String> a = new ArrayAdapter<>(urdutrans.this, android.R.layout.simple_list_item_1,urdu);
       ArrayAdapter<String> a=new ArrayAdapter<>(getApplicationContext(),R.layout.urdutext,urdu);
        listView.setAdapter(a);
    }
}