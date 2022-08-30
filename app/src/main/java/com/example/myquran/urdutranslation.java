package com.example.myquran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class urdutranslation extends AppCompatActivity {

    ListView l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urdutranslation);
        Intent i = getIntent();
        suratName urdusurat = new suratName();
        String[] urdusur = urdusurat.urduSurahNames;
        l =  findViewById(R.id.l);
//        DBHelper dbHelper=new DBHelper(urdutranslation.this);
//        ArrayList<String> a =  dbHelper.getAyaat();
        ArrayAdapter<String> aa =  new ArrayAdapter<>(urdutranslation.this,R.layout.urdutext,urdusur);
        l.setAdapter(aa);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(urdutranslation.this,urdutrans.class);
                intent.putExtra("surat",position);
                startActivity(intent);
            }
        });
    }
}